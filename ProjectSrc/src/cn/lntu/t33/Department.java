package com.bookMange.bean;

import com.bookMange.json.JsonUtil;

public class Department {
	
	private String DepartmentNum;
	private String DepartmentName;
	public String getDepartmentNum() {
		return DepartmentNum;
	}
	public void setDepartmentNum(String departmentNum) {
		DepartmentNum = departmentNum;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	
	
	public String toJson() {
		return JsonUtil.toJson(this);
	}

	public static Department fromJson(String json) {
		return JsonUtil.fromJson(json, Department.class);
	}

}
