package kr.ac.sesac.exam02;

public class Car3 {

	String color;
	int tire;
	
//	기본 생성자 ( 매개변수 없음 )
	Car3 () {
		color = "노란색";
		tire = 2;
	}
	
//	매개변수 1개인 생성자 생성
	Car3 (String c) {
		color = c;
		tire = 100;
	}
	
//	매개변수 2개인 생성자 생성
	Car3 (String c, int t) {
		color = c;
		tire = t;
	}
	
}
