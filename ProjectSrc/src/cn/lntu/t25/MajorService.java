package cn.lntu.t25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MajorService {

	
	private Connection conn;
	private PreparedStatement state;
	private Major major;
	
	public  boolean saveMajor(Major  major){
		boolean  flag=true;
		conn=DatabaseConnection.getConnection();
		
		String sql="insert into major (major_id,major_name,college_id)values(?,?,?)";
		try {
			conn.setAutoCommit(false);
			state=conn.prepareStatement(sql);
			state.setInt(1, major.getId());
			state.setString(2, major.getName());
			state.setInt(3, major.getCollege());
			
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

		public  boolean  deleteMajor(Major major){
		   boolean	flag  =true;
			conn=DatabaseConnection.getConnection();
	        String  sql="delete * from major  where  major_id=?";
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,major.getId() );
				state.execute();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
	        return flag;
		}
		
		
		
		public  Major  queryMajor(int id){
			
			conn=DatabaseConnection.getConnection();
	        String  sql="select  * from major  where  major_id=?";
	       major=new  Major();
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				ResultSet  re=state.executeQuery();
				while(re.next()){
					major.setId(re.getInt("major_id"));
					major.setName(re.getString("major_name"));
					major.setCollege(re.getInt("college_id"));
					major.setEmployment(re.getInt("employment"));
					major.setTotal(re.getInt("total"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return major;
		}
		
		public  Map<String,Integer>  queryAllMajor(int collegeid){
                Map<String,Integer>  majormap=new  HashMap<String,Integer>();
                conn=DatabaseConnection.getConnection();
    	        String  sql="select  major_id,major_name from   major where  college_id=? ";
    	        try {
    				state=conn.prepareStatement(sql);
    				state.setInt(1, collegeid);
    				ResultSet  re=state.executeQuery();
    				while(re.next()){
    	            majormap.put(re.getString("major_name"), re.getInt("major_id"));
    				}
    				
    			} catch (SQLException e) {
    				
    				e.printStackTrace();
    			}
    			return majormap;
    			}	
		public  boolean  updateMajor(Major  major){
			boolean flag=true;
			conn=DatabaseConnection.getConnection();
	        String  sql="update major set employment=? where major_id=?";
	   
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1, major.getEmployment()+1);
				state.setInt(2,major.getId());
				state.executeUpdate();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
			return flag;
		}
		
}
