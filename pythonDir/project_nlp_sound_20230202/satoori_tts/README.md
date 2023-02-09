# 한국어 방언 (사투리) 음성 합성

한국 5개 지역의 사투리로 말하는 인공지능. Tacotron2 기반.

#########################
##      사용환경        ##
#########################

# [satoori.yaml] 파일로 env 만들어놨습니다. 이용해서 가상환경을 만들어주세요.
# 가상환경 생성 명령어(prompt) : $conda env create --file satoori.yaml
# 본 프로젝트는 satoori 가상환경 하에서 작동이 가능합니다.

# 파이썬 3.8.15
# flask 2.2.2 ::: conda install flask            [satoori_flask.py]
# torch 1.12.1 ::: conda install pytorch         [satoori_flask.py]
# soundfile 0.11.0 ::: pip install soundfile     [satoori_flask.py]
# unidecode 1.2.0 ::: conda install unidecode    [cleaners.py]
# inflect 5.3.0 ::: conda install inflect        [numbers.py]
# jamo 0.4.1 ::: pip install jamo                [cleaners.py]
# tensorflow 2.10.0 ::: conda install tensorflow [audio.py]
# librosa 0.9.2 ::: pip install librosa          [audio.py]
# chardet 4.0.0 ::: conda install chardet        [audio.py]
# torchaudio 1.12.1 ::: pip install torchaudio   [audio.py]


#########################
##    사용 전 준비      ##
#########################

## (1) 폴더 생성
## logs 폴더를 만들어주세요. logs 폴더 안에 models 폴더를 만들어주세요.
## static폴더와 templates 폴더를 만들어주세요. templates 폴더 안에는 index 페이지와 result 페이지가 위치합니다.

## (2) 체크포인트 파일 위치
## 위에서 만든 models 폴더 안에 지역별 체크포인트 파일 (acoustic, vocoder) 을 위치시켜주세요.
## 다운로드 : https://drive.google.com/drive/folders/1qWilcW4f3CF4cwKvU1Sx4pyz-VJgrMfC
## 체크포인트 파일의 이름은 아래와 같습니다.
## 전라도 : jeon_acoustic.ckpt, jeon_vocoder.ckpt
## 경상도 : gyeong_acoustic.ckpt, gyeong_vocoder.ckpt
## 강원도 : kang_acoustic.ckpt, kang_vocoder.ckpt
## 제주도 : jeju_acoustic.ckpt, jeju_vocoder.ckpt
## 충청도 : chung_acoustic.ckpt, chung_vocoder.ckpt
## ! 파일들을 '꺼내서' 위치시켜주세요 !


#########################
##      사용 방법       ##
#########################

## satoori_flask.py 파일을 실행시켜주세요.
## 브라우저를 통해 서비스 페이지로 접속해주세요. 기본 주소는 [localhost:5002] 입니다.
## 방언 지역을 선택한 후, 음성으로 변환할 텍스트를 입력해주세요.
## 변환 작업에는 시간이 소요됩니다. 텍스트 길이에 비례해 시간이 소요되니 참고해주세요.
## 변환이 완료되면 result 페이지로 넘어가면서 음성을 재생할 수 있습니다.