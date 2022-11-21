package kr.ac.sesac.exam07;

public class ErrorExam02_Try {
	
	public void main (String[] args) {

//		try - catch - finally
		
		
		// 문제 코드 (1)
		String numStr = " 123";
		int num = Integer.parseInt(numStr);

		// try - catch - finally 예외처리
		String numStr2 = " 123";
		try {
		int num2 = Integer.parseInt(numStr);
		System.out.println(num);                 // 오류 없으면 try문 실행 -> 후 finally로
		} catch (NumberFormatException e) {
		e.printStackTrace();                     // 오류 있으면 catch 문 실행 -> 후 finally로
		} finally {
		System.out.println("항상 실행 1");       // finally는 항상 실행
		}
		
		// 문제 코드 (2)
		Object obj = new String("a");
		int a = (Integer) obj; // ClassCastException

		// try - catch - finally 예외처리
		Object obj2 = new String("a");
		try {
		int a2 = (Integer) obj;
		} catch (ClassCastException e) {
		e.printStackTrace();
		} finally {
		System.out.println("항상 실행 2");
		}

}
}