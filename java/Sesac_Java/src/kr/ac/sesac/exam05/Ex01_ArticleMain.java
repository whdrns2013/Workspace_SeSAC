package kr.ac.sesac.exam05;

public class Ex01_ArticleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex01_ArticleVO article = new Ex01_ArticleVO();
		
		article.setArticleId(1);
		article.setTitle("1번 게시글");
		article.setContent("1번 게시글 테스트입니다.");
		
		System.out.println(article.toString());
		
	}

}
