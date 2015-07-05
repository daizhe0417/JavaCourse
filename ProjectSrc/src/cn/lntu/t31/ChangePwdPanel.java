package cn.lntu.t31;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class ChangePwdPanel extends JPanel implements ActionListener{
	
	private JLabel JLOldPassword,JLNewPassword,JLCNewPassword;
	private JPasswordField JFOldPassword,JFNewPassword,JFCNewPassword;
	private JButton JBSubmit,JBRestart;
	
	private User user;
	
	ChangePwdPanel(User user) {
		this.user = user;
		this.initialFrame();
		this.addListener();
	}
	
	
	/**
	 * 添加Listener
	 */
	private void addListener() {
		JFOldPassword.addActionListener(this);
		JFNewPassword.addActionListener(this);
		JFCNewPassword.addActionListener(this);
		JBSubmit.addActionListener(this);
		JBRestart.addActionListener(this);	
	}
	
	/**
	 * 初始化frame
	 */
	private void initialFrame() {
		this.setLayout(null);
		JLOldPassword=new JLabel("原密码");
		JFOldPassword=new JPasswordField();
		JLNewPassword=new JLabel("新密码");
		JFNewPassword=new JPasswordField();
		JLCNewPassword=new JLabel("确认新密码");
		JFCNewPassword=new JPasswordField();
		JBSubmit=new JButton("提交");
		JBRestart=new JButton("重置");
		
		JLOldPassword.setBounds(220, 120, 150, 30);
		JLNewPassword.setBounds(220, 170, 150, 30);
		JLCNewPassword.setBounds(220,220, 150, 30);
		JFOldPassword.setBounds(300, 120, 150, 30);
		JFNewPassword.setBounds(300, 170, 150, 30);
		JFCNewPassword.setBounds(300, 220, 150, 30);
		JBSubmit.setBounds(230, 300, 100, 30);
		JBRestart.setBounds(360, 300, 100, 30);
		
		this.add(JLOldPassword);
		this.add(JFOldPassword);
		this.add(JLNewPassword);
		this.add(JFNewPassword);
		this.add(JLCNewPassword);
		this.add(JFCNewPassword);
		this.add(JBSubmit);
		this.add(JBRestart);
	}
	
	/**
	 * ActionListener时间监听器
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JBSubmit){
			String oldPwd = String.valueOf(JFOldPassword.getPassword());
			String newPwd = String.valueOf(JFNewPassword.getPassword());
			String cnewPwd = String.valueOf(JFCNewPassword.getPassword());
			if(oldPwd.equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入原密码");
				JFNewPassword.setText("");
				JFCNewPassword.setText("");
				JFOldPassword.requestFocus();
				return;
			}else if (!(oldPwd.equals(user.getPassword()))){
					JOptionPane.showMessageDialog(getParent(), "原密码不正确");
					JFOldPassword.setText("");
					JFNewPassword.setText("");
					JFCNewPassword.setText("");
					JFOldPassword.requestFocus();
					return;
				}else if(newPwd.equals("")){
						JOptionPane.showMessageDialog(getParent(), "请输入新密码");
						JFCNewPassword.setText("");
						JFNewPassword.requestFocus();
						return;
					}else  if(cnewPwd.equals("")) {
							JOptionPane.showMessageDialog(getParent(), "请再次输入新密码");
							JFCNewPassword.requestFocus();
							return;
						}else if(newPwd.equals(cnewPwd)){
								changePwd(cnewPwd);				
							}else{
								JOptionPane.showMessageDialog(getParent(), "两次密码不一致，请重新输入");
								JFNewPassword.setText("");
								JFCNewPassword.setText("");
								JFNewPassword.requestFocus();
								return;
							}
		}
		
		if(e.getSource()==JBRestart){
			JFOldPassword.setText("");
			JFNewPassword.setText("");
			JFCNewPassword.setText("");
			JFOldPassword.requestFocus();
		}
				
	}
	
	/**
	 * 修改密码
	 * @param cnewPwd
	 */
	private void changePwd(String cnewPwd) {
		UserService us = new UserService();
		try{
			int res = us.updatePassword(user.getUserName(),cnewPwd);
			if(res==1){
				JOptionPane.showMessageDialog(getParent(), "修改成功!");	
				user.setPassword(cnewPwd);
				JFOldPassword.setText("");
				JFNewPassword.setText("");
				JFCNewPassword.setText("");
				return;
			}else{
				JOptionPane.showMessageDialog(getParent(), "修改失败!");	
				JFOldPassword.setText("");
				JFNewPassword.setText("");
				JFCNewPassword.setText("");
				return;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(getParent(), "修改失败!");	
			JFOldPassword.setText("");
			JFNewPassword.setText("");
			JFCNewPassword.setText("");
			return;
		}		
	}
	
}
