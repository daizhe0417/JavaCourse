package cn.lntu.t25;

public class Form {
private  String  entername;
private  Integer studnetId;
private  String Jobname;
private  	String  resume;
private  String status;

Form(){
	
}//处理表单
Form(String entername,Integer studnetId,String  jobname,String resume,String  status){
	this.entername=entername;
	this.Jobname=jobname;
	this.resume=resume;
	this.studnetId=studnetId;
	this.status=status;
	
	
}
public String getEntername() {
	return entername;
}
public void setEntername(String entername) {
	this.entername = entername;
}
public Integer getStudnetId() {
	return studnetId;
}
public void setStudnetId(Integer studnetId) {
	this.studnetId = studnetId;
}
public String getJobname() {
	return Jobname;
}
public void setJobname(String jobname) {
	Jobname = jobname;
}
public String getResume() {
	return resume;
}
public void setResume(String resume) {
	this.resume = resume;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Form [entername=" + entername + ", studnetId=" + studnetId
			+ ", Jobname=" + Jobname + ", resume=" + resume + ", status="
			+ status + "]";
}	
	
}
