package cn.lntu.t35;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.lntu.t35.User;
import cn.lntu.t35.UserService;



public class ScoreService {
	UserService date = new UserService();
	PreparedStatement state;
	
	 public  boolean  saveScore(Score score){
	    	/**
	    	 * Ìí¼Ó¿Î³ÌSQLÓï¾ä
	    	 */
		 boolean flag=true;
		@SuppressWarnings("static-access")
		Connection conn = date.getDbConnection();
		
		String sql="insert into score (stunum,coursenum,scscore)values(?,?,?)";
		try {
			state=conn.prepareStatement(sql);
			state.setString(1,score.getStunum());
			state.setString(2,score.getCoursenum());
			state.setString(3,score.getScscore());
			state.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			flag=false;
			try {
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
	 
	 public  boolean  updateScore(Score score){
		 /**
		  * ÐÞ¸Ä³É¼¨SQLÓï¾ä
		  */
			boolean flag=true;
			@SuppressWarnings("static-access")
			Connection conn = date.getDbConnection();
			
			try {
				String sql="update score set scscore =?  where coursenum=? and stunum=?";
				state=conn.prepareStatement(sql);
				state.setString(1,score.getScscore());
				state.setString(2,score.getCoursenum());
				state.setString(3,score.getStunum());
				state.executeUpdate();

			} catch (SQLException e) {
				flag=false;
				try {
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
			return flag;
		}
	 
	 
	 public  boolean  deleteScore(int  id, int  id1){
	    	/**
	    	 * „h³ý¿Î³ÌSQLÕZ¾ä
	    	 */
			boolean flag=true;
			@SuppressWarnings("static-access")
			Connection conn = date.getDbConnection();
	        String  sql="delete  from score  where stunum=? and coursenum=?";
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				state.setInt(2,id1);
				state.execute();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
	        return flag;
		}
	 
	 public  Score  queryScore(int id){
			/**
			 * ²éÑ¯SQLÓï¾ä
			 */
	    	@SuppressWarnings({ "unused" })
	    	boolean flag=true;
			@SuppressWarnings("static-access")
			Connection conn = date.getDbConnection();
	        String  sql="select score.stunum,stuinformation.stuname,"
	        		+ "score.coursenum,course.coursenam,score.scscore "
	        		+ "from score,stuinformation,course where "
	        		+ "score.coursenum=?";
            Score score = new Score();
	        User user =new User();
	        Course course = new Course();
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				ResultSet  re=state.executeQuery();
				while(re.next()){
					score.setStunum(re.getString("stunum"));
					user.setStuname(re.getString("stuname"));
					score.setCoursenum(re.getString("coursenum"));
					course.setCoursenam(re.getString("coursenam"));
					score.setScscore(re.getString("scscore"));
				}
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
			return score;
		}
}
