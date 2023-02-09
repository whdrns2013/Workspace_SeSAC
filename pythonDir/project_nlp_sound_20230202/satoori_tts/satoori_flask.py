##########################
##  global 변수 선언 부  ##
##########################

## dir path 설정 : flask.py가 위치한 폴더를 입력해주세요.
dir_path = '/Workspace/pythonDir/project_nlp_sound_20230202/satoori_tts/'
## wav파일이 저장될 경로를 지정해주세요.
wavfile_save_path = dir_path + 'static/'


## flask request 변수 미리 선언
text:str
region:str
file:object
## ckpt 파일 관련 변수 선언
region_class = ['전라도', '강원도', '충청도', '경상도', '제주도']
dir_path = dir_path
ckpt_path = dir_path + 'logs/models/'
model_class = ['jeon', 'kang', 'chung', 'gyeong', 'jeju']
## wav 파일 저장 관련 변수 선언
wavfile_save_path = wavfile_save_path
wavfile_name = 'temp.wav'
## 음성 설정
sample_rate_list = [18000, 22050, 20000, 20000, 22050]
amp_list = [1, 1, 1, 1, 1]



################################################################
################################################################
################################################################


from flask import Flask
from flask import request
from flask import render_template

app = Flask(__name__)


# TTS 모델 실행 메서드
def inference(text, model_path_ac, model_path_vo, sample_rate, amp):
    # 범용 라이브러리
    import torch
    import numpy as np
    import soundfile as sf
    # 본 코드폴더 내 라이브러리
    from model.model_inference_v2 import Tacotron2            # 타코트론 모델 
    from vocoder.model.waveglow import WaveGlow               # 웨이브글로우 모델
    from vocoder.denoiser_librosa import Denoiser             # 디노이저 : 노이즈 제거
    from korean_text.korean_cleaner_cls import KoreanCleaner  # korean cleaner : 사투리 - 표준어
    from text import text_to_sequence
    from utils.util import to_var

    global amp_list

    # device 설정
    device = 'cpu' # cuda

    # Tacotron2
    ckpt_dict = torch.load(model_path_ac, map_location=torch.device(device))
    model = Tacotron2()
    model.load_state_dict(ckpt_dict['model'])
    model = model.eval()

    # Vocoder
    ckpt_dict = torch.load(model_path_vo, map_location=torch.device(device))
    vocoder = WaveGlow()
    vocoder.load_state_dict(ckpt_dict['model'])
    vocoder = vocoder.remove_weightnorm(vocoder)
    vocoder.eval()
    denoiser = Denoiser(vocoder, 0.1)

    korean_cleaner = KoreanCleaner()
    
    text = korean_cleaner.clean_text(text)

    sequence = text_to_sequence(text, ['multi_cleaner'])
    sequence = to_var(torch.IntTensor(sequence)[None, :]).long()

    # 음성 관련 설정
    sigma = 0.5
    strength = 10
    # sample_rate = 22050

    with torch.no_grad():
        _, mel_outputs_postnet, linear_outputs, _, alignments = model.inference(sequence)
        wav = vocoder.infer(mel_outputs_postnet, sigma=sigma)

        wav *= 32767. / max(0.01, torch.max(torch.abs(wav)))
        wav = wav.squeeze()
        wav = wav.cpu().detach().numpy().astype('float32')

        wav = denoiser(wav, strength=strength)

    wav = np.append(wav, np.array([[0.0] * (sample_rate // 2)])) * amp
    wav_file = wav.astype(np.int16)

    global wavfile_save_path
    global wavfile_name
    sf.write(wavfile_save_path + wavfile_name, wav_file, sample_rate)

    # melspec Save

    return '/static/temp.wav', text, sequence, mel_outputs_postnet


# flask 인덱스 페이지 : 지역 선택, 텍스트 선택
@app.route('/')
def home_page():
    return render_template('index.html')



# flask result 페이지 : sound file 재생
@app.route('/result', methods=['GET', 'POST'])
def result():
    
    # 전역변수 호출 부
    global region_class # 지역 리스트
    global ckpt_path    # 체크포인트 파일 기본 경로
    global model_class  # 지역별 모델(체크포인트 파일) 리스트
    global sample_rate_list  # 지역별 샘플레이트
    global amp_list     # 음량
    global dir_path     # 기본 경로
    
    # 방언 지역 선택 및 ckpt 파일 선택 부
    region = request.args.get('region')      # 사용자가 web 통해 선택한 지역 정보 받아오기
    region_idx = region_class.index(region)  # 사용자가 지정한 지역 index 추출
    model_path_acoustic =  str(ckpt_path + model_class[region_idx] + '_acoustic.ckpt') # ckpt 파일(acoustic) path 지정
    model_path_vocoder = str(ckpt_path + model_class[region_idx] + '_vocoder.ckpt')    # ckpt 파일(vocoder) path 지정

    sample_rate = sample_rate_list[region_idx]
    amp = amp_list[region_idx]
    
    
    # TTS 요청받은 텍스트 수신 부
    text = request.args.get('text') + ' '  # text로 직접 입력인 경우 (마지막 글자 안 밀리도록 공백 추가)
    file = request.args.get('file')        # 파일로 업로드한 경우
    
    
    # TTS WAV 파일 생성(및 저장) 부
    #### WAV 파일 저장 경로 : wavfile_save_path 변수 참조
    result, cleaned_text, sequence, mel = inference(text, model_path_acoustic, model_path_vocoder, sample_rate, amp)
    
    # TTS 요청내용 요약해서 print
    print('입력받은 텍스트 : ' + text)
    print('korean_cleaner 텍스트 : ' + cleaned_text)
    print('지역 ckpt 파일 선택(1) : ' + model_path_acoustic)
    print('지역 ckpt 파일 선택(2) : ' + model_path_vocoder)
    import matplotlib.pyplot as plt
    import numpy as np
    # plt.imshow(np.power(10, np.squeeze(mel)), origin="lower", aspect="auto", cmap="inferno")
    # plt.colorbar()
    # plt.xlabel("Mel Bins")
    # plt.ylabel("Timesteps")
    # plt.title("Mel Spectrogram - Postnet Outputs")
    # plt.savefig(wavfile_save_path + 'mel.png')
    import soundfile
    import librosa
    import librosa.display
    sound_content, sr = soundfile.read(dir_path + result)
    plt.figure(figsize = (10, 10))
    D = abs(librosa.stft(sound_content)) # 데이터 : 절대값 바로 먹임
    mel_spec = librosa.feature.melspectrogram(S=D, n_mels=128) # 128단계 melspectrogram 구하기
    mel_db = librosa.amplitude_to_db(mel_spec, ref=np.max)
    librosa.display.specshow(mel_db, sr=sr, x_axis='time', y_axis='mel') # y_axis 바뀜
    plt.title('Mel-Spectrogram')
    plt.colorbar(format='%+2.0f dB')
    plt.tight_layout()
    plt.savefig(dir_path + '/static/mel.png')


    return render_template('result.html', audiofile = result, text = text, cleaned_text = cleaned_text, sequence = sequence,
    mel = '/static/mel.png')


# flask 파일 전송 부 : 미사용
from flask import send_file
@app.route('/wav/<filename>')
def wav(filename):
    return send_file(filename, mimetype='audio/wav')


# flask 서버 구동
app.run(host = 'localhost', port = 5002)