package bookmanage;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.*;

public class Login extends JPanel{
    JFrame loginFrame = null;
	public  void userlogin(){
		 loginFrame = new JFrame("”√ªßµ«¬º");
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
		panel.add(new JLabel("’À∫≈:"));
		panel.add(new JTextField("«Î ‰»Î’À∫≈",15));
		panel.setVisible(true);
		return panel;
	}
	private JPanel part2(){
		JPanel panel=new JPanel();
		panel.add(new JLabel("√‹¬Î:"));
		panel.add(new JPasswordField("«Î ‰»Î√‹¬Î",15));
		panel.setVisible(true);
		return panel;
	}
	private JPanel part3(){
		JPanel panel=new JPanel();
		JButton button1=new JButton("»∑∂®");
		JButton button2=new JButton("ÕÀ≥ˆ");
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
