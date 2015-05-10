package cn.lntu.t34;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ManagementMenu extends JFrame implements ActionListener{
	Container container;
	JFrame jf;
	JLabel panelicon=new JLabel();
	String name=null;
	int flag;
	
	
	public ManagementMenu(String name,int flag){
		
		container=getContentPane();
		JMenuBar Mbar=new JMenuBar();
		JMenu Systemmenu=new JMenu(name);
		JMenu Idmenu=new JMenu("�˻�����");
		JMenu BookManage=new JMenu("ͼ�����");
		JMenu Feedback=new JMenu("���Թ���");
		JMenu Helpmenu=new JMenu("����");
		//ϵͳ�˵�
		JMenuItem Aboutsystem=new JMenuItem("����ϵͳ");
		JMenuItem SystemExit=new JMenuItem("�˳�");
		JMenuItem SwitchUser=new JMenuItem("�л��˺�");
		Systemmenu.add(SwitchUser);
		Systemmenu.add(Aboutsystem);Systemmenu.add(SystemExit);
		
		
		JMenuItem Brrowermenu=new JMenuItem("�����߹���");
		JMenuItem Managemenu=new JMenuItem("����Ա����");
		Idmenu.add(Brrowermenu);Idmenu.add(Managemenu);
		//ͼ�����˵�
		JMenuItem Browsebook=new JMenuItem("ͼ�����");
		JMenuItem BookInfo=new JMenuItem("ͼ����Ϣ����");
		BookManage.add(Browsebook);BookManage.add(BookInfo);
		//���Բ˵�
		
		JMenuItem Aboutfeed=new JMenuItem("������Ϣ");
	    JMenuItem Browsefeed=new JMenuItem("�������");
	    Feedback.add(Aboutfeed);Feedback.add(Browsefeed);
	    //����˵�
	    JMenuItem Abouthelp=new JMenuItem("���ڰ���");
	    JMenuItem ContactWe=new JMenuItem("��ϵ����");
	    Helpmenu.add(Abouthelp);Helpmenu.add(ContactWe);
	    //��Ӳ˵�
	    Mbar.add(Systemmenu);Mbar.add(Idmenu);
	    Mbar.add(BookManage);Mbar.add(Feedback);
	    Mbar.add(Helpmenu);
	    
	    SystemExit.addActionListener(this);
	    Helpmenu.addActionListener(this);
	    BookInfo.addActionListener(this);
	    setJMenuBar(Mbar);
	    panelicon.setIcon(new ImageIcon("1.gif"));
        container.add(panelicon);
	    setTitle("XXͼ���");
	    setBounds(350,130,600,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		String cmd=e.getActionCommand();
		if(cmd.equals("�˳�"))
		    dispose();
		
		if(cmd.equals("����"))
		{}
		//�������˵��ļ����¼�Ҫʵ�ֵ�����/////////
		
		
		if(cmd.equals("ͼ����Ϣ����"))
	       dispose();
		
	}
	/*
	public static void main(String [] args){
		new ManagementMenu();
	}
*/
}
