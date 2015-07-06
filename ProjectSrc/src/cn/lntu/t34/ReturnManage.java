package bookmanage;
import java.util.Calendar;
import java.util.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.Locale;

public class ReturnManage extends JFrame implements ActionListener{
	private String uname,bcode,bname,bdate,cdate,rdate,cmoney,amoney,change;  //存放 用户名，图书编号，图书名
	                     //借书、应还、实还日期，应缴纳、实给、找零金额
	Connection  conn=null;
	Statement stmt,stmt1;
	ResultSet rst=null,conn1=null;
	ResultSet rs=null;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	Object [][] tableData = new Object[10][5];
	JPanel panel3,panel1,panel2;
	JTable table=null;
	double money = 0.0;
	double changes=0.0;
	int row=-1;
	Chooser ser;
	NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
		
	public ReturnManage(){
		super("还书中心");
		
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(4,5));
		JLabel label1=new JLabel("图书编号:",SwingConstants.CENTER);
		tf1=new JTextField();
		tf1.addActionListener(this);
		panel1.add(label1);panel1.add(tf1);
		
	    label1=new JLabel("借阅证号:",SwingConstants.CENTER);
	    tf2=new JTextField();	    
		panel1.add(label1);panel1.add(tf2);
		label1=new JLabel("图书名称:",SwingConstants.CENTER);
		tf3=new JTextField();
		panel1.add(label1);panel1.add(tf3);
		label1=new JLabel("应还日期:",SwingConstants.CENTER);
		tf4=new JTextField();
		panel1.add(label1);panel1.add(tf4);
		label1=new JLabel("实还日期:",SwingConstants.CENTER);
		tf5=new JTextField();
		Date date=new Date();
        String dateFormatStr="yyyy年MM月dd日  E";
        String dateStr="yyyy-MM-dd";
        SimpleDateFormat simpleFormat=new SimpleDateFormat(dateFormatStr);
        SimpleDateFormat simpleformat=new SimpleDateFormat(dateStr);
        tf5.setText(simpleformat.format(date));
        ser=Chooser.getInstance();
        ser.register(tf5);
		panel1.add(label1);panel1.add(tf5);
		label1=new JLabel("罚款金额:",SwingConstants.CENTER);
		tf6=new JTextField();
		tf6.setText(numberFormat.format(money));
		panel1.add(label1);panel1.add(tf6);
		label1=new JLabel("实收金额:",SwingConstants.CENTER);
		tf7=new JTextField();		
		cmoney = numberFormat.format(money);
		tf7.setText(cmoney);
		tf7.addActionListener(this);
		panel1.add(label1);panel1.add(tf7);
		label1=new JLabel("找        零:",SwingConstants.CENTER);
		tf8=new JTextField();
		change = numberFormat.format(money);
		tf8.setText(change);
		panel1.add(label1);panel1.add(tf8);
		
		panel2 = new JPanel();
		JButton b1 = new JButton("还    书"); b1.addActionListener(this);
		JButton b2 = new JButton("退    出"); b2.addActionListener(this);
		JLabel separate = new JLabel("                             ");
		panel2.add(b1);panel2.add(separate);panel2.add(b2);
		
		panel3 = new JPanel();
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 5; j++)
				tableData[i][j]=null;
		String[] name={"借阅证号","图书名称","图书编号","借书日期","还书日期"};
		table=new JTable(tableData,name);
		table.setBounds(20,300,570,150);
		panel3.add(new JScrollPane(table));
		
		
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
		
		if(cmd.equals("还    书")){}
		if(e.getSource()==tf1)
		{

			
			bcode = tf1.getText();
			
			String selectSql="select * from bookinfo where Bcode ='"+bcode+"';";
			String selectBorrow="select * from borrow where Bid='"+bcode+"';";
			if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
	
			try {
		  		stmt=conn.createStatement();
		  		rs=stmt.executeQuery(selectSql);
		  		if(rs.next())
		  			{
		  			tf3.setText(rs.getString(3));
		  	//		JOptionPane.showMessageDialog(this, rs.getString(3));
		  			}
		  		rst=stmt.executeQuery(selectBorrow);
		  		if(rst.next()){
		  			tf2.setText(rst.getString(2));
		  			bdate=rst.getString(3);
		 			cdate=tf5.getText();
		  			String dateStr="yyyy-MM-dd";		         
				      SimpleDateFormat simpleformat=new SimpleDateFormat(dateStr);			    	
				      Calendar cal=Calendar.getInstance();
				      Calendar call=Calendar.getInstance();
				      Date date60=null;
				      cal.setTime(DateTest.StrToDate((bdate)));
					     cal.add(Calendar.DAY_OF_MONTH, 60);
					     date60=cal.getTime();
					     tf4.setText(simpleformat.format(date60));
		  		
					tf7.grabFocus();
		  			tf7.setText(null);
		  			amoney=tf7.getText();
				  call.setTime(DateTest.StrToDate(cdate));
		  		  long milliseconds1 = cal.getTimeInMillis();
		  	      long milliseconds2 = call.getTimeInMillis();
		  	      long diff = milliseconds2 - milliseconds1;
		  	      long diffDays = diff / (24 * 60 * 60 * 1000);
		  	      double count=diffDays*0.3;
		  		  if(count>0)
			  			{//JOptionPane.showMessageDialog(this, count);
		  		         tf6.setText(numberFormat.format(count));
				  	changes=count;
		  			
		  			}
		  		  else tf6.setText(numberFormat.format(money));
		  		}
		  		
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(ReturnManage.this, "图书编号重复,请检查后在输入！");
				e1.printStackTrace();
			}
		
		}
		if(e.getSource()==tf7)
		{
			amoney=tf7.getText();
			JOptionPane.showMessageDialog(this, "dhjkifohd");
		  	double moneys=Double.parseDouble(amoney);
		  	changes=moneys-changes;
		  	JOptionPane.showMessageDialog(this, moneys);
		  	tf8.setText(Double.toString(changes));
		}
	}
	
	
		
	
	
	public static void main(String [] args){
		new ReturnManage();
	}

}
