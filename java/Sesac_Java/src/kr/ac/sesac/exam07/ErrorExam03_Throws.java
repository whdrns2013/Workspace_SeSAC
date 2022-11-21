package kr.ac.sesac.exam07;

public class ErrorExam03_Throws {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 중괄호와 괄호 사이에 throws 키워드 이용해 떠넘길 예외를 지정한다.
		public static void main(String[] args) throws NumberFormatException, ClassCastException {

			// 예외 떠넘기기 - throws
			String numStr = " 123";
				int num = Integer.parseInt(numStr);
				Object obj = new String("a");
				int a = (Integer) obj;
				}
		
		
		
		
		
	}

}
