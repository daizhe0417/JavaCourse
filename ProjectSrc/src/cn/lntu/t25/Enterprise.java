package cn.lntu.t25;



public class Enterprise {


	private  Integer  id;
	private String name;
	private  String address;
	private String email;
	private String phoneNumber;
	private  String password;
	
	
	Enterprise()	{
		
	}
	Enterprise(int  id,String name,String address,String email,String phoneNumber,String password)	{
		this.id=id;
		this.name=name;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.password=password;
		
		
	}
	
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
	
	public  void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public  void setPassword(String password){
		this.password=password;
	}
	
	public  String getPassword(){
		return  this.password;
	}
	public   String  toString(){
		return  "name:"+this.name+"address:"+this.address+"email:"+this.email+"phonenumber:"+this.phoneNumber;
		
	}
	
}
