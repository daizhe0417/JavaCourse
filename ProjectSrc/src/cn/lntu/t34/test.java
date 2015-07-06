package bookmanage;
import java.sql.*;
import java.nio.charset.*;
import java.util.*;

public class test {
/*	 public ConnectDataBase(){
	 }
	 public static Connection getConn(){
	  Connection conn=null;
	  String strUrl="jdbc:mysql://localhost/exclusive_shop?user=root&password=dsy1672&useUnicode=true&characterEncoding=utf8";
	  try{
	     Class.forName("com.mysql.jdbc.Driver");
	     conn=DriverManager.getConnection(strUrl);
	     conn=DriverManager.getConnection(strUrl);
 //        System.out.println("数据库连接成功！");
	     }
	  catch (ClassNotFoundException ex){ex.printStackTrace();}
	  catch (SQLException e){
		  e.printStackTrace();
	//	  System.out.println("数据库连接失败！");
	  }
	  
	  return conn;
	 }

		 
		
		 
	 
	*//*
	public static void main(String [] args){
		try{
	         Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("成功加载MySQL驱动程序");
	         String url="jdbc:mysql://localhost:3306/company?"+"user=root&password=dsy1672";
	         Connection conn=DriverManager.getConnection(url);
	         String[] str=new String[5];
	         
	         System.out.println("数据库连接成功");
	       } 
	     catch (Exception e){
	                         System.out.println("找不到MySQL驱动程序"); 
	                         }
	   }*/
	public static void main(String [] args){
		   try{
		        Class.forName("com.mysql.jdbc.Driver");
		        String url="jdbc:mysql://localhost:3306/library?"+
		                   "user=root&password=dsy1672";
		        Connection conn=DriverManager.getConnection(url);
		        Statement st=conn.createStatement();
		        String name=new String("admin");
		        String passwd=new String("admi");
		        
		   //     ResultSet rs=st.executeQuery("select * from administrator");
		        ResultSet rs=st.executeQuery("select * from administrator where Aname='"+name+"'"+"and password='"+passwd+"'");
		        System.out.println("账户序号           账户名称   账户密码  联系方式   权限级别");
		        if(rs.next()){
		          System.out.println("这次查找成功！");
		          System.out.print(+rs.getInt(1)+"  ");
		          System.out.print(rs.getString(2)+"  ");
		          System.out.print(rs.getString(3)+"  ");
		          System.out.print(rs.getString(4)+"  ");
		          System.out.println(rs.getInt(5)+"  ");
		        }
		        else
		        	System.out.println("对不起，你输入的账号或密码有误！");
		        conn.close();
		       }
		    catch(Exception e){
		        e.printStackTrace();
		       }
		 }
}
