package cn.lntu.t35;

public class Course {
	private String coursenum;        //课程号
	private String coursenam;        //课程名
	private String stutim;           //学时
	private String credit;           //学分
	private String teacher;          //老师
	public String getCoursenum() {
		return coursenum;
	}
	public void setCoursenum(String coursenum) {
		this.coursenum = coursenum;
	}
	public String getCoursenam() {
		return coursenam;
	}
	public void setCoursenam(String coursenam) {
		this.coursenam = coursenam;
	}
	public String getStutim() {
		return stutim;
	}
	public void setStutim(String stutim) {
		this.stutim = stutim;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
}
