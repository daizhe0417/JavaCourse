package cn.lntu.t22.studentmanager;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.lang.*;
public class Choose extends JFrame {
	XYLayout xYLayout1 = new XYLayout();
	 JLabel jLabel1 = new JLabel();
	 JLabel jLabel2 = new JLabel();
	 JLabel jLabel3 = new JLabel();
	 JTextField jTextField1 = new JTextField();
	 JTextField jTextField2 = new JTextField();
	 JPanel jPanel1 = new JPanel();
	 XYLayout xYLayout2 = new XYLayout();
	 JScrollPane jScrollPane1 = new JScrollPane();
	 JTable jTable1 = new JTable();
	 JButton jButton1 = new JButton();
	 JPanel jPanel2 = new JPanel();
	 XYLayout xYLayout3 = new XYLayout();
	 JScrollPane jScrollPane2 = new JScrollPane();
	 JButton jButton2 = new JButton();
	 JButton jButton3 = new JButton();
	 JTable jTable2 = new JTable();
	 DefaultTableModel model = new DefaultTableModel();
	 Object[][] arrData = {};
	 String[] arrField = {"课程编号", "课程名称", "学分", "任课教师", "专业编号", "任课编号"};
 String classI, name, level;
 dbConn conn = new dbConn();
 dbConn con = new dbConn();
 int spId, j, intRow;
 String CS[] = new String[100];
 String fd[] = new String[100];
 JOptionPane jOptionPane1 = new JOptionPane();
 int i = 0;
 public Choose(String level, String name) {
 this.name = name;
 try {
 jbInit();
 } catch (Exception exception) {
 exception.printStackTrace();
 }
 }
 private void jbInit() throws Exception {
 getContentPane().setLayout(xYLayout1);
 jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
 jLabel1.setToolTipText("");
 jLabel1.setText("学 生 选 课");
 jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel2.setText("学生姓名：");
 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel3.setText("所属专业：");
 xYLayout1.setWidth(550);
 xYLayout1.setHeight(600);
 jPanel1.setBorder(BorderFactory.createEtchedBorder());
 jPanel1.setLayout(xYLayout2);
 jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton1.setText("选 择");
 jButton1.addActionListener(new
		 Choose_jButton1_actionAdapter(this));
		  jPanel2.setBorder(BorderFactory.createEtchedBorder());
		  jPanel2.setLayout(xYLayout3);
		  jScrollPane2.setBorder(BorderFactory.createEtchedBorder());
		  jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		  jButton2.setText("确 定");
		  jButton3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		  jButton3.setText("删 除");
		  this.setTitle("学生选课");
		  jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		  jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		  this.getContentPane().add(jLabel2, new XYConstraints(41, 92, 83,28));
		  this.getContentPane().add(jTextField2, new XYConstraints(374, 92, 125,25));
		  this.getContentPane().add(jTextField1, new XYConstraints(127, 92, 125, 25));
		  this.getContentPane().add(jLabel3, new XYConstraints(282, 92, 83, 28));
		  this.getContentPane().add(jLabel1, new XYConstraints(210, 23, 130, 38));
		  this.getContentPane().add(jPanel1, new XYConstraints(30, 142, 490,234));
		  jScrollPane1.getViewport().add(jTable1);
		  jPanel1.add(jScrollPane1, new XYConstraints(8, 9, 471, 173));
		  jPanel1.add(jButton1, new XYConstraints(201, 191, 85, 29));
		  jPanel2.add(jScrollPane2, new XYConstraints(7, 5, 473, 106));
		  jScrollPane2.getViewport().add(jTable2);
		  jPanel2.add(jButton3, new XYConstraints(281, 125, 76, 26));
		  jPanel2.add(jButton2, new XYConstraints(137, 125, 76, 26));
		  this.getContentPane().add(jPanel2, new XYConstraints(30, 404, 490,
		 174));
		  try {
			  ResultSet rs = conn.getRs("select * from Student whereUserId='" +name + "' ");
			  while (rs.next()) {
			  jTextField1.setText(rs.getString("RealName"));
			  classI = rs.getString("ClassId");
			  }
			  rs.close();
			  } catch (Exception ce) {
			  System.out.println(ce);
			  }
			  try {
			  ResultSet rs1 = conn.getRs("select * from Class whereClassId='" +
			  classI + "' ");
			  while (rs1.next()) {
			  jTextField2.setText(rs1.getString("ClassName"));
			  spId = rs1.getInt("SpecialityId");
			  }
			  rs1.close();
			  } catch (Exception ce) {
			  System.out.println(ce);
			  }
			  jTextField2.setEditable(false);
			  jTextField1.setEditable(false);
			  UpdateRecord();
			  }
			  public void UpdateRecord() {
			  Object[][] arrTmp = {}; //设定表格的字段
			  Vector vec = new Vector(1, 1);
			  model = new DefaultTableModel(arrTmp, arrField);
			  jTable1 = new JTable(model);
			  jScrollPane1.getViewport().add(jTable1, null);
			  try {
				  ResultSet rs3 = con.getRs(
				  "select * from stuchoose where Expr2='" + spId + "'");
				  while (rs3.next()) {
				  vec = new Vector();
				  vec.add(String.valueOf(rs3.getInt("CourseId")));
				  vec.add(rs3.getString("CourseName").trim());
				  vec.add(String.valueOf(rs3.getInt("CreaditHour")));
				  vec.add(rs3.getString("Expr1"));
				  vec.add(String.valueOf(rs3.getInt("Expr2")));
				  vec.add(String.valueOf(rs3.getInt("Expr3")));
				  model.addRow(vec);
				  }
				  rs3.close();
				  } catch (Exception e) {
				  e.printStackTrace();
				  }
				  jScrollPane1.getHorizontalScrollBar();
				  jTable1.setGridColor(Color.blue);
				  jTable1.setDragEnabled(true);
				  jTable1.setSelectionForeground(Color.red);
				  jTable1.setSelectionBackground(Color.green);

				 jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				  jTable1.setRowSelectionAllowed(true);
				  jTable1.setShowVerticalLines(true);
				  }
				  public void getM() {
				  intRow = jTable1.getSelectedRow();
				  String find1, find2;
				  if (intRow == -1) {
				  jOptionPane1.showMessageDialog(this, "请选择要选修的课程！", "提示",
 JOptionPane.INFORMATION_MESSAGE,
null);
 return;
 }
 try {
 find1 = model.getValueAt(intRow, 4).toString().trim();
 find2 = model.getValueAt(intRow, 5).toString().trim();
 fd[i] = find1;
 CS[i] = find2;
 System.out.println(fd[i]);
 System.out.println(CS[i]);
 } catch (Exception e) {
 e.getMessage();
 }
 }
 public void xuanKe() {
 Object[][] arrTmp = {}; //设定表格的字段
 Vector vec = new Vector(1, 1);
 model = new DefaultTableModel(arrTmp, arrField);
 jTable2 = new JTable(model);
 jScrollPane2.getViewport().add(jTable2, null);
 try {
 j = 0;
 while (j <= i) {
 ResultSet rs3 = con.getRs("select * from stuchoose where Expr2='" +Integer.valueOf(fd[j]) + "' and Expr3='" +Integer.valueOf(CS[j]) + "'");
 System.out.println( "select * from stuchoosewhere Expr2='" + Integer.valueOf(fd[j]) + "' and Expr3='" +Integer.valueOf(CS[j]) + "'");
 while (rs3.next()) {
 vec = new Vector();
 vec.add(String.valueOf(rs3.getInt("CourseId")));
 vec.add(rs3.getString("CourseName").trim());
 vec.add(String.valueOf(rs3.getInt("CreaditHour")));
 vec.add(rs3.getString("Expr1").trim());
 vec.add(String.valueOf(rs3.getInt("Expr2")));
 vec.add(String.valueOf(rs3.getInt("Expr3")));
 model.addRow(vec);
 }
 j++;
 }
 } catch (Exception ce) {
 ce.getMessage();
 }
 jScrollPane2.getHorizontalScrollBar();
 jTable2.setGridColor(Color.blue);
 jTable2.setDragEnabled(true);
 jTable2.setSelectionForeground(Color.red);
 jTable2.setSelectionBackground(Color.green);

jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 jTable2.setRowSelectionAllowed(true);
 jTable2.setShowVerticalLines(true);
 }
 public void jButton1_actionPerformed(ActionEvent e) {
 getM();
 xuanKe();
 i++;
 if (i >= 2) {
	 jOptionPane1.showMessageDialog(this, "最多只允许选择两门课程！", "提示",JOptionPane.INFORMATION_MESSAGE, null);
		 return;
		 } else if (i == 1) {
		 if (CS[0] == CS[1]) {
		 jOptionPane1.showMessageDialog(this, "请选择不同的课程！", "提示",JOptionPane.INFORMATION_MESSAGE, null);
		 return;
		 } else {
		 xuanKe();
		 i++;
		 return;
		 }
		 } else {
		 xuanKe();
		 i++;
		 }
		 }
		}
		class Choose_jButton1_actionAdapter implements ActionListener {
		 private Choose adaptee;
		 Choose_jButton1_actionAdapter(Choose adaptee) {
		 this.adaptee = adaptee;
		 }
		 public void actionPerformed(ActionEvent e) {
		 adaptee.jButton1_actionPerformed(e);
		 }
		}

