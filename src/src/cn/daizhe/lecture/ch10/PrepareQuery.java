package cn.daizhe.lecture.ch10;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class PrepareQuery extends JFrame implements ActionListener {
	JTextField tfDepartment = new JTextField();
	JLabel lbDepartment = new JLabel("系别");
	JButton btnQuery = new JButton("查询");
	JPanel panel = new JPanel();
	JTextArea taInfo = new JTextArea();

	public PrepareQuery() {
		super("预编译依据");
		setSize(350, 260);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new BorderLayout());
		panel.add(lbDepartment, BorderLayout.WEST);
		panel.add(tfDepartment, BorderLayout.CENTER);
		panel.add(btnQuery, BorderLayout.EAST);
		btnQuery.addActionListener(this);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(taInfo);
		this.setVisible(true);
	}

	public void getRecord(String strDepartment) throws SQLException {
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
			String URL = "jdbc:mysql://localhost:3306/student?user=root&password=lntujiuru";
			con = DriverManager.getConnection(URL);
			// 定义带参数的预编译语句
			String SQL = "SELECT id,name,dept,age,sex FROM stu"
					+ " WHERE dept=?";
			PreparedStatement preSt = con.prepareStatement(SQL);
			// 为参数指定值
			preSt.setString(1, strDepartment);
			ResultSet rs = preSt.executeQuery();
			taInfo.setText("");// 清空文本框
			while (rs.next()) {
				// 将结果集中的数据添加到文本框中
				taInfo.append(rs.getString("id") + "\t");
				taInfo.append(rs.getString("name") + "\t");
				taInfo.append(rs.getString("age") + "\t");
				taInfo.append(rs.getString("dept") + "\n");
				taInfo.append(rs.getString("sex") + "\n");
			}
			rs.close();
			preSt.close();
		} catch (SQLException ex) {
			taInfo.setText(ex.getMessage());
		} finally {
			con.close();
		}
	}

	public static void main(String[] args) {
		PrepareQuery frame = new PrepareQuery();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuery) {
			String str = tfDepartment.getText();
			try {
				getRecord(str);
			} catch (SQLException ex) {
				taInfo.setText(ex.getMessage());
			}
		}
	}
}
