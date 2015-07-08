package cn.lntu.t31.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.lntu.t31.Bean.User;
import cn.lntu.t31.Dao.UserService;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame{
	
	private JLabel JLAccount,JLPassword;
	private JTextField JFUserName;
	private JPasswordField JFPassword;
	private JButton JBLogin;
	
	LoginFrame(){
		super("高校科研管理系统");
		CreateFrame();
		AddListener();
	}
 
	/**
	 * 创建Frame
	 */
	private void CreateFrame() {
		JLAccount=new JLabel("帐号:");
		JLPassword=new JLabel("密码:");
		JFUserName=new JTextField();
		JFPassword=new JPasswordField();
		JBLogin=new JButton("登录");
		JPanel panel=new JPanel();
		panel.setLayout(null);

		JLAccount.setBounds(75, 50, 50, 30);
		JLPassword.setBounds(75,90,50,30);
		JFUserName.setBounds(115, 50, 150, 30);
		JFPassword.setBounds(115, 90, 150, 30);
		JBLogin.setBounds(130, 140, 120, 30);
		
		panel.add(JLAccount);
		panel.add(JLPassword);
		panel.add(JFUserName);
		panel.add(JFPassword);
		panel.add(JBLogin);
		
		this.add(panel);
		this.setSize(350, 250);
		this.setLocation(780, 400);
		this.setResizable(false);
		this.setVisible(true);	
	}

	/**
	 * 添加监听�?
	 */
	public void AddListener() {
		JFUserName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JFPassword.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JBLogin.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
					loginTask();						
			}	
		});
		
		JBLogin.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent key) {
				int keytype = key.getKeyCode();
				if (keytype == KeyEvent.VK_ENTER) {
					loginTask();
				}
			}	
		});
		
	}
	
	/**
	 * 登录任务
	 */
	public void loginTask() {
		String UserName = JFUserName.getText().toString();
		String psd =  new String(JFPassword.getPassword());
		if(UserName.equals("")){
			JOptionPane.showMessageDialog(getParent(), "帐号不能为空!");	
			return;
		}
		if(psd.equals("")){
			JOptionPane.showMessageDialog(getParent(), "密码不能为空!");	
			return;
		}
		UserService us = new UserService();
		User user = new User();
		try{
			String content = us.login(UserName,psd);
			user = User.fromJson(content);
			if(content.equals("-1")){
				JOptionPane.showMessageDialog(getParent(), "密码不正�?!");	
				return;
			}
			if(user == null){
				JOptionPane.showMessageDialog(getParent(), "登录失败!");	
				return;
			}
			if(user.getIsStop().equals("0")){
				JOptionPane.showMessageDialog(getParent(), "该用户已停用!");
				return;
			}	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(getParent(), "登录失败!");	
			return;
		}
		if(user.getPower().equals("1")){
			new UserFramme(user);
		}
		if(user.getPower().equals("2")){
			new CheckFrame(user);
		}
		if(user.getPower().equals("3")){
			new AdminFrame(user);
		}
		this.dispose();	
		
	}

	
	public static void main(String arg[]) {
		new LoginFrame();
	}
	
}
