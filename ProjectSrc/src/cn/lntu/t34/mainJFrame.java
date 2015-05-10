package bookmanage;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import bookmanage.Login;

public  class  mainJFrame extends JFrame {
	
	Container container;
	JFrame jf;
	JLabel panelicon=new JLabel();
	public mainJFrame(){
		container=getContentPane();
		JMenuBar Mbar=new JMenuBar();
		JMenu Systemmenu=new JMenu("系统");
		JMenu Loginmenu=new JMenu("登录");
		JMenu Browsemenu=new JMenu("浏览图书");
		JMenu Feedback=new JMenu("留言反馈");
		JMenu Helpmenu=new JMenu("帮助");
		//系统菜单
		JMenuItem Aboutsystem=new JMenuItem("关于系统");
		JMenuItem SystemExit=new JMenuItem("退出");
		Systemmenu.add(Aboutsystem);Systemmenu.add(SystemExit);
		//登录菜单
		JMenuItem UserLogin=new JMenuItem("用户入口");
		JMenuItem ManageLogin=new JMenuItem("管理入口");
		Loginmenu.add(UserLogin);Loginmenu.add(ManageLogin);
		//留言菜单
		JMenuItem Aboutfeed=new JMenuItem("关于留言");
	    JMenuItem Browsefeed=new JMenuItem("浏览留言");
	    Feedback.add(Aboutfeed);Feedback.add(Browsefeed);
	    //帮助菜单
	    JMenuItem Abouthelp=new JMenuItem("关于帮助");
	    JMenuItem ContactWe=new JMenuItem("联系我们");
	    Helpmenu.add(Abouthelp);Helpmenu.add(ContactWe);
	    //添加菜单
	    Mbar.add(Systemmenu);Mbar.add(Loginmenu);
	    Mbar.add(Browsemenu);Mbar.add(Feedback);
	    Mbar.add(Helpmenu);
	    //添加监听事件
	    SystemExit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		System.exit(0);
	    		
	    	}
	    });
	    Aboutsystem.addActionListener(new ActionListener(){	    
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				  JDialog jd=new JDialog();
	 	    	  jd.setTitle("系统");
	 	    	  JLabel jl=new JLabel("该系统制作于xx年，有xx人制作");
	              JLabel jl1=new JLabel("该系统用于图书管理，非商业软件！");
	              JPanel panel=new JPanel();
	              JPanel part1=new JPanel();
	              JPanel part2=new JPanel();
	              part1.add(jl);
	              part2.add(jl1);
	              panel.add(part1);
	              panel.add(part2);
	 	          jd.getContentPane().add(panel);
	 	    	  jd.setBounds(500,250,300,100);
	 	    	  jd.setSize(300,100);
	 	    	  jd.setVisible(true);
			}

			
	    });
	    UserLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new Login().userlogin();
				
			}
	    	
	    });
	    ManageLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new ManageLogin();
			}
	    	
	    });
	    setJMenuBar(Mbar);
	    panelicon.setIcon(new ImageIcon("1.gif"));
        container.add(panelicon);
	    setTitle("XX图书馆");
	    setBounds(350,130,600,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    
	    
	}
	
	public static void main(String args[]){
		new mainJFrame();
	}
}
