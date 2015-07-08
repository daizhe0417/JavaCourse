package cn.lntu.t31.Bean;

import cn.lntu.t31.Json.JsonUtil;

public class ProjectSearch {
	private String pNum;
	private String pName;
	private String Type;
	private String pContent;
	private String developTime;
	private String developers;
	
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	public String getDevelopTime() {
		return developTime;
	}
	public void setDevelopTime(String developTime) {
		this.developTime = developTime;
	}
	public String getDevelopers() {
		return developers;
	}
	public void setDevelopers(String developers) {
		this.developers = developers;
	}
	
	public String toJson() {
		return JsonUtil.toJson(this);
	}
	
	public static ProjectSearch fromJson(String json) {
		return JsonUtil.fromJson(json, ProjectSearch.class);
	}
	
}
