package cn.lntu.t22.studentmanager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
public class KeChengAddFrame extends JFrame {
 JPanel contentPane;
 JLabel jLabel1 = new JLabel();
 int FS, spid, FC;
 JLabel jLabel3 = new JLabel();
 JLabel jLabel4 = new JLabel();
 String IS;
 JTextField jTextField2 = new JTextField();
 JTextField jTextField3 = new JTextField();
 JLabel jLabel5 = new JLabel();
 JButton jButton1 = new JButton();
 JButton jButton2 = new JButton();
 JOptionPane jOptionPane1 = new JOptionPane();
 JLabel jLabel6 = new JLabel();
 JComboBox jComboBox1 = new JComboBox();
 dbConn sta = new dbConn();
 JLabel jLabel2 = new JLabel();
 JComboBox jComboBox2 = new JComboBox();
 public KeChengAddFrame() {
 try {
 jbInit();
 } catch (Exception exception) {
 exception.printStackTrace();
 }
 }

 private void jbInit() throws Exception {
 contentPane = (JPanel) getContentPane();

 contentPane.setLayout(null);
 setSize(new Dimension(482, 300));
 setTitle("课程录入");
 jLabel1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
 jLabel1.setText("课 程 录 入");
 jLabel1.setBounds(new Rectangle(178, 17, 126, 25));
 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel3.setText("课程名称：");
 jLabel3.setBounds(new Rectangle(75, 67, 81, 21));
 jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel4.setText("学 分：");
 jLabel4.setBounds(new Rectangle(75, 187, 77, 21));
 jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jTextField2.setBorder(BorderFactory.createLoweredBevelBorder());
 jTextField2.setText("");
 jTextField2.setBounds(new Rectangle(190, 67, 184, 26));
 jTextField3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jTextField3.setBorder(BorderFactory.createLoweredBevelBorder());
 jTextField3.setText("");
 jTextField3.setBounds(new Rectangle(190, 187, 94, 26));
 jLabel5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel5.setForeground(Color.red);
 jLabel5.setText("学分");
 jLabel5.setBounds(new Rectangle(301, 187, 42, 24));
 jButton1.setBounds(new Rectangle(103, 240, 90, 29));
 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton1.setText("提 交");
 jButton1.addActionListener(new
KeChengAddFrame_jButton1_actionAdapter(this));
 jButton2.setBounds(new Rectangle(277, 240, 90, 29));
 jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton2.setText("退 出");
 jButton2.addActionListener(new 
KeChengAddFrame_jButton2_actionAdapter(this));
 jOptionPane1.setBounds(new Rectangle(75, 261, 262, 90));
 jOptionPane1.setLayout(null);
 jLabel6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel6.setText("所属专业：");
 jLabel6.setBounds(new Rectangle(75, 107, 82, 21));
 jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN,
16));
 jComboBox1.setBounds(new Rectangle(190, 107, 160, 25));
 jComboBox1.addActionListener(new
 KeChengAddFrame_jComboBox1_actionAdapter(this));
 jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel2.setText("任课教师：");
 jLabel2.setBounds(new Rectangle(75, 147, 81, 25));
 jComboBox2.setFont(new java.awt.Font("Dialog", Font.PLAIN,
16));
 jComboBox2.setBounds(new Rectangle(190, 147, 160, 25));
 contentPane.add(jLabel1);
 contentPane.add(jButton1);
 contentPane.add(jButton2);
 contentPane.add(jOptionPane1);
 contentPane.add(jTextField3);
 contentPane.add(jLabel5);
 contentPane.add(jLabel4);
 contentPane.add(jLabel3);
 contentPane.add(jTextField2);
 contentPane.add(jComboBox1);
 contentPane.add(jLabel6);
 contentPane.add(jLabel2);
 contentPane.add(jComboBox2);
 jComboBox1.addItem("请选择");
 try {
 ResultSet rs = sta.getRs("select * from Speciality");
 while (rs.next()) {
 String xibu = rs.getString("SpecialityName");

 jComboBox1.addItem(xibu);
 }
 rs.close();
 } catch (Exception ce) {
 System.out.println("++++++++" + ce);
 }
 jComboBox2.setEnabled(false);
 }
 public void FindS() {
 try {
 ResultSet rs = sta.getRs(
 "select * from Speciality where SpecialityName='" +
 String.valueOf(jComboBox1.getSelectedItem()) + "'");
 while (rs.next()) {
 FS = rs.getInt("SpecialityId");
 }
 rs.close();
 } catch (Exception ce) {
 System.out.println("FS" + ce);
 }
 }
 public void FindC() {
 try {
 ResultSet rs = sta.getRs(
 "select * from Course where CourseName='" +
 jTextField2.getText().trim() + "'");
 while (rs.next()) {
 FC = rs.getInt("CourseId");
 }
 sta.getUpdate(
 "insert into CourseSpeciality (CourseId,SpecialityId) values ('" +FC + "','" + FS + "')");
 } catch (Exception ce) {
 System.out.println("FC" + ce);
 }
 }
 public void InS() {
 try {
 ResultSet rs = sta.getRs(
 "select * from Teacher where RealName='" +
 String.valueOf(jComboBox2.getSelectedItem()) + "'");
 while (rs.next()) {
 IS = rs.getString("UserId");
 }
 rs.close();
 sta.getUpdate(
 "insert into CourseTeacher (CourseId,UserId) values('" +FC + "','" + IS + "')");
 } catch (Exception ce) {
 System.out.println("IS" + ce);
 }
 }
 public void InC() {
 if (jTextField2.getText().length() == 0) {
 jOptionPane1.showMessageDialog(this, "课程名称不能为空！", "提示",JOptionPane.INFORMATION_MESSAGE, null);
 } else if (jComboBox1.getSelectedIndex() == 0) {
 jOptionPane1.showMessageDialog(this, "请选择课程所属系部！", "提示",
 
JOptionPane.INFORMATION_MESSAGE, null);
 } else if (jTextField3.getText().length() == 0) {
 jOptionPane1.showMessageDialog(this, "课时名称不能为空！", "提示",JOptionPane.INFORMATION_MESSAGE, null);
 } else {
 try {
 boolean name = false;
 ResultSet rs = sta.getRs("select CourseName fromCourse");
 while (rs.next()) {
 if (jTextField2.getText().trim().equals(rs.getString(
 "CourseName").trim())){
 name = true;
 }
 }
 if (name) {
 jOptionPane1.showMessageDialog(this, "课程名称已经存在！", "提示",JOptionPane.
INFORMATION_MESSAGE, null);
 } else {
 sta.getUpdate("insert into Course(CourseName,CreaditHour) values ('" +jTextField2.getText().trim() + "','" +
 Integer.valueOf(jTextField3.getText().trim())
+
 "')");
 jOptionPane1.showMessageDialog(this, "课程信息提交成功！", "提示",
 JOptionPane.INFORMATION_MESSAGE,
null);

 }
 rs.close();
 } catch (Exception ce) {
 System.out.println("--------" + ce);
 }
 }
 }
 public void jButton1_actionPerformed(ActionEvent e) {
 InC();
 FindS();
 FindC();
 InS();
 }
 public void jButton2_actionPerformed(ActionEvent e) {
 this.dispose();
 }
 public void tchoose() {
 jComboBox2.removeAllItems();
 jComboBox2.setEnabled(true);
 jComboBox2.addItem("请选择");
 try {
 ResultSet rs = sta.getRs(
 "select * from st where SpecialityName='" +
 String.valueOf(jComboBox1.getSelectedItem()) + "'");
 while (rs.next()) {
 String xibu = rs.getString("RealName");
 jComboBox2.addItem(xibu);
 }
 rs.close();
 } catch (Exception ce) {
 System.out.println("++++++++" + ce);

 }
 }
 public void jComboBox1_actionPerformed(ActionEvent e) {
 tchoose();
 }
}
class KeChengAddFrame_jComboBox1_actionAdapter implements
ActionListener {
 private KeChengAddFrame adaptee;
 KeChengAddFrame_jComboBox1_actionAdapter(KeChengAddFrame
adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jComboBox1_actionPerformed(e);
 }
}
class KeChengAddFrame_jButton1_actionAdapter implements ActionListener
{
 private KeChengAddFrame adaptee;
 KeChengAddFrame_jButton1_actionAdapter(KeChengAddFrame adaptee)
{
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton1_actionPerformed(e);
 }

}
class KeChengAddFrame_jButton2_actionAdapter implements ActionListener
{
 private KeChengAddFrame adaptee;
 KeChengAddFrame_jButton2_actionAdapter(KeChengAddFrame adaptee)
{
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton2_actionPerformed(e);
 }
}



