package kr.ac.sesac.exam02;

public class Ex01_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
//		int 타입의 score라는 배열을 생성하고
//		값은 90, 70, 77을 넣어봅시다.
		
//		int[] score = {90, 70, 77};
		
		
//		score 배열의 합계를 구하라
		
//		int sum = 0;
//		for (int i = 0 ; i < score.length ; i++) {
//			sum += score[i];    // sum = sum + score[i];
//		}System.out.println("score의 합 : " + sum);
		
		
//		향상된 for문
//		score 배열 내 원소를 출력하라
		
//		for (int p : score) {
//			System.out.println(p);
//		}
		
//		배열 복사하기
//		(1) for 문
		
		int [] origin = {1, 2, 3};
		int [] copy = new int [5];
		for ( int q  = 0 ; q < origin.length ; q++) {
			copy[q] = origin[q] ;
		}
		
		System.out.println(origin.length);
		
		
//		System.arraycopy(origin, 0, copy, 0, origin.length);

		
		
		
//		원소 테스트기 (n만 수정)
		int[] n = copy;
		for (int m = 0 ; m < n.length ; m++) {
			System.out.println(n[m]);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
