/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : �������ұ߷�����Ϣ���
 *	[ �ļ���      ]  : RightTopPanel.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��ViewList�ؼ�˼�룬ʵ�ַ���ͼ�껯
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
 *	[ ����˵��    ]  :		��ϸ˵���뿴���ڸ�������ͷ
 *
 *
 *  [ ��������    ]  : 
 *
 *######################################cn.lntu.t32##################
 */
package com.sunshine.mainframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;				//������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;


public class RightTopPanel 
extends JPanel 
implements ActionListener, MouseListener {
	
	private JButton rtbt1, rtbt2, rtbt3;
	private JTabbedPane rtp_tb;
	
	private JPanel rjp_bott;
	//������˲˵�
	private JPopupMenu pm;
	private JMenuItem mi1, mi2, mi3, mi4;
	
	//���淿������ViewList�ؼ����Ĺ�ϣ��
	private static Hashtable ht;
	//��ǰ��ǩ��ҳ
	private String tb_Name;
	//ɸѡ������Ϣ������	������ʾ
	private String sqlProviso = "";
	
	
	/**=======================================================================**
	 *		[## public RightTopPanel() {} ]: 				���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���齨�������ұ߷�����Ϣ���
	 **=======================================================================**
	 */
	public RightTopPanel() {
		super(new BorderLayout());
		
		//�������˲˵�
		pm = new JPopupMenu();
		mi1 = new JMenuItem("��ʾ�ɹ�");
		mi2 = new JMenuItem("��ʾͣ��");
		mi3 = new JMenuItem("��ʾռ��");
		mi4 = new JMenuItem("��ʾԤ��");
		
		pm.addSeparator();	//����˵���
		pm.add(mi1);
		pm.add(mi2);
		pm.add(mi3);
		pm.add(mi4);
		pm.addSeparator();
		
		//��ŷ�������
		ht = new Hashtable();
		//�������ͱ�ǩ��
		rtp_tb = new JTabbedPane();
		
		//������ǩ��
		buildJTabbedPane();
		
		//������ʼҳ
		rtp_tb.setSelectedIndex(Integer.parseInt(sunini.getIniKey("Default_Page")));
		
		//����ˢ�µȰ������
		rjp_bott = buildrjp_bott();		
		
		//���¼�����
		addListener();
		
		//�������
		this.add("South", rjp_bott);
		this.add("Center", rtp_tb);
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
		//���˲˵�
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		//��������
		rtbt2.addActionListener(this);
		rtbt3.addActionListener(this);
		//������
		rtbt1.addMouseListener (this);
		rtbt2.addMouseListener (this);
		rtbt3.addMouseListener (this);
		rtbt1.addMouseListener (this);
		rtp_tb.addMouseListener(this);
	}
	
	/**=======================================================================**
	 *		[## public void buildJTabbedPane() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ��������ǩ��
	 **=======================================================================**
	 */
	public void buildJTabbedPane() {
		try {
			//������з������͵����
			ResultSet rs = sunsql.executeQuery("select r_type,id from roomtype where delmark=0");
			rs.next();
			//������з������͵�����
			int roomtypeCount = sunsql.recCount(rs);
			String roomtypeName[] = new String[roomtypeCount];	//���淿������������
			String roomtypeId[]   = new String[roomtypeCount];	//���淿�����ͱ������
			
			//��������Ϣ���浽������
			for (int i = 0; i < roomtypeCount; i++) {
				rs.next();
				roomtypeName[i] = rs.getString(1);
				roomtypeId[i]	= rs.getString(2);
			}//Endfor
			
			String sqlCode = "";		//���ָ��������뷿��״̬��SQL���
			//��ʼ���������������
			for (int i = 0; i < roomtypeCount; i++) {
				
				sqlCode = "select id,state from roominfo where delmark=0 " +
				"and r_type_id='" + roomtypeId[i] + "' " + sqlProviso;
				
			    //����һ���������͵ı�ǩ����ҳ
			    JPanel jp = new JPanel(new GridLayout(1, 1));
			    //����ViewList��岢����jp
			    JPanel vl = buildViewList(sqlCode);
			    jp.add(vl);
			    rtp_tb.addTab(roomtypeName[i], jp);
			    
			    //����ǰ��������(ViewList�ؼ�)�����ϣ��
			    ht.put(roomtypeId[i], vl);
		    }//Endfor
		    tb_Name = rtp_tb.getTitleAt(0);		//��õ�ǰ��ǩ������
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }//Endtry
	}
	
	/**=======================================================================**
	 *		[## public JPanel buildViewList(String sqlCode) {} ]: 
	 *			����   ��String sqlCode�����ʾ����ݿ��л��ָ��������Ϣ
	 *			����ֵ ��JPanel
	 *			���η� ��public
	 *			����   ������ָ���������͵�ViewList�ؼ�
	 **=======================================================================**
	 */
	public JPanel buildViewList(String sqlCode) {
		ViewList vl = null;		//����һ��ViewList����
		String picName = "";	//����״̬ͼƬ���
		try {
			//���ָ���������͵����з������
			ResultSet vrs = sunsql.executeQuery(sqlCode);
			
			//���ָ���������͵����з�������
			int flag = sunsql.recCount(vrs);
			
			//�Է��������ʵ��ViewList�ؼ�
			vl = new ViewList(flag);
			
			//�����з�����뵽ViewList����
			for (int j = 0; j < flag; j++) {
				vrs.next();
				//��ViewList�н�������
				vl.addButton(vrs.getString(1)).addActionListener(this);
				vl.setButtonImage(vrs.getString(1), vrs.getString(2));
			}//Endfor
			
			//����û�дﵽҪ��ĸ���VL�Զ�����
			vl.remeButtons();
		    }
	    catch (Exception ex) {
	    	System.out.println ("RightTopPanel.buildViewList(): false");
	    }//Endtry
	    return vl;
	}
	
	/**=======================================================================**
	 *		[## public static JButton getViewListButton(String roomtypeID, String roominfoID) {} ]: 
	 *			����   ��String roomtypeID�����ʾ�����Ӧ�������ķ�������
	 *					 String roominfoID�����ʾ�밴���Ӧ�ķ������
	 *			����ֵ ��JButton
	 *			���η� ��public
	 *			����   ������뷿���Ӧ�İ���
	 **=======================================================================**
	 */
	public static JButton getViewListButton(String roomtypeID, String roominfoID) {
		return ((ViewList)ht.get(roomtypeID)).getButton(roominfoID);
	}
	
	/**=======================================================================**
	 *		[## public static void setViewListButtonImage(String roomtypeID, String roomNum, String state) {} ]: 
	 *			����   ��String roomtypeID�����ʾ�����Ӧ�������ķ�������
	 *					 String roominfoID�����ʾ�밴���Ӧ�ķ������
	 *					 String state �����ʾ����״̬
	 *			����ֵ ��JButton
	 *			���η� ��public
	 *			����   ������ָ�������״̬ͼƬ
	 **=======================================================================**
	 */
	public static void setViewListButtonImage(String roomtypeID, String roomID, String state) {
		((ViewList)ht.get(roomtypeID)).setButtonImage(roomID, state);
	}
	
	
	/**=======================================================================**
	 *		[## private void sxRoominfos() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����� [ sqlProviso ] ָ��������ˢ������Ϣ��ʾ
	 **=======================================================================**
	 */
	private void sxRoominfos() {
		//�õ���ǩ����ǰҳ��
		int tbSelectIndex = rtp_tb.getSelectedIndex();
		//��չ�ϣ��
		ht.clear();
		//��ձ�ǩ��
		rtp_tb.removeAll();
		//�����ڴ�
		System.gc();
		//�ؽ���ǩ��
		buildJTabbedPane();
		//���ñ�ǩ��Ϊ����ǰ����ʾҳ
		rtp_tb.setSelectedIndex(tbSelectIndex);
	}
	
	/**=======================================================================**
	 *		[## private JPanel buildrjp_bott() {} ]: 
	 *			����   ����
	 *			����ֵ ��JPanel
	 *			���η� ��private
	 *			����   �������������
	 **=======================================================================**
	 */
	private JPanel buildrjp_bott() {
		JPanel bott = new JPanel(new FlowLayout(FlowLayout.RIGHT,45,6));
		rtbt1 = new TJButton ("pic/choose.gif", "����״̬", "��ʾָ��״̬�ķ���");
		rtbt2 = new TJButton ("pic/browse.gif", "��ʾȫ��", "��ʾ���з���");
		rtbt3 = new TJButton ("pic/refurbish.gif", "  ˢ   ��  ", "ˢ�·�����Ϣ");
		
		bott.add(rtbt2);
		bott.add(rtbt1);
		bott.add(rtbt3);
		
		return bott;
	}
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed (ActionEvent ae) {
		Object o = ae.getSource();
		if(o == rtbt2) {							//��ʾȫ��
			sqlProviso = "";
			sxRoominfos();	//�ؽ���ǩ��
			return;
		}else if(o == rtbt3) {						//ˢ��
			sxRoominfos();	//�ؽ���ǩ��
			return;
		}else if(o == mi1) {						//��ʾ�ɹ�
			sqlProviso = "and state='�ɹ�'";
			sxRoominfos();	//�ؽ���ǩ��
			return;
		}else if(o == mi2) {						//��ʾͣ��
			sqlProviso = "and state='ͣ��'";
			sxRoominfos();	//�ؽ���ǩ��
			return;
		}else if(o == mi3) {						//��ʾռ��
			sqlProviso = "and state='ռ��'";
			sxRoominfos();	//�ؽ���ǩ��
			return;
		}else if(o == mi4) {						//��ʾԤ��
			sqlProviso = "and state='Ԥ��'";
			sxRoominfos();	//�ؽ���ǩ��
			return;
		}//Endif
		
		//ˢ����������ߵ���Ϣ
		String chooseRoomNum = ((JButton)o).getText();
		LeftTopPanel.title0.setText(tb_Name + ": ");
		LeftTopPanel.title1.setText(chooseRoomNum);
		try {
			//������ƣ���סʱ�䣬�ѽ�Ѻ������ʱ��
			ResultSet rs = sunsql.executeQuery("select c_name,in_time,foregift " +
			"from livein where delmark=0 and statemark='�������' and r_no='" + chooseRoomNum + "'");
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
			"r_type_id from roominfo where delmark=0 and id='" + chooseRoomNum + 
			"') b where a.delmark=0 and a.id=b.r_type_id");
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
				
	    }
	    catch (Exception ex) {
	    	//ex.printStackTrace();
	    	System.out.println ("RightTopPanel.actionPerformed(): false");
	    }//Endtry
	}
	
	/**=======================================================================**
	 *			MouseListener ����
	 **=======================================================================**
	 */
	public void mouseClicked (MouseEvent me) {
		Object o = me.getSource();
		if(o == rtp_tb) {
			tb_Name = rtp_tb.getTitleAt(rtp_tb.getSelectedIndex());		//��õ�ǰ��ǩ������
			LeftTopPanel.title0.setText(tb_Name + ": ");
			LeftTopPanel.title1.setText("");
			LeftTopPanel.lt[0].setText("");
			LeftTopPanel.lt[1].setText("");
			LeftTopPanel.lt[2].setText("");
			LeftTopPanel.lt[3].setText("");
			LeftTopPanel.lt[4].setText("");
			LeftTopPanel.lt[5].setText("");
			LeftTopPanel.lt[6].setText("");
			LeftTopPanel.lt[7].setText("");
		}else if(o == rtbt1) {							//����״̬
			int x = me.getX();
			int y = me.getY();
			pm.show(rtbt1, x, y);
		}//Endif
	}

	public void mousePressed (MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered (MouseEvent me) {		//����ƽ���ʾ
		Object o = me.getSource ();
		if(o == rtbt1) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"����ָ����״̬��ʾ������Ϣ   ����������������������������");
		}else if(o == rtbt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ʾ���еķ�����Ϣ   ������������������������������������");
		}else if(o == rtbt3) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ˢ�µ�ǰ������Ϣ��ʾ   ����������������������������������");
		}//Endif
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + 
		"��ѡ������ ...   ����������������������������������������");
	}
}