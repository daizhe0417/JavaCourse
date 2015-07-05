/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ϵͳ����ģ��
 *	[ �ļ���      ]  : Setup.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��֯ϵͳ���ô���
 *	[ ����        ]  : 
 *	[ �汾        ]  : 1.1
 *	----------------------------------------------------------------------------
 *	[ ��ע        ]  : 
 *	----------------------------------------------------------------------------
 *	[ �޸ļ�¼    ]  : 
 *
 *	##--------------------------------------------------------------------------
 *  			 ��Ȩ����(c) 2006-2007,  SunshineSOFT Corporation
 *	--------------------------------------------------------------------------##
 *	
 *	[ ����˵��    ]  :			�����ڸ�����ͷ
 *	
 *  [ ��������    ]  : 
 *
 *####################################################cn.lntu.t32########
 */
package com.sunshine.setup;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;			//�������
import com.sunshine.sunsdk.system.*;
import com.sunshine.sunsdk.swing.*;
import com.sunshine.mainframe.HotelFrame;	//����������


public class Setup 
extends JDialog 
implements ActionListener, MouseListener {
	
	private JLabel top,bott;
	private JTabbedPane tp;
	private JPanel panelMain;
	//=========������Ŀ����
	private JTable tb11, tb12;
	private DefaultTableModel dtm11, dtm12;		//���������б�//������Ϣ�б�
	 
	private JScrollPane sp11,sp12;
	private JComboBox cb11,cb12;
			    //��������,�ɹ�/����״̬
	private JButton bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20;
			      //���, �޸�,ɾ��LX,�ۿ�,����,�������,ɾ��,�޸�FJ,����,ɸѡ
	private JTextField tf11;
	//=========�ͻ���������
	private JTable tb21,tb22;
	private DefaultTableModel dtm21,dtm22;
			         //�ͻ������б�,����Ѵ����б�
	private JScrollPane sp21,sp22;
	private JButton bt21, bt22, bt23, bt24;
			      //���, �޸�,ɾ��LX,���Ѵ���
	//=========����Ա����
	private JTable tb31;
	private DefaultTableModel dtm31;
						//����Ա�б�
	private JScrollPane sp31;
	private JComboBox cb31;//�û���
	private JPasswordField tf31, tf32, tf33;
			 	   		//ԭ����,������,ȷ������
	private JRadioButton rb31,   rb32,   rb33,   rb34,   rb35;
				//���û��Ǽ�, �޸�����,ɾ���û�,��ͨ�û�,����Ա
	private JButton bt31, bt32, bt33;
	 		     // �Ǽ�, �޸�, ɾ��
	//=========�Ʒ�����
	private JTextField tf41, tf42, tf43, tf44, tf45, tf46, tf47; 
	private JCheckBox ck;
	private JButton bt41, bt42;
	
	//��ʾ��Ϣ
	String msg0 = "��ȷ��Ҫɾ���ڱ����ѡ�е�������Ŀ��";
	String msg1 = "������Ӧ�ı����ѡ����Ŀ���ٵ�ɾ��� ...";
	//��־��Ϣ
	String journal;
	//INI�ļ��еļ���
	String ini[] = { "[SOFTINFO]", "UserName", "CompName", "[CONFIG]", "Soft_First",
					 "Default_Link" , "Default_Page", "Sys_style", "[NUMBER]",
					 "LodgName", "LodgNumber", "EngaName", "EngaNumber", "ChouName", 
					 "ChouNumber", "[HABITUS]", "Ck_Habitus", "Ck_Minute", "[PARTTIME]", 
					 "In_Room", "Out_Room1", "Out_Room2", "InsuDay", "ClockRoom1", 
					 "ClockRoom2", "InsuHour1", "InsuHour2", "[JDBC]", "DBFname", 
					 "UserID", "Password", "IP", "Access", "[ODBC]", "LinkName" };
	
	//ʵ����ģ��
	//========================================================================//
		AddRoomType			art	 = new AddRoomType (this);		//��ӷ�������
		ModiRoomType		mrt  = new ModiRoomType(this);		//��ӷ�������
		AddCustomerType		act  = new AddCustomerType(this); 	//��ӿͻ�����
		ModiCustomerType	mct  = new ModiCustomerType(this);	//��ӿͻ�����
		Discount			dis  = new Discount(this);			//�ۿ�����
		AddRoomInfo 		ari  = new AddRoomInfo(this);		//������ӷ���
		AddRoomInfos		aris = new AddRoomInfos(this);		//������ӷ���
		ModiRoomInfo		mri  = new ModiRoomInfo(this);		//�޸ķ�����Ϣ
	//========================================================================//
	
	/**=======================================================================**
	 *		[## public Setup(JFrame frame) {} ]: 		���캯��
	 *			����   ��JDialog�����ʾ���Ի���ĸ�����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���齨ϵͳ����ģ��
	 **=======================================================================**
	 */
	public Setup(JFrame frame) {
		super (frame, "ϵͳ����", true);
		top = new JLabel();		//�ٿո�
		panelMain = new JPanel(new BorderLayout(0,10));
		tab();					//����ϵͳ������Ŀ��ǩ���
		addListener();			//�����¼�����
		panelMain.add("North",top);
		panelMain.add("Center",tp);
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (718,508));
		this.setMinimumSize (new Dimension (718,508));
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
		bt13.addActionListener(this);
		bt14.addActionListener(this);
		bt15.addActionListener(this);
		bt16.addActionListener(this);
		bt17.addActionListener(this);
		bt18.addActionListener(this);
		bt19.addActionListener(this);
		bt20.addActionListener(this);
		bt21.addActionListener(this);
		bt22.addActionListener(this);
		bt23.addActionListener(this);
		bt24.addActionListener(this);
		bt31.addActionListener(this);
		bt32.addActionListener(this);
		bt33.addActionListener(this);
		bt41.addActionListener(this);
		bt42.addActionListener(this);
		rb31.addActionListener(this);		//����Ա���ٷ�Χ����
		rb32.addActionListener(this);
		rb33.addActionListener(this);
		tf41.addActionListener(this);		//�Ʒ������ı���Ӽ���
		tf42.addActionListener(this);
		tf43.addActionListener(this);
		tf44.addActionListener(this);
		tf45.addActionListener(this);
		tf46.addActionListener(this);
		bt11.addMouseListener(this);		//��������
		bt12.addMouseListener(this);
		bt13.addMouseListener(this);
		bt14.addMouseListener(this);
		bt15.addMouseListener(this);
		bt16.addMouseListener(this);
		bt17.addMouseListener(this);
		bt18.addMouseListener(this);
		bt19.addMouseListener(this);
		bt20.addMouseListener(this);
		bt21.addMouseListener(this);
		bt22.addMouseListener(this);
		bt23.addMouseListener(this);
		bt24.addMouseListener(this);
		bt31.addMouseListener(this);
		bt32.addMouseListener(this);
		bt33.addMouseListener(this);
		bt41.addMouseListener(this);
		bt42.addMouseListener(this);
	}
	
	/**=======================================================================**
	 *		[## private void tab() {} ]: 		����ϵͳ������Ŀ��ǩ���
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ������ϵͳ������Ŀ��ǩ���
	 **=======================================================================**
	 */
	private void tab() {
		JPanel jp1,jp2,jp3,jp4;
		///////////////////////////////////////////////-------ģ�����ӿ�
		jp1 = fangjian();		//������Ŀ����
		jp2 = kehu();			//�ͻ���������
		jp3 = caozuo();			//����Ա����
		jp4 = jiFei();			//�Ʒ�����
		//////////////////////////////////////////////////////////////////
		tp = new JTabbedPane();
		tp.addTab("������Ŀ����", new ImageIcon("pic/u01.gif"), jp1);
		tp.addTab("�ͻ���������", new ImageIcon("pic/u02.gif"), jp2);
		tp.addTab("����Ա����", new ImageIcon("pic/u03.gif"), jp3);
		tp.addTab("�Ʒ�����", new ImageIcon("pic/u04.gif"), jp4);
	}
	
	/**=======================================================================**
	 *		[## private JPanel fangjian() {} ]: 
	 *			����   ����
	 *			����ֵ ��JPanel
	 *			���η� ��private
	 *			����   ��������Ŀ����
	 **=======================================================================**
	 */
	private JPanel fangjian() {
		
		dtm11 = new DefaultTableModel();
		tb11  = new JTable(dtm11);
		sp11  = new JScrollPane(tb11);
		dtm12 = new DefaultTableModel();
		tb12  = new JTable(dtm12);
		sp12  = new JScrollPane(tb12);
		
		JPanel pfangjian,pTop,pBott,pTn,pTc,pBn,pBc,pTcc,pTcs,pBcc,pBcs;
		pfangjian = new JPanel(new GridLayout(2,1,0,5));
		pTop	  = new JPanel(new BorderLayout());
		pBott	  = new JPanel(new BorderLayout());
		pTn		  = new JPanel();					//���ñ��水ť��...
		pTc		  = new JPanel(new BorderLayout());	//���÷��������б?�ĸ���ť
		pBn		  = new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));//���������б�
		pBc		  = new JPanel(new BorderLayout());	//���÷�����Ϣ�б?�ĸ���ť
		pTcc	  = new JPanel(new GridLayout(1,1));//���÷��������б�
		pTcs	  = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));//�����ĸ���ť
		pBcc	  = new JPanel(new GridLayout(1,1));//���÷�����Ϣ�б�
		pBcs	  = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));//�����ĸ���ť
		
		//���水ť�� ...
		JLabel lb1,lb2,lb3;
		lb1 = new JLabel("���ʺ󷿼�״̬��Ϊ:    ");
		lb2 = new JLabel("          ���ʺ�");
		lb3 = new JLabel("���Ӻ��Ϊ�ɹ�״̬        ");
		tf11 = new TJTextField(sunini.getIniKey(ini[17]),5);		//���INI�ļ����ֵ
		tf11.setHorizontalAlignment(JTextField.RIGHT);
		cb12 = new JComboBox();
		cb12.addItem("  �ɹ�״̬     ");
		cb12.addItem("  ����״̬     ");							//���INI�ļ����ֵ
		cb12.setSelectedIndex(Integer.parseInt(sunini.getIniKey(ini[16])));
		bt19 = new TJButton ("pic/save.gif", "   ��  ��   ", "��������");
		pTn.add(lb1);
		pTn.add(cb12);
		pTn.add(lb2);
		pTn.add(tf11);
		pTn.add(lb3);
		pTn.add(bt19);
		pTn.setBorder(BorderFactory.createTitledBorder(""));
		
		//���������б?�ĸ���ť
		bt11 = new TJButton ("pic/new.gif", "�������", "��ӷ�������");
		bt12 = new TJButton ("pic/modi0.gif", "�޸�����", "�޸ķ�������");
		bt13 = new TJButton ("pic/del.gif", "ɾ������", "ɾ�������");
		bt14 = new TJButton ("pic/modi3.gif", "���Ѵ���", "���÷�����ۿ�");
		pTcc.add(sp11);
		pTcs.add(bt11);
		pTcs.add(bt12);
		pTcs.add(bt13);
		pTcs.add(bt14);
		pTc.add(pTcc);
		pTc.add("South",pTcs);
		pTc.setBorder(BorderFactory.createTitledBorder("��������"));
		
		//����ϰ벿��
		pTop.add("North",pTn);
		pTop.add(pTc);
		
		
		//�����б�
		JLabel lb0 = new JLabel("���������͹���:  ");
		cb11 = new JComboBox();
		bt20 = new TJButton ("pic/choose1.gif", "ɸ  ѡ", "ɸѡ������Ϣ");
		bt20.setBorderPainted(false);
		bt20.setFocusPainted(false);
		pBn.add(lb0);
		pBn.add(cb11);
		pBn.add(bt20);
		
		buildDTM11();				//��ʼ�����������б�������б��ֵ
		buildDTM12("");				//��ʼ��������б�
		
		
		//������Ϣ�б?�ĸ���ť
		bt15 = new TJButton ("pic/new.gif", "�������", "��ӵ���������Ϣ");
		bt16 = new TJButton ("pic/book.gif", "�������", "������ӷ�����Ϣ");
		bt17 = new TJButton ("pic/del.gif", "ɾ���", "ɾ��ĳ��������Ϣ");
		bt18 = new TJButton ("pic/modi0.gif", "�޸ķ���", "�޸�ĳ��������Ϣ");
		pBcc.add(sp12);
		pBcs.add(bt15);
		pBcs.add(bt16);
		pBcs.add(bt17);
		pBcs.add(bt18);
		pBc.add(pBcc);
		pBc.add("South",pBcs);
		pBc.setBorder ( BorderFactory.createTitledBorder ("������Ϣ") );
		
		//����°벿��
		pBott.add("North",pBn);
		pBott.add(pBc);
		
		//���
		pfangjian.add(pTop);
		pfangjian.add(pBott);
		
		return pfangjian;
	}
	
	//
	/**=======================================================================**
	 *		[## private void buildDTM11() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����������б��ComboBox
	 **=======================================================================**
	 */
	private void buildDTM11() {
		String sqlCode2 = "select pk,sysmark,id,foregift,r_type ��������," +
		"price Ԥ�赥��,cl_price " + "'�ӵ�۸�/Сʱ'" + ",bed ��λ����,cl_room "+
		"'�ܷ��ӵ�Ʒ�(Y/N)' from roomtype where delmark = 0";
		sunsql.initDTM(dtm11,sqlCode2);
		tb11.removeColumn(tb11.getColumn("pk"));
		tb11.removeColumn(tb11.getColumn("sysmark"));
		tb11.removeColumn(tb11.getColumn("foregift"));
		tb11.removeColumn(tb11.getColumn("id"));
		
		String sqlCode1 = "select r_type from roomtype where delmark = 0";
		sunsql.initJComboBox(cb11,sqlCode1);
		cb11.addItem("��ʾȫ��������Ϣ");
		cb11.setSelectedIndex(cb11.getItemCount() - 1);		//������ʾȫ��
	}
	
	/**=======================================================================**
	 *		[## private void buildDTM12(String rType) {} ]: 
	 *			����   ��String rTypeΪˢ�²���
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ��������Ϣ��
	 **=======================================================================**
	 */
	public void buildDTM12(String rType) {
		String sqlCode = "select a.pk,a.r_type_id,a.id �����,b.r_type ��������," +
		"a.state ����״̬,a.location ��������,a.r_tel ����绰 from roominfo as a," +
		"roomtype as b where a.r_type_id = b.id and a.delmark = 0 " + rType;
		sunsql.initDTM(dtm12,sqlCode);
		tb12.removeColumn(tb12.getColumn("pk"));
		tb12.removeColumn(tb12.getColumn("r_type_id"));
	}
	
	/**=======================================================================**
	 *		[## private JPanel kehu() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ���ͻ���������
	 **=======================================================================**
	 */
	private JPanel kehu() {
		
		dtm21 = new DefaultTableModel();
		tb21  = new JTable(dtm21);
		sp21  = new JScrollPane(tb21);
		dtm22 = new DefaultTableModel();
		tb22  = new JTable(dtm22);
		sp22  = new JScrollPane(tb22);
		
		JPanel pkehu,p1,p2,p1b,p2b;
		p1 = new JPanel(new BorderLayout());//�ͻ��������
		p2 = new JPanel(new BorderLayout());//����Ѵ������
		p1b = new JPanel(new FlowLayout(FlowLayout.CENTER,30,5));//�ͻ����Ͱ�ť���
		p2b = new JPanel();	//����Ѵ��۰�ť���
		
		buildDTM21();		//��ʼ���ͻ����ͱ�
		bt21 = new TJButton ("pic/new.gif", "�������", "��ӿͻ�����");
		bt22 = new TJButton ("pic/modi0.gif", "�޸�����", "�޸Ŀͻ�����");
		bt23 = new TJButton ("pic/del.gif", "ɾ������", "ɾ��ͻ�����");
		p1b.add(bt21);
		p1b.add(bt22);
		p1b.add(bt23);
		p1.add(sp21);
		p1.add("South",p1b);
		p1.setBorder ( BorderFactory.createTitledBorder ("�ͻ�����") );
		
		buildDTM22();		//��ʼ��������۱�
		bt24 = new TJButton ("pic/modi3.gif", "   ����Ѵ���  ", "���÷�����ۿ�");
		p2b.add(bt24);
		p2.add(sp22);
		p2.add("South",p2b);
		p2.setBorder ( BorderFactory.createTitledBorder ("����Ѵ���") );
		
		pkehu = new JPanel(new GridLayout(2,1,0,10));
		pkehu.add(p1);
		pkehu.add(p2);
		
		return pkehu;
	}
	
	/**=======================================================================**
	 *		[## private JPanel caozuo() {} ]: 
	 *			����   ����
	 *			����ֵ ��JPanel
	 *			���η� ��private
	 *			����   ������Ա����
	 **=======================================================================**
	 */
	private JPanel caozuo() {
		JPanel panelMain,panelMain1,panelTop,panelBott1,panelBott2;
		
		dtm31 = new DefaultTableModel();
		tb31  = new JTable(dtm31);
		sp31  = new JScrollPane(tb31);
		
		panelMain = new JPanel(new GridLayout(2,1,0,5));
		panelMain1 = new JPanel (new BorderLayout (0,3));		//�°����
		panelTop   = new JPanel(new GridLayout(1,1));			//����Ա�б����
		panelBott1 = new JPanel(new GridLayout (1, 2));//��ϸ��Ϣ,������Χ,����Ȩ�����
		panelBott2 = new JPanel(new FlowLayout (FlowLayout.CENTER,20,5));//��ť���
		
		bt31 = new TJButton ("pic/new.gif", " ��  �� ", "���浱ǰ�û���Ϣ", false);
		bt32 = new TJButton ("pic/key.gif", " ��  �� ", "�޸�����", false);
		bt33 = new TJButton ("pic/del.gif", " ɾ  �� ", "ɾ��ǰ�û�", false);
		
		bt32.setEnabled(false);
		bt33.setEnabled(false);
		
		panelBott2.add (bt31);
		panelBott2.add (bt32);
		panelBott2.add (bt33);
		
		//����������Top_Left���
		panelBott1.add (bottLeft());
		
		//����������Top_Right���
		panelBott1.add (bottRight());
		
		panelMain1.add ("Center", panelBott1);
		panelMain1.add ("South", panelBott2);
		
		buildDTM31();						//��ʼ������Ա��Ϣ��
		panelTop.add(sp31);
		panelTop.setBorder(BorderFactory.createTitledBorder("����Ա�б�"));
		panelMain.add(panelTop);
		panelMain.add(panelMain1);
		
		return panelMain;
	}
	
	/**=======================================================================**
	 *		[## private JPanel topLeft () {} ]: 		����Top_Left���
	 *			����   ����
	 *			����ֵ ��JPanel��ʾ��֯�õ����
	 *			���η� ��private
	 *			����   ���齨�Ի�����û�����������
	 **=======================================================================**
	 */
	private JPanel bottLeft () {
		JLabel lb1, lb2, lb3, lb4;
		JPanel tl, jp1, jp2;
		
		lb1 = new JLabel ("��  ��  ��:    ");
		lb2 = new JLabel ("ԭ  ��  ��:    ");
		lb3 = new JLabel ("��  ��  ��:    ");
		lb4 = new JLabel ("ȷ������:    ");
		
		tf31 = new TJPasswordField (17);
		tf32 = new TJPasswordField (17);
		tf33 = new TJPasswordField (17);
		
		
		tl	= new JPanel ();
		jp1 = new JPanel (new GridLayout (4, 1, 0, 18));
		jp2 = new JPanel (new GridLayout (4, 1, 0, 9));
		
		//��ʼ���û���������
		cb31 = new JComboBox ();
		cb31.setEditable (true);
		
		tf31.setEditable (false);
		
		//�������
		jp1.add (lb1);
		jp1.add (lb2);
		jp1.add (lb3);
		jp1.add (lb4);
		jp2.add (cb31);
		jp2.add (tf31);
		jp2.add (tf32);
		jp2.add (tf33);
		
		tl.add (jp1);
		tl.add (jp2);
		tl.setBorder (BorderFactory.createTitledBorder (" ��ϸ��Ϣ "));
		return tl;
	}
	
	/**=======================================================================**
	 *		[## private JPanel topRight () {} ]: 		����Top_Right���
	 *			����   ����
	 *			����ֵ ��JPanel��ʾ��֯�õ����
	 *			���η� ��private
	 *			����   ���齨�Ի���������
	 **=======================================================================**
	 */
	private JPanel bottRight () {
		JPanel tr, jp1, jp2;
		ButtonGroup bg1,bg2;
		
		rb31 = new JRadioButton ("���û��Ǽ�", true);
		rb32 = new JRadioButton ("�޸�����");
		rb33 = new JRadioButton ("ɾ���û�");
		rb34 = new JRadioButton ("��ͨ����Ա", true);
		rb35 = new JRadioButton ("�� �� Ա");
		
		bg1 = new ButtonGroup ();
		bg2 = new ButtonGroup ();
		
		tr = new JPanel (new GridLayout (2, 1));
		jp1 = new JPanel ();
		jp2 = new JPanel ();
		
		//�ӵ�ѡ��	������Χ
		bg1.add (rb31);
		bg1.add (rb32);
		bg1.add (rb33);
		
		//�ӵ�ѡ��	����Ȩ��
		bg2.add (rb34);
		bg2.add (rb35);
		
		jp1.add (rb31);
		jp1.add (rb32);
		jp1.add (rb33);
		
		jp2.add (rb34);
		jp2.add (rb35);
		
		jp1.setBorder (BorderFactory.createTitledBorder (" ������Χ "));
		jp2.setBorder (BorderFactory.createTitledBorder (" ����Ȩ�� "));
		
		tr.add (jp1);
		tr.add (jp2);
		
		return tr;
	}
	
	/**=======================================================================**
	 *		[## private void buildDTM21() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ���ͻ������б�
	 **=======================================================================**
	 */
	private void buildDTM21() {
		String sqlCode = "select pk,id �ͻ����ͱ��,id,c_type �ͻ�����,discount " +
		"���۱��� from customertype where delmark = 0 and dis_attr = '�����ۿ�' and id!='SYSMARK'";
		sunsql.initDTM(dtm21,sqlCode);
		tb21.removeColumn(tb21.getColumn("pk"));
		tb21.removeColumn(tb21.getColumn("id"));
	}
	
	/**=======================================================================**
	 *		[## private void buildDTM22() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ��������۷��б�
	 **=======================================================================**
	 */
	private void buildDTM22() {
		String sqlCode = "select pk,sysmark,id,foregift,r_type ��������,price Ԥ�赥�� from roomtype where delmark = 0";
		sunsql.initDTM(dtm22,sqlCode);
		tb22.removeColumn(tb22.getColumn("pk"));
		tb22.removeColumn(tb22.getColumn("id"));
		tb22.removeColumn(tb22.getColumn("sysmark"));
		tb22.removeColumn(tb22.getColumn("foregift"));
	}
	

	/**=======================================================================**
	 *		[## private void buildDTM31() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ������Ա�б�
	 **=======================================================================**
	 */
	private void buildDTM31() {
		String sqlCode = "select pk,userid �û���¼ID,puis �û�Ȩ�� from pwd where delmark = 0";
		sunsql.initDTM(dtm31,sqlCode);
		tb31.removeColumn(tb31.getColumn("pk"));
		
		sunsql.initJComboBox (cb31, "select userid from pwd where delmark=0");
	}
	
	/**=======================================================================**
	 *		[## private JPanel jiFei() {} ]: 
	 *			����   ����
	 *			����ֵ ��JPanel
	 *			���η� ��private
	 *			����   ���Ʒ�����
	 **=======================================================================**
	 */
	private JPanel jiFei() {
		JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, 
			   lb11, lb12, lb13, lb14, lb15, lb16;
		//�������λ���
		JPanel panelJF, jfTop, jfLeft, jfRight, jfBott;
		JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9;
		//�����ǩ
		lb1 = new JLabel("�������˿���ʱ����");
		lb2 = new JLabel("��֮���µ�һ�쿪ʼ�Ʒ�");
		lb3 = new JLabel("���������˷�ʱ����");
		lb4 = new JLabel("��֮��Ƽ������Զ�׷�Ӱ���");
		lb5 = new JLabel("���������˷�ʱ����");
		lb6 = new JLabel("��֮��Ƽ������Զ�׷��һ��");
		lb7 = new JLabel("����������");
		lb8 = new JLabel("���ӿ�ʼ�Ʒ�");
		lb9 = new JLabel("�������ٰ�");
		lb10 = new JLabel("Сʱ�Ʒѣ�С�����ʱ��İ���ʱ��Ʒ�");
		lb11 = new JLabel("����������һСʱ������");
		lb12 = new JLabel("���ӵĲ��ְ�1Сʱ�Ʒ�");
		lb13 = new JLabel("������������������");
		lb14 = new JLabel("���ӵĲ��ְ���Сʱ�Ʒ�");
		lb15 = new JLabel("ע�������ý����ڱ�׼�Ʒѵ��ӵ㷿����������");
		lb16 = new JLabel("����");
		lb15.setForeground(new Color(255, 138, 0));
		//��ʼ����ʱ�Ʒ�����
		tf41 = new TJTextField(sunini.getIniKey("In_Room"),    5);
		tf42 = new TJTextField(sunini.getIniKey("Out_Room1"),  5);
		tf43 = new TJTextField(sunini.getIniKey("Out_Room2"),  5);
		tf44 = new TJTextField(sunini.getIniKey("ClockRoom1"), 5);
		tf45 = new TJTextField(sunini.getIniKey("ClockRoom2"), 5);
		tf46 = new TJTextField(sunini.getIniKey("InsuHour1"),  5);
		tf47 = new TJTextField(sunini.getIniKey("InsuHour2"),  5);
		//�����ı����Ҷ���
		tf41.setHorizontalAlignment(JTextField.RIGHT);
		tf42.setHorizontalAlignment(JTextField.RIGHT);
		tf43.setHorizontalAlignment(JTextField.RIGHT);
		tf44.setHorizontalAlignment(JTextField.RIGHT);
		tf45.setHorizontalAlignment(JTextField.RIGHT);
		tf46.setHorizontalAlignment(JTextField.RIGHT);
		tf47.setHorizontalAlignment(JTextField.RIGHT);
		//����һ���Ƿ�һ��Ƽ�
		ck	 = new JCheckBox("��סʱ�䲻��һ��İ�һ��Ʒ�");
		if(sunini.getIniKey("InsuDay").equals("1")) {
			ck.setSelected(true);
		}
		bt41 = new TJButton ("pic/save.gif", " ��  �� ", "���浱ǰ����");
		bt42 = new TJButton ("pic/exit.gif", " ��  �� ", "����������");
		
		panelJF = new JPanel(new BorderLayout());		//�Ʒ������
		jfTop	= new JPanel(new GridLayout(2, 1));		//���������
		jfLeft	= new JPanel(new GridLayout(4, 1));		//�Ʒ������
		jfRight	= new JPanel(new GridLayout(5, 1));		//�Ʒ������
		jfBott	= new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 4));//�������
		
		jp1		= new JPanel(new FlowLayout(FlowLayout.LEFT));	//��ߵ�����õ���
		jp2		= new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3		= new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp4		= new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp5		= new JPanel(new FlowLayout(FlowLayout.LEFT));	//�ұߵ�����õ���
		jp6		= new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp7		= new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp8		= new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp9		= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		//����������
		jp1.add(lb1);
		jp1.add(tf41);
		jp1.add(lb2);
		jp2.add(lb3);
		jp2.add(tf42);
		jp2.add(lb4);
		jp3.add(lb5);
		jp3.add(tf43);
		jp3.add(lb6);
		jp4.add(lb16);				//�ٿո�
		jp4.add(ck);
		
		jfLeft.add(jp1);
		jfLeft.add(jp2);
		jfLeft.add(jp3);
		jfLeft.add(jp4);
		
		//�����ұ����
		jp5.add(lb7);
		jp5.add(tf44);
		jp5.add(lb8);
		jp6.add(lb9);
		jp6.add(tf45);
		jp6.add(lb10);
		jp7.add(lb11);
		jp7.add(tf46);
		jp7.add(lb12);
		jp8.add(lb13);
		jp8.add(tf47);
		jp8.add(lb14);
		jp9.add(lb15);
		
		jfRight.add(jp5);
		jfRight.add(jp6);
		jfRight.add(jp7);
		jfRight.add(jp8);
		jfRight.add(jp9);
		
		//��֯�����?һ��
		jfTop.add(jfLeft);
		jfTop.add(jfRight);
		
		//��֯�������
		jfBott.add(bt41);
		jfBott.add(bt42);
		
		//���������
		panelJF.add("Center", jfTop);
		panelJF.add("South", jfBott);
		
		jfLeft.setBorder(BorderFactory.createTitledBorder("��ͨ�����׼�Ʒ�"));
		jfRight.setBorder ( BorderFactory.createTitledBorder ("�ӵ㷿��׼�Ʒ�") );
		return panelJF;
	}
	
	/**=======================================================================**
	 *		[## private boolean initMrt() {} ]: 
	 *			����   ����
	 *			����ֵ ��boolean
	 *			���η� ��private
	 *			����   ������ݸ��޸ķ������ʹ���
	 **=======================================================================**
	 */
	private boolean initMrt() {
		int row = tb11.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "�����������ͱ���ָ���������ͣ�" +
			"����ִ���޸Ĳ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		ModiRoomType.tf0.setText(dtm11.getValueAt(row,2) + "");		//���ͱ��
		ModiRoomType.tf1.setText(dtm11.getValueAt(row,4) + "");		//�������
		ModiRoomType.tf2.setText(dtm11.getValueAt(row,7) + "");		//��λ����
		ModiRoomType.tf3.setText(dtm11.getValueAt(row,5) + "");		//Ԥ�赥��
		ModiRoomType.tf4.setText(dtm11.getValueAt(row,3) + "");		//Ԥ��Ѻ��
		ModiRoomType.tf5.setText(dtm11.getValueAt(row,6) + "");		//�ӵ�Ʒ�
		String cl_room = dtm11.getValueAt(row, 8) + "";
		if(cl_room.equals("Y")) {
			ModiRoomType.chk.setSelected(true);			//�����ṩ�ӵ����
		}
		else {
			ModiRoomType.chk.setSelected(false);		//�������ṩ�ӵ����
			ModiRoomType.tf5.setEnabled(false);			//�����ӵ�ƷѲ�����
		}
		return true;
	}
	
	/**=======================================================================**
	 *		[## private boolean initMri() {} ]: 
	 *			����   ����
	 *			����ֵ ��boolean
	 *			���η� ��private
	 *			����   ������ݸ��޸ķ�����Ϣ����
	 **=======================================================================**
	 */
	private boolean initMri() {
		int row = tb12.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "�������淿����Ϣ����ָ������ţ�" +
			"����ִ���޸Ĳ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		ModiRoomInfo.tf1.setText(dtm12.getValueAt(row, 2) + "");	//������
		ModiRoomInfo.tf2.setText(dtm12.getValueAt(row, 5) + "");	//��������
		ModiRoomInfo.tf3.setText(dtm12.getValueAt(row, 6) + "");	//����绰
		ModiRoomInfo.pk = dtm12.getValueAt(row, 0) + "";			//��õ�ǰ�е�PK
		try {
			ResultSet rs = sunsql.executeQuery("select r_type from roomtype " +
			"where delmark=0 and id='" + dtm12.getValueAt(row,1) + "'");
			rs.next();
			ModiRoomInfo.cb1.setSelectedItem(rs.getString(1));		//��������
	    }
	    catch (Exception ex) {
	    	System.out.println ("ModiRoomInfo.initMri(): Modi false");
	    }//End try
	    return true;
	}
	
	/**=======================================================================**
	 *		[## private boolean initMct() {} ]: 
	 *			����   ����
	 *			����ֵ ��boolean
	 *			���η� ��private
	 *			����   ������ݸ��޸Ŀͻ����ʹ���
	 **=======================================================================**
	 */
	private boolean initMct() {
		int row = tb21.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "�����������ͱ���ָ���ͻ����ͣ�" +
			"����ִ���޸Ĳ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		ModiCustomerType.tf1.setText(dtm21.getValueAt(row,1) + "");		//�ͻ����ͱ��
		ModiCustomerType.tf2.setText(dtm21.getValueAt(row,3) + "");		//�ͻ��������
		ModiCustomerType.tf3.setText(dtm21.getValueAt(row,4) + "");		//�ͻ������ۿ�
		ModiCustomerType.pk = dtm21.getValueAt(row, 0) + "";			//��õ�ǰ�е�PK
		return true;
	}
	
	/**=======================================================================**
	 *		[## private boolean initDis(JTable dtb, DefaultTableModel ddtm) {} ]: 
	 *			����   ��JTable �� DefaultTableModel Ϊ��Ŀ���ۿ��еı�
	 *			����ֵ ��boolean
	 *			���η� ��private
	 *			����   ������ݸ�������ô���
	 **=======================================================================**
	 */
	private boolean initDis(JTable dtb, DefaultTableModel ddtm) {
		int row = dtb.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "������Ӧ�б���ָ���������ͣ�" +
			"���ܽ��д������ò���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		try {
			Discount.rt = ddtm.getValueAt(row, 2) + "";			//��÷�����
			ResultSet rs = sunsql.executeQuery("select discount from customertype " +
			"where id='SYSMARK' and dis_attr='" + ddtm.getValueAt(row, 2) + "'");
			rs.next();
			int temp = rs.getInt(1);
			if(temp == 10){
				Discount.cb1.setSelectedIndex(1);	//��ͨ���Ͳ�����ѡ��
				Discount.tf1.setEnabled(false);
			}else {
				Discount.cb1.setSelectedIndex(0);	//��ͨ���ʹ���ѡ��
				Discount.tf1.setEnabled(true);
			}//Endif
			Discount.tf1.setText(temp + "");		//��ͨ���͵��ۿ�
	    }
	    catch (Exception ex) {
	    }
		Discount.lb1.setText(ddtm.getValueAt(row, 4) + "");	//�����������
		Discount.lb2.setText(ddtm.getValueAt(row, 5) + "");	//����۸�
		//��ʼ������DTM
		sunsql.initDTM(Discount.dtm, "select c_type �ͻ��ȼ�,discount �����ۿ�, " +
		"dis_price �ۿۼ۸� from customertype where delmark=0 and dis_attr='" + 
		ddtm.getValueAt(row, 2) + "' and id!='SYSMARK'");
		//��ʼ����Ա�ȼ�ComboBox
		sunsql.initJComboBox(Discount.cb2, "select c_type from customertype where " + 
		"delmark=0 and id!='SYSMARK' and dis_attr='" + ddtm.getValueAt(row, 2) + "'");
		
		return true;
	}
	
	/**=======================================================================**
	 *		[## private boolean delInfo (String tName, DefaultTableModel delDtm, int dr[], String m) {} ]: 
	 *			����   ��Sring tName	��ʾҪִ��ɾ��ı���
	 *					 DTM delDtm		��ʾ�������DTM
	 *					 int dr[]		Ҫ��ִ��ɾ�������
	 *					 String m		��ʾ��Ϣ
	 *			����ֵ ��boolean
	 *			���η� ��private
	 *			����   ���������͡�������Ϣ�Ϳͻ����͵�ɾ����
	 **=======================================================================**
	 */
	private boolean delInfo (String tName, DefaultTableModel delDtm, int dr[], String m) {
		int rowCount = dr.length;
		int r =0;							//DTM��ָ��
		
		if(tName.equals ("roomtype")) {		//���ɾ������ͣ���ɾ���뷿��������صķ�����Ϣ��ͻ��ۿ�����
			rowCount = rowCount * 3;
		}//Endif
			
		if(rowCount > 0) {					//�ж�ѡ���¼��
			int isDel = JOptionPane.showConfirmDialog (null, m, "��ʾ", JOptionPane.YES_NO_OPTION);
			if(isDel == JOptionPane.YES_OPTION) {
				String sqlCode[] = new String[rowCount];
				//���SQL���
				for (int i = 0; i < rowCount; i++) {
					sqlCode[i] = "update " + tName +" set delmark=1 where pk=" + delDtm.getValueAt(dr[r], 0) + " and id='" + delDtm.getValueAt(dr[r],2) + "'";
					if(tName.equals ("roomtype")) {		//���ɾ������ͣ���ͬʱɾ����ط�����Ϣ
						i++;
						sqlCode[i] = "update roominfo set delmark=1 where id='sunhotel' or r_type_id='" + delDtm.getValueAt(dr[r],2) + "'";
						i++;
						sqlCode[i] = "update customertype set delmark=1 where id='sunhotel' or dis_attr='" + delDtm.getValueAt(dr[r],2) + "'";
					}
					r++;		//DTM��ָ���1
			    }//Endfor
			    //������ģʽִ��SQL�����, ȷ��������ȷ, ����ֵΪ�ɹ�ִ��SQL��������
			    isDel = sunsql.runTransaction(sqlCode);		
			    if(isDel != rowCount) {			//���ɹ�ִ�е����� = ���鳤�ȣ����ʾ���³ɹ�
			    	String mm = "��ִ�е� [ " + (isDel + 1) + " ] ����¼��ɾ�����ʱ���?����п��ܱ������ն��޸�\n���������粻ͨ�� ...";
			    	JOptionPane.showMessageDialog(null, mm, "����",JOptionPane.ERROR_MESSAGE);
			    	//����ʧ�ܣ�����false
			    	return false;
			    }//Endif
			    return true;		//���³ɹ�������true
			}//Endif
		}
		else 						//���û��ѡ�м�¼������ʾһ��
			JOptionPane.showMessageDialog(null, msg1, "��ʾ",JOptionPane.INFORMATION_MESSAGE);
		return false;
	}
	
	/**=======================================================================**
	 *		[## private void umAdd () {} ]: 		��Ӳ���
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ������µ��û�ID
	 **=======================================================================**
	 */
	private void umAdd () {
		String pwd1 = String.valueOf(tf32.getPassword());
		String pwd2 = String.valueOf(tf33.getPassword());
		String pu	= "��ͨ����Ա";			//�û�Ȩ��
		if(!pwd1.equals (pwd2)) {			//�������벻���
			JOptionPane.showMessageDialog (null, "�������[ ������ ] �� [ ȷ������ ] " +
			"����ȷ������������ ...", "����",JOptionPane.ERROR_MESSAGE);
			return;
		}//Endif
		String umName = cb31.getEditor ().getItem () + "";//����û���
		try {
			ResultSet rs = sunsql.executeQuery ("select userid from pwd where delmark=0 " +
			"and userid='" + umName + "'");
			
			int isID = sunsql.recCount(rs);
			if(isID > 0){					//��ǰҪ������û����Ƿ����
				JOptionPane.showMessageDialog (null, "����ԱID [ " + umName + " ] �Ѵ��ڣ�" +
				"���������� ...", "����",JOptionPane.ERROR_MESSAGE);
				return;
			}//Endif
			if(rb35.isSelected())			//����Ƿ��ǹ���ԱȨ��
				pu = "����Ա";
			long pk = sunsql.getPrimaryKey();//�ӷ���������
			//������ݿ�
			isID = sunsql.executeUpdate("insert into pwd(pk,userid,pwd,puis) values(" + pk + 
			",'" + umName + "','" + pwd1 + "','" + pu + "')");
			
			if(isID == 0) {
				JOptionPane.showMessageDialog (null, "��Ӳ���ʧ�ܣ��������������Ƿ��� " +
				"...", "����",JOptionPane.ERROR_MESSAGE);
				return;
			}
			tf32.setText("");				//�������
			tf33.setText("");
	    }
	    catch (Exception ex) {
	    	System.out.println ("UserID.umAdd(): Add new ID error.");
	    }//End try
	}
	
	/**=======================================================================**
	 *		[## private void umUpdate (int type) {} ]: 		����ɾ�����
	 *			����   ��int ������ʾ��������  0:��ʾ�޸�����  1:��ʾɾ���¼
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ���޸������ɾ���û�ID
	 **=======================================================================**
	 */
	private void umUpdate (int type) {
		String umName = cb31.getSelectedItem() + "";		//����û���
		String pwd0;
		String pwd1 = String.valueOf (tf32.getPassword ());
		String pwd2 = String.valueOf (tf33.getPassword ());
		
		int isID = 0;						//�û��Ƿ����
		if(!pwd1.equals (pwd2)) {			//�������벻���
			JOptionPane.showMessageDialog (null, "�������[ ������ ] �� [ ȷ������ ] " +
			"����ȷ������������ ...", "����",JOptionPane.ERROR_MESSAGE);
			return;
		}//Endif
		if(type == 0) 
			pwd0 = String.valueOf (tf31.getPassword ());//ȡ�޸Ĳ���������
		else
			pwd0 = String.valueOf (tf32.getPassword ());//ȡɾ�����������
		try {
			ResultSet rs = sunsql.executeQuery ("select pwd from pwd where delmark=0 and " +
			"userid='" + umName + "'");
			
			rs.next();
			if(!pwd0.equals(rs.getString(1))){					//�ж�ԭ�����Ƿ���ȷ
				JOptionPane.showMessageDialog (null, "����ԱID [ " + umName + " ] �� [ ԭ" +
				"���� ] ����ȷ������������ ...", "����",JOptionPane.ERROR_MESSAGE);
				
				return;
			}//Endif
			if(type == 0) {	//ִ���޸��������
				isID = sunsql.executeUpdate("update pwd set pwd='" + pwd1 + "' where " +
				"delmark=0 and userid='" + umName + "'");
			}else {			//ִ��ɾ�����
				isID = sunsql.executeUpdate("update pwd set delmark=1 where userid='" + umName + "'");
			}//Endif
	    }
	    catch (Exception ex) {
	    }//End try
		if(isID == 0) {				//�жϲ����Ƿ�ɹ�
			JOptionPane.showMessageDialog (null, "ִ�в���ʧ�ܣ��������������Ƿ��� ...", "����",JOptionPane.ERROR_MESSAGE);
		}
		tf31.setText("");				//�������
		tf32.setText("");
		tf33.setText("");
		return;
	}
	
	//���Ʒ������Ƿ�Ϸ�
	private boolean isValidity() {
		if(!suntools.isNum(tf41.getText(), 1, 6, 9)) {
			JOptionPane.showMessageDialog(null, "[ �ƷѲ��� 1 ] ֻ�������֣��ҷ�Χ�� 6-9 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf41.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf42.getText(), 2, 11, 13)) {
			JOptionPane.showMessageDialog(null, "[ �ƷѲ��� 2 ] ֻ�������֣��ҷ�Χ�� 11-13 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf42.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf43.getText(), 2, 17, 19)) {
			JOptionPane.showMessageDialog(null, "[ �ƷѲ��� 3 ] ֻ�������֣��ҷ�Χ�� 17-19 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf43.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf44.getText(), 1, 0, 5)) {
			JOptionPane.showMessageDialog(null, "[ �ӵ�ƷѲ��� 1 ] ֻ�������֣��ҷ�Χ�� 0-5 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf44.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf45.getText(), 1, 1, 5)) {
			JOptionPane.showMessageDialog(null, "[ �ӵ�ƷѲ��� 2 ] ֻ�������֣��ҷ�Χ�� 1-5 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf45.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf46.getText(), 2, 20, 40)) {
			JOptionPane.showMessageDialog(null, "[ �ӵ�ƷѲ��� 3 ] ֻ�������֣��ҷ�Χ�� 20-40 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf46.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf47.getText(), 2, 5, 15)) {
			JOptionPane.showMessageDialog(null, "[ �ӵ�ƷѲ��� 4 ] ֻ�������֣��ҷ�Χ�� 5-15 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf47.requestFocus(true);
			return false;
		}//endif
		return true;
	}
	
	/**=======================================================================**
	 *		[## private boolean isState(int aRow[]) {} ]: 
	 *			����   ��int aRom[] ��ʾҪִ��ɾ��������к�
	 *			����ֵ ��boolean
	 *			���η� ��private
	 *			����   ����鷿���״̬�Ƿ����ɾ��
	 **=======================================================================**
	 */
	private boolean isState(int aRow[]) {
		int ar = aRow.length;
		ResultSet rs = null;
		String aState = "";
		try {
			for (int i = 0; i < ar; i++) {
				rs = sunsql.executeQuery("select state from roominfo where " +
				"delmark=0 and pk='" + dtm12.getValueAt(aRow[i], 0) + "'");
				rs.next();
				aState = rs.getString(1);
				if(aState.equals("ռ��")) {
					JOptionPane.showMessageDialog(null, "[ " + dtm12.getValueAt(aRow[i], 2) + 
					" ] ��������ռ��״̬���޷�ִ��ɾ�������ϵͳȡ��������ɾ�����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}else if(aState.equals("�ӵ�")) {
					JOptionPane.showMessageDialog(null, "[ " + dtm12.getValueAt(aRow[i], 2) + 
					" ] ���������ӵ㷿״̬���޷�ִ��ɾ�������ϵͳȡ��������ɾ�����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}else if(aState.equals("Ԥ��")) {
					JOptionPane.showMessageDialog(null, "[ " + dtm12.getValueAt(aRow[i], 2) + 
					" ] ��������Ԥ��״̬���޷�ִ��ɾ�������ϵͳȡ��������ɾ�����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}//Endif
	    	}//Endif
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println ("Setup.isState(): false");
	    }//End try
	    return true;
	}
	
	
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == bt11) {//=======================================================
			art.show(true);					//��ӷ�������
			buildDTM11();					//ˢ�±����
			buildDTM12("");					//ˢ�±����
			buildDTM22();					//ˢ�±����
			
		}else if(o == bt12) {//=================================================
			if(initMrt()) {					//����ݸ��
				mrt.show(true);				//�޸ķ�������
				buildDTM11();				//ˢ�±����
				buildDTM12("");				//ˢ�±����
				buildDTM22();				//ˢ�±����
			}//Endif
			
		}else if(o == bt13) {//=================================================
				int rRow[] = tb11.getSelectedRows();			//ɾ�������
				int sysmark;
				for (int i = 0; i < rRow.length; i++) {
					//��õü�¼�����Ա�־����ת������
					sysmark = Integer.parseInt(dtm11.getValueAt(rRow[i], 1) + "");
					if(sysmark == 1) {
						JOptionPane.showMessageDialog(null, "[ " + dtm11.getValueAt(rRow[i], 4) + 
						" ] ����Ϊϵͳ�����ã������?ɾ��ϵͳ��ֹ��ɾ����� ...", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
						return;				//��ִ��ɾ��ش���
					}//Endif
			    }//Endfor
				String msg = "ע�⣬ɾ�� [ �������� ] �����Ὣ�� [ �������� ] ���" +
				"������ [ ������Ϣ ] һ��ɾ��\n��ȷ��Ҫɾ���ڱ����ѡ�е�������Ŀ��";
				
				if(delInfo ("roomtype", dtm11, rRow, msg)) {	//ִ��ɾ�����
					buildDTM11();			//ˢ�����ͱ����
					buildDTM12("");			//ˢ�·�������
					buildDTM22();			//ˢ�����ͱ����
					journal = "ִ����ɾ������͵Ĳ���--ɾ��������" + rRow.length;
					Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_RT);//��¼������־
				}//Endif
				
		}else if(o == bt14) {//=================================================
			if(initDis(tb11, dtm11)) {				//����Ѵ���
				dis.show(true);
			}//Endif
		}else if(o == bt15) {//=================================================
			sunsql.initJComboBox(AddRoomInfo.cb1, "select r_type from roomtype where delmark = 0");
			ari.show(true);					//������ӷ�����Ϣ
			buildDTM12("");					//ˢ�±����
			
		}else if(o == bt16) {//=================================================
			sunsql.initJComboBox(AddRoomInfos.cb, "select r_type from roomtype where delmark = 0");
			aris.show(true);				//������ӷ�����Ϣ
			buildDTM12("");					//ˢ�±����
			
		}else if(o == bt18) {//=================================================
			sunsql.initJComboBox(ModiRoomInfo.cb1, "select r_type from roomtype where delmark = 0");
			if(initMri()) {					//����ݸ��
				mri.show(true);				//�޸ķ�����Ϣ
				buildDTM12("");				//ˢ�±����
			}//Endif
			
		}else if(o == bt17) {//=================================================
			int rRow[] = tb12.getSelectedRows();			//ɾ�����Ϣ
			if(isState(rRow)) {				//�жϷ����״̬�Ƿ����ɾ��
				if(delInfo ("roominfo", dtm12, rRow, msg0)) {	//ִ��ɾ�����
					buildDTM12("");			//ˢ�·�������
					journal = "ִ����ɾ�����Ϣ�Ĳ���--ɾ��������" + rRow.length;
					Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_RI);//��¼������־
				}//Endif
			}
		}else if(o == bt19) {//=================================================
			if(!suntools.isNum(tf11.getText(),2 ,5 ,30))	{	//�����˷��󷿼�״̬
				JOptionPane.showMessageDialog(null, "������ķ���״̬��ʱ���ֻ��Ϊ���֣��ҷ�Χ�� 5 - 30 ֮��",
				"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				tf11.requestFocus(true);
				return;
			}
			sunini.setIniKey(ini[16], cb12.getSelectedIndex() + "");	//�����ñ�����������
			sunini.setIniKey(ini[17], tf11.getText());			
			sunini.saveIni(ini);								//������������ñ�����INI�ļ�
			
		}else if(o == bt20) {//=================================================
				int cbIndex = cb11.getSelectedIndex();		//ɸѡ��Ϣ
				if(cbIndex == cb11.getItemCount() - 1) {	//��ʾȫ������
					buildDTM12("");							//ˢ�·�������
				}else {
					String rt = "and a.r_type_id = '" + dtm11.getValueAt(cbIndex, 2) + "'";
					buildDTM12(rt);							//���ָ����������ˢ�±����
				}//Endif
				
		}else if(o == bt21) {//=================================================
			act.show(true);					//��ӿͻ�����
			buildDTM21();
			
		}else if(o == bt22) {//=================================================
			if(initMct()) {					//����ݸ��
				mct.show(true);				//�޸Ŀͻ�����
				buildDTM21();				//ˢ�±����
			}//Endif
			
		}else if(o == bt23) {//=================================================
			int rRow[] = tb21.getSelectedRows();				//ɾ��ͻ�����
			if(delInfo ("customertype", dtm21, rRow, msg0)) {	//ִ��ɾ�����
				buildDTM21();			//ˢ�·�������
				journal = "ִ����ɾ��ͻ����͵Ĳ���--ɾ��������" + rRow.length;
				Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_US);//��¼������־
			}//Endif
			
		}else if(o == bt24) {//=================================================
			if(initDis(tb22, dtm22)) {		//����Ѵ���
				dis.show(true);
			}//Endif
		}else if(o == bt31) {//===================================//�Ǽǲ���Ա��Ϣ
			if(String.valueOf(tf32.getPassword()).length() == 0) {
			 	JOptionPane.showMessageDialog(null, " [ ������ ] ����Ϊ��", "��ʾ", 
			 	JOptionPane.INFORMATION_MESSAGE);
			 	return;
			}else if(String.valueOf(tf33.getPassword()).length() == 0) {
				JOptionPane.showMessageDialog(null, " [ ȷ������ ] ����Ϊ��", "��ʾ", 
				JOptionPane.INFORMATION_MESSAGE);
				return;
			}//Endif
			umAdd ();					//ִ����Ӳ���
			buildDTM31();				//ˢ�±����
			journal = "������µĲ���Ա��Ϣ-- [ " + cb31.getEditor ().getItem () + " ]";
			Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_CZ);//��¼������־
			
		}else if(o == bt32) {//==================================//�޸Ĳ���Ա��Ϣ
			if(String.valueOf(tf31.getPassword()).length() == 0) {
				JOptionPane.showMessageDialog(null, " [ ������ ] ����Ϊ��", "��ʾ", 
				JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(String.valueOf(tf32.getPassword()).length() == 0) {
				JOptionPane.showMessageDialog(null, " [ ������ ] ����Ϊ��", "��ʾ", 
				JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(String.valueOf(tf33.getPassword()).length() == 0) {
				JOptionPane.showMessageDialog(null, " [ ȷ������ ] ����Ϊ��", "��ʾ", 
				JOptionPane.INFORMATION_MESSAGE);
				return;
			}//Endif
			umUpdate (0);				//ִ���޸��������
			journal = "�޸��˲���Ա [ " + cb31.getEditor ().getItem () + " ] ������";
			Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_CZ);//��¼������־
			
		}else if(o == bt33) {//=================================================//ɾ�����Ա��Ϣ
			if(String.valueOf(tf32.getPassword()).length() == 0) {
				JOptionPane.showMessageDialog(null, " [ ������ ] ����Ϊ��", "��ʾ", 
				JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(String.valueOf(tf33.getPassword()).length() == 0) {
				JOptionPane.showMessageDialog(null, " [ ȷ������ ] ����Ϊ��", "��ʾ", 
				JOptionPane.INFORMATION_MESSAGE);
				return;
			}//Endif
			int wi = JOptionPane.showConfirmDialog(null,"��ȷ��Ҫɾ��ǰ���û�ID��", 
			"��ʾ", JOptionPane.YES_NO_OPTION);
			
			if(wi == JOptionPane.YES_OPTION) {
				umUpdate (1);			//ִ��ɾ���û�ID����
				buildDTM31();			//ˢ�±����
				journal = "ɾ���˲���Ա [ " + cb31.getEditor ().getItem () + " ] ������";
				Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_CZ);//��¼������־
			}//Endif
			
		}else if(o == bt41) {//=================================================
			if(isValidity()) {
				int saveJf = JOptionPane.showConfirmDialog(null, "�� ȷ ʵ Ҫ �� �� " +
				"�� ǰ �� �� �� �� �� �� ��","��������",JOptionPane.YES_NO_OPTION);
				if(saveJf == JOptionPane.YES_OPTION) {		//����Ʒ�����
					sunini.setIniKey("In_Room", tf41.getText());	//�����ñ�����������
					sunini.setIniKey("Out_Room1", tf42.getText());
					sunini.setIniKey("Out_Room2", tf43.getText());
					sunini.setIniKey("ClockRoom1", tf44.getText());
					sunini.setIniKey("ClockRoom2", tf45.getText());
					sunini.setIniKey("InsuHour1", tf46.getText());
					sunini.setIniKey("InsuHour2", tf47.getText());
					if(ck.isSelected()) {					//����һ�찴һ���շ�
						sunini.setIniKey("InsuDay","1");
					}else {
						sunini.setIniKey("InsuDay","0");
					}//Endif
					sunini.saveIni(ini);					//������������ñ�����INI�ļ�
					journal = "�޸���ϵͳ�ļƷ�����";
					Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_JF);//��¼������־
				}//Endif
			}//Endif
		}else if(o == bt42) {//=================================================
			this.setVisible(false);			//����������
		}else if(o == tf41) {
			tf42.requestFocus(true);
		}else if(o == tf42) {
			tf43.requestFocus(true);
		}else if(o == tf43) {
			tf44.requestFocus(true);
		}else if(o == tf44) {
			tf45.requestFocus(true);
		}else if(o == tf45) {
			tf46.requestFocus(true);
		}else if(o == tf46) {
			tf47.requestFocus(true);
			
		}else if(o == rb31) {//=================================================
			bt31.setEnabled (true);			//������Χ--����²���Ա
			bt32.setEnabled (false);
			bt33.setEnabled (false);
			rb34.setEnabled (true);
			rb35.setEnabled (true);
			tf31.setEditable(false);
			tf32.setEditable(true);
			tf33.setEditable(true);
			cb31.setEditable (true);
			
		}else if(o == rb32) {				//������Χ--����Ա�޸�����
			bt31.setEnabled (false);
			bt32.setEnabled (true);
			bt33.setEnabled (false);
			rb34.setEnabled (false);
			rb35.setEnabled (false);
			tf31.setEditable(true);
			tf32.setEditable(true);
			tf33.setEditable(true);
			cb31.setEditable (false);
			
		}else if(o == rb33) {				//������Χ--ɾ�����Ա
			bt31.setEnabled (false);
			bt32.setEnabled (false);
			bt33.setEnabled (true);
			rb34.setEnabled (false);
			rb35.setEnabled (false);
			tf31.setEditable(false);
			tf32.setEditable(true);
			tf33.setEditable(true);
			cb31.setEditable (false);
		}//Endif
	}//End actionPerformed
	
	
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
		if(o == bt11) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"����µķ�������   ��������������������������������������");
		}else if(o == bt12) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�޸�ָ���ķ�������   ������������������������������������");
		}else if(o == bt13) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ɾ��ָ���ķ�������   ������������������������������������");
		}else if(o == bt14) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"����ָ���������͵�����ۿ�   ����������������������������");
		}else if(o == bt15) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"Ϊָ���ķ�����������µĿͷ�   ��������������������������");
		}else if(o == bt16) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"Ϊָ���ķ�������һ����Ӷ���¿ͷ�   ��������������������");
		}else if(o == bt17) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�޸�ָ���ͷ���Ϣ����   ����������������������������������");
		}else if(o == bt18) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ɾ��ָ���Ŀͷ�   ����������������������������������������");
		}else if(o == bt19) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"���淿���˷����״̬   ����������������������������������");
		}else if(o == bt20) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�����ָ����������ʾ������Ϣ   ��������������������������");
		} if(o == bt21) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"����µĿͻ�����   ��������������������������������������");
		}else if(o == bt22) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�޸�ָ���Ŀͻ�����   ������������������������������������");
		}else if(o == bt23) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ɾ��ָ���Ŀͻ�����   ������������������������������������");
		}else if(o == bt24) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"����ָ���������͵�����ۿ�   ����������������������������");
		}else if(o == bt31) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"����µĲ���Ա   ����������������������������������������");
		}else if(o == bt32) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�޸�ָ���Ĳ���Ա����   ����������������������������������");
		}else if(o == bt33) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ɾ��ָ���Ĳ���Ա   ��������������������������������������");
		}else if(o == bt41) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"���浱ǰ�ļƷ�������INI�����ļ�  ������������������������");
		}else if(o == bt42) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"����������   ��������������������������������������������");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + 
		"��ѡ������ ...   ����������������������������������������");
	}
	
}