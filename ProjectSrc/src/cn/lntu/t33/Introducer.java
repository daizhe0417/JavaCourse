package cn.lntu.t33;

public class Introducer implements java.io.Serializable   
{   
	   private String Idnumber;
	   private String Idname;
	   private String sex;
	   private String phone;   
	   public Introducer()   
	     {  }   
	   public void setIdnumber(String Idnumber)   
	     {   this.Idnumber=Idnumber;   } 
	   public void setIdname(String Idname)   
	     {   this.Idname=Idname;   }
	   public void setsex(String sex)   
	     {   this.sex=sex;   }
	   public void setphone(String phone)   
	     {   this.phone=phone;   }
	   public String getIdnumber()   
	     {    return Idnumber;    }
	   public String getIdname()   
	     {    return Idname;    }
	    public String getsex()   
	     {    return sex;    }   
	    public String getphone()   
	     {    return phone;    }
	 
	} 
