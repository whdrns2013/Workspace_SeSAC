package kr.ac.sesac.exam04;

public class HumanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Human 클래스를 상속받는 Me 클래스를 객체로 생성
		
		Me jonghyuk = new Me();
		
		jonghyuk.setRoutineMorning();
		jonghyuk.setRoutineDay();
		jonghyuk.setRoutineNight();
		
		System.out.println(jonghyuk.getMorning());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
	}

}
