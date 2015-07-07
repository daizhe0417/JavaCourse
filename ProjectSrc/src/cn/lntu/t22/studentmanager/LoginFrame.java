package cn.lntu.t22.studentmanager;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class LoginFrame extends JFrame {
 JPanel contentPane;
 ImageIcon snow=new ImageIcon("src/image/2.jpg");
 JLabel jLabel1 = new JLabel();
 JLabel jLabel2 = new JLabel();
 JLabel jLabel3 = new JLabel();
 JLabel jLabel4 = new JLabel();
 JLabel jLabel5 = new JLabel();
 JTextField jTextField1 = new JTextField();
 JButton jButton1 = new JButton();
 JButton jButton2 = new JButton();
 JLabel jLabel6 = new JLabel();
 JLabel jLabel7 = new JLabel();
 JOptionPane jOptionPane1 = new JOptionPane();
 JPasswordField jPasswordField1 = new JPasswordField();
 JPanel jPanel1 = new JPanel();
 JLabel jLabel8 = new JLabel();
 CardLayout cardLayout1 = new CardLayout();
 static String level,name;
 public LoginFrame() {
 try {
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 jbInit();
 } catch (Exception exception) {
 exception.printStackTrace();
 }
 }
 private void jbInit() throws Exception {
 contentPane = (JPanel) getContentPane();
 contentPane.setLayout(null);
 setSize(new Dimension(504, 344));
 setTitle("欢迎登陆学生管理系统");
 jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 25));
 jLabel1.setToolTipText("");

 jLabel1.setText("欢 迎 登 陆 学 生");
 jLabel1.setBounds(new Rectangle(128, 19, 246, 30));
 jLabel2.setFont(new java.awt.Font("Dialog", Font.BOLD, 25));
 jLabel2.setToolTipText("");
 jLabel2.setText("管 理 系 统");
 jLabel2.setBounds(new Rectangle(173, 61, 164, 29));
 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel3.setText("用户名:");
 jLabel3.setBounds(new Rectangle(95, 123, 77, 25));
 jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jLabel4.setText("密 码:");
 jLabel4.setBounds(new Rectangle(95, 172, 74, 21));
 jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
 jTextField1.setText("");
 jTextField1.setBounds(new Rectangle(188, 122, 212, 27));
 jButton1.setBounds(new Rectangle(124, 243, 93, 30));
 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton1.setText("登 陆");
 jButton1.addActionListener(new
LoginFrame_jButton1_actionAdapter(this));
 jButton2.setBounds(new Rectangle(286, 243, 93, 30));
 jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
 jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
 jButton2.setText("退 出");
 jButton2.addActionListener(new
LoginFrame_jButton2_actionAdapter(this));
 jLabel6.setFont(new java.awt.Font("Dialog", Font.BOLD, 25));
 jLabel6.setForeground(Color.blue);
 
 jLabel6.setToolTipText("");
 jLabel6.setText("管 理 系 统");
 jLabel6.setBounds(new Rectangle(173, 62, 164, 29));
 jLabel7.setFont(new java.awt.Font("Dialog", Font.BOLD, 25));
 jLabel7.setForeground(Color.blue);
 jLabel7.setToolTipText("");
 jLabel7.setText("欢 迎 登 陆 学 生");
 jLabel7.setBounds(new Rectangle(128, 20, 246, 30));
 jOptionPane1.setBounds(new Rectangle(28, 263, 262, 90));
 jOptionPane1.setLayout(null);

jPasswordField1.setBorder(BorderFactory.createLoweredBevelBorder());
 jPasswordField1.setBounds(new Rectangle(187, 168, 213, 26));
 jPanel1.setBounds(new Rectangle( -15, 0, 529, 375));
 jPanel1.setLayout(cardLayout1);
 jLabel8.setIcon(snow);
 contentPane.add(jTextField1);
 contentPane.add(jLabel3);
 contentPane.add(jLabel4);
 contentPane.add(jLabel5);
 contentPane.add(jButton1);
 contentPane.add(jButton2);
 contentPane.add(jLabel1);
 contentPane.add(jLabel2);
 contentPane.add(jLabel7);
 contentPane.add(jLabel6);
 contentPane.add(jPasswordField1);
 contentPane.add(jPanel1);
 jPanel1.add(jLabel8, "jLabel8");
 contentPane.add(jOptionPane1);
 }
 public void jButton2_actionPerformed(ActionEvent e) {
 System.exit(0);
 }

 public void jButton1_actionPerformed(ActionEvent e) {
 boolean deng=false;
 boolean cheng=false;
 
 if(jTextField1.getText().length()==0)
 {
 jOptionPane1.showMessageDialog(this,"用户名不能为空！","提 示",jOptionPane1.INFORMATION_MESSAGE);
 }else{
 deng=true;
 }
 
 if(deng){
	 
 try{
	 
 Class.forName("com.mysql.jdbc.Driver");
 }catch(Exception ce){
 System.out.println(ce);

 }
 try{
 String url = "jdbc:mysql://localhost/lxc";
 String user = "root";
 String password = "230276";
 Connection con = null;
 
 con =DriverManager.getConnection(url, user, password);
 
 Statement sta = con.createStatement();
 ResultSet rs=sta.executeQuery("select * from User1");
 while(rs.next()){
 if (rs.getString(1).trim().equals(jTextField1.getText())&&rs.getString(2).trim().equals(this.jPasswordField1.getText())){
 jOptionPane1.showMessageDialog(this,"恭喜你登陆成功！","提示",jOptionPane1.INFORMATION_MESSAGE);
 level=rs.getString("adminType").trim();
 name=jTextField1.getText().trim() ;
 MainFrame main=new MainFrame(level,jTextField1.getText());

 main.setLocation(200,40);
 main.setSize(911, 698);
 main.setVisible( true );
 main.setResizable( false );
 main.validate();
 this.dispose();
 cheng=false;
 break;
 }else{
 cheng=true;
 }
 }
 if(cheng){
 jOptionPane1.showMessageDialog(this,"用户名或密码错误！","提示",jOptionPane1.INFORMATION_MESSAGE);
 }
 rs.close();
 sta.close();
 con.close();
 }catch(Exception ce){
 System.out.println(ce);
 }
 }
 }
}
class LoginFrame_jButton1_actionAdapter implements ActionListener {
 private LoginFrame adaptee;
 LoginFrame_jButton1_actionAdapter(LoginFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton1_actionPerformed(e);

 }
}
class LoginFrame_jButton2_actionAdapter implements ActionListener {
 private LoginFrame adaptee;
 LoginFrame_jButton2_actionAdapter(LoginFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton2_actionPerformed(e);
 }
}


