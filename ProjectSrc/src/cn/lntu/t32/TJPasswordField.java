/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : �����������ı���
 *	[ �ļ���      ]  : TJPasswordField.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : �����������ı���
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
 *	[## public TJPasswordField(String text) {} ]:
 *		����: ���캯��	
 *
 *	[## public TJPasswordField(String text, int column) {} ]:
 *		����: ���캯��  
 *	
 *	[## public void setLineWidth(int l) {} ]:
 *		����: ��������߿�
 *
 *  [ ��������    ]  : 
 *
 *#################################cn.lntu.t32####################
 */
package com.sunshine.sunsdk.swing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class TJPasswordField 
extends JPasswordField 
implements MouseListener, FocusListener {
	
	private int thickness = 1;
	
	public TJPasswordField() {
		setStyle();
	}
	
	public TJPasswordField(int col) {
		super(col);
		setStyle();
	}
	
	public TJPasswordField(String text) {
		super(text);
		setStyle();
	}
	
	public TJPasswordField(String text, int column) {
		super(text, column);
		setStyle();
	}
	
	public void setLineWidth(int l) {
		thickness = l;
		this.setBorder(new LineBorder(new Color(159, 145, 118), thickness));
	}
	
	private void setStyle() {
		this.setForeground(new Color( 87,  87,  47));
		this.setBackground(new Color(248, 242, 230));
		this.setBorder(new LineBorder(new Color(159, 145, 118), thickness));
		this.addMouseListener(this);
		this.addFocusListener(this);
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
		this.setBorder(new LineBorder(new Color(241, 171, 84), thickness));
	}

	public void mouseExited (MouseEvent me) {
		this.setBorder(new LineBorder(new Color(159, 145, 118), thickness));
	}
	
	/**=======================================================================**
	 *			FocusListener ����
	 **=======================================================================**
	 */
	public void focusGained (FocusEvent fe) {
		this.setBorder(new LineBorder(new Color(241, 171, 84), thickness));
	}
	
	public void focusLost (FocusEvent fe) {
		this.setBorder(new LineBorder(new Color(159, 145, 118), thickness));
	}
}