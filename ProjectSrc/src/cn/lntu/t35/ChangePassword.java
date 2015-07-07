package cn.lntu.t35;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import cn.lntu.t35.User;
import cn.lntu.t35.UserService;

public class ChangePassword extends JPanel implements ActionListener {
	/**
	 * �޸�����
	 */
	private static final long serialVersionUID = 1L;
	JPasswordField oldpassWd, newpassWd1, newpassWd2;
	JButton buttYes, buttNo;
	Container framePane;
	//JDialog d;
	JPanel frame = new JPanel();
	JLabel OPassWd, NPassWd1, NPassWd2;
	String str;
	private User user;
	public ChangePassword(User user) {
		this.user = user;
		this.initialFrame();
		this.addListener();
	}

	private void addListener() {
		oldpassWd.addActionListener(this);
		newpassWd1.addActionListener(this);
		newpassWd2.addActionListener(this);
		buttYes.addActionListener(this);
		buttNo.addActionListener(this);
	}

	private void initialFrame() {
		this.setLayout(null);
		OPassWd = new JLabel("ԭ����: ");
		NPassWd1 = new JLabel("������:");
		NPassWd2 = new JLabel("ȷ��������:");
		oldpassWd = new JPasswordField("");
		newpassWd1 = new JPasswordField("");
		newpassWd2 = new JPasswordField("");
		buttYes = new JButton("ȷ��");
		buttNo = new JButton("ȡ��");

		OPassWd.setBounds(250, 200, 150, 30);
		NPassWd1.setBounds(250, 250, 150, 30);
		NPassWd2.setBounds(225, 300, 150, 30);
		oldpassWd.setBounds(320, 200, 150, 30);
		newpassWd1.setBounds(320, 250, 150, 30);
		newpassWd2.setBounds(320, 300, 150, 30);
		buttYes.setBounds(250, 400, 80, 30);
		buttNo.setBounds(390, 400, 80, 30);

		this.add(OPassWd);
		this.add(NPassWd1);
		this.add(NPassWd2);
		this.add(oldpassWd);
		this.add(newpassWd1);
		this.add(newpassWd2);
		this.add(buttYes);
		this.add(buttNo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttYes) {
			String oldPwd = String.valueOf(oldpassWd.getPassword());
			String newPwd1 = String.valueOf(newpassWd1.getPassword());
			String newPwd2 = String.valueOf(newpassWd2.getPassword());
			if (oldPwd.equals("")) {
				JOptionPane.showMessageDialog(getParent(), "������ԭ����");
				oldpassWd.setText("");
				oldpassWd.requestFocus();
				return;
			} else if (newPwd1.equals("")) {
				JOptionPane.showMessageDialog(getParent(), "������������");
				newpassWd2.setText("");
				newpassWd1.requestFocus();
				return;
			} else if (newPwd2.equals("")) {
				JOptionPane.showMessageDialog(getParent(), "���ٴ�����������");
				newpassWd2.requestFocus();
				return;
			} else if (!(oldPwd.equals(this.user.getPassword()))) {
				JOptionPane.showMessageDialog(getParent(), "ԭ���벻��ȷ");
				oldpassWd.setText("");
				newpassWd1.setText("");
				newpassWd2.setText("");
				oldpassWd.requestFocus();
				return;
			} else if (!(newPwd1.equals(newPwd2))) {
				JOptionPane.showMessageDialog(getParent(), "�������벻һ�£�����������");
				newpassWd1.setText("");
				newpassWd2.setText("");
				newpassWd1.requestFocus();
				return;
			} else {
				UserService us = new UserService();
				try{
					int res = us.update(newPwd1,user.getStunum());
					if(res==0){
						JOptionPane.showMessageDialog(getParent(), "�޸ĳɹ�!");	
						user.setPassword(newPwd2);
						oldpassWd.setText("");
						newpassWd1.setText("");
						newpassWd2.setText("");
					   // user.setPassword(newPwd1);
						return;
					}else{
						JOptionPane.showMessageDialog(getParent(), "�޸�ʧ��!");	
						oldpassWd.setText("");
						newpassWd1.setText("");
						newpassWd2.setText("");
						return;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getParent(), "�޸�ʧ��!");	
					oldpassWd.setText("");
					newpassWd1.setText("");
					newpassWd2.setText("");
					return;
				}		
			}
		}
		if (e.getSource() == buttNo) {
			oldpassWd.setText("");
			newpassWd1.setText("");
			newpassWd2.setText("");
			oldpassWd.requestFocus();
		}

	}
}
