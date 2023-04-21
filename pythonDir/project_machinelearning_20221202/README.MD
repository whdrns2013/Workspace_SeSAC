# 통신 데이터를 활용한 머신러닝 구현 (연령대 및 생활패턴 분석 및 예측)  

**팀원 : 이선영(팀장), 신숙주, 심재훈, 박종혁, 박기현**  

![](./src/images/image_01.png)

<br>
<br>

## 1. 프로젝트 소개

우리가 살아가는 현재는 통신의 시대입니다. 인터넷과 스마트폰의 발전으로, 전화나 문자와 같은 전통적인 통신 이외에도, 배달 앱, 인터넷 쇼핑, 이러한 서비스를 이용하기 위한 위치정보 통신 등  우리의 삶의 많은 부분이 통신과 연결이 되어있습니다.  

이러한 변화와 함께, 현대 한국 사회에서는 1인 가구의 수가 급격히 늘고 있습니다. 이러한 1인 가구들은 사회에서 큰 소비 잡단으로 주목받고 있습니다.  

본 프로젝트에서는 머신러닝을 통해 1인가구의 연령대별, 거주지역별 통신 데이터와 생활 패턴 사이의 연관성을 찾아보고, 예측해보는 것을 목표로 하였습니다.  

![](./src/images/image_02.png)


### 📁 함께 보면 좋을 자료  

* 발표자료 : [발표자료.pdf](./presentation.pdf)  
* 프로젝트 계획서 : [프로젝트 계획서.pdf](./src/pm/plan.pdf)  

<br>
<br>

## 2. 데이터 

본 프로젝트는 서울시와 SK 텔레콤이 함께 만든, 통신데이터 기반 1인가구의 생활특성 정보입니다.  

![](./src/images/image_03.png)

* 생활특성 정보 : 쇼핑서비스 이용 횟수, 출근 소요시간, 평균 근무시간, 평균 커뮤니케이션 빈도, 평일 외출 횟수 등  
* 2022년 1월 ~ 9월까지의 데이터  
* 거주지와 연령대별로 범주화되어있음  
* 총 칼럼 수 143개  
* 데이터 수는 91,584개  



### 2-1. 데이터셋 다운로드  

