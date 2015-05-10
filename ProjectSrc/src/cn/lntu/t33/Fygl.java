package cn.lntu.t33;

public class Fygl {
	private Zyfl zyfl;        //职业类型（编号）
	private Yrdw yrdw;        //用人单位（编号）
	private Qzzxx qzzxx;      //求职者（编号）
	private Jsrxx jsrxx;      //介绍人（编号）
	private int dwjf;         //单位缴费
	private int qzzjf;        //求职者缴费
	public  Fygl()
	{      }
	public  Fygl(Zyfl zyfl,Yrdw yrdw,Qzzxx qzzxx,Jsrxx jsrxx,int dwjf,int qzzjf)
	{ this.set(zyfl,yrdw,qzzxx,jsrxx,dwjf,qzzjf);}
	public void set(Zyfl zyfl,Yrdw yrdw,Qzzxx qzzxx,Jsrxx jsrxx,int dwjf,int qzzjf)
	{ this.zyfl=zyfl;
	  this.yrdw=yrdw;
	  this.qzzxx=qzzxx;
	  this.jsrxx=jsrxx;
	  this.dwjf=dwjf;
	  this.qzzjf=qzzjf;
	}
	public String getzynumber(Zyfl zyfl)
	{ return this.zyfl.getZylxnumber();}
	public String getdwnumber(Yrdw yrdw)
	{ return this.yrdw.getdwnumber();}
	public String getQzznumber(Qzzxx qzzxx)
	{ return this.qzzxx.getqzznumber();}
	public String getjsrnumber(Jsrxx jsrxx)
	{ return this.jsrxx.getjsrnumber();}
	public int getdwjf()
	{ return this.dwjf;}
	public int getqzzjf()
	{ return this.qzzjf;}
	void insert(Fygl z)           //实现增加接口方法
	{z.set(z.zyfl,z.yrdw,z.qzzxx,z.jsrxx,z.dwjf,z.qzzjf);}
	void updata(String n,Fygl z)    //实现修改接口方法
	{if(this.zyfl.getZylxnumber()==n)
		{ this.zyfl=z.zyfl;
	      this.yrdw=z.yrdw;
	      this.qzzxx=z.qzzxx;
	      this.jsrxx=z.jsrxx;
	      this.dwjf=z.dwjf;
	      this.qzzjf=z.qzzjf;}
	}

}
