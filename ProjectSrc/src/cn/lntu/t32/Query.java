/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : Ӫҵ��ѯģ��
 *	[ �ļ���      ]  : Setup.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��֯Ӫҵ��ѯ���ڼ�����
 *	[ ����        ]  : 
 *	[ �汾        ]  : 1.0
 *	----------------------------------------------------------------------------
 *	[ ��ע        ]  : 
 *	----------------------------------------------------------------------------
 *	[ �޸ļ�¼    ]  : 
 *
 *	[ ��  �� ]     [�汾]         [�޸���]         [�޸�����] 
 *	##--------------------------------------------------------------------------
 *  			 ��Ȩ����(c) 2006-2007,  SunshineSOFT Corporation
 *	--------------------------------------------------------------------------##
 *	
 *	[ ����˵��    ]  :			�����ڸ�����ͷ
 *	
 *  [ ��������    ]  : 
 *
 *############################################cn.lntu.t32################
 */
package com.sunshine.query;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.sunshine.sunsdk.sql.*;			//�������
import com.sunshine.sunsdk.system.*;
import com.sunshine.sunsdk.swing.*;
import com.sunshine.mainframe.HotelFrame;	//����������


public class Query 
extends JDialog 
implements ActionListener, MouseListener {
	
	private JLabel top;
	private JTabbedPane tp;
	private JPanel panelMain;
	
	//=========���ʵ���ѯ
	private JTextField tf11,tf12,tf13,tf1;
	private JButton bt11,bt12;
	private JCheckBox chk11,chk12;
	private JTable tb1;
	private DefaultTableModel dtm1;
	private JScrollPane sp1;
	
	//=========ȫ��������Ϣ��ѯ
	private JTextField tf21,tf2;
	private JButton bt21,bt22,bt23;
	private JTable tb2;
	private DefaultTableModel dtm2;
	private JScrollPane sp2;
	
	//=========�ڵ������Ѳ�ѯ
	private JTextField tf31,tf32,tf33,tf3;
	private JButton bt31,bt32;
	private JRadioButton rb31,rb32;
	private JTable tb3;
	private DefaultTableModel dtm3;
	private JScrollPane sp3;
	
	//=========��������Ѳ�ѯ
	private JTextField tf41,tf42,tf43,tf4;
	private JButton bt41,bt42;
	private JCheckBox chk41,chk42;
	private JComboBox cb41;
	private JTable tb4;
	private DefaultTableModel dtm4;
	private JScrollPane sp4;
	
	/**=======================================================================**
	 *		[## public Query(JFrame frame) {} ]: 		���캯��
	 *			����   ��JDialog�����ʾ���Ի���ĸ�����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���齨Ӫҵ��ѯģ��
	 **=======================================================================**
	 */
	public Query(JFrame frame) {
		super(frame,"Ӫҵ��ѯ",true);
		
		top = new JLabel();		//�ٿո�
		panelMain = new JPanel(new BorderLayout(0,5));
		tab();					//����ϵͳ������Ŀ��ǩ���
		addListener();			//�����¼�����
		panelMain.add("North",top);
		panelMain.add("Center",tp);
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (800,500));
		this.setMinimumSize (new Dimension (800,500));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
	}
	
	/**=======================================================================**
	 *		[## private void addListener() {} ]: 		���¼�����
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����¼�����
	 **=======================================================================**
	 */
	private void addListener() {
		bt11.addActionListener(this);		//�Ӷ�������
		bt12.addActionListener(this);
		bt21.addActionListener(this);
		bt22.addActionListener(this);
		bt23.addActionListener(this);
		bt31.addActionListener(this);
		bt32.addActionListener(this);
		bt41.addActionListener(this);
		bt42.addActionListener(this);
		bt11.addMouseListener(this);		//��������
		bt12.addMouseListener(this);
		bt21.addMouseListener(this);
		bt22.addMouseListener(this);
		bt23.addMouseListener(this);
		bt31.addMouseListener(this);
		bt32.addMouseListener(this);
		bt41.addMouseListener(this);
		bt42.addMouseListener(this);
	}
	
	/**=======================================================================**
	 *		[## private void tab() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ������ϵͳ������Ŀ��ǩ���
	 **=======================================================================**
	 */
	private void tab() {
		JPanel jp1,jp2,jp3,jp4;
		///////////////////////////////////////////////-----------ģ��ӿ�
		jp1 = pay();		    //���˵���ѯ
		jp2 = allCustomer();	//ȫ��������Ϣ��ѯ
		jp3 = stay();			//�ڵ������Ѳ�ѯ
		jp4 = leave();			//��������Ѳ�ѯ
		//////////////////////////////////////////////////////////////////
		tp = new JTabbedPane();
		tp.addTab("���ʵ���ѯ", new ImageIcon("pic/u04.gif"), jp1);
		tp.addTab("ȫ��������Ϣ��ѯ", new ImageIcon("pic/u02.gif"), jp2);
		tp.addTab("�ڵ������Ѳ�ѯ", new ImageIcon("pic/u03.gif"), jp3);
		tp.addTab("��������Ѳ�ѯ", new ImageIcon("pic/v04.gif"), jp4);
	}
	
	/**=======================================================================**
	 *		[## private JPanel pay() {} ]: 
	 *			����   ����
	 *			����ֵ ��JPanel
	 *			���η� ��private
	 *			����   �����ʵ���ѯ
	 **=======================================================================**
	 */
	private JPanel pay() {
		
		tf11 = new TJTextField (13);
		tf12 = new TJTextField (13);
		tf13 = new TJTextField (13);
		tf1  = new JTextField ("����״̬��Ϣ");
		tf1.setHorizontalAlignment (JTextField.CENTER);
		tf1.setBackground(new Color(199,183,143));
		tf1.setBorder(new LineBorder(new Color(87,87,47)));
		tf1.setEditable(false);
		
		bt11 = new TJButton ("pic/find.gif", "�顡ѯ", "��ѯ���ʵ���Ϣ");
		bt12 = new TJButton ("pic/b1.gif", "ˢ����", "ˢ�½��ʵ���Ϣ");
		
		chk11 = new JCheckBox(" ����ʱ�䣺");
		chk12 = new JCheckBox();
		
		dtm1 = new DefaultTableModel();
		tb1  = new JTable(dtm1);
		sp1  = new JScrollPane(tb1);
		////////////////////////��д���
		String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,b.c_name ��������,b.foregift ����Ѻ��,a.money ʵ�ս��,a.chk_time ����ʱ��,a.remark ��ע "+
						 "from checkout as a,livein as b where a.delmark = 0 and a.in_no = b.in_no";
		sunsql.initDTM(dtm1,sqlCode);
		
		JLabel lb1,lb4,lb5,lb8,lb9,lb10,lb11;
		lb1 = new JLabel("��ʼʱ�䡡");
		lb4 = new JLabel("���� ��ֹʱ�䡡");
		lb5 = new JLabel("��");
		lb8 = new JLabel("����/�����/�ʵ��ţ�    ");
		lb9 = new JLabel("����");
		lb10 = new JLabel("��  ");
		lb11 = new JLabel("��");
		
		JPanel panelPay,pn,pn1,pn2,pc; 
		panelPay = new JPanel(new BorderLayout());
		pn		 = new JPanel(new GridLayout(2,1,0,0));
		pn1	     = new JPanel(new FlowLayout());
		pn2	     = new JPanel(new FlowLayout());
		pc		 = new JPanel(new BorderLayout());
		
		pn1.add(chk11);
		pn1.add(lb1);
		pn1.add(tf11);
		pn1.add(lb4);
		pn1.add(tf12);
		pn1.add(lb5);
		pn2.add(chk12);
		pn2.add(lb8);
		pn2.add(tf13);
		pn2.add(lb9);
		pn2.add(bt11);
		pn2.add(lb10);
		pn2.add(bt12);
		pn2.add(lb11);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.setBorder(BorderFactory.createTitledBorder(""));
		
		pc.add("North",tf1);
		pc.add(sp1);
		pc.setBorder(BorderFactory.createTitledBorder(""));
		
		panelPay.add("North",pn);
		panelPay.add(pc);
		
		return panelPay;
	}
	
	/**=======================================================================**
	 *		[## private JPanel allCustomer() {} ]: 
	 *			����   ����
	 *			����ֵ ��JPanel
	 *			���η� ��private
	 *			����   ��ȫ��������Ϣ��ѯ
	 **=======================================================================**
	 */
	private JPanel allCustomer() {
		
		tf21 = new TJTextField (10);
		tf2  = new JTextField ("����������Ϣ");
		tf2.setHorizontalAlignment (JTextField.CENTER);
		tf2.setBackground(new Color(199,183,143));
		tf2.setBorder(new LineBorder(new Color(87,87,47)));
		tf2.setEditable(false);
		
		bt21 = new TJButton ("pic/find.gif", "��ѯ", "��ѯ������Ϣ");
		bt22 = new TJButton ("pic/b1.gif", "ˢ��", "ˢ�±�����Ϣ");
		bt23 = new TJButton ("pic/recall.gif", "��������", "����������Ϣ");
		
		dtm2 = new DefaultTableModel();
		tb2  = new JTable(dtm2);
		sp2  = new JScrollPane(tb2);
		////////////////////////��д���
		String sqlCode = "select m_id ��Ա���,r_no �����,c_name ��������,sex �Ա�,zj_type ֤������,zj_no ֤�����,renshu ����,foregift Ѻ��,"+
						 "days Ԥס����,statemark ��ǰ״̬,in_time ��סʱ��,chk_time ����ʱ��,chk_no ���㵥�� from livein where delmark = 0";
		sunsql.initDTM(dtm2,sqlCode);
		
		JLabel lb1,lb2,lb3,lb4;
		lb1 = new JLabel("��������/֤�����/����ţ�");
		lb2 = new JLabel("      ");
		lb3 = new JLabel("   ");
		lb4 = new JLabel("   ");
		
		JPanel panelAC,pn,pc; 
		panelAC = new JPanel(new BorderLayout());
		pn	    = new JPanel();
		pc		= new JPanel(new BorderLayout());
		
		pn.add(lb1);
		pn.add(tf21);
		pn.add(lb2);
		pn.add(bt21);
		pn.add(lb3);
		pn.add(bt22);
		pn.add(lb4);
		pn.add(bt23);
		pn.setBorder(BorderFactory.createTitledBorder(""));
		
		pc.add("North",tf2);
		pc.add(sp2);
		pc.setBorder(BorderFactory.createTitledBorder(""));
		
		panelAC.add("North",pn);
		panelAC.add(pc);
		
		return panelAC;
	}
	
	/**=======================================================================**
	 *		[## private JPanel stay() {} ]: 
	 *			����   ����
	 *			����ֵ ��JPanel
	 *			���η� ��private
	 *			����   ���ڵ������Ѳ�ѯ
	 **=======================================================================**
	 */
	private JPanel stay() {
		
		tf31 = new TJTextField (13);
		tf32 = new TJTextField (13);
		tf33 = new TJTextField (13);
		tf3  = new JTextField ("�ڵ�������");
		tf3.setHorizontalAlignment (JTextField.CENTER);
		tf3.setBackground(new Color(199,183,143));
		tf3.setBorder(new LineBorder(new Color(87,87,47)));
		tf3.setEditable(false);
		
		bt31 = new TJButton ("pic/find.gif", "�顡ѯ", "��ѯ�ڵ�������");
		bt32 = new TJButton ("pic/b1.gif", "ˢ����", "ˢ���ڵ�������");
		
		rb31 = new JRadioButton("��סʱ�䣺",true);
		rb32 = new JRadioButton("��  ��  �ţ�");
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb31);
		bg.add(rb32);
		
		dtm3 = new DefaultTableModel();
		tb3  = new JTable(dtm3);
		sp3  = new JScrollPane(tb3);
		////////////////////////��д���
		String sqlCode = "select a.r_no �����,b.r_type ��������,b.price ����,c.discount �ۿ۱���,c.dis_price �ۺ󵥼�,(c.price - c.dis_price) �Żݽ��,a.in_time ��סʱ�� "+
						 "from livein as a,roomtype as b,customertype as c where a.statemark = '�������' and a.delmark = 0 and a.r_type_id = b.id and a.c_type_id = c.id and a.r_type_id = c.dis_attr";
		sunsql.initDTM(dtm3,sqlCode);
		
		JLabel lb1,lb4,lb8,lb9;
		lb1 = new JLabel("��ʼʱ�䡡");
		lb4 = new JLabel("��     ����ֹʱ�䡡");
		lb8 = new JLabel(" ��  ��  ��  ��   ");
		lb9 = new JLabel("��  ��   ");
		
		JPanel panelStay,pn,pn1,pn2,pc; 
		panelStay = new JPanel(new BorderLayout());
		pn		  = new JPanel(new GridLayout(2,1,0,0));
		pn1	      = new JPanel();
		pn2	      = new JPanel();
		pc		  = new JPanel(new BorderLayout());
		
		pn1.add(rb31);
		pn1.add(lb1);
		pn1.add(tf31);
		pn1.add(lb4);
		pn1.add(tf32);
		pn2.add(rb32);
		pn2.add(tf33);
		pn2.add(lb8);
		pn2.add(bt31);
		pn2.add(lb9);
		pn2.add(bt32);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.setBorder(BorderFactory.createTitledBorder(""));
		
		pc.add("North",tf3);
		pc.add(sp3);
		pc.setBorder(BorderFactory.createTitledBorder(""));
		
		panelStay.add("North",pn);
		panelStay.add(pc);
		
		return panelStay;
	}
	
	/**=======================================================================**
	 *		[## private JPanel leave() {} ]: 
	 *			����   ����
	 *			����ֵ ��JPanel
	 *			���η� ��private
	 *			����   ����������Ѳ�ѯ
	 **=======================================================================**
	 */
	private JPanel leave() {
		
		tf41 = new TJTextField (13);
		tf42 = new TJTextField (13);
		tf43 = new TJTextField (7);
		tf4  = new JTextField ("���������");
		tf4.setHorizontalAlignment (JTextField.CENTER);
		tf4.setBackground(new Color(199,183,143));
		tf4.setBorder(new LineBorder(new Color(87,87,47)));
		tf3.setEditable(false);
		
		bt41 = new TJButton ("pic/find.gif", "�顡ѯ", "��ѯ���������");
		bt42 = new TJButton ("pic/b1.gif", "ˢ����", "ˢ�����������");
		
		chk41 = new JCheckBox("����ʱ�䣺");
		chk42 = new JCheckBox("��ѯ������");
		cb41  = new JComboBox();
		cb41.addItem("�����ʵ���");
		cb41.addItem("�������");
		
		dtm4 = new DefaultTableModel();
		tb4  = new JTable(dtm4);
		sp4  = new JScrollPane(tb4);
		////////////////////////��д���
		String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,c.r_type ��������,c.price ����,d.discount �ۿ۱���,d.dis_price ʵ�ս��,(d.price - d.dis_price) �Żݽ��,a.chk_time ����ʱ�� "+
						 "from checkout as a,livein as b,roomtype as c,customertype as d where a.delmark = 0 and b.statemark = '�ѽ���' and a.in_no = b.in_no and b.r_type_id = c.id and b.c_type_id = d.id and b.r_type_id = d.dis_attr";
		sunsql.initDTM(dtm4,sqlCode);
		
		
		JLabel lb1,lb2,lb4,lb5,lb6,lb7,lb8,lb9,lb10;
		lb1 = new JLabel("��ʼʱ�䡡");
		lb4 = new JLabel(" ����  ��ֹʱ�䡡");
		lb5 = new JLabel("��");
		lb8 = new JLabel("    �ؼ��֣�");
		lb9 = new JLabel("      ");
		lb10 = new JLabel(" ");
		lb2  = new JLabel("   ");
		
		JPanel panelLeave,pn,pn1,pn2,pc; 
		panelLeave = new JPanel(new BorderLayout());
		pn		   = new JPanel(new GridLayout(2,1,0,0));
		pn1	       = new JPanel();
		pn2	       = new JPanel();
		pc		   = new JPanel(new BorderLayout());
		
		pn1.add(chk41);
		pn1.add(lb1);
		pn1.add(tf41);
		pn1.add(lb4);
		pn1.add(tf42);
		pn1.add(lb5);
		pn2.add(chk42);
		pn2.add(cb41);
		pn2.add(lb8);
		pn2.add(tf43);
		pn2.add(lb9);
		pn2.add(bt41);
		pn2.add(lb10);
		pn2.add(bt42);
		pn2.add(lb2);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.setBorder(BorderFactory.createTitledBorder(""));
		
		pc.add("North",tf4);
		pc.add(sp4);
		pc.setBorder(BorderFactory.createTitledBorder(""));
		
		panelLeave.add("North",pn);
		panelLeave.add(pc);
		
		return panelLeave;
	}
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o==bt11) {
			//========================================================���ʵ���ѯ
			if(chk11.isSelected()) {
				if(!chk12.isSelected()) {//**************ֻѡ�����ʱ���ѯ
					String start,end;
					start = tf11.getText();
					end = tf12.getText();
					if(!suntools.isDate(start)||!suntools.isDate(end)) {
						//�����ڲ��Ϸ�
						JOptionPane.showMessageDialog(null,"������������,����ȷ����(yyyy-mm-dd)");
						tf11.setText("");
						tf12.setText("");
						tf13.setText("");
						tf11.requestFocus();
					}else {//�����ںϷ�
						start = tf11.getText()+" 00:00:00";
						end = tf12.getText()+" 23:59:59";
						String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,b.c_name ��������,b.foregift ����Ѻ��,a.money ʵ�ս��,a.chk_time ����ʱ��,a.remark ��ע "+
										 "from checkout as a,livein as b where a.delmark = 0 and a.in_no = b.in_no and a.chk_time between '"+start+"' and '"+end+"'";
						sunsql.initDTM(dtm1,sqlCode);
						tf13.setText("");
					}
				}else {                 //***************�������ϲ�ѯ
					String start = tf11.getText();
					String end = tf12.getText();
					if(!suntools.isDate(start)||!suntools.isDate(end)) {
						//�����ڲ��Ϸ�
						JOptionPane.showMessageDialog(null,"������������,����ȷ����(yyyy-mm-dd)");
						tf11.setText("");
						tf12.setText("");
						tf11.requestFocus();
					}else {//�����ںϷ�
						String nrc = tf13.getText();
						String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,b.c_name ��������,b.foregift ����Ѻ��,a.money ʵ�ս��,a.chk_time ����ʱ��,a.remark ��ע "+
										 "from checkout as a,livein as b where a.delmark = 0 and a.in_no = b.in_no and  (a.chk_no like '%"+nrc+"%' or b.r_no like '%"+nrc+"%' or b.c_name like '%"+nrc+"%') and a.chk_time between '"+start+"' and '"+end+"'";
						sunsql.initDTM(dtm1,sqlCode);
					}
					
				}
			}else {
				if(!chk12.isSelected()) {//****************����ȫ��ѡ��
					JOptionPane.showMessageDialog(null,"��ѡ���ѯ��ʽ!");
					tf11.setText("");
					tf12.setText("");
					tf13.setText("");
					tf11.requestFocus();
				}else {                 //*****************ֻѡ������/����/�ʵ��Ų�ѯ
					String nrc = tf13.getText();
					String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,b.c_name ��������,b.foregift ����Ѻ��,a.money ʵ�ս��,a.chk_time ����ʱ��,a.remark ��ע "+
									 "from checkout as a,livein as b where a.delmark = 0 and a.in_no = b.in_no and  (a.chk_no like '%"+nrc+"%' or b.r_no like '%"+nrc+"%' or b.c_name like '%"+nrc+"%')";
					sunsql.initDTM(dtm1,sqlCode);
					tf11.setText("");	
					tf12.setText("");	
				}
			}
		}else if(o==bt12) {
			//===========================================================���ʵ�ˢ��
			String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,b.c_name ��������,b.foregift ����Ѻ��,a.money ʵ�ս��,a.chk_time ����ʱ��,a.remark ��ע "+
							 "from checkout as a,livein as b where a.delmark = 0 and a.in_no = b.in_no";
			sunsql.initDTM(dtm1,sqlCode);
			tf11.setText("");
			tf12.setText("");
			tf13.setText("");
			chk11.setSelected(false);
			chk12.setSelected(false);
		}else if(o==bt21) {
			//===========================================================ȫ�����Ͳ�ѯ
			String nzr = tf21.getText();
			String sqlCode = "select m_id ��Ա���,r_no �����,c_name ��������,sex �Ա�,zj_type ֤������,zj_no ֤�����,renshu ����,foregift Ѻ��,"+
							 "days Ԥס����,statemark ��ǰ״̬,in_time ��סʱ��,chk_time ����ʱ��,chk_no ���㵥�� from livein where delmark = 0 and (c_name like '%"+nzr+"%' or zj_no like '%"+nzr+"%' or r_no like '%"+nzr+"%')";
			sunsql.initDTM(dtm2,sqlCode);
		}else if(o==bt22) {
			//===========================================================ȫ������ˢ��
			String sqlCode = "select m_id ��Ա���,r_no �����,c_name ��������,sex �Ա�,zj_type ֤������,zj_no ֤�����,renshu ����,foregift Ѻ��,"+
							 "days Ԥס����,statemark ��ǰ״̬,in_time ��סʱ��,chk_time ����ʱ��,chk_no ���㵥�� from livein where delmark = 0";
			sunsql.initDTM(dtm2,sqlCode);
			tf21.setText("");
		}else if(o==bt23) {
			//===========================================================��������
			GregorianCalendar gc = new GregorianCalendar();
			String year = gc.get (GregorianCalendar.YEAR) + "";
			//Ϊ�·ݲ�'0'
			String month = gc.get (GregorianCalendar.MONTH) + 1 + "";
			if( month.length() == 1)
				month = "0" + month;
			//Ϊ�첹'0'
			String day = gc.get (GregorianCalendar.DAY_OF_MONTH) + "";
			if( day.length () == 1)
				day = "0" + day;
			String in_time = year+"-"+month+"-"+day;
			
			String nzr = tf21.getText();
			String sqlCode = "select m_id ��Ա���,r_no �����,c_name ��������,sex �Ա�,zj_type ֤������,zj_no ֤�����,renshu ����,foregift Ѻ��,"+
							 "days Ԥס����,statemark ��ǰ״̬,in_time ��סʱ��,chk_time ����ʱ��,chk_no ���㵥�� from livein where delmark = 0 and (c_name like '%"+nzr+"%' or zj_no like '%"+nzr+"%' or r_no like '%"+nzr+"%') and in_time = '"+in_time+"'";
			sunsql.initDTM(dtm2,sqlCode);
		}else if(o==bt31) {
			//===========================================================�ڵ���Ͳ�ѯ
			if(rb31.isSelected()) {//*********************����סʱ���ѯ
				String start = tf31.getText();
				String end = tf32.getText();
				if(!suntools.isDate(start)||!suntools.isDate(end)) {
					//�����ڲ��Ϸ�
					JOptionPane.showMessageDialog(null,"������������,����ȷ����(yyyy-mm-dd)");
					tf31.setText("");
					tf32.setText("");
					tf33.setText("");
					tf31.requestFocus();
				}else {//�����ںϷ�
					start = tf31.getText()+" 00:00:00";
					end = tf32.getText()+" 23:59:59";	
					String sqlCode = "select a.r_no �����,b.r_type ��������,b.price ����,c.discount �ۿ۱���,c.dis_price �ۺ󵥼�,(c.price - c.dis_price) �Żݽ��,a.in_time ��סʱ�� "+
									 "from livein as a,roomtype as b,customertype as c where a.statemark = '�������' and a.delmark = 0 and a.r_type_id = b.id and a.c_type_id = c.id and a.r_type_id = c.dis_attr and a.in_time between '"+start+"' and '"+end+"'";
					sunsql.initDTM(dtm3,sqlCode);
					tf33.setText("");
					}
			}else if(rb32.isSelected()) {//****************������Ų�ѯ
				String r_no = tf33.getText();
				String sqlCode = "select a.r_no �����,b.r_type ��������,b.price ����,c.discount �ۿ۱���,c.dis_price �ۺ󵥼�,(c.price - c.dis_price) �Żݽ��,a.in_time ��סʱ�� "+
								 "from livein as a,roomtype as b,customertype as c where a.statemark = '�������' and a.delmark = 0 and a.r_type_id = b.id and a.c_type_id = c.id and a.r_type_id = c.dis_attr and a.r_no like '%"+r_no+"%'";
				sunsql.initDTM(dtm3,sqlCode);
				tf31.setText("");
				tf32.setText("");
			}
		}else if(o==bt32) {
			//===========================================================�ڵ����ˢ��
			String sqlCode = "select a.r_no �����,b.r_type ��������,b.price ����,c.discount �ۿ۱���,c.dis_price �ۺ󵥼�,(c.price - c.dis_price) �Żݽ��,a.in_time ��סʱ�� "+
							 "from livein as a,roomtype as b,customertype as c where a.statemark = '�������' and a.delmark = 0 and a.r_type_id = b.id and a.c_type_id = c.id and a.r_type_id = c.dis_attr";
			sunsql.initDTM(dtm3,sqlCode);
			tf31.setText("");
			tf32.setText("");
			tf33.setText("");
			rb31.setSelected(true);
		}else if(o==bt41) {
			//===========================================================�����Ͳ�ѯ
			if(chk41.isSelected()) {
				if(!chk42.isSelected()) {//**************ֻѡ�����ʱ���ѯ
					String start = tf41.getText();
					String end = tf42.getText();
					if(!suntools.isDate(start)||!suntools.isDate(end)) {
						//�����ڲ��Ϸ�
						JOptionPane.showMessageDialog(null,"������������,����ȷ����(yyyy-mm-dd)");
						tf41.setText("");
						tf42.setText("");
						tf43.setText("");
						tf41.requestFocus();
						cb41.setSelectedIndex(0);
					}else {//�����ںϷ�
						start = tf41.getText()+" 00:00:00";
						end = tf42.getText()+" 23:59:59";
						String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,c.r_type ��������,c.price ����,d.discount �ۿ۱���,d.dis_price ʵ�ս��,(d.price - d.dis_price) �Żݽ��,a.chk_time ����ʱ�� "+
										 "from checkout as a,livein as b,roomtype as c,customertype as d where a.delmark = 0 and b.statemark = '�ѽ���' and a.in_no = b.in_no and b.r_type_id = c.id and b.c_type_id = d.id and b.r_type_id = d.dis_attr and a.chk_time between '"+start+"' and '"+end+"'";
						sunsql.initDTM(dtm4,sqlCode);
						tf43.setText("");
						chk41.setSelected(false);
						chk42.setSelected(false);
						cb41.setSelectedIndex(0);
					}
				}else {                 //***************�������ϲ�ѯ
					String start = tf41.getText();
					String end = tf42.getText();
					if(!suntools.isDate(start)||!suntools.isDate(end)) {
						//�����ڲ��Ϸ�
						JOptionPane.showMessageDialog(null,"������������,����ȷ����(yyyy-mm-dd)");
						tf41.setText("");
						tf42.setText("");
						tf41.requestFocus();
					}else {//�����ںϷ�
						String nrc = tf43.getText();
						if(cb41.getSelectedIndex()==0) {//�����ʵ���
							String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,c.r_type ��������,c.price ����,d.discount �ۿ۱���,d.dis_price ʵ�ս��,(d.price - d.dis_price) �Żݽ��,a.chk_time ����ʱ�� "+
											 "from checkout as a,livein as b,roomtype as c,customertype as d where a.delmark = 0 and b.statemark = '�ѽ���' and a.in_no = b.in_no and b.r_type_id = c.id and b.c_type_id = d.id and b.r_type_id = d.dis_attr and a.chk_no like '%"+nrc+"%' and a.chk_time between '"+start+"' and '"+end+"'";
							sunsql.initDTM(dtm4,sqlCode);
						}else if(cb41.getSelectedIndex()==1) {//�������
							String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,c.r_type ��������,c.price ����,d.discount �ۿ۱���,d.dis_price ʵ�ս��,(d.price - d.dis_price) �Żݽ��,a.chk_time ����ʱ�� "+
											 "from checkout as a,livein as b,roomtype as c,customertype as d where a.delmark = 0 and b.statemark = '�ѽ���' and a.in_no = b.in_no and b.r_type_id = c.id and b.c_type_id = d.id and b.r_type_id = d.dis_attr and b.r_no like '%"+nrc+"%' and a.chk_time between '"+start+"' and '"+end+"'";
							sunsql.initDTM(dtm4,sqlCode);
						}
					}
					
				}
			}else {
				if(!chk42.isSelected()) {//****************����ȫ��ѡ��
					JOptionPane.showMessageDialog(null,"��ѡ���ѯ��ʽ!");
					tf41.setText("");
					tf42.setText("");
					tf43.setText("");
					cb41.setSelectedIndex(0);
				}else {                 //*****************ֻѡ�񷿺�/�ʵ��Ų�ѯ
					String nrc = tf43.getText();
					if(cb41.getSelectedIndex()==0) {//�����ʵ���
						String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,c.r_type ��������,c.price ����,d.discount �ۿ۱���,d.dis_price ʵ�ս��,(d.price - d.dis_price) �Żݽ��,a.chk_time ����ʱ�� "+
										 "from checkout as a,livein as b,roomtype as c,customertype as d where a.delmark = 0 and b.statemark = '�ѽ���' and a.in_no = b.in_no and b.r_type_id = c.id and b.c_type_id = d.id and b.r_type_id = d.dis_attr and a.chk_no like '%"+nrc+"%'";
						sunsql.initDTM(dtm4,sqlCode);
					}else if(cb41.getSelectedIndex()==1) {//�������
						String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,c.r_type ��������,c.price ����,d.discount �ۿ۱���,d.dis_price ʵ�ս��,(d.price - d.dis_price) �Żݽ��,a.chk_time ����ʱ�� "+
										 "from checkout as a,livein as b,roomtype as c,customertype as d where a.delmark = 0 and b.statemark = '�ѽ���' and a.in_no = b.in_no and b.r_type_id = c.id and b.c_type_id = d.id and b.r_type_id = d.dis_attr and b.r_no like '%"+nrc+"%'";
						sunsql.initDTM(dtm4,sqlCode);
					}
					tf41.setText("");
					tf42.setText("");
				}
			}
		}else if(o==bt42) {
			//������ˢ��
			String sqlCode = "select a.chk_no �ʵ���,b.r_no �����,c.r_type ��������,c.price ����,d.discount �ۿ۱���,d.dis_price ʵ�ս��,(d.price - d.dis_price) �Żݽ��,a.chk_time ����ʱ�� "+
						 	 "from checkout as a,livein as b,roomtype as c,customertype as d where a.delmark = 0 and b.statemark = '�ѽ���' and a.in_no = b.in_no and b.r_type_id = c.id and b.c_type_id = d.id and b.r_type_id = d.dis_attr";
			sunsql.initDTM(dtm4,sqlCode);
			tf41.setText("");
			tf42.setText("");
			tf43.setText("");
			chk41.setSelected(false);
			chk42.setSelected(false);
			cb41.setSelectedIndex(0);
		}
	}
	
	/**=======================================================================**
	 *			MouseListener ����
	 **=======================================================================**
	 */
	public void mouseClicked (MouseEvent me) {
	}

	public void mousePressed (MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered (MouseEvent me) {		//����ƽ���ʾ
		Object o = me.getSource();
		if(o==bt11) {
			//���ʵ���ѯ
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯ���ʵ���Ϣ��      ���������������������������������� ��");
		}else if(o==bt12) {
			//���ʵ�ˢ��
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ˢ�½��ʵ���Ϣ��      ���������������������������������� ��");
		}else if(o==bt21) {
			//ȫ�����Ͳ�ѯ
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯȫ��������Ϣ      ���������������������������������� ��");
		}else if(o==bt22) {
			//ȫ������ˢ��
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ˢ��ȫ��������Ϣ      ���������������������������������� ��");
		}else if(o==bt23) {
			//ȫ�����͹���
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯ����������Ϣ      ���������������������������������� ��");
		}else if(o==bt31) {
			//�ڵ���Ͳ�ѯ
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯ�ڵ������Ϣ      ���������������������������������� ��");
		}else if(o==bt32) {
			//�ڵ����ˢ��
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ˢ���ڵ������Ϣ      ���������������������������������� ��");
		}else if(o==bt41) {
			//�����Ͳ�ѯ
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯ��������Ϣ      ���������������������������������� ��");
		}else if(o==bt42) {
			//������ˢ��
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ˢ����������Ϣ      ���������������������������������� ��");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}
}