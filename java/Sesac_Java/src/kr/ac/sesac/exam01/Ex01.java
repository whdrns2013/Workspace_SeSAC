// 본 패키지는 강사님이 작성한 패키지입니다.

package kr.ac.sesac.exam01;

public class Ex01 {

	public static void main(String[] args) {
		// 변수
		// 값을 저장할수 있는 메모리상의 공간
		// 타입명 변수명 = 할당할 값;
		int age = 10; // 변수 생성 + 값 할당 
		int age2; //변수 만 생성
//		System.out.println(age2); -> 변수를 초기화 하지않고 사용하면 에러 발생
		
		//변수 생성 규칙
		// 첫번째 글자는 문자(소문자) 혹은 _ 혹은 $ 로 시작
		// tire, age, sportsCar, _str, $num
		// 대소문자 구분이 필수
		// firstname , firstName
		// 합성어일경우 (단어 + 단어) 두번째 단어의 첫글자를 대문자로 작성
		// myName , sportsCar , firstName
		// 예약어는 사용 불가
		
		//변수에 값 할당
		age2 = 20; //미리 선언되어 있는 변수를 사용할때는 타입명 생략
		
		System.out.println(age2);
		
		//변수선언 + 변수사용
		//타입이 정수인 변수 today에 오늘날짜(yyyymmdd)를 입력하고, 콘솔창에 출력해봅시다.
		int today = 20221011;
		System.out.println(today);
		System.out.println("오늘 날짜는 ? "+today);
		
		//변수 선언 + 사용 2
		int num = 1;
		int num2 = 2;
		// num의 값에 num2를 입력
		// 기존의 num의 값인 1은 사라짐
		num = num2;
		System.out.println("num : "+num);
	}

}
