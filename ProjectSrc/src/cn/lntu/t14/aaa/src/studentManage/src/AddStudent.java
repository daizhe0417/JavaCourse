package studentManage.src;

import java.awt.Color;
import java.awt.Font;
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

public class AddStudent extends JFrame implements ActionListener {
	JLabel JL= new JLabel("添加基本信息",JLabel.CENTER);
	JLabel JLNumber= new JLabel(new ImageIcon("学号"));
	JTextField JTNumber= new JTextField(); 
	JLabel JLName= new JLabel(new ImageIcon(""));
	JTextField JTName= new JTextField();
	JLabel JLClass = new JLabel(new ImageIcon(""));
	JTextField JTClass = new JTextField();
	JLabel JLsex= new JLabel(new ImageIcon(""));
	ButtonGroup BG = new ButtonGroup();
	JRadioButton JRB1= new JRadioButton("男");
	JRadioButton JRB2= new JRadioButton("女");
	JLabel JL1= new JLabel(new ImageIcon(""));
	JTextField JT1= new JTextField();
	JLabel JL2= new JLabel(new ImageIcon(""));
	JTextField JT2= new JTextField();
	JButton JBAdd=new JButton("添加");
	JButton JBNext= new JButton("取消");
	JButton JBExit=new JButton("退出");
	String sql="";
	public AddStudent()
	{
		this.setTitle("添加考试信息");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,19));
		JLabel sno = new JLabel("编号");
    	sno.setBounds(80,80,100,20);
    	this.add(sno);
    	JLabel name = new JLabel("姓名");
    	name.setBounds(80,120,100,20);
    	this.add(name);
    	JLabel cla = new JLabel("班级");
		cla.setBounds(80,200,100,20);
    	this.add(cla);
		JLabel pho = new JLabel("电话");
    	pho.setBounds(80,240,100,20);
    	this.add(pho);
    	JLabel bir = new JLabel("生日");
		bir.setBounds(80,280,100,20);
    	this.add(bir);
    	
		JL.setBounds(100,30,200,40);
		this.add(JL);
		JLNumber.setBounds(100,80,100,20);
		this.add(JLNumber);
		JTNumber.setBounds(200,80,80,20);
		this.add(JTNumber);
		
		JL2.setBounds(100,200,100,20);
		this.add(JL2);
		JT2.setBounds(200,200,80,20);
		this.add(JT2);
		
		JLName.setBounds(100,120,100,20);
		this.add(JLName);
		JTName.setBounds(200,120,80,20);
		this.add(JTName);
		JLsex.setBounds(100,160,100,20);
		this.add(JLsex);
		JRB1.setBounds(200,160,100,20);
		JRB2.setBounds(300,160,40,20);
		this.add(JRB1);
		this.add(JRB2);
		BG.add(JRB1);
		BG.add(JRB2);
		
    	pho.setBounds(80,240,100,20);
    	this.add(pho);
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
		JBAdd.setBounds(80,320,90,20);
		this.add(JBAdd);
		JBAdd.addActionListener(this);
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
	/*连接数据库*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBAdd)
		{
			String snumber=JTNumber.getText();
			String sname= JTName.getText();
			String sclass= JTClass.getText();
			String ssex="女";
			if(JRB1.isSelected())
				ssex="男";
			String scollect=JT1.getText();
			String sbir=JT2.getText();
			sql="select* from student where Id='" + snumber + "'";
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//连接数据库驱动
				Connection cot=DriverManager.getConnection("jdbc:odbc:student1","","");
				java.sql.Statement stm=cot.createStatement();//以字符串集合形式返回
				ResultSet rs= stm.executeQuery(sql);
				if(rs.next())//自动寻找
				{
					JOptionPane.showMessageDialog(null, "该号已经存在");}
					else {
						sql="insert into student values('"+snumber+"','"+sname+"','"+sclass+"','"+ssex+"','"+scollect+"','"+sbir+"')'";
						int i=stm.executeUpdate(sql);//接受到数据
						if(i>0)
							JOptionPane.showMessageDialog(null, "添加成功！");
						else 
							JOptionPane.showMessageDialog(null, "无结果!");
							
						
					}
				}
				
			 catch (Exception ee) {
				ee.printStackTrace();
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
			new AddStudent();
		}
		

	
		
 
}
