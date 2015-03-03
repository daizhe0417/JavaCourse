package expe.ch2;

public class EmployeeModel{
	private String ygno;
	private String ygxm;
	private String zw;
	private String dianban;
	private String duibie;

	public String getYgno() {
		return ygno;
	}

	public void setYgno(String ygno) {
		this.ygno = ygno;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}

	public String getZw() {
		return zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	public String getDianban() {
		return dianban;
	}

	public void setDianban(String dianban) {
		this.dianban = dianban;
	}

	public String getDuibie() {
		return duibie;
	}

	public void setDuibie(String duibie) {
		this.duibie = duibie;
	}

	public EmployeeModel(String ygno, String ygxm, String zw, String dianban,
			String duibie) {
		super();
		this.ygno = ygno;
		this.ygxm = ygxm;
		this.zw = zw;
		this.dianban = dianban;
		this.duibie = duibie;
	}

	public EmployeeModel() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dianban == null) ? 0 : dianban.hashCode());
		result = prime * result + ((duibie == null) ? 0 : duibie.hashCode());
		result = prime * result + ((ygno == null) ? 0 : ygno.hashCode());
		result = prime * result + ((ygxm == null) ? 0 : ygxm.hashCode());
		result = prime * result + ((zw == null) ? 0 : zw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeModel other = (EmployeeModel) obj;
		if (dianban == null) {
			if (other.dianban != null)
				return false;
		} else if (!dianban.equals(other.dianban))
			return false;
		if (duibie == null) {
			if (other.duibie != null)
				return false;
		} else if (!duibie.equals(other.duibie))
			return false;
		if (ygno == null) {
			if (other.ygno != null)
				return false;
		} else if (!ygno.equals(other.ygno))
			return false;
		if (ygxm == null) {
			if (other.ygxm != null)
				return false;
		} else if (!ygxm.equals(other.ygxm))
			return false;
		if (zw == null) {
			if (other.zw != null)
				return false;
		} else if (!zw.equals(other.zw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeModel [ygno=" + ygno + ", ygxm=" + ygxm + ", zw=" + zw
				+ ", dianban=" + dianban + ", duibie=" + duibie + "]";
	}
}
