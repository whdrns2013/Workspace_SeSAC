from main_code import shop_info
from main_code import user_info
from main_code import Utils

# shop_info 클래스 인스턴스 선언
coupang = shop_info('쿠팡')

# 하위 변수 선언
coupang.commision_rate = 15
coupang.logis_policy = "무료배송"
coupang.logis_price = 3500

# 마진 계산
margin, margin_per_sale, margin_per_pur = coupang.margin_calculate(15000, 5000)

# 출력 확인
print('마진액 : ', margin)
print('마진율/판매가 : ', margin_per_sale)
print('마진율/매입가 : ', margin_per_pur)

##########################################################################################
##########################################################################################

# user_info 클래스 인스턴스 선언
user = user_info('user_001')

# 하위 변수 선언
user.user_name = '박종혁'
user.business_type = '법인사업자'

# 출력 확인
print('user id : ', user.user_id)
print('user name : ', user.user_name)
print('business_type : ', user.business_type)

##########################################################################################
##########################################################################################


# 파일 저장 테스트
Utils.save_shop_info(coupang)
Utils.save_user_info(user)

# 파일 불러오기
import pandas as pd
df = pd.read_csv('./shop_info.csv')
print('■■■ shop_info 불러오기 ■■■\n', df)
df = pd.read_csv('./user_info.csv')
print('■■■ user_info 불러오기 ■■■\n', df)