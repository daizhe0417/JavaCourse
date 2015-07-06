package bookmanage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ManagementMenu extends JFrame implements ActionListener{
	Container container;
	JFrame jf;
	JLabel panelicon=new JLabel();
	String name=null;
	int flag;
	
	
	
	public  ManagementMenu(String name,int  flag){
	    this.flag=flag;
	    this.name=name;
		container=getContentPane();
		JMenuBar Mbar=new JMenuBar();
		JMenu Systemmenu=new JMenu(name);
		JMenu Idmenu=new JMenu("账户管理");
		JMenu BookManage=new JMenu("图书管理");
		JMenu Feedback=new JMenu("留言管理");
		JMenu Helpmenu=new JMenu("帮助");
		//系统菜单
		JMenuItem Aboutsystem=new JMenuItem("关于系统");
		JMenuItem SystemExit=new JMenuItem("退出");
		JMenuItem SwitchUser=new JMenuItem("切换账号");
		Systemmenu.add(SwitchUser);
		Systemmenu.add(Aboutsystem);Systemmenu.add(SystemExit);
		
		
		JMenuItem Brrowermenu=new JMenuItem("借阅者管理");
		JMenuItem Managemenu=new JMenuItem("管理员管理");
		Idmenu.add(Brrowermenu);Idmenu.add(Managemenu);
		//图书管理菜单
		JMenuItem Browsebook=new JMenuItem("图书浏览");
		JMenuItem BookInfo=new JMenuItem("图书信息管理");
		JMenuItem borrowBook=new JMenuItem("借书管理");
		JMenuItem returnBook=new JMenuItem("还书管理");
		BookInfo.addActionListener(this);
		borrowBook.addActionListener(this);
		returnBook.addActionListener(this);
		BookManage.add(BookInfo);BookManage.add(Browsebook);
		BookManage.add(borrowBook);BookManage.add(returnBook);
		//留言菜单
		
		JMenuItem Aboutfeed=new JMenuItem("留言信息");
	    JMenuItem Browsefeed=new JMenuItem("浏览留言");
	    Feedback.add(Aboutfeed);Feedback.add(Browsefeed);
	    //帮助菜单
	    JMenuItem Abouthelp=new JMenuItem("关于帮助");
	    JMenuItem ContactWe=new JMenuItem("联系我们");
	    Helpmenu.add(Abouthelp);Helpmenu.add(ContactWe);
	    //添加菜单
	    Mbar.add(Systemmenu);Mbar.add(Idmenu);
	    Mbar.add(BookManage);Mbar.add(Feedback);
	    Mbar.add(Helpmenu);
	    
	    SystemExit.addActionListener(this);
	    Helpmenu.addActionListener(this);
	    BookInfo.addActionListener(this);
	    Abouthelp.addActionListener(this);
	    SwitchUser.addActionListener(this);
	    Managemenu.addActionListener(this);
	    
	    setJMenuBar(Mbar);
	    panelicon.setIcon(new ImageIcon("1.gif"));
        container.add(panelicon);
        container.setBackground(Color.green);
	    setTitle("图书馆管理信息");
	    setBounds(350,130,600,400);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setVisible(true);
	    
	   
	}
	public void actionPerformed(ActionEvent e){
		String cmd=e.getActionCommand();
		if(cmd.equals("退出"))
		    dispose();
		if(cmd.equals("切换账号")){
			dispose();
		    new ManageLogin();
		}
		if(cmd.equals("关于帮助"))
		{
			JOptionPane.showMessageDialog(this, "谢谢使用，若有不明白的地方请联系我们！");
		}
		//添加其他菜单的监听事件要实现的内容/////////
		if(cmd.equals("借书管理"))
			new BorrowBook();
		
		if(cmd.equals("还书管理"))
			new BorrowBook();
		     
		
		if(cmd.equals("管理员管理"))
		{
			int root=this.flag;
			if(root>2)
				new Manager(name,root);
			else
				JOptionPane.showMessageDialog(this, "您的使用权限级别不够！");
		}
		
		if(cmd.equals("联系我们"))
			JOptionPane.showMessageDialog(this, "谢谢使用，若有不明白的地方请联系我们！");
		if(cmd.equals("图书信息管理"))
	       //dispose();
			{new BookManage();}
		
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getFlag(){
		return this.flag;
	}
	
	public static void main(String [] args){
		new ManagementMenu("dsy",3);
	}

}
