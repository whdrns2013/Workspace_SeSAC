package kr.ac.sesac.exam04;

public class ComputerMain {

	public static void main(String[] args) {

		NoteBook notebook = new NoteBook(8);
		// 컴퓨터 클래스를 상속받는 노트북 클래스의 notebook 객체 생성 (매개변수를 8로 가진)
		System.out.println(notebook.cpu);
		
	}

}
