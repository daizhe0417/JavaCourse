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
		JMenuItem borrowBook=new JMenuItem("�������");
		JMenuItem returnBook=new JMenuItem("�������");
		BookInfo.addActionListener(this);
		borrowBook.addActionListener(this);
		returnBook.addActionListener(this);
		BookManage.add(BookInfo);BookManage.add(Browsebook);
		BookManage.add(borrowBook);BookManage.add(returnBook);
		//���Բ˵�
		
		JMenuItem Aboutfeed=new JMenuItem("������Ϣ");
	    JMenuItem Browsefeed=new JMenuItem("�������");
	    Feedback.add(Aboutfeed);Feedback.add(Browsefeed);
	    //�����˵�
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
	    Abouthelp.addActionListener(this);
	    SwitchUser.addActionListener(this);
	    Managemenu.addActionListener(this);
	    
	    setJMenuBar(Mbar);
	    panelicon.setIcon(new ImageIcon("1.gif"));
        container.add(panelicon);
        container.setBackground(Color.green);
	    setTitle("ͼ��ݹ�����Ϣ");
	    setBounds(350,130,600,400);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setVisible(true);
	    
	   
	}
	public void actionPerformed(ActionEvent e){
		String cmd=e.getActionCommand();
		if(cmd.equals("�˳�"))
		    dispose();
		if(cmd.equals("�л��˺�")){
			dispose();
		    new ManageLogin();
		}
		if(cmd.equals("���ڰ���"))
		{
			JOptionPane.showMessageDialog(this, "ллʹ�ã����в����׵ĵط�����ϵ���ǣ�");
		}
		//��������˵��ļ����¼�Ҫʵ�ֵ�����/////////
		if(cmd.equals("�������"))
			new BorrowBook();
		
		if(cmd.equals("�������"))
			new BorrowBook();
		     
		
		if(cmd.equals("����Ա����"))
		{
			int root=this.flag;
			if(root>2)
				new Manager(name,root);
			else
				JOptionPane.showMessageDialog(this, "����ʹ��Ȩ�޼��𲻹���");
		}
		
		if(cmd.equals("��ϵ����"))
			JOptionPane.showMessageDialog(this, "ллʹ�ã����в����׵ĵط�����ϵ���ǣ�");
		if(cmd.equals("ͼ����Ϣ����"))
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
