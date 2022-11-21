package kr.ac.sesac.exam01;

import java.util.Scanner;

public class Ex04_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Scanner를 활용해서 점수를 입력 받고 if문을 활용해
		// 90점 이상이면 A
		// 80점 이상이면 B
		// 70점 이상이면 C
		// 70점 미만이면 D

//		int score = 0;
//		Scanner scan = new Scanner(System.in);
//		System.out.print("점수를 입력해주세요 : ");
//		score = scan.nextInt();
//		System.out.println("입력한 점수는 " + score + "점 입니다.");
//		String grade = "";
//		
//		
//		if (score >= 90) {
//			grade = "A";
//		}else if (score >= 80) {
//			grade = "B";
//		}else if (score >= 70) {
//			grade = "C";
//		}else {
//			grade = "D";
//		}
//		
//		
//		System.out.println("성적은 " + grade + "입니다.");
		
		
		
		// 이걸 개인적으로 삼항 연산자로 표현해봄
//		String grade2 = score >= 90 ? "A" :
//			            score >= 80 ? "B" :
//			            score >= 70 ? "C" :
//			                          "D" ;
//		System.out.println("성적은 " + grade2 + "입니다.");
		
		// 이거 삼항연산자로 쓰면 더 간편한데 왜 if 문을 쓰나요? 라고 질문함
		// 이에 대해 (1) if문은 더 많은 내용을 나타낼 때, 삼항연산자보다 더 명료하게 보이며
		// (2) 중첩 if 문과 같은 기능이 필요할 때 활용할 수 있기 때문이라고 답함
		// 단, 실무에서도 위와 같은 간단한 경우의 수 나누기는 삼항연산자를 많이 사용한다고 함.
		
		
		
		
		
		
		// 중첩 if문 응용
		// 95점 이상이면 A+
		// 85점 이상이면 B+
		// 75점 이상이면 C+
		// 65점 이상이면 D+
		
		int score = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");
		score = scan.nextInt();
		System.out.println("입력한 점수는 " + score + "점 입니다.");
		String grade = "";
		
		
		if (score >= 90) {
			if (score >= 95) {
				grade = "A+";
			}else {
				grade = "A";
			}
		}else if (score >= 80) {
			if (score >= 85) {
				grade = "B+";
			}else {
			grade = "B";
			}
		}else if (score >= 70) {
			if (score >= 75) {
				grade = "C+";
			}else {
			grade = "C";
			}
		}else {
			if (score >=65 ) {
				grade = "D+";
			}else {
			grade = "D";
		}
		}
		
		System.out.println("성적은 " + grade + "입니다.");
		
	}

}
