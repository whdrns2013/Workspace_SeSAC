class shop_info:

    def __init__(self, shop_name, commision_rate=None,
                logis_policy=None, logis_price=None, cat=None,):
        '''변수 설명
        shop_name = 쇼핑몰 명
        commision_rate = 수수료율
        logis_policy = 배송정책 (무료배송/유료배송)
        logis_price = 판매자 부담 배송비 (1회 운송당)
        cat = 카테고리
        '''
        self.shop_name = shop_name
        self.commision_rate = commision_rate
        self.logis_policy = logis_policy
        self.logis_price = logis_price
        self.cat = cat
    
    def margin_calculate(self, sale_price, pur_price, logis_earn):

        '''
        sale_price : 판매가
        pur_price : 매입가
        logis_earn : 구매자로부터 받는 배송비 결제액
        '''

        margin = sale_price - pur_price - (self.commision_rate * sale_price / 100) - + logis_earn + (self.logis_price * (1 if self.logis_policy == "무료배송" else 0))
        margin_per_sale = margin / sale_price
        margin_per_pur = margin / pur_price
        return margin, margin_per_sale, margin_per_pur



class user_info:

    def __init__(self, user_id, user_name=None, business_type=None):

        '''
        user_id : 유저 id
        user_name : 유저명
        business_type : 사업자 구분 (법인, 개인, 영세...)
        '''

        self.user_id = user_id
        self.user_name = user_name
        self.business_type = business_type



class Utils:

    def save_shop_info(shop_info):
        import pandas as pd
        shop_name = shop_info.shop_name
        ls_col_name = ['쇼핑몰명', '수수료율', '배송정책', '배송비', '카테고리']
        ls_value = [shop_info.shop_name, shop_info.commision_rate, shop_info.logis_policy,
                    shop_info.logis_price, shop_info.cat]
        df = pd.DataFrame(data=[ls_col_name, ls_value]).T
        df.columns = ['항목', '값']
        df['쇼핑몰명'] = shop_name
        df = df[['쇼핑몰명', '항목', '값']]
        df.to_csv('./shop_info.csv')
        print(df) #### 
        print('샵 정보가 저장되었습니다.')
    
    def save_user_info(user_info):
        import pandas as pd
        user_name = user_info.user_name
        user_id = user_info.user_id
        business_type = user_info.business_type
        ls_col_name = ['유저명', 'ID', '사업자구분']
        ls_value = [user_name, user_id, business_type]
        df = pd.DataFrame(data = [ls_col_name, ls_value]).T
        df.columns = ['항목', '값']
        df.to_csv('./user_info.csv')
        print(df) ####
        print('유저 정보가 저장되었습니다.')

    