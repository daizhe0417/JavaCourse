package cn.lntu.t22.studentmanager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
public class AddAdminFrame extends JFrame {
 JPanel contentPane;
 String level;
 JLabel jLabel1 = new JLabel();
 JLabel jLabel2 = new JLabel();
 JLabel jLabel3 = new JLabel();
 JLabel jLabel4 = new JLabel();
 JTextField jTextField1 = new JTextField();
 JPasswordField jPasswordField1 = new JPasswordField();
 JPasswordField jPasswordField2 = new JPasswordField();
 JButton jButton1 = new JButton();
 JButton jButton2 = new JButton();
 JOptionPane jOptionPane1 = new JOptionPane();
 public AddAdminFrame() {
 try {
 jbInit();
 } catch (Exception exception) {
 exception.printStackTrace();
 }
 }

 private void jbInit() throws Exception {
 contentPane = (JPanel) getContentPane();
 contentPane.setLayout(null);
 setSize(new Dimension(469, 315));
 setTitle("管理员添加");
 jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 23));
 jLabel1.setText("管 理 员 添 加");
 jLabel1.setBounds(new Rectangle(134, 12, 198, 27));
 jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel2.setText("用户名:");
 jLabel2.setBounds(new Rectangle(90, 66, 68, 22));

 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel3.setText("密 码:");
 jLabel3.setBounds(new Rectangle(90, 118, 75, 27));
 jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel4.setText("确认密码:");
 jLabel4.setBounds(new Rectangle(84, 167, 89, 29));
 jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
 jTextField1.setBounds(new Rectangle(191, 65, 155, 24));

jPasswordField1.setBorder(BorderFactory.createLoweredBevelBorder());
 jPasswordField1.setBounds(new Rectangle(191, 119, 155, 24));

jPasswordField2.setBorder(BorderFactory.createLoweredBevelBorder());
 jPasswordField2.setText("");
 jPasswordField2.setBounds(new Rectangle(191, 169, 155, 24));
 jButton1.setBounds(new Rectangle(99, 225, 89, 25));
 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton1.setText("提 交");
 jButton1.addActionListener(new
AddAdminFrame_jButton1_actionAdapter(this));
 jButton2.setBounds(new Rectangle(267, 225, 89, 25));
 jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton2.setText("退 出");
 jButton2.addActionListener(new
AddAdminFrame_jButton2_actionAdapter(this));
 jOptionPane1.setBounds(new Rectangle(0, 233, 262, 90));
 jOptionPane1.setLayout(null);
 contentPane.add(jLabel2);
 contentPane.add(jLabel3);
 contentPane.add(jLabel4);
 contentPane.add(jTextField1);
 contentPane.add(jPasswordField2);

 contentPane.add(jPasswordField1);
 contentPane.add(jButton1);
 contentPane.add(jButton2);
 contentPane.add(jLabel1);
 contentPane.add(jOptionPane1);
 }
 public void jButton2_actionPerformed(ActionEvent e) {
 this.dispose();
 }
 public void jButton1_actionPerformed(ActionEvent e) {
 try{
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 }catch(Exception ce){
 System.out.println(ce);
 }
 boolean zhi=false;
 if(jTextField1.getText().length()==0){
 jOptionPane1.showMessageDialog(this,"用户名不能为空！","提示",JOptionPane.INFORMATION_MESSAGE,null);
 }else
if(jPasswordField2.getText().trim().equals(jPasswordField1.getText().trim())){
 zhi=true;
}else{
 jOptionPane1.showMessageDialog(this,"密码确认错误！","提示",
JOptionPane.INFORMATION_MESSAGE,null);
}
if(zhi){
 try{
 boolean name=false;
 String url = "jdbc:odbc:test";
 Connection con = DriverManager.getConnection(url);

 Statement s = con.createStatement();
 ResultSet rs = s.executeQuery("select UserId from User1");
 while(rs.next()){

if(jTextField1.getText().trim().equals(rs.getString(1).trim())){
 name=true;
 }
 }
 if(name){
 jOptionPane1.showMessageDialog(this,"该用户名已经存在！","提示",JOptionPane.INFORMATION_MESSAGE,null);
 }else{
 s.executeUpdate("insert into User1(UserId,UserPwd,UserType) values('"+jTextField1.getText().trim()+"','"+jPasswordField2.getText().trim()+"','2')");
 jOptionPane1.showMessageDialog(this,"恭喜您管理员注册成功！","提示",JOptionPane.INFORMATION_MESSAGE,null);
 }
 rs.close();
 s.close();
 con.close();
 }catch(Exception ce){
 System.out.println(ce);
 }
 }
 }
}
class AddAdminFrame_jButton1_actionAdapter implements ActionListener {
 private AddAdminFrame adaptee;
 AddAdminFrame_jButton1_actionAdapter(AddAdminFrame adaptee) {
 this.adaptee = adaptee;
 }

 public void actionPerformed(ActionEvent e) {
 adaptee.jButton1_actionPerformed(e);
 }
}
class AddAdminFrame_jButton2_actionAdapter implements ActionListener {
 private AddAdminFrame adaptee;
 AddAdminFrame_jButton2_actionAdapter(AddAdminFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton2_actionPerformed(e);
 }
}



