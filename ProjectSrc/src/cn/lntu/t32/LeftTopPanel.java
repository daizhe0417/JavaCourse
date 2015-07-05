/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ����������ϲ����
 *	[ �ļ���      ]  : ModiRoomType.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��ʾʱ�ӣ�ָ������״̬���ͱ�ǩ
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
 *	[## public LeftTopPanel() {} ]:
 *		����: �������������ϲ����
 *
 *	[## private void buildHabitus () {} ]: 
 *		����: ����״̬ҳ
 *
 *	[## public void initRoomstate() {} ]: 
 *		����: ��ʼ��������״̬
 *
 *	[## public void run() {} ]: 
 *		����: ʱ���߳�
 *
 *  [ ��������    ]  : 
 *
 *###################cn.lntu.t32#####################################
 */
package com.sunshine.mainframe;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;			//������
import com.sunshine.sunsdk.swing.*;



public class LeftTopPanel 
extends JPanel 
implements ActionListener, Runnable {
	//������Ϣ
	public static JLabel title0, title1, title2, line;
	public static JLabel lt[] = new JLabel[13];
	
	//ʱ����ʱ�Ӱ���
	private JTextField lt_Clock;
	private JButton clock_Button;
	
	//��ǩ��������
	private TJTextArea lt_ta;
	private JScrollPane lt_sp;
	
	//��ǩ��������
	private JTabbedPane lt_tp;
	private JPanel habitus, notepaper;			//״̬����ǩ
	
	
	
	/**=======================================================================**
	 *		[## public LeftTopPanel() {} ]: 				���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���������������ϲ����
	 **=======================================================================**
	 */
	public LeftTopPanel () {
		super (new BorderLayout());
		
		lt_Clock = new JTextField();						//����ʱ��
		lt_tp	 = new JTabbedPane (JTabbedPane.BOTTOM);	//��ǩ��

		lt_Clock.setEditable(false);						//����ʱ��
		lt_Clock.setForeground(new Color (99, 130, 191));
		lt_Clock.setFont (new Font ("����", Font.BOLD, 13));
		lt_Clock.setHorizontalAlignment (JTextField.CENTER);
		
		//����״̬ҳ
		buildHabitus ();
		
		//������ǩҳ
		buildNotepaper ();
		
		//������ǩ��
		lt_tp.addTab("״̬", new ImageIcon("pic/b1.gif"), habitus);
		lt_tp.addTab("��ǩ", new ImageIcon("pic/b2.gif"), notepaper);
		
		//��ʼ��������״̬
		initRoomstate();
		
		this.add("North", lt_Clock);
		this.add("Center", lt_tp);
		(new Thread(this)).start();				//����ʱ���߳�
	}
	
	/**=======================================================================**
	 *		[## private void buildHabitus () {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ������״̬ҳ
	 **=======================================================================**
	 */
	private void buildHabitus (){
		String lbText[] = { "  ��������", "  Ԥ�赥�ۣ�", "  ����绰��", "  ��������", 
							"  ���ʱ�䣺", "  ����ʱ�䣺", "  �ѽ�Ѻ��", "  Ӧ�ս�", 
							"  ��������", "  ��ǰռ�ã�", "  ��ǰ�ɹ���", "  ��ǰԤ����", 
							"  ��ǰͣ�ã�" };
							
		JLabel lb[] = new JLabel[13];
		JPanel jp1, jp2, jp3 ,jp4, jp5, jp6, jp7, jp8;
		
		//���ñ���
		title0 = new JLabel("��׼���˼�: ");
		title1 = new JLabel("");
		title2 = new JLabel("������״̬");
		line   = new JLabel(new ImageIcon("pic/line2.gif"));
		title0.setForeground(Color.red);
		title1.setForeground(Color.red);
		title2.setForeground(Color.red);
		title0.setFont (new Font ("����", Font.PLAIN, 14));
		title1.setFont (new Font ("����", Font.PLAIN, 14));
		title2.setFont (new Font ("����", Font.PLAIN, 14));
		
		//�������
		habitus = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new GridLayout(8, 1));
		jp3 = new JPanel(new GridLayout(8, 1));
		jp4 = new JPanel(new GridLayout(5, 1));
		jp5 = new JPanel(new GridLayout(5, 1));
		jp6 = new JPanel(new BorderLayout());
		jp7 = new JPanel(new BorderLayout());
		jp8 = new JPanel(new GridLayout(2, 1));
		
		//��ʼ����ǩ����////////////////////////////////////���������ʾ�ӿ�////
		for (int i = 0; i < 8; i++) {			//�����һ����
			lb[i] = new JLabel(lbText[i]);
			lt[i] = new JLabel("");
			lt[i].setForeground(Color.BLUE);
			jp2.add(lb[i]);
			jp3.add(lt[i]);
	    }
	    for (int i = 8; i < 13; i++) {			//����ڶ�����
			lb[i] = new JLabel(lbText[i]);
			lt[i] = new JLabel("");
			lt[i].setForeground(Color.BLUE);
			jp4.add(lb[i]);
			jp5.add(lt[i]);
	    }
	    
		//������������
		jp1.add(title0);
		jp1.add(title1);
		jp8.add(line);				
		jp8.add(title2);
		
		habitus.add(jp1);			//�ӱ���
		habitus.add(jp2);			//�ӷ�����Ϣ
		habitus.add(jp3);
		habitus.add(jp8);			//�ӷָ��ߺ����淿��״̬�ı���
		habitus.add(jp4);			//�ӷ���״̬��Ϣ
		habitus.add(jp5);
	}
	
	/**=======================================================================**
	 *		[## private void buildNotepaper () {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ��������ǩҳ
	 **=======================================================================**
	 */
	private void buildNotepaper () {
		clock_Button = new TJButton("pic/clock.gif", "��ǩ���ʱ��", "���뵱ǰʱ��");
		lt_ta = new TJTextArea(25, 4);
		lt_sp = new JScrollPane(lt_ta);
		
		notepaper = new JPanel(new BorderLayout());
		//���ù������û�к��������
		lt_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//�Ӽ�����
		clock_Button.addActionListener(this);
		
		notepaper.add("North", clock_Button);
		notepaper.add("Center", lt_sp);
	}
	
	/**=======================================================================**
	 *		[## public void initRoomstate() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ʼ��������״̬
	 **=======================================================================**
	 */
	public void initRoomstate() {
		try {
			ResultSet rs = sunsql.executeQuery("select count(*) from roominfo where delmark=0");
			rs.next();
			lt[8].setText(rs.getString(1));		//��������
			rs = sunsql.executeQuery("select count(*) from roominfo where delmark=0 and state='ռ��'");
			rs.next();
			lt[9].setText(rs.getString(1));
			rs = sunsql.executeQuery("select count(*) from roominfo where delmark=0 and state='�ɹ�'");
			rs.next();
			lt[10].setText(rs.getString(1));
			rs = sunsql.executeQuery("select count(*) from roominfo where delmark=0 and state='Ԥ��'");
			rs.next();
			lt[11].setText(rs.getString(1));
			rs = sunsql.executeQuery("select count(*) from roominfo where delmark=0 and state='ͣ��'");
			rs.next();
			lt[12].setText(rs.getString(1));
	    }
	    catch (Exception ex) {
	    	System.out.println ("LeftTopPanel.initRoomstate(): false");
	    }//End try
	}
	
	/**=======================================================================**
	 *		[## public void run() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ��ʱ���߳�
	 **=======================================================================**
	 */
	public void run() {
		while( true ) {
			GregorianCalendar gc = new GregorianCalendar();
			lt_Clock.setText(gc.getTime().toLocaleString());
			try {
				Thread.sleep(500);
		    }
		    catch (Exception ex) {
		    }//End try
		}//End while
	}
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed (ActionEvent ae) {
		if(ae.getSource() == clock_Button) {
			lt_ta.append("\n---" + lt_Clock.getText() + "---\n");
			lt_ta.requestFocus(true);
		}//Enif
	}
	
}