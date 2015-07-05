/**
 *##############################################################################
 *
 *	[ ��Ŀ��      ]  : 
 *  [ ��˾��      ]  : SunshineSOFT
 *	[ ģ����      ]  : ��ݿ�����
 *	[ �ļ���      ]  : sunsql.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ���Ӽ�������ݿ�
 *	[ ����        ]  : 
 *	[ �汾        ]  : 1.3
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
 *	[## private sunsql() {} ] :  
 *		����: ��ֹʵ��sunsql����
 *
 *  [## public static int executeUpdate(String sql) {} ] :
 *		����: ִ�ж���ݿ��ĵ�sql��������ظ����Ӱ�������
 *
 *  [## public static ResultSet executeQuery(String sql) {} ] :
 *		����: ִ�ж���ݿ��select��ѯ���ܣ������ز�ѯ��õ��Ľ��
 *
 *	[## public static int recCount(ResultSet rs)) {} ] :
 *		����: ���ָ�����ļ�¼����
 *
 *	[## public static long getPrimaryKey() {} ] : #A
 *		����: ͨ���������ǰ��ʱ����һ������
 *
 *	[## public static void initJComboBox (JComboBox cb, String sqlCode) {} ] : #B
 *		����: ��SQL������ݿ�ѡ��Items����JComboBox
 *
 *	[## public static void initJList (JList jt, String sqlCode) {} ] : #E
 *		����: ��SQL������ݿ�ѡ����ݼ���JList
 *
 *	[## public static void initDTM (DefaultTableModel fdtm, String sqlCode) {} ] : #C
 *		����: ��SQL������ݿ��л�����(���)����ӵ�fdtm��(Ҳ����˵JTable��)
 *
 *	[## public static int runTransaction (String updateCode[]) {} ] : #D
 *		����: ���������ģʽ��updateCode�е�sql������ݿ���и���
 *
 *
 *  [ ��������    ]  :
 *
 *	[ ��ݿ����ӹر����� ] : ����: ֻ��Ӧ�ó�����ȫ�˳�ʱ��ݿ����ӲŹر�
 *       cn.lntu.t32: ÿ����ݿ������ɺ�Ҫ�ر�
 *	
 *
 *##############################################################################
 */
package com.sunshine.sunsdk.sql;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import com.sunshine.sunsdk.system.*;


public class sunsql {
	
	private static Statement ste = null;
	private static Connection conn = null;
	
