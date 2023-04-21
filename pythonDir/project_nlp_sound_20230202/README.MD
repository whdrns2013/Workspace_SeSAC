# 사투리 TTS-STT 서비스, 자기 음성 TTS 서비스

**뭐라카노 팀 : 윤율, 심재훈, 박종혁, 손원준**  


![](./src/images/image_01.png)

<br>
<br>

## 1. 프로젝트 소개

<br>

### ⚙️ 주요 기능  

**사투리 TTS - STT**  
* 텍스트를 강원도, 경상도, 전라도, 제주도, 충청도 사투리 음성으로 변환해주는 기능  
* 음성으로 변환된 자료의 Sequence, Mel-Mpectogram 을 출력해주는 기능  

**자기 음성 TTS**  
* 텍스트를 학습된 음성(자신 혹은 특정 타인의 음성 가능)으로 변환해주는 기능  

<br>

### 📁 함께 보면 좋을 자료  

* 발표자료 : [발표자료.pdf](./presentation_with_script.pdf)  
* 프로젝트 계획서 : [프로젝트 계획서.pdf](./src/pm/plan.pdf)  

<br>
<br>

## 2. 데이터셋 다운로드

* 사투리(방언) 발화 음성 및 텍스트 데이터  
[한국어 방언 발화(강원도)](https://aihub.or.kr/aihubdata/data/view.do?currMenu=115&topMenu=100&aihubDataSe=realm&dataSetSn=118)  
[한국어 방언 발화(경상도)](https://aihub.or.kr/aihubdata/data/view.do?currMenu=115&topMenu=100&aihubDataSe=realm&dataSetSn=119)  
[한국어 방언 발화(전라도)](https://aihub.or.kr/aihubdata/data/view.do?currMenu=115&topMenu=100&aihubDataSe=realm&dataSetSn=120)  
[한국어 방언 발화(제주도)](https://aihub.or.kr/aihubdata/data/view.do?currMenu=115&topMenu=100&aihubDataSe=realm&dataSetSn=121)  
[한국어 방언 발화(충청도)](https://aihub.or.kr/aihubdata/data/view.do?currMenu=115&topMenu=100&aihubDataSe=realm&dataSetSn=122)


<br>
<br>

## 3. Train / Inference / 실행  

### 3-1. 사투리 tts  

자세한 사용법은 사투리 tts train README 파일을 참고해주세요.  

[사투리 tts train](./satoori_tts_train/)  
[사투리 tts 가상환경](./satoori_tts_train/satoori.yaml)  

### 3-2. 사투리 tts Flask Web  

[사투리 tts Flask Web](./satoori_tts_web/)  

###  3-3. 자기음성 tts  

자세한 사용법은 각 파일 주석을 참고해주세요  

[자기음성 tts](./custom_tts/)  
[(1)glow tts](./custom_tts/train-glowtts-v2.ipynb)  
[(2)hifigan](./custom_tts/train_hifigan_v2.ipynb)  
[(3)inference](./custom_tts/infer_v2.ipynb)  

<br>
<br>

## 4. 실행 결과  

### 4-1. TTS 로 변환된 음성 결과물  
[발표를 대신 진행한 재훈봇 음성자료](./src/result/)  

### 4-2. Flask로 구축된 웹페이지  

![](./src/images/image_09.png)  


<br>
<br>

## 5. 프로젝트를 마치며

### 5-1. 프로젝트의 의의  

**1. 음성 기술에 대한 공부**  

이번 음성 기술의 경우, 손원준 팀원이 이론적인 공부를 직접 담당하였고, 덕분에 다른 프로젝트들보다 근본적인 이해에서부터 프로젝트를 시작할 수 있었습니다.  

![](./src/images/image_04.png)  
![](./src/images/image_05.png)  
![](./src/images/image_06.png)  

<br>

**2.사투리tts, 자기음성tts 의의와 한계**  

![](./src/images/image_07.png)  
![](./src/images/image_08.png)  


### 🔨 기술 스택  
- Python 3.9.0  
- Flask 2.2.2  
- HTML5  

### 👥 팀 구성원

|팀원 1|팀원 2|팀원 3|팀원 4|
|:---:|:---:|:---:|:---:|
|<center><strong>박종혁</strong><br>* 플라스크 백엔드 구현<br>* 사투리 tts 플라스크 탑재</center>|<strong>윤율</strong><br>* 기획<br>* 프로젝트 매니징|<strong>심재훈</strong><br>* 사투리 tts 구현<br>* 자기 음성 tts 구현|<strong>손원준</strong><br>* 음성기술 원리 연구<br>* 데이터 관리|
|whdrns2013@naver.com<br>[블로그](https://whdrns2013.github.io/)<br>[깃허브](https://github.com/whdrns2013/)|||

<br>
<br>