package kr.ac.sesac.exam01;

public class Ex02 {

	public static void main(String[] args) {
		// 타입
		// 기본자료형
		// 논리(참 또는 거짓), 문자(한글자), 정수(1,2,3...), 실수(1.1, 1.2, 1.3 ...)
		boolean isTrue = true;
		isTrue = false;
		
		char ch = 'A'; //글자 하나만 표현 가능, 작은따옴표로 표현
		
		byte bt = 10;
		short shrt = 100;
		int i = 1000;
		long lng = 10000;
		
		float flt = 1.1f;
		double dble = 123.123;
		
		// 참조자료형
		// 기본형을 제외한 나머지 타입
		String str = "문자열 표현 가능"; //참조형의 대표적인 예시 String(문자열)타입
		
		//각각 변수의 값에 맞는 타입을 붙여봅시다.
		boolean a = false;
		char b = 'a';
		int c = 20;
		long d = 100L;
		float e = 1.2f;
		double f = 1.3;
		// ctrl + alt 화살표 아래 : 밑으로 한줄씩 복사
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(str.getClass().getName()); //참조자료형에서 타입 확인
		
		//형변환 
		// 값의 타입을 다른 타입으로 변환
		// 기본자료형 : boolean을 제외한 나머지 7개 타입은 서로 형변환 가능
		// 참조자료형 : 같은 타입(상속) 인 경우 형변환 가능 -> 업 캐스팅, 다운 캐스팅
		
		byte small = 10;
		int big;
		big = small; //자동 형변환
		
		byte small2;
		short big2 = 1000;
		small2 = (byte) big2; // 강제 형변환
		
		System.out.println(big);
		System.out.println(small2);

		
	}

}
