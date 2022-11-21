package kr.ac.sesac.exam02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex03_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		Hash Map 생성
		
//		HashMap<String, String> map = new HashMap<String, String> ();
//		
//		map.put("name", "이름이름");
//		map.put("address", "한국");
//		map.put("job", "개발자");
//		
//		System.out.println(map);
//		System.out.println(map.containsKey("name"));
//		System.out.println(map.containsValue("한국"));
//		System.out.println(map.get("name"));
//		
//		
//		map.put("name", "변경된이름");
//		System.out.println(map.get("name"));
		
		
//		실습 : 맵 생성 및 데이터 확인
//		(1) 키값은 문자열, 밸류값은 정수의 데이터를 가지는 score 맵변수 생성
//		(2) 키값에는 영어, 국어, 수학
//		(3) 밸류에는 임의의 점수를 삽입하고
//		(4) score 정보 확인 (출력)
//		(5) 과목들 점수 합계 출력
		
		HashMap<String, Integer> score = new HashMap<String, Integer>();
		
		score.put("영어", 98);
		score.put("국어", 95);
		score.put("수학", 100);
		
		System.out.println(score);
				
//		(1)번 방법 : 향상된 for 문
		
		int sumFor = 0; // 점수 합계
		for (int value : score.values()) {
			sumFor += value;
		}
		System.out.println("과목 점수의 합 :" + sumFor);
		
		
		
//		(2)번 방법
		
		int sumIter = 0;
		
		Set<String> keys = score.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			int value = score.get(key);
			sumIter += value;
		}
		System.out.println("과목 점수의 합 : " + sumIter);
		
		System.out.println(keys);
		System.out.println(iter);
		
		
		
		
	}

}
