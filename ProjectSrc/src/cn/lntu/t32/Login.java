/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : ����Ƶ����ϵͳ
 *  [ ��˾��      ]  : �廪IT
 *	[ ģ����      ]  : ϵͳ��½����
 *	[ �ļ���      ]  : Login.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ϵͳ��½����
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
 *	[## public Login() {} ]:
 *		����: ���캯��	�齨��¼����
 *
 *	[## private void buildCenter() {} ]:
 *		����: �齨�û���������壬������ʹ��
 *
 *	[## private void quit() {} ]: 
 *		����: �ر�ϵͳ���������ʹ��
 *
 *	[## private void dengLu() {} ]:
 *		����: ������֤ͨ��������������棬������ʹ��
 *
 *  [ ��������    ]  : 
 *
 *############cn.lntu.t32################################################
 */
package com.sunshine.login;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.*;


public class Login extends JFrame
implements ActionListener, KeyListener, ItemListener, FocusListener {
	
	JLabel top, bott;
	JComboBox cb;
	JPasswordField pf;
	JButton bt1, bt2;
	JPanel panelMain, panelInfo;
	String clue = "    �� ʾ :  ";
	int flag	= 0;		//�ǼǴ��������
	
	
	
	/**=======================================================================**
	 *		[## public Login() {} ]: 					���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���齨��¼����
	 **=======================================================================**
	 */
	public Login() {
		super("ϵ ͳ �� ¼");
		top = new JLabel (new ImageIcon("pic/login_top.gif"));
		bott = new JLabel();
		panelMain = new JPanel(new BorderLayout(10, 10));
		bott.setBorder(new LineBorder (new Color(184, 173, 151)));
		buildCenter();
		
		panelMain.add("North", top);
		panelMain.add("South", bott);
		panelMain.add(panelInfo);
		
		//���¼�����
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt1.addFocusListener (this);
		bt2.addFocusListener (this);
		bt1.addKeyListener (this);
		bt2.addKeyListener (this);
		cb.addItemListener (this);
		cb.addFocusListener(this);
		pf.addFocusListener(this);
		cb.addKeyListener (this);
		pf.addKeyListener (this);
		
		//�Ӵ��ڼ��� new WindowAdapter��������
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				quit();
			}//End windowClosing
		});
		
		this.setContentPane(panelMain);		//���ô������
		this.setSize(350, 235);
		this.setResizable (false);			//���ô��ڲ��ɷŴ���С
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		sunswing.setWindowCenter(this);
		this.setVisible(true);
		pf.requestFocus(true);				//���ý���������
	}
	
	/**=======================================================================**
	 *		[## private void buildCenter() {} ]: 		�����û����������
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ���齨�û���������壬������ʹ��
	 **=======================================================================**
	 */
	private void buildCenter() {
		
		JLabel lb1, lb2;
		JPanel pa1, pa2, pa3;
		
		lb1 = new JLabel("��  ��  �� :");
		lb2 = new JLabel("��¼���� :");
		cb	= new JComboBox();
		pf  = new TJPasswordField (15);
		bt1 = new TJButton ("pic/key.gif", "��  ¼", "��¼ϵͳ");
		bt2 = new TJButton ("pic/exit.gif", "��  ��", "�ر�ϵͳ");
		sunsql.initJComboBox (cb, "select userid from pwd where delmark=0");
		
		//�������Ϊ�޲���
		panelInfo = new JPanel(null);
		//�������
		panelInfo.add(lb1);
		panelInfo.add(lb2);
		panelInfo.add(cb);
		panelInfo.add(pf);
		panelInfo.add(bt1);
		panelInfo.add(bt2);
		
		lb1.setBounds(50,14,60,20);
		lb2.setBounds(50,48,60,20);
		bt1.setBounds(68,77,86,28);
		bt2.setBounds(186,77,86,28);
		cb.setBounds (115,12,168,23);
		pf.setBounds (115,46,170,23);
		
		//�趨�߿���
		panelInfo.setBorder(BorderFactory.createTitledBorder(""));
	}
	
	/**=======================================================================**
	 *		[## private void quit() {} ]: 				ϵͳ�˳�
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ���ر�ϵͳ���������ʹ��
	 **=======================================================================**
	 */
	private void quit() {
		int flag = 0;
		String msg = "�� �� �� Ҫ �� �� ϵ ͳ �� ��";
		flag = JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_NO_OPTION);
		if(flag == JOptionPane.YES_OPTION) {
			this.setVisible(false);
			System.exit(0);
		}//End if(flag == JOptionPane.YES_OPTION)
		return;
	}
	
	/**=======================================================================**
	 *		[## private void dengLu() {} ]: 			ϵͳ��¼
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ��������֤ͨ��������������棬������ʹ��
	 **=======================================================================**
	 */
	private void dengLu() {
		String user = cb.getSelectedItem() + "";
		String pwd	= String.valueOf(pf.getPassword());
		String code = "select pwd,puis from pwd where delmark=0 and userid='" + user + "'";
		ResultSet rs = sunsql.executeQuery (code);
		try {
			if(rs.next()) {			//�û������
				if(pwd.equals(rs.getString(1))) {
					bott.setText(clue + "��¼�ɹ������ڽ���ϵͳ ...");
					String puis = rs.getString(2);		//��ò���ԱȨ��
					boolean flag = Journal.writeJournalInfo(user, "��¼��ϵͳ", Journal.TYPE_LG);
					if(flag) {		//��¼��־
						new com.sunshine.mainframe.HotelFrame(user, puis);		//���������򴰿�(�û���, Ȩ��)
						this.setVisible(false);
					}else {
						String msg = "д��־��������ϵͳ����Ա��ϵ ...";
						JOptionPane.showMessageDialog(null, msg, "����", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
				else {
					bott.setText(clue + "�û� [ " + user + " ] �����벻��ȷ������������ ...");
					flag++;
					if(flag == 3) {		//���������֤
						JOptionPane.showMessageDialog(null, "���Ǳ�ϵͳ�Ĺ���Ա��ϵͳ�ر� ...", "����", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}//End if(flag == 3)
					return;
				}//End if(pwd.equals(rs.getString(1)))
			}
			else {
				bott.setText(clue + "�û�ID [ " + user + " ] ������ ...");
			}//End if(rs.next()) 
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}//End try
	}
	
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed (ActionEvent ae) {
		//��������
		if(ae.getSource() == bt1) {		//��¼����
			dengLu();
		}
		else {
			quit();
		}//End if(ae.getSource() == bt1)
	}
	
	
	/**=======================================================================**
	 *			ItemListener ����
	 **=======================================================================**
	 */
	public void itemStateChanged (ItemEvent ie) {
		pf.requestFocus(true);
	}
	
	
	/**=======================================================================**
	 *			KeyListener ����
	 **=======================================================================**
	 */
	public void keyPressed (KeyEvent ke) {
		//���̰��¼���
		int key = ke.getKeyCode();
		if(key == KeyEvent.VK_ENTER) {
			if(ke.getSource() == cb)
				pf.requestFocus(true);				//��������û��������
			if(pf.getPassword().length > 0)
				dengLu();							//��Enter���¼ϵͳ
		}
		else if(key == KeyEvent.VK_ESCAPE) {		//��ESC���˳�ϵͳ
			quit();
		}//End if
	}
	
	public void keyReleased (KeyEvent ke) {
		//�����ͷż���
	}
	
	public void keyTyped (KeyEvent ke) {
		//�����ͼ���
	}
	
	
	/**=======================================================================**
	 *			FocusListener ����
	 **=======================================================================**
	 */
	public void focusGained (FocusEvent fe) {
		//�������
		if(fe.getSource() == cb)		//�������·��Ĺ�����ʾ
			bott.setText(clue + "��ѡ�����Ա��� ...");
		else
			if(fe.getSource() == pf)
				bott.setText(clue + "�������¼���� ...");
			else
				if(fe.getSource() == bt1)
					bott.setText(clue + "��¼ϵͳ ...");
				else
					if(fe.getSource() == bt2)
						bott.setText(clue + "�˳�ϵͳ ...");
	}
	
	public void focusLost (FocusEvent fe) {
		//ʧȥ�������
	}
	
	
	
	/**=======================================================================**
	 *		[## public static void main(String sd[]) {} ]: 	������
	 *			����   ��String sd[] 
	 *			����ֵ ����
	 *			���η� ��public static
	 *			����   ���������
	 **=======================================================================**
	 */
	public static void main(String sd[]) {
		sunswing.setWindowStyle(sunini.getIniKey("Sys_style").charAt(0));
		new FStartWindow ("pic/Login.gif", new Frame(), 1200);
		new Login();
	}

}

