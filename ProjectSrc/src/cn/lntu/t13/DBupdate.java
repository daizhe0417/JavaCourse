package cn.lntu.t13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBupdate {
	public static int update(Worker w) {
	    Connection conn = DBconnect.getConn();
	    int i = 0;
	    String sql = "update wworker set birth='" + w.birth + "' where Name='" + w.name + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
}
