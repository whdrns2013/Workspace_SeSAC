package com.human.youth;

public class Car {	
	String color;
	int tire;
	String name;
	
	public Car(String color, int tire, String name) {
		this.color=color;
		this.tire=tire;
		this.name=name;
	}	
	
	public void front() {
		System.out.println(name +"직진입니다");
	}
	
	public void rear() {
		System.out.println(name+"후진입니다");
	}
}
