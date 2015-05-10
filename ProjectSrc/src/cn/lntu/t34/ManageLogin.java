package bookmanage;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.*;

public class ManageLogin extends JFrame implements ActionListener{
	Connection conn=null;
	JTextField user;
	JPasswordField passWd;
	JButton b1,b2;
	Container framePane,Panel1,Panel2,Panel3,Panel4,Panel5;
    JDialog d;
    JFrame frame;
    JLabel label1,label2;
    Font font1,font2;
    Dimension dim1;
    int count=0;
    private static String systemTitle="图  书  管  理  系  统";
    /**Construct the application*/
    public ManageLogin(){
    	setTitle("登录窗口");
    	framePane=getContentPane();
    	GridBagLayout gridbag=new GridBagLayout();
    	GridBagConstraints c=new GridBagConstraints();
    	setFont(new Font("SanSerif",Font.PLAIN,14));
        framePane.setLayout(gridbag);
        MakeComponent mc=new MakeComponent();
        c.gridy=0;
        c.gridwidth=6;
        c.gridheight=1;
        c.weighty=1;
        c.anchor=GridBagConstraints.CENTER;
        label1=mc.makeJLabel(framePane,systemTitle,gridbag,c);
        font1=new Font("labelName",Font.BOLD,30);
        //添加其他组件/////////////////////
        c.gridx=0;
        c.gridy=1;
        c.anchor=GridBagConstraints.WEST;
        label1=mc.makeJLabel(framePane, "账  户: ", gridbag, c);
        c.gridx=0;
        c.gridy=2;
        c.anchor=GridBagConstraints.WEST;
        label1=mc.makeJLabel(framePane, "密   码: ", gridbag, c);
        
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=100;
        c.anchor=GridBagConstraints.EAST;
  //     user.setColumns(30);
        user=mc.makeJTextField(framePane, "请输入账户                            ", gridbag, c);
        user.setColumns(0);c.gridy=2;
        c.gridx=0;
        
        c.gridwidth=100;
        c.anchor=GridBagConstraints.EAST;
        passWd=mc.makeJPasswordField(framePane, "请输入密码 "+"                  ", gridbag, c);
        
        
        c.gridx=0;
        c.gridy=3;
        c.anchor=GridBagConstraints.WEST;
        b1=mc.makeJButton(framePane,"确定",gridbag,c);
        c.gridx=1;
        c.gridy=3;
        c.anchor=GridBagConstraints.EAST;
        b2=mc.makeJButton(framePane,"取消",gridbag,c);
        c.gridy=4;
        c.gridx=0;
        c.anchor=GridBagConstraints.WEST;
        label2=mc.makeJLabel(framePane,"注意：初始用户名user密码123456",gridbag,c);
        font2=new Font("labelName",Font.BOLD,12);
        label2.setFont(font2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setBounds(200,150,325,240);            //设置窗口显示位置
        getRootPane().setDefaultButton(b1);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //关闭窗口时推车应用程序
        setVisible(true);
    	
    }
    public void actionPerformed(ActionEvent e){
    	  String cmd=e.getActionCommand();
    	  if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
    	  
    	  String name=user.getText();      //取得管理员的名称
    	  char[] passWord=passWd.getPassword();
    	  String passwd=new String(passWord);  //取得管理员密码
    	  Statement stmt=null;
    	  ResultSet rst=null;
    	  int flag=0;
    	  try{
    	      if(cmd.equals("确定"))
    	      {
    	        String sql="select * from administrator where Aname='"+name+"'"+"and password='"+passwd+"'";
    	        stmt=conn.createStatement();
    	       
    	        rst=stmt.executeQuery(sql);
    	        if(rst.next())
    	        {
    	         flag=1;
    	         JOptionPane.showMessageDialog(ManageLogin.this, "本次登录账号是"+name,"提示对话框",1);
    	        
    	        JFrame F=new ManagementMenu(name,1);
    	         dispose();
    	        }
    	        else
    	        //添加其他一些登录信息判断
    	        //..........................
    	        {               }
    	       }
    	       else
    	       {                   }
    	      if(cmd.equals("取消"))
    	    	//  System.exit(0);
    	    	  dispose();
    	          
    	     }
    	  catch(Exception ex){ex.printStackTrace();}
    	 }
    	 public static void main(String [] args)
    	 {
    	  new ManageLogin();
    	 }

}
