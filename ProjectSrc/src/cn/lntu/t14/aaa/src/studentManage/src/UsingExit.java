package studentManage.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class UsingExit extends JFrame implements ActionListener
{
	JLabel JLInfo= new JLabel("退出界面");
	JButton JBExit= new JButton("退出");
	JButton JBNE= new JButton("取消");
	public UsingExit()
	{
		this.setTitle("退出界面");
		this.setLayout(null);
		JLInfo.setFont(new java.awt.Font("宋体",Font.PLAIN,19));
		JLInfo.setForeground(Color.black);
		JLInfo.setBounds(100,40,200,40);
		this.add(JLInfo);
		JBExit.setBounds(80,100,90,20);
		this.add(JBExit);
		JBExit.addActionListener(this);
		JBNE.setBounds(190,100,90,20);
		this.add(JBNE);
		JBNE.addActionListener(this);
		this.setBounds(10,10,400,250);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
		}
		});
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==JBExit)//完全退出
		{
			System.exit(0);
		}
		if(e.getSource()==JBNE)
		{
			setVisible(false);
		}
	}
	public static void main(String args[])
	{
		new UsingExit().setVisible(true);
	}
}


	
