package cn.lntu.t25;


//用户累，对应数据库中的用户表

class StuUser {
private  Integer  id=0;
private  String   password="0";
StuUser(){
	
	
}	

public   void   setId(int  id){
this .id=id;
}
public   void  setPassword(String password){
	this.password=password;
}
public   int  getId(){
	
	return  this.id;
}
public   String  getPassword(){
	return  this.password;
}
}




class  EnterUser{
	
	private  Integer  id=0;
	private  String   password="0";
	EnterUser(){
		
		
	}
	   public   void   setId(int  id){
		this .id=id;
		}
	
		public   void  setPassword(String password){
			this.password=password;
		}
		public   int  getId(){
			
			return  this.id;
		}
		public   String  getPassword(){
			return  this.password;
		}
	
}


class  AdminUser{
	private  Integer  id=0;
	private  String   password="0";
	AdminUser(){
		
		
	}
	public   void   setId(int  id){
		this .id=id;
		}
		public   void  setPassword(String password){
			this.password=password;
		}
		public   int  getId(){
			
			return  this.id;
		}
		public   String  getPassword(){
			return  this.password;
		}
}