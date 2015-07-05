/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : �޸Ŀͻ�����
 *	[ �ļ���      ]  : ModiRoomInfo.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ʵ�ֶ��¿ͻ����͵����
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
 *	[## public ModiCustomerType(JDialog dialog) {} ]:
 *		����: ����µĿͻ�����
 *
 *	[## private void addListener() {} ]: 
 *		����: ���¼�����
 *
 *	[## private boolean isValidity() {} ]:
 *		����: �����û����������Ƿ�Ϸ�
 *
 *	[## private void saveAddCustomerType() {} ]:
 *		����: ����ͻ�����
 *
 *  [ ��������    ]  : 
 *
 *#####################cn.lntu.t32#######################################
 */
package com.sunshine.setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;			//�������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.HotelFrame;	//������



public class ModiCustomerType 
extends JDialog 
implements ActionListener {
	
	public static JTextField tf1, tf2, tf3;
	public static String pk;
	private JButton bt1, bt2;
	
	/**=======================================================================**
	 *		[## public ModiCustomerType(JDialog dialog) {} ]: 	���캯��
	 *			����   ��JDialogΪ������
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���޸Ŀͻ�����
	 **=======================================================================**
	 */
	public ModiCustomerType(JDialog dialog) {
		super(dialog, "�ͻ�����", true);
		
		JLabel lb, lb1, lb2, lb4;
		JPanel panelMain, panelInfo, p1, p2, p3, p4, p5;		//�����������
		
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		p5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		p4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 6));
		panelInfo = new JPanel(new GridLayout(4, 1, 0, 0));
		panelMain = new JPanel(new BorderLayout());
		
		lb1 = new JLabel("�ͻ����ͣ�");
		lb2 = new JLabel("���۱���");
		lb4 = new JLabel("���ͱ�ţ�");
		lb  = new JLabel("<html>ע���˴��۱������������Ʒ��Ŀ��<br>����8Ϊ���ۣ�10Ϊ������<html>");
		lb.setForeground(new Color(255, 138, 0));
		
		tf1 = new TJTextField(7);
		tf2 = new TJTextField(7);
		tf3 = new TJTextField("10", 7);
		tf1.setEnabled(false);
		
		bt1 = new TJButton ("pic/save.gif", "ȷ��", "ȷ����ӿͻ�����"); 
		bt2 = new TJButton ("pic/cancel.gif", "ȡ��", "ȡ�����"); 
		
		//�������
		p1.add(lb1);
		p1.add(tf2);
		p2.add(lb2);
		p2.add(tf3);
		p3.add(lb);
		p4.add(bt1);
		p4.add(bt2);
		p5.add(lb4);
		p5.add(tf1);
		
		panelInfo.add(p5);
		panelInfo.add(p1);
		panelInfo.add(p2);
		panelInfo.add(p3);
		panelMain.add("Center", panelInfo);
		panelMain.add("South", p4);
		
		//���¼�����
		addListener();
		
		panelInfo.setBorder (BorderFactory.createTitledBorder("�ͻ�������Ϣ"));
		
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (250,255));
		this.setMinimumSize (new Dimension (250,255));
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
		bt2.addActionListener(this);
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);
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
			JOptionPane.showMessageDialog(null, "�ͻ� [ ���ͱ�� ] ����Ϊ��", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf1.requestFocus(true);
			return false;
		}else if(tf2.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "�ͻ� [ ������� ] ����Ϊ��", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf2.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf3.getText(), 2, 1, 10)) {
			JOptionPane.showMessageDialog(null, "[ �ۿ۱��� ] ֻ�������֣��ҷ�Χ�� 1-10 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf3.requestFocus(true);
			return false;
		}//Endif
		return true;
	}
	
	/**=======================================================================**
	 *		[## private void saveAddCustomerType() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ������ͻ�����
	 **=======================================================================**
	 */
	private void saveAddCustomerType() {
		if(isValidity()) {					//˨���û����������Ƿ�Ϸ�
			try {
				ResultSet rs = sunsql.executeQuery("select id from customertype " +
				"where delmark=0 and c_type='" + tf2.getText() + "' and pk!=" +pk);
				if(rs.next()) {				//����µ���������Ƿ����
					JOptionPane.showMessageDialog(null, "�µĿͻ�������� [ " + tf2.getText() +
					" ] �Ѵ��ڣ�����ִ����Ӳ����������º˶� ...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					tf2.requestFocus(true);
					return;
				}//Endif
				String sqlCode = "update customertype set c_type='" + tf2.getText() + 
				"',discount=" + tf3.getText() + " where delmark=0 and pk=" + pk;;
				
				int rec = sunsql.executeUpdate(sqlCode);			//����ݱ��浽��ݿ�
				if(rec == 0) {
					JOptionPane.showMessageDialog(null, "�����µķ���������Ϣʧ�ܣ�" +
					"�����������ӻ���ϵ����Ա", "����", JOptionPane.ERROR_MESSAGE);
				}else {
					String journal = "�޸��˿ͻ�����-- [ " + tf2.getText() + " ]";
					Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_US);//��¼������־
					this.setVisible(false);
				}//Endif
		    }
		    catch (Exception ex) {
		    	System.out.println ("ModiCustomerType false");
		    }//End try
		}//Endif
	}//End saveAddCustomerType()
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == bt1) {					//ȷ��
			saveAddCustomerType();		//�������
		}else if(o == bt2) {			//ȡ��
			this.setVisible(false);
		}else if(o == tf1) {			//�ͻ�����
			tf2.requestFocus(true);
		}else if(o == tf2) {			//�ͻ�����
			tf3.requestFocus(true);
		}else if(o == tf3) {			//�ۿ�
			saveAddCustomerType();		//�������
		}//Endif
	}
}