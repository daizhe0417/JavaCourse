package cn.lntu.t25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CollegeService {

	private Connection conn;
	private PreparedStatement state;
	private College college;
	
	public  boolean  saveCollege(College  college){
		boolean  flag=true;
		conn=DatabaseConnection.getConnection();
		
		String sql="insert into college(college_id,college_name)values(?,?)";
		try {
			conn.setAutoCommit(false);
			state=conn.prepareStatement(sql);
            state.setInt(1, college.getId());
			state.setString(2, college.getName());
			
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

		public  boolean deleteCollege(College college){
			boolean  flag=true;
			conn=DatabaseConnection.getConnection();
	        String  sql="delete  from college  where  college_id=?";
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,college.getId() );
				state.execute();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
	        return flag;
		}
		
		
		
		public  College  queryCollege(int id){
			
			conn=DatabaseConnection.getConnection();
	        String  sql="select  * from College  where  college_id=? ";
	       college=new College();
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				ResultSet  re=state.executeQuery();
				while(re.next()){
				college.setId(re.getInt("college_id"));
				college.setName(re.getString("college_name"));
				college.setEmployment(re.getInt("employment"));
				college.setTotal(re.getInt("total"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return college;
		}
		
      public Map<String,Integer>  queryAllCollege(){
			Map<String,Integer >  collegemap=new  HashMap<String,Integer>();
			conn=DatabaseConnection.getConnection();
	        String  sql="select  college_name,college_id from College  order by college_id";
	        try {
				state=conn.prepareStatement(sql);
				ResultSet  re=state.executeQuery();
				while(re.next()){
	            collegemap.put(re.getString("college_name"), re.getInt("college_id"));
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return collegemap;
		}
		public  boolean  updateCollege(College  college){
			boolean flag=true;
			conn=DatabaseConnection.getConnection();
	        String  sql="update college set employment=? where college_id=?";
	   
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1, college.getEmployment()+1);
				state.setInt(2,college.getId());
				state.executeUpdate();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
			return flag;
		}
}
