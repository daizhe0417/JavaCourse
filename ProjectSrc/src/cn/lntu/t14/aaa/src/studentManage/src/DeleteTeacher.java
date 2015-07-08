
package studentManage.src;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

 class DeleteTeacher extends JFrame implements ActionListener {
	 JLabel JL= new JLabel("教师基本信息",JLabel.CENTER);
	 JLabel JLNumber= new JLabel(new ImageIcon());
	 JTextField JTNumber= new JTextField();
	 JLabel JLName= new JLabel(new ImageIcon());
	 JTextField JTName= new JTextField();
	 JButton JBDel= new JButton("删除");
	 JButton JBNext= new JButton("取消");
	 JButton JBExit= new JButton("退出");
	 String sql="";
	 public DeleteTeacher()
	 {
		 this.setTitle("删除教师信息");
		 this.setLayout(null);
		 JL.setForeground(Color.blue);
		 JL.setFont(new java.awt.Font("宋体",Font.PLAIN,19));
		 JL.setBounds(100,30,200,40);
		 this.add(JL);
		 JLNumber.setBounds(100,120,100,20);
		 this.add(JLNumber);
		 JTNumber.setBounds(200,120,80,20);
		 this.add(JTNumber);
		 JLName.setBounds(100,160,100,20);
		 this.add(JLName);
		 JTName.setBounds(200,160,80,20);
		 this.add(JTName);
		 JBDel.setBounds(80,320,90,20);
		 this.add(JBDel);
		 JBDel.addActionListener(this);
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
		if(e.getSource()==JBDel)
		{
			String snumber=JTNumber.getText();
			String sname=JTNumber.getText();
			sql="select*from teacher where Id='"+snumber+"'";
			try {
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection cot= DriverManager.getConnection("jdbc:odbc:student1","","");
				 Statement stm= (Statement) cot.createStatement();
				 ResultSet rs=((java.sql.Statement) stm).executeQuery(sql);
				 if(rs.next())
				 {
					 sql="delete*from student where Id='"+snumber+"'";
					 int n=((java.sql.Statement) stm).executeUpdate(sql);
					 if(n>0)
						 JOptionPane.showMessageDialog(null, "删除成功");
					 else 
						JOptionPane.showMessageDialog(null, "删除失败");
				 }else
				 {
					 JOptionPane.showMessageDialog(null,"此用户不存在");
				 }
				 
			}
			
				catch (Exception er) {
				// TODO: handle exception
			}
		}
		if(e.getSource()==JBNext)
		{
			JTNumber.setText(null);
			JTName.setText(null);
		}
		if(e.getSource()==JBExit)
		{
			setVisible(false);
		}
		 }
		 public static void  main(String args[]) {
			new DeleteTeacher();
		}
		 
		 
		 
	 }
