package cn.lntu.t33;

public class Zyxx {
	private String zynumber;   //职业号
	private String zyname;     //职业名称
	private Yrdw yrdw;         //用人单位（编号）
	private Zyfl zyfl;         //职业类型（号）
	private String zyyq;       //专业要求
	private int yprs;          //已聘人数
	private int xqrs;          //需求人数
	private int gz;            //工资
	public Zyxx()
	{           }
	public Zyxx(String zynumber,String zyname,Yrdw yrdw,Zyfl zyfl,String zyyq,int yprs,int xqrs,int gz)
	{ this.set(zynumber, zyname,yrdw,zyfl,zyyq,yprs,xqrs,gz);
	}
    public void set(String zynumber,String zyname,Yrdw yrdw,Zyfl zyfl,String zyyq,int yprs,int xqrs,int gz)
	{ this.zynumber=zynumber;
	  this.zyname=zyname;
	  this.yrdw=yrdw;
	  this.zyfl=zyfl;
	  this.zyyq=zyyq;
	  this.yprs=yprs;
	  this.xqrs=xqrs;
	  this.gz=gz;
	}
	public String getzynumber()
	{ return this.zynumber; }
	public String getzyname()
	{ return this.zyname; }
	public String getdwnumber(Yrdw yrdw)
	{ return this.yrdw.getdwnumber(); }
	public String getzylxnumber(Zyfl zyfl)
	{ return this.zyfl.getZylxnumber(); }
	public String getzyyq()
	{ return this.zyyq; }
	public int getyprs()
	{ return this.yprs; }
	public int getxqrs()
	{ return this.xqrs; }
	public int getgz()
	{ return this.gz; }
	void insert(Zyxx z)            //实现增加接口方法
	{z.set(z.zynumber, z.zyname,z.yrdw,z.zyfl,z.zyyq,z.yprs,z.xqrs,z.gz);}
	void updata(String n,Zyxx z)    //实现修改接口方法
	{if(this.zynumber==n)
	   { this.zynumber=z.zynumber;
         this.zyname=z.zyname;
         this.yrdw=z.yrdw;
         this.zyfl=z.zyfl;
         this.zyyq=z.zyyq;
         this.yprs=z.yprs;
         this.xqrs=z.xqrs;
         this.gz=z.gz;}
	}

}
