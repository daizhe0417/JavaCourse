package cn.lntu.t33;

public class Yrdw {
	private String dwnumber;      //��λ���
	private String dwname;        //��λ����
    private Zyfl zyfl;            //ְҵ���ͣ��ţ�
    public Yrdw()
    {             }
    public Yrdw(String dwnumber,String dwname,Zyfl zyfl)
	{ this.set(dwnumber, dwname,zyfl);
	}
    public void set(String dwnumber, String dwname,Zyfl zyfl)
	{ this.dwnumber=dwnumber;
	  this.dwname=dwname;
	  this.zyfl=zyfl;
	}
	public String getdwnumber()
	{ return this.dwnumber; }
	public String getdwname()
	{ return this.dwname; }
	public String getzynumber(Zyfl zyfl)
	{ return this.zyfl.getZylxnumber(); 
		}

}
