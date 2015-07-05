/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : 
 *	[ ģ����      ]  : ɢ�Ϳ�������
 *	[ �ļ���      ]  : Team.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ������Ϳ��跿�䴰��
 *	[ ����        ]  : 
 *	[ �汾        ]  : 1
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
 *	[## public Team(JFrame frame) {} ]:
 *		����: ɢ�Ϳ�������
 *
 *	[## private void addListener() {} ]: 
 *		����: ���¼�����
 *
 *	[## private void buildPanel() {} ]: 
 *		����: ���������
 *
 *	[## private void initDTM1(String cType) {} ]:
 *		����: ��ʼ���ɹ������б�
 *
 *	[## private void initDTM2() {} ]: 
 *		����: ��ʼ�����������б�
 *
 *	[## private void addRoom() {} ]: 
 *		����: �ӵ�������
 *
 *	[## private void subRoom() {} ]: 
 *		����: �ӿ������Ƴ�
 *
 *	[## private boolean isValidity() {} ]:
 *		����: �����û����������Ƿ�Ϸ�
 *
 *	[## private void saveLiveIn() {} ]: 
 *		����: �������б��͵���ס��Ϣ
 *
 *  [ ��������cn.lntu.t32##############################################################################
 */
package com.sunshine.team;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;				//������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.*;				//����ܴ���


public class Team 
extends JDialog 
implements ActionListener, MouseListener {
	
	public static JComboBox cb, cb2;			//�������ͣ���������
	public static DefaultTableModel dtm1, dtm2;	//�ɹ�����?���������
	public static JTable tb2;					//�����б�
	
	private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tfA, tfB;
                   //֤����,����,����,Ѻ��,����,����,��ַ,��ע	������
    private JButton bt1, bt2, bt3, bt4;
                  //ȷ��,ȡ��,���,�Ƴ�
	private JComboBox cb1, cb3;
               //֤������,�Ա�
	private JCheckBox chk;
                //��Ԥס��������
	private JTable tb1;				//���
	private JScrollPane sp1, sp2;	//�������
	
	private JPanel panelMain;		//�����
	
	private String rt;				//��������
    
    
    /**=======================================================================**
	 *		[## public Team(JFrame frame) {} ]: 			���캯��
	 *			����   ��JFrame frame��ʾ���Ի���ĸ�����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����忪������
	 **=======================================================================**
	 */
	public Team(JFrame frame) {
		super (frame, "���忪��", true);
		panelMain = new JPanel(new GridLayout(2, 1, 0, 10));	//�����Ϊ��񲼾�
		buildPanel();
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (540,500));
		this.setMinimumSize (new Dimension (540, 500));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
	}
	
	/**=======================================================================**
	 *		[## private void addListener() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����¼�����
	 **=======================================================================**
	 */
	private void addListener() {
		tf1.addActionListener(this);	//�ı���Ӽ���
		tf2.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
		tf6.addActionListener(this);
		tf7.addActionListener(this);
		bt1.addActionListener(this);	//����Ķ�������
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		cb.addActionListener(this);
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
		bt3.addMouseListener(this);
		bt4.addMouseListener(this);
	}
	
	/**=======================================================================**
	 *		[## private void buildPanel() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ��������Ϣ���
	 **=======================================================================**
	 */
	private void buildPanel() {
		
		JLabel lb0, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11;
		lb0 = new JLabel("�������ͣ�");
		lb1 = new JLabel("֤�����ͣ�");
		lb2 = new JLabel("  �������ͣ�");
		lb3 = new JLabel("  �����Ա�");
		lb4 = new JLabel("֤�����룺");
		lb5 = new JLabel("  ��������");
		lb6 = new JLabel("  ��������");
		lb7 = new JLabel("ʵ��Ѻ��");
		lb8 = new JLabel("  ���ͷ��䣺");
		lb9 = new JLabel("  Ԥס����");
		lb10 = new JLabel("��ַ��Ϣ��");
		lb11 = new JLabel("��ע��Ϣ��");
		
		//�����б�
		cb = new JComboBox();//��������
		cb1 = new JComboBox();
		cb1.addItem("���֤");
		cb1.addItem("��ʻ֤");
		cb1.addItem("ѧ��֤");
		cb1.addItem("���֤");
		cb1.addItem("����");
		cb1.addItem("����");
		cb2 = new JComboBox();//��������
		cb3 = new JComboBox();
		cb3.addItem("��         ");
		cb3.addItem("Ů         ");
		
		//�ı���
		tf1 = new TJTextField(8);
		tf2 = new TJTextField(10);
		tf3 = new TJTextField("1");
		tf4 = new TJMoneyField();
		tf5 = new JTextField("", 10);
		tf6 = new TJTextField(8);
		tf7 = new TJTextField(40);
		tf8 = new TJTextField(40);
		tfA = new JTextField("������Ϣ");
		tfB = new JTextField("��������");
		tf3.setHorizontalAlignment (JTextField.RIGHT);	//���ñ��������ı����Ҷ���
		tf6.setHorizontalAlignment (JTextField.RIGHT);	//���ñ���Ԥס�����Ҷ���
		tf5.setEditable(false);							//�������ͷ����ɱ༭
		tfA.setHorizontalAlignment (JTextField.CENTER);	//���������ñ���
		tfA.setBackground(new Color(199, 183, 143));
		tfA.setBorder(new LineBorder(new Color(87, 87, 47)));
		tfA.setEditable(false);
		tfB.setHorizontalAlignment (JTextField.CENTER);
		tfB.setBackground(new Color(199, 183, 143));
		tfB.setBorder(new LineBorder(new Color(87, 87, 47)));
		tfB.setEditable(false);
		
		//��ѡť
		chk = new JCheckBox("   ��Ԥס����ʱ�Զ�����");
				
		//��߱��
		dtm1 = new DefaultTableModel();
		tb1  = new JTable(dtm1);
		sp1  = new JScrollPane(tb1);
		tb1.setShowHorizontalLines(false);
		tb1.setForeground(new Color( 87,  87,  47));
		tb1.setBackground(new Color(248, 242, 230));
		sp1.setBorder(BorderFactory.createTitledBorder(""));
		String rtype = cb.getSelectedItem()+"";
		
		/////////////////////////////////////////�����
		
		//�ұ߱��
		dtm2 = new DefaultTableModel();
		tb2  = new JTable(dtm2);
		sp2  = new JScrollPane(tb2);
		tb2.setShowHorizontalLines(false);
		tb2.setForeground(new Color( 87,  87,  47));
		tb2.setBackground(new Color(248, 242, 230));
		sp2.setBorder(BorderFactory.createTitledBorder(""));
		/////////////////////////////////////////�����
		
		//��ť
		bt1 = new TJButton ("pic/modi3.gif", " ȷ �� ", "����");
		bt2 = new TJButton ("pic/cancel.gif", " ȡ �� ", "ȡ��");
		bt3 = new TJButton("pic/new.gif","��ӵ�������","��ӵ�������");
		bt4 = new TJButton("pic/del.gif","�ӿ�����ɾ��","�ӿ�����ɾ��");
		
		//���
		JPanel pb,pt,ptc,pt1,pt1c,pt1cn,pt2,
			   pc2,pc21,pc22,pcd1,pc23,pc24,pcd2,pc25,pc26,pcd3,
			   pc3,pc31,pc32,
			   pc4,pc5;
		JLabel line0 = new JLabel("                                                            ");
		JLabel line1 = new JLabel(new ImageIcon("pic/line4.gif"));//�ָ���
		JLabel line2 = new JLabel(new ImageIcon("pic/line4.gif"));//�ָ���
		
		pt = new JPanel(new BorderLayout(0,5));    //�����ϰ����
		ptc = new JPanel(new GridLayout(1,2,10,5));//�ϰ����ı��
		pt1 = new JPanel(new BorderLayout());	   //������߱��
		pt1c = new JPanel(new BorderLayout());	   //
		pt1cn = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
		pt2 = new JPanel(new BorderLayout());      //�����ұ߱��	
		pb = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));   //�°����
		pc2  = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));  //����"֤������...,��������....ʵ��Ѻ��"����
		pc21 = new JPanel(new GridLayout(3,1,5,16));//����֤������,��������,ʵ��Ѻ��
		pc22 = new JPanel(new GridLayout(3,1,5,6));//����֤������,��������������,ʵ��Ѻ���ı���
		pcd1  = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����pcc21,pcc22
		pc23 = new JPanel(new GridLayout(3,1,5,15));//����֤������,��������,���ͷ���
		pc24 = new JPanel(new GridLayout(3,1,5,6));//����֤������,��������,���ͷ����ı���
		pcd2  = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����pcc23,pcc24
		pc25 = new JPanel(new GridLayout(3,1,5,15));//���������Ա�,��������,Ԥס����
		pc26 = new JPanel(new GridLayout(3,1,5,6));//���������Ա�������,��������,Ԥס�����ı���
		pcd3  = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����pcc25,pcc26
		pc3  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3));   //����"��ַ��Ϣ,��ע��Ϣ"����
		pc31 = new JPanel(new GridLayout(2,1,0,6));//���õ�ַ��Ϣ,��ע��Ϣ
		pc32 = new JPanel(new GridLayout(2,1,0,6));//���õ�ַ��Ϣ,��ע��Ϣ�ı���
		pc4  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3));   //����chk
		pc5  = new JPanel(new FlowLayout(FlowLayout.CENTER,70,6));//����ȷ����ȡ��ť
		
		//����pc1
		JLabel temp = new JLabel ("");
		pt1cn.add(lb0);
		pt1cn.add(cb);
		pt1cn.setBorder(BorderFactory.createTitledBorder(""));
		pt1c.add("North",pt1cn);
		pt1c.add(sp1);
		pt1.add("North",tfA);
		pt1.add(pt1c);
		pt1.add("South",bt3);
		pt2.add("North",tfB);
		pt2.add(sp2);
		pt2.add("South",bt4);
		ptc.add(pt1);
		ptc.add(pt2);
		pt.add("North",temp);
		pt.add(ptc);
		
		//����֤������,��������,ʵ��Ѻ������
		pc21.add(lb1);		
		pc21.add(lb4);
		pc21.add(lb7);
		pc22.add(cb1);		
		pc22.add(tf1);	
		pc22.add(tf4);	
		pc23.add(lb2);	
		pc23.add(lb5);	
		pc23.add(lb8);	
		pc24.add(cb2);
		pc24.add(tf2);
		pc24.add(tf5);
		pc25.add(lb3);
		pc25.add(lb6);
		pc25.add(lb9);
		pc26.add(cb3);
		pc26.add(tf3);
		pc26.add(tf6);
		pcd1.add(pc21);
		pcd1.add(pc22);
		pcd2.add(pc23);
		pcd2.add(pc24);
		pcd3.add(pc25);
		pcd3.add(pc26);
		pc2.add(pcd1);
		pc2.add(pcd2);
		pc2.add(pcd3);
		
		//�����ַ��Ϣ,��ע��Ϣ����
		pc31.add(lb10);
		pc31.add(lb11);
		pc32.add(tf7);
		pc32.add(tf8);
		pc3.add(pc31);
		pc3.add(pc32);
		
		//����chk	
		JLabel temp10 = new JLabel("                                                                                                              ");
		pc4.add(chk);
		pc4.add(temp10);
		
		//����ȷ��ȡ��ť���
		pc5.add(bt1);
		pc5.add(bt2);
		
		//��������Ϣ�������
		pb.add(line1);
		pb.add(pc2);
		pb.add(pc3);
		pb.add(pc4);
		pb.add(line2);		
		pb.add(pc5);		
		
		
		panelMain.add(pt);
		panelMain.add(pb);
	}
	
	/**=======================================================================**
	 *		[## private void initDTM1(String rtype) {} ]: 
	 *			����   ��String rtype��ʾ��������
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ���ɹ������б�
	 **=======================================================================**
	 */
	private void initDTM1(String rtype) {
		String sqlCode = "select a.id �ͷ����,b.price ��׼����,b.id from roominfo as a,roomtype " +
		"as b where a.indimark=0 and b.r_type = '"+rtype+"' and a.r_type_id = b.id and " +
		"a.state = '�ɹ�' and a.delmark = 0";
		sunsql.initDTM(dtm1,sqlCode);
		tb1.removeColumn(tb1.getColumn("id"));
	}
	
	/**=======================================================================**
	 *		[## private void initDTM2() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ�����������б�
	 **=======================================================================**
	 */
	public static void initDTM2() {
		sunsql.initDTM(Team.dtm2,"select roomid �ͷ����,price ��׼����,rr_type from roomnums");
		tb2.removeColumn(tb2.getColumn("rr_type"));
	}
	
	/**=======================================================================**
	 *		[## private void addRoom() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ���ӵ�������
	 **=======================================================================**
	 */
	private void addRoom() {
		//���ѡ����к�
		int arows[] = tb1.getSelectedRows();
		
		int ar = 0;
		String sqlCode[]  = new String[arows.length * 2];
		if(arows.length > 0) {
			
			if(tf5.getText().length() == 0) {		//Ĭ�ϵ�һ������ķ���Ϊ������
				tf5.setText(dtm1.getValueAt(arows[0], 0) + "");
			}//Endif
			
			for (int i = 0; i < arows.length; i++) {
				//���뿪���б�
				sqlCode[ar] = "insert into roomnums(roomid,price,rr_type) values('" +
				dtm1.getValueAt(arows[i], 0) + "'," + dtm1.getValueAt(arows[i], 1) + ",'" + 
				dtm1.getValueAt(arows[i], 2) + "')";
				ar++;
				//���ɹ��б�
				sqlCode[ar] = "update roominfo set indimark=1 where " +
				"delmark=0 and id='" + dtm1.getValueAt(arows[i], 0) + "'";
				ar++;
			}//Endfor
			int flag = sunsql.runTransaction(sqlCode);
			
			if(flag < arows.length) {
				JOptionPane.showMessageDialog(null, "���ʧ�ܣ������������", 
				"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}//Endif
			initDTM1(rt);		//ˢ�¿ɹ��б�
			initDTM2();			//ˢ�¿����б�
		}else {
			JOptionPane.showMessageDialog(null, "���ڿɹ������б���ѡ��ָ�����䣬" +
			"��׷��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return;
		}//endif
	}
	
	/**=======================================================================**
	 *		[## private void subRoom() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ���ӿ������Ƴ�
	 **=======================================================================**
	 */
	private void subRoom() {
		//���ѡ����к�
		int arows[] = tb2.getSelectedRows();
		
		int ar = 0;
		String sqlCode[]  = new String[arows.length * 2];
		if(arows.length > 0) {
			for (int i = 0; i < arows.length; i++) {
				sqlCode[ar] = dtm2.getValueAt(arows[i], 0) + "";
				if(!sqlCode[ar].equals(tf5.getText())) {		//�ж������䲻��ɾ��
					sqlCode[ar] = "delete from roomnums where roomid='" +
					dtm2.getValueAt(arows[i], 0) + "'";//�Ƴ��б�
					ar++;
					//���ɹ��б�
					sqlCode[ar] = "update roominfo set indimark=0 where " +
					"delmark=0 and id='" + dtm2.getValueAt(arows[i], 0) + "'";
					ar++;
				}else {
					JOptionPane.showMessageDialog(null, "[ " + dtm2.getValueAt(arows[i], 0) + 
					" ] �����������䣬�����Ƴ� ...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}//Endif
			}//Endfor
			int flag = sunsql.runTransaction(sqlCode);
			
			if(flag < arows.length) {
				JOptionPane.showMessageDialog(null, "�Ƴ�ʧ�ܣ������������", 
				"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}//Endif
			initDTM1(rt);		//ˢ�¿ɹ��б�
			initDTM2();			//ˢ�¿����б�
		}else {
			JOptionPane.showMessageDialog(null, "���ڿ����б���ѡ��ָ�����䣬" +
			"���Ƴ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return;
		}//endif
	}
	
	/**=======================================================================**
	 *		[## private boolean isValidity() {} ]: 	�����û����������Ƿ�Ϸ�
	 *			����   ����
	 *			����ֵ ��boolean
	 *			���η� ��private
	 *			����   �������û����������Ƿ�Ϸ�
	 **=======================================================================**
	 */
	private boolean isValidity() {
		if(tf1.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "[ ֤������ ] ����Ϊ��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf1.requestFocus(true);
			return false;
		}else if(tf2.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "[ ������� ] ����Ϊ��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf2.requestFocus(true);
			return false;
		}else if(tf7.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "[ ��ַ��Ϣ ] ����Ϊ��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf7.requestFocus(true);
			return false;
		}else if(tf5.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "[ ���ͷ��� ] ����Ϊ��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else if(!suntools.isNum(tf3.getText(), 3, 1, 600)) {
			JOptionPane.showMessageDialog(null, "[ �������� ] ֻ����������ɣ�" +
			"��������1�ˣ����600��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf3.setText("1");
			tf3.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf6.getText(), 2, 1, 99)) {
			JOptionPane.showMessageDialog(null, "ɢ�Ϳ����� [ Ԥס���� ] ������1�죬" +
			"���99�죬��������µ��뵽VIP�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf6.setText("1");
			tf6.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf4.getText(), 8, 1000, 20000)) {
			JOptionPane.showMessageDialog(null, "���忪���� [ ʵ��Ѻ�� ] ����Ϊ1000Ԫ��" +
			"���20000Ԫ������50000Ԫ�������뵽VIP�����跿��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf4.requestFocus(true);
			return false;
		}//Endif
		return true;
	}
	
	/**=======================================================================**
	 *		[## private void saveLiveIn() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����������ס��Ϣ
	 **=======================================================================**
	 */
	private void saveLiveIn() {
		long pkMain = sunsql.getPrimaryKey();			//��PK
		String inNumber = suntools.getNumber(suntools.Number_RZ);	//��ס����
		String roomMain = tf5.getText();				//�������
		String cName	= tf2.getText();				//�ͻ����
		String sex		= cb3.getSelectedItem().toString().trim();	//�Ա�
		String zjType	= cb1.getSelectedItem() + "";	//֤������
		String zjNo		= tf1.getText();				//֤�����
		String address	= tf7.getText();				//��ַ
		String renShu	= tf3.getText();				//����
		String inTime	= Journal.getNowDTime();		//��סʱ��
		String days		= tf6.getText();				//Ԥע����
		String account	= tb2.getRowCount() +"";		//�������
		String foregift = tf4.getText();				//Ѻ��
		String reMark	= tf8.getText();				//��ע
		String userid	= HotelFrame.userid;			//������
		int cluemark 	= 0;							//���ѱ�־
		if(chk.isSelected())
			cluemark	= 1;
		String sqlCode[]= new String[tb2.getRowCount() * 2];	//Ҫ����ݣ���Ҫ��״̬��������������С��SQL����
		try {
			ResultSet rs = sunsql.executeQuery("select distinct id from customertype where " +
			"delmark = 0 and pk!=0 and c_type='" + cb2.getSelectedItem() + "'");
			rs.next();
			String cType = rs.getString(1);		//��ÿͻ����ͱ��
			
			int rcss = 0;						//����¼ָ��
			for (int i = 0; i < tb2.getRowCount() * 2; i++) {
				sqlCode[i] = "insert into livein(pk,in_no,r_no,r_type_id,main_room," +
				"main_pk,c_type_id,c_name,sex,zj_type,zj_no,address,renshu,in_time,days," +
				"foregift,remark,userid,cluemark) values(" + (pkMain + rcss) + ",'" + inNumber + 
				"','" + dtm2.getValueAt(rcss, 0) + "','" + dtm2.getValueAt(rcss, 2) + "','" + roomMain + "'," + 
				pkMain + ",'" + cType + "','" + cName + "','" + sex + "','" + zjType + "','" + 
				zjNo + "','" + address + "','" + renShu + "','" + inTime + "','" + days + "','" +
				foregift + "','" + reMark + "','" + userid + "'," + cluemark + ")";//д����һ����ס��Ϣ
				
				i++;
				sqlCode[i] = "update roominfo set state='ռ��' where delmark=0 " +
				"and id='" + dtm2.getValueAt(rcss, 0) + "'";	//��ͨ��ס״̬����
				//���״̬ͼƬ
				RightTopPanel.setViewListButtonImage(dtm2.getValueAt(rcss, 2) + "", dtm2.getValueAt(rcss, 0) + "", "ռ��");
				
				rcss++;		//DTMָ�� +1
		    }//Endfor
		    
		    //������ķ�ʽ�ύ����ݿ�
		    int livins = sunsql.runTransaction(sqlCode);
		    if(livins > tb2.getRowCount() * 2) {
		    	JOptionPane.showMessageDialog(null, "���跿�����ʧ�ܣ���������" +
		    	"���ӻ���ϵ����Ա", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		    	//�������ʧ�ܵĻ�����ָ�״̬ͼƬ
		    	for (int i = 0; i < tb2.getRowCount(); i++) {
		    		RightTopPanel.setViewListButtonImage(dtm2.getValueAt(rcss, 0) + "", 
		    		dtm2.getValueAt(rcss, 0) + "", "�ɹ�");
			    }
				return;					//�û���������
		    }//Endif

			tf1.setText("");			//�������ִ�����򴰿ڿؼ�����
			tf2.setText("");
			tf3.setText("1");
			tf4.setText("0.00");
			tf5.setText("");
			tf6.setText("1");
			tf7.setText("");
			tf8.setText("");
			cb1.setSelectedIndex(0);
			cb3.setSelectedIndex(0);
			suntools.savNumber(inNumber, suntools.Number_RZ);//������ס����
			this.setVisible(false);		//����������
	    }
	    catch (Exception ex) {
	    	System.out.println ("Individual.saveLiveIn(): false");
	    }//End try
	}
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		try {
			ResultSet rs = null;
			if(o == tf1) {		//֤��������ý���ʱ�س�
				//���ұ�����ǰ��ס��¼
				rs = sunsql.executeQuery("select c_name,address from " +
				"livein where delmark=0 and zj_no='" + tf1.getText() + "'");
				
				if(rs.next()) {
					tf2.setText(rs.getString(1));	//��������
					tf7.setText(rs.getString(2));	//���͵�ַ
				}else {					//����ǵ�һ�����ı������Բ�ʡ��
					String gt = tf1.getText();
					if(gt.length() > 5 && gt.equals("370203")) {
						tf7.setText("ԭ������ɽ��ʡ�ൺ���б���");
					}else if(gt.length() > 5 && gt.equals("370502")) {
						tf7.setText("ԭ������ɽ��ʡ��Ӫ�ж�Ӫ��");
					}else if(gt.length() > 5 && gt.equals("370603")) {
						tf7.setText("ԭ������ɽ��ʡ��̨��");
					}//Endif
				}//Endif
				tf2.requestFocus(true);		//�������������		    
			}else if(o == tf2) {
				tf3.requestFocus(true);		//��������������	
			}else if(o == tf3) {
				tf4.requestFocus(true);		//�������Ԥ��Ѻ��
			}else if(o == tf4) {
				tf6.requestFocus(true);		//�������Ԥס����
			}else if(o == tf6) {
				tf7.requestFocus(true);		//���������͵�ַ	
			}else if(o == tf7) {
				tf8.requestFocus(true);		//�������ע
			}else if(o == cb) {
				rt = cb.getSelectedItem()+"";
				initDTM1(rt);				//��ָ���ķ������Ϳɹ���������
			}else if(o == bt1) {			//ȷ��
				if(isValidity()) {
					int isAdd = JOptionPane.showConfirmDialog(null, "��ȷ���Ե�ǰ������Ϣ���跿�����\n" +
					"������ [ " + tf5.getText() + " ] ���������� [ " + tf2.getText() + " ]", "��ʾ", JOptionPane.YES_NO_OPTION);
					
					if(isAdd == JOptionPane.YES_OPTION) {
						saveLiveIn();					//������ס��Ϣ
					}//Endif
				}//Endif
			}else if(o == bt2) {			//ȡ��	�������пؼ�
				tf1.setText("");
				tf2.setText("");
				tf3.setText("1");
				tf4.setText("0.00");
				tf5.setText("");
				tf6.setText("1");
				tf7.setText("");
				tf8.setText("");
				cb1.setSelectedIndex(0);
				cb3.setSelectedIndex(0);
				this.setVisible(false);
			}else if(o == bt3) {			//���뵽��������
				addRoom();
			}else if(o == bt4) {			//�Ƴ����
				subRoom();
			}//Endif
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println ("Team.actionPerformed(): false");
	    }//End try
		
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
			"ȷ�ϵ�ǰ�������ס��Ϣ   ��������������������������������");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ȡ�����������ס��Ϣ       ��������������������������������");
		}else if(o == bt3) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ӷ��䵽���忪����       ��������������������������������");
		}else if(o == bt4) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�ӿ������Ƴ����Ϣ       ��������������������������������");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}
	
}