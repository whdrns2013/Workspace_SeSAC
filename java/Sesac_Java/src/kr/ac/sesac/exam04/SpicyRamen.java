package kr.ac.sesac.exam04;

public class SpicyRamen extends Ramen{

	public SpicyRamen(String name, String taste) {
		super.name = name;
		super.taste = taste;
		}

	@Override
	public String getTaste() {
		// TODO Auto-generated method stub
		return name + " => " + taste;
	}
	
	
	

	
	
	
}
