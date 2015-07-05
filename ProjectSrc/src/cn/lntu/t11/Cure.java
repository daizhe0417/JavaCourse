package cn.lntu.t11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class Cure {
	public String dname;
	public String pname;
	public String time;
	public String cdno;
	public String category;
	public String type;
	public String attribute;
	public String number;
	private static List<Cure> list = new ArrayList();
	public String getCunumber() {
		return number;
	}
	public void setCunumber(String number) {
		this.number = number;
	}
	public String getCudname() {
		return dname;
	}
	public void setCudname(String dname) {
		this.dname = dname;
	}
	public String getCupname() {
		return pname;
	}
	public void setCupname(String pname) {
		this.pname = pname;
	}
	public String getCutime() {
		return time;
	}
	public void setCutime(String time) {
		this.time = time;
	}

	public String getCudno() {
		return cdno;
	}
	public void setCudno(String cdno) {
		this.cdno = cdno;
	}
	public String getCucategory() {
		return category;
	}
	public void setCucategory(String category) {
		this.category = category;
	}
	public String getCtype() {
		return type;
	}
	public void setCutype(String type) {
		this.type = type;
	}
	public String getCuattribute() {
		return attribute;
	}
	public void setCuattribute(String attribute) {
		this.attribute = attribute;
	}
	public boolean add(Cure cur) {
		if (this.list != null) {
			this.list.add(cur);
			return true;
		} else {
			this.list = new ArrayList();
			this.list.add(cur);
		}
		return false;
	}
	public List<Cure> getAllCure() {
		return this.list;
	}
	
	public Cure()
	{}
	public Cure(String dname,String pname, String time,String cdno, String number,String category, String type,String attribute) {
		this.dname=dname;
		this.pname=pname;
		this.cdno = cdno;
		this.time=time;
		this.category = category;
		this.type = type;
		this.attribute = attribute;
		this.number=number;
	}
	
   public Cure get()
   {
 	Cure curein=new  Cure();
	curein.setCudname(this.dname);
	curein.setCupname(this.pname);
	curein.setCutime(this.time);
	curein.setCudno(this.cdno);
	curein.setCucategory(this.category);
	curein.setCutype(this.type);
	curein.setCuattribute(this.attribute);
	return  curein;
}
}
