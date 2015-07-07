package cn.lntu.t25;

public class College {
	//学院信息
	
	private  Integer id;
	private String  name;
	private  Integer  total;
	private  Integer  employment;
	
public College() {
		
	}
public College(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getTotal() {
	return total;
}
public void setTotal(Integer total) {
	this.total = total;
}
public Integer getEmployment() {
	return employment;
}
public void setEmployment(Integer employment) {
	this.employment = employment;
}
@Override
public String toString() {
	return "College [id=" + id + ", name=" + name + ", total=" + total
			+ ", employment=" + employment + "]";
}	
}
