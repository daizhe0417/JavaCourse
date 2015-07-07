package cn.lntu.t35;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.lntu.t35.UserService;

public class StudentService {
	UserService date = new UserService();
	PreparedStatement state;
	
	public  int  queryStudent(String id){
		/**
		 * ≤È—ØSQL”Ôæ‰
		 */
        Connection conn=UserService.getDbConnection();
		try {
			String  sql="select stuname,stunum,stusex,stuhometown,stuclass,stumajor,stuinstitute  from stuinformation  where  stunum='"+id+"'";
			state=conn.prepareStatement(sql);
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();}}
		return  0;
		}
}
