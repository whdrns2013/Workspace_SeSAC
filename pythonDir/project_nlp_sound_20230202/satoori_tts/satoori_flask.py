from flask import Flask
from flask import request
from flask import render_template


app = Flask(__name__)


text:str
region:str
file:object

model_jr:object
model_gw:object
model_cc:object
model_gs:object
model_jj:object

region_class = ['전라도', '강원도', '충청도', '경상도', '제주도']
ckpt_path = 'logs/model/'
model_class = ['jeon', 'kang', 'chung', 'gyeong', 'jeju']

# def model_select(region):
#     model = model_class[region_class.index(region)]
#     return model


def inference(text, model_path_ac, model_path_vo):
    import torch
    import numpy as np
    import soundfile as sf

    from model.model_inference_v2 import Tacotron2
    from vocoder.model.waveglow import WaveGlow
    from vocoder.denoiser_librosa import Denoiser
    from korean_text.korean_cleaner_cls import KoreanCleaner

    from text import text_to_sequence
    from utils.util import to_var

    device = 'cpu' # cuda

    # Tacotron2
    ckpt_dict = torch.load('logs/model/acoustic.ckpt', map_location=torch.device(device))
    model = Tacotron2()
    model.load_state_dict(ckpt_dict['model'])
    model = model.eval()

    # Vocoder
    ckpt_dict = torch.load('logs/model/vocoder.ckpt', map_location=torch.device(device))
    vocoder = WaveGlow()
    vocoder.load_state_dict(ckpt_dict['model'])
    vocoder = vocoder.remove_weightnorm(vocoder)
    vocoder.eval()
    denoiser = Denoiser(vocoder, 0.1)

    korean_cleaner = KoreanCleaner()
    
    text = korean_cleaner.clean_text(text)

    sequence = text_to_sequence(text, ['multi_cleaner'])
    sequence = to_var(torch.IntTensor(sequence)[None, :]).long()

    sigma = 0.5
    strength = 10
    sample_rate = 22050

    with torch.no_grad():
        _, mel_outputs_postnet, linear_outputs, _, alignments = model.inference(sequence)
        wav = vocoder.infer(mel_outputs_postnet, sigma=sigma)

        wav *= 32767. / max(0.01, torch.max(torch.abs(wav)))
        wav = wav.squeeze()
        wav = wav.cpu().detach().numpy().astype('float32')

        wav = denoiser(wav, strength=strength)

    wav = np.append(wav, np.array([[0.0] * (sample_rate // 2)]))

    wav_file = wav.astype(np.int16)
    sf.write('temp.wav', wav_file, sample_rate)

    return 'temp.wav'

@app.route('/')
def home_page():
    return render_template('index.html')


@app.route('/result', methods=['GET'])
def result():
    
    global region_class
    global ckpt_path
    global model_class
    
    region = request.args.get('region')
    region_idx = region_class.index(region)
    model_path_acoustic =  str(ckpt_path + model_class[region_idx] + '_acoustic.ckpt')
    model_path_vocoder = str(ckpt_path + model_class[region_idx] + '_vocoder.ckpt')
    
    text = request.args.get('text')
    file = request.args.get('file')
    # result = model_select(region).predict(txt)
    # result -> wav 파일
    
    import test_test as test
    
    wav = inference(text, model_path_acoustic, model_path_vocoder)
    
    
    result = '/static/jj.wav'
    
    return render_template('result.html', audiofile=result)


app.run(host = 'localhost', port = 5002)