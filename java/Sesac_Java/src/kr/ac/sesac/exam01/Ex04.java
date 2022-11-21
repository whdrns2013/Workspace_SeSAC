package kr.ac.sesac.exam01;

public class Ex04 {

	//파일 저장할때 : ctrl + s -> 현재 파일 저장
	// ctrl + shift + s -> 전체 파일을 저장
	public static void main(String[] args) {
		// 조건문 - if문
		// if(조건식){수행문}
		int a = 3;
		boolean t = false;
		// if문
//		if(a > 5) {
//			// if문 괄호안에 연산식 혹은 변수가 true일때 수행된다.
//			// a가 5보다 크다 (true일때) 수행
//			System.out.println("a는 5보다 큽니다.");
//		}
		
		//if , else문
//		if(a > 5) {
//			// if문 괄호안에 연산식 혹은 변수가 true일때 수행된다.
//			// a가 5보다 크다 (true일때) 수행
//			System.out.println("a는 5보다 큽니다.");
//		}else {
//			// if문 괄호안에 연산식 혹은 변수가 false일때 수행된다.
//			System.out.println("a는 5보다 작습니다.");
//		}
		
		//if, else, else if 문
//		if(a > 5) {
//			// if문 괄호안에 연산식 혹은 변수가 true일때 수행된다.
//			// a가 5보다 크다 (true일때) 수행
//			System.out.println("a는 5보다 큽니다.");
//		}else if(a > 2) {
//			// if문 괄호에 연산식(변수)가 false일때 그리고,
//			// else if문 괄호에 연산식(변수)가 true일때 수행된다.
//			System.out.println("a는 5보다 작고, 2보다 큽니다.");
//		}else {
//			// if문,else if문 괄호안에 연산식 혹은 변수가 false일때 수행된다.
//			System.out.println("a는 2보다 작습니다.");
//		}
		
		//else if문 여러개 사용가능
//		a = 1;
//		if(a > 5) { //조건식1
//			// if문 괄호안에 연산식 혹은 변수가 true일때 수행된다.
//			// a가 5보다 크다 (true일때) 수행
//			System.out.println("a는 5보다 큽니다.");
//		}else if(a > 2) { //조건식2
//			// if문 괄호에 연산식(변수)가 false일때 그리고,
//			// else if문 괄호에 연산식(변수)가 true일때 수행된다.
//			System.out.println("a는 5보다 작고, 2보다 큽니다.");
//		}else if(a > 0){ //조건식3
//			// 조건식1 과 조선식2 모두 false이고, 
//			// 조건식3이 true일때 수행된다.
//			System.out.println("a는 2보다 작고 , 0보다 큽니다.");
//		}else {
//			// if문,else if문 괄호안에 연산식 혹은 변수가 false일때 수행된다.
//			System.out.println("a는 0보다 작습니다.");
//		}
		
		//중첩 if문 - if문 안에 if문이 중첩된 형태
		a = 21;
		if(a > 10) {
			// a가 10보다 클때 수행
			System.out.println("a는 10보다 클때 수행");
			if(a > 20) {
				System.out.println("a는 20보다 클때 수행");
			}else {
				System.out.println("a는 10보다 크지만, 20보다 작다.");
			}
		}else {
			// a가 10보다 크지않을때 수행
		}
		System.out.println("수행완료");
	}

}
