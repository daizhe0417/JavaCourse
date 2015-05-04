package cn.lntu.t25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnterpriseService {

	private Connection conn;
	private PreparedStatement state;
	private  Enterprise  enterprise;
	
	
	public  boolean  saveEnterprise(Enterprise  enterprise){
		boolean  flag=true;
		conn=DatabaseConnection.getConnection();
		
		String sql="insert into enterprise (id,name,address,email,phoneNumber)values(?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			state=conn.prepareStatement(sql);
			state.setInt(1, enterprise.getId());
			state.setString(2, enterprise.getName());
			state.setString(3, enterprise.getAddress());
			state.setString(4,enterprise.getEmail());
			state.setString(5,enterprise.getPhoneNumber());
			state.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
				flag=false;
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  flag;
	}

		public   boolean deleteEnterprise(int   id){
			boolean flag=true;
			conn=DatabaseConnection.getConnection();
	        String  sql="delete from enterprise  where  id=?";
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				state.execute();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
	        return flag;
		}
		
		
		
		public  Enterprise  queryEnterprise(int id){
			
			conn=DatabaseConnection.getConnection();
	        String  sql="select  * from  enterprise  where  id=?";
	        enterprise =new Enterprise();
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				ResultSet  re=state.executeQuery();
				while(re.next()){
					enterprise.setName(re.getString("name"));
					enterprise.setAddress(re.getString("address"));
					enterprise.setEmail(re.getString("email"));
					enterprise.setPhoneNumber(re.getString("phoneNumber"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return enterprise;
		}
		
public  Enterprise  queryEnterprise(String name){
			
			conn=DatabaseConnection.getConnection();
	        String  sql="select  * from  enterprise  where  name=?";
	        enterprise =new Enterprise();
	        try {
				state=conn.prepareStatement(sql);
				state.setString(1,name);
				ResultSet  re=state.executeQuery();
				while(re.next()){
					enterprise.setId(re.getInt("id"));
					enterprise.setName(re.getString("name"));
					enterprise.setAddress(re.getString("address"));
					enterprise.setEmail(re.getString("email"));
					enterprise.setPhoneNumber(re.getString("phoneNumber"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return enterprise;
		}


		public  boolean  updateEnterprise(Enterprise enterprise){
			boolean   flag=true;
			conn=DatabaseConnection.getConnection();
			
			String sql="update enterprise set address=?,email=?,phoneNumber=?   where id=?";
			try {
				conn.setAutoCommit(false);
				state=conn.prepareStatement(sql);
				state.setString(1, enterprise.getAddress());
				state.setString(2,  enterprise.getEmail());
				state.setString(3,  enterprise.getPhoneNumber());
				state.setInt(4, enterprise.getId());
				state.executeUpdate();
				conn.commit();
			} catch (SQLException e) {
				try {
					flag=false;
					conn.rollback();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				try {
					state.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return  flag;
		}
}
