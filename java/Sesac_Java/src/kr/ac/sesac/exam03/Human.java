package kr.ac.sesac.exam03;

public class Human {

	//속성(필드) 생성
	String name = "";
	int age = 0;
	String job = "";
	int height = 0;
	boolean lover = true ;
	
	//동작(메서드) 생성
	void eat(String a) {
		System.out.println(a + "이/가 밥을 먹는다.");
	}
	
	void sleep(String b) {
		System.out.println(b + "이/가 잠을 잔다.");
	}
	
	void introduce(Human c) {
		System.out.println("안녕하세요. 제 이름은 " + c.name + ", 나이는 " + c.age + "세 입니다." + 
							" 현재 직업은 " + c.job + ", 키는 " + c.height + "cm 입니다.");
	}
	
	String date (boolean lover) {
		if (lover == true) {
			return "데이트를 한다.";
		}else
			return "데이트를 못한다.";
	}
	
	
}
