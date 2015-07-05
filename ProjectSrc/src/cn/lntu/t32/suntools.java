/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ���ߺ���
 *	[ �ļ���      ]  : suntools.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��������Ƿ�Ϸ�����ˮ���Զ�����
 *	[ ����        ]  : 
 *	[ �汾        ]  : 1.2
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
 *	[## private suntools () {} ] :  
 *		����: ��ֹʵ��suntools����
 *
 *  [## public static boolean isDate (String date) {} ]:
 *		����: �ж������ַ��Ƿ�Ϸ�����
 *
 *	[## public static boolean isNum (String in) {} ]: 	#A
 *		����: �����ַ��Ƿ�������(0-9)���
 *
 *	[## public static boolean isNum (String in, int length, double min, double max) {} ]: #B
 *		����: �����ַ��ʾ����ֵ����Χ�����ַ�ֻ�����������
 *
 *	[## public static String getNumber (int type) {} ]:	#C
 *		����: �Զ����䵥�ݱ��, �Զ�����
 *	
 *	[## public static void savNumber (String num, int type) {} ]: #D
 *		����: �����ñ�ű��浽INI�ļ�
 *
 *	[## public static double getConsumeFactor(String sDate, String eDate) {} ]: #E
 *		����: ����Ƶ�Ʒ�����  ��INI�ļ������õ�
 *
 *	[## public static double getClockFactor(String sDate, String eDate) {} ]: #F
 *		����: ����Ƶ��ӵ㷿�Ʒ�ϵ��  ��INI�ļ������õ�
 *
 *	[## public static String getConsumeHour(String sDate, String eDate) {} ]: #G
 *		����: ��������ʱ��֮���м�Сʱ����
 *
cn.lntu.t32
 *
 *
 *##############################################################################
 */
package com.sunshine.sunsdk.system;

import java.util.*;
import java.text.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;


public class suntools {
	
	public static final int Number_RZ = 0;			//��ʾ���۵���
	public static final int Number_YD	= 1;		//��ʾ�������
	public static final int Number_JS	= 1;		//��ʾ�������
	
	/**=======================================================================**
	 *		[## private suntools () {} ]:		���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ֹʵ��suntools����
	 **=======================================================================**
	 */
	private suntools () {
	}
	
	/**=======================================================================**
	 *		[## public static boolean isDate (String date) {} ]:		
	 *			����   ��String�����ʾ���ڵ��ַ�
	 *			����ֵ ��boolean �Ϸ�����true
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ���ж������ַ��Ƿ�Ϸ�����
	 **=======================================================================**
	 */
	public static boolean isDate (String date) {
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		String isdate = date;
		if(date.length() == 10)				//���ֻ�����ڣ������Զ�����00:00:00
			isdate = date + " 00:00:00";
		try {
			sdf.parse (isdate);
			return true;
	    }
	    catch (Exception ex) {
	    	System.out.println ("feetools.isDate(): The DATE format is error .");
	    	return false;
	    }
	}
	
	/**=======================================================================**
	 *		[## public static boolean isNum (String in) {} ]:		
	 *			����   ��String�����ʾ�����ַ�
	 *			����ֵ ��boolean �Ϸ�����true
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   �������ַ��Ƿ�������(0-9)���
	 **=======================================================================**
	 */
	public static boolean isNum (String in) {
		return isNum (in, 0, 0, 0);
	}
	
	/**=======================================================================**
	 *		[## public static boolean isNum (String in, int length, double min, double max) {} ]:		
	 *			����   ��String�����ʾ�����ַ�
	 *					 length������ʾ�ַ���󳤶ȣ�ȡֵ0����ʾû�г����޶�
	 *					 min,max�����޶���String�����ʾ����ֵ��Χ����(length > 0)ʱ
	 *			����ֵ ��boolean �Ϸ�����true
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   �������ַ��ʾ����ֵ����Χ�����ַ�ֻ�����������
	 **=======================================================================**
	 */
	public static boolean isNum (String in, int length, double min, double max) {
		String num = in;
		int point  = 0;						//'.'�ĸ���
		int len = num.length (); 
		if(length > 0) {
			if(len > length || len == 0) {	//�ж��ַ���,���Ϸ��շ���false
				System.out.println ("suntools.isNum(): Length error.");
				return false;
			}//Endif
		}//End if(length > 0)
		else
			if(len == 0) {					//�ж��ַ��Ƿ�Ϊ��,�շ���false
				System.out.println ("suntools.isNum(): String is NULL");
				return false;
			}//End if(len == 0)
		for (int i = len - 1; i >=0; i--) {		//�ж��ַ�ֻ��������
			char ac = num.charAt (i);
			if(ac == '.' && point == 0 &&  i!= 0) {	//�����'.'�ַ����ǵ�һ�γ��֣��Ҳ���ֻ��һ����
				if(i > len - 4) {			//�ж�С��λֻ������λ
					point++;
					continue;
				}//Endif
			}//Endif
			if(ac < '0' || ac > '9' ) {
				System.out.println ("suntools.isNum(): Character isn't ( '0' - '9' )");
				return false;
			}//Endif
	    }//Endfor
	    if(length !=0) {
	    	double s = Double.parseDouble (num);		//����lenΪ�ַ��ʾ����ֵ
	    	if(s < min  || s >max) {					//���Ʒ�Χmin-max֮��
	    		System.out.println ("suntools.isNum(): Amount limit error. ");
	    		return false;
	    	}//Endif
	    }//End if(length != 0)
	    return true;
	}
	
	/**=======================================================================**
	 *		[## public static String getNumber (int type) {} ]:		
	 *			����   ��int������ʾҪ���ʲô���͵ĵ���(����ͷ����)
	 *			����ֵ ��String����: ����;
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ���Զ����䵥�ݱ��, �Զ�����
	 **=======================================================================**
	 */
	public static String getNumber (int type) {
		
		GregorianCalendar gc = new GregorianCalendar();
		String tp, number, month, day;		//���ű�ͷ, ���ż���λ, Ϊ�·�, Ϊ��
		int numLen = 0;						//���ŵ�Ĭ��λ��
		
		if(type == Number_RZ) {				//Ҫ��ȡ���۵���
			tp = sunini.getIniKey ("LodgName");
			number = sunini.getIniKey ("LodgNumber");
		}else if(type == Number_YD){					//Ҫ��ȡ�������
			tp = sunini.getIniKey ("EngaName");
			number = sunini.getIniKey ("EngaNumber");
		}else {
			tp = sunini.getIniKey ("ChouName");
			number = sunini.getIniKey ("ChouNumber");
		}
		
		numLen = number.length ();						//�õ����ŵ�Ĭ��λ��
		number = Integer.parseInt (number) + 1 + "";	//��������1,��ת���ַ�

		//�жϼ�����Ƿ�λ(����Ҫ�󳤶�)
		if(number.equals ((int)Math.pow (10, numLen - 1) + "") && number.length() > 1)
			number = number.substring(1);				//���ż���λ����

		//forѭ��,��'0'Ϊnumber��λ (i = ��ǰ����λ��, i < numLen)
		for (int i = number.length (); i < numLen; i++) {
			number = "0" + number;
	    }//Endfor
		
		//Ϊ�·ݲ�'0'
		month = gc.get (GregorianCalendar.MONTH) + 1 + "";
		if( month.length() == 1)
			month = "0" + month;
		
		//Ϊ�첹'0'
		day = gc.get (GregorianCalendar.DAY_OF_MONTH) + "";
		if( day.length () == 1)
			day = "0" + day;
			
		//���ӵ��ű�ͷ,����,����λ;��ɵ��ݺ���
	    tp = tp + gc.get (GregorianCalendar.YEAR) + month + day + number;
		
		return tp;			//���ص���
	}
	
	/**=======================================================================**
	 *		[## public static void savNumber (String num, int type) {} ]:		
	 *			����   ��String�����ʾҪ����ĵ���
	 *					 int������ʾҪ����ʲô���͵ĵ���(����ͷ����)
	 *			����ֵ ����
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   �������ñ�ű��浽INI�ļ�
	 **=======================================================================**
	 */
	public static void savNumber (String num, int type) {
		//INI�ļ��еļ���
		String ini[] = { "[SOFTINFO]", "UserName", "CompName", "[CONFIG]", "Soft_First",
					 "Default_Link" , "Default_Page", "Sys_style", "[NUMBER]",
					 "LodgName", "LodgNumber", "EngaName", "EngaNumber", "ChouName", 
					 "ChouNumber", "[HABITUS]", "Ck_Habitus", "Ck_Minute", "[PARTTIME]", 
					 "In_Room", "Out_Room1", "Out_Room2", "InsuDay", "ClockRoom1", 
					 "ClockRoom2", "InsuHour1", "InsuHour2", "[JDBC]", "DBFname", 
					 "UserID", "Password", "IP", "Access", "[ODBC]", "LinkName" };
		String bt;
		if(type == Number_RZ) {
			bt = sunini.getIniKey ("LodgName");
			sunini.setIniKey ("LodgNumber", num.substring (bt.length () + 8));
		}
		else if(type == Number_YD){
			bt = sunini.getIniKey ("EngaName");
			sunini.setIniKey ("EngaNumber", num.substring (bt.length () + 8));
		} else{
			bt = sunini.getIniKey ("ChouName");
			sunini.setIniKey ("ChouNumber", num.substring (bt.length () + 8));
		}
		//���浽INI�ļ�
		sunini.saveIni (ini);
	}
	
	/**=======================================================================**
	 *		[## public static double getConsumeFactor(String sDate, String eDate) {} ]:		
	 *			����   ��String sDate�����ʾ��ʼʱ��
	 *					 String eDate������ʾ����ʱ��
	 *			����ֵ ��double
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ������Ƶ�Ʒ�����  ��INI�ļ������õ�
	 **=======================================================================**
	 */
	 //������ϵ��
	public static double getConsumeFactor(String sDate, String eDate) {
		
		//��ÿ�ʼ����ʱ���--��--��--��--ʱ--��--��
		String syh [] = sDate.trim ().split(" ");
		String symd[] = syh[0].trim().split("-");
		String shms[] = syh[1].trim().split(":");
		int sy = Integer.parseInt(symd[0]);
		int sM = Integer.parseInt(symd[1]);
		int sd = Integer.parseInt(symd[2]);
		int sh = Integer.parseInt(shms[0]);
		int sm = Integer.parseInt(shms[1]);
		int ss = Integer.parseInt(shms[2]);
		
		//��ý�������ʱ���--��--��--��--ʱ--��--��
		String eyh [] = eDate.trim ().split(" ");
		String eymd[] = eyh[0].trim().split("-");
		String ehms[] = eyh[1].trim().split(":");
		int ey = Integer.parseInt(eymd[0]);
		int eM = Integer.parseInt(eymd[1]);
		int ed = Integer.parseInt(eymd[2]);
		int eh = Integer.parseInt(ehms[0]);
		int em = Integer.parseInt(ehms[1]);
		int es = Integer.parseInt(ehms[2]);
		
		//���sDate��longֵ
		long sdt = new Timestamp(sy, sM, sd, sh, sm, ss, 0).getTime();
		//���eDate��longֵ
		long edt = new Timestamp(ey, eM, ed, eh, em, es, 0).getTime();
		
		double db = 0;
		
		if(sdt > edt) {			//���Ϸ�	��ʼ����һ��ҪС�ڽ�������
			db = -1;
			return db;
		}//Endif
		
		if(sdt == edt) {		//��ʱ���
			db = 0;
			return db;
		}//Endif
		
		
		int insuDay = (int)(edt - sdt)/3600000;
		if(insuDay < 24) {				//��ס����һ��
			if(Integer.parseInt(sunini.getIniKey("InsuDay")) == 1)
				db = 1;					//��ȫ��Ʒ�
			else {
				if(insuDay > 1 && insuDay < 12)
					db = 0.5;			//���ȫ��Ʒѣ������1Сʱ������Ʒ�
				else
					db = 1;				//���ȫ��Ʒѣ������12Сʱ��ȫ��Ʒ�
			}//Endif
			return db;	
		}//Endif
		
		//����֮���µ�һ��Ʒ�
		int inRoom = Integer.parseInt(sunini.getIniKey("In_Room"));
		if(sh < inRoom) {
			db = 0.5;
		}//Endif
		sh = inRoom;		//���ʱ���Ѿ�����ϵ��ȥ�������
		//����֮�󰴰���Ʒ�
		int outRoom1 = Integer.parseInt(sunini.getIniKey("Out_Room1"));
		int outRoom2 = Integer.parseInt(sunini.getIniKey("Out_Room2"));
		if(eh > outRoom1 && eh < outRoom2) {
			db = db + 0.5;
			eh = outRoom1;	//���ʱ���Ѿ�����ϵ��ȥ�������
		}else if(eh >= outRoom2) {
			db = db + 1;
			eh = outRoom2;
		}//Endif
		
		//������סʱ��
		sdt = new Timestamp(sy, sM, sd, sh, sm, ss, 0).getTime();
		edt = new Timestamp(ey, eM, ed, eh, em, es, 0).getTime();
		
		db = db + (edt - sdt)/86400000;
		return db;
	}
	
	/**=======================================================================**
	 *		[## public static double getClockFactor(String sDate, String eDate) {} ]:		
	 *			����   ��String sDate�����ʾ��ʼʱ��
	 *					 String eDate������ʾ����ʱ��
	 *			����ֵ ��double
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ������Ƶ��ӵ㷿�Ʒ�ϵ��  ��INI�ļ������õ�
	 **=======================================================================**
	 */
	public static double getClockFactor(String sDate, String eDate) {
		
		//��ÿ�ʼ����ʱ���--��--��--��--ʱ--��--��
		String syh [] = sDate.trim ().split(" ");
		String symd[] = syh[0].trim().split("-");
		String shms[] = syh[1].trim().split(":");
		int sy = Integer.parseInt(symd[0]);
		int sM = Integer.parseInt(symd[1]);
		int sd = Integer.parseInt(symd[2]);
		int sh = Integer.parseInt(shms[0]);
		int sm = Integer.parseInt(shms[1]);
		int ss = Integer.parseInt(shms[2]);
		
		//��ý�������ʱ���--��--��--��--ʱ--��--��
		String eyh [] = eDate.trim ().split(" ");
		String eymd[] = eyh[0].trim().split("-");
		String ehms[] = eyh[1].trim().split(":");
		int ey = Integer.parseInt(eymd[0]);
		int eM = Integer.parseInt(eymd[1]);
		int ed = Integer.parseInt(eymd[2]);
		int eh = Integer.parseInt(ehms[0]);
		int em = Integer.parseInt(ehms[1]);
		int es = Integer.parseInt(ehms[2]);
		
		//���sDate��longֵ
		long sdt = new Timestamp(sy, sM, sd, sh, sm, ss, 0).getTime();
		//���eDate��longֵ
		long edt = new Timestamp(ey, eM, ed, eh, em, es, 0).getTime();
		//���ʱ���
		
		double db = 0;
		
		if(sdt > edt) {			//���Ϸ�	��ʼ����һ��ҪС�ڽ�������
			db = -1;
			return db;
		}//Endif
		
		//�������ʱ��֮���ж�����
		edt = (edt - sdt) / 1000;
		//--------------------------------------------------------------------//
		if(edt <= 60 * Integer.parseInt(sunini.getIniKey("ClockRoom1"))) {
			db = 0;				//�����󼸷��ӿ�ʼ�Ʒѣ���INI�ļ�����
			return db;
		}//Endif
		//--------------------------------------------------------------------//
		if(edt / 60 < 60 * Integer.parseInt(sunini.getIniKey("ClockRoom2"))) {
			db = 1;				//���㼸Сʱ��һ����λ�Ʒ�
			return db;
		}//Endif
		//--------------------------------------------------------------------//
		
		//�����Ͽ��ܵ���Ʒѹ�ʽ����
		db = edt / 3600;				//��ù�ȥ��Сʱ��
		
		edt = edt % 3600 / 60;			//��ö���ķ�����
		
		if(edt > Integer.parseInt(sunini.getIniKey("InsuHour2")) && edt <= Integer.parseInt(sunini.getIniKey("InsuHour1"))) {
			db = db + 0.5;				//������ٷ֣���С�ڶ��ٷֲ��֣��հ��
		}else if(edt > Integer.parseInt(sunini.getIniKey("InsuHour2"))) {
			db = db + 1;				//������ٷֵģ���ȫ��
		}//Endif
		//--------------------------------------------------------------------//
		
		return db;
	}
	
	
	/**=======================================================================**
	 *		[## public static String getConsumeHour(String sDate, String eDate) {} ]:		
	 *			����   ��String sDate�����ʾ��ʼʱ��
	 *					 String eDate������ʾ����ʱ��
	 *			����ֵ ��String
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ����������ʱ��֮���м�Сʱ����
	 **=======================================================================**
	 */
	public static String getConsumeHour(String sDate, String eDate) {
		
		//��ÿ�ʼ����ʱ���--��--��--��--ʱ--��--��
		String syh [] = sDate.trim ().split(" ");
		String symd[] = syh[0].trim().split("-");
		String shms[] = syh[1].trim().split(":");
		int sy = Integer.parseInt(symd[0]);
		int sM = Integer.parseInt(symd[1]);
		int sd = Integer.parseInt(symd[2]);
		int sh = Integer.parseInt(shms[0]);
		int sm = Integer.parseInt(shms[1]);
		int ss = Integer.parseInt(shms[2]);
		
		//��ý�������ʱ���--��--��--��--ʱ--��--��
		String eyh [] = eDate.trim ().split(" ");
		String eymd[] = eyh[0].trim().split("-");
		String ehms[] = eyh[1].trim().split(":");
		int ey = Integer.parseInt(eymd[0]);
		int eM = Integer.parseInt(eymd[1]);
		int ed = Integer.parseInt(eymd[2]);
		int eh = Integer.parseInt(ehms[0]);
		int em = Integer.parseInt(ehms[1]);
		int es = Integer.parseInt(ehms[2]);
		
		//���sDate��longֵ
		long sdt = new Timestamp(sy, sM, sd, sh, sm, ss, 0).getTime();
		//���eDate��longֵ
		long edt = new Timestamp(ey, eM, ed, eh, em, es, 0).getTime();
		//���ʱ���
		sdt = edt - sdt;
		
		//��ɹ�ȥ����ʱ����ַ�
		String t = sdt / 3600000 + "Сʱ" + sdt % 3600000 / 60000 + "��";
		
		return t;
	}
}