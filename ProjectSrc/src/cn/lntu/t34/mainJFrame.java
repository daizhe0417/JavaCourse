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
		JMenu Systemmenu=new JMenu("ϵͳ");
		JMenu Loginmenu=new JMenu("��¼");
		JMenu Browsemenu=new JMenu("���ͼ��");
		JMenu Feedback=new JMenu("���Է���");
		JMenu Helpmenu=new JMenu("����");
		//ϵͳ�˵�
		JMenuItem Aboutsystem=new JMenuItem("����ϵͳ");
		JMenuItem SystemExit=new JMenuItem("�˳�");
		Systemmenu.add(Aboutsystem);Systemmenu.add(SystemExit);
		//��¼�˵�
		JMenuItem UserLogin=new JMenuItem("�û����");
		JMenuItem ManageLogin=new JMenuItem("�������");
		Loginmenu.add(UserLogin);Loginmenu.add(ManageLogin);
		//���Բ˵�
		JMenuItem Aboutfeed=new JMenuItem("��������");
	    JMenuItem Browsefeed=new JMenuItem("�������");
	    Feedback.add(Aboutfeed);Feedback.add(Browsefeed);
	    //�����˵�
	    JMenuItem Abouthelp=new JMenuItem("���ڰ���");
	    JMenuItem ContactWe=new JMenuItem("��ϵ����");
	    Helpmenu.add(Abouthelp);Helpmenu.add(ContactWe);
	    //��Ӳ˵�
	    Mbar.add(Systemmenu);Mbar.add(Loginmenu);
	    Mbar.add(Browsemenu);Mbar.add(Feedback);
	    Mbar.add(Helpmenu);
	    //��Ӽ����¼�
	    SystemExit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		System.exit(0);
	    		
	    	}
	    });
	    Aboutsystem.addActionListener(new ActionListener(){	    
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				  JDialog jd=new JDialog();
	 	    	  jd.setTitle("ϵͳ");
	 	    	  JLabel jl=new JLabel("��ϵͳ������xx�꣬��xx������");
	              JLabel jl1=new JLabel("��ϵͳ����ͼ���������ҵ�����");
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
				// TODO �Զ����ɵķ������
				new Login().userlogin();
				
			}
	    	
	    });
	    ManageLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				new ManageLogin();
			}
	    	
	    });
	    JPanel panel=new JPanel();
	    JPanel pan=new JPanel();
	    this.setJMenuBar(Mbar);
	    JButton button=new JButton("���������");
	    JButton button1=new JButton("����Ա���");
	    button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ManageLogin();
			}
	    	
	    });
	    panel.setLayout(new GridLayout(7,1));
	    panel.add(button);
	    panel.add(button1);
	    panel.setBackground(Color.BLUE);
	    container.add(panel,"East");
	    container.setLayout(new BorderLayout());
	    
	    ImageIcon p2 = new ImageIcon(getClass().getResource("tutu.gif"));
	    panelicon.setIcon(p2);
        pan.add(panelicon);
        container.add(panel,"East");
       container.add(pan, "Center");
	    this.setTitle("XXͼ���");
	    this.setBounds(350,130,600,400);
	    this.getContentPane().setBackground(Color.green);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    
	    
	}
	
	public static void main(String args[]){
		new mainJFrame();
	}


}
