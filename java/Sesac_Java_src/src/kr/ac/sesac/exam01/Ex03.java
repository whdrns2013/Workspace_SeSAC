package kr.ac.sesac.exam01;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		양수를 음수로 변환
		int a = 10;
		a = -a;
		System.out.println(a);
		
//		true를 연산을 통해 false로 변환
		boolean b = true;
		b = !b;
		System.out.println(b);

		
//		증감연산자
		int c = 10;
		int c2 = ++c;   //증가를 시키고 참조
		int c3 = c++;   //참조를 한 뒤에 증가
		System.out.println(c2 + c);
		System.out.println(c3 + c);
		
//		이항 연산자
		int i = 1;
		int i2 = 2;
		int i3 = i + i2;
		System.out.println(i3);
		
//		%연산자
		int i4 = 30 / 4;    //나누기 몫
		int i5 = 30 % 4;    //나눈 후 나머지
		System.out.println(i4);
		System.out.println(i5);
		
//		대입 연산자 : 짧게 쓰기
		int z1 = 0;
		z1 = z1 + 1;
		z1 += 1;   // 대입 연산자 짧게 쓰기 : z1 = z1 + 1과 같은 뜻

//		비교 연산자
		int y1 = 3;
		int y2 = 3;
		boolean result = y1 > y2;
		System.out.println(result);
		result = y1 == y2;
		System.out.println(result);
		
//		삼항 연산자
//		(조건식) ? true일 때 / false일 때
		int x1 = 3;
		boolean x2 = x1 == 3 ? true : false;
		System.out.println(x2);
		
		String x3 = x1 > 2 ? "2보다 크다" : "2보다 크지 않다" ;
		System.out.println(x3);
		
		
//		논리 연산자
		boolean logi1 = true;
		boolean logi2 = false;
		
		boolean logiResultAnd = logi1 && logi2;
		boolean logiResultSum = logi1 || logi2;
		
		System.out.println("논리곱 연산의 결과는 : " + logiResultAnd);
		System.out.println("논리합 연산의 결과는 : " + logiResultSum);
		
//		논리 연산 : 일반 연산을 실례로
		
		int b1 = 2;
		int b2 = 0;
				
		boolean b3 = b1 < b2;
		System.out.println(b3);
		
		
//		if 문을 활용한 논리 연산
		if(0>1 && 2>0) {
			System.out.println("결과값은 True 입니다.");
		}
		else {
			System.out.println("결과값은 False 입니다.");
		}
		
//		수학, 영어, 국어 성저의 합과 평균을 구해보고, 콘솔에 출력 해봅시다.
//		변수명 수학 = math 영어 = eng 국어 = kor
//		성적은 임의로 지정
		
		int math = 97;
		int eng = 85;
		int kor = 96;
		
		int sum = math + eng + kor;
		float avg = (float)sum / (float)3;

		System.out.println("성적 합계: " + sum + "  성적 평균: " + avg);		
		
		
		
//		계산식에 float을 어디에 적용하는가에 따른 결과값 차이
//		-> float을 한쪽에만 붙여도 됨 : 이는 자동 캐스팅(프로모션)이 되기 때문으로 생각됨
		float avg2 = sum / 3;
		float avg3 = (float)sum / 3;
		float avg4 = sum / (float) 3;
		
		System.out.println(avg2);
		System.out.println(avg3);
		System.out.println(avg4);
		
		
//		int score = 0;
//		System.out.println("성적 입력 : ");
//		Scanner scan = new Scanner(System.in);
//		score = scan.nextInt();
//		System.out.println("성적은 : " + score);

		
//		입력받은 성적이 90점 이상이면 'A'를 출력, 그렇지 않다면 'B'를 출력하시오.
//		삼항 연산자를 활용해서
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성적을 입력해주세요 : ");
		int score2 = scan.nextInt();
		char grade = score2 >= 90 ? 'A' : 'B';
		System.out.println(grade);
		
		
//		입력받은 성적이 90점 이상이면 'A'를 출력, 80점 이상이면 'B', 그렇지 않으면 'C' 출력하시오.		
		
		char grade2 = score2 >= 90 ? 'A' : 
			          score2 >= 80 ? 'B' : 'C';
		System.out.println(grade2);
	
		

//		%연산자 활용 + 삼항 연산자
//		정수타입 변수 num이 홀수인지 짝수인지 구분하여 출력하시오.
		
		int num = 10;
		int namu = num % 2;
		char js = namu ==0 ? '짝' : '홀';
		System.out.println(js);
		
//		아래와 같이 써도 동일한 결과값
		System.out.println(num%2 == 0 ? "짝" : "홀");
		
		
//		홀짝 구분 프로그램 (입력값 받기)
		System.out.print("홀짝 구분 수를 입력해주세요 : ");
		int num2 = scan.nextInt();
		char js2 = num2 % 2 == 0 ? '짝' : '홀';
		System.out.println(js2);
		
		
	}	
	}