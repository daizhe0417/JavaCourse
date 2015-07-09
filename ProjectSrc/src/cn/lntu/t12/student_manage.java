package cn.lntu.t12;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class student_manage extends JFrame
implements ActionListener
{
	
	JMenuBar jm=new JMenuBar();//菜单蓝对象
	JMenu jm1=new JMenu("信息");
	JMenuItem jmi1=new JMenuItem("增加信息");
	JMenuItem jmi2=new JMenuItem("删除信息");
	JMenuItem jmi3=new JMenuItem("修改信息");
	JMenu jm2=new JMenu("查询");
	JMenuItem jmi21=new JMenuItem("基本信息查询");//文字标签
	JMenuItem jm22=new JMenuItem("成绩查询");
	JMenu jm3=new JMenu("其他");
	JMenuItem jmi31= new JMenuItem("退出");
	public student_manage()
	{
		
		this.setTitle("学生基本信息");
		this.setLayout(new CardLayout());
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm.add(jm3);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jm2.add(jmi21);
		jm2.add(jm22);
		jm2.addActionListener(this);
		jmi21.addActionListener(this);
		jm22.addActionListener(this);
		jm3.add(jmi31);
		jm3.addActionListener(this);
		jmi31.addActionListener(this);
		this.setBounds(10,10,500,400);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});//内部类重写关闭方法
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jmi1)
		{
			new AddStudent();
		}
		if(e.getSource()==jmi2)
		{
			new DeleteStudent();
		}
	    if(e.getSource()==jmi3)
	    {
	        new GetStudent();	
	    }
		if(e.getSource()==jmi21)
		{
			new SetStudent();
			
		}
		if(e.getSource()==jmi31)
		{
			new UsingExit().setVisible(true);
			
		}
		if(e.getSource()==jm22)
		{
			new SetGrade();
		}
	}
	public static void main(String args[])
	{
		new student_manage();
	}
	

}
