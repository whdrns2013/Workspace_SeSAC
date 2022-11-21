package kr.ac.sesac.exam04;

import java.util.Scanner;

public class Me extends Human {

//	휴먼 클래스를 상속받는 나 자신 클래스 만들기
	
//	필드
	
	String Hobby = "";
	String Driving = "";
	
	
	
//	루틴
	String routineMorning = "";
	String routineDay = "";
	String routineNight = "";
	
	public String getRoutineMorning() {
		return routineMorning;
	}
	public void setRoutineMorning(String routineMorning) {
		this.routineMorning = routineMorning;
	}
	public String getRoutineDay() {
		return routineDay;
	}
	public void setRoutineDay(String routineDay) {
		this.routineDay = routineDay;
	}
	public String getRoutineNight() {
		return routineNight;
	}
	public void setRoutineNight(String routineNight) {
		this.routineNight = routineNight;
	}
	
//	루틴을 실행하는 메서드
	
	public void setRoutines (String time) {
		
		if (time == "오전") {
			this.routineMorning = routineMorning;
		}else if (time == "오후") {
			this.routineDay = routineDay;
		}else if (time == "저녁") {
			this.routineNight = routineNight;
		}
		
		
	}
	
	
	
	
	public void printRoutines () {
		
		System.out.println(routineMorning);
		System.out.println(routineDay);
		System.out.println(routineNight);
		System.out.println();
	}
	
	
	
}
