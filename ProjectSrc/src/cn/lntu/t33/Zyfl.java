package cn.lntu.t33;

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

}
