package cn.lntu.t25;

public class Enterprise {

	Enterprise()	{
		
	}
	private  int  id;
	private String name;
	private  String address;
	private String email;
	private int phoneNumber;
	private  int password;
	
	
	
	public  void setId(int id){
		this.id=id;
	}
	
	public  int getId(){
		return  this.id;
	}
	
	public void  setName(String name){
		this.name=name;
		
	}
	
	public  String  getName(){
		return  this.name;
	}
	
	public  void setAddress(String address){
		this.address=address;
		
	}
	
	public  String  getAddress(){
		return  this.address;
	}
	
	public  void setEmail(String email){
		this.email=email;
	}
	
	public  String  getEmail(){
		return  this.email;
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
	
}
