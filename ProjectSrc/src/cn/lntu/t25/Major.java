package cn.lntu.t25;

public class Major {
private  Integer id;
private  String  name;
private   Integer college_id;
private  Integer  total;
private  Integer  employment;

Major(){

}
Major(int id,String  name,int college){
	this.id=id;
	this.name=name;
	this.college_id=college;
	
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
public int getCollege() {
	return this.college_id;
}
public void setCollege(int college) {
	this.college_id = college;
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
	return "Major [id=" + id + ", name=" + name + ", college_id=" + college_id
			+ ", total=" + total + ", employment=" + employment + "]";
}


}
