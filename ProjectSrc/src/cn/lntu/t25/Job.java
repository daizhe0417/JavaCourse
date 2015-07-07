package cn.lntu.t25;



public class Job {

	private  Integer  enterId;
	private String  jobName;
	private  Integer  needNumber;
	private Integer  reminder;
	private  String  gangweimiaoshu;
	private  String  description;
	private  String  gender;
	private   Integer year1;
	private Integer year2;
	private  String  skill;
	private  String  entername;




	public int getEnterId() {
		return enterId;
	}


	public void setEnterId(int enterId) {
		this.enterId = enterId;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public int getNeedNumber() {
		return needNumber;
	}


	public void setNeedNumber(int needNumber) {
		this.needNumber = needNumber;
	}


	public int getReminder() {
		return reminder;
	}


	public void setReminder(int reminder) {
		this.reminder = reminder;
	}


	public String getGangweimiaoshu() {
		return gangweimiaoshu;
	}


	public void setGangweimiaoshu(String gangweimiaoshu) {
		this.gangweimiaoshu = gangweimiaoshu;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getYear1() {
		return year1;
	}


	public void setYear1(int year1) {
		this.year1 = year1;
	}


	public int getYear2() {
		return year2;
	}


	public void setYear2(int year2) {
		this.year2 = year2;
	}


	public String getSkill() {
		return skill;
	}


	public void setSkill(String skill) {
		this.skill = skill;
	}


	public String getEntername() {
		return entername;
	}


	public void setEntername(String entername) {
		this.entername = entername;
	}
	
	


	@Override
	public String toString() {
		return "Job [enterId=" + enterId + ", jobName=" + jobName
				+ ", needNumber=" + needNumber + ", reminder=" + reminder
				+ ", gangweimiaoshu=" + gangweimiaoshu + ", description="
				+ description + ", gender=" + gender + ", year1=" + year1
				+ ", year2=" + year2 + ", skill=" + skill + ", entername="
				+ entername + "]";
	}
	
}
