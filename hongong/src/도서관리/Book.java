package 도서관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Book {

	// 필드는 외부 접근 막기 - getter/setter
	private String title;
	private String writer;
	private int price;
	private String bnum;

	public Book() {
		
	}
	
	public Book(String title) {
        this.title = title;
	}

	
	public Book(String title, String writer, int price, String bnum) {
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.bnum = bnum;
	}

	public Book(String title, int price, String bnum) {
		this.title = title;
		this.price = price;
		this.bnum = bnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	@Override
	public String toString() {
		return "제목 : " + title + " \t " + " 저자 : " + writer + "\t" + "가격 : " + price + "\t" + "책번호 : " + bnum ;
	}


}
