package chap13;

public class Board {

	// 필드
	String subject;
	String writer;
	private String title;
	private String content;
	
	// 생성자
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
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
	
	// 메소드
//	@Override
//	public String toString() {
//		return subject + " : " + content + " : " + writer;
//	}
	
}
