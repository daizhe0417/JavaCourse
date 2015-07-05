package cn.lntu.t11;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class DoctorJPanel extends JPanel implements ActionListener{
	private JTextField texts[];
	 private JRadioButton radiobs[];
	 public JComboBox<String>combox_depart,combox_office,combox_dno;
	 private static String num[]={"1001","1002","1003","1004","1005","1006","1007","1008","1009","1010"};
	 private static String depart[] = {"内科","外科"};
	 private static String office[][]={{"解热镇痛药","抗肿瘤药","补益剂","解表剂","止咳剂"},{"类风湿剂","活气血剂","中成药","循环系统药"}};
	 private JLabel lname,lsex,lnum,lage,lmonth,ldepart,loffice;
	 public DoctorJPanel(){
		 this.setBorder(new TitledBorder("Doctor"));
		 this.setLayout(new GridLayout(10,1));
		 String str[][]={{"姓名","年龄","要删除的位置(第几行)"},{"男","女"}};
		 this.texts=new JTextField[str[0].length];
		 for(int i=0;i<this.texts.length;i++)
		 {  
			 this.add(this.texts[i]=new JTextField(str[0][i]));
		 }
		 JPanel panel=new JPanel(new GridLayout(1,2));
		 this.add(panel);
		 
		 ButtonGroup bgroup=new ButtonGroup();
		 this.radiobs=new JRadioButton[str[1].length];
		 for(int i=0;i<this.radiobs.length;i++)
		 {
			 panel.add(this.radiobs[i]=new JRadioButton(str[1][i]));
			 bgroup.add(this.radiobs[i]);
		 }
		 this.radiobs[0].setSelected(true); 
		 this.add(this.combox_dno=new JComboBox<String>(DoctorJPanel.num));
		 this.add(this.combox_depart=new JComboBox<String>(DoctorJPanel.depart));
		 this.add(this.combox_office=new JComboBox<String>(DoctorJPanel.office[0]));
		 this.combox_office.addActionListener(this);
		 this.combox_dno.addActionListener(this);
		 this.combox_depart.addActionListener(this);
		 }
		 public Doctor get()
		 {  String sex=radiobs[0].isSelected()?radiobs[0].getText():radiobs[1].getText();
			return new Doctor(texts[0].getText(),texts[1].getText(),texts[2].getText(),sex,(String)combox_dno.getSelectedItem(),(String)combox_depart.getSelectedItem(),(String)combox_office.getSelectedItem());
		}
		@Override
		public void actionPerformed(ActionEvent ev) 
		{
			int i=this.combox_depart.getSelectedIndex();
			if(office!=null&&i!=-1)
			{this.combox_office.removeAllItems();
			for(int j=0;j<DoctorJPanel.office[i].length;j++)
				this.combox_office.addItem(DoctorJPanel.office[i][j]);
			}
			
		}
		
		private void setJMenuBar(JMenuBar menubar) {
			// TODO Auto-generated method stub
			
		}
		
}

