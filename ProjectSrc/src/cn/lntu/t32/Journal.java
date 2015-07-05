/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ��־��������
 *	[ �ļ���      ]  : Journal.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : д������־����ݿ�
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
 *	[## private Journal() {} ]:
 *		����: ��ֹ���಻�ܱ�ʵ��
 *
 *	[## public static String getNowDTime() {} ]:
 *		����: ���ص�ǰ����ʱ��
 *
 *	[## public static boolean writeJournalInfo(String user, String content,int infoIndex) {} ]:
 *		����: ��¼������־
 *
 *  [ ��������    ]  : 
 *
 *###############################cn.lntu.t32########################
 */
package com.sunshine.sunsdk.sql;

import java.util.*;
import com.sunshine.sunsdk.sql.sunsql;


public class Journal {
	
	public static final int TYPE_LG = 0;		//����Ա��¼
	public static final int TYPE_RT = 1;		//�������Ͳ���
	public static final int TYPE_RI = 2;		//������Ϣ����
	public static final int TYPE_US = 3;		//�ͻ���Ϣ����
	public static final int TYPE_CZ = 4;		//����Ա����
	public static final int TYPE_JF = 5;		//�Ʒ�����
	public static final int TYPE_DA = 6;		//��ݲ���
	
	public static String brief[] = { "����Ա��¼", "�������Ͳ���", "������Ϣ����", 
									 "�ͻ���Ϣ����", "����Ա����","�Ʒ�����","��ݲ���"};
	
	/**=======================================================================**
	 *		[## private Journal() {} ]: 					���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ֹ���಻�ܱ�ʵ��
	 **=======================================================================**
	 */
	private Journal() {
	}
	
	/**=======================================================================**
	 *		[## public static String getNowDTime() {} ]: 	���ص�ǰ����ʱ��
	 *			����   ����
	 *			����ֵ ��String �����ʾ��ǰϵͳʱ��
	 *			���η� ��public
	 *			����   �����ص�ǰ����ʱ��
	 **=======================================================================**
	 */
	public static String getNowDTime() {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.getTime().toLocaleString();
	}
	
	/**=======================================================================**
	 *		[## public static boolean writeJournalInfo(String user, String content,int infoIndex) {} ]:
	 *			����   ��String user	��ʾ��ǰ����Ա
	 *					 String content	��ʾ��������
	 *					 int infoIndex	��������
	 *			����ֵ ��boolean
	 *			���η� ��public
	 *			����   ����¼������־
	 **=======================================================================**
	 */
	public static boolean writeJournalInfo(String user, String content,int infoIndex) {
		String dt = getNowDTime();						//��õ�ǰʱ��
		content   = user + " �� " + dt + " " + content;	//��������
		long pk	  = sunsql.getPrimaryKey();				//�������
		
		String sqlCode = "insert into record(pk,time,operator,brief,content) values(" + 
		pk + ",'" + dt + "','" + user + "','" + brief[infoIndex] + "','" + content + "')";
		
		if(sunsql.executeUpdate(sqlCode) == 0) {	//д������־
			return false;
		}//Endif
		return true;
	}
	
}