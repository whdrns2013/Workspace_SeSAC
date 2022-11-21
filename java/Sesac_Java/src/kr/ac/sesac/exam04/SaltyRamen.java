package kr.ac.sesac.exam04;

public class SaltyRamen extends Ramen{
	
	public SaltyRamen(String name, String taste) {
		super.name = name;
		super.taste = taste;
		}

	@Override
	public String getTaste() {
		// TODO Auto-generated method stub
		return super.name + " => " + taste;
	}		
}