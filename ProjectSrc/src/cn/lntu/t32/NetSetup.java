/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ϵͳ�趨�Ի���
 *	[ �ļ���      ]  : NetSetup.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ����ϵͳ������ݿ�ķ�ʽ������
 *	[ ����        ]  : �˿�
 *	[ �汾        ]  : 1.1
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
 *	[ ����˵��    ]  :
 *
 *	[## public NetSetup (JFrame frame) {} ]:
 *		����: �齨ϵͳ�趨�Ի���
 *
 *	[## private JPanel buildDBA() {} ]:
 *		����: �齨��ݿ����
 *
 *	[## private JPanel buildSYS() {} ]: 
 *		����: �齨ϵͳ�������
 *
 *	[## private void setupInit(int fg) {} ]:
 *		����: ���ñ��Ի���������Ĭ��ֵ
 *
 *	[## private void ceShi() {} ]:
 *		����: ���ԶԻ�����������ܷ���������ݿ�
 *
 *
 *  [ ��������    ]  : ��JDBC�����Ӳ���ʱ�����IP���ԣ����׳��ּ���������
 cn.lntu.t32##############################################################
 */
package com.sunshine.netsetup;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.*;

public class NetSetup 
extends JDialog 
implements ActionListener, MouseListener, KeyListener, ItemListener {
	
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
	JButton bt1, bt2, bt3, bt4;
	JRadioButton rb1, rb2, rb3;
	ButtonGroup bg;
	JComboBox cb1, cb2;
	JPanel stMain, dba, sys, bp;
	JTabbedPane tp;
	//INI�ļ��еļ���
	String ini[] = { "[SOFTINFO]", "UserName", "CompName", "[CONFIG]", "Soft_First",
					 "Default_Link" , "Default_Page", "Sys_style", "[NUMBER]",
					 "LodgName", "LodgNumber", "EngaName", "EngaNumber", "ChouName", 
					 "ChouNumber", "[HABITUS]", "Ck_Habitus", "Ck_Minute", "[PARTTIME]", 
					 "In_Room", "Out_Room1", "Out_Room2", "InsuDay", "ClockRoom1", 
					 "ClockRoom2", "InsuHour1", "InsuHour2", "[JDBC]", "DBFname", 
					 "UserID", "Password", "IP", "Access", "[ODBC]", "LinkName" };
	
	
	
	/**=======================================================================**
	 *		[## public NetSetup (JFrame frame) {} ]:		���캯��
	 *			����   ��JFrame ��ʾ���Ի���ĸ�����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���齨ϵͳ�趨�Ի���
	 **=======================================================================**
	 */
	public NetSetup (JFrame frame) {
		super (frame, "��������", true);
		
		bt1 = new TJButton ("pic/save.gif", " ��  �� ", "���浱ǰ������Ϣ");
		bt2 = new TJButton ("pic/exit.gif", " ��  �� ", "�����޸�");
		bt3 = new TJButton ("pic/recall.gif", " ��  �� ", "�Ե�ǰ�����������");
		bt4 = new TJButton ("pic/recall.gif", " ��  �� ", "�Ե�ǰ�����������");
		tp	= new JTabbedPane ();
		stMain = new JPanel (new BorderLayout ());
		bp     = new JPanel (new FlowLayout (FlowLayout.RIGHT, 10, 8));
		 
		bp.add (bt1);
		bp.add (bt2);
		bt1.setEnabled (false);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
		bt3.addMouseListener(this);
		bt4.addMouseListener(this);
		
		//������ǩ��
		sys = buildSYS ();
		dba = buildDBA ();
		tp.addTab ("��������", new ImageIcon ("pic/u05.gif"), sys);
		tp.addTab ("JDBC��������", new ImageIcon ("pic/setup.gif"), dba);
		
		//�����
		stMain.add ("Center", tp);
		stMain.add ("South", bp);
		
		//���INI�ļ�����Ĭ��ֵ
		setupInit(2);				//��һ�γ�ʼ��Ĭ��ֵʱ������Ϊ2
		
		this.setContentPane (stMain);
		pack ();
		this.setMinimumSize (new Dimension (579, 276));
		sunswing.setWindowCenter(this);
	}
	
	/**=======================================================================**
	 *		[## private JPanel buildDBA() {} ]:			������ǩ��DBA
	 *			����   ����
	 *			����ֵ ������һ��JPanel����
	 *			���η� ��private
	 *			����   ���齨��ݿ����
	 **=======================================================================**
	 */
	private JPanel buildDBA() {
		JLabel lb1, lb2, lb3, lb4, lb5;
		JPanel bd, dnet, dbf;
		JPanel jp1, jp2, jp3, jp4, jp5, jp6;
		
		lb1 = new JLabel (" �� �� �� IP :");
		lb2 = new JLabel ("�������˿�:");
		lb3 = new JLabel ("��ݿ����:");
		lb4 = new JLabel ("��¼�û���:");
		lb5 = new JLabel ("�� ¼ �� �� :");
		
		tf1 = new TJTextField (15);
		tf2 = new TJTextField (15);
		tf3 = new TJTextField (15);
		tf4 = new TJTextField (15);
		tf5 = new TJTextField (15);
		tf6 = new TJTextField ("���Խ��δ���� ...", 15);
		tf6.setEditable(false);			//���ò����ı��򲻿ɱ༭
		
		bd = new JPanel (new GridLayout(1, 2));
		dnet = new JPanel (new GridLayout(3, 1));
		dbf	 = new JPanel (new GridLayout(3, 1));
		
		jp1 = new JPanel ();
		jp2 = new JPanel ();
		jp3 = new JPanel ();
		jp4 = new JPanel ();
		jp5 = new JPanel ();
		jp6 = new JPanel ();
		
		//�Ӽ��̼���
		tf1.addKeyListener (this);
		tf2.addKeyListener (this);
		tf3.addKeyListener (this);
		tf4.addKeyListener (this);
		tf5.addKeyListener (this);
		
		//��ݿ��¼�������
		jp1.add (lb3);
		jp1.add (tf3);
		jp2.add (lb4);
		jp2.add (tf4);
		jp3.add (lb5);
		jp3.add (tf5);
		dbf.add (jp1);
		dbf.add (jp2);
		dbf.add (jp3);
		
		//���������������
		jp4.add (lb1);
		jp4.add (tf1);
		jp5.add (lb2);
		jp5.add (tf2);
		jp6.add (tf6);
		jp6.add (bt3);
		dnet.add (jp4);
		dnet.add (jp5);
		dnet.add (jp6);
		
		//�ӱ����
		dbf.setBorder (BorderFactory.createTitledBorder ("��ݿ��¼����" ));
		dnet.setBorder (BorderFactory.createTitledBorder ("������������" ));
		
		bd.add (dbf);
		bd.add (dnet);
		return bd;		//����һ��JPanel
	}
	
	/**=======================================================================**
	 *		[## private JPanel buildSYS() {} ]:			������ǩ��SYS
	 *			����   ����
	 *			����ֵ ������һ��JPanel����
	 *			���η� ��private
	 *			����   ���齨ϵͳ�������
	 **=======================================================================**
	 */
	private JPanel buildSYS() {
		JLabel lb1, lb2, lb3;
		JPanel bs, lt, rt, jp1, jp2, jp3, jp4, jp5, jp6;
		
		rb1 = new JRadioButton ("Windwos ϵͳ���");
		rb2 = new JRadioButton ("JAVA Ĭ�Ϸ��");
		rb3 = new JRadioButton ("JAVA �������");
		bg	= new ButtonGroup ();
		lb1 = new JLabel ("�� �� �� ʽ :");
		lb2 = new JLabel ("���Դ���:");
		lb3 = new JLabel ("ϵ ͳ �� ʼ ҳ Ϊ :");
		tf7 = new TJTextField (15);
		tf8 = new TJTextField ("���Խ��δ���� ...", 14);
		cb1	= new JComboBox ();
		cb2	= new JComboBox ();
		tf8.setEditable (false);
		
		bs	= new JPanel (new GridLayout(1, 2));
		lt	= new JPanel (new BorderLayout());
		rt	= new JPanel (new BorderLayout());
		jp1 = new JPanel ();
		jp2	= new JPanel (new GridLayout(2, 1));
		jp3	= new JPanel ();
		jp4	= new JPanel ();
		jp5	= new JPanel ();
		jp6	= new JPanel (new GridLayout(3, 1));
		
		bg.add (rb1);
		bg.add (rb2);
		bg.add (rb3);
		cb1.addItem ("  ODBC �� ��                      ");
		cb1.addItem ("  JDBC �� ��                      ");
		cb2.addItem ("  �� ׼ �� �� ��          ");
		cb2.addItem ("  �� ׼ ˫ �� ��          ");
		
		//���¼�����
		rb1.addActionListener (this);
		rb2.addActionListener (this);
		rb3.addActionListener (this);
		cb1.addItemListener (this);
		cb2.addItemListener (this);
		tf7.addKeyListener (this);
		
		//������
		jp1.add (lb1);
		jp1.add (cb1);
		jp3.add (lb2);
		jp3.add (tf7);
		jp4.add (tf8);
		jp4.add (bt4);
		jp2.add (jp3);
		jp2.add (jp4);
		lt.add ("North", jp1);
		lt.add ("Center", jp2);
		
		//�ұ����
		jp5.add (lb3);
		jp5.add (cb2);
		jp6.add (rb1);
		jp6.add (rb2);
		jp6.add (rb3);
		rt.add ("North", jp5);
		rt.add ("Center", jp6);
		
		bs.add (lt);
		bs.add (rt);
		
		//�ӱ����
		jp1.setBorder (BorderFactory.createTitledBorder ("��ݿ����ӷ�ʽ"));
		jp2.setBorder (BorderFactory.createTitledBorder ("ODBC��������"));
		jp5.setBorder (BorderFactory.createTitledBorder ("������ʼҳ"));
		jp6.setBorder (BorderFactory.createTitledBorder ("ϵͳ�������"));
		
		return bs;		//����һ��JPanel
	}
	
	/**=======================================================================**
	 *		[## private void setupInit(int fg) {} ]:	���INI�ļ�����Ĭ��ֵ
	 *			����   ��int fg������һ����־��
	 *					 ȡֵ0��1��ʱ��Ϊ���ӷ�ʽ�¼����õ�ˢ��;
	 *					 ȡֵ2��ʱ��Ϊͨ��INI�ļ����𻯸������Ĭ��ֵ��
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����ñ��Ի���������Ĭ��ֵ
	 **=======================================================================**
	 */
	private void setupInit(int fg) {
		int link = 0;			//ȡֵ 0��1
		int page = 0;			//ȡֵ 0��1
		char style = '2';		//ȡֵ 0��1��2
		tf1.setText (sunini.getIniKey (ini[31]));
		tf2.setText (sunini.getIniKey (ini[32]));
		tf3.setText (sunini.getIniKey (ini[28]));
		tf4.setText (sunini.getIniKey (ini[29]));
		tf5.setText (sunini.getIniKey (ini[30]));
		tf7.setText (sunini.getIniKey (ini[34]));
		//���Ĭ���趨
		style = sunini.getIniKey (ini[7]).charAt (0);
		switch(style) {
			case '0':
				rb1.setSelected (true);
				break;
			case '1':
				rb2.setSelected (true);
				break;
			case '2':
				rb3.setSelected ( true );
				break;
		}
		
		//���ӷ�ʽĬ��ֵ�趨
		if(fg == 2) {
			link = Integer.parseInt (sunini.getIniKey (ini[5]));
			cb1.setSelectedIndex (link);
		}
		else {	link = fg;	}

		//��ʼҳĬ���趨
		page = Integer.parseInt (sunini.getIniKey (ini[6]));
		cb2.setSelectedIndex (page);
		
		if(link == 0) {
			tf1.setEditable (false);
			tf2.setEditable (false);
			tf3.setEditable (false);
			tf4.setEditable (false);
			tf5.setEditable (false);
			tf7.setEditable (true);
			bt3.setEnabled (false);
			bt4.setEnabled (true);
		}
		else {
			tf1.setEditable (true);
			tf2.setEditable (true);
			tf3.setEditable (true);
			tf4.setEditable (true);
			tf5.setEditable (true);
			tf7.setEditable (false);
			bt3.setEnabled (true);
			bt4.setEnabled (false);
		}
	}
	
	//
	/**=======================================================================**
	 *		[## private void ceShi() {} ]:				��������
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����ԶԻ�����������ܷ���������ݿ�
	 **=======================================================================**
	 */
	private void ceShi() {
		int flag = cb1.getSelectedIndex();
		try {
			Statement ste = null;
			if(flag == 1) {		//JDBC���ӷ�ʽ
				String user = tf4.getText();
				String pwd  = tf5.getText();
				String ip   = tf1.getText();
				String acc  = tf2.getText();
				String dbf  = tf3.getText();
				String url  = "jdbc:microsoft:sqlserver://" + ip + ":" + acc + ";" + "databasename=" + dbf;
				//ע����
				Class.forName ("com.microsoft.jdbc.SQLServerDriver");
				//���һ������
				Connection conn = DriverManager.getConnection (url, user, pwd);
				//�����߼�����
				ste = conn.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				tf6.setText ("���Խ��: �ɹ����ӵ�������");
				ste.close();
				conn.close();
				//��INI��ֵ���뻺����
				sunini.setIniKey(ini[31], ip);
				sunini.setIniKey(ini[32], acc);
				sunini.setIniKey(ini[28], dbf);
				sunini.setIniKey(ini[29], user);
				sunini.setIniKey(ini[30], pwd);
			}
			else {
				//ע����										//JDBCODBC���ӷ�ʽ
				DriverManager.registerDriver (new sun.jdbc.odbc.JdbcOdbcDriver());
				//���һ������
				Connection conn = DriverManager.getConnection ("jdbc:odbc:" + tf7.getText());
				//�����߼�����
				ste = conn.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				tf8.setText ("���Խ��: �ɹ����ӵ�������");
				ste.close();
				conn.close();
				//��INI��ֵ���뻺����
				sunini.setIniKey(ini[34], tf7.getText());
			}//End if(flag == 1)
			sunini.setIniKey(ini[5], cb1.getSelectedIndex()+"");	//�������ӷ�ʽ����
			sunini.setIniKey(ini[6], cb2.getSelectedIndex()+"");	//������ʼҳ
			bt1.setEnabled ( true );
	    }
	    catch (Exception ex) {
	    	if(flag == 1)
	    		tf6.setText ("���Խ��  ����ʧ�� ...");
	    	else
	    		tf8.setText ("���Խ��  ����ʧ�� ...");
	    	bt1.setEnabled (false);
	    	JOptionPane.showMessageDialog (null, "�޷����ӵ������������������������������ ...", "����", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed (ActionEvent ae) {
		Object o = ae.getSource();
		if(o == rb1)
			sunini.setIniKey(ini[7], "0");				//�������ΪWindows ���
		else if(o == rb2)
				 sunini.setIniKey(ini[7], "1");			//�������ΪJAVA Ĭ�Ϸ��
			 else if(o == rb3)
			 		  sunini.setIniKey(ini[7], "2");	//�������ΪJAVA �������
			 	  else if(o == bt1) {
			 	  		   int fee = JOptionPane.showConfirmDialog(null, "�Ƿ�Ҫ���浱ǰ���� ��", "��ʾ", JOptionPane.YES_NO_OPTION);
			 	  		   if(fee == JOptionPane.YES_OPTION) {
			 	  		   	   sunini.saveIni(ini);				//����INI�ļ�
			 	  		   	   JOptionPane.showMessageDialog(null, "���Ѹ����ϵͳ���ã��������µ�¼ϵͳ ...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			 	  		   	   System.exit(0);
			 	  		   }//Ene if(fee == JOptionPane.YES_OPTION)
			 	  		   else
			 	  		       bt1.setEnabled(false);
			 	  	   }//End if(o == bt1)
			 	  	   else if(o == bt2)
			 	  	   			this.setVisible(false);			//����
			 	  	   		else if(o == bt3 || o==bt4)
			 	  	   				 ceShi();					//��������
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
		Object o = me.getSource ();
		if(o == bt1) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"����ǰ���ñ��浽INI�����ļ��С�������������������������  ");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�������������桡��������������������������������������   ");
		}else if(o == bt3) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"���Ե�ǰ���ӷ�ʽ�Ƿ���������ָ������ݿ⡡����������   ");
		}else if(o == bt4) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"���Ե�ǰ���ӷ�ʽ�Ƿ���������ָ������ݿ⡡����������   ");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + 
		"��ѡ������ ...   ����������������������������������������");
	}
	
	/**=======================================================================**
	 *			KeyListener ����
	 **=======================================================================**
	 */
	public void keyPressed (KeyEvent ke) {
		//���̰��¼���
	}
	
	public void keyReleased (KeyEvent ke) {
		//�����ͷż���
		bt1.setEnabled (false);
	}
	
	public void keyTyped (KeyEvent ke) {
		//�����ͼ���
	}
	
	
	/**=======================================================================**
	 *			ItemListener ����
	 **=======================================================================**
	 */
	public void itemStateChanged (ItemEvent ie) {
		if(ie.getSource() == cb1) {
			setupInit(cb1.getSelectedIndex());		//ˢ�¿ؼ���ֵ
			bt1.setEnabled(false);
		}//Endif
	}
	
}