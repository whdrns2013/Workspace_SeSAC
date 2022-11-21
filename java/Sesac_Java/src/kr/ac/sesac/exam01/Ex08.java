package kr.ac.sesac.exam01;

public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 2; i <=10; i++) {
			if(i %2 !=0) {
				continue;
				int t = 10; 
			}
			System.out.println(i);
		}
		
//		break 문
		
		for (int x = 1; x <= 9 ; x++) {
			for (int y = 2; y <= 9 ; y++) {
				if (x == y) {
					break;
				}
				System.out.print(x + "*" + y + "=" + (x * y));
			}
		}
		System.out.println();
		
		
		
		
		
//		continue를 사용해서 구구단 홀수단만 출력 (방법 1)
		
		for(int j = 2; j < 10 ; j++) {
			if (j%2!=1) {
				continue;
			}
			System.out.println("===구구단 " + j + "단===");
			for (int k = 1; k <10 ; k++) {
				System.out.println(j + "x" + k + "=" + (j*k));
			}
		}
		
		
//		방법2
		for(int n = 1; n <= 5 ; n++) {
			System.out.println("===구구단 " + (n*2 - 1) + "단===");
			for (int m = 1; m <10 ; m++) {
				System.out.println((n*2-1) + "x" + m + "=" + ((n*2-1)*m));
			}
		}
		
		
//		방법3
		for(int o = 1; o < 10 ; o+=2) {
			for(int p = 1 ; p < 10 ; p++) {
				System.out.println(o + "x" + p + "=" + (o*p));
			}
		}
		
		
//		방법4


		
		
		
		
	}

}
