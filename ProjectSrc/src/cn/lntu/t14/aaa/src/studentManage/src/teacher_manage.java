

package studentManage.src;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class teacher_manage extends JFrame
implements ActionListener
{
	JMenuBar jm=new JMenuBar();
	JMenu jm1=new JMenu("信息");
	JMenuItem jmi1=new JMenuItem("增加信息");
	JMenuItem jmi2=new JMenuItem("删除信息");
	JMenuItem jmi3=new JMenuItem("修改信息");
	JMenu jm4=new JMenu("成绩");
	JMenuItem jm41= new JMenuItem("录入成绩");
	JMenuItem jm42 = new JMenuItem("删除成绩");
	JMenuItem jm43 = new JMenuItem("修改成绩");
	JMenu jm2= new JMenu("查询");
	JMenuItem jmi21=new JMenuItem("基本信息查询");
	JMenu jm3=new JMenu("其他");
	JMenuItem jmi31= new JMenuItem("退出");
	public teacher_manage()
	{
		this.setTitle("考生基本信息");
		this.setLayout(new CardLayout());
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm.add(jm3);
		jm.add(jm4);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jm2.add(jmi21);
		jm2.add(jmi31);
		jm2.addActionListener(this);
		jmi21.addActionListener(this);
		jmi31.addActionListener(this);
		jm3.add(jmi31);
		jm3.addActionListener(this);
		jmi31.addActionListener(this);
		jm4.add(jm41);
		jm4.add(jm42);
		jm4.add(jm43);
		jm41.addActionListener(this);
		jm42.addActionListener(this);
		jm43.addActionListener(this);
		this.setBounds(10,10,500,400);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
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
	    if(e.getSource()==jm41)
	    {
	    	new AddGrade();
	    }
	    if(e.getSource()==jm42)
	    {
	    	new DeleteGrade();
	    }
	    if(e.getSource()==jm43)
	    {
	    	new GetGrade();
	    }
		if(e.getSource()==jmi21)
		{
			new SetTeacher();
			
		}
		if(e.getSource()==jmi31)
		{
			new UsingExit1().setVisible(true);
			
		}
		
	}
	public static void main(String args[])
	{
		new teacher_manage();
	}
	

}
