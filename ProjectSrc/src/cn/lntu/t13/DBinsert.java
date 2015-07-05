package cn.lntu.t13;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBinsert {

		public static void dbinsert(String wn,String wb,String ws,String wd,String wj) throws Exception {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/worker?user=root&password=asdf";
			Connection conn = DriverManager.getConnection(url);
			
			  DatabaseMetaData dbmd = conn.getMetaData();
			  System.out.println("JDBC�����:" + dbmd.getDriverName() + "," +
			  dbmd.getDriverVersion() + "\nJDBC URL:" + dbmd.getURL() + "\n��ݿ�:" +
			  dbmd.getDatabaseProductName() + ",�汾:" +
			  dbmd.getDatabaseProductVersion() + ",�û���:" + dbmd.getUserName());
			 
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO wworker "
					+ "VALUES ('"+wn+"','"+wb+"','"+ws+"','"+wd+"','"+wj+"')";
			int count=stmt.executeUpdate(sql);
			System.out.println(count);
			conn.close();
		}

}
