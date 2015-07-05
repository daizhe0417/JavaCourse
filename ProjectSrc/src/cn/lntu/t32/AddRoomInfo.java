/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ����·�����Ϣ����
 *	[ �ļ���      ]  : AddRoomInfo.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ʵ�ֶ��·�����Ϣ�����
 *	[ ����        ]  : ����
 *	[ �汾        ]  : 1.0
 *	----------------------------------------------------------------------------
 *	[ ��ע        ]  : 
 *	----------------------------------------------------------------------------
 *	[ �޸ļ�¼    ]  : 
 *
 *	[ ��  �� ]     [�汾]         [�޸���]         [�޸�����] 
 *	2006/04/19      1.0             ����            ����
 *	2006/04/21      1.1             �˿�            ʵ�ֹ���
 *	##--------------------------------------------------------------------------
 *  			 ��Ȩ����(c) 2006-2007,  SunshineSOFT Corporation
 *	--------------------------------------------------------------------------##
 *	
 *	[ ����˵��    ]  :	
 *
 *	[## public AddRoomInfo(JDialog dialog) {} ]:
 *		����: ����µķ�����Ϣ
 *
 *	[## private void addListener() {} ]: 
 *		����: ���¼�����
 *
 *	[## private void buildPC() {} ]: 
 *		����: ������Ϣ���
 *
 *	[## private void buildPS() {} ]:
 *		����: �����������
 *
 *	[## private boolean isValidity() {} ]:
 *		����: �����û����������Ƿ�Ϸ�
 *
 *	[## private void saveRoomInfo() {} ]: 
 *		����: ���淿����Ϣ
 *
 *  [ ��������    ]  : 
 *cn.lntu.t32################################################################
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


public class AddRoomInfo
extends JDialog 
implements ActionListener {
	
	public static JComboBox cb1;
	private JTextField tf1,tf2,tf3;
	private JButton bt1,bt2;
	private JPanel panelMain,pc,ps;
	
	/**=======================================================================**
	 *		[## public AddRoomInfo(JDialog dialog) {} ]: 	���캯��
	 *			����   ��JDialogΪ������
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ������µķ�����Ϣ
	 **=======================================================================**
	 */
	public AddRoomInfo(JDialog dialog) {
		super(dialog,"������Ϣ",true);
		
		JLabel lb = new JLabel();
		panelMain = new JPanel(new BorderLayout(0,5));
		pc 		  = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
		ps 		  = new JPanel(new FlowLayout(FlowLayout.CENTER,30,10));
		
		buildPC();			//����������Ϣ���
		buildPS();			//�����������
		
		//�������
		panelMain.add("North", lb);
		panelMain.add("Center",pc);
		panelMain.add("South", ps);
		
		//���¼�����
		addListener();
		
		this.setContentPane(panelMain);
		this.setPreferredSize(new Dimension(300, 235));
		this.setMinimumSize(new Dimension(300, 235));
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
		cb1.addActionListener(this);
	}
	
	/**=======================================================================**
	 *		[## private void buildPC() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ��������Ϣ���
	 **=======================================================================**
	 */
	private void buildPC() {
		JPanel pc1,pc2;
		JLabel lb1,lb2,lb3,lb4;
		
		pc1 = new JPanel(new GridLayout(4, 1, 0, 16));
		pc2 = new JPanel(new GridLayout(4, 1, 0,  8));
		
		lb1 = new JLabel("�������ͣ�");
		lb2 = new JLabel("�����ţ�");
		lb3 = new JLabel("��������");
		lb4 = new JLabel("����绰��");
		
		cb1 = new JComboBox();				//�ͷ�����
		cb1.setMaximumRowCount(5);			//����JComboBox����������ʾ������
		String sql = "select r_type from roomtype where delmark = 0";
		sunsql.initJComboBox(cb1, sql);
		tf1 = new TJTextField(10);			//������
		tf2 = new TJTextField(10);			//��������
		tf3 = new TJTextField(10);			//����绰
		
		pc1.add(lb1);
		pc1.add(lb2);
		pc1.add(lb3);
		pc1.add(lb4);
		
		pc2.add(cb1);
		pc2.add(tf1);
		pc2.add(tf2);
		pc2.add(tf3);
		
		pc.add(pc1);
		pc.add(pc2);
	}
	
	/**=======================================================================**
	 *		[## private void buildPS() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �������������
	 **=======================================================================**
	 */
	private void buildPS() {
		bt1 = new TJButton ("pic/save.gif", " ��  �� ", "���淿��"); 
		bt2 = new TJButton ("pic/cancel.gif", " ȡ  �� ", "ȡ�����"); 
		ps.add(bt1);
		ps.add(bt2);
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
			JOptionPane.showMessageDialog(null, " [ ������ ] ����Ϊ��", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf1.requestFocus(true);
			return false;
		}else if(tf2.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "���� [ �������� ] ����Ϊ��", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf2.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf3.getText(), 4, 1000, 9999)) {
			JOptionPane.showMessageDialog(null, "[ ����绰 ] ֻ�������֣��Ϊ4λ��" +
			"��Χ 1000-9999 ֮��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf3.requestFocus(true);
			return false;
		}//Endif
		return true;
	}
	
	/**=======================================================================**
	 *		[## private void saveRoomInfo() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����淿����Ϣ
	 **=======================================================================**
	 */
	private void saveRoomInfo() {
		if(isValidity()) {
			try {
				ResultSet rs = sunsql.executeQuery("select r_type_id from roominfo " +
				"where delmark=0 and id='" + tf1.getText() + "'");
				if(rs.next()) {			//����µķ������Ƿ����
					JOptionPane.showMessageDialog(null, "��ָ���ķ����� [ " + tf1.getText() +
					" ] �Ѵ��ڣ�����ִ����Ӳ����������º˶� ...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					tf1.requestFocus(true);
					return;
				}//Endif
				rs = sunsql.executeQuery("select id from roominfo " +
				"where delmark=0 and r_tel='" + tf3.getText() + "'");
				if(rs.next()) {			//����µķ���绰���Ƿ��ظ�
					JOptionPane.showMessageDialog(null, "������·���ĵ绰�� [ " + tf3.getText() +
					" ] �Ѵ��ڣ�����ִ����Ӳ����������º˶� ...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					tf3.requestFocus(true);
					return;
				}//Endif
				rs = sunsql.executeQuery("select id from roomtype " +
				"where delmark=0 and r_type='" + cb1.getSelectedItem() + "'");
				rs.next();
				String r_ty_id = rs.getString(1);
				long pk = sunsql.getPrimaryKey();
				String sqlCode = "insert into roominfo(pk,id,r_type_id,state,location," +
								 "r_tel) values(" + pk + ",'" + tf1.getText() + "','" +
								 r_ty_id + "','�ɹ�','" + tf2.getText() + "','" + tf3.getText() + "')";
				
				int rec = sunsql.executeUpdate(sqlCode);			//����ݱ��浽��ݿ�
				if(rec == 0) {
					JOptionPane.showMessageDialog(null, "�����µķ������Ϣʧ�ܣ�" +
					"�����������ӻ���ϵ����Ա", "����", JOptionPane.ERROR_MESSAGE);
				}else {
					String journal = "������µ�" + cb1.getSelectedItem() + "-- ����ţ�[ " + tf1.getText() + " ]";
					Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_RI);//��¼������־
					cb1.setSelectedIndex(0);		//����ɹ��������пؼ�����
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf1.requestFocus(true);
				}//Endif
		    }
		    catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println ("AddRoomInfo false");
		    }//End try
		}//Endif
			
	}
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == bt1) {
			saveRoomInfo();							//����
		}else if(o == bt2) {
			this.setVisible(false);					//ȡ��
		}else if(o == cb1) {
			tf1.requestFocus(true);					//��������
		}else if(o == tf1) {
			tf2.requestFocus(true);					//�������
		}else if(o == tf2) {
			tf3.requestFocus(true);					//��������
		}else if(o == tf3) {						//����绰
			saveRoomInfo();
		}//Endif
	}
}