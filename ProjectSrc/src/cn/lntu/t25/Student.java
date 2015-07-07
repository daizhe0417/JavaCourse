package cn.lntu.t25;



public class Student {
	
	
private String  name;
private  Integer id;
private  String idNumber;
private  String  sex;
private  String  address;
private  Integer college_id;
private  Integer major_id;
private  String phoneNumber;
private  String password;
private  String  employment;



Student(){
	
}
Student(String name,int id,String idNumber,String sex,String address,int college_id,int major_id,String phoneNumber,String  password,String employment){
	
	this.id=id;
	this.idNumber=idNumber;
	this.sex=sex;
	this.address=address;
	this.college_id=college_id;
	this.major_id=major_id;
	this.name=name;
	this.phoneNumber=phoneNumber;
	this.employment=employment;
	this.password=password;
	
	
}
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

public  void   setIdNumber(String idNumber){
	this.idNumber=idNumber;
}


public  String  getIdNumber(){
	return  this.idNumber;
	
}


public  void setSex(String  sex){
	this.sex=sex;
	
}


public  String getSex(){
	return  this.sex;
	
}

public  void setAddress(String address){
	this.address=address;
	
}


public  String  getAddress(){
	return  this.address;
}



public  void setCollege(int college_id){
	this.college_id=college_id;
	
}



public  int  getCollege(){
	return this.college_id;
}



public  void setMajor(int major_id){
	this.major_id=major_id;
}


public int getMajor(){
	
	return this.major_id;
}



public  void setPhoneNumber(String phoneNumber){
	this.phoneNumber=phoneNumber;
}


public  String getPhoneNumber(){
	return this.phoneNumber;
}



public  void setPassword(String password){
	this.password=password;
}



public  String getPassword(){
	return  this.password;
}




public  void setEmployment(String str){
	
	this.employment=str;
}



public String isEmployment(){
	return this.employment;
}

public  String  toString(){
	
	return "name :"+this.name+"id:"+this.id+"idnumber:"+this.idNumber+"address:"+this.address+"sex:"+this.sex+"employment?:"+this.employment;
	
}

}
