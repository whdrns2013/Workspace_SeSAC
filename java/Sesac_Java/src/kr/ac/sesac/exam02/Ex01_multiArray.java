package kr.ac.sesac.exam02;

public class Ex01_multiArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr1 = new int[][] {
			{10, 9, 8},
			{7, 6, 5},
			{4, 3, 2}
		};
		
		
//		for문을 활용해서 arr2의 전체 데이터 확인
		
		int[][]arr2 = {
				{10, 9, 8},
				{7, 6, 5},
				{4, 3, 2},
				{1, 0, -1}
		};
		
		for (int i = 0 ; i <= arr2.length ; i++) {
			for (int x = 0 ; x <arr2[i].length ; x++) {
				System.out.print(arr2[i][x] + " ");
			}
			System.out.println();
		}
		
		
		
		
	}

}
