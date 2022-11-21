package com.human.youth;

public class Truck extends Car{
	public Truck(String color, int tire, String name) {
		super(color,tire, name);		
	}
	
	public void cargo() {
		System.out.println("적재물을 쏟아 붙습니다");
	}

}
