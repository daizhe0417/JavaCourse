package com.bookMange.bean;

import com.bookMange.json.JsonUtil;

public class BookInfo {

	private String bookNum;
	private String bookName;
	private String bookAuthor;
	private String bookISBN;
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	
	public String toJson() {
		return JsonUtil.toJson(this);
	}

	public static BookInfo fromJson(String json) {
		return JsonUtil.fromJson(json, BookInfo.class);
	}
	
}
