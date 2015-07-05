package cn.lntu.t13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBdelete {
	public static int delete(String name) {
	    Connection conn = DBconnect.getConn();
	    int i = 0;
	    String sql = "delete from wworker where Wname='" + name + "'";
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
