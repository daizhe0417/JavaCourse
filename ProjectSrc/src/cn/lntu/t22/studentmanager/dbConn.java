
package cn.lntu.t22.studentmanager;
import java.sql.*;
public class dbConn {
 public dbConn() {
 try {
 jbInit();
 } catch (Exception ex) {
 ex.printStackTrace();
 }
 }
 private Statement conn(){
	 String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost/lxc";
		String user = "root";
		String password = "230276";
		Connection myconn = null;
		try{
			Class.forName(driver);
	   myconn=   DriverManager.getConnection(con, user, password);
			
			
		}catch(ClassNotFoundException e){
			System.out.println("找不到驱动");
			e.printStackTrace();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return (Statement) myconn;
	}
 public ResultSet getRs(String sql){
 try {
 Statement stat = conn();
 ResultSet rs = stat.executeQuery(sql);
 System.out.println(rs);
 //rs.next();
 return rs;
 }
 catch (SQLException ex) {
 System.err.println("------------"+ex.getMessage());
 return null;
 }
 }
 public int getUpdate(String sql){
 try
 {
 Statement stat = conn();
 int i = stat.executeUpdate(sql);
 return i;
 }
 

 catch(Exception ex){
 System.out.println(">>>>>>>>"+ex.getMessage());
 return -1;
 }
 }
 private void jbInit() throws Exception {
 }
}
