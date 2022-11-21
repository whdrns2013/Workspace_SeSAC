package kr.ac.sesac.exam01;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		반복문 - for문
//		1에서 10까지 출력
		
		for(int i = 1 ; i <= 10 ; i++) {
			System.out.println("1부터 10까지 출력 : " + i);
		};
		
		
//		1에서 10까지의 정수를 더하기
		
		int sum = 0;	
		for(int j = 1 ; j <= 10 ; j++) {
			sum += j;		
		}
		System.out.println("1부터 10까지의 합은 : " + sum);
		
		
//		1에서 10까지의 정수 중 짝수를 더하기
		
		int sumDouble = 0;	
		for(int k = 1 ; k <= 10 ; k++) {
			if (k % 2 == 0) {
				sumDouble += k;		
		}
		}
		System.out.println("1부터 10까지 중 짝수의 합은 : " + sumDouble);
		

//		이중 for 문 : 구구단 만들기
//		바깥 for 문 초기값 시작한 뒤 -> 안쪽 for 문이 진행된다.
//		바깥 초기 + 안쪽 전체 - 바깥 두번째 값 + 안쪽 전체 - .... - 바깥 마지막 값 + 안쪽 전체
//		삼중 for 문도 사용은 가능(빅데이터, 인공지능) 웹프로그래밍에서는 잘 사용하지는 않음
		for (int n = 2 ; n <=9 ; n++) {
			for (int m = 1 ; m <= 9 ; m ++) {
				System.out.println(n + "X" + m + "=" + (n*m));
			}
		}
		for (int x = 2 ; x <= 9 ; x++) {
			System.out.println("=====구구단 " + x + "단=====");
			for (int y = 1 ; y <=9 ; y++) {
				System.out.println(x + "X" + y + "=" + (x * y));
			}		
		}
		
		
		
		for (byte a = 0 ; a <= 20 ; a++) {
			System.out.print(a + " ");
			if ( a % 5 == 0 ) {
				System.out.println();
			}
		}
}
}
