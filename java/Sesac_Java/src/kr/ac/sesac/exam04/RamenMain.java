package kr.ac.sesac.exam04;

public class RamenMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Ramen ramen2 = new SaltyRamen("소금 라면", "짠 라면맛");
		String taste2 = ramen2.getTaste();
		System.out.println(taste2);
		
		Ramen ramen1 = new SpicyRamen("불 라면", "매운 라면맛");
		String taste1 = ramen1.getTaste();
		System.out.println(taste1);
		
		
		
		
	}

}
