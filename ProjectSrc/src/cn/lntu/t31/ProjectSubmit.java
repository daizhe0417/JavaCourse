package cn.lntu.t31;


public class ProjectSubmit {
	private String pName;
	private String Type;
	private String pContent;
	private String pSubmiter;
	private String developTime;
	private String developers;
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	public String getpSubmiter() {
		return pSubmiter;
	}
	public void setpSubmiter(String pSubmiter) {
		this.pSubmiter = pSubmiter;
	}
	public String getDevelopTime() {
		return developTime;
	}
	public void setDevelopTime(String developTime) {
		this.developTime = developTime;
	}
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
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
	
	public static ProjectSubmit fromJson(String json) {
		return JsonUtil.fromJson(json, ProjectSubmit.class);
	}
}
