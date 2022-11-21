package com.human.youth;

public class CarMain {

	public static void main(String[] args) {
		Taxi taxi = new Taxi("Red",4,"택시");
		taxi.front();
		taxi.rear();
		System.out.println(taxi.color);
		System.out.println(taxi.tire);
		
		Truck truck = new Truck("Red",12,"트럭");
		truck.front();
		truck.rear();
		System.out.println(truck.color);
		System.out.println(truck.tire);
		
//		Bus bus = new Bus();
//		bus.front();
//		bus.rear();
//		System.out.println(bus.color);
//		System.out.println(bus.tire);
	}

}
