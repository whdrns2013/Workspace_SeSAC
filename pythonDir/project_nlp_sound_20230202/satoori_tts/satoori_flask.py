#########################
##      사용환경        ##
#########################

# 폴더에 [satoori.yaml] 파일로 env 만들어놨습니다. 고거 사용해주세요.
# 가상환경 생성 명령어(prompt) : $conda env create --file satoori.yaml

# 파이썬 3.8.15
# flask 2.2.2 ::: conda install flask            [satoori_flask.py]
# torch 1.12.1 ::: conda install pytorch
# soundfile 0.11.0 ::: pip install soundfile
# unidecode 1.2.0 ::: conda install unidecode    [cleaners.py]
# inflect 5.3.0 ::: conda install inflect        [numbers.py]
# jamo 0.4.1 ::: pip install jamo                [cleaners.py]
# tensorflow 2.10.0 ::: conda install tensorflow [audio.py]
# librosa 0.9.2 ::: pip install librosa          [audio.py]
# chardet 4.0.0 ::: conda install chardet        [audio.py]
# torchaudio 1.12.1 ::: pip install torchaudio   [audio.py]


#########################
##      사용방법        ##
#########################

## (1) 폴더 생성
## logs 폴더를 만들어주세요. logs 폴더 안에 models 폴더를 만들어주세요.
## static폴더와 templates 폴더를 만들어주세요. templates 폴더 안에는 index 페이지와 result 페이지가 위치합니다.

## (2) 체크포인트 파일 위치
## models 폴더 안에 지역별 체크포인트 파일 (acoustic, vocoder) 을 위치시켜주세요.
## 체크포인트 파일의 이름은 아래와 같습니다.
## 전라도 : jeon_acoustic.ckpt, jeon_vocoder.ckpt
## 경상도 : gyeong_acoustic.ckpt, gyeong_vocoder.ckpt
## 강원도 : kang_acoustic.ckpt, kang_vocoder.ckpt
## 제주도 : jeju_acoustic.ckpt, jeju_vocoder.ckpt
## 충청도 : chung_acoustic.ckpt, chung_vocoder.ckpt

## (3) dir path 설정
## 아래 dir_path를 현재 폴더의 path로 지정해주세요.
dir_path = '/Workspace/pythonDir/project_nlp_sound_20230202/satoori_tts/'
## wav파일이 저장될 경로를 지정해주세요.
wavfile_save_path = dir_path + 'static/'


##########################
##  global 변수 선언 부  ##
##########################

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


################################################################
################################################################
################################################################

from flask import Flask
from flask import request
from flask import render_template

app = Flask(__name__)


# TTS 모델 실행 메서드
def inference(text, model_path_ac, model_path_vo):
    # 범용 라이브러리
    import torch
    import numpy as np
    import soundfile as sf
    # 본 코드폴더 내 라이브러리
    from model.model_inference_v2 import Tacotron2
    from vocoder.model.waveglow import WaveGlow
    from vocoder.denoiser_librosa import Denoiser
    from korean_text.korean_cleaner_cls import KoreanCleaner
    from text import text_to_sequence
    from utils.util import to_var

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

    global wavfile_save_path
    global wavfile_name
    sf.write(wavfile_save_path + wavfile_name, wav_file, sample_rate)

    return '/static/temp.wav'

inference('안녕하소', str(ckpt_path + 'jeon_acoustic.ckpt'), str(ckpt_path + 'jeon_vocoder.ckpt'))

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
    
    # 방언 지역 선택 및 ckpt 파일 선택 부
    region = request.args.get('region')      # 사용자가 web 통해 선택한 지역 정보 받아오기
    region_idx = region_class.index(region)  # 사용자가 지정한 지역 index 추출
    model_path_acoustic =  str(ckpt_path + model_class[region_idx] + '_acoustic.ckpt') # ckpt 파일(acoustic) path 지정
    model_path_vocoder = str(ckpt_path + model_class[region_idx] + '_vocoder.ckpt')    # ckpt 파일(vocoder) path 지정
    
    # TTS 요청받은 텍스트 수신 부
    text = request.args.get('text')  # text로 직접 입력인 경우
    file = request.args.get('file')  # 파일로 업로드한 경우
    
    # TTS 요청내용 요약해서 print
    print('입력받은 텍스트 : ' + text)
    print('지역 ckpt 파일 선택(1) : ' + model_path_acoustic)
    print('지역 ckpt 파일 선택(2) : ' + model_path_vocoder)

    # TTS WAV 파일 생성(및 저장) 부
    #### WAV 파일 저장 경로 : wavfile_save_path 변수 참조
    result = inference(text, model_path_acoustic, model_path_vocoder)
    
    return render_template('result.html', audiofile=result)


# flask 파일 전송 부 : 미사용
from flask import send_file
@app.route('/wav/<filename>')
def wav(filename):
    return send_file(filename, mimetype='audio/wav')


# flask 서버 구동
app.run(host = 'localhost', port = 5002)