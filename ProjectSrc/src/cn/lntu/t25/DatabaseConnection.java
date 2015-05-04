package cn.lntu.t25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	
	
	public static Connection   getConnection()  {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employment";
		String user = "root";
		String password = "305237731";
		Connection myconn = null;
		try{
			Class.forName(driver);
	   myconn=   DriverManager.getConnection(url, user, password);
			
			
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
