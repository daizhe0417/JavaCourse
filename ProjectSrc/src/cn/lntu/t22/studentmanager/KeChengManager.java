package cn.lntu.t22.studentmanager;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
public class KeChengManager extends JFrame {

 XYLayout xYLayout1 = new XYLayout();
 JLabel jLabel1 = new JLabel();
 JLabel jLabel2 = new JLabel();
 JLabel jLabel3 = new JLabel();
 JLabel jLabel4 = new JLabel();
 JLabel jLabel5 = new JLabel();
 JTextField jTextField1 = new JTextField();
 JComboBox jComboBox1 = new JComboBox();
 JComboBox jComboBox2 = new JComboBox();
 JTextField jTextField2 = new JTextField();
 JButton jButton1 = new JButton();
 JButton jButton3 = new JButton();
 dbConn sta = new dbConn();
 JOptionPane jOptionPane1 = new JOptionPane();
 String kefind;
 int csid;
 public KeChengManager(String find) {
 kefind=find;
 try {
 jbInit();
 } catch (Exception exception) {
 exception.printStackTrace();
 }
 }
 private void jbInit() throws Exception {
 getContentPane().setLayout(xYLayout1);
 xYLayout1.setWidth(500);
 xYLayout1.setHeight(350);
 jLabel1.setFont(new java.awt.Font("新宋体", Font.BOLD, 20));
 jLabel1.setText("课 程 修 改 ");
 jButton3.addActionListener(new
KeChengManager_jButton3_actionAdapter(this));

 jButton1.addActionListener(new
KeChengManager_jButton1_actionAdapter(this));
 jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jComboBox2.setFont(new java.awt.Font("Dialog", Font.PLAIN,
16));
 jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN,
16));
 jComboBox1.addActionListener(new

KeChengManager_jComboBox1_actionAdapter(this));
 jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton3.setText("退 出");
 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton1.setText("修 改");
 jLabel5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel5.setText("学 分：");
 jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel4.setText("任课教师：");
 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel3.setText("所属专业：");
 this.getContentPane().add(jComboBox1,
 new XYConstraints(200, 130, 140,
30));
 this.getContentPane().add(jComboBox2,
 new XYConstraints(200, 180,140,30));
 this.getContentPane().add(jTextField2,
 new XYConstraints(200, 230, 140,30));
 this.getContentPane().add(jLabel2, new XYConstraints(85, 80, 80,30));
 this.getContentPane().add(jLabel5, new XYConstraints(85, 230, 80,30));
 this.getContentPane().add(jLabel4, new XYConstraints(85, 180, 80, 30));
 this.getContentPane().add(jLabel3, new XYConstraints(85, 130, 80,30));
 this.getContentPane().add(jTextField1,
 new XYConstraints(200, 80, 140,30));
 this.getContentPane().add(jLabel1, new XYConstraints(158, 21, -1,49));
 this.getContentPane().add(jButton1, new XYConstraints(130, 290, 90,30));
 this.getContentPane().add(jButton3, new XYConstraints(295, 290, 90,30));
 jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel2.setText("课程名称：");
 this.setTitle("课程修改与删除");
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
 setF();
 }
 public void setF(){
 if(kefind==null)
 return;
 else{

 jComboBox2.setEnabled(true);
 try {
 ResultSet rs = sta.getRs("select * from CourseS whereCourseSpecialityID='"+Integer.valueOf(kefind)+"'");
 while (rs.next()) {
 csid=rs.getInt(1);

jComboBox1.setSelectedItem(String.valueOf(rs.getString(3)));
 jTextField1.setText(rs.getString(4).trim());
jComboBox2.setSelectedItem(String.valueOf(rs.getString(5)));
 jTextField2.setText(rs.getString(6).trim());
 }
 rs.close();
 } catch (Exception ce) {
 System.out.println("++++++++" + ce);
 }}
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
 public void jButton3_actionPerformed(ActionEvent e) {
 this.dispose();
 }
 public void jButton1_actionPerformed(ActionEvent e) {
 String keCName,zyName,tName,xueFen;
 keCName=jTextField1.getText().trim();
 zyName=String.valueOf(jComboBox1.getSelectedItem());
 tName=String.valueOf(jComboBox2.getSelectedItem());
 xueFen=jTextField2.getText().trim();
 try{
 sta.getUpdate("update CourseS set SpecialityName='"+zyName+"',CourseName='"+keCName+"',RealName='"+tName+"',CreaditHour='"+Integer
.valueOf(xueFen)+"' where CourseSpecialityID='"+csid+"'");
 jOptionPane1.showMessageDialog(this,"课程修改成功！","提示",JOptionPane.INFORMATION_MESSAGE,null);
 }catch(Exception a){
 System.out.println(a.getMessage());
 }
 }
 public void jComboBox1_actionPerformed(ActionEvent e) {
 tchoose();
 }
}
class KeChengManager_jComboBox1_actionAdapter implements 

ActionListener {
 private KeChengManager adaptee;
 KeChengManager_jComboBox1_actionAdapter(KeChengManager
adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jComboBox1_actionPerformed(e);
 }
}
class KeChengManager_jButton1_actionAdapter implements ActionListener {
 private KeChengManager adaptee;
 KeChengManager_jButton1_actionAdapter(KeChengManager adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton1_actionPerformed(e);
 }
}
class KeChengManager_jButton3_actionAdapter implements ActionListener {
 private KeChengManager adaptee;
 KeChengManager_jButton3_actionAdapter(KeChengManager adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton3_actionPerformed(e);
 }
}



