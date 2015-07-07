package cn.lntu.t22.studentmanager;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
public class MAPasswordFrameFrame extends JFrame {
 JPanel contentPane;
 String level;
 String name;
 JLabel jLabel1 = new JLabel();
 JLabel jLabel2 = new JLabel();
 JLabel jLabel3 = new JLabel();
 JLabel jLabel4 = new JLabel();
 JLabel jLabel5 = new JLabel();
 JTextField jTextField1 = new JTextField();
 JPasswordField jPasswordField1 = new JPasswordField();
 JPasswordField jPasswordField2 = new JPasswordField();
 JPasswordField jPasswordField3 = new JPasswordField();
 JButton jButton1 = new JButton();
 JButton jButton2 = new JButton();
 JOptionPane jOptionPane1 = new JOptionPane();
 public MAPasswordFrameFrame(String level,String name) {
 this.level=level;
 this.name=name;
 try {
 jbInit();
 } catch (Exception exception) {
 exception.printStackTrace();
 }
 }

 private void jbInit() throws Exception {
 contentPane = (JPanel) getContentPane();
 contentPane.setLayout(null);
 setSize(new Dimension(444, 340));
 setTitle("用户密码修改");
 jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
 jLabel1.setText("用 户 密 码 修 改");
 jLabel1.setBounds(new Rectangle(112, 15, 204, 24));
 jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel2.setText("用户名:");
 jLabel2.setBounds(new Rectangle(80, 72, 74, 23));
 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel3.setText("旧密码:");
 jLabel3.setBounds(new Rectangle(80, 115, 74, 23));
 jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel4.setText("新密码:");
 jLabel4.setBounds(new Rectangle(80, 159, 74, 23));
 jLabel5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel5.setText("确认新密码:");
 jLabel5.setBounds(new Rectangle(72, 203, 101, 23));
 jTextField1.setEnabled(false);
 jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
 jTextField1.setBounds(new Rectangle(175, 72, 159, 23));

jPasswordField1.setBorder(BorderFactory.createLoweredBevelBorder());
 jPasswordField1.setBounds(new Rectangle(175, 114, 160, 25));

jPasswordField2.setBorder(BorderFactory.createLoweredBevelBorder());
 jPasswordField2.setText("");
 jPasswordField2.setBounds(new Rectangle(175, 158, 160, 25));

jPasswordField3.setBorder(BorderFactory.createLoweredBevelBorder());
 jPasswordField3.setText("");
 jPasswordField3.setBounds(new Rectangle(175, 202, 160, 25));
 jButton1.setBounds(new Rectangle(87, 254, 86, 26));
 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton1.setText("提 交");
 jButton1.addActionListener(new

MAPasswordFrameFrame_jButton1_actionAdapter(this));
 jButton2.setBounds(new Rectangle(253, 254, 86, 26));

 jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton2.setText("退 出");
 jButton2.addActionListener(new

MAPasswordFrameFrame_jButton2_actionAdapter(this));
 jOptionPane1.setBounds(new Rectangle( -8, 84, 262, 90));
 jOptionPane1.setLayout(null);
 contentPane.add(jLabel1);
 contentPane.add(jLabel2);
 contentPane.add(jLabel3);
 contentPane.add(jLabel4);
 contentPane.add(jLabel5);
 contentPane.add(jPasswordField3);
 contentPane.add(jPasswordField1);
 contentPane.add(jPasswordField2);
 contentPane.add(jButton2);
 contentPane.add(jButton1);
 contentPane.add(jTextField1);
 contentPane.add(jOptionPane1);
 this.jTextField1.setText(name);
 if(level.equals("2")){
 jTextField1.setEnabled(true);
 }
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
 boolean a=false;
 boolean b=true;

if(jTextField1.getText().trim()==null||jTextField1.getText().trim().length()==0||
jTextField1.getText().trim().length()>20)
 { jOptionPane1.showMessageDialog(this,"用户名不能为空且最大长度为 20 个字符！ "," 提 示",JOptionPane.INFORMATION_MESSAGE,null);
 }else
if(jPasswordField2.getText().trim().compareTo(jPasswordField3.getText().trim(
))!=0){
 jOptionPane1.showMessageDialog(this," 新密码确认错误！","提 示",JOptionPane.INFORMATION_MESSAGE,null);
 }else{
 try{
 String url = "jdbc:odbc:test";
 Connection con = DriverManager.getConnection(url);
 Statement s = con.createStatement();
 ResultSet rs=s.executeQuery("select UserId,UserPwd fromUser1");
 while(rs.next()){

if(jTextField1.getText().trim().equals(rs.getString(1).trim())&&jPasswordField1.getText().trim().equals(rs.getString(2).trim())){
 a=true;
 b=false;
 break;
 }
 }
 if(b){
 jOptionPane1.showMessageDialog(this," 用 户 名 或 密码错误！","提示",JOptionPane.INFORMATION_MESSAGE,null);
 }
 if(a){
 s.executeUpdate("update User1 set UserPwd='"+jPasswordField2.getText().trim()+"' where UserId=('"+jTextField1.getText().trim()+"') " );
 jOptionPane1.showMessageDialog(this, "恭喜您修改成功！", "提示",JOptionPane.INFORMATION_MESSAGE, null);
 jTextField1.setText("");
 jPasswordField1.setText("");
 jPasswordField2.setText("");
 jPasswordField3.setText("");
 }
 rs.close();
 s.close();
 con.close();
 }catch(java.sql.SQLException ce){
 System.out.println(ce);
 }
 }
 }
}
class MAPasswordFrameFrame_jButton1_actionAdapter implements
ActionListener {
 private MAPasswordFrameFrame adaptee;

MAPasswordFrameFrame_jButton1_actionAdapter(MAPasswordFrameFrame
adaptee) {
 this.adaptee = adaptee;
 }

 public void actionPerformed(ActionEvent e) {
 adaptee.jButton1_actionPerformed(e);
 }
}
class MAPasswordFrameFrame_jButton2_actionAdapter implements
ActionListener {
 private MAPasswordFrameFrame adaptee;

MAPasswordFrameFrame_jButton2_actionAdapter(MAPasswordFrameFrame
adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton2_actionPerformed(e);
 }
}
