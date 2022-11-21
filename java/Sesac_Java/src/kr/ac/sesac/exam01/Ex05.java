package kr.ac.sesac.exam01;

public class Ex05 {

	public static void main(String[] args) {
		// 조건문 - switch문
		int a = 5;
//		switch(a) { //조건괄호에 변수가 들어온다.
//			case 1 : //case 키워드 다음에 비교할 값을 명시해준다.
//				System.out.println("a는 1입니다.");
//				break;// break가 없으면 다음 case도 실행 된다. *주의*
//			case 5 :
//				System.out.println("a는 5입니다.");
//				break;
//			case '5' :
//				System.out.println("a는 '5'입니다.");
//				break;
//			default :
//				System.out.println("a에 해당하는 case가 없습니다.");
//		}
		
		switch(a) { //조건괄호에 변수가 들어온다.
			case 1 : //case 키워드 다음에 비교할 값을 명시해준다.
				System.out.println("[1]a는 1입니다.");
				break;
			case 5 :
				System.out.println("[2]a는 5입니다.");
				break;
			case '5' :
				System.out.println("[3]a는 '5'입니다.");
				break;
			default :
				System.out.println("[4]a에 해당하는 case가 없습니다.");
		}
		
		String str = "abc";
		switch (str) {
			case "abc" : 
				System.out.println("abc입니다.");
				break;
			case "cde" :
				System.out.println("cde 입니다.");
				break;
			default:
				System.out.println("해당하는 케이스가 없습니다.");
		}

	}

}
