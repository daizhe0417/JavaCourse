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

}
