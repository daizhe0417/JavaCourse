package cn.lntu.t12;

import java.awt.Color;
import java.awt.Font;
import java.awt.ImageCapabilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.*;

 class GetTeacher extends JFrame implements ActionListener {
	 JLabel JL= new JLabel("教师基本信息",JLabel.CENTER);
	 JLabel JLNumber= new JLabel("教师编号");
	 JTextField JTNumber= new JTextField();
	 JLabel JLName= new JLabel("姓名");
	 JTextField JTName= new JTextField();
	 JLabel JLClass= new JLabel("职称");
	 JTextField JTClass= new JTextField();
	 JLabel JLSex= new JLabel("性别");
	 ButtonGroup BG= new ButtonGroup();
	 JRadioButton JRB1= new JRadioButton("男");
	 JRadioButton JRB2= new JRadioButton("女");
	 JLabel JL1= new JLabel("学院");
	 JTextField JT1= new JTextField();
	 JLabel JL2= new JLabel("生日");
	 JTextField JT2= new JTextField();
	 JButton JBGet= new JButton("修改");
	 JButton JBNext= new JButton("取消");
	 JButton JBExit= new JButton("退出");
	 String sql="";
	 public GetTeacher()
	 {
		 this.setTitle("修改教师信息");
		 this.setLayout(null);
		 JL.setForeground(Color.blue);
		 JL.setFont(new  java.awt.Font("宋体",Font.PLAIN,19));
		 JL.setBounds(100,30,200,40);
		 this.add(JL);
		 JLNumber.setBounds(100,80,100,20);
		 this.add(JLNumber);
		 JTNumber.setBounds(200,80,80,20);
		 this.add(JTNumber);
		 JLName.setBounds(100,120,100,20);
		 this.add(JLName);
		 JTName.setBounds(200,120,80,20);
		 this.add(JTName);
		 JLSex.setBounds(100,160,40,20);
		 this.add(JLSex);
		 JRB1.setBounds(200,160,40,20);
		 JRB2.setBounds(300,160,40,20);
		 this.add(JRB1);
		 this.add(JRB2);
		 BG.add(JRB1);
		 BG.add(JRB2);
		 JL2.setBounds(100,200,100,20);
		 this.add(JL2);
		 JT2.setBounds(200,200,80,20);
		 this.add(JT2);
		 JLClass.setBounds(100,240,100,20);
		 this.add(JLClass);
		 JTClass.setBounds(200,240,80,20);
		 this.add(JTClass);
		 JL1.setBounds(100,280,100,20);
		 this.add(JL1);
		 JT1.setBounds(200,280,80,20);
		 this.add(JT1);
		 JBGet.setBounds(80,320,90,20);
		 this.add(JBGet);
		 JBGet.addActionListener(this);
		 JBNext.setBounds(190,320,90,20);
		 this.add(JBNext);
		 JBNext.addActionListener(this);
		 JBExit.setBounds(300,320,90,20);
		 this.add(JBExit);
		 JBExit.addActionListener(this);
		 this.setBounds(10,10,500,400);
		 this.setVisible(true);
		 addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e)
			 {
				 System.exit(0);
			 }
		});
		 
		 
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource()==JBGet)
		 {
			 String snumber= JTNumber.getText();
			 String sname= JTName.getText();
			 String sclass= JTClass.getText();
			 String ssex="女",sql;
			 if(JRB1.isSelected())
				 ssex="男";
			 String scollect= JT1.getText();
			 String sbir= JT2.getText();
			 sql="select*from student where Id='"+snumber+"'";
			 try {
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection cot= DriverManager.getConnection("jdbc:odbc:student1","","");
				 Statement stm= (Statement) cot.createStatement();
				 ResultSet rs=((java.sql.Statement) stm).executeQuery(sql);
				 if(rs.next())
				 {
					 sql="update student set name='"+sname+"',suppport='"
							 +sclass+"',sex='"+ssex+"',collect='"
							 +scollect+ "',bir='" +sbir+"'where Id="
							 		+ snumber+"'";
					 int n=((java.sql.Statement) stm).executeUpdate(sql);
					 if(n>0)
						 JOptionPane.showMessageDialog(null, "修改成功");
					 else 
						JOptionPane.showMessageDialog(null, "修改失败");
				 }else
				 {
					 JOptionPane.showMessageDialog(null,"此用户不存在");
				 }
				 
			} catch (Exception er) {
				// TODO: handle exception
				
			}
		 }
		 if(e.getSource()==JBNext)
		 {
			 JTNumber.setText(null);
			 JTName.setText(null);
			 JTClass.setText(null);
			 JT1.setText(null);
			 JT2.setText(null);
			 
		 }
		 if(e.getSource()==JBExit)
		 {
			 setVisible(false);
		 }
	 }
	 public static void main(String args[])
	 {
		 new GetTeacher();
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}

