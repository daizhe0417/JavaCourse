package cn.lntu.t33;

public class Zyxx {
	private String zynumber;   //ְҵ��
	private String zyname;     //ְҵ����
	private Yrdw yrdw;         //���˵�λ����ţ�
	private Zyfl zyfl;         //ְҵ���ͣ��ţ�
	private String zyyq;       //רҵҪ��
	private int yprs;          //��Ƹ����
	private int xqrs;          //��������
	private int gz;            //����
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
	void insert(Zyxx z)            //ʵ�����ӽӿڷ���
	{z.set(z.zynumber, z.zyname,z.yrdw,z.zyfl,z.zyyq,z.yprs,z.xqrs,z.gz);}
	void updata(String n,Zyxx z)    //ʵ���޸Ľӿڷ���
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
