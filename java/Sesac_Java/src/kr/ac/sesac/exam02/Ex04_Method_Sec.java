package kr.ac.sesac.exam02;

public class Ex04_Method_Sec {

	public static void main(String[] args) {

		printStar(5, 'a');
		
		
//	static int add4 (int a, int b) {
//		return a + b;
//	}
	
//	int result2 = add4 (100, 200);
//	System.out.println(result2);
		
	
	}
	
	public static void printStar(int count, char ch) {
		for (int i = 1; i <= count; i++) {
			for (int j = 1; j <= i; j++) {
					System.out.print(ch);
			}
			System.out.println();
		}
		}
		
		
	}

