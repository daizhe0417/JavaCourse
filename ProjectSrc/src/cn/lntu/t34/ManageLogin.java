package cn.lntu.t34;
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
    private static String systemTitle="ͼ  ��  ��  ��  ϵ  ͳ";
    /**Construct the application*/
    public ManageLogin(){
    	setTitle("��¼����");
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
        //����������/////////////////////
        c.gridx=0;
        c.gridy=1;
        c.anchor=GridBagConstraints.WEST;
        label1=mc.makeJLabel(framePane, "��  ��: ", gridbag, c);
        c.gridx=0;
        c.gridy=2;
        c.anchor=GridBagConstraints.WEST;
        label1=mc.makeJLabel(framePane, "��   ��: ", gridbag, c);
        
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=100;
        c.anchor=GridBagConstraints.EAST;
  //     user.setColumns(30);
        user=mc.makeJTextField(framePane, "�������˻�                            ", gridbag, c);
        user.setColumns(0);c.gridy=2;
        c.gridx=0;
        
        c.gridwidth=100;
        c.anchor=GridBagConstraints.EAST;
        passWd=mc.makeJPasswordField(framePane, "���������� "+"                  ", gridbag, c);
        
        
        c.gridx=0;
        c.gridy=3;
        c.anchor=GridBagConstraints.WEST;
        b1=mc.makeJButton(framePane,"ȷ��",gridbag,c);
        c.gridx=1;
        c.gridy=3;
        c.anchor=GridBagConstraints.EAST;
        b2=mc.makeJButton(framePane,"ȡ��",gridbag,c);
        c.gridy=4;
        c.gridx=0;
        c.anchor=GridBagConstraints.WEST;
        label2=mc.makeJLabel(framePane,"ע�⣺��ʼ�û���user����123456",gridbag,c);
        font2=new Font("labelName",Font.BOLD,12);
        label2.setFont(font2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setBounds(200,150,325,240);            //���ô�����ʾλ��
        getRootPane().setDefaultButton(b1);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //�رմ���ʱ�Ƴ�Ӧ�ó���
        setVisible(true);
    	
    }
    public void actionPerformed(ActionEvent e){
    	  String cmd=e.getActionCommand();
    	  if(conn==null) conn=ConnectDataBase.getConn();     //������ݿ�����
    	  
    	  String name=user.getText();      //ȡ�ù���Ա�����
    	  char[] passWord=passWd.getPassword();
    	  String passwd=new String(passWord);  //ȡ�ù���Ա����
    	  Statement stmt=null;
    	  ResultSet rst=null;
    	  int flag=0;
    	  try{
    	      if(cmd.equals("ȷ��"))
    	      {
    	        String sql="select * from administrator where Aname='"+name+"'"+"and password='"+passwd+"'";
    	        stmt=conn.createStatement();
    	       
    	        rst=stmt.executeQuery(sql);
    	        if(rst.next())
    	        {
    	         flag=1;
    	         JOptionPane.showMessageDialog(ManageLogin.this, "���ε�¼�˺���"+name,"��ʾ�Ի���",1);
    	        
    	        JFrame F=new ManagementMenu(name,1);
    	         dispose();
    	        }
    	        else
    	        //�������һЩ��¼��Ϣ�ж�
    	        //..........................
    	        {               }
    	       }
    	       else
    	       {                   }
    	      if(cmd.equals("ȡ��"))
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
