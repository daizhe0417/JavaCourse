/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ������JList�б��
 *	[ �ļ���      ]  : TJList.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : �������ı�����
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
 *	[## public TJList() {} ]:
 *		����: ���캯��	
 *
 *	[ ��������    ]  : 
 *
 *###############################################cn.lntu.t32######
 */
package com.sunshine.sunsdk.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TJList 
extends JList
implements MouseListener {
	
	public TJList() {
		//������ʾ������
		this.setVisibleRowCount(5);
		//����ǰ��ɫ�ͺ�ɫ
		this.setForeground(new Color(141, 131, 106));
		this.setBackground(new Color(244, 238, 227));
		//��������
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
		this.setForeground(new Color( 87,  87,  47));
		this.setBackground(new Color(248, 242, 230));
	}

	public void mouseExited (MouseEvent me) {
		this.setForeground(new Color(141, 131, 106));
		this.setBackground(new Color(244, 238, 227));
	}
}