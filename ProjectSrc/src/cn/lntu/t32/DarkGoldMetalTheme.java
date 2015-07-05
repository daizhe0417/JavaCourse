/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ����ɫ������
 *	[ �ļ���      ]  : DarkGoldMetalTheme.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ���ô���Ϊ����ɫ����
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
 *	[## public String getName() {} ]:
 *		����: ����������
 *
 *  [ ��������    ]  : 	
 *
 *########################################cn.lntu.t32#######
 */
package com.sunshine.sunsdk.swing.Theme;

import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import java.awt.*;


public class DarkGoldMetalTheme extends DefaultMetalTheme {

    public String getName() { return "Sandstone"; }

    private final ColorUIResource primary1 = new ColorUIResource( 87,  87,  47);
    private final ColorUIResource primary2 = new ColorUIResource(159, 151, 111);
    private final ColorUIResource primary3 = new ColorUIResource(199, 183, 143);

    private final ColorUIResource secondary1 = new ColorUIResource(111, 111, 111);
    private final ColorUIResource secondary2 = new ColorUIResource(184, 173, 151);
    private final ColorUIResource secondary3 = new ColorUIResource(231, 215, 183);

    protected ColorUIResource getPrimary1() { return primary1; }
    protected ColorUIResource getPrimary2() { return primary2; }
    protected ColorUIResource getPrimary3() { return primary3; }

    protected ColorUIResource getSecondary1() { return secondary1; }
    protected ColorUIResource getSecondary2() { return secondary2; }
    protected ColorUIResource getSecondary3() { return secondary3; }
    
}