package cn.lntu.t22.studentmanager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class MainFrame extends JFrame{
	JPanel contentPane;
	 String level;
	 static String name;
	 ImageIcon snow = new ImageIcon("image/1.jpg");
	 JLabel jLabel1 = new JLabel();
	 JLabel jLabel2 = new JLabel();
	 JLabel jLabel3 = new JLabel();
	 JLabel jLabel4 = new JLabel();
	 JMenuBar jMenuBar1 = new JMenuBar();
	 JMenu jMenu1 = new JMenu();
	 JMenu jMenu2 = new JMenu();
	 JMenuItem jMenuItem4 = new JMenuItem();
	 JMenuItem jMenuItem5 = new JMenuItem();
	 JMenu jMenu3 = new JMenu();
	 JMenuItem jMenuItem7 = new JMenuItem();
	 JMenuItem jMenuItem8 = new JMenuItem();
	 JMenuItem jMenuItem9 = new JMenuItem();
	 JMenu jMenu4 = new JMenu();
	 JMenuItem jMenuItem10 = new JMenuItem();
	 JMenuItem jMenuItem11 = new JMenuItem();
	 JMenuItem jMenuItem12 = new JMenuItem();
	 JMenu jMenu5 = new JMenu();
	 JMenuItem jMenuItem13 = new JMenuItem();
	 JMenu jMenu6 = new JMenu();
	 JMenuItem jMenuItem1 = new JMenuItem();
	 JMenuItem jMenuItem14 = new JMenuItem();
	 JMenuItem jMenuItem15 = new JMenuItem();
	 JMenu jMenu7 = new JMenu();
	 JMenuItem jMenuItem2 = new JMenuItem();
	 JMenuItem jMenuItem17 = new JMenuItem();
	 JMenuItem jMenuItem18 = new JMenuItem();
	 JPanel jPanel1 = new JPanel();
	 JLabel jLabel5 = new JLabel();
	 BorderLayout borderLayout1 = new BorderLayout();
	 JMenuItem jMenuItem19 = new JMenuItem();
	 String Sid, find;
	 public MainFrame(String level, String name) {
	 this.level = level;
	 this.name = name;
	 try {
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 jbInit();
	 } catch (Exception exception) {
	 exception.printStackTrace();
	 }
	 }
	 private void jbInit() throws Exception {
	 contentPane = (JPanel) getContentPane();
	 contentPane.setLayout(null);
	 this.setJMenuBar(jMenuBar1);
	 setSize(new Dimension(911, 698));
	 setTitle("欢迎登陆学生管理系统");
	 jLabel1.setText("欢 迎 您 使 用 学 生");
	 jLabel1.setBounds(new Rectangle(473, 66, 320, 33));
	 jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 30));
	 jLabel1.setForeground(Color.lightGray);
	 jLabel2.setFont(new java.awt.Font("Dialog", Font.BOLD, 30));
	 jLabel2.setText("欢 迎 您 使 用 学 生");
	 jLabel2.setBounds(new Rectangle(474, 67, 328, 33));
	 jLabel3.setFont(new java.awt.Font("Dialog", Font.BOLD, 30));
	 jLabel3.setText("管 理 系 统");
	 jLabel3.setBounds(new Rectangle(570, 135, 240, 33));
	 jLabel4.setFont(new java.awt.Font("Dialog", Font.BOLD, 30));
	 jLabel4.setForeground(Color.lightGray);
	 jLabel4.setText("管 理 系 统");
	 jLabel4.setBounds(new Rectangle(568, 136, 228, 33));
	 jMenu1.setText("学生信息管理");
	 jMenu2.setText("班级管理");
	 jMenuItem4.setText(" 录 入");
	 jMenuItem4.addActionListener(new
	MainFrame_jMenuItem4_actionAdapter(this));
	 jMenuItem5.setText(" 管 理");
	 jMenuItem5.addActionListener(new
	MainFrame_jMenuItem5_actionAdapter(this));
	 jMenu3.setText("课程管理");
	 jMenuItem7.setText(" 录 入");
	 jMenuItem7.addActionListener(new
	MainFrame_jMenuItem7_actionAdapter(this));
	 jMenuItem8.setText(" 修 改");
	 jMenuItem8.addActionListener(new
	MainFrame_jMenuItem8_actionAdapter(this));
	 jMenuItem9.setText(" 查 询");
	 jMenuItem9.addActionListener(new
			 MainFrame_jMenuItem9_actionAdapter(this));
	 jMenu4.setText("用户管理");
	 jMenuItem10.setText(" 注 册");
	 jMenuItem10.addActionListener(new
	MainFrame_jMenuItem10_actionAdapter(this));
	 jMenuItem11.setText("修改密码");
	 jMenuItem11.addActionListener(new
	MainFrame_jMenuItem11_actionAdapter(this));
	 jMenuItem12.setEnabled(true);
	 jMenuItem12.setText("删除用户");
	 jMenu5.setText("退出");
	 jMenuItem13.setText(" 退 出");
	 jMenuItem13.addActionListener(new
	MainFrame_jMenuItem13_actionAdapter(this));
	 jMenu6.setText("学生信息");
	 jMenuItem1.setText(" 注 册");
	 jMenuItem1.addActionListener(new
	MainFrame_jMenuItem1_actionAdapter(this));
	 jMenuItem14.setText(" 管 理");
	 jMenuItem14.addActionListener(new
	MainFrame_jMenuItem14_actionAdapter(this));
	 jMenuItem15.setText(" 查 询");
	 jMenuItem15.addActionListener(new
	MainFrame_jMenuItem15_actionAdapter(this));
	 jMenu7.setText("选课信息");
	 jMenuItem2.setText(" 选 课");
	 jMenuItem2.addActionListener(new
	MainFrame_jMenuItem2_actionAdapter(this));
	 jMenuItem17.setText("课程查询");
	 jMenuItem18.setText("重新启动");
	 jMenuItem18.addActionListener(new
	MainFrame_jMenuItem18_actionAdapter(this));
	 jPanel1.setBounds(new Rectangle( -6, 0, 946, 771));
	 jPanel1.setLayout(borderLayout1);
	 jLabel5.setIcon(snow);
	 jMenuItem19.setText("更改权限");
	 jMenuItem19.addActionListener(new
	MainFrame_jMenuItem19_actionAdapter(this));
	 contentPane.add(jLabel2);
	 contentPane.add(jLabel3);
	 contentPane.add(jLabel4);
	 contentPane.add(jLabel1);
	 contentPane.add(jPanel1);
	 jPanel1.add(jLabel5, java.awt.BorderLayout.NORTH);
	 jMenuBar1.add(jMenu1);
	 jMenuBar1.add(jMenu2);
	 jMenuBar1.add(jMenu3);
	 jMenuBar1.add(jMenu4);
	 jMenuBar1.add(jMenu5);
	 jMenu1.add(jMenu6);
	 jMenu1.add(jMenu7);
	 jMenu2.add(jMenuItem4);
	 jMenu2.add(jMenuItem5);
	 jMenu3.add(jMenuItem7);
	 jMenu3.add(jMenuItem8);
	 jMenu3.add(jMenuItem9);
	 jMenu4.add(jMenuItem10);
	 jMenu4.add(jMenuItem11);
	 jMenu4.add(jMenuItem19);
	 jMenu4.add(jMenuItem12);
	 jMenu5.add(jMenuItem13);
	 jMenu5.add(jMenuItem18);
	 jMenu6.add(jMenuItem1);
	 jMenu6.add(jMenuItem14);
	 jMenu6.add(jMenuItem15);
	 jMenu7.add(jMenuItem2);
	 jMenu7.add(jMenuItem17);
	 if (level.equals("0")) {
	 this.jMenuItem1.setVisible(false);
	 this.jMenuItem14.setVisible(false);
	 this.jMenuItem12.setVisible(false);
	 this.jMenuItem5.setVisible(false);
	 this.jMenuItem7.setVisible(false);
	 this.jMenuItem8.setVisible(false);
	 this.jMenuItem10.setVisible(false);
	 this.jMenuItem19.setVisible(false);
	 }
	 if (level.equals("1")) {
	 this.jMenuItem2.setVisible(false);
	 this.jMenuItem10.setVisible(false);
	 this.jMenuItem9.setVisible(false);
	 }
	 }
	 public void jMenuItem13_actionPerfome(ActionEvent e) {
	 System.exit(0);
	 }
	 public void jMenuItem18_actionPerformed(ActionEvent e) {
	 this.dispose();
	 LoginFrame login = new LoginFrame();
	 login.setLocation(400, 200);
	 login.setSize(504, 344);
	 login.setVisible(true);
	 login.setResizable(false);
	 login.validate();
	 }
	 public void jMenuItem1_actionPerformed(ActionEvent e) {
	 StudentInfoAddFrame siadd = new StudentInfoAddFrame();
	 siadd.setLocation(400, 200);
	 siadd.setSize(592, 500);
	 siadd.setVisible(true);
	 siadd.setResizable(false);
	 siadd.validate();
	 }
	 public void jMenuItem14_actionPerformed(ActionEvent e) {
	 StudentUp siadd = new StudentUp(find);
	 siadd.setLocation(400, 200);
	 siadd.setSize(592, 500);
	 siadd.setVisible(true);
	 siadd.setResizable(false);
	 siadd.validate();
	 }
	 public void jMenuItem10_actionPerformed(ActionEvent e) {
	 AddAdminFrame siadd = new AddAdminFrame();
	 siadd.setLocation(400, 200);
	 siadd.setSize(469, 315);
	 siadd.setVisible(true);
	 siadd.setResizable(false);
	 siadd.validate();
	 }
	 public void jMenuItem11_actionPerformed(ActionEvent e) {
	 MAPasswordFrameFrame siadd = new
	MAPasswordFrameFrame(level, name);
	 siadd.setLocation(400, 200);
	 siadd.setSize(444, 340);
	 siadd.setVisible(true);
	 siadd.setResizable(false);
	 siadd.validate();
	 }
	 public void jMenuItem19_actionPerformed(ActionEvent e) {
	 QModifyFrame siadd = new QModifyFrame();
	 siadd.setLocation(400, 200);
	 siadd.setSize(434, 314);
	 siadd.setVisible(true);
	 siadd.setResizable(false);
	 siadd.validate();
	 }
	 public void jMenuItem7_actionPerformed(ActionEvent e) {
	 KeChengAddFrame siadd = new KeChengAddFrame();
	 siadd.setLocation(400, 200);
	 siadd.setSize(482, 320);
	 siadd.setVisible(true);
	 siadd.setResizable(false);
	 siadd.validate();
	 }
	 public void jMenuItem8_actionPerformed(ActionEvent e) {
	 KeChengManager siadd = new KeChengManager(find);
	 siadd.setLocation(400, 200);
	 siadd.setSize(500, 380);
	 siadd.setVisible(true);
	 siadd.setResizable(false);
	 siadd.validate();
	 }
	 public void jMenuItem4_actionPerformed(ActionEvent e) {
	 AddClassFrame siadd = new AddClassFrame();
	 siadd.setLocation(400, 200);
	 siadd.setSize(465, 310);
	 siadd.setVisible(true);
	 siadd.setResizable(false);
	 siadd.validate();
	 }public void jMenuItem5_actionPerformed(ActionEvent e) {
		 ClassManager siadd = new ClassManager();
		 siadd.setLocation(400, 200);
		 siadd.setSize(530, 560);
		 siadd.setVisible(true);
		 siadd.setResizable(false);
		 siadd.validate();
		 }
		 public void jMenuItem15_actionPerformed(ActionEvent e) {
		 StudentC siadd = new StudentC();
		 siadd.setLocation(220, 100);
		 siadd.setSize(800, 620);
		 siadd.setVisible(true);
		 siadd.setResizable(false);
		 siadd.validate();
		 }
		 public void jMenuItem2_actionPerformed(ActionEvent e) {
		 Choose siadd = new Choose(level, name);
		 siadd.setLocation(320, 100);
		 siadd.setSize(550, 620);
		 siadd.setVisible(true);
		 siadd.setResizable(false);
		 siadd.validate();
		 }
		 public void jMenuItem9_actionPerformed(ActionEvent e) {
		 KeChengF siadd = new KeChengF();
		 siadd.setLocation(320, 100);
		 siadd.setSize(550, 600);
		 siadd.setVisible(true);
		 siadd.setResizable(false);
		 siadd.validate();
		 }
}
class MainFrame_jMenuItem9_actionAdapter implements ActionListener {
 private MainFrame adaptee;
 MainFrame_jMenuItem9_actionAdapter(MainFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jMenuItem9_actionPerformed(e);
 }
}
class MainFrame_jMenuItem2_actionAdapter implements ActionListener {
 private MainFrame adaptee;
 MainFrame_jMenuItem2_actionAdapter(MainFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jMenuItem2_actionPerformed(e);
 }
}
class MainFrame_jMenuItem15_actionAdapter implements ActionListener {
 private MainFrame adaptee;
 MainFrame_jMenuItem15_actionAdapter(MainFrame adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jMenuItem15_actionPerformed(e);
 }
}
class MainFrame_jMenuItem5_actionAdapter implements ActionListener {
	 private MainFrame adaptee;
	 MainFrame_jMenuItem5_actionAdapter(MainFrame adaptee) {
	 this.adaptee = adaptee;
	 }
	 public void actionPerformed(ActionEvent e) {
	 adaptee.jMenuItem5_actionPerformed(e);
	 }
	}
	class MainFrame_jMenuItem4_actionAdapter implements ActionListener {
	 private MainFrame adaptee;
	 MainFrame_jMenuItem4_actionAdapter(MainFrame adaptee) {
	 this.adaptee = adaptee;
	 }
	 public void actionPerformed(ActionEvent e) {
	 adaptee.jMenuItem4_actionPerformed(e);
	 }
	}
	class MainFrame_jMenuItem8_actionAdapter implements ActionListener {
	 private MainFrame adaptee;
	 MainFrame_jMenuItem8_actionAdapter(MainFrame adaptee) {
	 this.adaptee = adaptee;
	 }
	 public void actionPerformed(ActionEvent e) {
	 adaptee.jMenuItem8_actionPerformed(e);
	 }
	}
	class MainFrame_jMenuItem7_actionAdapter implements ActionListener {
	 private MainFrame adaptee;
	 MainFrame_jMenuItem7_actionAdapter(MainFrame adaptee) {
		 this.adaptee = adaptee;
		 }
		 public void actionPerformed(ActionEvent e) {
		 adaptee.jMenuItem7_actionPerformed(e);
		 }
		}
		class MainFrame_jMenuItem19_actionAdapter implements ActionListener {
		 private MainFrame adaptee;
		 MainFrame_jMenuItem19_actionAdapter(MainFrame adaptee) {
		 this.adaptee = adaptee;
		 }
		 public void actionPerformed(ActionEvent e) {
		 adaptee.jMenuItem19_actionPerformed(e);
		 }
		}
		class MainFrame_jMenuItem10_actionAdapter implements ActionListener {
		 private MainFrame adaptee;
		 MainFrame_jMenuItem10_actionAdapter(MainFrame adaptee) {
		 this.adaptee = adaptee;
		 }
		 public void actionPerformed(ActionEvent e) {
		 adaptee.jMenuItem10_actionPerformed(e);
		 }
		}
		class MainFrame_jMenuItem11_actionAdapter implements ActionListener {
		 private MainFrame adaptee;
		 MainFrame_jMenuItem11_actionAdapter(MainFrame adaptee) {
			 this.adaptee = adaptee;
			 }
			 public void actionPerformed(ActionEvent e) {
			 adaptee.jMenuItem11_actionPerformed(e);
			 }
			}
			class MainFrame_jMenuItem13_actionAdapter implements ActionListener {
			 private MainFrame adaptee;
			 MainFrame_jMenuItem13_actionAdapter(MainFrame adaptee) {
			 this.adaptee = adaptee;
			 }
			 public void actionPerformed(ActionEvent e) {
			 adaptee.jMenuItem13_actionPerfome(e);
			 }
			}
			class MainFrame_jMenuItem14_actionAdapter implements ActionListener {
			 private MainFrame adaptee;
			 MainFrame_jMenuItem14_actionAdapter(MainFrame adaptee) {
			 this.adaptee = adaptee;
			 }
			 public void actionPerformed(ActionEvent e) {
			 adaptee.jMenuItem14_actionPerformed(e);
			 }
			}
			class MainFrame_jMenuItem1_actionAdapter implements ActionListener {
			 private MainFrame adaptee;
			 MainFrame_jMenuItem1_actionAdapter(MainFrame adaptee) {
				 this.adaptee = adaptee;
				 }
				 public void actionPerformed(ActionEvent e) {
				 adaptee.jMenuItem1_actionPerformed(e);
				 }
				}
				class MainFrame_jMenuItem18_actionAdapter implements ActionListener {
				 private MainFrame adaptee;
				 MainFrame_jMenuItem18_actionAdapter(MainFrame adaptee) {
				 this.adaptee = adaptee;
				 }
				 public void actionPerformed(ActionEvent e) {
				 adaptee.jMenuItem18_actionPerformed(e);
				 }
				}

	 

