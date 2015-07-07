package cn.lntu.t25;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;



@SuppressWarnings("serial")
public class ChangePassword extends JPanel implements ActionListener {
	/*密码修改


     */
	private String pwd;
	private  Service service;
	private int  id;


	private JLabel[] jlArray = { new JLabel("原始密码"), new JLabel("新密码"),
			new JLabel("确认新密码") };

	private JPasswordField[] jpfArray = { new JPasswordField(),
			new JPasswordField(), new JPasswordField() };
	private JButton[] jbArray = { new JButton("确认"), new JButton("重置") };
	
	public ChangePassword(int id, String password,Service service) {
		this.pwd = password;
		this.id = id;
		this.service=service;
		this.initialFrame();
		this.addListener();
	}


	
	
	
	public void addListener() {
		jpfArray[0].addActionListener(this);
		jpfArray[1].addActionListener(this);
		jpfArray[2].addActionListener(this);
		jbArray[0].addActionListener(this);
		jbArray[1].addActionListener(this);
	}

	private void initialFrame() {
		this.setLayout(null);
		for (int i = 0; i < jlArray.length; i++) {
			jlArray[i].setBounds(100, 50 + 50 * i, 150, 30);
			this.add(jlArray[i]);
			jpfArray[i].setBounds(300, 50 + 50 * i, 150, 30);
			this.add(jpfArray[i]);

		}
		jbArray[0].setBounds(200, 400, 100, 30);
		this.add(jbArray[0]);
		jbArray[1].setBounds(400, 400, 100, 30);
		this.add(jbArray[1]);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jpfArray[0]) {
			if(jpfArray[0].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入原密码");
				jpfArray[0].requestFocus();
			}
			else{	jpfArray[1].requestFocus(true);}
			
		} else if (e.getSource() == jpfArray[1]) {
			if(jpfArray[1].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入新密码");
				jpfArray[1].requestFocus();
			}
			else	{jpfArray[2].requestFocus(true);}
		} else if (e.getSource() == jpfArray[2]) {
			if(jpfArray[2].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入新密码");
				jpfArray[2].requestFocus();
			}
			else{jbArray[0].requestFocus(true);}
		} else if (e.getSource() == jbArray[1]) {
			jpfArray[0].setText("");
			jpfArray[1].setText("");
			jpfArray[2].setText("");
		} else if (e.getSource() == jbArray[0]) {
			String oldPwd, newPwd1, newPwd2;
			oldPwd = String.valueOf(jpfArray[0].getPassword());

			newPwd1 = String.valueOf(jpfArray[1].getPassword());

			newPwd2 = String.valueOf(jpfArray[2].getPassword());
			if (oldPwd.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入原密码");
			     jpfArray[0].requestFocus();
			} else if (newPwd1.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入新密码");
				jpfArray[1].requestFocus();
			} else if (newPwd2.equals("")) {
				JOptionPane.showMessageDialog(this, "请确认新密码");
				return;
			}

			else if (!(oldPwd.equals(pwd))) {
				JOptionPane.showMessageDialog(this, "原始密码错误", "eror",
						JOptionPane.ERROR_MESSAGE);
				jpfArray[0].setText("");
				jpfArray[1].setText("");
				jpfArray[2].setText("");
				jpfArray[0].requestFocus(true);
			}

			else if (!(newPwd1.equals(newPwd2))) {
				JOptionPane.showMessageDialog(this, "两次新密码不一致，请重新输入");
				jpfArray[1].setText("");
				jpfArray[2].setText("");
				jpfArray[1].requestFocus(true);
			}

			else {
				if(service.update(newPwd1, id)){
					
					JOptionPane.showMessageDialog(getParent(), "操作成功");
				}
				else{JOptionPane.showMessageDialog(getParent(), "操作失败");}
			}
		}
	}

	void setFocus() {
		jpfArray[0].requestFocus(true);
	}

}
