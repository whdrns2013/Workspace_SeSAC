package kr.ac.sesac.exam04;

public class CarMain {

	public static void main(String[] args) {
		//Car 클래스를 상속받는 SportsCar클래스를 객체로 생성
		
		SportsCar sCar = new SportsCar();
		
		
		Car c = null;
		c = (Car)sCar;   
		c.move();  
		// 업캐스팅 ~ c 개체에 sCar 내용을 덮어씌운 다음 Car클래스로 형변환을 했다.
		// 그래서 SportsCar 클래스만이 가진 Booster... 등의 메서드가 사용 불가하다.
		
		
		SportsCar d = (SportsCar) c;
		d.move();
		d.openSunroof();
		// 다운캐스팅 : 스포츠카 클래스의 d 변수에 Car 클래스의 c 변수를 덮어씌운 다음
		// SportsCar 클래스로 선언한다 (=> 자식클래스로 선언 = 다운캐스팅)
		// 그래서 자식 클래스인 SportsCar 클래스가 가진 모든 기능을 이용할 수 있게 된다.
		
		
		
		
		sCar.move();
		sCar.setTire(4);
		System.out.println(sCar.tire);
		sCar.booster();
		
		
		
		
		
		
		
		
	}

}
