package cn.lntu.t33;

interface Change
{  void insert(Object object);
   void delete(Object n,Object object);
   void select(Object object);
   void updata(Object n,Object object);
}

public class Zyfl {
	private String zylxnumber; // ְҵ���ͺ�
	private String zylxname; // ְҵ������
	public Zyfl()
    { }
    public Zyfl(String zylxnumber, String zylxname) {
		this.set(zylxnumber, zylxname);
	}
    public void set(String zylxnumber, String zylxname) {
		this.zylxnumber = zylxnumber;
		this.zylxname = zylxname;
	}

	public String getZylxnumber() {
		return this.zylxnumber;
	}

	public String getZylxname() {
		return this.zylxname;
	}
	void insert(Zyfl z)              //ʵ�����ӽӿڷ���
	{ z.set(z.zylxnumber,z.zylxname);}
	void updata(String n,Zyfl z)    //ʵ���޸Ľӿڷ���
	{if(this.zylxnumber==n)
		{ this.zylxnumber=z.zylxnumber;
	      this.zylxname=z.zylxname;}
	}

}
