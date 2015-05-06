package cn.lntu.t25;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LojinIn extends JFrame {

	/**
	 * 登录界面，选择登录身份
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jzhanghao, jpassword, jlabel,jlabel2;
	private JButton jlogin;
	private JTextField jt1;
	private JPasswordField jp;
	private  JComboBox<String>  combox;
	private String choose,password;
	private int id;
	private String [] item={"管理员","企业","学生"};
	
	public LojinIn() {
		create();
		addListener();

	}

	private void addListener() {
		
		jt1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent key) {
				int keytype = key.getKeyCode();
				if (keytype == KeyEvent.VK_DOWN) {
					jp.requestFocusInWindow();
				}
			}

		});
		jt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jt1) {
					jp.requestFocus(true);
				}

			}

		});
		jp.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent key) {
				int keytype = key.getKeyCode();
				if (keytype == KeyEvent.VK_UP) {
					jt1.requestFocusInWindow();
				}

			}

		});
		jp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == jp) {
					jlogin.requestFocus(true);
				}
			}
		});
		jlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					login();
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			}
		});
		jlogin.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent key) {
				int keytype = key.getKeyCode();
				if (keytype == KeyEvent.VK_ENTER) {
				try {
					login();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				}		
				}
		});
		combox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				choose=(String) arg0.getItem();
			}});
	}

	private void create() {
		
		
		Container content = getContentPane();
		Color color=new Color(120,200,78);
		content.setBackground(color);
		
		content.setLayout(null);
		this.setTitle("就业管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(500, 350);
		setVisible(true);
		this.setLocation((dim.width - this.getWidth()) / 2,
				(dim.height - this.getHeight()) / 2);
		
		jlabel = new JLabel(new ImageIcon(getClass().getResource(
				"welcome.jpg")));
		jlabel.setBounds(40, 5, 400, 100);
		jlabel.setFocusable(true);
		jlabel.setForeground(Color.red);
		jlabel.setHorizontalTextPosition(JLabel.CENTER);
		jlabel.setHorizontalAlignment(JLabel.CENTER);
		jlabel.setFont(new Font("Serif", Font.BOLD, 20));
		content.add(jlabel);

		jzhanghao = new JLabel("账    号");
		jzhanghao.setBounds(5, 120, 80, 40);
		jzhanghao.setHorizontalAlignment(JLabel.RIGHT);
		content.add(jzhanghao);

		jpassword = new JLabel("密    码");
		jpassword.setBounds(5, 165, 80, 40);
		jpassword.setHorizontalAlignment(JLabel.RIGHT);
		content.add(jpassword);

		jt1 = new JTextField();
		jt1.setBounds(200, 120, 200, 40);
		jt1.setBorder(BorderFactory.createEtchedBorder());
		jt1.requestFocus(true);
		
		content.add(jt1);
		

		jp = new JPasswordField();
		jp.setBounds(200, 165, 200, 40);
		jp.setBorder(BorderFactory.createEtchedBorder());
		
		content.add(jp);

		jlogin = new JButton("login");
		jlogin.setBounds(300, 250, 80, 40);
		jlogin.setBackground(Color.red);
		jlogin.setBorder(BorderFactory.createRaisedBevelBorder());

		content.add(jlogin);
		
	    jlabel2=new JLabel("登录身份");
	    jlabel2.setBounds(20, 250, 80, 40);
	    content.add(jlabel2);
	
		combox=new JComboBox<String>(item);
		combox.setBounds(100, 250, 60, 40);
	    content.add(combox);
	    combox.setSelectedIndex(0);
	    choose=(String) combox.getSelectedItem();
		repaint();
	}

	
	
	
	public  void  login() throws SQLException {
		if(jt1.getText().equals("")||jp.getPassword().equals(""))
			JOptionPane.showMessageDialog(this, "请输入信息");
		else{
		  id=Integer.parseInt(jt1.getText().trim());
		  password=String.valueOf(jp.getPassword());
		  
		  //管理员登录处理
		  if(choose==item[0]){
			
			 AdminUserService service=new AdminUserService();
			 AdminUser user= service.queryUser(id);
			 if(user.getId()==0){
				 JOptionPane.showMessageDialog(this, "用户名不存在"); 
				 jt1.setText("");
			      jp.setText("");
			 }
			 else {if(user.getPassword().equals(password)){
			        new SchoolAdminClient(id,password);
			       this.dispose(); }
		         else{
			     JOptionPane.showMessageDialog(this, "密码错误");
			     jt1.setText("");
			      jp.setText(""); } }}  
		  //企业端处理
		  if(choose==item[1]){
			EnterUserService service=new EnterUserService();
				 EnterUser user= service.queryUser(id);
				 if(user.getId()==0){
					 JOptionPane.showMessageDialog(this, "用户名不存在"); 
					 jt1.setText("");
				      jp.setText("");
				 }
				 else{ if(user.getPassword().equals(password)){
			      new EnterpriseClient(id,password);
			       this.dispose(); }
		 else{
			 JOptionPane.showMessageDialog(this, "密码错误");
			 jt1.setText("");
			 jp.setText("");}    }	}
		  
		//学生端处理
			if(choose==item[2]){ 
				StuUserService service=new StuUserService();
				 StuUser user= service.queryUser(id);
				 if(user.getId()==0){
					 JOptionPane.showMessageDialog(this, "用户名不存在"); 
					 jt1.setText("");
				      jp.setText("");
				 }
				 else{if(user.getPassword().equals(password)){ 
				 new StudentClient(id,password);
				 this.dispose();
			 }
			 else{
				 JOptionPane.showMessageDialog(this, "密码错误");
				 jt1.setText("");
				 jp.setText("");
				 
			 } 		
			}		}	}
	}
	
	public static void main(String[] args) {
		new LojinIn();

	}

}