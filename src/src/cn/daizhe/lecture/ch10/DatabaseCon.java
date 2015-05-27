package cn.daizhe.lecture.ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DatabaseCon extends JFrame {
	JTextArea taInfo = new JTextArea();

	public DatabaseCon() {
		super("连接数据库");
		setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(taInfo);
		this.setVisible(true);
	}

	public void connecion() {
		try {
			// 加载JDBC-ODBC桥驱动程序
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			taInfo.setText(ex.getMessage());
			System.exit(-1);
		}
		try {
			// 建立 连接
			String URL = "jdbc:mysql://localhost:3306/student?user=root&password=lntujiuru";
			Connection con = DriverManager.getConnection(URL);
			if (!con.isClosed()) {// 判断数据库连接是否成功
				taInfo.setText("数据库连接成功");
			} else {
				taInfo.setText("数据库连接失败");
			}
			con.close();
		} catch (SQLException ex) {
			taInfo.setText(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		DatabaseCon frame = new DatabaseCon();
		frame.connecion();
	}
}
