package cn.lntu.t33;

public class Yrdw {
	private String dwnumber;      //单位编号
	private String dwname;        //单位名称
    private Zyfl zyfl;            //职业类型（号）
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
