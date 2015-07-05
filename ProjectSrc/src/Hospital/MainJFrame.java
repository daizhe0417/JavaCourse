package Hospital;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MainJFrame extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4809293292305833007L;
	private JLabel jlabel = new JLabel(new ImageIcon(getClass().getResource(
			"123.jpg")));
	private JButton button_cut, button_copy, button_paste;

	public MainJFrame() {
		this.setLayout(null);
		jlabel.setBounds(0, 0, 900, 600);
		this.add(jlabel);
		initial();
		this.addmyMenu();
	}

	private void addmyMenu() {
		// TODO Auto-generated method stub
		JMenuBar menubar = new JMenuBar(); // 菜单栏
		this.setJMenuBar(menubar); // 框架上添加菜单栏

		JMenu menu_file = new JMenu("医院管理系统"); // 菜单
		menubar.add(menu_file); // 菜单栏中加入菜单
		// menu_file.add(new JMenuItem("打开")); // 生成菜单项并加入到菜单
		JMenuItem menuitem_medicine = new JMenuItem("药品管理");
		menu_file.add(menuitem_medicine);
		menuitem_medicine.addActionListener(this);
		JMenuItem menuitem_doctor = new JMenuItem("医生管理");
		menu_file.add(menuitem_doctor);
		menuitem_doctor.addActionListener(this);
		JMenuItem menuitem_cure = new JMenuItem("治疗管理");
		menu_file.add(menuitem_cure);
		menuitem_cure.addActionListener(this);
		JMenuItem menuitem_office = new JMenuItem("科室管理");
		menu_file.add(menuitem_office);
		menuitem_office.addActionListener(this);
		menu_file.addSeparator(); // 加分隔线

		JMenuItem menuitem_exit = new JMenuItem("退出系统");
		menu_file.add(menuitem_exit);
		menuitem_exit.addActionListener(this); // 为菜单项注册单击事件监听器
	}

	public void actionPerformed(ActionEvent e) { // 单击事件处理程序
		if (e.getSource() instanceof JMenuItem) {

			if (e.getActionCommand() == "退出系统") { // 不能用switch(int)语句
				if (JOptionPane.showConfirmDialog(this, "终止当前程序运行？") == 0) {
					System.exit(0);
				}// 单击菜单项时结束程序
			}
			if (e.getActionCommand() == "药品管理") {
				Medicine value[]={new Medicine()};
				new MedicineJFrame(new MedicineJPanel(),value);
				this.hide();
			}
			if (e.getActionCommand() == "医生管理") {
				Doctor value[]={new Doctor()};
				new DoctorJFrame(new DoctorJPanel(),value);
				this.hide();
			}
			if (e.getActionCommand() == "治疗管理") {
				Cure value[]={new Cure()};
				new CureJFrame(new CureJPanel(),value);
				this.hide();
				}
			if (e.getActionCommand() == "科室管理") {
				Office value[]={new Office()};
				new OfficeJFrame(new OfficeJPanel(),value);
				 this.hide();
			}
		}

	}

	public void initial() {
		this.setTitle("医院管理系统");
		this.setSize(900, 650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(this);
		Container c = this.getContentPane();
		c.setLayout(null);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainJFrame();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

