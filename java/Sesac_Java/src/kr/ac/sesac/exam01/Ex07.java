package kr.ac.sesac.exam01;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 1;
		while ( i <=10 ) {
			System.out.println(i);
			i++;
		}
		

//		"12345"의 각 자릿수를 더하기
		
		int num = 12345;
		int total = 0;
		
		while (num > 0) {
			int m = num % 10;
			total += m;
			num = num/10;
		}
		System.out.println("각 자리의 합 :" + total);
		
		
//		while문을 활용해서 구구단을 생성
		
		int a = 0;
		while (++a <= 9) {
			System.out.println("===구구단 " + a + "단 ===");
			int b = 0;
			while (++b <= 9) {
			System.out.println(a + "X" + b + "=" + (a*b));
			}
		}

//		do - while 문
//		while 문이 변형된 형태
//		do { 수행문 } while (조건식);
		
		int z = 0;
		do {
			System.out.println("최소 한 번은 실행된다.");
		}while (z > 10);
		
		
		
	}
}
