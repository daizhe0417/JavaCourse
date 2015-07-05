/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ViewList�ؼ�
 *	[ �ļ���      ]  : ViewList.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��ɺ��ҵĵ��Բ������
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
 *	[## public ViewList(int buttons) {} ]:
 *		����: ���캯�����������
 *
 *	[## public void remeButtons() {} ]:	
 *		����: �������λ
 *
 *	[## public JButton getButton(String roomNum) {} ]:
 *		����: �������е�ָ������
 *
 *	[## public void setButtonImage(String buttonName, String state) {} ]:
 *		����: ���ð���ͼƬ
 *	
 *	[## public void addButton(String name) {} ]:
 *		�������ܰ��������Ӧ��ģ���У�����JButton����������Ӽ���
 *
 *  [ ��������    ]  : 
 *
 *##############cn.lntu.t32#######################################
 */
package com.sunshine.sunsdk.swing;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class ViewList extends JPanel {
	
	//���ð��������
	private Hashtable buttons = new Hashtable();
	//���ð�������
	private JPanel panelMain;
	//ViewList ������򰴼�ĸ��������
	private int column	= 6;
	private int row		= 5;
	
	//����ڰ�������
	private int buttonTotal = 30;
	//���������
	private int buttonCount = 0;
	
	
	/**=======================================================================**
	 *		[## public ViewList(int buttons) {} ]:		���캯�����������
	 *			����   ��int buttons ��ʾViewList�еİ�������
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����캯�����������
	 **=======================================================================**
	 */
	public ViewList(int buttons) {
		super(new BorderLayout());
		
		JScrollPane spMain;								//����������
		
		//��ݰ�����ݼ����������������
		int vRow = buttons / column;
		if(vRow > row) {					//������㹻�İ����������������������
			if(buttons % column > 0) {		//����ʹ��Ĭ������ row = 5
				row = vRow + 1;
			}else {
				row = vRow;
			}//Endif
			buttonTotal = buttons;						//��ð�������
		}//Endif
		
		//�����������
		panelMain	= new JPanel(new GridLayout(row, 1, 5, 15));		
		//����Ĭ�ϱ���ɫ
		panelMain.setBackground(new Color(248, 242, 230));
		spMain	  = new JScrollPane(panelMain);
		//���������
		this.add("Center", spMain);
	}
	
	/**=======================================================================**
	 *		[## public void remeButtons() {} ]:		�������λ
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���������λ�������������� column * row ��ӿ�JLabel��λ��
	 *					 ��Ȼ�ֻܾ���	ע�⣬�˷���һ��Ҫ�ڼ������а����ʹ��
	 **=======================================================================**
	 */
	public void remeButtons() {
		if(buttonCount < buttonTotal) {
			for (int i = 0; i < buttonTotal - buttonCount; i++) {
				JLabel lb = new JLabel("��");
				panelMain.add(lb);				//����λ
		    }//Endfor
		}//Endif
	}
	
	/**=======================================================================**
	 *		[## public JButton getButton(String roomNum) {} ]:		
	 *			����   ��String roomNum �����ʾ�������֣�Ҳ���Ƿ����
	 *			����ֵ ��JButton
	 *			���η� ��public
	 *			����   ���������е�ָ������
	 **=======================================================================**
	 */
	public JButton getButton(String roomNum) {
		return (JButton)buttons.get(roomNum);
	}
	
	/**=======================================================================**
	 *		[## public void setButtonImage(String buttonName, String state) {} ]:		
	 *			����   ��String buttonName �����ʾ�����ڹ�ϣ���еļ���
	 *					 String State �����ʾ����״̬
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����ð���ͼƬ
	 **=======================================================================**
	 */
	public void setButtonImage(String buttonName, String state) {
		String picName = "";
		if(state.equals("�ɹ�"))
			picName = "pic/room/prov.gif";
		else if(state.equals("ռ��"))
			picName = "pic/room/pree.gif";
		else if(state.equals("Ԥ��"))
			picName = "pic/room/rese.gif";
		else if(state.equals("�ӵ�"))
			picName = "pic/room/clock.gif";
		else if(state.equals("�෿"))
			picName = "pic/room/clean.gif";
		else if(state.equals("ͣ��"))
			picName = "pic/room/stop.gif";
		((JButton)buttons.get(buttonName)).setIcon(new ImageIcon(picName));
	}
	
	/**=======================================================================**
	 *		[## public void addButton(String name) {} ]:
	 *			����   ��String name	��ʾ���ܰ��������
	 *			����ֵ ��JButton
	 *			���η� ��public
	 *			����   ���������ܰ��������Ӧ��ģ���У�����JButton����������Ӽ���
	 **=======================================================================**
	 */
	public JButton addButton(String name) {
		JButton button = new JButton(name);
		button.setBorderPainted(false);				//���ð����ޱ߿�
		button.setContentAreaFilled(false);			//���ð���ɫ͸��
		button.setHorizontalTextPosition(SwingConstants.CENTER);//����Ico�����־���
		button.setVerticalTextPosition(SwingConstants.BOTTOM);//����Ico������ֵ�λ��
		panelMain.add(button);		  				//��������밴�����
		buttons.put(name, button);					//����������ϣ��
		buttonCount++;								//���������+1
		return button;
	}
}