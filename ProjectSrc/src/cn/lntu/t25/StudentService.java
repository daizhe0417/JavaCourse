package cn.lntu.t25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class StudentService {

private Connection conn;
private PreparedStatement state;
private Student student;


public  boolean  saveStudent(Student  student){
	boolean flag=true;
	conn=DatabaseConnection.getConnection();
	
	String sql="insert into student (id,idNumber,name,sex,address,college_id,major_id,phoneNumber,employment)values(?,?,?,?,?,?,?,?,?)";
	try {
		conn.setAutoCommit(false);
		state=conn.prepareStatement(sql);
		state.setInt(1, student.getId());
		state.setString(2, student.getIdNumber());
		state.setString(3,  student.getName());
		state.setString(4,  student.getSex());
		state.setString(5,  student.getAddress());
		state.setInt(6,  student.getCollege());
		state.setInt(7,  student.getMajor());
		state.setString(8,  student.getPhoneNumber());
		state.setString(9,  student.isEmployment());
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

	public  boolean  deleteStudent(int  id){
		boolean flag=true;
		conn=DatabaseConnection.getConnection();
        String  sql="delete  from student  where  id=?";
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
	
	
	
	public  Student  queryStudent(int id){
		
		conn=DatabaseConnection.getConnection();
        String  sql="select  * from student  where  id=?";
        student =new Student();
        try {
			state=conn.prepareStatement(sql);
			state.setInt(1,id);
			ResultSet  re=state.executeQuery();
			while(re.next()){
				student.setId(re.getInt("id"));
				student.setName(re.getString("name"));
				student.setIdNumber(re.getString("idNumber"));
				student.setCollege(re.getInt("college_id"));
				student.setMajor(re.getInt("major_id"));
				student.setAddress(re.getString("address"));
				student.setSex(re.getString("sex"));
				student.setPhoneNumber(re.getString("phoneNumber"));
				student.setEmployment(re.getString("employment"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return student;
	}
	
	
	public  boolean  updateStudent(Student student){
		boolean flag=true;
		conn=DatabaseConnection.getConnection();
		
		String sql="UPDATE student SET name=?,address=?,phoneNumber=?,employment=?  WHERE id=?";
		try {
			conn.setAutoCommit(false);
			state=conn.prepareStatement(sql);
			state.setString(1,  student.getName());
			state.setString(2,  student.getAddress());
			state.setString(3,  student.getPhoneNumber());
			state.setInt(4, student.getId());
			state.setString(5, student.isEmployment());
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
		return flag;
	}
	
	
	
}
	
	
	
	

