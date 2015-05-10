package cn.lntu.t34;
import java.sql.*;

import java.nio.charset.*;
import java.util.*;

public class ConnectDataBase {
	 public ConnectDataBase(){
	 }
	 public static Connection getConn(){
	  Connection conn=null;
	  String strUrl="jdbc:mysql://localhost/library?user=root&password=dsy1672&useUnicode=true&characterEncoding=utf8";
	  try{
	     Class.forName("com.mysql.jdbc.Driver");
	     conn=DriverManager.getConnection(strUrl);
	     conn=DriverManager.getConnection(strUrl);
 //        System.out.println("��ݿ����ӳɹ���");
	     }
	  catch (ClassNotFoundException ex){ex.printStackTrace();}
	  catch (SQLException e){
		  e.printStackTrace();
	//	  System.out.println("��ݿ�����ʧ�ܣ�");
	  }
	  
	  return conn;
	 }

		 
		
		 
	 
	/*
	public static void main(String [] args){
		try{
	         Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("�ɹ�����MySQL�����");
	         String url="jdbc:mysql://localhost:3306/company?"+"user=root&password=dsy1672";
	         Connection conn=DriverManager.getConnection(url);
	         String[] str=new String[5];
	         
	         System.out.println("��ݿ����ӳɹ�");
	       } 
	     catch (Exception e){
	                         System.out.println("�Ҳ���MySQL�����"); 
	                         }
	   }
	public void login(){
		   try{
		        Class.forName("com.mysql.jdbc.Driver");
		        String url="jdbc:mysql://localhost:3306/library?"+
		                   "user=root&password=dsy1672";
		        Connection conn=DriverManager.getConnection(url);
		        Statement st=conn.createStatement();
		   //     ResultSet rs=st.executeQuery("select * from administrator");
		        ResultSet rs=st.executeQuery("select * from administrator");
		        System.out.println("�˻����           �˻����   �˻�����  ��ϵ��ʽ   Ȩ�޼���");
		        while(rs.next()){
		          System.out.print(+rs.getInt(1)+"  ");
		          System.out.print(rs.getString(2)+"  ");
		          System.out.print(rs.getString(3)+"  ");
		          System.out.print(rs.getString(4)+"  ");
		          System.out.println(rs.getInt(5)+"  ");
		        }
		        conn.close();
		       }
		    catch(Exception e){
		        e.printStackTrace();
		       }
		 }*/
}
