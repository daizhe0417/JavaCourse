package cn.lntu.t13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class RSMSLogin extends Frame implements ActionListener {
	public TextField text_ID, text_Password;
	public Button button_OK, button_Cancel;
	public static String ID;
	public static String Password;
	public static String Manager[] = { "CZH", "SDS", "JY", "LYL", "ZZD" };
	public static String Key[] = { "111", "222", "333", "444", "555" };
	public static boolean flag=false;
	
	public RSMSLogin() {
		super("Login");
		this.setSize(270, 140);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.lightGray);
		this.setLayout(new GridLayout(3, 2, 2, 2));

		this.add(new Label("ID", Label.RIGHT));
		text_ID = new TextField(20);
		this.add(text_ID);
		this.add(new Label("Password", Label.RIGHT));
		text_Password = new TextField(20);
		this.add(text_Password);
		button_OK = new Button("OK");
		this.add(button_OK);
		button_OK.addActionListener(this);
		button_Cancel = new Button("Cancel");
		this.add(button_Cancel);
		button_Cancel.addActionListener(this);
		
		this.addWindowListener(new WinClose());
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == button_OK) {
			ID = text_ID.getText();
			Password = text_Password.getText();
			if (ID.equals("")) {
				JOptionPane.showMessageDialog(this, "�û�����Ϊ��");
				return;
			}
			if (Password.equals("")) {
				JOptionPane.showMessageDialog(this, "���벻��Ϊ��");
				return;
			}

			switch (RSMSLogin.login(ID, Password)) {
			case 0:
				RSMSLogin.flag=true;
				JOptionPane.showMessageDialog(this, "��¼�ɹ�");
				this.hide();
				MainWindows();
				break;
			case 1:
				JOptionPane.showMessageDialog(this, "���벻��ȷ");
				break;
			case 2:
				JOptionPane.showMessageDialog(this, "�û������");
				;
				break;
			}
		}
		if (ev.getSource() == button_Cancel) {
			System.exit(0);
		}
	}

	public static int login(String id, String pw) {
		for (int i = 0; i < 5; i++) {
			if (id.equals(Manager[i]))
				if (pw.equals(Key[i])) {
					return 0;
				} else {
					return 1;
				}
		}
		return 2;
	}

	public static void main(String arg[]) {
		new RSMSLogin();
	}
	public static void MainWindows() {
		WorkerBuffer wbtemp;
		wbtemp=new WorkerBuffer(DBselect.getAll());

		Worker worker[] = { new Worker("SDS", "0625", "man", "office", "manager"),
				new Worker("SXS", "0506", "man", "offic", "secretary"),
				new Worker("XC", "0625", "won", "human", "minister"),
				new Worker("MSCH", "0506", "won", "finance", "minister"),
				new Worker("TSDL", "0324", "won", "science", "staff") };
		String temp[];
		temp = RSMSWindow.exchangeWorker(wbtemp.www);
		new RSMSWindow(new WorkerPanel(), worker, temp);
	}
}

class WinClose implements WindowListener {
	public void windowClosing(WindowEvent ev) {
		System.exit(0);
	}

	public void windowOpened(WindowEvent ev) {

	}

	public void windowActivated(WindowEvent ev) {

	}

	public void windowDeactivated(WindowEvent ev) {

	}

	public void windowClosed(WindowEvent ev) {

	}

	public void windowIconified(WindowEvent ev) {

	}

	public void windowDeiconified(WindowEvent ev) {

	}
}
