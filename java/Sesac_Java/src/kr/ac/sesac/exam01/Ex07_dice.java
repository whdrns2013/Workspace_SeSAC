package kr.ac.sesac.exam01;

public class Ex07_dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		두 개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출력하고
//		눈의 합이 10이면 종료하면서 던진 횟수 출력하기
		
		boolean isContinue = true;
		int count = 0;
		while (isContinue) {
			int num1 = (int) (Math.random() * 6 + 1);
			int num2 = (int) (Math.random() * 6 + 1);
			System.out.println("(" + num1 + "," + num2 + ")");
			count += 1;
			if (num1 + num2 == 10) {
				break;
			}
		}
		System.out.println("주사위를 던진 횟수 : " + count);
		
		
//		Math.random() * 6 테스트
		int i = 0;
		while (i == 10) {
			System.out.println(Math.random() * 6 + 1);
			i++;
		}
		
		
		
		
	}

}
