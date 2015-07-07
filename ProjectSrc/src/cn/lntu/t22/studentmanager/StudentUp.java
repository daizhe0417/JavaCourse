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
public class StudentUp extends JFrame {
	JPanel contentPane;
	 JLabel jLabel2 = new JLabel();
	 JLabel jLabel3 = new JLabel();
	 JLabel jLabel4 = new JLabel();
	 JLabel jLabel5 = new JLabel();
	 JLabel jLabel6 = new JLabel();
	 JLabel jLabel7 = new JLabel();
	 JLabel jLabel8 = new JLabel();
	 JLabel jLabel9 = new JLabel();
	 JTextField jTextField1 = new JTextField();
	 JTextField jTextField2 = new JTextField();
	 JTextField jTextField3 = new JTextField();
	 JTextField jTextField4 = new JTextField();
	 JComboBox jComboBox4 = new JComboBox();
	 JComboBox jComboBox5 = new JComboBox();
	 JButton jButton1 = new JButton();
	 JButton jButton2 = new JButton();
	 JTextField jTextField5 = new JTextField();
	 int xiN;
	 dbConn con = new dbConn();
	 Object clas[] = {};
	 JLabel jLabel10 = new JLabel();
	 JComboBox jComboBox1 = new JComboBox();
	 dbConn conn = new dbConn();
	 JOptionPane jOptionPane1 = new JOptionPane();
	 String uid, rname, num, addr, idc, find,cname,sname,dname;
	 public StudentUp(String find) {
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
	 setSize(new Dimension(592, 500));
	 setTitle("学生信息注册");
	 jLabel2.setFont(new java.awt.Font("Dialog", Font.BOLD, 23));
	 jLabel2.setText("学 生 信 息 修 改");
	 jLabel2.setBounds(new Rectangle(197, 17, 231, 25));
	 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
	 jLabel3.setText("用 户 名:");
	 jLabel3.setBounds(new Rectangle(50, 74, 90, 22));
	 jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
	 jLabel4.setText("姓 名:");
	 jLabel4.setBounds(new Rectangle(50, 124, 90, 22));
	 jLabel5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
	 jLabel5.setText("身份证号:");
	 jLabel5.setBounds(new Rectangle(50, 224, 90, 22));
	 jLabel6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
	 jLabel6.setText("学 号:");
	 jLabel6.setBounds(new Rectangle(50, 174, 90, 22));
	/* jLabel7.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
	 jLabel7.setText("所属系部:");
	 jLabel7.setBounds(new Rectangle(50, 274, 90, 22));
	 jLabel8.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
	 jLabel8.setText("所属专业:");
	 jLabel8.setBounds(new Rectangle(297, 274, 90, 22));*/
	 jLabel9.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
	 jLabel9.setText("家庭住址:");
	 jLabel9.setBounds(new Rectangle(45, 374, 90, 22));
	 jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
	 jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
	 jTextField1.setBounds(new Rectangle(150, 74, 195, 23));
	 jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
	 jTextField2.setBorder(BorderFactory.createLoweredBevelBorder());
	 jTextField2.setText("");
	 jTextField2.setBounds(new Rectangle(150, 124, 195, 23));
	 jTextField3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
	 jTextField3.setBorder(BorderFactory.createLoweredBevelBorder());
	 jTextField3.setText("");
	 jTextField3.setBounds(new Rectangle(150, 174, 195, 23));
	 jTextField4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
	 jTextField4.setBorder(BorderFactory.createLoweredBevelBorder());
	 jTextField4.setText("");
	 jTextField4.setBounds(new Rectangle(150, 374, 395, 25));
	/* jComboBox4.setFont(new java.awt.Font("Dialog", Font.PLAIN,
	16));

	jComboBox4.setBorder(BorderFactory.createLoweredBevelBorder());
	 jComboBox4.setBounds(new Rectangle(150, 274, 125, 25));
	 jComboBox4.addActionListener(new

	//StudentUp_jComboBox4_actionAdapter(this));
	 jComboBox5.setEnabled(false);
	 jComboBox5.setFont(new java.awt.Font("Dialog", Font.PLAIN,
	16));

	jComboBox5.setBorder(BorderFactory.createLoweredBevelBorder());
	 jComboBox5.setBounds(new Rectangle(390, 274, 125, 25));
	 jComboBox5.addActionListener(new

	//StudentUp_jComboBox5_actionAdapter(this));*/
	 jButton2.setBounds(new Rectangle(375, 424, 90, 27));
	 jButton1.setBounds(new Rectangle(147, 424, 90, 27));
	 jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
	 jButton1.setText("提 交");
	 jButton1.addActionListener(new

	StudentUp_jButton1_actionAdapter(this));
	 jButton2.setText("退 出");
	 jButton2.addActionListener(new

	StudentUp_jButton2_actionAdapter(this));
	 jTextField5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
	 jTextField5.setBorder(BorderFactory.createLoweredBevelBorder());
	 jTextField5.setBounds(new Rectangle(150, 224, 195, 23));
	 jLabel10.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
	 jLabel10.setText("所在班级：");
	 jLabel10.setBounds(new Rectangle(47, 324, 93, 29));
	 jComboBox1.setEnabled(true);
	 jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN,
	16));
	 jComboBox1.setBounds(new Rectangle(150, 324, 125, 25));
	 contentPane.add(jLabel2);
	// contentPane.add(jLabel8);
	 contentPane.add(jComboBox5);
	 //contentPane.add(jLabel7);
	 contentPane.add(jComboBox4);
	 contentPane.add(jLabel3);
	 contentPane.add(jTextField1);
	 contentPane.add(jLabel4);
	 contentPane.add(jLabel6);
	 contentPane.add(jTextField2);
	 contentPane.add(jTextField3);
	 contentPane.add(jTextField5);
	 contentPane.add(jLabel5);
	 contentPane.add(jButton1);
	 contentPane.add(jButton2);
	 contentPane.add(jTextField4);
	 contentPane.add(jLabel9);
	 contentPane.add(jLabel10);
	 contentPane.add(jComboBox1);
	 jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
	 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
	 /*this.jComboBox4.addItem("请选择系部");
	 try {
	 ResultSet rs = con.getRs("select * from Dept ");
	 while (rs.next()) {
	 String xibu = rs.getString("DeptName");
	 jComboBox4.addItem(xibu);
	 }
	 } catch (Exception ce) {
	 System.out.println(ce);
	 }
	 showstu();
	 jComboBox5.setEnabled(false);
	 jComboBox1.setEnabled(false);*/
	 }
	 /*public void jComboBox4_actionPerformed(ActionEvent e) {
	 jcb();
	 jComboBox5.setEnabled(true);
	 }
	 public void jComboBox5_actionPerformed(ActionEvent e) {
	 classAdd();
	 jComboBox1.setEnabled(true);
	 }*/
	 public void jButton1_actionPerformed(ActionEvent e) {
	 if (jTextField1.getText().trim().equals("")) {
	 jOptionPane1.showMessageDialog(this, "请输入学生用户名！", "提 示",jOptionPane1.INFORMATION_MESSAGE);
	 } else if (jTextField2.getText().trim().equals("")) {
		 jOptionPane1.showMessageDialog(this, "请输入学生姓名！", "提 示",jOptionPane1.INFORMATION_MESSAGE);
		 //jOptionPane1.showMessageDialog(this, "请输入学生姓名！", "提 示",jOptionPane1.INFORMATION_MESSAGE);
	 } else if (jTextField3.getText().trim().equals("")) {
	 jOptionPane1.showMessageDialog(this, "请输入学生学号！", "提 示",jOptionPane1.INFORMATION_MESSAGE);
	 } else if (jTextField5.getText().trim().equals("")) {
		 jOptionPane1.showMessageDialog(this, "请输入学生的身份证 号！", "提 示",jOptionPane1.INFORMATION_MESSAGE);
				  } else if (jComboBox4.getSelectedIndex() == 0) {
				  jOptionPane1.showMessageDialog(this, "请选择学生所在系部！", "提 示",jOptionPane1.INFORMATION_MESSAGE);
				  } else if (jComboBox5.getSelectedIndex() == 0) {
				  jOptionPane1.showMessageDialog(this, "请选择学生所属专 业！", "提 示", jOptionPane1.INFORMATION_MESSAGE);
				  } else if (jComboBox1.getSelectedIndex() == 0) {
				  jOptionPane1.showMessageDialog(this, "请选择学生所在班 级！", "提 示", jOptionPane1.INFORMATION_MESSAGE);
				  } else if (jTextField4.getText().trim().equals("")) {
				  jOptionPane1.showMessageDialog(this, "请输入学生详细地址！", "提 示",jOptionPane1.INFORMATION_MESSAGE);
				  } else {
				  try {
				  findC();
				  boolean Num = false;
				  ResultSet rs = conn.getRs("select * from Student");
				  while (rs.next()) {
				  if (jTextField3.getText().trim().equals(rs.getString(
				  "Number").trim())) {
				  Num = true;
				  }
				  }
				  rs.close();
				  if (Num) {
				  jOptionPane1.showMessageDialog(this, "学生学号已存在，请重 新输入！", "提示",JOptionPane. INFORMATION_MESSAGE, null);
				  } else {
				  uid = jTextField1.getText().trim();
				  rname = jTextField2.getText().trim();
				  num = jTextField3.getText().trim();
				  addr = jTextField4.getText().trim();
				  idc = jTextField5.getText().trim();
				  inuser();
				  instu();
				  }
				  } catch (Exception ce) {
				  System.out.println(ce.getMessage());
				  }
				  }
				  }
				  public void jButton2_actionPerformed(ActionEvent e) {
				  this.dispose();
				  }
				  /*public void jcb() {
				  jComboBox5.removeAllItems();
				  jComboBox5.addItem("请选择专业");
				  try {
				  ResultSet rs = conn.getRs("select * from ds where DeptName='"
				 +

				 String.valueOf(jComboBox4.getSelectedItem()) +
				  "' ");
				  while (rs.next()) {
					  String zhy = rs.getString("SpecialityName");
					  jComboBox5.addItem(zhy);
					  }
					  rs.close();
					  } catch (Exception e) {
					  System.out.println(e.getMessage());
					  }
					  }*/
					  public void findC() {
					  try {
					  ResultSet rs = conn.getRs("select * from sc where ClassName='" + String.valueOf(jComboBox1.getSelectedItem()) + "' ");
					  while (rs.next()) {
					  xiN = rs.getInt("ClassId");
					  }
					  rs.close();
					  } catch (Exception e) {
					  System.out.println(e.getMessage());
					  }
					  }
					  public void classAdd() {
					  jComboBox1.removeAllItems();
					  jComboBox1.addItem("请选择班级");
					  try {
					  ResultSet rs = conn.getRs("select * from sc");
while (rs.next()) {
String zhy = rs.getString("ClassName");
jComboBox1.addItem(zhy);
}
rs.close();
} catch (Exception e) {
System.out.println(e);
}
}
public void instu() {
try {
conn.getUpdate("update Student set(UserId,RealName,ClassId,Address,IdentityCode) values ('" +uid + "','" + rname + "','" + xiN +"','" +addr + "','" + idc +"') where Number='"+find+"' ");
} catch (Exception ce) {
System.out.println(ce.getMessage());
}
}
public void inuser() {
try {
conn.getUpdate("insert into User1 (adminName,adminType) values('" +
uid +
"','0')");
} catch (Exception ce) {
System.out.println(ce.getMessage());
}
}
public void showstu() {
if(find==""){
return;
}else{
try {
ResultSet rs = con.getRs("select * from findstu where Number='" +find + "' ");
while (rs.next()) {
uid=rs.getString(1);
rname=rs.getString(2);
num=rs.getString(3);
cname=rs.getString(4);
idc=rs.getString(5);
addr=rs.getString(6);
sname=rs.getString(8);
dname=rs.getString(9);
}
} catch (Exception ce) {
System.out.println(ce);
}
jTextField1.setText(uid);
jTextField2.setText(rname);
jTextField3.setText(num);
jComboBox4.setSelectedItem(dname);
jComboBox5.addItem(sname);
jComboBox1.addItem(cname);
jTextField4.setText(addr);
jTextField5.setText(idc);
}
}
	}
	class StudentUp_jButton2_actionAdapter implements ActionListener {
	 private StudentUp adaptee;
	 StudentUp_jButton2_actionAdapter(StudentUp adaptee) {
	 this.adaptee = adaptee;
	 }
	 public void actionPerformed(ActionEvent e) {
	 adaptee.jButton2_actionPerformed(e);
	 }
	}
	class StudentUp_jButton1_actionAdapter implements ActionListener {
	 private StudentUp adaptee;
	 StudentUp_jButton1_actionAdapter(StudentUp adaptee) {
	 this.adaptee = adaptee;
	 }
	 public void actionPerformed(ActionEvent e) {
	 adaptee.jButton1_actionPerformed(e);
	 }
	/*class StudentUp_jComboBox5_actionAdapter implements ActionListener {
	 private StudentUp adaptee;
	 StudentUp_jComboBox5_actionAdapter(StudentUp adaptee) {
	 this.adaptee = adaptee;
	 }
	 /*public void actionPerformed(ActionEvent e) {
	 adaptee.jComboBox5_actionPerformed(e);
	 }
	}
	class StudentUp_jComboBox4_actionAdapter implements ActionListener {
		 private StudentUp adaptee;
		 StudentUp_jComboBox4_actionAdapter(StudentUp adaptee) {
		 this.adaptee = adaptee;
		 }
		 public void actionPerformed(ActionEvent e) {
		 adaptee.jComboBox4_actionPerformed(e);
		 }*/
		
	 
		 

}

