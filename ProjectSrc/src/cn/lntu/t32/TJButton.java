/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ������ICO��������ʾ�İ���
 *	[ �ļ���      ]  : TJButton.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ������ICO��������ʾ�İ���
 *	[ ����        ]  : 
 *	[ �汾        ]  : 1.1
 *	----------------------------------------------------------------------------
 *	[ ��ע        ]  : 
 *	----------------------------------------------------------------------------
 *	[ �޸ļ�¼    ]  : 
 *
 *	[ ��  �� ]     [�汾]         [�޸���]         [�޸�����] 
 *	##--------------------------------------------------------------------------
 *  			 ��Ȩ����(c) 2006-2007, SunshineSOFT Corporation
 *	--------------------------------------------------------------------------##
 *	
 *	[ ����˵��    ]  :
 *
 *	[## public TJButton(String picName, String text, String toolTip) {} ]:
 *		����: ���캯��	������ICO��������ʾ�İ���
 *
 *	[## public TJButton(String picName, String text, String toolTip,boolean flag) {} ]:
 *		����: ������ICO��������ʾ�Ĺ���������
 *
 *	[## private buildButton(String picName, String text, String toolTip,boolean flag) {} ]:
 *		����: ������ICO��������ʾ�Ĺ���������,������ʹ��
 *
 *  [ ��������    ]  : 
 *cn.lntu.t32#########################################################
 */
package com.sunshine.sunsdk.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TJButton 
extends JButton 
implements MouseListener {
	
	/**=======================================================================**
	 *		[## public TJButton(String picName, String text, String toolTip) {} ]
	 *			���캯��
	 *			����   ��String picName ��ʾ�����ϵ�ICO�ļ���
	 *					 String text ��ʾ��������
	 *					 String toolTip ��ʾ�����ToolTip��ʾ
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ��������ICO��������ʾ�İ���
	 **=======================================================================**
	 */
	public TJButton(String picName, String text, String toolTip) {
		buildButton(picName, text, toolTip, false);
	}
	
	/**=======================================================================**
	 *		[## public TJButton(String picName, String text, String toolTip,boolean flag) {} ]
	 *			���캯��
	 *			����   ��String picName ��ʾ�����ϵ�ICO�ļ���
	 *					 String text ��ʾ��������
	 *					 String toolTip ��ʾ�����ToolTip��ʾ
	 *					 boolean ��ʾ����Ϊ��ͼ�깤����ģʽ
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ��������ICO��������ʾ�Ĺ���������
	 **=======================================================================**
	 */
	public TJButton(String picName, String text, String toolTip,boolean flag) {
		buildButton(picName, text, toolTip, flag);
	}
	
	/**=======================================================================**
	 *		[## private buildButton(String picName, String text, String toolTip,boolean flag) {} ]
	 *			����������
	 *			����   ��String picName ��ʾ�����ϵ�ICO�ļ���
	 *					 String text ��ʾ��������
	 *					 String toolTip ��ʾ�����ToolTip��ʾ
	 *					 boolean ��ʾ����Ϊ��ͼ�깤����ģʽ
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ��������ICO��������ʾ�Ĺ���������,������ʹ��
	 **=======================================================================**
	 */
	private void buildButton(String picName, String text, String toolTip,boolean flag) {
		this.setIcon (new ImageIcon (picName));
		this.setText (text);
		this.setToolTipText (toolTip);
		if(flag) {
			//this.setBorderPainted (false);
			this.setContentAreaFilled(false);		//���ñ���ɫ͸��
			this.setHorizontalTextPosition (SwingConstants.CENTER);
			this.setVerticalTextPosition (SwingConstants.BOTTOM);
		}//End if(flag)
		this.addMouseListener(this);
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

	public void mouseEntered (MouseEvent me) {
		this.setForeground(new Color(156, 126,  66));
		this.setBackground(new Color(234, 223, 203));
	}

	public void mouseExited (MouseEvent me) {
		this.setForeground(new Color( 87,  87,  47));
		this.setBackground(new Color(231, 215, 183));
	}
}