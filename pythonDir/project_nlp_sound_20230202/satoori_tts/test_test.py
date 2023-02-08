import torch
import numpy as np
import librosa
import librosa.display
import matplotlib.pyplot as plt

# from model.model_inference_v2 import Tacotron2
# from models.model_inference_v2 import Tacotron2
from model.model_inference_v2 import Tacotron2
from vocoder.model.waveglow import WaveGlow
from vocoder.denoiser_librosa import Denoiser
from korean_text.korean_cleaner_cls import KoreanCleaner

from text import text_to_sequence, sequence_to_text
from utils.util import mode, to_var, to_arr

from demo_proc import _convert_to_pcm16

device = 'cpu' # cuda
korean_cleaner = KoreanCleaner()     # 특수문자, 한글에 없는 문자 제거


######## 모델 선언 ########

def model_selection_Tacotron2(model_path):
    # Tacotron2
    ckpt_dict = torch.load(str(model_path + '_acoustic.ckpt'), map_location=torch.device(device))
    model = Tacotron2()
    model.load_state_dict(ckpt_dict['model'])
    model = model.eval()
    return model

# Vocoder
def model_selection_Vocoder(model_path):
    ckpt_dict = torch.load(str(model_path + '_vocoder.ckpt'), map_location=torch.device(device))
    vocoder = WaveGlow()
    vocoder.load_state_dict(ckpt_dict['model'])
    vocoder = vocoder.remove_weightnorm(vocoder)
    vocoder.eval()
    return vocoder

def denoiser_(vocoder):
    denoiser = Denoiser(vocoder, 0.1)    # 노이즈 제거
    return denoiser


######## 텍스트 클리너 ########

def cleaner(text):
    cleaned_text = korean_cleaner.clean_text(text)
    return cleaned_text


######## 텍스트 to sequence ########

def text_to_seq(cleaned_text):
    sequence = cleaner(cleaned_text, ['multi_cleaner'])
    sequence = to_var(torch.IntTensor(sequence)[None, :]).long()
    return sequence


######## 추론 ########

def to_wav(sequence):
    sigma = 0.5
    strength = 10
    sample_rate = 22050

    with torch.no_grad():
        _, mel_outputs_postnet, linear_outputs, _, alignments = model.inference(sequence)
        vocoder = model_selection_Vocoder
        wav = vocoder.infer(mel_outputs_postnet, sigma=sigma)

        wav *= 32767. / max(0.01, torch.max(torch.abs(wav)))
        wav = wav.squeeze()
        wav = wav.cpu().detach().numpy().astype('float32')

        wav = denoiser_(wav, strength=strength)

    wav = np.append(wav, np.array([[0.0] * (sample_rate // 2)]))
    audio_duration = librosa.get_duration(wav, sample_rate)
    
    return wav, sample_rate


######## 파일로 저장 ########

def wav_save(sequence):
    import IPython.display as ipd
    import soundfile as sf
    
    wav, sample_rate = to_wav(sequence)

    wav_file = wav.astype(np.int16)
    sf.write('/temp.wav', wav_file, sample_rate)