/*
 * @(#)CsUIManager.java	2006-4-13
 * 
 * public class
 *
 * Copyright 2006 CazoSoft, Inc. All rights reserved.
 */
package cn.lntu.t32;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.metal.*;

/**
 * <code> CsUIManager </code>
 * <p>
 * ˵��������Ϊ��۹�����
 * <p>
 * <strong>���棺</strong>
 * ʹ�ý�����BOLD�����ʱ���������Ļ����쳣������Ӱ��ϵͳ����
 * <p>
 * ��ؿ��ļ���o.jar
 * 
 * @author 
 * @version 2006-4-13 23:05:39
 * @since CAZOSOFT 1.0
 */
public class CsUIManager {

    //Windows ���
    public static final int WINDOWS = 0;

    //Java Ĭ�����
    public static final int METAL = 1;

    //Linux ���
    public static final int MOTIF = 2;

    //WindowsClassic ���
    public static final int WINDOWSCLASSIC = 3;

    //Alloy ���
    public static final int ALLOY = 4;

    //Alloy �������
    public static final int GLASSTHEMEALLOY = 5;

    //Alloy �Ի����
    public static final int ACIDTHEMEALLOY = 6;

    //Alloy ���������
    public static final int BEDOUIDTHEMEALLOY = 7;

    //Alloy Ĭ�����
    public static final int DEAFULTTHEMEALLOY = 8;
    
    //Bold ���
    public static final int BOLD = 9;
    
    /**
	 * ������ѡ����
	 * 
	 * @param cp
	 *            ����Ҫ�ı�Ŀؼ�
	 * @param style
	 *            ���ܽ����±�
	 * @return ���سɹ��������
	 */
	public static boolean setUI(Component cp, int style) {

		try {
			switch (style) {
			case 0:
				UIManager.setLookAndFeel("com.sun.java.swing.plaf."
						+ "windows.WindowsLookAndFeel");
				break;
			case 1:
				UIManager.setLookAndFeel("javax.swing.plaf."
						+ "metal.MetalLookAndFeel");
				break;
			case 2:
				UIManager.setLookAndFeel("com.sun.java.swing.plaf."
						+ "motif.MotifLookAndFeel");
				break;
			case 3:
				UIManager.setLookAndFeel("com.sun.java.swing.plaf."
						+ "windows.WindowsClassicLookAndFeel");
				break;
			case 4:
				UIManager.setLookAndFeel("com.incors.plaf."
						+ "alloy.AlloyLookAndFeel");
				break;
			case 5:
				UIManager.setLookAndFeel("soft.wes.feels."
						+ "GlassThemeAlloyLookAndFeel");
				break;
			case 6:
				UIManager.setLookAndFeel("soft.wes.feels."
						+ "AcidThemeAlloyLookAndFeel");
				break;
			case 7:
				UIManager.setLookAndFeel("soft.wes.feels."
						+ "BedouinThemeAlloyLookAndFeel");
				break;
			case 8:
				UIManager.setLookAndFeel("soft.wes.feels."
						+ "DefaultThemeAlloyLookAndFeel");
				break;
			case 9:
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				//�����öԻ������
				JDialog.setDefaultLookAndFeelDecorated(true);
				//���������ô������
				JFrame.setDefaultLookAndFeelDecorated(true);
				Toolkit.getDefaultToolkit().setDynamicLayout(true);
				System.setProperty("sun.awt.noerasebackground", "true");
				UIManager.setLookAndFeel(new MetalLookAndFeel());
				break;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "����ʧ��,��ԭ�����ʾ");
			return false;
		}
		SwingUtilities.updateComponentTreeUI(cp);
		cp.repaint();
		
		return true;
	}
}
