package cn.daizhe.lecture.ch10;

import javax.swing.*;

import java.awt.*;
import java.sql.*;

public class AddStudent extends JFrame {
	JTextArea taInfo = new JTextArea();
	JScrollPane panel = new JScrollPane();

	public AddStudent() {
		super("添加学生信息");
		setSize(350, 260);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.getViewport().add(taInfo);
		getContentPane().add(panel);
		this.setVisible(true);
	}

	public void MidifyStudentTb() throws SQLException {
		String URL, SQL;
		Connection con = null;
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			taInfo.setText(ex.getMessage());
			System.exit(-1);
		}
		try {
			// 建立连接
			URL = "jdbc:mysql://localhost:3306/student?user=root&password=lntujiuru";
			con = DriverManager.getConnection(URL);
			// 创建一个可滚动可更新的结果集
			Statement stmt = con
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			SQL = "SELECT id,name,dept,age,sex FROM stu";
			ResultSet rs = stmt.executeQuery(SQL);
			// 显示所有结果
			taInfo.setText("更新前的学生信息表\n");
			while (rs.next()) {
				// 将结果集中的数据添加到文本框中
				taInfo.append(rs.getString("id") + "\t");
				taInfo.append(rs.getString("name") + "\t");
				taInfo.append(rs.getString("age") + "\t");
				taInfo.append(rs.getString("dept") + "\n");
				taInfo.append(rs.getString("sex") + "\n");
			}
			// 添加一个新的记录
			rs.moveToInsertRow();
			rs.updateString("id", "102030405060");
			rs.updateString("name", "李煜");
			rs.updateInt("age", 20);
			rs.updateString("dept", "计算机");
			rs.updateString("sex", "male");
			rs.insertRow();
			rs.beforeFirst();
			taInfo.append("插入后的学生信息表\n");
			while (rs.next()) {
				taInfo.append(rs.getString("id") + "\t");
				taInfo.append(rs.getString("name") + "\t");
				taInfo.append(rs.getString("age") + "\t");
				taInfo.append(rs.getString("dept") + "\n");
				taInfo.append(rs.getString("sex") + "\n");
			}
			// 删除最后一条记录
			// rs.absolute(10);
			rs.last();
			rs.deleteRow();
			taInfo.append("删除后的学生信息表\n");
			while (rs.next()) {
				taInfo.append(rs.getString("id") + "\t");
				taInfo.append(rs.getString("name") + "\t");
				taInfo.append(rs.getString("age") + "\t");
				taInfo.append(rs.getString("dept") + "\n");
				taInfo.append(rs.getString("sex") + "\n");
			}
			rs.close();
			rs = stmt.executeQuery(SQL);
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			taInfo.setText(ex.getMessage());
		} finally {
			con.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		AddStudent frame = new AddStudent();
		frame.MidifyStudentTb();
	}
}
