package cn.daizhe.lecture.ch10;

import javax.swing.*;

import java.sql.*;

public class QueryStudent extends JFrame {
	// 添加方本框组件用于显示结果集
	JTextArea taInfo = new JTextArea();
	JScrollPane panel = new JScrollPane();

	public QueryStudent() {
		super("学生信息");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		panel.getViewport().add(taInfo);
		this.getContentPane().add(panel);
		this.setVisible(true);
	}

	public void getRecord() throws SQLException {
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			taInfo.setText(ex.getMessage());
			System.exit(-1);
		}
		try {
			// 建立连接
			String URL = "jdbc:mysql://localhost:3306/student?user=root&password=lntujiuru";
			Connection con = DriverManager.getConnection(URL);
			Statement stmt = con.createStatement();
			// 执行查询语句
			String SQL = "SELECT id,name,dept,age,sex FROM stu";
			ResultSet rs = stmt.executeQuery(SQL);
			taInfo.setText("");
			// 获取查询结果集
			while (rs.next()) {
				// 将结果集中的数据添加到文本框中
				taInfo.append(rs.getString("id") + "\t");
				taInfo.append(rs.getString("name") + "\t");
				taInfo.append(rs.getString("age") + "\t");
				taInfo.append(rs.getString("dept") + "\t");
				taInfo.append(rs.getString("sex") + "\t");
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			taInfo.setText(ex.getMessage());
		}
	}

	public static void main(String[] args) throws SQLException {
		QueryStudent frame = new QueryStudent();
		frame.getRecord();
	}
}
