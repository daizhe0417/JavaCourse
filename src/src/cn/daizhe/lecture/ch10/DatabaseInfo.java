package cn.daizhe.lecture.ch10;

import javax.swing.*;
import java.sql.*;

public class DatabaseInfo extends JFrame {
	JTextArea taInfo = new JTextArea();

	public DatabaseInfo() {
		super("数据库信息");
		setSize(300, 260);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(taInfo);
		this.setVisible(true);
	}

	public void getDatabaseInfo() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			taInfo.setText(ex.getMessage());
			System.exit(-1);
		}
		try {
			String URL = "jdbc:mysql://localhost:3306/student?user=root&password=lntujiuru";
			con = DriverManager.getConnection(URL);
			DatabaseMetaData dbmt = con.getMetaData();
			taInfo.setText("JDBC URL:" + dbmt.getURL() + "\n");
			taInfo.append("JDBC 驱动程序" + dbmt.getDriverName() + "\n");
			taInfo.append("用户名" + dbmt.getUserName() + "\n");
			taInfo.append("数据库名" + dbmt.getDatabaseProductName() + "\n");
			con.close();
		} catch (SQLException ex) {
			taInfo.setText(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		DatabaseInfo frame = new DatabaseInfo();
		frame.getDatabaseInfo();
	}
}