	static {
		try {
			if(sunini.getIniKey ("Default_Link").equals ("1")) {		//JDBC���ӷ�ʽ
				String user = sunini.getIniKey ("UserID");
				String pwd  = sunini.getIniKey ("Password");
				String ip   = sunini.getIniKey ("IP");
				String acc  = sunini.getIniKey ("Access");
				String dbf  = sunini.getIniKey ("DBFname");
				String url  = "jdbc:microsoft:sqlserver://" + ip + ":" + acc + ";" + "databasename=" + dbf;
				//ע����
				//DriverManager.registerDriver (new com.microsoft.jdbc.sqlserver.SQLServerDriver());
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//���һ������
				conn = DriverManager.getConnection (url, user, pwd);
			}
			else {
				//ע����										//JDBCODBC���ӷ�ʽ
				DriverManager.registerDriver (new sun.jdbc.odbc.JdbcOdbcDriver());
				//���һ������
				conn = DriverManager.getConnection ("jdbc:odbc:" + sunini.getIniKey("LinkName"));
			}
			//�����Զ��ύΪfalse
			conn.setAutoCommit (false);
			//�����߼�����
			ste = conn.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    }
	    catch (Exception ex) {
	    	JOptionPane.showMessageDialog (null, "��ݿ�����ʧ��...", "����", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	    	//ex.printStackTrace();
	    }//End try
	}
	
	/**=======================================================================**
	 *		[## private sunsql() {} ]:		���캯��
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ����ֹʵ��sunsql����
	 **=======================================================================**
	 */
	private sunsql(){
	}
	
	/**=======================================================================**
	 *		[## public static int executeUpdate(String sql) {} ] :	
	 *			����   ��String ����, ��ʾ��Ҫִ�е�sql���
	 *			����ֵ ��int, ��ʾ��sql������ݿ�Ӱ���˼���
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ��ִ�ж���ݿ��ĵ�sql��������ظ����Ӱ�������
	 **=======================================================================**
	 */
	public static int executeUpdate(String sql) {
//		System.out.println ("Update SQL : " + sql);
		int i = 0 ;
		try {
			i = ste.executeUpdate(sql) ;
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace() ;
		}//End try
		return i ;
	}
	
	/**=======================================================================**
	 *		[## public static int runTransaction (String updateCode[]) {} ] :	
	 *			����   ��String[]���ַ�����, ��ʾ��Ҫִ�е�����sql���
	 *			����ֵ ��int, ��ʾsql���ִ�е����, (i==���鳤��)Ϊ���³ɹ�
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   �����������ģʽ��updateCode�е�sql������ݿ���и���
	 **=======================================================================**
	 */
	public static int runTransaction (String updateCode[]) {
		int ok = 0, i = 0;
		int row = updateCode.length;		//������������
		try {
			for (i = 0; i < row; i++) {
				ok = ste.executeUpdate (updateCode[i]);		//ִ��SQL���
				if(ok == 0) {				//���ɹ��������ѭ��
					System.out.println ("sunsql.runTransaction(): updateCode[" + i + "] ʧ��" + ok);
					break;
				}
				System.out.println ("sunsql.runTransaction(): updateCode[" + i + "] �ɹ� " + ok);
			}
			//��ݱ��� ok �ж�����ѭ���Ƿ����������
			if(ok == 0) {
				conn.rollback ();		//(ok == 0)��ʾ���¹���г��?�ع����
				System.out.println ("sunsql.runTransaction(): Update data false, rollback");
			}
			else {
				conn.commit ();			//(ok != 0)����������SQL������гɹ�, ���ύ����ݿ�
				System.out.println ("sunsql.runTransaction(): Update finish");
			}
		}
	    catch (Exception ex) {
	    	System.out.println ("sunsql.runTransaction(): Update false ...");
	    }
		return i;
	}
	
	/**=======================================================================**
	 *		[## public static ResultSet executeQuery(String sql) {} ] :
	 *			����   ��String ����, ��ʾ��Ҫִ�е�sql���
	 *			����ֵ ��ResultSet����, ��ʾ�˲�ѯ��䷵�صĽ��
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ��ִ�ж���ݿ��select��ѯ���ܣ������ز�ѯ��õ��Ľ��
	 **=======================================================================**
	 */
	public static ResultSet executeQuery(String sql) {
//		System.out.println ("Query SQL : " + sql);
		ResultSet rs = null ;
		try {
			rs = ste.executeQuery(sql) ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}//End try
		return rs ;
	}
	
	/**=======================================================================**
	 *		[## public static int recCount(ResultSet rs)) {} ] :
	 *			����   ��ResultSet ����, ��ʾĿ����
	 *			����ֵ ��int, ��ʾ����еļ�¼����
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   �����ָ�����ļ�¼����
	 **=======================================================================**
	 */
	public static int recCount(ResultSet rrs) {
		int i = 0;
		try {
			if(rrs.getRow() != 0)
				rrs.beforeFirst();
			//while���ڼ���rs�ļ�¼����
			while(rrs.next())
				i++;
			rrs.beforeFirst();	
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    }//End try
		return i;
	}
	
	/**=======================================================================**
	 *		[## public static long getPrimaryKey() {} ] :
	 *			����   ����
	 *			����ֵ ��long, ��ʾ�ӷ�������õ�����
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ��ͨ���������ǰ��ʱ����һ������
	 **=======================================================================**
	 */
	public static long getPrimaryKey() {
		long pk = 0;
		
		try {
			//��÷�����ʱ��
			ResultSet rs = executeQuery("select getdate()");
			rs.next();
			pk = rs.getTimestamp(1).getTime();
	    }
	    catch (Exception ex) {
	    	System.out.println ("sunsql.getPrimaryKey (): false");
	    }
	    return pk;
	}
	
	/**=======================================================================**
	 *		[## public static void initJComboBox (JComboBox cb, String sqlCode) {} ] :
	 *			����   ��JComboBox��ʾҪ����ݵ�������, String�����ʾһ��SQL���
	 *			����ֵ ��JComboBox, ��ʾ����һ���Ӻ�Item��JComboBox����
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ����SQL������ݿ�ѡ��Items����JComboBox
	 **=======================================================================**
	 */
	public static void initJComboBox (JComboBox cb, String sqlCode) {
		cb.removeAllItems();
		try {
			ResultSet rs = executeQuery (sqlCode);
			int row = recCount (rs);
			rs.beforeFirst ();
			//�ӽ����ȡ��Item����JComboBox��
			for (int i = 0; i < row; i++) {
				rs.next();
				cb.addItem (rs.getString (1));
		    }
	    }
	    catch (Exception ex) {
	    	System.out.println ("sunsql.initJComboBox (): false");
	    }
	}
	
	/**=======================================================================**
	 *		[## public static void initJList (JList jt, String sqlCode) {} ] :
	 *			����   ��JList��ʾҪ����ݵ��б��, String�����ʾһ��SQL���
	 *			����ֵ ����
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ����SQL������ݿ�ѡ����ݼ���JList
	 **=======================================================================**
	 */
	public static void initJList (JList jt, String sqlCode) {
		try {
			ResultSet rs = executeQuery (sqlCode);
			int row = recCount (rs);
			String list[] = new String[row];
			//�ӽ����ȡ����ݴ���������
			for (int i = 0; i < row; i++) {
				rs.next();
				list[i] = rs.getString(1);
		    }//Endfor
		    jt.setListData(list);	//��ʼ��List
	    }
	    catch (Exception ex) {
	    	System.out.println ("sunsql.initJList(): false");
	    }//Endtry
	}
	
	/**=======================================================================**
	 *		[## public static void initDTM (DefaultTableModel fdtm, String sqlCode) {} ] :
	 *			����   ��DefaultTableModel�����ʾҪ�����ݵı�ģʽ
	 *					 String�����ʾһ��SQL���
	 *			����ֵ ����
	 *			���η� ��public static ���Բ�ʵ������ֱ�ӵ��÷���
	 *			����   ����SQL������ݿ��л����ݣ���ӵ�fdtm��(Ҳ����˵JTable��)
	 **=======================================================================**
	 */
	public static void initDTM (DefaultTableModel fdtm, String sqlCode) {
		try {
			ResultSet rs = executeQuery( sqlCode );	//��ý��
			int row = recCount( rs );				//��ý�����м������
			ResultSetMetaData rsm =rs.getMetaData();	//����м�
			int col = rsm.getColumnCount();		//����еĸ���
			String colName[] = new String[col];
			//ȡ����еı�ͷ���, ����colName������
			for (int i = 0; i < col; i++) {
				colName[i] = rsm.getColumnName( i + 1 );
			}//End for
			rs.beforeFirst();
			String data[][] = new String[row][col];
			//ȡ����е����, ����data������
			for (int i = 0; i < row; i++) {
				rs.next();
				for (int j = 0; j < col; j++) {
					data[i][j] = rs.getString (j + 1);
					//System.out.println (data[i][j]);
			    }
			}//End for
			fdtm.setDataVector (data, colName);
	    }
	    catch (Exception ex) {
	    	System.out.println ("sunsql.initDTM (): false");
	    }//End try
	}

}