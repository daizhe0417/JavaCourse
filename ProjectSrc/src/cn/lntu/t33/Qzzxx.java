package cn.lntu.t33;

public class Qzzxx {
	private String qzznumber;    //��ְ�߱��
	private String name;         //����
	private String sex;          //�Ա�
	private String gdzy;         //����רҵ
	private boolean piny;        //�Ƿ�Ƹ��
	private int yuex;            //��нҪ��
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
	void insert(Qzzxx z)        //ʵ�����ӽӿڷ���
	{z.set(z.qzznumber, z.name, z.sex, z.gdzy, z.piny, z.yuex);}
	void updata(String n,Qzzxx z)    //ʵ���޸Ľӿڷ���
	{if(this.qzznumber==n)
		{ this.qzznumber=z.qzznumber;
	      this.name=z.name;
	      this.sex=z.sex;
	      this.gdzy=z.gdzy;
	      this.piny=z.piny;
	      this.yuex=z.yuex;}
	}

}
