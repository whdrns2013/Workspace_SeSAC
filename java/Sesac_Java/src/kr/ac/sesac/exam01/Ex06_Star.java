package kr.ac.sesac.exam01;

public class Ex06_Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for문 - 별모양 프린트해보기
		for (int i = 0 ; i <5 ; i++) {
			for (int j = 0 ; j <= i ; j++) {
				System.out.print("*");
		}
			System.out.println("");
		}
		
		
		
//		for문 - 별모양 프린트해보기 2
		for (int n = 0 ; n <= 5 ; n++) {
			for (int m = 5 ; m >= 0 ; m--) {
				if (m >= n) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		
	}

}
