package kr.ac.sesac.exam01;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
//		System.out.print("값을 입력해주세요:");
//		Scanner scan = new Scanner(System.in);
//		int a = scan.nextInt();
//		if(a > 5) {
//			System.out.println("a는 5보다 큽니다.");
//		}else if(a > 2){
//			System.out.println("a는 5보다 작고 2보다 큽니다.");
//		}else if(a >1){
//			System.out.println("a는 2보다 작고 1보다 큽니다.");
//		}else {
//			System.out.println("a는 1보다 작습니다.");
//		}
//		System.out.println("수행완료");
		
		
		
		
		// 중첩 if문 - if문 안에 if문이 중첩된 형태
		int b = 31;
		if (b > 10) {
			System.out.println("b가 10보다 클 때 수행");
			if (b > 20) {
				System.out.println("b가 20보다 클 때 수행");
			} else {
				System.out.println("b는 10보다 크지만, 20보다 작다.");
			}
		}else {
			System.out.println("b가 10보다 크지 않을 때 수행");
		}
		
		System.out.println ("수행 완료");
		
		
	}

}
