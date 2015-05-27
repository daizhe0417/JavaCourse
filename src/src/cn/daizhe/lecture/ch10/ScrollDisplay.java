package cn.daizhe.lecture.ch10;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ScrollDisplay extends JFrame implements ActionListener {
	JLabel lbRow = new JLabel("行数");
	JTextField tfRow = new JTextField();
	JButton btnQuery = new JButton("查询");
	JPanel panel = new JPanel();
	JTextArea taInfo = new JTextArea();

	public ScrollDisplay() {
		super("滚动显示学生信息");
		setSize(320, 260);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new BorderLayout());
		panel.add(lbRow, BorderLayout.WEST);
		panel.add(tfRow, BorderLayout.CENTER);
		panel.add(btnQuery, BorderLayout.EAST);
		btnQuery.addActionListener(this);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(taInfo, BorderLayout.CENTER);
	}

	public void getRecord(int Row) throws SQLException {
		String URL, SQL;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			taInfo.setText(ex.getMessage());
			System.exit(-1);
		}
		try {
			URL = "jdbc:mysql://localhost:3306/student?user=root&password=lntujiuru";
			con = DriverManager.getConnection(URL);
			// 判断记录总数
			// 也可以用rs.getRow()，效率没有这个高
			String newSQL = "SELECT COUNT(1) AS CT FROM (stu)";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(newSQL);
			rs.next();
			int rowCount = rs.getInt(1);
			if (rowCount > Row) {
				// 创建一个可滚动但不可更新的结果集
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				SQL = "SELECT * FROM stu";
				rs = stmt.executeQuery(SQL);
				if (rs == null || rs.getRow() > Row) {
					taInfo.setText("暂无记录");
				} else {
					rs.absolute(Row);// 将游标移到指定的行
					taInfo.setText("");
					taInfo.setText(rs.getString("name") + "\t");
					taInfo.append(rs.getString("dept") + "\t");
					taInfo.append(String.valueOf(rs.getInt("age")) + "\t");
					taInfo.append(rs.getString("sex") + "\n");
				}
			} else {
				taInfo.setText("只有" + rowCount + "条记录");
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			taInfo.setText(ex.getMessage());
			ex.printStackTrace();
		} finally {
			con.close();
		}
	}

	public static void main(String[] args) {
		ScrollDisplay frame = new ScrollDisplay();
		frame.show();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuery) {
			String strRow = tfRow.getText();// 获取用户输入的行号
			int intRow = Integer.parseInt((strRow));
			try {
				getRecord(intRow);
			} catch (SQLException ex) {
				taInfo.setText(ex.getMessage());
			}
		}
	}
}
