package kr.ac.sesac.exam02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Exam_Collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		ArrayList에 저장된 요소 중 2의 배수인 요소 삭제하기
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2); numbers.add(3); numbers.add(3); 
		numbers.add(2); numbers.add(2); numbers.add(4);
		numbers.add(1); numbers.add(8); numbers.add(7);
		
		
		
		System.out.println("삭제 전 데이터 : " + numbers);
		for( int i = 0 ; i < numbers.size() ; i++ ) {
			if( numbers.get(i) % 2 == 0 ) {
				numbers.remove(i);
		}
		}
		System.out.println("삭제 후 데이터 : " + numbers);

		
		
		
		// 특정 숫자를 포함하고 나머지 번호를 랜덤하게 생성해서
		// 로또번호 6개를 완성한 후 출력하기

		TreeSet<Integer> lotto = new TreeSet<Integer>();
		lotto.add(2);
		lotto.add(7);
		lotto.add(11);
		
		System.out.println(lotto.size());
		
		while ( lotto.size() < 6 ) {
			int num = (int)(Math.random() * 45 + 1);
			lotto.add(num); // TreeSet 객체에 랜덤숫자 저장
		}
		
		Iterator<Integer> iter = lotto.iterator();
		while ( iter.hasNext() == true ) {
			System.out.print( iter.next() + " " );
		}
		
		
		// size() 가 사용 가능한 대상
//		
//		lotto.size();      // TreeSet
//		numbers.size();    // ArrayList
//		
//		
////		lotto.get(1);
//		numbers.get(1);
		
		
		
		
		//hasNext(), netx()
		
		iter.hasNext();    // iterator
		iter.next();       // iterator
		
		
	}

}
