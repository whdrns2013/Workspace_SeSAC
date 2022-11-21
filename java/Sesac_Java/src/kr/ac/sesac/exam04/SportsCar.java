package kr.ac.sesac.exam04;

//	Car 클래스를 상속받는 SportsCar 클래스 생성
//	클래스명 뒤에 'extends 클래스이름'을 작성해 상속
public class SportsCar extends Car{

	public ScportsCar() {
		System.out.println("SportsCar 클래스를 생성합니다.");
	}
	
	int coupeDoor = 2;
	String brand = "porshe";
	
	void booster() {
		System.out.println("부스터 사용");
	}
	
	void openSunroof() {
		System.out.println("선루프 오픈");
	}
	
}
