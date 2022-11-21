package kr.ac.sesac.exam01;

import java.util.Scanner;

public class Ex03 {
// 주석(해제) 단축키 : ctrl + /
	public static void main(String[] args) {
		// 연산자
		// 단항 연산자
		int a = 10;

		a = -a; // 양수를 음수로 변경
//		System.out.println(a);

		boolean b = true;
		b = !b; // b값의 논리 부정
//		System.out.println(b);

		int c = 10;
		int c2 = ++c; // 증가를 시키고 참조 -> 결과 : 11
		int c3 = c++; // 참조를 한 후에 증가 -> 결과 : 11
		System.out.println("전위 연산" + c2);
		System.out.println(c);
		System.out.println("후위 연산" + c3);
		System.out.println(c);

		// 이항연산자
		int i = 1;
		int i2 = 2;
		int i3 = i + i2;
//		System.out.println(i3);

		// %연산자 : 나머지 값을 구하는 연산자
		int i4 = 30 / 3;
		int i5 = 30 % 4; // 몫이 7이고 , 나머지는 2
//		System.out.println(i4);
//		System.out.println(i5);

// 대입연산자 +=
		int z1 = 0;
		z1 = z1 + 1;
		z1 += 1; // z1 = z1 + 1 와 같은 뜻

		// 비교 : 참 혹은 거짓으로 결과값을 얻을수 있다.
		int y1 = 3;
		int y2 = 3;
//		boolean result = y1 > y2; // 3 > 3 고로 결과값은 false
//		System.out.println(result);
//		result = y1 == y2; // y1과 y2가 같으면 true, 같지 않다면 false
//		System.out.println(result);

		// 삼항연산자
		// (조건식) ? true일때 : false일때
		int x1 = 3;
		boolean x2 = x1 == 3 ? true : false;
		String x3 = x1 > 0 ? "0보다 크다" : "0보다 작다";
		System.out.println(x2);
		System.out.println(x3);
// arlt + 화살표 위아래 : 해당라인을 한줄씩 이동
// ctrl + d : 한줄식 제거
// ctrl + shift + f : 소스코드 정리
		//들여쓰기 앞으로 : shift + tab
		if (x1 > 1) {
			// x1 > 1 일때 (참일때)
			System.out.println("1보다 크다");
		} else {
			// x1 > 1 이 아닐때 (거짓일때)
			System.out.println("1보다 작다");
		}
		
		//논리합 , 논리곱
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = b1 || b2;
		System.out.println("논리연산자 결과값은 : "+b3);
		if(0>1 && 2>1) {
			// 조건식이 true일때
			// 0이 1보다 크다(false) 또는(or), 2가 1보다 클때(true)
			System.out.println("결과는 true");
		}else {
			// 조건식이 false일때
			// 0이 1보다 크다(false) 그리고(and),  2가 1보다 클때(true)
			System.out.println("결과는 false");
		}
		
		
		// 수학, 영어, 국어 성적의 합과 평균을 구해보고, 콘솔에 출력 해봅시다.
		// 변수명 수학 = math, 영어 = eng , 국어 = kor
		// 성적은 임의로 지정
		int math = 50;
		int eng = 90;
		int kor = 87;
		//성적 합계 
		int sum = math + eng + kor;
		// 성적 평균
		float avg = (float)sum / 3;
		// 합계 구하는 소스
		// 평균 구하는 소스
		System.out.println("성적 합계 : "+sum+" 성적 평균 : "+avg);
		
		
//		int score = 0;
//		//단어입력한상태 + ctrl + space = 자동완성
//		System.out.print("성적 입력 : ");
//		// ctrl + shift + o : 임포트
//		Scanner scan = new Scanner(System.in);
//		score = scan.nextInt();
//		
//		System.out.println("성적은 : "+score);
//		//입력받은 성적이 90점 이상이면 'A'를 출력, 그렇지 않다면 'B'를 출력하시오.
//		//삼항 연산자를 활용해서!
//		// 삼항연산자 응용
//		// 80점이상이면 'B' , 그렇지 않으면 'C'를 출력하도록 수정해봅시다.
//		char grade = score >= 90 ? 'A' : (score >= 80 ? 'B' : 'C');
//		System.out.println("성적 등급은 : "+grade);
		
		// %연산자 활용 + 삼항연산자
		// 정수타입 변수num이 홀수 인지 짝수인지 구분 하여 출력 하시오.
		int num = 10;
		// num을 2로 나누었을때 나머지가 0이면 짝수 그렇지 않다면 홀수 이다.
		System.out.println( num % 2 == 0 ? "짝수" : "홀수");
		
		

		
		
	}


}
