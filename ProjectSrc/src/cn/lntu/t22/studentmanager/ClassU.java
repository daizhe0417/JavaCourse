package cn.lntu.t22.studentmanager;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClassU extends JFrame {
	JPanel contentPane;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JTextField jTextField1 = new JTextField();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JOptionPane jOptionPane1 = new JOptionPane();
	JComboBox jComboBox1 = new JComboBox();
	int xi;
	dbConn conn = new dbConn();
	JLabel jLabel4 = new JLabel();
	JComboBox jComboBox2 = new JComboBox();
	String find;

	public ClassU(String find) {
		this.find = find;
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(465, 280));
		setTitle("班级修改");
		jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		jLabel1.setText("班 级 信 息 修 改");
		jLabel1.setBounds(new Rectangle(136, 20, 212, 25));
		jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel2.setText("班级名称:");
		jLabel2.setBounds(new Rectangle(80, 80, 90, 20));
		jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel3.setText("所属系部:");
		jLabel3.setBounds(new Rectangle(80, 130, 90, 20));
		jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField1.setBounds(new Rectangle(180, 80, 180, 25));
		jButton1.setBounds(new Rectangle(102, 223, 96, 29));
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton1.setText("修 改");
		jButton1.addActionListener(new ClassU_jButton1_actionAdapter(this));
		jButton2.setBounds(new Rectangle(265, 221, 96, 31));
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton2.setToolTipText("");
		jButton2.setText("退 出");
		jButton2.addActionListener(new ClassU_jButton2_actionAdapter(this));
		jOptionPane1.setBounds(new Rectangle(106, 258, 262, 90));
		jOptionPane1.setLayout(null);
		jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox1.setBounds(new Rectangle(180, 130, 180, 25));
		jComboBox1.addActionListener(new ClassU_jComboBox1_actionAdapter(this));
		jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel4.setText("所属专业：");
		jLabel4.setBounds(new Rectangle(80, 180, 90, 20));
		jComboBox2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox2.setEditable(true);
		jComboBox2.setBounds(new Rectangle(180, 180, 180, 25));
		contentPane.add(jLabel1);
		contentPane.add(jOptionPane1);
		contentPane.add(jComboBox1);
		contentPane.add(jLabel3);
		contentPane.add(jLabel2);
		contentPane.add(jTextField1);
		contentPane.add(jLabel4);
		contentPane.add(jComboBox2);
		contentPane.add(jButton2);
		contentPane.add(jButton1);
		jComboBox1.addItem("请选择系部");
		try {
			ResultSet rs = conn.getRs("select * from Dept ");
			while (rs.next()) {
				String xibu = rs.getString("DeptName");
				jComboBox1.addItem(xibu);
			}
		} catch (Exception ce) {
			System.out.println("++++++++" + ce);
		}
		jComboBox2.setEnabled(false);
		xianshi();
	}

	public void setTitle(String string) {
		// TODO Auto-generated method stub

	}

	public void setSize(Dimension dimension) {
		// TODO Auto-generated method stub

	}

	public void zhuanye() {
		jComboBox2.removeAllItems();
		jComboBox2.addItem("请选择专业");
		try {
			ResultSet rs = conn.getRs("select * from ds where DeptName='"
					+ String.valueOf(jComboBox1.getSelectedItem()) + "' ");
			while (rs.next()) {
				String zhy = rs.getString("SpecialityName");
				jComboBox2.addItem(zhy);
			}
		} catch (Exception ce) {
			System.out.println("++++++++" + ce);
		}
	}

	public void xibu() {
		String sel = String.valueOf(jComboBox2.getSelectedItem());
		try {
			ResultSet rs = conn
					.getRs("select * from Speciality where SpecialityName='"
							+ sel + "'");
			while (rs.next()) {
				xi = rs.getInt("SpecialityId");
			}
			rs.close();
		} catch (Exception ce) {
			System.out.println("++++++++" + ce);
		}
	}

	public void jButton2_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	public void jButton1_actionPerformed(ActionEvent e) {
		if (this.jTextField1.getText().trim().length() == 0) {
			jOptionPane1.showMessageDialog(this, "班级名称不能为空", "提示",
					JOptionPane.INFORMATION_MESSAGE, null);
			if (jComboBox1.getSelectedIndex() == 0) {
				jOptionPane1.showMessageDialog(this, "请选择所属系部！", "提示",
						JOptionPane.INFORMATION_MESSAGE, null);
			} else if (jComboBox2.getSelectedIndex() == 0) {
				jOptionPane1.showMessageDialog(this, "请选择所属专业！", "提示",
						JOptionPane.INFORMATION_MESSAGE, null);
			} else {
				xibu();
				try {
					boolean classname = false;
					ResultSet rs = conn.getRs("select ClassName from Class");
					while (rs.next()) {
						if (jTextField1.getText().trim()
								.equals(rs.getString("ClassName").trim())) {
							classname = true;
						}
					}
					if (classname) {
						jOptionPane1.showMessageDialog(this, "该班级名称已经存在！",
								"提示", JOptionPane.INFORMATION_MESSAGE, null);
					} else {
						conn.getUpdate("update Class set ClassName='"
								+ jTextField1.getText().trim()
								+ "',SpecialityId='" + xi + "' where ClassId='"
								+ Integer.valueOf(find) + "'");
						jOptionPane1.showMessageDialog(this, "恭喜您班级信息修改成功！",
								"提示", JOptionPane.INFORMATION_MESSAGE, null);
					}
				} catch (Exception ce) {
					System.out.println(ce);
				}
			}
		}
	}

	public void jComboBox1_actionPerformed(ActionEvent e) {
		zhuanye();
		jComboBox2.setEnabled(true);
	}

	public void xianshi() {
		if (find == null)
			return;
		else {
			jComboBox2.setEnabled(true);
			try {
				ResultSet rs = conn.getRs("select * from deptS whereClassId='"
						+ Integer.valueOf(find) + "'");
				while (rs.next()) {

					jComboBox1.setSelectedItem(String.valueOf(rs.getString(2)));

					jComboBox2.setSelectedItem(String.valueOf(rs.getString(3)));
					jTextField1.setText(rs.getString(4).trim());
				}
				rs.close();
			} catch (Exception ce) {
				System.out.println("++++++++" + ce);
			}
		}
	}
}

class ClassU_jComboBox1_actionAdapter implements ActionListener {
	private ClassU adaptee;

	ClassU_jComboBox1_actionAdapter(ClassU adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jComboBox1_actionPerformed(e);
	}
}

class ClassU_jButton1_actionAdapter implements ActionListener {
	private ClassU adaptee;

	ClassU_jButton1_actionAdapter(ClassU adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class ClassU_jButton2_actionAdapter implements ActionListener {
	private ClassU adaptee;

	ClassU_jButton2_actionAdapter(ClassU adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);

	}
}
