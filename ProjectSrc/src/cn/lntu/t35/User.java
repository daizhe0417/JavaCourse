package cn.lntu.t35;


public class User {
	private String power;        //Ȩ��
	private String password;     //����	
	private String stuname;      //����
	private String stunum;       //ѧ��
	private String stusex;       //�Ա�
	private String stuhometown;	 //����
	private String stuclass;     //�༶
	private String stumajor;     //רҵ
	private String stuinstitute; //ѧԺ
	
	
 
	

public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
		
	}
	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getStusex() {
		return stusex;
	}

	public void setStusex(String stusex) {
		this.stusex = stusex;
	}

	public String getStuhometown() {
		return stuhometown;
	}

	public void setStuhometown(String stuhometown) {
		this.stuhometown = stuhometown;
	}

	public String getStuclass() {
		return stuclass;
	}

	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}

	public String getStumajor() {
		return stumajor;
	}

	public void setStumajor(String stumajor) {
		this.stumajor = stumajor;
	}

	public String getStuinstitute() {
		return stuinstitute;
	}

	public void setStuinstitute(String stuinstitute) {
		this.stuinstitute = stuinstitute;
	}

public String toJson() {
	return JsonUtil.toJson(this);
}

public static User fromJson(String json) {
	return JsonUtil.fromJson(json, User.class);
}
//public static void main(String[] args){
//	User user=new User();
//	System.out.println(user.stunum);
//}
}

