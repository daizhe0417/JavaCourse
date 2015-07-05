/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : �޸ĵ����ۿ�
 *	[ �ļ���      ]  : Discount.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ʵ�ֶԿͻ��ۿ۵ĵ����޸�
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
 *	[ ����˵��    ]  :	
 *
 *	[## public Discount(JDialog dialog) {} ]:
 *		����: �޸ĵ����ۿ�
 *
 *	[## private void addListener() {} ]: 
 *		����: ���¼�����
 *
 *	[## private void buildPN() {} ]: 
 *		����: �����������
 *
 *	[## private void buildPC() {} ]: 
 *		����: �����м����
 *
 *	[## private void buildPS() {} ]: 
 *		����: �����ϱ����
 *
 *	[## private void initDtm() {} ]:
 *		����: ��ʼ��DTM
 *
 *  [ ��������    ]  : 
 *
 *###############cn.lntu.t32#############################################
 */
package com.sunshine.setup;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import com.sunshine.sunsdk.sql.*;			//�������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;

public class Discount 
extends JDialog 
implements ActionListener, FocusListener {
	
	public static JLabel lb1, lb2;			//����Ӳα���
	public static JTextField tf1;
	public static JComboBox cb1, cb2;
	public static DefaultTableModel dtm;
	public static String rt;				//�������ͱ��
	
	private JButton bt1;
	private JComboBox cb3;
	private JTable tb;
	private JScrollPane sp;
	private JPanel panelMain, pn, pc, ps;
	
	
	/**=======================================================================**
	 *		[## public Discount(JDialog dialog) {} ]: 		���캯��
	 *			����   ��JDialog�����ʾ���Ի���ĸ�����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���޸ĵ����ۿ�
	 **=======================================================================**
	 */
	public Discount(JDialog dialog) {
		super(dialog, "�����������", true);
		
		pn = new JPanel(new GridLayout(2, 2, 0, 0));
		pc = new JPanel(new BorderLayout());
		ps = new JPanel(new GridLayout(2, 1, 0, 0));
		panelMain = new JPanel(new BorderLayout(0, 0));
		
		buildPN();		//�������ڱ������
		buildPC();		//���������м����
		buildPS();		//���������ϱ����
		
		//�������
		panelMain.add("North", pn);
		panelMain.add("Center",pc);
		panelMain.add("South", ps);
		
		//���¼�����
		addListener();
		
		this.setContentPane(panelMain);
		this.setPreferredSize(new Dimension(450, 360));
		this.setMinimumSize(new Dimension(450, 360));
		this.setResizable(false);			//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);		//������Ļ����
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
		bt1.addActionListener(this);
		cb1.addActionListener(this);
		cb3.addActionListener(this);
		tf1.addFocusListener(this);
	}
	
	/**=======================================================================**
	 *		[## private void buildPN() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �������������
	 **=======================================================================**
	 */
	private void buildPN() {
		JPanel pn1, pn2;
		JLabel lbA, lbB, lbC, lbD;
		
		pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		lb1 = new JLabel("����˫�˼�");			//��Ŀ���
		lb2 = new JLabel("��500.00");			//���䵥��
		lbA = new JLabel("��Ŀ��ƣ�");
		lbB = new JLabel("�������������ۣ�");
		lbC = new JLabel("��");			//�ٿո�
		lbD = new JLabel("��");			//�ٿո�
		
		lbA.setFont(new Font("����", Font.BOLD, 15));	//���������С
		lbB.setFont(new Font("����", Font.BOLD, 15));
		lb1.setFont(new Font("����", Font.PLAIN, 15));
		lb2.setFont(new Font("����", Font.PLAIN, 15));
		lbA.setForeground(new Color(87, 87, 47));		//���ñ�ǩǰ��ɫ
		lbB.setForeground(new Color(87, 87, 47));
		lb1.setForeground(Color.RED);
		lb2.setForeground(Color.RED);
		
		//�������
		pn1.add(lbA);
		pn1.add(lb1);
		pn2.add(lbB);
		pn2.add(lb2);
		pn.add(lbC);
		pn.add(lbD);
		pn.add(pn1);
		pn.add(pn2);
	}
	
	/**=======================================================================**
	 *		[## private void buildPC() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �������м����
	 **=======================================================================**
	 */
	private void buildPC() {
		JPanel pcn,pcc;
		JLabel lbA,lbB;
		
		lbA = new JLabel("��ͨ���ʹ������ͣ�");
		lbB = new JLabel("������ͨ���ʹ��۱���");
		
		cb1 = new JComboBox();
		cb1.addItem("����");
		cb1.addItem("������");
		tf1 = new TJTextField(6);
		
		dtm = new DefaultTableModel();
		tb  = new JTable(dtm);
		sp  = new JScrollPane(tb);
		sp.setBorder(BorderFactory.createTitledBorder(""));
		tb.setEnabled(false);
		/////////////////////////////////��������ӱ��
		pcn = new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
		pcc = new JPanel(new GridLayout(1,1));
		
		//�������
		pcn.add(lbA);
		pcn.add(cb1);
		pcn.add(lbB);
		pcn.add(tf1);
		pcc.add(sp);
		
		pc.add("North",pcn);
		pc.add(pcc);
		pc.setBorder(BorderFactory.createTitledBorder(""));
	}
	
	/**=======================================================================**
	 *		[## private void buildPS() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �������ϱ����
	 **=======================================================================**
	 */
	private void buildPS() {
		JLabel lb1, lb2, lb3, lb4;
		JPanel bps, bp1;
		String cbItem[] = { "���", "һ��", "����", "����", "����", "����", "����", 
							"����", "����", "����", "���ۿۡ���������"};
		
		lb1 = new JLabel("       �ͻ��ȼ���");
		lb2 = new JLabel("       �����ۿۣ�");
		lb3 = new JLabel("��ע�����۱���8Ϊ���ۣ�10Ϊ�����ۣ�0Ϊ��ѣ�   ");
		lb4 = new JLabel("��");
		cb2 = new JComboBox();
		cb3 = new JComboBox();
		bt1 = new TJButton ("pic/cancel.gif", "������", "��������ۿ�"); 
		
		lb3.setForeground(new Color(255, 138, 0));		//����lb3��ǰ��ɫ
		
		bps = new JPanel(new GridLayout(1, 5, 0, 0));
		bp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,8,6));
		
		//���绯��Ա�ȼ�
		sunsql.initJComboBox(cb2, "select distinct c_type from customertype where delmark = 0 and pk!=0");
		cb2.setMaximumRowCount(5);			//����JComboBox����������ʾ������
		//��ʼ�������ۿ�
		for (int i = 0; i < 11; i++) {
			cb3.addItem(cbItem[i]);
	    }
	    cb3.setMaximumRowCount(5);			//����JComboBox����������ʾ������
	    cb3.setSelectedIndex(10);			//����Ϊ���ۿ�ѡ��
		
		//�������
		bps.add(lb1);
		bps.add(cb2);
		bps.add(lb2);
		bps.add(cb3);
		bps.add(lb4);
		bp1.add(lb3);
		bp1.add(bt1);
		
		ps.add(bps);
		ps.add(bp1);
		
		bps.setBorder(BorderFactory.createTitledBorder(""));
	}
	
	/**=======================================================================**
	 *		[## private void initDtm() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ��DTM
	 **=======================================================================**
	 */
	private void initDtm() {
		sunsql.initDTM(Discount.dtm, "select c_type �ͻ��ȼ�,discount �����ۿ�, " +
		"dis_price �ۿۼ۸� from customertype where delmark=0 and dis_attr='" + 
		rt + "' and id!='SYSMARK'");
	}
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == bt1) {						//����ۿ�
			int cl = JOptionPane.showConfirmDialog(null, "�� ȷ ʵ Ҫ �����л�Ա�� [ " + 
			lb1.getText() + " ] ���ۿ������ ��","��������",JOptionPane.YES_NO_OPTION);
			
			if(cl == JOptionPane.YES_OPTION) {
				sunsql.executeUpdate("update customertype set discount=10 where delmark=0 " +
				"and dis_attr='" + rt + "'");
				initDtm();					//ˢ�±�����
			}//Endif
		}else if(o == cb1) {
			if(cb1.getSelectedIndex() == 0) {
				tf1.setEnabled(true);
				tf1.requestFocus(true);
			}else {
				tf1.setText("10");
				tf1.setEnabled(false);
				sunsql.executeUpdate("update customertype set discount=10 where dis_attr='" + rt + "' and id='SYSMARK'");
			}
		}else if(o == cb3) {
			int dis = cb3.getSelectedIndex();
			sunsql.executeUpdate("update customertype set discount=" + dis + " where delmark=0 " +
			"and c_type='" + cb2.getSelectedItem() + "' and dis_attr='" + rt + "'");
			
				initDtm();					//ˢ�±�����
		}//Endif
	}
	
	/**=======================================================================**
	 *			FocusListener ����
	 **=======================================================================**
	 */
	public void focusGained (FocusEvent fe) {
	}
	
	public void focusLost (FocusEvent fe) {
		sunsql.executeUpdate("update customertype set discount=" + tf1.getText() + 
		" where dis_attr='" + rt + "' and id='SYSMARK'");
	}
}