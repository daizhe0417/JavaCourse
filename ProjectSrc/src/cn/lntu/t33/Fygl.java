package cn.lntu.t33;

public class Fygl {
	private Zyfl zyfl;        //ְҵ���ͣ���ţ�
	private Yrdw yrdw;        //���˵�λ����ţ�
	private Qzzxx qzzxx;      //��ְ�ߣ���ţ�
	private Jsrxx jsrxx;      //�����ˣ���ţ�
	private int dwjf;         //��λ�ɷ�
	private int qzzjf;        //��ְ�߽ɷ�
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
	void insert(Fygl z)           //ʵ�����ӽӿڷ���
	{z.set(z.zyfl,z.yrdw,z.qzzxx,z.jsrxx,z.dwjf,z.qzzjf);}
	void updata(String n,Fygl z)    //ʵ���޸Ľӿڷ���
	{if(this.zyfl.getZylxnumber()==n)
		{ this.zyfl=z.zyfl;
	      this.yrdw=z.yrdw;
	      this.qzzxx=z.qzzxx;
	      this.jsrxx=z.jsrxx;
	      this.dwjf=z.dwjf;
	      this.qzzjf=z.qzzjf;}
	}

}
