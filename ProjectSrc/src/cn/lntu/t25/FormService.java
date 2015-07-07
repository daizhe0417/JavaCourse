package cn.lntu.t25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FormService {
	
private Form  form;
private Connection conn;
private PreparedStatement state;


//对申请表的数据库操作
public  boolean  saveForm(Form  form){
	boolean  flag=true;
	conn=DatabaseConnection.getConnection();
	String sql="insert  into  form(entername,jobname,stu_id,resume,status)values(?,?,?,?,?)";
	try{	conn.setAutoCommit(false);
		state=conn.prepareStatement(sql);
		state.setString(1, form.getEntername());
		state.setString(2, form.getJobname());
		state.setInt(3, form.getStudnetId());
		state.setString(4, form.getResume());
		state.setString(5, form.getStatus());
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

	public  boolean  deleteForm(Form   form){
		boolean  flag=true;
		conn=DatabaseConnection.getConnection();
        String  sql="delete from form where  entername=? and jobname=? and stu_id=?";
        try {
			state=conn.prepareStatement(sql);
			state.setString(1,form.getEntername());
			state.setString(2, form.getJobname());
			state.setInt(3, form.getStudnetId());
			state.execute();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
        return  flag;
	}
	
	
	
	public  Form  queryForm(String entername,Integer studentId,String jobname){
		
		conn=DatabaseConnection.getConnection();
        String  sql="select  * from  form  where  entername=? and  jobname=? and stu_id=?";
         form=new Form();
        try {
			state=conn.prepareStatement(sql);
			state.setString(1, entername);
			state.setString(2, jobname);
			state.setInt(3, studentId);
			ResultSet re = state.executeQuery();
			while(re.next()){
				form.setEntername(re.getString("entername"));
				form.setJobname(re.getString("jobname"));
				form.setStudnetId(re.getInt("stu_id"));
				form.setResume(re.getString("resume"));
				form.setStatus(re.getString("status"));
			}
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
		return form;
	}
	
        public  List<Form>  queryForm(String entername){
		List<Form> list=new LinkedList<Form>();
		conn=DatabaseConnection.getConnection();
        String  sql="select  * from  form  where  entername=? ";
         
        try {
			state=conn.prepareStatement(sql);
			state.setString(1, entername);
		
			ResultSet re = state.executeQuery();
			while(re.next()){
				form=new Form();
				form.setEntername(re.getString("entername"));
				form.setJobname(re.getString("jobname"));
				form.setStudnetId(re.getInt("stu_id"));
				form.setResume(re.getString("resume"));
				form.setStatus(re.getString("status"));
				list.add(form);
			}
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
		return list;
	}
        
        public  List<Form>  queryForm(int id){
    		List<Form> list=new LinkedList<Form>();
    		conn=DatabaseConnection.getConnection();
            String  sql="select  * from  form  where  stu_id=? ";
             
            try {
    			state=conn.prepareStatement(sql);
    			state.setInt(1, id);
    		
    			ResultSet re = state.executeQuery();
    			while(re.next()){
    				form=new Form();
    				form.setEntername(re.getString("entername"));
    				form.setJobname(re.getString("jobname"));
    				form.setStudnetId(re.getInt("stu_id"));
    				form.setResume(re.getString("resume"));
    				form.setStatus(re.getString("status"));
    				list.add(form);
    			}
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
    		return list;
    	}
	
	public  boolean  updateForm(Form  form){
		boolean  flag=true;
		conn=DatabaseConnection.getConnection();
		
		String sql="update form set status=?   where entername=? and jobname=? and stu_id=?";
		try {
			conn.setAutoCommit(false);
			state=conn.prepareStatement(sql);
		    state.setString(1, form.getStatus());
		    state.setString(2, form.getEntername());
		    state.setString(3, form.getJobname());
		    state.setInt(4, form.getStudnetId());
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
				e.printStackTrace();}}
            return  flag;	
            }
	
	
	public  Integer  countnNumber(String  name){
		Integer count=0;
		conn=DatabaseConnection.getConnection();
		String  sql=" select count(entername) as number from  form  where entername=?";
		try{
		state=conn.prepareStatement(sql);
		state.setString(1, name);
		ResultSet re = state.executeQuery();
		while(re.next()){
			count=re.getInt("number");
		}
		}
        catch (SQLException e) {
			
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
		return  count;
	}
	
	
	
	}
	
	

