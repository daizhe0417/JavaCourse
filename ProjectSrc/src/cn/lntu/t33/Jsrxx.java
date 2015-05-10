package cn.lntu.t33;

public class Jsrxx {
	private String jsrnumber;  //介绍人员编号
	private String jsrname;    //介绍人员名字
	private String phone;      //介绍人员电话
	public Jsrxx()
	{            }
	public Jsrxx(String jsrnumber,String jsrname,String phone)
	{ this.set(jsrnumber, jsrname,phone);
	}
	public void set(String jsrnumber, String jsrname,String phone)
	{ this.jsrnumber=jsrnumber;
	  this.jsrname=jsrname;
	  this.phone=phone;
	}
	public String getjsrnumber()
	{ return this.jsrnumber; }
	public String getjsrname()
	{ return this.jsrname; }
	public String getphone()
	{ return this.phone; }
	void insert(Jsrxx z)               //实现增加接口方法
	{z.set(z.jsrnumber, z.jsrname,z.phone);}
	void updata(String n,Jsrxx z)    //实现修改接口方法
	{if(this.jsrnumber==n)
		{ this.jsrnumber=z.jsrnumber;
	      this.jsrname=z.jsrname;
	      this.phone=z.phone;}
	}


}