* 서울 시민생활 데이터  
[https://data.seoul.go.kr/dataVisual/seoul/seoulLiving.do](https://data.seoul.go.kr/dataVisual/seoul/seoulLiving.do)  


### 2-2. 데이터 전처리  

**이상치 제거**  

각 칼럼마다 이상치를 IQR 방식으로 제거를 했습니다.  
원 데이터 91,584개 -> 이상치 제거 후 61,488개  

![](./src/images/image_04.png)  

<br>
<br>

## 3. 분석 및 예측  

본 프로젝트에서는 총 3가지 다른 분석/예측을 진행했습니다.  

![](./src/images/image_05.png)

각각의 분석/예측은 목표에 맞춰 다른 머신러닝 모델을 사용했고, 데이터에 대한 추가 전처리를 하는 경우도 있었습니다. 이에 대해서는 아래에서 각각 소개해드리겠습니다.  

<br>

### 3-1. 통신데이터를 통한 연령대 예측  

연령대 예측은 다양한 분야에서 중요한 역할을 합니다. 특히, 기업이나 정부 기관에서는 연령대에 따라 다른 소비 패턴, 생활 습관 등을 파악하여 이를 기반으로 전략을 수립합니다.

이를 위해 통신 데이터를 활용하는 것이 효과적입니다. 통신 데이터는 우리의 일상 생활에서 발생하는 모든 통화, 문자, 데이터 사용량 등을 기록하고 있고, 이를 통해 연령대 예측의 정확도가 높아질 수 있기 때문입니다.

본 섹션에서는 통신 데이터를 통해 연령대를 예측해보고, 이 결과물이 우리에게 무엇을 시사해줄 수 있는지를 탐색해보았습니다.  

**사용 모델**  
![](./src/images/image_06.png)

**변수 선정**
![](./src/images/image_07.png)
![](./src/images/image_08.png)

**추가 전처리 : Encoding, Scaling**
![](./src/images/image_11.png)

**튜닝**
![](./src/images/image_09.png)

**결과**
![](./src/images/image_10.png)  
![](./src/images/image_12.png)  
![](./src/images/image_13.png)

<br>

### 3-2. 평균 문자 대상자 수 예측  

**사용 모델 : Light GBN**  
![](./src/images/image_14.png)

**변수 선정**  
변수간 상관관계 분석을 통해 주요 변수를 추출했습니다.  
* 평균 근무시간  
* 평균 통화대상자 수  
* 평일 총 이동 횟수  
* 평일 총 이동 거리 합계  
* 휴일 총 이동 거리 합계  
* 금융 서비스 사용일수  
* 쇼핑 서비스 사용일수  
![](./src/images/image_15.png)  
![](./src/images/image_16.png)  


<br>

### 3-3. 연령대별 주요 이용 서비스 예측  




<br>
<br>

## 4. 객체 탐지(detect) 코드 실행  

객체 탐지 코드를 실행시켜주세요.  
* 객체 탐지 코드 : `./yolov7/detect_or_trackmbasic_1_3_7.py`  

```terminal
-- 주간 detect 코드
python detect_or_trackmbasic_1_3_7.py --weights coco2wild4_day_31epoch_best.pt --no-trace --view-img --track --show-track --unique-track-color --danger-range 0.5 --conf-thres 0.7 --detecting-time 10 --thickness 3 --source 0 --class 1 2 3

-- 야간 detect 코드
python detect_or_trackmbasic_1_3_7.py --weights coco2wild4_night_12epoch_best.pt --no-trace --view-img --track --show-track --unique-track-color --danger-range 0.5 --conf-thres 0.7 --detecting-time 10 --thickness 3 --source 0 --class 0 1 2

```

```python
--weights : 객체 탐지에 이용할 weight 파일(가중치 파일)을 지정한다.
--source : 객체 탐지할 소스에 대한 유형을 지정. 0은 웹캠.
--save-txt : 로그정보를 기록할지에 대한 옵션. 선언시 True
--saving-img : 이미지를 저장할지에 대한 옵션. 선언시 True
--detecting-time : 객체 미탐지시 얼마의 시간 동안 이벤트 종료를 유예할 건지 설정. 단위는 초(sec)
--remove-old-track : 사라진 객체의 tracking 선을 제거합니다.
--danger-range 0.x : 객체가 화면의 x% 범위 내로 접근하면 알람이 울리도록 범위 설정 [0.0-1.0]
--conf-thres 0.y : 객체 인식 신뢰도 [0.0-1.0]
--view-img : 탐지 현황 영상을 보여준다.
--track : 객체 경로 추적을 활성화 한다.
--show-track : 객체 경로를 탐지 현황 영상에 표시한다.
--unique-track-color : 객체 경로를 서로 다른 색으로 지정한다.
```

<br>
<br>

**참고 사항**  
* AWS 연결 정보를 담고 있는 환경변수 파일(.env)는 보안상 업로드하지 않았습니다.  
* 관련 사항은 상황에 맞게 사용하는 서버로 대체되어야 합니다.  

<br>
<br>

## 5. 프로젝트 관련 기타 사항  

### 🔨 기술 스택  
- Python 3.9.0  
- Java (JDK 17)  
- Spring Boot 3.0.4  
- HTML5  
- MySQL 8.0.27  
- Maven 4.0.0  

### 👥 팀 구성원

|![](./src/team-01.png)|![](./src/team-02.png)|![](./src/team-03.png)|![](./src/team-04.png)|
|:---:|:---:|:---:|:---:|
|<center><strong>박종혁(팀장)</strong><br>* 백엔드 개발<br>* 모델-서버 연결</center>|<strong>윤율</strong><br>* 프론트엔드 개발<br>* 기획|<strong>심재훈</strong><br>* 백엔드 개발<br>* 경로추적 구현|<strong>손원준</strong><br>* 백엔드 개발<br>* 모델 학습|
|whdrns2013@naver.com<br>[블로그](https://whdrns2013.github.io/)<br>[깃허브](https://github.com/whdrns2013/)|weconomy90@gmail.com <br> [블로그](https://velog.io/@human_power22)|doctorsim1@naver.com<br>[블로그](https://blog.naver.com/doctorsim1)| swj6446@gmail.com  <br>[블로그](https://velog.io/@swj6446)|

<br>
<br>
