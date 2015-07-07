package cn.lntu.t35;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import cn.lntu.t35.StudentMenu;
import cn.lntu.t35.User;
import cn.lntu.t35.UserService;

public class LoginIn extends JFrame implements ActionListener {
	/**
	 * 登陆界面
	 */
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	JTextField JTuser, JTpower;
	JPasswordField JTpassWd;
	JButton button1;
	Container framePane;
	JFrame frame = new JFrame();
	JLabel label1, label2;
	String str;
	
	private User user;
	
	
	public LoginIn() {
		
        
		Container content = getContentPane();
		Color color = new Color(100, 200, 78);
		content.setBackground(color);
		content.setLayout(null);
		this.setResizable(false);
		setTitle("登录窗口");

		framePane = frame.getContentPane();
		label1 = new JLabel("用户名: ");
		label1.setBounds(45, 30, 50, 30);
		this.add(label1);
		JTuser = new JTextField();
		str = JTuser.getText();
		JTuser.setFocusable(true);

		JTuser.setBounds(110, 30, 150, 30);
		this.add(JTuser);

		label1 = new JLabel("密 码: ");
		label1.setBounds(50, 70, 50, 30);
		this.add(label1);

		JTpassWd = new JPasswordField(null);
		JTpassWd.setBounds(110, 70, 150, 30);
		this.add(JTpassWd);

		button1 = new JButton("登录");
		button1.addActionListener(this);
		button1.setBounds(120, 130, 90, 30);
		
		this.add(button1);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(320, 220);
		setVisible(true);
		this.setLocation((dim.width - this.getWidth()) / 2,
				(dim.height - this.getHeight()) / 2); // 设置窗口显示位置

		this.setDefaultCloseOperation(HIDE_ON_CLOSE); // 关闭窗口时推车应用程序
		setVisible(true);

	}

	
   /** 
    *  登录用户密码判断
    */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (JTuser.getText().toString().equals("")
				|| JTpassWd.getPassword().equals(""))
			JOptionPane.showMessageDialog(this, "信息不能为空！");

		// JOptionPane.showMessageDialog(this, passWd.getPassword());
		else if (e.getActionCommand().equals(button1.getText())) {
			
            UserService service = new UserService();
			@SuppressWarnings("deprecation")
			String flag = service.Userpwd(JTuser.getText(), JTpassWd.getText());
			this.user = new User();
			user = User.fromJson(flag);
			if (user == null) {
				JOptionPane.showMessageDialog(this, "用户名不存在或密码错误" + '\n'
						+ "请重新输入！");

				JTuser.setText("");
				JTpassWd.setText("");

			} else {
				if (user.getPower().equals("00")) {

					
					new AdminMenu(user);
				} else if (user.getPower().equals("11")) {

					new StudentMenu(user);
				}
				this.dispose();
			}

		}
	}
	
	public static void main(String[] args) {
		new LoginIn();
	}
}
