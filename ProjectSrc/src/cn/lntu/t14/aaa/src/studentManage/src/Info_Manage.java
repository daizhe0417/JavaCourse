package studentManage.src;

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
    JLabel JLUserName = new JLabel(new ImageIcon("E:"));//创建一个标签对象
    JLabel JLPaw = new JLabel(new ImageIcon(""));
    JLabel JLP = new JLabel(new ImageIcon(""));
    JTextField JTUserName =new JTextField();
    JPasswordField JPsw= new JPasswordField();
    JTextField jt = new JTextField(10);
    String str[]={"考生","教师"};
    JComboBox JCB= new JComboBox(str);//父选框
    JButton JB1 = new JButton("登录");
    JButton JB2 = new JButton("取消");
    public Info_Manage()//设置布局
    {  
    	this.setTitle("考生管理系统");
    	this.setLayout(null);
    	JLabel user = new JLabel("用户名");
    	user.setBounds(80,40,100,20);
    	this.add(user);
    	
    	JLUserName.setBounds(100,40,100,20);
    	this.add(JLUserName);
    	JTUserName.setBounds(200,40,100,20);
    	this.add(JTUserName);
    	JLabel pas = new JLabel("密码");
    	pas.setBounds(80,100,100,20);
    	this.add(pas);
    	JPsw.setBounds(200,100,80,20);
    	this.add(JPsw);
    	JCB.setBounds(200,150,100,20);
    	this.add(JCB);
    	JLP.setBounds(100,150,100,20);
    	this.add(JLP);
    	JB1.setBounds(100,200,60,20);
    	this.add(JB1);
    	JB1.addActionListener(this);//添加动作监听
    	JB2.setBounds(200,200,60,20);
    	this.add(JB2);
    	JB2.addActionListener(this);
    	this.setVisible(true);//设置可见度
    	this.setBounds(10,10,400,250);
    	/*固定格式，执行退出*/
    	addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e){
    			System.exit(0);
    		}
    		
    		
		});
    	/*选项监听*/
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
    /*提交数据并返回选项*/
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
