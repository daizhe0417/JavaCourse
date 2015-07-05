package cn.lntu.t11;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Office {
	public String ofname;
	public String ofdno;
	public String ofphone;
	public String offloor;
	public String ofnumber;
	public String getOfname() {
		return ofname;
	}

	public void setOfname(String ofname) {
		this.ofname = ofname;
	}

	public String getOfdno() {
		return ofdno;
	}

	public void setOfdno(String ofdno) {
		this.ofname = ofdno;
	}
	public String getOfphone() {
		return ofphone;
	}
	public void setOfphone(String ofphone) {
		this.ofphone = ofphone;
	}
	public String getOfflooor() {
		return offloor;
	}
	public void setOffloor(String offloor) {
		this.offloor = offloor;
	}
	public Office() {

	}
	public String getOfnumber() {
		return ofnumber;
	}

	public void setOfnumber(String ofnumber) {
		this.ofnumber = ofnumber;
	}
	public Office(String ofname, String ofdno, String ofphone,String offloor,String ofnumber) {
		this.ofname = ofname;
		this.ofdno = ofdno;
		this.ofphone = ofphone;
		this.offloor=offloor;
		this.ofnumber=ofnumber;
	}
	public Office get()
	{
		Office officein=new  Office();
		officein.setOfdno(this.ofname);
		officein.setOfdno(this.ofdno);
		officein.setOfdno(this.ofphone);
		officein.setOfdno(this.offloor);
		return  officein;		
	}
	
}
/*public boolean add(Office off) {
		if (this.list != null) {
			this.list.add(off);
			return true;
		} else {
			this.list = new ArrayList();
			this.list.add(off);
		}
		return false;
	}
	public List<Office> getAllOffice() {
		return this.list;
	}
*/	