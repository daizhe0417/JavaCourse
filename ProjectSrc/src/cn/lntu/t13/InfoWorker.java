package cn.lntu.t13;

public class InfoWorker {
	public String ProfessionalTitle;
	public String StudyHistory;
	public String OfficeHistory;
	public String FamilyInfo;
	
	public String Honour;
	public String Remark;
	
	public InfoWorker(){
		this.ProfessionalTitle=new String();
		this.StudyHistory=new String();
		this.OfficeHistory=new String();
		this.FamilyInfo=new String();
		this.Honour=new String();
		this.Remark=new String();
	}
	
	public InfoWorker(InfoWorker i){
		this.ProfessionalTitle=new String(i.ProfessionalTitle);
		this.StudyHistory=new String(i.StudyHistory);
		this.OfficeHistory=new String(i.OfficeHistory);
		this.FamilyInfo=new String(i.FamilyInfo);
		this.Honour=new String(i.Honour);
		this.Remark=new String(i.Remark);	
	}
}
