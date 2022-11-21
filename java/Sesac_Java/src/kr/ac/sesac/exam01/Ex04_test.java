package kr.ac.sesac.exam01;

import java.util.Scanner;

public class Ex04_test {

	public static void main(String[] args) {
		// 스캐너를 활용해서 점수를 입력 받고 if문을 활용해서,
		// 90점 이상 이면 A
		// 80점 이상 이면 B
		// 70점 이상 이면 C
		// 70점 미만 이면 D
		// ex) 성적은 A 입니다.
//		int score = 0;
//		Scanner scan = new Scanner(System.in);
//		System.out.print("점수를 입력 하세요 : ");
//		score = scan.nextInt();
//		System.out.println(score);
//		String grade = "";
//		if(score >= 90) {
//			grade = "성적은 A 입니다.";
//		}else if(score >= 80) {
//			grade = "성적은 B 입니다.";
//		}else if(score >= 70) {
//			grade = "성적은 C 입니다.";
//		}else {
//			grade = "성적은 D 입니다.";
//		}
//		System.out.println(grade);
		
		// 중첩if문 응용
		// 95점 이상이면 A+
		// 85점 이상이면 B+
		// 75점 이상이면 C+
		// 65점 이상이면 D+
		int score = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력 하세요 : ");
		score = scan.nextInt();
		String grade = "";
		if(score >= 90) {
			if(score >= 95) {
				grade = "성적은 A+ 입니다.";
			}else {
				grade = "성적은 A 입니다.";
			}
		}else if(score >= 80) {
			if(score >= 85) {
				grade = "성적은 B+ 입니다.";
			}else {
				grade = "성적은 B 입니다.";
			}
		}else if(score >= 70) {
			if(score >= 75) {
				grade = "성적은 C+ 입니다.";
			}else {
				grade = "성적은 C 입니다.";
			}
		}else {
			if(score >= 65) {
				grade = "성적은 D+ 입니다.";
			}else {
				grade = "성적은 D 입니다.";
			}
		}
		System.out.println(grade);

	}

}
