package kr.ac.sesac.exam03;

public class HumanMain {

	public static void main(String[] args) {

//		hyuk이라는 Human 클래스의 객체 생성
		Human hyuk = new Human();
		hyuk.name = "박종혁";
		hyuk.age = 31;
		hyuk.job = "학생";
		hyuk.height = 173;
		hyuk.lover = true;
		
		System.out.println("이름 : " + hyuk.name);
		System.out.println("나이 : " + hyuk.age);
		System.out.println("직업 : " + hyuk.job);
		
		hyuk.eat(hyuk.name);
		hyuk.sleep(hyuk.name);
		hyuk.introduce(hyuk);
		
		System.out.println(hyuk.date(hyuk.lover));
		
		System.out.println(hyuk);
		
		
	}
}
