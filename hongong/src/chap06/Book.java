package chap06;

public class Book {
	
	// 필드
	private String book_name;
	private int book_id;
	private int book_price;

	// 생성자
	Book(int book_id, String book_name, int book_price){
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_price = book_price;
	}


	// 메소드
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	
	
	
	
}
