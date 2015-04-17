package cn.lntu.t25;

public class Student {
	
	Student(){
		
	}
private String  name;
private  int id;
private  int idNumber;
private  char  sex;
private  String  address;
private  String college;
private  String major;
private  int phoneNumber;
private  int password;
private  String  isemployment;



public void  setName(String name){
	this.name=name;
	
}


public  String  getName(){
	return  this.name;
}

public  void  setId(int id){
	this.id=id;
	
}


public   int  getId(){
	return  this.id;
}

public  void   setIdNumber(int idNumber){
	this.idNumber=idNumber;
}


public  int  getIdNumber(){
	return  this.idNumber;
	
}


public  void setSex(char  sex){
	this.sex=sex;
	
}


public  char getSex(){
	return  this.sex;
	
}

public  void setAddress(String address){
	this.address=address;
	
}


public  String  getAddress(){
	return  this.address;
}



public  void setCollege(String college){
	this.college=college;
	
}



public  String  getCollege(){
	return this.college;
}



public  void setMajor(String major){
	this.major=major;
}


public  String getMajor(){
	
	return this.major;
}



public  void setPhoneNumber(int phoneNumber){
	this.phoneNumber=phoneNumber;
}


public  int getPhoneNumber(){
	return this.phoneNumber;
}



public  void setPassword(int password){
	this.password=password;
}



public  int getPassword(){
	return  this.password;
}




public  void setIsemployment(){
	
	this.isemployment="待业";
}



public String getIsemployment(){
	return this.isemployment;
}


}