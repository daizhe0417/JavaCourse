package Hospital;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JList;
public class UserJFrame extends JFrame implements ActionListener, ItemListener {
	private JTextField text_number, text_name; // 编号、姓名文本行
	private JLabel lbld, lbPass;
	private JRadioButton radiobutton_male, radiobutton_female; // 性别按钮
	private JComboBox combobox_province, combobox_city; // 省份、城市组合框
	private JButton button_ok, button_cancel; // 添加按钮
    
	public UserJFrame() {
		super("用户登录");
		this.setSize(360, 100);
		this.setLocation(200, 240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行
		this.setLayout(new GridLayout(1, 1)); // 网格布局，1行2列，左右分隔窗口
		JPanel panel = new JPanel(new GridLayout(3, 2)); // 面板网格布局，6行1列
		this.add(panel); // 占据窗口右半部分
		lbld = new JLabel("用户名");
		lbPass = new JLabel("密码");
		text_name = new JTextField(10);
		text_number = new JTextField(10);
		button_ok = new JButton("确定");
		button_cancel = new JButton("取消");
		button_ok.addActionListener(this);
		button_cancel.addActionListener(this);
		panel.add(lbld);
		panel.add(text_name);
		panel.add(button_ok);
		panel.add(lbPass);
		panel.add(text_number);
		panel.add(button_cancel);
		JPanel panel_radiobutton = new JPanel(new GridLayout(1, 2)); // 单选按钮子面板，网格布局，1行2列
		panel.add(panel_radiobutton);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) // 单击按钮时触发执行
	{
		if (e.getSource().equals(button_cancel)) {
			System.exit(0);
		}
		if (e.getSource().equals(button_ok)) {
			String name = "songxiaonan";
			String password = "123456";
			String id = "";
			String code = "";
			id = text_name.getText();
			code = text_number.getText();
			if (name.compareTo(id) != 0 || password.compareTo(code) != 0) {
				JOptionPane.showMessageDialog(null, "用户名或密码有错误！", "测试窗口",
						JOptionPane.PLAIN_MESSAGE);
				text_name.setText("");
				text_number.setText("");
			} else {
				new MainJFrame();
				this.hide();
			}
		}
	}

	public static void main(String arg[]) {
		new UserJFrame();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}
}

