package cn.lntu.t11;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Medicine {
	
	public String mename;
	public String medno;
	public String mesex;
	public String medepart;
	public String meoffice;
	public String menumber;
	public String getMenumber() {
		return menumber;
	}
	public void setMenumber(String menumber) {
		this.menumber = menumber;
	}
	public String getMename() {
		return mename;
	}
	public void setMename(String mename) {
		this.mename = mename;
	}
	public String getMedno() {
		return medno;
	}
	public void setMedno(String medno) {
		this.medno = medno;
	}

	public String getMedsex() {
		return mesex;
	}
	public void setMesex(String mesex) {
		this.mesex = mesex;
	}
	public String getMedepart() {
		return medepart;
	}
	public void setMedepart(String medepart) {
		this.medepart = medepart;
	}
	public String getMeoffice() {
		return meoffice;
	}
	public void setMeoffice(String meoffice) {
		this.meoffice = meoffice;
	}
	public Medicine(){}
	
	public Medicine(String mename, String medno,String menumber,String mesex, String medepart,String meoffice) {
		this.medno = medno;
		this.mename = mename;
		this.mesex = mesex;
		this.medepart = medepart;
		this.meoffice = meoffice;
		this.menumber=menumber;}
public Medicine get()
{
	Medicine medicinein=new  Medicine();
	medicinein.setMename(this.mename);
	medicinein.setMesex(this.mesex);
	medicinein.setMedno(this.medno);
	medicinein.setMedepart(this.medepart);
	medicinein.setMeoffice(this.meoffice);
	return  medicinein;
}
}