/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ��������·�����Ϣ����
 *	[ �ļ���      ]  : AddRoomInfos.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ʵ�ֶ��·�����Ϣ���������
 *	[ ����        ]  
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
 *	[## public AddRoomInfoa(JDialog dialog) {} ]:
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
 *	[## private void saveRoomInfos() {} ]: 
 *		����: ���淿����Ϣ
 *
 *  [ ��������    ]  : 
 *
 *#cn.lntu.t32###########################################################
 */
package com.sunshine.setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;			//������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.HotelFrame;	//������


public class AddRoomInfos
extends JDialog 
implements ActionListener {
	
	public static JComboBox cb;
	private JTextField tf1, tf2, tf3, tf4;
	private JButton bt1, bt2;
	
	private JPanel panelMain, pc, ps;
	
	/**=======================================================================**
	 *		[## public AddRoomInfos(JDialog dialog) {} ]: 	���캯��
	 *			����   ��JDialogΪ������
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ����������µķ�����Ϣ
	 **=======================================================================**
	 */
	public AddRoomInfos(JDialog dialog) {
		super(dialog, "������ӷ���", true);
		
		JLabel lb = new JLabel();			//�ٿո�
		panelMain = new JPanel(new BorderLayout());
		pc 		  = new JPanel();			//��Ϣ���
		ps 		  = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 6));
		
		//������Ϣ���
		buildPC();
		//�����������
		buildPS();
		
		//�������
		panelMain.add("North", lb);
		panelMain.add("Center",pc);
		panelMain.add("South", ps);
		
		//�����¼�����
		addListener();
		
		this.setContentPane(panelMain);
		this.setPreferredSize(new Dimension(300, 298));
		this.setMinimumSize(new Dimension(300, 298));
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
		tf4.addActionListener(this);
		cb.addActionListener(this);
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
		JPanel pc1, pc2, pc3, pc4, pc5, pc6;
		JLabel lb0, lb1, lb2, lb3, lb4, lb5, lb6;
		
		lb0 = new JLabel("��  ");		//��λ���õļٿո�
		lb1 = new JLabel("�������ͣ�");
		lb2 = new JLabel("��ʼ���ţ�");
		lb3 = new JLabel("��ֹ���ţ�");
		lb4 = new JLabel("����ַ�");
		lb5 = new JLabel("��������");
		lb6 = new JLabel("   ע�⣺������ӷ��䣬�������λ��Ϊ����绰��");
		lb6.setForeground(new Color(255, 138, 0));

		tf1 = new TJTextField(10);		//��ʼ�����
		tf2 = new TJTextField(10);		//��ֹ�����
		tf3 = new TJTextField(10);		//����ַ�
		tf4 = new TJTextField(10);		//��������
				
		cb = new JComboBox();
		cb.setMaximumRowCount(5);			//����JComboBox����������ʾ������
		String sql = "select r_type from roomtype where delmark = 0";
		//��ʼ����������
		sunsql.initJComboBox(cb,sql);
		
		pc1 = new JPanel();
		pc2 = new JPanel();
		pc3 = new JPanel();
		pc4 = new JPanel();
		pc5 = new JPanel();
		pc6 = new JPanel(new GridLayout(5,1));
		
		//�������
		pc1.add(lb1);		//��������
		pc1.add(cb);
		pc1.add(lb0);
		pc2.add(lb2);		//��ʼ����
		pc2.add(tf1);
		pc3.add(lb3);		//��ֹ����
		pc3.add(tf2);
		pc4.add(lb4);		//����ַ�
		pc4.add(tf3);
		pc5.add(lb5);		//��������
		pc5.add(tf4);
		
		pc6.add(pc2);
		pc6.add(pc3);
		pc6.add(pc4);
		pc6.add(pc5);
		pc6.add(lb6);
		
		//���������
		pc.add(pc1);
		pc.add(pc6);
		
		pc.setBorder (BorderFactory.createTitledBorder("�����������"));
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
		if(!suntools.isNum(tf1.getText(), 4, 1000, 9999)) {
			JOptionPane.showMessageDialog(null, "[ ��ʼ���� ] ֻ�������֣��Ϊ4λ��" +
			"��Χ 1000-9999 ֮��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf1.requestFocus(true);
			return false;
		}else if(!suntools.isNum(tf2.getText(), 4, 1000, 9999)) {
			JOptionPane.showMessageDialog(null, "[ ��ֹ���� ] ֻ�������֣��Ϊ4λ��" +
			"��Χ 1000-9999 ֮��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf2.requestFocus(true);
			return false;
		}else if(tf3.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "���ŵ� [ ����ַ� ] ����Ϊ��", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf3.requestFocus(true);
			return false;
		}else if(tf4.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "���� [ �������� ] ����Ϊ��", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf4.requestFocus(true);
			return false;
		}else if(Integer.parseInt(tf1.getText()) >= Integer.parseInt(tf2.getText())) {
			JOptionPane.showMessageDialog(null, "ע�� [ ��ʼ���� ] ����С�� [ ��ֹ���� ]", "��ʾ", 
			JOptionPane.INFORMATION_MESSAGE);
			tf1.requestFocus(true);
			return false;
		}//Endif
		return true;
	}
	
	/**=======================================================================**
	 *		[## private void saveRoomInfos() {} ]: 	
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   �����淿����Ϣ
	 **=======================================================================**
	 */
	private void saveRoomInfos() {
		if(isValidity()) {				//������������Ƿ�Ϸ�
			//����·������Ƿ����Ѵ��ڵķ���
			int rooms = Integer.parseInt(tf1.getText());
			int roomn = Integer.parseInt(tf2.getText());
			long pk   = 0;								//����
			String rnum[] = new String[roomn-rooms + 1];		//���巿������
			try {
				ResultSet rs = sunsql.executeQuery("select id from roomtype " +
				"where delmark=0 and r_type='" + cb.getSelectedItem() + "'");	//��÷������ͱ��
				rs.next();
				String rType = rs.getString(1);				//�ѷ������ͱ�Ŵ���rType����
				pk = sunsql.getPrimaryKey();				//����
				for (int i = 0; i < roomn - rooms + 1; i++) {
					rnum[i] = tf3.getText() + (rooms + i);	//��ô��ǵķ����
					rs = sunsql.executeQuery("select * from roominfo where " +
					"delmark=0 and id='" + rnum[i] + "'");	//ȥ��ݿ����Ƿ�Ϸ�
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "������� [ " + rnum[i] + " ] �Ѵ��ڣ�" +
						"���������ӣ���˶Է�����Ϣ", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						tf1.requestFocus(true);
						return;
					}//Endif
					//����SQL���
					rnum[i] = "insert into roominfo(pk,id,r_type_id,state,location,r_tel) values(" +
					pk + ",'" + rnum[i] + "','" + rType + "','�ɹ�','" + tf4.getText() + "','" + (rooms + i) + "')";
					pk++;					//����++��ѭ������̫�죬���׳����ظ�����������++
		  		}//Endfor
		  		int temp = sunsql.runTransaction(rnum);
		  		if(temp < rnum.length) {
					JOptionPane.showMessageDialog(null, "�����µķ������Ϣʧ�ܣ�" +
					"�����������ӻ���ϵ����Ա", "����", JOptionPane.ERROR_MESSAGE);
					return;
				}//Endif
				String journal = "ִ���� [ " + cb.getSelectedItem() + " ] ���������--��ʼ���� [ " + tf3.getText() + 
				rooms + " ] ����������" + (roomn - rooms + 1);
				Journal.writeJournalInfo(HotelFrame.userid, journal, Journal.TYPE_RI);//��¼������־
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				cb.setSelectedIndex(0);
				this.setVisible(false);
		    }
		    catch (Exception ex) {
		    ex.printStackTrace();
		    //	System.out.println ("AddRoomInfos.saveRoomInfos false");
		    }//Endtry
		}//Endif
	}
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == bt1) {
			saveRoomInfos();			//����
		}else if(o == bt2) {
			this.setVisible(false);		//ȡ��
		}else if(o == tf1) {
			tf2.requestFocus(true);		//��ʼ�����
		}else if(o == tf2) {
			tf3.requestFocus(true);		//��ֹ�����
		}else if(o == tf3) {
			tf4.requestFocus(true);		//����ַ�
		}else if(o == tf4) {			//��������
			saveRoomInfos();			//����
		}//Endif
	}
}