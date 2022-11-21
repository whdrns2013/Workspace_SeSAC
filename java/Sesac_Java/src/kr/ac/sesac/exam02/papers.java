package kr.ac.sesac.exam02;

import java.util.Scanner;

public class papers {

	public static void main(String[] args) {

		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		
		int a1 = 10;
		
		System.out.println(a1);  // -> 10
		System.out.println(a2);  // -> 0
		System.out.println(a3);  // -> 0
		
		int a1 = 0;
		int a2 = 0;
		
		a2 = a1++;               // 후위 증가연산
		System.out.println(a1);  // -> 11
		System.out.println(a2);  // -> 10
//		a2 = a1의 값을 먼저 참조한 후 a1에 증가연산(+1)을 진행
//		이때, a1=11 , a2=10

		
		int a1 = 0;
		int a2 = 0;
		
		a3 = --a1;               // 전위 감소연산
		System.out.println(a1);  // -> 9
		System.out.println(a2);  // -> 9
//		a3 = 감소연산을 한 a1의 값을 참조함
//		이때, a1=9 , a2=9
		
		
		
	}

}
