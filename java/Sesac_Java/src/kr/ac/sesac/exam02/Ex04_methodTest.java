package kr.ac.sesac.exam02;

import java.util.Scanner;

public class Ex04_methodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		gugudan1();
//		gugudan2(3, 5);
		
		

		Scanner scan = new Scanner(System.in);
		System.out.print("시작 단을 입력해주세요 : ");
		int x = scan.nextInt();
		System.out.print("끝 단을 입력해주세요 : ");
		int y = scan.nextInt();

		String result = gugudan3(x,y);
		System.out.println(result);
		
		
		String str1 = strAdd("안녕하세요.", " 반갑습니다.");
		String str2 = strAdd("안녕하세요.", "반갑습니다.", "건강하세요.");
		
		System.out.println(str1);
		System.out.println(str2);
		
		
//		메서드 오버로딩 (같은 이름의 메서드 생성해보기)

		
		
		
		
		
}

////	매개변수가 없는 구구단 만들기
////	1. 메소드명 : gugudan
////	2. 매개변수 : X
////	3. 반환값 : X
//	
//	static void gugudan1() {
//		for (int i = 2; i <= 9; i++) {
//			for (int j = 1; j <= 9; j++) {
//			System.out.println(i + " * " + j + " = " + (i * j));
//			}
//		}
//	}
//	
//
////	매개변수가 있는 구구단 만들기
////	1. 메소드명 : gugudan1
////	2. 매개변수 : 시작 단, 마지막 단
////	3. 반환값 : 없음
//	
	static void gugudan2(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.println("===구구단" + i + "단===");
			for (int j = 1; j <= 9; j++) {
			System.out.println(
			i + " * " + j + " = " + (i * j));
			}
		}
	}
//	
//	static String star(int num, char ch) {
//		String statement = "";
//		for (int i = 0 ; i <= num ; i++) {
//			statement += ch;
//		statement += "\n";
//		}
//		return statement;
//	}
//	
//	
//	구구단 메서드3 생성
//	반환값 : 구구단 결과 문자열
//	매개변수 : 첫 번째 매겨변수 = 시작할 단, 두 번째 매개변수 = 끝낼 단
//	ex) 매개변수 (4,7)을 넘겨줄 때, 결과는 4~7단의 문자열
//	메인메서드에서는 변수에 값을 저장하여 출력
	
//	static String gugudan3(int start2, int end2) {
//		String gugudanStack = "" ;
//		for (int x = start2 ; x <= end2 ; x++) {
//			for (int y = 1 ; y <= 9 ; y++) {
//				gugudanStack += (x + "*" + y + "=" + (x*y));
//				gugudanStack += "\n";
//			}
//		}
//		return gugudanStack;
//	}
	
	static String gugudan3(int start2, int end2) {
		String gugudanStack = "" ;
		for (int x = start2 ; x <= end2 ; x++) {
			gugudanStack += "===구구단" + x + "단===" + "\n";
			for (int y = 1 ; y <= 9 ; y++) {
				gugudanStack += (x + "*" + y + "=" + (x*y) + "\n");
			}}
		return gugudanStack;
	}
	
	
	
	
	static String strAdd(String a, String b) {
		return a + b ;
	}

	static String strAdd(String a, String b, String c) {
		return a + b + c;
	}
	
	
	
	
	
	}