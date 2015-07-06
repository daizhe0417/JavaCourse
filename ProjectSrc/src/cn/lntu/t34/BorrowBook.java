package bookmanage;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.sql.*;
import java.util.Locale;

import javax.swing.text.Document;  
import javax.swing.event.DocumentListener;  
import javax.swing.event.DocumentEvent;  

public class BorrowBook extends JFrame implements ActionListener{
	private String uname,bcode,bdate,rdate,bname,count;
	Connection  conn=null;
	Statement stmt=null,stm=null;
	ResultSet rst=null;
	ResultSet rs=null;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	Object [][] tableData = new Object[10][5];
	JPanel panel3,panel1,panel2;
	JTable table=null;
	int row=-1;
	int isSuccess=0;
	 
	public BorrowBook(){
		super("借书中心");
		
		Chooser ser = Chooser.getInstance();
		Chooser ser1= Chooser.getInstance();
		panel1=new JPanel();
		panel1.setBackground(Color.BLUE);
		panel1.setLayout(new GridLayout(3,5));
		JLabel label1=new JLabel("借阅证号:",SwingConstants.CENTER);
		tf1=new JTextField();
		tf1.addFocusListener(new FocusL());
		panel1.add(label1);panel1.add(tf1);
		
	    label1=new JLabel("图书编号:",SwingConstants.CENTER);
	    tf2=new JTextField();
	    tf2.addFocusListener(new Focus2());
		panel1.add(label1);panel1.add(tf2);
		label1=new JLabel("图书名称:",SwingConstants.CENTER);
		tf3=new JTextField();
		panel1.add(label1);panel1.add(tf3);
		label1=new JLabel("借书日期:",SwingConstants.CENTER);
		tf4=new JTextField();
		tf4.addFocusListener(new DateChangeA());
		Date date=new Date();
        String dateFormatStr="yyyy年MM月dd日  E";
        String dateStr="yyyy-MM-dd";
        SimpleDateFormat simpleFormat=new SimpleDateFormat(dateFormatStr);
        SimpleDateFormat simpleformat=new SimpleDateFormat(dateStr);
        tf4.setText(simpleFormat.format(date));
        bdate=tf4.getText();
        ser.register(tf4);
        
      
        
    //    tf4.addActionListener(new DateChange());
		panel1.add(label1);panel1.add(tf4);
		label1=new JLabel("还书日期:",SwingConstants.CENTER);
//		tf6=new JTextField();
		Calendar cal=Calendar.getInstance();
	    cal.add(Calendar.DAY_OF_MONTH, 60);
        Date date60=cal.getTime();
        tf5 = new JTextField();
        ser1.register(tf5);
        tf5.setText(simpleformat.format(date60));
		panel1.add(label1);panel1.add(tf5);
		
		label1 = new JLabel("可借次数:",SwingConstants.CENTER);
		tf6 = new JTextField();
		panel1.add(label1);panel1.add(tf6);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		JButton b1 = new JButton("借    书"); b1.addActionListener(this);
		JButton b2 = new JButton("退    出"); b2.addActionListener(this);
		JLabel separate = new JLabel("                             ");
		panel2.add(b1);panel2.add(separate);panel2.add(b2);
		
		panel3 = new JPanel();
		panel3.setBackground(Color.GREEN);
		
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 5; j++)
				tableData[i][j]="\0";
		String[] name={"借阅证号","图书名称","图书编号","借书日期","还书日期"};
		table=new JTable(tableData,name);
		JScrollPane js = new JScrollPane(table);
	//	panel3.setBounds(10,10,470,330);
	//	panel3.add(new JScrollPane(table));
		panel3.add(js);
		Document doc = tf4.getDocument(); 
        doc.addDocumentListener(new TextChangeEvent(tf4,tf6));  
		
		
		this.setLayout(new BorderLayout());
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.SOUTH);
		this.add(panel3,BorderLayout.CENTER);
		this.setBackground(Color.GREEN);
		setBounds(300,200,570,350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd=e.getActionCommand();
		if(cmd.equals("退    出"))dispose();
		//借书按钮
		if(cmd.equals("借    书")){
			uname = tf1.getText();
			bcode = tf2.getText();
			bdate = tf4.getText();
			count = tf6.getText();
			row = Integer.parseInt(count);
			
			Date date=new Date();
			String dateStr="yyyy-MM-dd";
	        SimpleDateFormat simpleformat=new SimpleDateFormat(dateStr);
			if(bdate.length()>10)
				bdate = simpleformat.format(date);
			
			String sql="insert into borrow(Bid, Uid, bdate) values('"+bcode+"','"+uname+"','"+bdate+"');";
	//		JOptionPane.showMessageDialog(BorrowBook.this, "图书借出成功！");
			if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
			if(row > 0)
			{
				 try {
				  		stmt=conn.createStatement();
				  		if(bcode.length()==0||uname.length()==0)
				  			{
				  		      JOptionPane.showMessageDialog(this, "请输入完整信息！");
				  		      isSuccess=0;
				  		      tf1.grabFocus();
				  		     }
				  		else
				  		{stmt.executeUpdate(sql);			  		
				  		JOptionPane.showMessageDialog(this, "图书借阅成功！");
				  		count = tf6.getText();
				  		tf6.setText(Integer.toString(Integer.parseInt(count)));
				  		isSuccess=1;
				  		}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, "该书已被借出！");
						tf2.grabFocus();
						e1.printStackTrace();
					}
				 if(1==isSuccess)
				 {
			    	 tableData[row][0] = tf1.getText();
				     tableData[row][1] = tf3.getText();
			     	 tableData[row][2] = tf2.getText();
				     tableData[row][3] = tf4.getText();
				     tableData[row][4] = tf5.getText();
				     for(int j=0; j<5; j++)
					    this.table.setValueAt(tableData[row][j], row, j);
				
				     row++;
				 }
			}
			
			else 
				JOptionPane.showMessageDialog(this, "您的借书次数已满！");
		}
	}
	
	class FocusL implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			uname = tf1.getText();
			if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
			String sql="select * from borrow where Uid='"+uname+"';";
			
			try{
				stmt=conn.createStatement();
				stm=conn.createStatement();
				 rst=stmt.executeQuery(sql);
		          int i=0,j=0;
		          String str1;
		          
		          String dateStr="yyyy-MM-dd";		         
			      SimpleDateFormat simpleformat=new SimpleDateFormat(dateStr);			    	
			      Calendar cal=Calendar.getInstance();
			      Date date60=null;
			      
		          while(rst.next()&&i<10)
				    
				    {	
				      
					  tableData[i][2]=rst.getString(1);
					  tableData[i][0]=rst.getString(2);
					  tableData[i][3]=rst.getString(3);
		          					 
					  str1="select bname from bookinfo where bcode='"+tableData[i][2]+"';";
					  rs=stm.executeQuery(str1);
					  if(rs.next())
					  tableData[i][1]=rs.getString(1);						  
					  tableData[i][4]=tf5.getText();
		          		         		             
		             cal.setTime(DateTest.StrToDate((String)tableData[i][3]));
				     cal.add(Calendar.DAY_OF_MONTH, 60);
				     date60=cal.getTime();
				     tableData[i][4]=simpleformat.format(date60);
				     
				     i++;
		             row=i;
				    }
		          tf6.setText(Integer.toString(10-row));
		          if(tableData[0][0].equals("\0")&&!tableData[0][0].equals(null))
		          {JOptionPane.showMessageDialog(BorrowBook.this, "输入有误，请重新输入！");
		        	 
		          if(!tableData[0][0].equals("\0"))		        	  
		          { 
		             tf1.grabFocus();
		          }tf1.setText(null);
		          }
		          
			     
		          
		          for(i=0;i<row;i++)
	                {
	                	for(j=0;j<5;j++)
	                	{BorrowBook.this.table.setValueAt(tableData[i][j], i, j);}
	                	
	                }
			}
			catch (Exception ee){
				ee.printStackTrace();
				try {
					if(rst.getRow()==0)
					JOptionPane.showMessageDialog(BorrowBook.this, "证件号码有误！");
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	//对借书日期选着后及时更新还书日期，日期数是60天
	class DateChangeA implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
		    bdate = tf4.getText();
		    if(bdate.length()<11)
		    {
		    	 
		        String dateStr="yyyy-MM-dd";		         
		        SimpleDateFormat simpleformat=new SimpleDateFormat(dateStr);
		    	
		    	Calendar cal=Calendar.getInstance();
		    	cal.setTime(DateTest.StrToDate(bdate));
		    	cal.add(Calendar.DAY_OF_MONTH, 60);
		    	Date date60=cal.getTime();

		    	tf5.setText(simpleformat.format(date60));
		    	
		    }
		}
		
	}
	
	class Focus2 implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			tf2.setText(null);
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			bcode = tf2.getText();
			String str = "select bname from bookinfo where bcode ='"+bcode+"';";
			try {
		  		stmt=conn.createStatement();
		  		rs=stmt.executeQuery(str);
		  		
		  		if(rs.next())
		  			tf3.setText( rs.getString(1));
		  		
		  		
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(BorrowBook.this, "图书编号重复,请检查后在输入！");
				e1.printStackTrace();
			}
		}
		
	}
	
	public static void main(String [] args){
		new BorrowBook();
	}

	

}
