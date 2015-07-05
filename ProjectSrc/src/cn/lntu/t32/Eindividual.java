/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ɢ�Ϳ�������
 *	[ �ļ���      ]  : Eindividual.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��ͨ���Ϳ��跿�䴰��
 *	[ ����        ]  : ����
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
 *	[## public Eindividual(JFrame frame) {} ]:
 *		����: ɢ�Ϳ�������
 *
 *	[## private void addListener() {} ]: 
 *		����: ���¼�����
 *
 *	[## private void buildPanel() {} ]: 
 *		����: ���������
 *
 *	[## private void initDTM1() {} ]:
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
 *		����: ���������ס��Ϣ
 *
 *  [ ��������cn.lntu.t32############################################################################
 */
package com.sunshine.engage;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;			//�������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.*;	//����ܴ���


public class Eindividual 
extends JDialog 
implements ActionListener, MouseListener {
	
	public JLabel lbA, lbB, lbC;			//���ͷ���,��������,Ԥ�赥��
	public JComboBox cb2;				//��������
	public JCheckBox chk1;				//�ӵ㷿��
	public DefaultTableModel dtm1, dtm2;	//�ɹ�������б��DTM
	
	private JPanel panelMain;
	private JTable tb1, tb2;
	private JScrollPane sp1, sp2;
	private JComboBox cb1, cb3;
               //֤������, �Ա�
    private JCheckBox chk2;
                //��Ԥס��������
    public JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf;
                   //֤����,����,����,��ַ,��ע,�ۿ�,ʵ��,����,Ѻ��,����
    private JButton bt1, bt2, bt3, bt4;
                  //ȷ��,ȡ��,���,�Ƴ�
    private JTabbedPane tp;
    
    String cType;							//�������ͱ��
    String roomType = "";					//��������
    
    private double disPrice = 0;			//�ۿۼ�
    private int zRooms = 0;					//׷�ӿͷ�������
    
    
    /**=======================================================================**
	 *		[## public EiIndividual(JFrame frame) {} ]: 			���캯��
	 *			����   ��JFrame frame��ʾ���Ի���ĸ�����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ��ɢ�Ϳ�������
	 **=======================================================================**
	 */
	public Eindividual(JDialog dialog) {
		super (dialog, "Ԥ������", true);
		panelMain = new JPanel(new BorderLayout());	//�����Ϊ�߽粼��,ȷ��ȡ��ť��South
		buildPanel();
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (530,510));
		this.setMinimumSize (new Dimension (530, 510));
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
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
		tf5.addActionListener(this);
		tf8.addActionListener(this);
		cb2.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
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
	 *			����   ���������
	 **=======================================================================**
	 */
	private void buildPanel() {
		
		JLabel lb0, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, 
		lb12, lb13, lb14, lb15;
		
		lb0 = new JLabel("���ͷ��䣺");
		lb1 = new JLabel("�������ͣ�");
		lb2 = new JLabel("������  Ԥ�赥�ۣ�");
		lb3 = new JLabel("֤�����ͣ�");
		lb4 = new JLabel("        ֤�����룺");
		lb5 = new JLabel("       �����Ա�");
		lb6 = new JLabel("�������ͣ�");
		lb7 = new JLabel("        ��������");
		lb8 = new JLabel("       ��������");
		lb9 = new JLabel("��ַ��Ϣ��");
		lb10 = new JLabel("��ע��Ϣ��");
		lb11 = new JLabel("�ۿ۱���");
		lb12 = new JLabel("    ʵ�ʵ��ۣ�");
		lb13 = new JLabel("     Ԥס����");
		lb14 = new JLabel("    ʵ��Ѻ��");
		lb15 = new JLabel("��������ע��ֻ��׷��ͬ�෿�䣬���4�䣡��Ҫ׷�Ӳ�ͬ���͵ķ�����ѡ�����忪����");
		lbA = new JLabel("BD1001");///////////////////////////////////////////
		lbB = new JLabel("��׼���˼䡡");///////////////////////////////////////////
		lbC = new JLabel("150.00");///////////////////////////////////////////
		
		//�����б�
		cb1 = new JComboBox();
		cb1.addItem("���֤");
		cb1.addItem("��ʻ֤");
		cb1.addItem("ѧ��֤");
		cb1.addItem("���֤");
		cb1.addItem("����");
		cb1.addItem("����");
		//��������
		cb2 = new JComboBox();
		cb3 = new JComboBox();
		cb3.addItem("��         ");
		cb3.addItem("Ů         ");
		
		//�ı���
		tf1 = new TJTextField(10);
		tf2 = new TJTextField(10);
		tf3 = new TJTextField("1", 6);
		tf4 = new TJTextField(40);
		tf5 = new TJTextField(40);
		tf6 = new JTextField(3);
		tf7 = new JTextField("��0.00", 6);
		tf8 = new TJTextField("1", 4);
		tf9 = new TJMoneyField();
		tf  = new JTextField("������Ϣ");
		tf6.setEditable(false);
		tf7.setEditable(false);
		tf3.setHorizontalAlignment (JTextField.RIGHT);
		tf6.setHorizontalAlignment (JTextField.RIGHT);
		tf7.setHorizontalAlignment (JTextField.RIGHT);
		tf8.setHorizontalAlignment (JTextField.RIGHT);
		tf.setHorizontalAlignment (JTextField.CENTER);
		tf.setBackground(new Color(199, 183, 143));
		tf.setBorder(new LineBorder(new Color(87, 87, 47)));
		tf.setEditable(false);
		
		//��ѡť
		chk1 = new JCheckBox("���ӵ㷿");
		chk2 = new JCheckBox("   ��Ԥס����ʱ�Զ�����");
		
		//��ť
		bt1 = new TJButton("pic/modi3.gif", " ȷ �� ", "����");
		bt2 = new TJButton("pic/cancel.gif"," ȡ �� ", "ȡ��");
		bt3 = new TJButton("pic/right.gif", "", "��ӵ�������");
		bt4 = new TJButton("pic/left.gif",  "", "�ӿ�����ɾ��");
		bt3.setBorderPainted(false);	//�����
		bt4.setBorderPainted(false);
		bt3.setFocusPainted(false);		//�޽����
		bt4.setFocusPainted(false);
		bt3.setContentAreaFilled(false);//����͸��ɫ
		bt4.setContentAreaFilled(false);
		
		//���
		JPanel ps, pc, pcc, pcc1, pcc11, pcc12, pcc13,
			   pcc2, pcc21, pcc22, pcd1, pcc23, pcc24, pcd2, pcc25, pcc26, pcd3, 
			   pcc3, pcc31, pcc32,
			   pcc4, pcc41, pcc42, pcc43, pcc44,
			   pcc5, pcc6,  pcc7;
			   
		JLabel line0 = new JLabel(new ImageIcon("pic/line5.gif"));//�ָ���
		JLabel line1 = new JLabel(new ImageIcon("pic/line4.gif"));//�ָ���
		JLabel line2 = new JLabel(new ImageIcon("pic/line4.gif"));//�ָ���
		
		ps = new JPanel(new FlowLayout(FlowLayout.CENTER,50,5));  	//����ȷ����ȡ��ť	
		pc = new JPanel(new BorderLayout(0,5));					  	//���ð�ť���ϵĲ���
		pcc = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0)); 	//������Ϣ�ı���Ϊ���ɱ༭,����North,������������ֵ������
		pcc1 = new JPanel(new GridLayout(1, 3));					//����"���ͷ���,��������,Ԥ�赥��"...һ��
		pcc11 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));	//�������ͷ���
		pcc12 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));	//���÷�������
		pcc13 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));	//����Ԥ�赥��
		pcc2  = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));  //����"֤������...,��������..."����
		pcc21 = new JPanel(new GridLayout(2,1,5,6));//����֤������,��������
		pcc22 = new JPanel(new GridLayout(2,1,5,6));//����֤������,��������������
		pcd1  = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����pcc21,pcc22
		pcc23 = new JPanel(new GridLayout(2,1,5,6));//����֤������,��������
		pcc24 = new JPanel(new GridLayout(2,1,5,6));//����֤������,���������ı���
		pcd2  = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����pcc23,pcc24
		pcc25 = new JPanel(new GridLayout(2,1,5,6));//���������Ա�,��������
		pcc26 = new JPanel(new GridLayout(2,1,5,6));//���������Ա�������,���������ı���
		pcd3  = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����pcc25,pcc26
		pcc3  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3));  //����"��ַ��Ϣ,��ע��Ϣ"����
		pcc31 = new JPanel(new GridLayout(2,1,0,6));//���õ�ַ��Ϣ,��ע��Ϣ
		pcc32 = new JPanel(new GridLayout(2,1,0,6));//���õ�ַ��Ϣ,��ע��Ϣ�ı���
		pcc4  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3));//����"���۱���,ʵ�ʵ���,Ԥס����,ʵ��Ѻ��"һ��
		pcc41 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//���ô��۱���
		pcc42 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����ʵ�ʵ���
		pcc43 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����Ԥס����
		pcc44 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));//����ʵ��Ѻ��
		pcc5  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3));   //��������chk
		pcc6  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3));   //����tp
		pcc7  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3));   //����"ע:......."
		
		
		
		pcc11.add(lb0);
		pcc11.add(lbA);
		pcc12.add(lb1);
		pcc12.add(lbB);
		pcc13.add(lb2);
		pcc13.add(lbC);
		pcc1.add(pcc11);
		pcc1.add(pcc12);
		pcc1.add(pcc13);
		lbA.setFont(new Font("����",Font.BOLD,15));
		lbA.setForeground(Color.BLUE);
		lbB.setFont(new Font("����",Font.BOLD,15));
		lbB.setForeground(Color.BLUE);
		lbC.setFont(new Font("����",Font.BOLD,15));
		lbC.setForeground(Color.RED);
		
		//����֤������,������������
		pcc21.add(lb3);		
		pcc21.add(lb6);
		pcc22.add(cb1);		
		pcc22.add(cb2);	
		pcc23.add(lb4);	
		pcc23.add(lb7);	
		pcc24.add(tf1);
		pcc24.add(tf2);
		pcc25.add(lb5);
		pcc25.add(lb8);
		pcc26.add(cb3);
		pcc26.add(tf3);
		pcd1.add(pcc21);
		pcd1.add(pcc22);
		pcd2.add(pcc23);
		pcd2.add(pcc24);
		pcd3.add(pcc25);
		pcd3.add(pcc26);
		pcc2.add(pcd1);
		pcc2.add(pcd2);
		pcc2.add(pcd3);
		
		//�����ַ��Ϣ,��ע��Ϣ����
		pcc31.add(lb9);
		pcc31.add(lb10);
		pcc32.add(tf4);
		pcc32.add(tf5);
		pcc3.add(pcc31);
		pcc3.add(pcc32);
		
		//������۱���,ʵ�ʵ���,Ԥע����,ʵ��Ѻ������
		pcc41.add(lb11);
		pcc41.add(tf6);
		pcc42.add(lb12);
		pcc42.add(tf7);
		pcc43.add(lb13);
		pcc43.add(tf8);
		pcc44.add(lb14);
		pcc44.add(tf9);
		pcc4.add(pcc41);
		pcc4.add(pcc42);
		pcc4.add(pcc43);
		pcc4.add(pcc44);
		
		//�����ӵ㷿һ��
		JLabel temp4,temp5;
		temp4 = new JLabel("             ");
		temp5 = new JLabel("                                                                          ");
		pcc5.add(chk1);
		pcc5.add(temp4);
		pcc5.add(chk2);
		pcc5.add(temp5);
		
		//����JTabbedPane
		tp = new JTabbedPane();
		//======================================================================
		JLabel zlb1, zlb2, zlb3;				//�ٿո�
		JTextField ztf0 ,ztf1;					//�����ı���Ҳ�ٵ�
		JPanel zjMain, zj0, zj1, zj2;
		
		zlb1 = new JLabel("��");
		zlb2 = new JLabel("��");
		zlb3 = new JLabel("��");
		ztf0 = new JTextField("�ɹ�����", 18);
		ztf1 = new JTextField("��������", 18);
		
		zjMain = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		zj0    = new JPanel(new BorderLayout());	//�ɹ�����
		zj1    = new JPanel(new BorderLayout());	//��������
		zj2    = new JPanel(new GridLayout(5, 1));	//��Ӱ���
		
		//��߱��
		dtm1 = new DefaultTableModel();
		tb1  = new JTable(dtm1);
		sp1  = new JScrollPane(tb1);
		tb1.setTableHeader(null);
		tb1.setShowHorizontalLines(false);
		tb1.setForeground(new Color( 87,  87,  47));
		tb1.setBackground(new Color(248, 242, 230));
		//���ñ����ʾ�ĳߴ�
		tb1.setPreferredScrollableViewportSize(new Dimension(80,100));
		/////////////////////////////////////////�����
		
		//�ұ߱��
		dtm2 = new DefaultTableModel();
		tb2  = new JTable(dtm2);
		sp2  = new JScrollPane(tb2);
		tb2.setTableHeader(null);
		tb2.setShowHorizontalLines(false);
		tb2.setForeground(new Color( 87,  87,  47));
		tb2.setBackground(new Color(248, 242, 230));
		//���ñ����ʾ�ĳߴ�
		tb2.setPreferredScrollableViewportSize(new Dimension(80,100));
		/////////////////////////////////////////�����
		sp1	   = new JScrollPane(tb1);
		sp2	   = new JScrollPane(tb2);
		
		//���ñ������־���
		ztf0.setHorizontalAlignment (JTextField.CENTER);
		ztf1.setHorizontalAlignment (JTextField.CENTER);
		//���ñ����ı��򱳾�ɫ
		ztf0.setBackground(new Color(199,183,143));
		ztf1.setBackground(new Color(199,183,143));
		//���ñ����ı����
		ztf0.setBorder(new LineBorder(new Color(87,87,47)));
		ztf1.setBorder(new LineBorder(new Color(87,87,47)));
		//�����ı����ɱ༭
		ztf0.setEditable(false);
		ztf1.setEditable(false);
		
		//�������
		zj2.add(zlb1);			//������Ӱ���
		zj2.add(bt3);
		zj2.add(zlb2);
		zj2.add(bt4);
		zj2.add(zlb3);
		
		zj0.add("North", ztf0);
		zj0.add("Center", sp1);
		zj1.add("North", ztf1);
		zj1.add("Center", sp2);
		
		//����׷�ӷ������
		zjMain.add(zj0);
		zjMain.add(zj2);
		zjMain.add(zj1);
		
		tp.addTab("׷ �� �� ��", zjMain);
		//======================================================================
		pcc6.add(tp);
			
		//����"ע:.................."	
		JLabel temp10 = new JLabel("                                 ");
		lb15.setForeground(Color.red);
		pcc7.add(lb15);
		pcc7.add(temp10);
		
		//��������Ϣ�������
		pcc.add(pcc1);
		pcc.add(line1);
		pcc.add(pcc2);
		pcc.add(pcc3);
		pcc.add(pcc4);
		pcc.add(pcc5);
		pcc.add(line2);
		pcc.add(pcc6);
		pcc.add(pcc7);
		
		
		pc.add("North",tf);
		pc.add(pcc);
		pc.setBorder(BorderFactory.createTitledBorder(""));
		ps.add(bt1);
		ps.add(bt2);
		
		panelMain.add("South",ps);
		panelMain.add(pc);
	}
	
	/**=======================================================================**
	 *		[## private void initDTM1() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ���ɹ������б�
	 **=======================================================================**
	 */
	public void initDTM1() {
		sunsql.initDTM(dtm1,"select a.id ������1 from roominfo " +
		"a,(select id from roomtype where r_type='" + lbB.getText() + 
		"') b where a.delmark=0 and a.indimark=0 and a.state='�ɹ�' and a.r_type_id=b.id");
	}
	
	/**=======================================================================**
	 *		[## private void initDTM2() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ�����������б�
	 **=======================================================================**
	 */
	public void initDTM2() {
		sunsql.initDTM(dtm2,"select roomid ������ from roomnum");
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
		if(arows.length + tb2.getRowCount() > 5) {
			JOptionPane.showMessageDialog(null, "���ֻ��׷���ļ�ͷ���" +
			"��ס������Ͽͷ���ʹ�����忪��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		int ar = 0;
		int zr = zRooms;							//��¼�������������������
		String sqlCode[]  = new String[arows.length * 2];
		if(arows.length > 0) {
			for (int i = 0; i < arows.length; i++) {
				sqlCode[ar] = "insert into roomnum(roomid) values('" +
				dtm1.getValueAt(arows[i], 0) + "')";//���뿪���б�
				ar++;
				//���ɹ��б�
				sqlCode[ar] = "update roominfo set indimark=1 where " +
				"delmark=0 and id='" + dtm1.getValueAt(arows[i], 0) + "'";
				ar++;
				zRooms++;						//������ +1
			}//Endfor
			int flag = sunsql.runTransaction(sqlCode);
			
			if(flag < arows.length) {
				JOptionPane.showMessageDialog(null, "���ʧ�ܣ������������", 
				"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				zRooms = zr;
				return;
			}//Endif
			initDTM1();		//ˢ�¿ɹ��б�
			initDTM2();		//ˢ�¿����б�
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
		if(tb2.getRowCount() - arows.length < 1) {
			JOptionPane.showMessageDialog(null, "[ ɢ�Ϳ��� ] ����Ҫ����һ������", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		int ar = 0;
		int zr = zRooms;							//��¼�������������������
		String sqlCode[]  = new String[arows.length * 2];
		if(arows.length > 0) {
			for (int i = 0; i < arows.length; i++) {
				sqlCode[ar] = dtm2.getValueAt(arows[i], 0) + "";
				if(!sqlCode[ar].equals(lbA.getText())) {		//�ж������䲻��ɾ��
					sqlCode[ar] = "delete from roomnum where roomid='" +
					dtm2.getValueAt(arows[i], 0) + "'";//�Ƴ��б�
					ar++;
					//���ɹ��б�
					sqlCode[ar] = "update roominfo set indimark=0 where " +
					"delmark=0 and id='" + dtm2.getValueAt(arows[i], 0) + "'";
					ar++;
					zRooms--;				//������ -1	
				}else {
					JOptionPane.showMessageDialog(null, "[ " + dtm2.getValueAt(arows[i], 0) + 
					" ] �����������䣬�����Ƴ� ...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					zRooms = ar;
					return;
				}//Endif
			}//Endfor
			int flag = sunsql.runTransaction(sqlCode);
			
			if(flag < arows.length) {
				JOptionPane.showMessageDialog(null, "�Ƴ�ʧ�ܣ������������", 
				"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				zRooms = zr;
				return;
			}//Endif
			initDTM1();		//ˢ�¿ɹ��б�
			initDTM2();		//ˢ�¿����б�
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
		}else if(tf4.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "[ ��ַ��Ϣ ] ����Ϊ��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf4.requestFocus(true);
			return false;
		}
		else if(!suntools.isNum(tf3.getText(), 2, 1, 15)) {
			JOptionPane.showMessageDialog(null, "ɢ�Ϳ����� [ �������� ] ������1�ˣ�" +
			"���15��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf3.setText("1");
			tf3.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf8.getText(), 2, 1, 99)) {
			JOptionPane.showMessageDialog(null, "ɢ�Ϳ����� [ Ԥס���� ] ������1�죬" +
			"���99�죬��������µ��뵽VIP�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf8.setText("1");
			tf8.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf9.getText(), 7, 100, 8000)) {
			JOptionPane.showMessageDialog(null, "ɢ�Ϳ����� [ ʵ��Ѻ�� ] ����Ϊ100Ԫ��" +
			"���8000Ԫ������8000Ԫ���͵��뵽VIP�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf8.requestFocus(true);
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
		String roomMain = lbA.getText();				//�������
		String cName	= tf2.getText();				//�ͻ����
		String sex		= cb3.getSelectedItem().toString().trim();	//�Ա�
		String zjType	= cb1.getSelectedItem() + "";	//֤������
		String zjNo		= tf1.getText();				//֤�����
		String address	= tf4.getText();				//��ַ
		String renShu	= tf3.getText();				//����
		String inTime	= Journal.getNowDTime();		//��סʱ��
		String days		= tf8.getText();				//Ԥע����
		String account	= tb2.getRowCount() +"";		//�������
		String foregift = tf9.getText();				//Ѻ��
		String reMark	= tf5.getText();				//��ע
		String userid	= HotelFrame.userid;			//������
		int cluemark 	= 0;							//���ѱ�־
		if(chk2.isSelected())
			cluemark	= 1;
		String sqlCode[]= new String[tb2.getRowCount() * 2 + 1];	//Ҫ������Ҫ��״̬��������������С��SQL����
		try {
			int rcss = 0;					//����¼ָ��
			for (int i = 0; i < tb2.getRowCount() * 2; i++) {
				sqlCode[i] = "insert into livein(pk,in_no,r_no,r_type_id,main_room," +
				"main_pk,c_type_id,c_name,sex,zj_type,zj_no,address,renshu,in_time,days," +
				"foregift,remark,userid,cluemark) values(" + (pkMain + rcss) + ",'" + inNumber + 
				"','" + dtm2.getValueAt(rcss, 0) + "','" + roomType + "','" + roomMain + "'," + 
				pkMain + ",'" + cType + "','" + cName + "','" + sex + "','" + zjType + "','" + 
				zjNo + "','" + address + "','" + renShu + "','" + inTime + "','" + days + "','" +
				foregift + "','" + reMark + "','" + userid + "'," + cluemark + ")";//д����һ����ס��Ϣ
				
				i++;
				if(chk1.isSelected()) {	
					sqlCode[i] = "update roominfo set state='�ӵ�' where delmark=0 " +
					"and id='" + dtm2.getValueAt(rcss, 0) + "'";	//�ӵ㷿״̬����
					//���״̬ͼƬ
					RightTopPanel.setViewListButtonImage(roomType, dtm2.getValueAt(rcss, 0) + "", "�ӵ�");
				}else {
					sqlCode[i] = "update roominfo set state='ռ��' where delmark=0 " +
					"and id='" + dtm2.getValueAt(rcss, 0) + "'";	//��ͨ��ס״̬����
					//���״̬ͼƬ
					RightTopPanel.setViewListButtonImage(roomType, dtm2.getValueAt(rcss, 0) + "", "ռ��");
				}//Endif
				
				rcss++;		//DTMָ�� +1
		    }//Endfor
		    
		    sqlCode[tb2.getRowCount() * 2] = "update engage set engagemark=1 where " +
		    "engagemark=2 and r_no='" + roomMain + "'";
		    System.out.println (sqlCode[tb2.getRowCount() * 2]);
		    
		    //������ķ�ʽ�ύ����ݿ�
		    int livins = sunsql.runTransaction(sqlCode);
		    if(livins < tb2.getRowCount() * 2 + 1) {
		    	JOptionPane.showMessageDialog(null, "���跿�����ʧ�ܣ���������" +
		    	"���ӻ���ϵ����Ա", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		    	//�������ʧ�ܵĻ�����ָ�״̬ͼƬ
		    	for (int i = 0; i < tb2.getRowCount(); i++) {
		    		RightTopPanel.setViewListButtonImage(roomType, dtm2.getValueAt(rcss, 0) + "", "�ɹ�");
			    }
				return;					//�û���������
		    }//Endif
		    tf1.setText("");			//�������ִ�����򴰿ڿؼ�����
			tf2.setText("");
			tf3.setText("1");
			tf4.setText("");
			tf5.setText("");
			tf8.setText("1");
			tf9.setText("0.00");
			cb1.setSelectedIndex(0);
			cb3.setSelectedIndex(0);
			suntools.savNumber(inNumber, suntools.Number_RZ);
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
			if(o == tf1) {					//֤��������ý���ʱ�س�
				//���ұ�����ǰ��ס��¼
				rs = sunsql.executeQuery("select c_name,address from " +
				"livein where delmark=0 and zj_no='" + tf1.getText() + "'");
				
				if(rs.next()) {
					tf2.setText(rs.getString(1));	//��������
					tf4.setText(rs.getString(2));	//���͵�ַ
				}else {					//����ǵ�һ�����ı������Բ�ʡ��
					String gt = tf1.getText();
					if(gt.length() > 5 && gt.equals("370203")) {
						tf4.setText("ԭ������ɽ��ʡ�ൺ���б���");
					}else if(gt.length() > 5 && gt.equals("370502")) {
						tf4.setText("ԭ������ɽ��ʡ��Ӫ�ж�Ӫ��");
					}else if(gt.length() > 5 && gt.equals("370603")) {
						tf4.setText("ԭ������ɽ��ʡ��̨��");
					}//Endif
				}//Endif
				tf2.requestFocus(true);		//�������������		    
			}else if(o == tf2) {
				tf3.requestFocus(true);		//��������������
			}else if(o == tf3) {
				tf4.requestFocus(true);		//���������͵�ַ
			}else if(o == tf4) {
				tf5.requestFocus(true);		//�������ע
			}else if(o == tf5) {
				tf8.requestFocus(true);		//�������Ԥס����
			}else if(o == tf8) {
				//��÷����Ԥ��Ѻ��
				rs = sunsql.executeQuery("select foregift from roomtype where " +
				"delmark=0 and r_type='" + lbB.getText() + "'");
				if(rs.next()) {
					tf9.setText(rs.getDouble(1) + "");	//Ԥ��Ѻ��
				}//Endif
			}else if(o == cb2) {
				//�Զ��ۿۼ���
				rs = sunsql.executeQuery("select a.discount,a.dis_price,a.id,b.id from " +
				"customertype a,(select id from roomtype where delmark=0 and " +
				"r_type='" + lbB.getText() + "') b where a.delmark=0 and " +
				"a.c_type='" + cb2.getSelectedItem() + "' and a.dis_attr=b.id");
				if(rs.next()) {
					tf6.setText(rs.getString(1));	//�ۿ�
					disPrice = rs.getDouble(2);		//�ۿۼ�
					tf7.setText("��" + disPrice);
					cType = rs.getString(3);
					roomType  = rs.getString(4);
				}//Endif
				tf1.requestFocus(true);				//ȷ��
			}else if(o == bt1) {
				if(isValidity()) {
					int isAdd = JOptionPane.showConfirmDialog(null, "��ȷ���Ե�ǰ������Ϣ���� [ " + 
					lbA.getText() + " ] Ϊ�����䣬���跿����", "��ʾ", JOptionPane.YES_NO_OPTION);
					
					if(isAdd == JOptionPane.YES_OPTION) {
						saveLiveIn();					//������ס��Ϣ
					}//Endif
				}//Endif
			}else if(o == bt2) {					//ȡ��
				tf1.setText("");
				tf2.setText("");
				tf3.setText("1");
				tf4.setText("");
				tf5.setText("");
				tf8.setText("1");
				tf9.setText("0.00");
				cb1.setSelectedIndex(0);
				cb3.setSelectedIndex(0);
				this.setVisible(false);
			}else if(o == bt3) {					//���뵽��������
				if(zRooms < 4) {					//��鷿������
					addRoom();
				}else {
					JOptionPane.showMessageDialog(null, "���ֻ��׷���ļ�ͷ���" +
					"��ס������Ͽͷ���ʹ�����忪��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}//Endif
			}else if(o == bt4) {
				if(zRooms >= 0) {					//��鷿������
					subRoom();
				}else {
					JOptionPane.showMessageDialog(null, "[ ɢ�Ϳ��� ] ����Ҫ����һ������", 
					"��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}//Endif
			}//Endif
		}
		catch (Exception ex) {
			//ex.printStackTrace();
			System.out.println ("Individual.actionPerformed: false");
		}//End try
	}
	
	
	/**=======================================================================**
	 *			MouseListener ����
	 **=======================================================================**
	 */
	public void mouseClicked (MouseEvent me) {
	}

	public void mousePressed (MouseEvent me) {
		Object o = me.getSource();
		if(o == bt3) {
			bt3.setIcon(new ImageIcon("pic/right2.gif"));
		}if(o == bt4) {
			bt4.setIcon(new ImageIcon("pic/left2.gif"));
		}//Endif
	}

	public void mouseReleased(MouseEvent me) {
		Object o = me.getSource();
		if(o == bt3) {
			bt3.setIcon(new ImageIcon("pic/right.gif"));
		}if(o == bt4) {
			bt4.setIcon(new ImageIcon("pic/left.gif"));
		}//Endif
	}

	public void mouseEntered (MouseEvent me) {		//����ƽ���ʾ
		Object o = me.getSource ();
		if(o == bt1) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ȷ�ϵ�ǰ���͵���ס��Ϣ   ��������������������������������");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ȡ�������ס��Ϣ      ���������������������������������� ��");
		}else if(o == bt3) {
			bt3.setIcon(new ImageIcon("pic/right1.gif"));
		}else if(o == bt4) {
			bt4.setIcon(new ImageIcon("pic/left1.gif"));
		}//Endif
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
		bt3.setIcon(new ImageIcon("pic/right.gif"));
		bt4.setIcon(new ImageIcon("pic/left.gif"));
	}
	
}