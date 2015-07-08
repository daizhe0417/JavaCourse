package cn.lntu.t31.Persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lntu.t31.Interface.IDataBaseHelper;

public class DataOperate implements IDataBaseHelper{
	private static final String url = "jdbc:mariadb://localhost:3306/employsystem";
	private static final String user = "root";
    private static final String password = "lzq";
    
    /**
     * 获取数据库连�?
     * @return
     */
	private static Connection getDbConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
            System.out.println("*error:  数据库驱动加载失败！");
            return null;
        }
		try {      
            Connection con = DriverManager.getConnection(url, user, password);    //连接
            return con;
        } catch (SQLException ex) {
            System.out.println("*error:  sql错误�?");
            return null;
        } 
	}
	
	
	 /**
	  * 执行sql命令
	  */
	@Override
	public int ExcuSQL(String SQLString) {
		Connection conn = getDbConnection();
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(SQLString);
			int res = pstm.executeUpdate();
			if(res==0){
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}	
        return 1;
	}

	/**
	 * 通过sql语句获取�?行数�?
	 */
	@Override
	public String[] GetARowDataBySQL(String SQLString, int length) {
		String [] result = new String[length];
		Connection conn = getDbConnection();
		PreparedStatement pstm; 
		ResultSet rs;
		try {
			pstm = conn.prepareStatement(SQLString);
			rs = pstm.executeQuery();
			if(rs.next()){
				for(int i=0;i<length;i++){	
					result[i] = rs.getString(i+1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
		return result;
	}
	
	/**
	 * 数据存在�? 
	 */
	@Override
	public boolean HasData(String SQLString) {
		boolean result = false;
		Connection conn = getDbConnection();
		PreparedStatement pstm;
		ResultSet rs;
		try {
			pstm = conn.prepareStatement(SQLString);
			rs = pstm.executeQuery();
			if(rs.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return result;
	}
	
	/**
	 * 返回数据库中的多行数�?---字符串数�?,从数据库中返回一个字符串数组（select�?
	 */
	@Override
	public List<String[]> GetMutiRowDataBySQL(String SQLString, int length) {
		Connection conn = getDbConnection();
		List<String[]> result= new ArrayList<>();
		String [] res = null;
		PreparedStatement pstm;
		ResultSet rs;
		try {
			pstm = conn.prepareStatement(SQLString);
			rs = pstm.executeQuery();
			while(rs.next()){
				res = new String[length];
				for(int i=0;i<length;i++){
					res[i] = rs.getString(i+1);	
				}
				result.add(res);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	/**
	 * 返回数据库中的多行数�?---字符串数�?,从数据库中返回一个字符串数组（select 带有条件�?
	 */
	@Override
	public List<String[]> GetMutiRowDataBySQL(String SQLString, int length, MutiCondition request){
		Connection conn = getDbConnection();
		List<String[]> result= new ArrayList<>();
		String [] res = new String[length];
		PreparedStatement pstm;
		ResultSet rs;
		try {
			String sql = SQLString + request.Clause;
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				for(int i=0;i<length;i++){
					res[i] = rs.getString(i+1);	
					
				}
				result.add(res);
			}	
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}

		return result;
	}
}
