package cn.lntu.t12;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Info_Manage extends Frame implements ActionListener{
    JLabel JLUserName = new JLabel("用户名：");
    JLabel JLPaw = new JLabel("密码：");
    JLabel JLP = new JLabel("身份");
    JTextField JTUserName =new JTextField();//文本框对象
    JPasswordField JPsw= new JPasswordField();//密码框对象
    JTextField jt = new JTextField(10);
    String str[]={"学生","教师"};
    JComboBox JCB= new JComboBox(str);//组合框
    JButton JB1 = new JButton("登录");
    JButton JB2 = new JButton("取消");
    public Info_Manage()//构造函数
    {
    	this.setTitle("学生管理系统");
    	this.setLayout(null);
    	JLUserName.setBounds(100,40,100,20);
    	this.add(JLUserName);
    	JTUserName.setBounds(200,40,100,20);
    	this.add(JTUserName);
    	JLPaw.setBounds(100,100,100,20);
    	this.add(JLPaw);
    	JPsw.setBounds(200,100,80,20);
    	this.add(JPsw);
    	JCB.setBounds(200,150,100,20);
    	this.add(JCB);
    	JLP.setBounds(100,150,100,20);
    	this.add(JLP);
    	JB1.setBounds(100,200,60,20);
    	this.add(JB1);
    	JB1.addActionListener(this);
    	JB2.setBounds(200,200,60,20);
    	this.add(JB2);
    	JB2.addActionListener(this);
    	this.setVisible(true);
    	this.setBounds(10,10,400,250);//窗口尺寸大小
    	addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e){
    			System.exit(0);
    		}
    		
    		
		});
    	JCB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int h= JCB.getSelectedIndex();
				if(h==0)
				{
					student_manage sm= new student_manage();
				}
				else if(h==1)
				{
					teacher_manage tm= new teacher_manage();
					
				}
			}
		});
    	
    }
    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==JB1)
    	{
    		String name=JTUserName.getText();
    		String password=new String(JPsw.getPassword());
    		if((name !=null&&(name.equals("1")))&&(password !=null&&(password.equals("1"))))
    		{
    			new student_manage();
    		}
    		else {
    			{
    				
    			}
			}
    	}
    }
    
    public static void main(String args[])
    {
    	new Info_Manage();
    }
    }
