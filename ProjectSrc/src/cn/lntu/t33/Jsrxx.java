package cn.lntu.t33;

public class Jsrxx {
	private String jsrnumber;  //������Ա���
	private String jsrname;    //������Ա����
	private String phone;      //������Ա�绰
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
	void insert(Jsrxx z)               //ʵ�����ӽӿڷ���
	{z.set(z.jsrnumber, z.jsrname,z.phone);}
	void updata(String n,Jsrxx z)    //ʵ���޸Ľӿڷ���
	{if(this.jsrnumber==n)
		{ this.jsrnumber=z.jsrnumber;
	      this.jsrname=z.jsrname;
	      this.phone=z.phone;}
	}


}
