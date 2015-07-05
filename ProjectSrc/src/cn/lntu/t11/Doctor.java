package cn.lntu.t11;

public class Doctor {
	public String dename;
	public String deage;
	public String desex;
	public String dedno;
	public String dedepart;
	public String deoffice;
	public String denumber;
	public String getDenumber() {
		return denumber;
	}

	public void setDenumber(String denumber) {
		this.denumber = denumber;
	}
	public String getDename() {
		return dename;
	}

	public void setDename(String dename) {
		this.dename = dename;
	}
	public String getDeage() {
		return deage;
	}

	public void setDeage(String deage) {
		this.deage = deage;
	}
	public String getDesex() {
		return desex;
	}
	public void setDesex(String desex) {
		this.desex = desex;
	}
	public String getDedno() {
		return dedno;
	}
	public void setDedno(String dedno) {
		this.dedno = dedno;
	}
	public String getDedepart() {
		return dedepart;
	}

	public void setDedepart(String dedepaet) {
		this.dedepart = dedepart;
	}
	public String getDeoffice() {
		return deoffice;
	}

	public void setDeoffice(String deoffice) {
		this.deoffice = deoffice;
	}
	public Doctor()
	{}
	public Doctor(String dename, String deage,String denumber,String desex ,String dedno,String dedepart,String deoffice) {
		this.dename = dename;
		this.deage=deage;
		this.dedno=dedno;
		this.desex=desex;
		this.dedepart=dedepart;
		this.deoffice=deoffice;
		this.denumber=denumber;
	}
	public Doctor get()
	{
		Doctor doctorin=new  Doctor();
		doctorin.setDename(this.dename);
		doctorin.setDeage(this.deage);
		doctorin.setDedno(this.dedno);
		doctorin.setDesex(this.desex);
		doctorin.setDedepart(this.dedepart);
		doctorin.setDeoffice(this.deoffice);
		return  doctorin;
		
	}
}
