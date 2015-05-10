package com.bookMange.bean;

import com.bookMange.json.JsonUtil;

public class ReaderType {
	
	private String readerNum;
	private String typeName;
	private String borrowAmount;
	private String borrowTime;
	public String getReaderNum() {
		return readerNum;
	}
	public void setReaderNum(String readerNum) {
		this.readerNum = readerNum;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getBorrowAmount() {
		return borrowAmount;
	}
	public void setBorrowAmount(String borrowAmount) {
		this.borrowAmount = borrowAmount;
	}
	public String getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}
	
	public String toJson() {
		return JsonUtil.toJson(this);
	}

	public static ReaderType fromJson(String json) {
		return JsonUtil.fromJson(json, ReaderType.class);
	}
}
