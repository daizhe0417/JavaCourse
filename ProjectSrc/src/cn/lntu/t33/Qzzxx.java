package cn.lntu.t33;

public class Qzzxx {
	private String qzznumber;    //求职者编号
	private String name;         //姓名
	private String sex;          //性别
	private String gdzy;         //攻读专业
	private boolean piny;        //是否聘用
	private int yuex;            //月薪要求
	public  Qzzxx()
	{                 }
	public  Qzzxx(String qzznumber,String name,String sex,String gdzy,boolean piny,int yuex)
	{ this.set(qzznumber, name, sex, gdzy, piny, yuex); }
	public void set(String qzznumber,String name,String sex,String gdzy,boolean piny,int yuex)
	{ this.qzznumber=qzznumber;
	  this.name=name;
	  this.sex=sex;
	  this.gdzy=gdzy;
	  this.piny=piny;
	  this.yuex=yuex;
	}
	public String getqzznumber()
	{ return this.qzznumber; }
	public String getname()
	{ return this.name; }
	public String getsex()
	{ return this.sex; }
	public String getgdzy()
	{ return this.gdzy; }
	public boolean getpiny()
	{ return this.piny; }
	public int getyuex()
	{ return this.yuex;}

}
