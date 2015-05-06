package cn.lntu.t25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



//对用户表的查询

class StuUserService {
	private Connection conn;
	private PreparedStatement state;
	private StuUser  stuUser;
	
	public   StuUser  queryUser(int id){
		stuUser=new  StuUser();
		conn=DatabaseConnection.getConnection();
		String  sql="select * from  stu_user where  id=?";
		try {
			state=conn.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet re = state.executeQuery();
			while(re.next()){
				stuUser.setId(re.getInt("id"));
				stuUser.setPassword(re.getString("password"));
			}
			re.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  stuUser;
	}
	public  boolean  update(String password,int id){
		boolean  flag=true;
		String sql="update  stu_user set password=?   where  id=? ";
		conn=DatabaseConnection.getConnection();
		try {
			state=conn.prepareStatement(sql);
			state.setString(1, password);
			state.setInt(2, id);
			state.executeUpdate();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();}}
		return  flag;}
}

class  AdminUserService {
	
	private Connection conn;
	private PreparedStatement state;
	private AdminUser  adminUser;
	
	public   AdminUser  queryUser(int id){
		adminUser=new  AdminUser();
		conn=DatabaseConnection.getConnection();
		String  sql="select * from  admin_user where  id=?";
		try {
			state=conn.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet re = state.executeQuery();
			while(re.next()){
				adminUser.setId(re.getInt("id"));
				adminUser.setPassword(re.getString("password"));
			}
			re.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  adminUser;
	}
	public  boolean  update(String password,int id){
		boolean  flag=true;
		String sql="update  admin_user set password=?   where  id=? ";
		conn=DatabaseConnection.getConnection();
		try {
			state=conn.prepareStatement(sql);
			state.setString(1, password);
			state.setInt(2, id);
			state.executeUpdate();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();}}
		return  flag;}
}
class  EnterUserService{
	
	private Connection conn;
	private PreparedStatement state;
	private EnterUser  enterUser;
	
	public   EnterUser  queryUser(int id){
		enterUser=new  EnterUser();
		conn=DatabaseConnection.getConnection();
		String  sql="select * from  enter_user where  id=?";
		try {
			state=conn.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet re = state.executeQuery();
			while(re.next()){
				enterUser.setId(re.getInt("id"));
				enterUser.setPassword(re.getString("password"));
			}
			re.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  enterUser;
	}
	public  boolean  update(String password,int id){
		boolean  flag=true;
		String sql="update  enter_user set password=?   where  id=? ";
		conn=DatabaseConnection.getConnection();
		try {
			state=conn.prepareStatement(sql);
			state.setString(1, password);
			state.setInt(2, id);
			state.executeUpdate();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();}}
		return  flag;}	
}
