package cn.lntu.t13;

public class Worker {
	public String name;
	public String birth;
	public String sex;
	public String depart;
	public String job;
	public InfoWorker information;

	public Worker() {
		this.name = new String();
		this.birth = new String();
		this.sex = new String();
		this.depart = new String();
		this.job = new String();
		this.information=new InfoWorker();
	}
	
	public Worker(String n,String b,String s,String d,String j) {
		this.name=new String(n);
		this.birth=new String(b);
		this.sex=new String(s);
		this.depart=new String(d);
		this.job=new String(j);
		this.information=new InfoWorker();
	}
	
	public Worker (Worker w){
		this.name=new String(w.name);
		this.birth=new String(w.birth);
		this.sex=new String(w.sex);
		this.depart=new String(w.depart);
		this.job=new String(w.job);
		this.information=new InfoWorker(w.information);
	}
}
