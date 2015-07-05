/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ��QQ����������
 *	[ �ļ���      ]  : JQFrame.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ���ڿ�����Ļ�Ϸ�ʱ���Զ�����
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
 *	[## public Login() {} ]:
 *		����: JQFrame �Ĺ��캯��
 *
 *	[## public void setSize(int w, int h) {} ]:
 *		����: ���ô��ڳߴ�
 *
 *	[## public void setStep(int s) {} ]: 
 *		����: ���õĴ��ڶ�������
 *
 *
 *  [ ��������    ]  : 
 *
 *###########################cn.lntu.t32##########################
 */
package com.sunshine.sunsdk.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sunshine.sunsdk.swing.*;			//�������
import com.sunshine.sunsdk.system.*;

public class JQFrame 
extends JFrame 
implements MouseListener {
	
	private boolean winState = true;		//����������־
	private int sunWidth	 = 200;			//����Ĭ�Ͽ��
	private int minHieght	 = 5;			//���������ĸ߶�
	private int maxHieght	 = 506;			//����չ����ĸ߶�
	private int step		 = 15;			//���ڶ������� 
	
	
	/**=======================================================================**
	 *		[## public JQFrame() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ��JQFrame �Ĺ��캯��
	 **=======================================================================**
	 */
	public JQFrame() {
		super("JQFrame");
		
		//�Դ��ڼ�������
		this.addMouseListener(this);
		//���ô������Ͻ�ͼ��
		ImageIcon ia = new ImageIcon("pic/ico.gif");
		this.setIconImage(ia.getImage());
		//���ô���Ĭ�ϴ�С
		this.setBounds(55, 55, sunWidth, maxHieght);
		//���ô��ڲ��ɸı��С
		this.setResizable(false);
	}
	
	/**=======================================================================**
	 *		[## public void setSize(int w, int h) {} ]: 
	 *			����   ��int w ��ʾ���ڿ��  int h ��ʾ���ڸ߶�
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����ô��ڳߴ�
	 **=======================================================================**
	 */
	public void setSize(int w, int h) {
		sunWidth  = w;
		maxHieght = h;
		super.setSize(w, h);
	}
	
	/**=======================================================================**
	 *		[## public void setStep(int s) {} ]: 
	 *			����   ��int s ��ʾҪ���õĴ��ڶ�������
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   �����ô��ڵĶ�������
	 **=======================================================================**
	 */
	public void setStep(int s) {
		if(s > 4) {
			step = s;						//���ô��ڶ�������
		}//Endif
	}
	
	
	/**=======================================================================**
	 *			MouseListener ����
	 **=======================================================================**
	 */
	public void mouseClicked(MouseEvent me)  {
	}

	public void mousePressed(MouseEvent me)  {
	}

	public void mouseReleased(MouseEvent me) {
		if(this.getY() < 0) {
			//���ڵ�Y���С��0��������0�����𴰿�
			this.setLocation(this.getX(), 0);
			for (int i = this.getHeight(); i > minHieght; i-=step) {
				if(i - minHieght <= step) {
					i = minHieght;
				}//Endif
				super.setSize(this.getWidth(), i);
			}//Endfor
			winState = false;
		}//Endif
	}

	public void mouseEntered(MouseEvent me)  {
		if(me.getSource() == this) {					//��������봰��
			if(this.getY() == 0 && !winState) {			//��������Ļ������������
				//չ������
				for (int i = minHieght; i < maxHieght; i+=step) {
					if(i + step >= maxHieght) {
						i = maxHieght;
					}//Endif
					super.setSize(this.getWidth(), i);
				}//Endfor
				winState = true;
			}//Endif
		}//Endif
	}
	
	public void mouseExited(MouseEvent me)   {
		if(me.getSource() == this) {					//�������Ƴ�����
			int mx = me.getX();
			int my = me.getY();
			//������ڴ����ڲ��ؼ����򷵻�
			if(mx > 0 && mx < sunWidth && my < maxHieght) {
				return;
			}//Endif
			if(this.getY() == 0 && winState) {			//��������Ļ��������չ��
				//���𴰿�
				for (int i = maxHieght; i >= minHieght; i-=step) {
					if(i - minHieght <= step) {
						i = minHieght;
					}//Endif
					super.setSize(this.getWidth(), i);
				}//Endfor
				winState = false;
			}//Endif
		}//Endif
	}
	
}