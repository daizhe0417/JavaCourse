package cn.lntu.t25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class JobService {

	private Connection conn;
	private PreparedStatement state;
	private  Job  job;
	//职位表的数据库操作
	
public  boolean  saveJob(Job  job){
		boolean  flag=true;
		conn=DatabaseConnection.getConnection();
		String sql="insert  into  job(enterprise_id,entername,job_name,need_number,reminder,gangweimiaoshu,gender,year1,year2,skill,description)values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			state=conn.prepareStatement(sql);
			state.setInt(1, job.getEnterId());
			state.setString(2, job.getEntername());
			state.setString(3, job.getJobName());
			state.setInt(4, job.getNeedNumber());
			state.setInt(5, job.getReminder());
			state.setString(6, job.getGangweimiaoshu());
			state.setString(7, job.getGender());
			state.setInt(8, job.getYear1());
			state.setInt(9, job.getYear2());
			state.setString(10, job.getSkill());
			state.setString(11, job.getDescription());
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
			try{
			state.close();
			conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

		public  boolean  deleteJob(Job  job){
			boolean  flag=true;
			conn=DatabaseConnection.getConnection();
	        String  sql="delete from job  where  enterprise_id=?,job_name=?";
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,job.getEnterId() );
				state.setString(2,job.getJobName());
				state.execute();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
	        return  flag;
		}
		
		
		
		public  Job  queryJob(String entername,String jobname){
			
			conn=DatabaseConnection.getConnection();
	        String  sql="select  * from  job  where  entername=? and  job_name=?";
	      job =new Job();
	        try {
				state=conn.prepareStatement(sql);
				state.setString(1,entername);
				state.setString(2, jobname);
				ResultSet  re=state.executeQuery();
				while(re.next()){
					job.setEntername(re.getString("entername"));
					job.setJobName(re.getString("job_name"));
					job.setGender(re.getString("gender"));
					job.setGangweimiaoshu(re.getString("gangweimiaoshu"));
					job.setDescription(re.getString("description"));
					job.setNeedNumber(re.getInt("need_number"));
					job.setReminder(re.getInt("reminder"));
					job.setSkill(re.getString("skill"));
					job.setYear1(re.getInt("year1"));
					job.setYear2(re.getInt("year2"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return job;
		}
		
public  List<Job>  queryAllJob(){
			List<Job> list=new LinkedList<Job>();
			conn=DatabaseConnection.getConnection();
	        String  sql="select  * from  job ";
	     
	        try {
				state=conn.prepareStatement(sql);
				ResultSet  re=state.executeQuery();
				while(re.next()){
					 job =new Job();
					job.setEntername(re.getString("entername"));
					job.setJobName(re.getString("job_name"));
					job.setGender(re.getString("gender"));
					job.setGangweimiaoshu(re.getString("gangweimiaoshu"));
					job.setDescription(re.getString("description"));
					job.setNeedNumber(re.getInt("need_number"));
					job.setReminder(re.getInt("reminder"));
					job.setSkill(re.getString("skill"));
					job.setYear1(re.getInt("year1"));
					job.setYear2(re.getInt("year2"));
					list.add(job);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return list;
		}
		
		
		
		public  boolean  updatejob(Job  job){
			boolean  flag=true;
			conn=DatabaseConnection.getConnection();
			
			String sql="update job set reminder=?   where entername=? and job_name=?";
			try {
				conn.setAutoCommit(false);
				state=conn.prepareStatement(sql);
			state.setInt(1,job.getReminder()-1 );
			state.setString(2, job.getEntername());
			state.setString(3,job.getJobName());
				state.executeUpdate();
				conn.commit();
			} catch (SQLException e) {
				try {flag=false;
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
	return  flag;	}
		
		
}
