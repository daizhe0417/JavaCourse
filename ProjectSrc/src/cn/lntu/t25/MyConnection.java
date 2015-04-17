package cn.lntu.t25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	
	
	public static Connection   getConnection()  {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql//localhost:3306/employment";
		String  name="root";
		String  paw="305237731";
		Connection myconn = null;
		try{
			Class.forName(driver);
		myconn =DriverManager.getConnection(url,name,paw);
			
			
		}catch(ClassNotFoundException e){
			System.out.println("找不到驱动");
			e.printStackTrace();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return myconn;
	}
}
