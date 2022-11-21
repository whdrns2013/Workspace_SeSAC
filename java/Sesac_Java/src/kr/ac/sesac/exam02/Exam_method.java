package kr.ac.sesac.exam02;

import java.util.Random;

public class Exam_method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println();
		
		int resultRandom = getRandomNumber (60, 100);
		System.out.println(resultRandom);
		
		
	}
	///////////// 이상 메인 메서드 부 ///////////////
	
//	아래 조건에 해당하는 dilemma 메소드 작성하기
//	전제) 범죄자 A와 B가 체포되어 서로 다른 취조실에서 격리되어 심문을 받고 있음
//	두 명의 자백 여부에 따라 석방 또는 복역기간이 정해짐
//	조건 1) 둘 중 하나가 배신하여 죄를 자백하면 자백한 사람은 즉시 석방되고 나머지는 10년을 복역
//	조건 2) 둘 모두 서로 배신하여 죄를 자백하면 둘 다 5년을 복역
//	조건 3) 둘 모두 죄를 자백하지 않으면 둘 다 1년을 복역
//	조건 4) 범죄자를 나타내는 변수 a, b는 자백하면 true, 그렇지 않으면 false를 가짐
	
	public static String dilemma(boolean a , boolean b) {
		String result = "";
		
		if (a == true & b == true) {
			result = "A, B 둘 다 5년을 복역";
		}else if (a == true & b == false ) {
			result = "A 석방, B는 10년을 복역";
		}else if (a == false & b == true ) {
			result = "B 석방, A는 10년을 복역";
		}else {
			result = "둘 다 1년을 복역";
		}
		
		return result ;
	}
	
	// 두 정수 사이의 난수 생성 메서드 만들기
	// 메서드명은 getRandomNumber 이고, int 형 매개변수를 두 개 가진다.
	// int형 매개변수는 각각 (1)난수 중 최소 숫자 (2)난수 중 최대 숫자 이다.
	// 난수는 라이브러리의 Random 클래스를 사용한다.
	// Random 클래스 선언 방법 : Random 변수명 = new Random();
	// Random 클래스의 기능 : 0 ~ 지정 끝 수 중 랜덤한 수를 뽑아준다.
	
	public static int getRandomNumber(int x , int y) {
		
		Random rnd = new Random();
		int resultNum = 0;
		
		while (true) {
			resultNum = rnd.nextInt(y);
			if ( resultNum >= x) {
				break;
			}else {
				continue;
			}
		}
		return resultNum ;
	} 
	
	
	
	
	

}
