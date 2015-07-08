package studentManage.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class SetGrade extends JFrame implements ActionListener {
	JLabel JL= new JLabel("查询成绩",JLabel.CENTER);
	JLabel JLNumber= new JLabel(new ImageIcon());
	JTextField JTNumber= new JTextField();
	JLabel JLName= new JLabel(new ImageIcon());
	JTextField JTName= new JTextField();
	JLabel JLClass= new JLabel(new ImageIcon());
	JTextField JTClass= new JTextField();
	JLabel JLsex= new JLabel(new ImageIcon());
	ButtonGroup BG= new ButtonGroup();
	JRadioButton JRB1= new JRadioButton("男");
	JRadioButton JRB2= new JRadioButton("女");
	JLabel JL1= new JLabel(new ImageIcon());
	JTextField JT1= new JTextField();
	JLabel JL2= new JLabel(new ImageIcon());
	JTextField JT2= new JTextField();
	JButton JBSet= new JButton("查询");
	JButton JBNext= new JButton("取消");
	JButton JBExit= new JButton("退出");
	String sql= "";
	public SetGrade()
	{
		this.setTitle("查询成绩");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,19));
		JL.setBounds(100,30,200,40);
		this.add(JL);
		
		JLNumber.setBounds(100,80,100,20);
		this.add(JLNumber);
		JTNumber.setBounds(200,80,180,20);
		this.add(JTNumber);
		JLName.setBounds(100,160,100,20);
		this.add(JLName);
		JTName.setBounds(200,160,80,20);
		this.add(JTName);
		JLsex.setBounds(100,200,100,20);
		this.add(JLsex);
		JRB1.setBounds(200,200,40,20);
		JRB2.setBounds(300,200,40,20);
		this.add(JRB1);
		this.add(JRB2);
		BG.add(JRB1);
		BG.add(JRB2);
		JL2.setBounds(100,240,100,20);
		this.add(JL2);
		JT2.setBounds(200,240,80,20);
		this.add(JT2);
		JLClass.setBounds(100,280,100,20);
		this.add(JLClass);
		JTClass.setBounds(200,280,80,20);
		this.add(JTClass);
		JL1.setBounds(100,320,100,20);
		this.add(JL1);
		JT1.setBounds(200,320,80,20);
		this.add(JT1);
		JBSet.setBounds(80,120,90,20);
		this.add(JBSet);
		JBSet.addActionListener(this);
		JBNext.setBounds(190,120,90,20);
		this.add(JBNext);
		JBNext.addActionListener(this);
		JBExit.setBounds(300,120,90,20);
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
		if(e.getSource()==JBSet)
		{
			String snumber=JTNumber.getText();
			String sname=JTName.getText();
			String sclass=JTClass.getText();
			String ssex="女";
			if(JRB1.isSelected())
				ssex="男";
			String scollect=JT1.getText();
			String sbir=JT2.getText();
			sql ="select*from student where Id='"+snumber+"'";
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cot=DriverManager.getConnection("jdbc:odbc:student1","","");
				Statement stm=cot.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				if(rs.next())
				{
					String name=rs.getString(2);
					JTName.setText(name);
					String clas=rs.getString(3);
					JTClass.setText(clas);
					String sex=rs.getString(4);
					JRB1.setText(sex);
					String collect=rs.getString(5);
					JT1.setText(collect);
					String bir=rs.getString(6);
					JT2.setText(bir);
					int n=stm.executeUpdate(sql);
					if(n>0)
						JOptionPane.showMessageDialog(null,"查询成功");
					else 
						JOptionPane.showMessageDialog(null,"查询失败");
				}
				else {
					JOptionPane.showMessageDialog(null, "用户不存在");
				}
				
				
				
			} catch (Exception ee) {

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
			}}
		}
		
		public static void main(String args[])
		{
			new SetGrade();		
	}

	

}
