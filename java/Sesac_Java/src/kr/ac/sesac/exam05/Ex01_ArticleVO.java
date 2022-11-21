package kr.ac.sesac.exam05;

public class Ex01_ArticleVO {
	// 게시글의 정보를 취급하는 클래스
	private int articleId;
	private String title;
	private String content;
	
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Ex01_ArticleVO [articleId=" + articleId + ", title=" + title + ", content=" + content + "]";
	}
	
}
