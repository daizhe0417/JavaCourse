package bookmanage;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.*;

public class Login extends JPanel{
    JFrame loginFrame = null;
	public  void userlogin(){
		 loginFrame = new JFrame("用户登录");
		loginFrame.setBounds(500,250,250,180);
		loginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Container contentPane=loginFrame.getContentPane();
		contentPane.add(new Login());
		loginFrame.setVisible(true);
	}
	
	public Login()
	{
		add(part1());
		add(part2());
		add(part3());
		setVisible(true);
	}
	private JPanel part1(){
		JPanel panel=new JPanel();
		panel.add(new JLabel("账号:"));
		panel.add(new JTextField("请输入账号",15));
		panel.setVisible(true);
		return panel;
	}
	private JPanel part2(){
		JPanel panel=new JPanel();
		panel.add(new JLabel("密码:"));
		panel.add(new JPasswordField("请输入密码",15));
		panel.setVisible(true);
		return panel;
	}
	private JPanel part3(){
		JPanel panel=new JPanel();
		JButton button1=new JButton("确定");
		JButton button2=new JButton("退出");
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		//		new ConnectDataBase().login();
				
			}
			
		});
		
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		      System.exit(0);
	//		loginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		panel.add(button1);
		panel.add(button2);
		panel.setVisible(true);
		return panel;
	}

	
}
