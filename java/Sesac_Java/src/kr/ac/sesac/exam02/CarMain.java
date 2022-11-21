package kr.ac.sesac.exam02;

import java.util.Random;

public class CarMain {

	public static void main(String[] args) {

//		Car 클래스를 객체로 생성
		Car car = new Car();
		System.out.println(car.color);
		System.out.println(car.tire);
		
//		매개변수가 있는 생성자를 활용한 객체 생성
		Car2 car2 = new Car2("노란색", 3);
		System.out.println(car2.color);
		System.out.println(car2.tire);
		
		
		
//		오버로딩 클래스 이용해보기
		
		Car3 car3_0 = new Car3();
		System.out.println(car3_0.color);
		System.out.println(car3_0.tire);
		
		Car3 car3_1 = new Car3("무지개색");
		System.out.println(car3_1.color);
		System.out.println(car3_1.tire);
		
		Car3 car3_2 = new Car3("진한 빨간색" , 4);
		System.out.println(car3_2.color);
		System.out.println(car3_2.tire);
		
		
		
		Random random = new Random() ;
		random.nextInt();
	}

}
