package kr.ac.sesac.exam04;

public class Car {
	
	int door = 4;
	int tire = 2;
	
	public Car() {
		System.out.println("Car 객체 생성");
	}	
	public void move() {
		System.out.println("이동");
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public int getTire() {
		return tire;
	}
	public void setTire(int tire) {
		this.tire = tire;
	}
	
	
	
	
}
