package kr.ac.sesac.exam02;

import java.util.ArrayList;

public class Ex02_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ArrayList<String> arrayList = new ArrayList<String>();
//		
//		
//		arrayList.add("1");
//		arrayList.add("1");
//		arrayList.add("2");
//		arrayList.add("2");
//		arrayList.add("3");
//		
//		System.out.println(arrayList.get(0));
//		
//		for (int i = 0; i < arrayList.size() ; i++) {
//			System.out.println(arrayList.get(i));
//		}
		
		
		
//		어레이리스트 생성 및 값 추가, 데이터 확인 실습
//		(1) 정수형을 취급하는 intArrayList 변수 선언
//		(2) 해당 어레이리스트에 숫자 3개 이상 삽입
//		(3) for 문 사용해서 포함된 데이터 확인
//		(4) 항목들의 전체 합을 출력
		
		ArrayList<int> intArrayList = new ArrayList<int>();
		
		intArrayList.add(1);
		intArrayList.add(2);
		intArrayList.add(3);
		intArrayList.add((int)Math.random() * 100);
		intArrayList.add((int)Math.random() * 100);
		
		int sum = 0;
		for (int j = 0 ; j < intArrayList.size() ; j++) {
			System.out.println(intArrayList.get(j));
			sum += intArrayList.get(j);
		}
		
		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		
		
	}

}
