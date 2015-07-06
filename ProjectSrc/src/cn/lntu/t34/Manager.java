package bookmanage;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class Manager extends JFrame implements ActionListener{

	private static Object add;
	private String managerCode,managerName,managerPaswd,managerPhone,managerRoot;
	JTextField tf1,tf2,tf3,tf4,tf5;
	private String rootStr[] = {"1","2","3"};
	private String adminName=null;
	private int root;
	
	JComboBox jc;
	JTable table;
	JButton button1,button2,button3,button4;
	
	Connection  conn=null;
	Statement stmt=null;
	ResultSet rst=null;
	ResultSet rs=null;
	
	Object [][] tableData=new Object[50][5];
	int row = -1;
	
	public Manager(String name, int root){
		super("管理员信息中心,本次操作是:"+name);
		this.adminName=name;
		this.root=root;
		Container content = this.getContentPane();
		JLabel label;
//		label.setBackground(Color.white);        //背景色
//	    label.setFont(new java.awt.Font("Dialog", 1, 18));    //18代表字号，其他查一下api
//	    label.setForeground(Color.red);       //前景颜色，就是文字颜色了
//	    
		//用户Id板块
		label = new JLabel("用户号 :");
		label.setBounds(80, 20, 50, 25);
		label.setBackground(Color.white);        //背景色
	    label.setFont(new java.awt.Font("Dialog", 1, 13));    //18代表字号，其他查一下api
	    label.setForeground(Color.blue);   //前景颜色，就是文字颜色了
	    this.add(label);
	    tf1 = new JTextField();
	    tf1.setBounds(140,20,150,25);
	    tf1.addFocusListener(new FocusL());
	    this.add(tf1);
	    
	    //用户名板块
	    label = new JLabel("用户名 :");
	    label.setBounds(310,20,50,25);
	    label.setBackground(Color.white);        //背景色
	    label.setFont(new java.awt.Font("Dialog", 1, 13));    //18代表字号，其他查一下api
	    label.setForeground(Color.blue);   //前景颜色，就是文字颜色了
	    this.add(label);
	    tf2 = new JTextField();
	    tf2.setBounds(370,20,150,25);
	    tf2.addFocusListener(new FocusM());
	    this.add(tf2);
	    
	    //密码板块
	    label = new JLabel("密    码:");
	    label.setHorizontalAlignment(SwingConstants.RIGHT);
	    label.setBounds(80, 50, 50, 25);
	    label.setBackground(Color.white);        //背景色
	    label.setFont(new java.awt.Font("Dialog", 1, 13));    //18代表字号，其他查一下api
	    label.setForeground(Color.blue);   //前景颜色，就是文字颜色了
	    this.add(label);
	    tf3 = new JTextField();
	    tf3.setBounds(140,50,150,25);
	    this.add(tf3);
	    //联系方式板块
	    label = new JLabel("联系方式:");
	    label.setHorizontalAlignment(SwingConstants.RIGHT);
	    label.setBounds(300, 50, 60, 25);
	    label.setBackground(Color.white);        //背景色
	    label.setFont(new java.awt.Font("Dialog", 1, 13));    //18代表字号，其他查一下api
	    label.setForeground(Color.blue);   //前景颜色，就是文字颜色了
	    this.add(label);
	    tf4 = new JTextField();
	    tf4.setBounds(370,50,150,25);
	    this.add(tf4);
	    
	    //权限级别板块
	    label = new JLabel("权    限:");
	    label.setHorizontalAlignment(SwingConstants.RIGHT);
	    label.setBounds(310, 80, 50, 25);
	    label.setBackground(Color.white);        //背景色
	    label.setFont(new java.awt.Font("Dialog", 1, 13));    //18代表字号，其他查一下api
	    label.setForeground(Color.blue);   //前景颜色，就是文字颜色了
	    this.add(label);
	    jc = new JComboBox(rootStr);
	    jc.setBounds(370, 80, 100, 25);
	    jc.setEditable(true);
	    JTextField defaultRoot=(JTextField)(jc.getEditor().getEditorComponent());//获得textfield
	    defaultRoot.setText("默认权限是:1");     //设置默认权限为 2                                      
	    this.add(jc);
	    
	    //警告提示板块模块
	    label = new JLabel("警告提示:操作前确定周围是否有无关的人员！");
	    label.setHorizontalAlignment(SwingConstants.RIGHT);
	    label.setBounds(10, 80, 290, 25);
	    label.setBackground(Color.white);        //背景色
	    label.setFont(new java.awt.Font("Dialog", 1, 13));    //18代表字号，其他查一下api
	    label.setForeground(Color.red);   //前景颜色，就是文字颜色了
	    this.add(label);
	    //表格板块
	    if(conn==null) conn=ConnectDataBase.getConn();
	    String sql="select * from administrator order by Aid desc";
	    try{
	  		  stmt=conn.createStatement();
	          rst=stmt.executeQuery(sql);
	          int i=0;
	          while(rst.next()&&i<15)
			    
			    {	
			      
				  tableData[i][0]=rst.getString(2);
				  tableData[i][1]=rst.getString(3);
				  tableData[i][2]=rst.getString(4);
				  tableData[i][3]=rst.getString(5);
				  tableData[i][4]=rst.getString(6);
								 
			      i++;
			    }
	    }catch(Exception e){e.printStackTrace();}
//	    for(int i = 0; i < tableData.length; i++)
//			for(int j = 0; j < tableData[i].length; j++)
//				tableData[i][j]="\0";
	    String[] ColumnName={"用户号","用户名","用户密码","联系方式","权限"};
	    table = new JTable(tableData, ColumnName);
	    JScrollPane js = new JScrollPane(table);
	    js.setBounds(50, 120, 500, 180);
	    this.add(js);
	    //单击表格事件
	    table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row=table.getSelectedRow();
				
				managerCode=(String) table.getValueAt(row,0);
				managerName=(String) table.getValueAt(row,1);
				managerPaswd=(String) table.getValueAt(row,2);
				managerPhone=(String) table.getValueAt(row,3);
				managerRoot=(String) table.getValueAt(row,4);
				
				tf1.setText(managerCode);tf2.setText(managerName);
				tf3.setText(managerPaswd);tf4.setText(managerPhone);
				JTextField defaultRoot=(JTextField)(jc.getEditor().getEditorComponent());//获得textfield
			    defaultRoot.setText(managerRoot);
			    
			}

			
		});
	    
	    //按钮的添加
	    button1 = new JButton("添  加");
	    button2 = new JButton("修  改");
	    button3 = new JButton("删  除");
	    button4 = new JButton("退  出");
	    button1.setBounds(80, 315, 80, 30);
	    button2.setBounds(200, 315, 80, 30);
	    button3.setBounds(320, 315, 80, 30);
	    button4.setBounds(440, 315, 80, 30);
	    button1.addActionListener(this);
	    button2.addActionListener(this);
	    button3.addActionListener(this);
	    button4.addActionListener(this);
	    this.add(button1);this.add(button2);
	    this.add(button3);this.add(button4);
		
	    
	    
		this.setBounds(400,100,600,400);
	//	content.setBackground(new Color(80, 50, 90));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("退  出")) dispose();
		//数据的添加功能
		if(cmd.equals("添  加"))
		{
//			JOptionPane.showMessageDialog(this, "添加功能好使！");
			
			managerCode = tf1.getText();
			managerName = tf2.getText();
			managerPaswd = tf3.getText();
			managerPhone = tf4.getText();
			managerRoot = (String) jc.getSelectedItem();
			
			int rootNow = Integer.parseInt(managerRoot);
//			JOptionPane.showMessageDialog(this, managerRoot);
			String strSql = "insert into administrator(Acode,Aname,password,phone,root) values('"+managerCode
					        +"','"+managerName+"','"+managerPaswd+"','"+managerPhone+"',"+rootNow+");";
			
			if(conn==null) conn=ConnectDataBase.getConn(); 
			try{
				if(managerCode.length()>0 && managerName.length()>0 && managerPaswd.length()>0)
				{
					stmt = conn.createStatement();
					stmt.executeUpdate(strSql);
		  			JOptionPane.showMessageDialog(this, "信息添加成功！");
				}
			}
			catch (Exception ee){
				JOptionPane.showMessageDialog(this, "信息输入错误,请检查后在输入！");
				ee.printStackTrace();
			}
			String sqlSelect ="select * from administrator order by Aid desc;";
			try{
		  		
		  	    rst=stmt.executeQuery(sqlSelect);
	            int i=0;
	            while(rst.next()&&i<50)		    
			    {	
			      
				  tableData[i][0]=rst.getString(2);
				  tableData[i][1]=rst.getString(3);
				  tableData[i][2]=rst.getString(4);
				  tableData[i][3]=rst.getString(5);
				  tableData[i][4]=rst.getString(6);
				  
				 
			      i++;
			      row = i-1;
			    }
	            for(i=0;i< row;i++)
	            {
	            	for(int j=0;j<5;j++)
	            	{this.table.setValueAt(tableData[i][j], i, j);}
	            	
	            }
	        
			 }catch(Exception ex){ex.printStackTrace();}
		    
		}
		//修改功能
		if(cmd.equals("修  改"))
		{
//			JOptionPane.showMessageDialog(this, "修改功能好使！");
			String str1,str2,str3,str4,str5;
			str1 = tf1.getText();
			str2 = tf2.getText();
			str3 = tf3.getText();
			str4 = tf4.getText();
			str5 = (String) jc.getSelectedItem();
			int rootNow = Integer.parseInt(str5);
			
			String updateSql="update administrator set Acode='"+str1+"',Aname='"+
                        str2+"',password='"+str3+"',phone='"+str4+"',root='"+
            		    str5+"' where Acode='"+managerCode+"' and Aname='"+
            		    managerName+"' and password='"+managerPaswd+"' and phone='"+managerPhone+"' and root='"+
            		    managerRoot+"';";
			try{
            	if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
            	stmt=conn.createStatement();
            	stmt.executeUpdate(updateSql);
            	JOptionPane.showMessageDialog(this, "修改成功！");
            }
            catch (Exception e1)
            {e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "请检查后在输入！");
            }
			String sqlSelect ="select * from administrator order by Aid desc;";
			try{
		  		
		  	    rst=stmt.executeQuery(sqlSelect);
	            int i=0;
	            while(rst.next()&&i<50)		    
			    {	
			      
				  tableData[i][0]=rst.getString(2);
				  tableData[i][1]=rst.getString(3);
				  tableData[i][2]=rst.getString(4);
				  tableData[i][3]=rst.getString(5);
				  tableData[i][4]=rst.getString(6);
				  
				 
			      i++;
			      row = i-1;
			    }
	            for(;i<50;i++)
	            	for(int j=0;j<5;j++)
	            		this.tableData[i][j]="\0";
	            for(i=0;i< 50;i++)
	            {
	            	for(int j=0;j<5;j++)
	            	{this.table.setValueAt(tableData[i][j], i, j);}
	            	
	            }
	        
			 }catch(Exception ex){ex.printStackTrace();}
		    			
		}
		//删除功能
		if(cmd.equals("删  除"))
		{
	//		JOptionPane.showMessageDialog(this, "删除功能好使！");
			managerCode = tf1.getText();
			managerName = tf2.getText();
			managerPaswd = tf3.getText();
			managerPhone = tf4.getText();
			managerRoot = (String) jc.getSelectedItem();
			int rootNow = Integer.parseInt(managerRoot);
			
			
			String deleteSql="delete from administrator where Acode='"+managerCode+"' or Aname='"
			                  +managerName+"';";
			if(conn==null) conn=ConnectDataBase.getConn();
			try{
				if(managerCode.length()>0 && managerName.length()>0)
				{
					stmt = conn.createStatement();
					stmt.executeUpdate(deleteSql);
					JOptionPane.showMessageDialog(this, "删除信息成功！");
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "删除失败,请检查后再删除！");
			}
			String sqlSelect ="select * from administrator order by Aid desc;";
			try{
		  		
		  	    rst=stmt.executeQuery(sqlSelect);
	            int i=0;
	            while(rst.next()&&i<50)		    
			    {	
			      
				  tableData[i][0]=rst.getString(2);
				  tableData[i][1]=rst.getString(3);
				  tableData[i][2]=rst.getString(4);
				  tableData[i][3]=rst.getString(5);
				  tableData[i][4]=rst.getString(6);
				  
				 
			      i++;
			      row = i-1;
			    }
	            for(;i<50;i++)
	            	for(int j=0;j<5;j++)
	            		this.tableData[i][j]="\0";
	            for(i=0;i< 50;i++)
	            {
	            	for(int j=0;j<5;j++)
	            	{this.table.setValueAt(tableData[i][j], i, j);}
	            	
	            }
	        
			 }catch(Exception ex){ex.printStackTrace();}
		    
		}
	}
	//实现用户证号的监听事件
	class FocusL implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			managerCode = tf1.getText();
			if(managerCode.length()>0 && managerCode.length()<16){
					String strSql="select * from administrator where Acode='"+managerCode+"';";
					if(conn==null) conn=ConnectDataBase.getConn();
					try{
						stmt=conn.createStatement();
				        rs=stmt.executeQuery(strSql);

				        if(rs.next())				        	
				        	{
					        	JOptionPane.showMessageDialog(Manager.this, "已有证号，请重新输入！");
					        	tf1.grabFocus();
				        	}
				    
					}catch(Exception ee){
						ee.printStackTrace();
				//		JOptionPane.showMessageDialog(Manager.this, "您的输入有误，请重新输入！");
						}
				}
			  if(managerCode.length()>15)
				{
				  JOptionPane.showMessageDialog(Manager.this, "您的输入有误，请重新输入！");
				  tf1.grabFocus();
				}
		 }
		
		    
	}
	//为用户名添加监听事件
	class FocusM implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			managerName = tf2.getText();
			if(managerName.length()>0 && managerName.length()<21){
				String strSql="select * from administrator where Aname='"+managerName+"';";
				if(conn==null) conn=ConnectDataBase.getConn();
				try{
					
					stmt=conn.createStatement();
					ResultSet result=stmt.executeQuery(strSql);

			        if(result.next())				        	
			        	{
				        	JOptionPane.showMessageDialog(Manager.this, "已有用户名，请重新输入！");
				        	tf2.grabFocus();
			        	}
			    
				}catch(Exception ee){
					ee.printStackTrace();
			//		JOptionPane.showMessageDialog(Manager.this, "您的输入有误，请重新输入！");
					}
			}
		  if(managerName.length()>20)
			{
			  JOptionPane.showMessageDialog(Manager.this, "您的输入太长，请重新输入！");
			  tf2.grabFocus();
			}
	 }
	
		    
	}
	
	public static void main(String [] args){
		new Manager("admin",1);
	}

}
