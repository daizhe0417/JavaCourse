/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ������ص�����
 *	[ �ļ���      ]  : sunswing.java
 *	[ ����ļ�    ]  : swing.Theme.*
 *	[ �ļ�ʵ�ֹ���]  : ���ô�������
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
 *	[## private sunswing() {} ]:
 *		����: ���캯��
 *
 *	[## public static void setWindowStyle (char style) {} ]:
 *		����: ���ô��ڷ��
 *
 *	[## public static void setWindowCenter (Component cp) {} ]:
 *		����: ���ô�������Ļ����
 *
 *	
 *  [ ��������    ]  : 
 *
 *###############################cn.lntu.t32######################
 */
package com.sunshine.sunsdk.swing;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import com.sunshine.sunsdk.swing.Theme.*;


public class sunswing {
	
	//������۷����
	public static final int SYSTEM_STYLE = '0';
	public static final int JAVA_STYLE	 = '1';
	public static final int METAL_STYLE	 = '2';
	
	/**=======================================================================**
	 *		[## private sunswing() {} ]:		���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ֹʵ��sunswing����
	 **=======================================================================**
	 */
	private sunswing() {
	}
	
	/**=======================================================================**
	 *		[## public static void setWindowStyle (int style) {} ]:	
	 *			����   ��int,��ʾ���������ĳ���(����ͷ����)
	 *			����ֵ ����
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   �����ô��ڷ��
	 **=======================================================================**
	 */
	public static void setWindowStyle (char style) {
		try {
			switch (style) {
				case '0':
					UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					break;
				case '1':
					UIManager.setLookAndFeel ("javax.swing.plaf.metal.MetalLookAndFeel");
					break;
				case '2':
					UIManager.put ("swing.boldMetal", Boolean.FALSE);
					//�����öԻ������
					JDialog.setDefaultLookAndFeelDecorated (true);
					//���������ô������
					JFrame.setDefaultLookAndFeelDecorated (true);
					Toolkit.getDefaultToolkit().setDynamicLayout (true);
					System.setProperty ( "sun.awt.noerasebackground", "true");
					UIManager.setLookAndFeel (new MetalLookAndFeel());
					//���ô���ɫ������
					MetalLookAndFeel.setCurrentTheme(new DarkGoldMetalTheme());
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			}//End switch (style)
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }//End try
	}
	
	/**=======================================================================**
	 *		[## public static void setWindowCenter(Component cp) {} ]:	
	 *			����   ��Component����,��ʾҪ���еĴ���
	 *			����ֵ ����
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   �����ô�������Ļ����
	 **=======================================================================**
	 */
	public static void setWindowCenter(Component cp) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cp.setLocation (screenSize.width / 2 - (cp.getWidth() / 2), 
						screenSize.height / 2 - (cp.getHeight() / 2));
	}
	
}
