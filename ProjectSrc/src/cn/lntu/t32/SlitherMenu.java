/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : �����˵�
 *	[ �ļ���      ]  : SlitherMenu.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��QQһ��Ļ����˵�
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
 *	[## public SlitherMenu() {} ]:
 *		����: �����˵��Ĺ��캯�� (�޲������)
 *
 *	[## public void addPanel(String name,String ico, int index, int quantity) {} ]:
 *		����: ��������ģ�壬��������ģ��
 *
 *	[## public void addButton(String ico, String name, String tooltip, int index) {} ]:
 *		����: �������ܰ��������Ӧ��ģ����
 *
 *	[## public void initButtonPanelDimension() {} ]:
 *		����: ��ʼ��ÿ������ģ������ߴ�(�������ڵ�setVisible()����֮ǰʹ��)
 *
 *	[## public void setInitMenu() {} ]: 
 *		����: ���ó�ʼ����չ����һ��˵�(�������ڵ�setVisible()����֮��ʹ��)
 *
 *	[## public void setMenuDimension(int w,int h) {} ]: 
 *		����: ���ò˵���Ⱥ͸߶�(�ڳ�ʼ���˵���������֮ǰʹ��)
 *
 *	[## public void setMenuLocation(int x, int y) {} ]: 
 *		����: ���ò˵������(�ڳ�ʼ���˵���������֮ǰʹ��)
 *
 *	[## public void setTitleHeight(int h) {} ]: 
 *		����: ����ģ����ⰴ��߶�(�����ⰴ���б���ͼ��ʱ��ʹ�ñ�����)
 *
 *	[## public void setButtonPanelBackground(Color bg) {} ]: 
 *		����: ���ð���ģ�屳����ɫ(�ڳ�ʼ���˵���������֮��ʹ��)
 *
 *	[## public String getSelectButtonName() {} ]: 
 *		����: ���ѡ�еİ�����
 *
 *	[## private void slither(int index) {} ]:
 *		����: ����˵�����Ч��
 *
 *  [ ��������   cn.lntu.t32�ػ��˵�
 *						2�����ܸ������ģ�����ñ���ͼ��
 *						3�����ܸı䰴���ǰ����ɫ
 *
 *##############################################################################
 */
package com.sunshine.sunsdk.swing;
 
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class SlitherMenu 
extends JPanel 
implements ActionListener {
	
	//����ģ������
	private ArrayList template = new ArrayList();
	//���ð�����������
	private ArrayList buttonPanels = new ArrayList();
	//����ActionListener�¼��İ�����
	private String selectButtonName = "";
	//��ǰչ��ģ������
	private int selectPanelNumber	= 0;
	//��Ҫչ��ģ������
	private int selectPanelNumberNew = 0;
	
	//ģ������
	private int panelconut = 0;
	//���廬���˵������
	private int sm_X = 0;
	private int sm_Y = 0;
	//���廬���˵��Ŀ�Ⱥ͸߶�
	private int slitherMenuBar_Width  = 60;
	private int slitherMenuBar_Height = 300;
	//������ģ�������ĸ߶�
	private int titleHeight = 28;
	
	
	
	/**=======================================================================**
	 *		[## public SlitherMenu() {} ]: 	���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �������˵��Ĺ��캯�� (�޲������)
	 **=======================================================================**
	 */
	public SlitherMenu() {
		super(null);		//���������Ϊ�޲���
	}
	
	/**=======================================================================**
	 *		[## public void addPanel(String name,String ico, int index, int quantity) {} ]:
	 *			����   ��String name ��ʾ����ģ��ı��ⰴ����
	 *					 String ico	 ��ʾ�������ı���ͼ��
	 *					 int index	 ��ʾ����ģ����������
	 *					 int quantity��ʾģ���ڽ�Ҫ���밴�������
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ����������ģ�壬��������ģ��
	 **=======================================================================**
	 */
	public void addPanel(String name,String ico, int index, int quantity) {
		JButton titleButton;
		JScrollPane spPanel;
		JPanel panelMain, buttonPanel;
		
		titleButton = new JButton(name, new ImageIcon(ico));	//�������ⰴ��
		panelMain	= new JPanel(new BorderLayout(0, 0));		//������Ϊ�߽粿��
		buttonPanel = new JPanel(new GridLayout(quantity, 1));	//���������Ϊ��񲿾�
		spPanel		= new JScrollPane(buttonPanel);				//�����������
		spPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//���ñ��ⰴ������, ���ͼ��Ϊ�գ���Ĭ��Javaԭ������
		if(ico.length() > 0) {
			titleButton.setFocusPainted(false);					//���ý������Ϊ��
			titleButton.setBorderPainted(false);				//���ð����ޱ߿�
			titleButton.setContentAreaFilled(false);			//���ð���ɫ͸��
			titleButton.setHorizontalTextPosition(SwingConstants.CENTER); //����Ico�����־���
			//panelMain.setBorder(new LineBorder(new Color(184, 207, 229)));//�������
		}//Endif
		
		//�Ա��ⰴ����¼�����
		titleButton.addActionListener(this);
		
		titleButton.setName(index+ "");				//���ÿ������־
		panelMain.add("North", titleButton);		//������ⰴ��
		panelMain.add("Center",spPanel);			//���밴�������
		this.add(panelMain);						//����˵����
		panelconut++;								//��������+1
		
		template.add(index, panelMain);				//������ģ���������
		buttonPanels.add(index, buttonPanel);		//�����ð��������������
	}
	
	/**=======================================================================**
	 *		[## public void addButton(String ico, String name, String tooltip, int index) {} ]:
	 *			����   ��String name	��ʾ���ܰ��������
	 *					 String ico		��ʾ���ܰ���ı���ͼ��
	 *					 String tooltip ��ʾ�����������ʾ�ı�
	 *					 int index		��ʾ����Ҫ�����ĸ�ģ��
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ���������ܰ��������Ӧ��ģ����
	 **=======================================================================**
	 */
	public void addButton(String ico, String name, String tooltip, int index) {
		JButton button = new JButton(name, new ImageIcon(ico));
		button.setToolTipText(tooltip);				//���ð�����ʾ
		button.setBorderPainted(false);				//���ð����ޱ߿�
		button.setContentAreaFilled(false);			//���ð���ɫ͸��
		button.setHorizontalTextPosition(SwingConstants.CENTER);//����Ico�����־���
		button.setVerticalTextPosition(SwingConstants.BOTTOM);//����Ico������ֵ�λ��
		button.addActionListener(this);						  //���¼�����
		((JPanel)buttonPanels.get(index)).add(button);		  //��������밴�����
	}
	
	/**=======================================================================**
	 *		[## public void initButtonPanelDimension() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ����ʼ��ÿ������ģ������ߴ�(�������ڵ�setVisible()����֮ǰʹ��)
	 **=======================================================================**
	 */
	public void initButtonPanelDimension() {
		for (int i = 0; i < panelconut; i++) {
			((JPanel)template.get(i)).setBounds(sm_X, sm_Y, slitherMenuBar_Width, 
			slitherMenuBar_Height - titleHeight * (panelconut - 1));
	    }//Endfor
	}
	
	/**=======================================================================**
	 *		[## public void setInitMenu() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����ó�ʼ����չ����һ��˵�(�������ڵ�setVisible()����֮��ʹ��)
	 **=======================================================================**
	 */
	public void setInitMenu() {
		if(panelconut > 0) {
			JPanel mainMenu  = (JPanel)template.get(0);			//չ����һ��˵�
			int titlesHeight = (panelconut - 1) * titleHeight;	//�������ģ�����ĸ߶��ܺ�
			int height = slitherMenuBar_Height - titlesHeight;
			mainMenu.setBounds(sm_X, sm_Y, slitherMenuBar_Width, height);
			//��������˵�����
			for (int i = 1; i < panelconut; i++) {
				((JPanel)template.get(i)).setBounds(sm_X, sm_Y + height + (i - 1) *  titleHeight, 
													slitherMenuBar_Width, titleHeight);
		    }//Endfor
		}else {
			String msg = "û�а���ģ�����֯��";
			JOptionPane.showMessageDialog(null, msg, "����",JOptionPane.ERROR_MESSAGE);
		}//Endif
	}
	
	/**=======================================================================**
	 *		[## public void setMenuDimension(int w,int h) {} ]: 
	 *			����   ��int w ��ʾ�˵���ȣ�int h ��ʾ�˵��߶�
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����ò˵���Ⱥ͸߶�(�ڳ�ʼ���˵���������֮ǰʹ��)
	 **=======================================================================**
	 */
	public void setMenuDimension(int w,int h) {
		if(panelconut == 0) {
			slitherMenuBar_Width  = w;
			slitherMenuBar_Height = h;
		}else {
			String msg = "setMenuDimension()�������ڼ������֮ǰʹ�á�";
			JOptionPane.showMessageDialog(null, msg, "����",JOptionPane.WARNING_MESSAGE);
		}//Endif
	}
	
	/**=======================================================================**
	 *		[## public void setMenuLocation(int x, int y) {} ]: 
	 *			����   ��int x ��ʾ�˵��ĺ�����꣬int y ��ʾ�˵����������
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����ò˵������(�ڳ�ʼ���˵���������֮ǰʹ��)
	 **=======================================================================**
	 */
	public void setMenuLocation(int x, int y) {
		if(panelconut == 0) {
			sm_X = x;
			sm_Y = y;
		}else {
			String msg = "setMenuLocation()�������ڼ������֮ǰʹ�á�";
			JOptionPane.showMessageDialog(null, msg, "����",JOptionPane.WARNING_MESSAGE);
		}//Endif
	}
	
	/**=======================================================================**
	 *		[## public void setTitleHeight(int h) {} ]: 
	 *			����   ��int h ��ʾ����ģ��ı����ĸ߶�
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ������ģ����ⰴ��߶�(�����ⰴ���б���ͼ��ʱ��ʹ�ñ�����)
	 **=======================================================================**
	 */
	public void setTitleHeight(int h) {
		titleHeight = h;
	}
	
	/**=======================================================================**
	 *		[## public void setButtonPanelBackground(Color bg) {} ]: 
	 *			����   ��Color �����ʾ����ģ��ı�����ɫ
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����ð���ģ�屳����ɫ(�ڳ�ʼ���˵���������֮��ʹ��)
	 **=======================================================================**
	 */
	public void setButtonPanelBackground(Color bg) {
		if(panelconut > 0) {
			for (int i = 0; i < panelconut; i++) {
				((JPanel)buttonPanels.get(i)).setBackground(bg);
	   		}//Endfor
		}else {
			String msg = "setButtonPanelBackground()�������ڼ������֮��ʹ�á�";
			JOptionPane.showMessageDialog(null, msg, "����",JOptionPane.WARNING_MESSAGE);
		}//Endif
		
	}
	
	/**=======================================================================**
	 *		[## public String getSelectButtonName() {} ]: 
	 *			����   ����
	 *			����ֵ ��String �����ʾ�����¼��Ĺ��ܰ��������
	 *			���η� ��public
	 *			����   �����ѡ�еİ�����
	 **=======================================================================**
	 */
	public String getSelectButtonName() {
		return selectButtonName;
	}
	
	/**=======================================================================**
	 *		[## private void slither(int index) {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ������˵�����Ч��
	 **=======================================================================**
	 */
	private void slither(int index) {
		//����������ĸ߶��ܺ�
		int sp_h = slitherMenuBar_Height - titleHeight * (panelconut - 1);
		
		if(index == selectPanelNumber) {			//����ǵ�ǰ��壬�򲻴���
			return;					
		}else if(index > selectPanelNumber) {		//�˵����ƶ���
			int sp_y = titleHeight * (selectPanelNumber + 1);
			for (int i = sp_h; i >= titleHeight; i --) {
				//��ǰչ���������
				((JPanel)template.get(selectPanelNumber)).setSize(slitherMenuBar_Width, i);	
				//���?ǰչ������뽫Ҫչ�����֮��ı���
				for (int j = selectPanelNumber + 1; j < index; j++) {
					int other_Y = ((JPanel)template.get(j)).getY() - 1;		
					((JPanel)template.get(j)).setLocation(sm_X, other_Y);
			    }//Endfor
			    //�����չ��
			    int index_Y = ((JPanel)template.get(index)).getY() - 1;
			    int index_H = ((JPanel)template.get(index)).getHeight() + 1;
			    ((JPanel)template.get(index)).setBounds(sm_X, index_Y, slitherMenuBar_Width, index_H);
		    }//Endfor
		}else if(index < selectPanelNumber) {		//���ƶ���
			int sp_y = titleHeight * (selectPanelNumber - 2);
			for (int i = sp_h; i >= titleHeight; i --) {
				//��ǰչ���������
				int spy = ((JPanel)template.get(selectPanelNumber)).getY() + 1;
			    ((JPanel)template.get(selectPanelNumber)).setBounds(sm_X, spy, slitherMenuBar_Width, i);
				//���?ǰչ������뽫Ҫչ�����֮��ı���
				for (int j = selectPanelNumber - 1; j > index; j--) {
					int other_Y = ((JPanel)template.get(j)).getY() + 1;		
					((JPanel)template.get(j)).setLocation(sm_X, other_Y);
			    }//Endfor
			    //�����չ��
			    int index_H  = ((JPanel)template.get(index)).getHeight() + 1;
			    ((JPanel)template.get(index)).setSize(slitherMenuBar_Width, index_H);
		    }//Endfor
		}//Endif
		this.validate();		//ȷ����ǰ�˵��ı仯
	}
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed ( ActionEvent ae ) {
		//��ô����¼��İ���Name
		selectButtonName = ((JButton)ae.getSource()).getName();
		
		if(selectButtonName != null) {		//��Ϊ����ѡ��ľ��Ǳ��ⰴ��
			//��ñ�ѡ��ģ������
			selectPanelNumberNew = Integer.parseInt(selectButtonName);
			//����˵�����Ч��
			slither(selectPanelNumberNew);
			selectPanelNumber = selectPanelNumberNew;
		}
		else {
			//��ù��ܰ��������
			selectButtonName = ((JButton)ae.getSource()).getText();
		}//Endif
	}
	
}