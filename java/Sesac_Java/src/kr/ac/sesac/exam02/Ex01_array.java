package kr.ac.sesac.exam02;

public class Ex01_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array1 = new int[3];  // 길이가 3인 배열 생성
		
		array1[0] = 1;
		array1[1] = 2;
		array1[2] = 3;
		
		System.out.println(array1[0]);
		

//		int[] array2 = {4,5,6,7,8,9};
//		for (int i = 0 ; i <= array2.length ; i++) {
//			System.out.println("array2의 데이터 확인 : " + array2[i]);
//		}
		
//		방법1
		int[] array3 = {10, 20, 30};
		for ( int j = 0 ; j <= array3.length ; j++) {
			array3[j] += 1;
			System.out.println("array3[" + j + "] 수정 : " + array3[j]);
		}
		
		
//		방법2
		int[] array4 = {10, 20, 30};
		for (int k = 0 ; k <=array4.length ; k++) {
			System.out.println("array4[" + k + "] 수정 : " +  (array4[k] += 1));
		}
		
//		방법3
		int[] array5 = {10, 20, 30};
		int m = 1
		while (int m == (int)((array5.length) + 1)) {
			array5[m++] += 1;
		}
		
		
		
		
	}

}
