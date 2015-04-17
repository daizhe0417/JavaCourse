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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jzhanghao, jpassword, jlabel,jlabel2;
	private JButton jlogin;
	private JTextField jt1;
	private JPasswordField jp;
	private  JComboBox<String>  combox;
	private String choose,password,paw;
	private int id;
	private String [] item={"管理员","企业","学生"};
	private PreparedStatement	mystate;
	private Connection myconn;
	public LojinIn() {
		create();

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
		jt1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent key) {
				int keytype = key.getKeyCode();
				if (keytype == KeyEvent.VK_DOWN) {
					jp.requestFocusInWindow();
				}
			}

		});
		content.add(jt1);
		jt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jt1) {
					jp.requestFocus(true);
				}

			}

		});

		jp = new JPasswordField();
		jp.setBounds(200, 165, 200, 40);
		jp.setBorder(BorderFactory.createEtchedBorder());
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
		content.add(jp);

		jlogin = new JButton("login");
		jlogin.setBounds(300, 250, 80, 40);
		jlogin.setBackground(Color.red);
		jlogin.setBorder(BorderFactory.createRaisedBevelBorder());

		content.add(jlogin);
		jlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					login();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}

			}
		});
	    jlabel2=new JLabel("登录身份");
	    jlabel2.setBounds(20, 250, 80, 40);
	    content.add(jlabel2);
	
		combox=new JComboBox<String>(item);
		combox.setBounds(100, 250, 60, 40);
	    content.add(combox);
	    combox.setSelectedIndex(0);
	    choose=(String) combox.getSelectedItem();
	   // combox.updateUI();
		combox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				choose=(String) arg0.getItem();
			}});

     
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
			 
			String sql="select * from admin_user where id=?";
		    this.validation(sql);
		 if(this.password==paw){
			 
			 new adminClient(id,password);
			 this.dispose();
		 }
		 else{
			 JOptionPane.showMessageDialog(this, "账号或密码错误");
			 jt1.setText("");
			 jp.setText("");
			 
		 }  
		  }
		  
		  
		  //企业端处理
		  if(choose==item[1]){
				 
			 
			  String sql="select * from enter_user where id=?";
			  this.validation(sql);
		 if(this.password==paw){
			 
			 new EnterpriseClient(id,password);
			 this.dispose();
		 }
		 else{
			 JOptionPane.showMessageDialog(this, "账号或密码错误");
			 jt1.setText("");
			 jp.setText("");
			 
		 }    
			  
		  }	
		  
		//学生端处理
			if(choose==item[2]){
				 
				 
				  String sql="select * from stu_user where id=?";
				  this.validation(sql);
			   if(this.password==paw){ 
				 new adminClient(id,password);
				 this.dispose();
			 }
			 else{
				 JOptionPane.showMessageDialog(this, "账号或密码错误");
				 jt1.setText("");
				 jp.setText("");
				 
			 } 		
			}		
		}	
	}
	
	
	
	public  void   validation(String sql)throws  SQLException{
		
	  try {
		myconn=MyConnection.getConnection();
		mystate=myconn.prepareStatement(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  mystate.setInt(1, id);
	  ResultSet  res=mystate.executeQuery();
	 while(res.next()){
		paw=res.getString("password");
		 
	 }
	 res.close();
	 mystate.close();
	 myconn.close();
	
	  }
		
	
	
	
	public static void main(String[] args) {
		new LojinIn();

	}

}