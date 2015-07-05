package cn.lntu.t31;


public class User {
	
	private String UserName;	//用户名
	private String Password;	//密码
	private String Power;		//权限
	private String RealName;	//真实姓名
	private String IsStop;		//是否停用
	private String Tel;			//电话
	private String Sex;			//性别
	private String PhotoPath;   //头像
	private String Unit;

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPower() {
		return Power;
	}
	public void setPower(String power) {
		Power = power;
	}
	
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public String getIsStop() {
		return IsStop;
	}
	public void setIsStop(String isStop) {
		IsStop = isStop;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}	
	public String getPhotoPath() {
		return PhotoPath;
	}
	public void setPhotoPath(String photoPath) {
		PhotoPath = photoPath;
	}
	
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String toJson() {
		return JsonUtil.toJson(this);
	}
	
	public static User fromJson(String json) {
		return JsonUtil.fromJson(json, User.class);
	}
	
}
