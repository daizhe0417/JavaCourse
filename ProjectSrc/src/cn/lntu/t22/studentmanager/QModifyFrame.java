package cn.lntu.t22.studentmanager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
public class QModifyFrame extends JFrame {
 JPanel contentPane;
 int request=0;
 JLabel jLabel1 = new JLabel();
 JLabel jLabel2 = new JLabel();
 JLabel jLabel3 = new JLabel();
 JLabel jLabel4 = new JLabel();
 JTextField jTextField1 = new JTextField();
 JTextField jTextField2 = new JTextField();
 JComboBox jComboBox1 = new JComboBox();
 JButton jButton1 = new JButton();
 JButton jButton2 = new JButton();
 JOptionPane jOptionPane1 = new JOptionPane();
 public QModifyFrame() {
 try {
 jbInit();
 } catch (Exception exception) {
 exception.printStackTrace();
 }
 }

 private void jbInit() throws Exception {
 contentPane = (JPanel) getContentPane();
 contentPane.setLayout(null);
 setSize(new Dimension(434, 314));
 setTitle("权限管理");
 jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
 jLabel1.setText("权 限 修 改");
 jLabel1.setBounds(new Rectangle(145, 18, 135, 25));
 jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel2.setText("用户名:");

 jLabel2.setBounds(new Rectangle(79, 78, 70, 21));
 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel3.setText("当前权限:");
 jLabel3.setBounds(new Rectangle(73, 120, 83, 25));
 jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel4.setText("设置权限:");
 jLabel4.setBounds(new Rectangle(73, 169, 88, 23));
 jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
 jTextField1.setBounds(new Rectangle(173, 76, 148, 25));
 jTextField1.addFocusListener(new
QModifyFrame_jTextField1_focusAdapter(this));
 jTextField2.setEnabled(false);
 jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jTextField2.setForeground(Color.red);
 jTextField2.setBorder(BorderFactory.createLoweredBevelBorder());
 jTextField2.setBounds(new Rectangle(173, 120, 149, 24));
 jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN,
13));

jComboBox1.setBorder(BorderFactory.createLoweredBevelBorder());
 jComboBox1.setBounds(new Rectangle(173, 169, 111, 23));
 jButton1.setBounds(new Rectangle(110, 224, 84, 25));
 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton1.setText("提 交");
 jButton1.addActionListener(new
QModifyFrame_jButton1_actionAdapter(this));
 jButton2.setBounds(new Rectangle(245, 224, 84, 25));
 jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton2.setText("退 出");
 jButton2.addActionListener(new
QModifyFrame_jButton2_actionAdapter(this));
 jOptionPane1.setBounds(new Rectangle(5, 239, 262, 90));

 jOptionPane1.setLayout(null);
 contentPane.add(jLabel1);
 contentPane.add(jLabel2);
 contentPane.add(jLabel3);
 contentPane.add(jLabel4);
 contentPane.add(jTextField1);
 contentPane.add(jTextField2);
 contentPane.add(jComboBox1);
 contentPane.add(jButton2);
 contentPane.add(jButton1);
 contentPane.add(jOptionPane1);
 this.jComboBox1.addItem("管理员");
 this.jComboBox1.addItem("普通教师");
 this.jComboBox1.addItem("学生");
 }
 public void jButton2_actionPerformed(ActionEvent e) {
 this.dispose();
 }
 public void jTextField1_focusLost(FocusEvent e) {
 try{
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 }catch(Exception ce){
 System.out.println(ce);
 }
 try{
 boolean a=false;
 boolean b=true;
 String level=null;
 String url = "jdbc:odbc:test";
 Connection con = DriverManager.getConnection(url);
 Statement s = con.createStatement();
 ResultSet rs=s.executeQuery("select UserId,UserType fromUser1");
 while(rs.next()){


if(jTextField1.getText().trim().equals(rs.getString(1).trim())){
 level=rs.getString(2).toString().trim();
 a=true;
 b=false;
 break;
 }
 }
 if(b&&!this.jTextField1.getText().trim().equals("")){
 jOptionPane1.showMessageDialog(this," 用 户 名 输 入错误！","提示",JOptionPane.INFORMATION_MESSAGE,null);
 }
 if(a){
 request=1;
 if(level.equals("0")){
 this.jTextField2.setText("学生");
 }
 if(level.equals("1")){
 this.jTextField2.setText("普通教师");
 }
 if(level.equals("2")){
 this.jTextField2.setText("管理员");
 }
 }
 rs.close();
 s.close();
 con.close();
 }catch(java.sql.SQLException ce){
 System.out.println(ce);
 }
 }
 public void jButton1_actionPerformed(ActionEvent e) {
 if(request==1){

 try{
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 }catch(Exception ce){
 System.out.println(ce);
 }
 try{
 String url = "jdbc:odbc:test";
 Connection con = DriverManager.getConnection(url);
 Statement s = con.createStatement();
 if(this.jComboBox1.getSelectedItem().equals("学生")){
 request=0;
 }
 if(this.jComboBox1.getSelectedItem().equals("普通教师")){
 request=1;
 }
 if(this.jComboBox1.getSelectedItem().equals("管理员")){
 request=2;
 }
 s.executeUpdate("update User1 set UserType='"+request+"'whereUserId=('"+jTextField1.getText().trim()+"') " );
 jOptionPane1.showMessageDialog(this,"权限修改成功！","提示",JOptionPane.INFORMATION_MESSAGE,null);
 }catch(Exception a){
 }
 }else{
 jOptionPane1.showMessageDialog(this," 请输入正确的用户名！","提示",JOptionPane.INFORMATION_MESSAGE,null);
 }
 }
}
class QModifyFrame_jButton1_actionAdapter implements ActionListener {

 private QModifyFrame adaptee;
 QModifyFrame_jButton1_actionAdapter(QModifyFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton1_actionPerformed(e);
 }
}
class QModifyFrame_jTextField1_focusAdapter extends FocusAdapter {
 private QModifyFrame adaptee;
 QModifyFrame_jTextField1_focusAdapter(QModifyFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void focusLost(FocusEvent e) {
 adaptee.jTextField1_focusLost(e);
 }
}
class QModifyFrame_jButton2_actionAdapter implements ActionListener {
 private QModifyFrame adaptee;
 QModifyFrame_jButton2_actionAdapter(QModifyFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton2_actionPerformed(e);
 }
}


