package kr.ac.sesac.exam03.copy;

public class carMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SportsCar spCar = new SportsCar();
		Car car = null;
		car = (Car) spCar; // 업캐스팅: 괄호로 표시 하지 않아도 괜찮지만, 관례적(가독성 위해) 괄호를 명시함
		// 업캐스팅 : 자식 클래스가 수퍼 클래스(부모 클래스)로 형변환
		
		SportsCar spCar2 = (SportsCar) car;
		// 다운캐스팅 : 수퍼 클래스가 자식 클래스로 형변환

		
		
		
		
	}

}
