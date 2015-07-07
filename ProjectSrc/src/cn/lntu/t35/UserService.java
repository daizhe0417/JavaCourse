package cn.lntu.t35;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
	private static final String url = "jdbc:mariadb://localhost:3306/stusystem";
	private static final String user = "root";
	private static final String password = "123";
	
	/**
	 * 获取数据库连接
	 */
	
	PreparedStatement state;
	
	
	
	 static Connection getDbConnection() {
		/**
		 * 数据库链接判断
		 */
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("*error:  数据库驱动加载失败！");
			return null;
		}
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (SQLException ex) {
			System.out.println("*error:  数据库加载失败！");
			return null;
		}
	}

	
	
	
	public String Userpwd(String name, String pwd) {
		/**
		 * 登陆数据库语句
		 */
		Connection conn = getDbConnection();
		User user = new User();
		PreparedStatement pstm;
		ResultSet rs;
		try {
			String sql = "select * from stuinformation  where stunum = ? and password = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, pwd);
			rs = pstm.executeQuery();
			if (rs.next()) {
				user.setPower(rs.getString("power"));
				user.setPassword(rs.getString("password"));
				user.setStuname(rs.getString("stuname"));
				user.setStunum(rs.getString("stunum"));
				user.setStusex(rs.getString("stusex"));
				user.setStuhometown(rs.getString("stuhometown"));
				user.setStuclass(rs.getString("stuclass"));
				user.setStumajor(rs.getString("stumajor"));
				user.setStuinstitute(rs.getString("stuinstitute"));
				
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user.toJson();
	}

	
	
	public  int  update(String newPwd1,String stunum){
			/**
			 * 修改密码
			 */
			Connection conn=UserService.getDbConnection();
			try {
				String sql="update  stuinformation set password='"+ newPwd1 +"' where  stunum='"+stunum+"'";
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
	
	
	
	    public  boolean  saveStudent(User user){
	    	/**
	    	 * 添加SQL语句
	    	 */
		Connection conn = getDbConnection();
		boolean flag=true;
		String sql="insert into stuinformation (power,password,stuname,stunum,stusex,stuhometown,stuclass,stumajor,stuinstitute)values(?,?,?,?,?,?,?,?,?)";
		try {
			state=conn.prepareStatement(sql);
			state.setString(1,user.getPower());
			state.setString(2,user.getPassword());
			state.setString(3,user.getStuname());
			state.setString(4,user.getStunum());
			state.setString(5,user.getStusex());
			state.setString(6,user.getStuhometown());
			state.setString(7,user.getStuclass());
			state.setString(8,user.getStumajor());
			state.setString(9,user.getStuinstitute());
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

	    
	    public  User  queryStudent(int id){
			/**
			 * 查询SQL语句
			 */
	    	Connection conn = getDbConnection();
	        String  sql="select  * from stuinformation  where  stunum=?";
	        User user =new User();
	        try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				ResultSet  re=state.executeQuery();
				while(re.next()){
					user.setPower(re.getString("power"));
					user.setPassword(re.getString("password"));
					user.setStuname(re.getString("stuname"));
					user.setStunum(re.getString("stunum"));
					user.setStusex(re.getString("stusex"));
					user.setStuhometown(re.getString("stuhometown"));
					user.setStuclass(re.getString("stuclass"));
					user.setStumajor(re.getString("stumajor"));
					user.setStuinstitute(re.getString("stuinstitute"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return user;
		}
	    
	    public  boolean  deleteStudent(int  id){
	    	/**
	    	 * 刪除SQL語句
	    	 */
			boolean flag=true;
			Connection conn = getDbConnection();
	        String  sql="delete  from stuinformation  where  stunum=?";
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
	    
		public  boolean  updateStudent(User user){
			boolean flag=true;
			Connection conn = getDbConnection();
			
			try {
				String sql="update stuinformation set power=?,password =?,stuname=?,stusex=?,stuhometown=?,stuclass=?,stumajor=?,stuinstitute=?  where stunum=?";

				state=conn.prepareStatement(sql);
				state.setString(1,user.getPower());
				state.setString(2,user.getPassword());
				state.setString(3,user.getStuname());
				state.setString(4,user.getStusex());
				state.setString(5,user.getStuhometown());
				state.setString(6,user.getStuclass());
				state.setString(7,user.getStumajor());
				state.setString(8,user.getStuinstitute());
				state.setString(9,user.getStunum());
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
		
		 public  boolean  saveCourse(Course course){
		    	/**
		    	 * 添加课程SQL语句
		    	 */
			 boolean flag=true;
			Connection conn = getDbConnection();
			
			String sql="insert into course (coursenum,coursenam,stutim,credit,teacher)values(?,?,?,?,?)";
			try {
				state=conn.prepareStatement(sql);
				state.setString(1,course.getCoursenum());
				state.setString(2,course.getCoursenam());
				state.setString(3,course.getStutim());
				state.setString(4,course.getCredit());
				state.setString(5,course.getTeacher());
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
		 
		 public  Course  queryCourse(int id){
				/**
				 * 查询课程SQL语句
				 */
		    	Connection conn = getDbConnection();
		        String  sql="select  * from course  where  coursenum=?";
		        Course course =new Course();
		        try {
					state=conn.prepareStatement(sql);
					state.setInt(1,id);
					ResultSet  re=state.executeQuery();
					while(re.next()){
						course.setCoursenum(re.getString("coursenum"));
						course.setCoursenam(re.getString("coursenam"));
						course.setStutim(re.getString("stutim"));
						course.setCredit(re.getString("credit"));
						course.setTeacher(re.getString("teacher"));
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return course;
			}
		 public  boolean  deleteCourse(int  id){
		    	/**
		    	 * 刪除课程SQL語句
		    	 */
				boolean flag=true;
				Connection conn = getDbConnection();
		        String  sql="delete  from course  where  coursenum=?";
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
		 
		 public  boolean  updateCourse(Course course){
			 /**
			  * 修改课程SQL语句
			  */
				boolean flag=true;
				Connection conn = getDbConnection();
				
				try {
					String sql="update course set coursenam=?,stutim =?,credit=?,teacher=?  where coursenum=?";
					state=conn.prepareStatement(sql);
					state.setString(1,course.getCoursenam());
					state.setString(2,course.getStutim());
					state.setString(3,course.getCredit());
					state.setString(4,course.getTeacher());
					state.setString(5,course.getCoursenum());
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
	}
