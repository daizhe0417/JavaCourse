/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ����������²����
 *	[ �ļ���      ]  : LeftBottPanel.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ����ͨ��������ʵ�����뷿���������ʾ��Ϣ
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
 *	[## public LeftBottPanel() {} ]:
 *		����: �������������²����
 *
 *
 *  [ ��������    ]  : 
 *
 *############################cn.lntu.t32############################
 */
package com.sunshine.mainframe;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;			//������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;


public class LeftBottPanel
extends JPanel
implements ActionListener, MouseListener, FocusListener {
	
	private TJTextField tf;
	private JLabel lb;
	
	/**=======================================================================**
	 *		[## public LeftBottPanel() {} ]: 				���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���������������²����
	 **=======================================================================**
	 */
	public LeftBottPanel() {
		//���������Ϊ�߽粿��
		super (new BorderLayout());
		
		lb = new JLabel (new ImageIcon ("pic/sunshine.gif"));
		tf = new TJTextField ("     �� �� ͨ ��", 10);
		lb.setBorder (new LineBorder (new Color (199, 183, 143)));
		tf.setLineWidth(1);
		//����������ʾ��Ϣ
		tf.setToolTipText("���뷿����룬��ֱ�ӻ�÷����������Ϣ");
		//��������
		tf.setFont (new Font ("����", Font.PLAIN, 15));
		
		this.add ("North", tf);
		this.add ("Center", lb);
		
		tf.addActionListener(this);
		tf.addMouseListener (this);
		tf.addFocusListener (this);
	}
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed (ActionEvent ae) {
		try {
			ResultSet rs = sunsql.executeQuery("select a.r_type from roomtype " +
			"a,(select r_type_id from roominfo where delmark=0 and id='" + tf.getText() + 
			"') b where a.delmark=0 and a.id=b.r_type_id");			//��õ�ǰ������������
			
			if(rs.next()) {
				
				String chooseRoomNum = tf.getText();
				LeftTopPanel.title0.setText(rs.getString(1));
				LeftTopPanel.title1.setText(chooseRoomNum);
				
				//������ƣ���סʱ�䣬�ѽ�Ѻ������ʱ��
				rs = sunsql.executeQuery("select c_name,in_time,foregift from livein " +
				"where delmark=0 and statemark='�������' and r_no='" + chooseRoomNum + "'");
				
				//��סʱ��
				String inTime = "";
				
				if(rs.next()) {
					LeftTopPanel.lt[0].setText(rs.getString(1));
					inTime = rs.getString(2);
					LeftTopPanel.lt[4].setText(inTime.substring(0, 10));
					LeftTopPanel.lt[5].setText(suntools.getConsumeHour(inTime, Journal.getNowDTime()));
					LeftTopPanel.lt[6].setText(rs.getString(3));
				}else {
					LeftTopPanel.lt[0].setText("");
					LeftTopPanel.lt[4].setText("");
					LeftTopPanel.lt[5].setText("");
					LeftTopPanel.lt[6].setText("");
				}//Endif
				
				//�����������򣬷���绰		˳��ȡ������״̬Ϊ������ס�޻����ӵ㷿
				rs = sunsql.executeQuery("select r_tel,location,state from roominfo where id='" + 
				chooseRoomNum + "' and delmark=0");
				if(rs.next()) {
					LeftTopPanel.lt[2].setText(rs.getString(1));
					LeftTopPanel.lt[3].setText(rs.getString(2));
				}else {
					LeftTopPanel.lt[2].setText("");
					LeftTopPanel.lt[3].setText("");
				}//Endif
				
				//��÷���״̬
				String rState = rs.getString(3);
				
				//Ԥ�跿��,�ӵ㷿��		����SQL�����ͨ���Ż�÷������ͱ�׼����, �ӵ㷿��Ϊ����Ӧ�ս�������
				rs = sunsql.executeQuery("select a.price,a.cl_price from roomtype a, (select " +
				"r_type_id from roominfo where delmark=0 and id='" + chooseRoomNum + "') b where " +
				"a.delmark=0 and a.id=b.r_type_id");
				if(rs.next())
					LeftTopPanel.lt[1].setText("��" + rs.getString(1));
				else 
					LeftTopPanel.lt[1].setText("");
				
				//��÷���״̬��ѡ��Ʒѷ�ʽ----����
				double money = 0;
				if(rState.equals("ռ��"))			//��ͨ��ס�Ʒѵ���
					money = Double.parseDouble(LeftTopPanel.lt[1].getText().substring(1));
				else
					money = rs.getDouble(2);		//�ӵ㷿�Ʒѵ���
				
				//Ӧ�ս��		����SQL�����ͨ���Ż�ñ����ۿ۱���
				rs = sunsql.executeQuery("select a.discount from customertype a," +
				"(select c_type_id,r_type_id from livein  where r_no='" + chooseRoomNum + 
				"' and statemark='�������' and delmark=0) b where a.delmark=0 and " +
				"a.id=b.c_type_id and a.dis_attr=b.r_type_id");
				
				if(rs.next()) {
					if(rState.equals("ռ��"))		//������ͨ��סӦ�շ���
						money = money * suntools.getConsumeFactor(inTime, Journal.getNowDTime());
					else							//�����ӵ㷿Ӧ�շ���
						money = money * suntools.getClockFactor(inTime, Journal.getNowDTime());
					
					//�Ա����ۿ۱�����۵�ǰӦ�ս��
					money = money * rs.getDouble(1)/10;
					LeftTopPanel.lt[7].setText("��" + money);
				}else {
					LeftTopPanel.lt[7].setText("");
				}//Endif
				
				//ˢ�������������
				if(rState.equals("�ɹ�")) {
					RightBottPanel.listRightBottDTM("", false);		//ִ��ˢ��
				}else {
					String rbCode = "select a.in_no ��ס����,a.main_room �������,b.price " +
					"��׼����,b.c_type ��������,b.discount �����ۿ�,b.dis_price ��ѽ��,in_time " +
					"���ʱ��,userid ������ from livein a, customertype b where a.r_no='" + 
					chooseRoomNum + "' and " + "statemark='�������' and a.c_type_id=b.id " +
					"and b.dis_attr=a.r_type_id and a.delmark=0";
				
					RightBottPanel.listRightBottDTM(rbCode, true);		//ִ��ˢ��
				}//Endif
				
			}else {
				JOptionPane.showMessageDialog(null, "ϵͳ��û�� [ " + tf.getText() +
				" ] �ķ�����Ϣ", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			}//Endif
	    }
	    catch (Exception ex) {
	    	System.out.println ("LeftBottPanel.actionPerformed() false");
	    }//Endtry
	    tf.requestFocus(false);
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
		HotelFrame.lbA.setText (HotelFrame.clue + 
		"���뷿����룬��ֱ�ӻ�÷����������Ϣ   ����������������");
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + 
		"��ѡ������ ...   ����������������������������������������");
	}
	
	/**=======================================================================**
	 *			FocusListener ����
	 **=======================================================================**
	 */
	public void focusGained (FocusEvent fe) {
		//�������
		tf.setText("");
	}
	
	public void focusLost (FocusEvent fe) {
		//ʧȥ�������
		tf.setText("     �� �� ͨ ��");
	}
}