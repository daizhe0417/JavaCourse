/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ����¿ͷ�����
 *	[ �ļ���      ]  : AddRoomType.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ����¿ͷ����͵�����
 *	[ ����        ]  : 
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
 *	[## public AddRoomType(JDialog dialog) {} ]:
 *		����: ����µĿͷ�����
 *
 *	[## private void buildPC() {} ]:
 *		����: ���������������
 *
 *	[## private boolean isValidity() {} ]:
 *		����: �����û����������Ƿ�Ϸ�
 *
 *	[## private void saveRoomType() {} ]:�������
 *		����: �������
 *
 *  [ ��������    ]  : 
 *
 *##############cn.lntu.t32##############################################
 */
package com.sunshine.setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;			//�������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.HotelFrame;	//����ܴ���


public class AddRoomType 
extends JDialog 
implements ActionListener {
	
	private JTextField tf0, tf1, tf2, tf3, tf4, tf5;
	private JCheckBox chk;
	private JButton bt1, bt2;
	private JPanel panelMain, pc, ps;
	
	
	
	/**=======================================================================**
	 *		[## public AddRoomType(JDialog dialog) {} ]: 		���캯��
	 *			����   ��JDialog�����ʾ���Ի���ĸ�����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ������µĿͷ�����
	 **=======================================================================**
	 */
	public AddRoomType(JDialog dialog) {
		super(dialog,"��������",true);
		
		bt1 = new TJButton ("pic/save.gif", " ��  �� ", "���淿������"); 
		bt2 = new TJButton ("pic/cancel.gif", " ȡ  �� ", "����ǰ����"); 
		
		JLabel lb = new JLabel();			//�ٿո�
		panelMain = new JPanel(new BorderLayout(0, 0));
		pc 		  = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		ps		  = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 6));
		
		//�������
		ps.add(bt1);
		ps.add(bt2);
		
		buildPC();							//���������������
		
		//���������
		panelMain.add("North", lb);
		panelMain.add("Center",pc);
		panelMain.add("South", ps);
		
		//���¼�����
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		tf0.addActionListener(this);		//Ϊ�ı���Ӽ���
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
		tf5.addActionListener(this);
		chk.addActionListener(this);
		
		this.setContentPane(panelMain);
		this.setPreferredSize(new Dimension(300, 305));
		this.setMinimumSize(new Dimension(300, 305));
		this.setResizable(false);			//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);		//������Ļ����
	}
	
	/**=======================================================================**
	 *		[## private void buildPC() {} ]: 		���������������
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����������������
	 **=======================================================================**
	 */
	private void buildPC() {
		JPanel pc1, pc2, ck;
		JLabel lb0, lb1, lb2, lb3, lb4, lb5, lb6, lb7;
		
		pc1 = new JPanel(new GridLayout(6, 1, 0, 10));		//�������
		pc2 = new JPanel(new GridLayout(6, 1, 0,  7));
		ck	= new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
		
		lb0 = new JLabel("���ͱ�ţ�");
		lb1 = new JLabel("�������ͣ�");
		lb2 = new JLabel("��λ������");
		lb3 = new JLabel("Ԥ�赥�ۣ�");
		lb4 = new JLabel("Ԥ��Ѻ��");
		lb5 = new JLabel("�ӵ�Ʒѣ�");
		lb6 = new JLabel("/��");
		lb7 = new JLabel("/Сʱ");
		
		chk = new JCheckBox("�����?�ӵ㷿��������������");
		chk.setSelected(true);
		
		tf0 = new TJTextField(10);
		tf1 = new TJTextField(10);
		tf2 = new TJTextField("1", 10);
		tf3 = new TJMoneyField();
		tf4 = new TJMoneyField();
		tf5 = new TJMoneyField();
		
		tf2.setHorizontalAlignment(JTextField.RIGHT);
		
		//�������
		pc1.add(lb0);
		pc1.add(lb1);
		pc1.add(lb2);
		pc1.add(lb3);
		pc1.add(lb4);
		pc1.add(lb5);
		
		pc2.add(tf0);
		pc2.add(tf1);
		pc2.add(tf2);
		pc2.add(tf3);
		pc2.add(tf4);
		pc2.add(tf5);
		
		ck.add(chk);
		
		pc.add(pc1);
		pc.add(pc2);
		pc.add(ck);
		
		pc.setBorder (BorderFactory.createTitledBorder("�·�������"));
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
		if(tf0.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "���� [ ���ͱ�� ] ����Ϊ��", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf0.requestFocus(true);
			return false;
		}else if(tf1.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "���� [ ������� ] ����Ϊ��", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf1.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf2.getText(), 2, 1, 10)) {
			JOptionPane.showMessageDialog(null, "[ ��λ���� ] ֻ�������֣��ҷ�Χ�� 1-10 ֮��", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf2.requestFocus(true);
			return false;
		}else if(Double.parseDouble(tf3.getText()) >= Double.parseDouble(tf4.getText())) {
			JOptionPane.showMessageDialog(null, " [ Ԥ��Ѻ�� ] ����Ҫ���� [ Ԥ�赥�� ]", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf2.requestFocus(true);
			return false;
		}//Endif
		return true;
	}
	
	/**=======================================================================**
	 *		[## private void saveRoomType() {} ]: 	�������
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ���������
	 **=======================================================================**
	 */
	private void saveRoomType() {
		if(isValidity()) {					//˨���û����������Ƿ�Ϸ�
			try {
				ResultSet rs = sunsql.executeQuery("select r_type from roomtype " +
				"where delmark=0 and id='" + tf0.getText() + "'");
				if(rs.next()) {			//����µ����ͱ���Ƿ����
					JOptionPane.showMessageDialog(null, "�µķ������ͱ�� [ " + tf0.getText() +
					" ] �Ѵ��ڣ�����ִ����Ӳ����������º˶� ...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					tf0.requestFocus(true);
					return;
				}//Endif
				rs = sunsql.executeQuery("select id from roomtype " +
				"where delmark=0 and r_type='" + tf1.getText() + "'");
				if(rs.next()) {			//����µ���������Ƿ����
					JOptionPane.showMessageDialog(null, "�µķ���������� [ " + tf1.getText() +
					" ] �Ѵ��ڣ�����ִ����Ӳ����������º˶� ...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					tf1.requestFocus(true);
					return;
				}//Endif
				String Code = "select distinct pk,id,c_type from customertype where delmark = 0 and pk!=0";
				rs = sunsql.executeQuery(Code);
				int cus = sunsql.recCount(rs);
				System.out.println (cus);
				String sqlCode[] = new String[cus + 1];
				for (int i = 0; i < cus; i++) {
					rs.next();
					//��ɸ��¿ͻ����ͱ��SQL���
					sqlCode[i] = "insert into customertype(pk,id,c_type,dis_attr,price) " +
					"values(" + rs.getLong(1) + ",'" + rs.getString(2) + "','" + rs.getString(3) + 
					"','" + tf0.getText() + "'," + tf3.getText() + ")";
			    }
				
				String flag = "N";
				if(chk.isSelected()) {
					flag = "Y";
				}//Endif
				long pk = sunsql.getPrimaryKey();
				//��ɸ��·������ͱ��SQL���
				sqlCode[cus] = "insert into roomtype(pk,id,r_type,bed,price,foregift,cl_room," +
				"cl_price) values(" + pk + ",'" + tf0.getText() + "','" + tf1.getText() + "'," + 
				tf2.getText() + "," + tf3.getText() + "," + tf4.getText() + ",'" + flag + "'," + 
				tf5.getText() + ")";
				
				int rec = sunsql.runTransaction(sqlCode);			//����ݱ��浽��ݿ�
				if(rec < sqlCode.length) {
					JOptionPane.showMessageDialog(null, "�����µķ���������Ϣʧ�ܣ�" +
					"�����������ӻ���ϵ����Ա", "����", JOptionPane.ERROR_MESSAGE);
				}else {
					String journal = "������µķ�������-- [ " + tf1.getText() + " ]";
					Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_RT);//��¼������־
					tf0.setText("");		//����ɹ��������пؼ�����
					tf1.setText("");
					tf2.setText("1");
					tf3.setText("0");
					tf4.setText("0");
					tf5.setText("0");
					tf5.setEnabled(true);
					chk.setSelected(true);
					tf0.requestFocus(true);
				}//Endif
		    }
		    catch (Exception ex) {
		    	System.out.println ("AddRoomType false");
		    }//End try
		}//Endif
	}//End saveRoomType
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == bt1) {					//��������
			saveRoomType();
		}else if(o == bt2) {			//ȡ�����
			this.setVisible(false);
		}else if(o == tf0) {
			tf1.requestFocus(true);
		}else if(o == tf1) {
			tf2.requestFocus(true);
		}else if(o == tf2) {
			tf3.requestFocus(true);
		}else if(o == tf3) {
			tf4.requestFocus(true);
		}else if(o == tf4) {
			if(tf5.isEnabled()) {		//��������ӵ㷿���������۸�
				tf5.requestFocus(true);
			}else
				saveRoomType();			//��������
		}else if(o == tf5) {
			saveRoomType();				//��������
		}else if(o == chk) {
			if(chk.isSelected()) {
				tf5.setEnabled(true);
				tf5.requestFocus(true);
			}else {
				tf5.setEnabled(false);
				tf0.requestFocus(true);
			}//Endif
			tf5.setText("0");
		}//Endif
	}//End actionPerformed
}