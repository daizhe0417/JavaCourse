package bookmanage;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BookManage extends JFrame/*JInternalFrame*/ implements ActionListener{
	/*Container panel1,panel2,panel3;*/
	String bcode,bname,btype,bpress,bprice,bdate;
	JLabel bcodel,bnamel,btypel,bpressl,bpricel,storageTime;
	Connection  conn=null;
	Statement stmt=null;
	ResultSet rst=null;
	ResultSet rs=null;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	Object [][] tableDate=new Object[50][6];
	JPanel panel3,panel1,panel2;
	JTable table=null;
	int row=-1;
	public BookManage(){
		super("图书信息中心");
		panel1 = new JPanel();
		
		panel1.setLayout(new GridLayout(3,5));
		JLabel label1=new JLabel("图书编号:",SwingConstants.CENTER);
		tf1=new JTextField();
		panel1.add(label1);panel1.add(tf1);
		
	    label1=new JLabel("图书名称:",SwingConstants.CENTER);
	    tf2=new JTextField();	    
		panel1.add(label1);panel1.add(tf2);
		label1=new JLabel("图书类型:",SwingConstants.CENTER);
		tf3=new JTextField();
		panel1.add(label1);panel1.add(tf3);
		label1=new JLabel("图书价格:",SwingConstants.CENTER);
		tf4=new JTextField();
		panel1.add(label1);panel1.add(tf4);
		label1=new JLabel(" 出   版  社:",SwingConstants.CENTER);
		tf5=new JTextField();
		panel1.add(label1);panel1.add(tf5);
		label1=new JLabel("入库日期:",SwingConstants.CENTER);
	    
		Date date=new Date();
		String dateFormateStr="yyyy-MM-dd"+"  "+"E";
		String dateFormateStr1="yyyy-MM-dd";
		SimpleDateFormat simpleFormat1=new SimpleDateFormat(dateFormateStr1);
		SimpleDateFormat simpleFormat=new SimpleDateFormat(dateFormateStr);
		tf6=new JTextField(simpleFormat.format(date));
//		tf6=new JTextField(simpleFormat1.format(date));
		bdate=new String(simpleFormat1.format(date));
		panel1.add(label1);panel1.add(tf6);
		tf6.addFocusListener(new FocusL());
		
		JButton b1=new JButton("添加");
		JButton b2=new JButton("修改");
		JButton b3=new JButton("删除");
		JButton b4=new JButton("退出");
		
		b1.addActionListener(this);b2.addActionListener(this);
		b3.addActionListener(this);b4.addActionListener(this);
		panel2=new JPanel();
		panel2.add(b1);panel2.add(b2);panel2.add(b3);panel2.add(b4);

		panel3=new JPanel();
		
	//	Connection  conn=null;
	//	Statement stmt=null;
  	//  ResultSet rst=null;
  	    String sql="select * from bookinfo order by Bid desc";

  	  if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
  	  try{
  		  stmt=conn.createStatement();
          rst=stmt.executeQuery(sql);
          int i=0;
          while(rst.next()&&i<15)
		    
		    {	
		      
			  tableDate[i][0]=rst.getString(2);
			  tableDate[i][1]=rst.getString(3);
			  tableDate[i][2]=rst.getString(4);
			  tableDate[i][3]=rst.getString(5);
			  tableDate[i][4]=rst.getString(6);
			  tableDate[i][5]=rst.getString(7);
			 
		      i++;
		    }
          
		 }catch(Exception e){e.printStackTrace();}
  	
		String[] name={"图书编号","图书名称","图书类型","图书价格","出      版     社","入库时间"};
		table=new JTable(tableDate,name);		
		panel3.add(new JScrollPane(table));
		
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				row=table.getSelectedRow();
				bcode=(String) table.getValueAt(row,0);
				bname=(String) table.getValueAt(row,1);
				btype=(String) table.getValueAt(row,2);
				bprice=(String) table.getValueAt(row,3);
				bpress=(String) table.getValueAt(row,4);
				bdate=(String) table.getValueAt(row,5);
				tf1.setText(bcode);tf2.setText(bname);
				tf3.setText(btype);tf4.setText(bprice);
				tf5.setText(bpress);tf6.setText(bdate);
			}

			
		});
		this.setLayout(new BorderLayout());
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.SOUTH);
		this.add(panel3,BorderLayout.CENTER);
		
		
		
		setBounds(300,200,530,350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	//public JInternalFrame getIframe()
	//{return this;}
	
	class FocusL implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String cmd=e.getActionCommand();
		if(cmd.equals("退出"))dispose();
		
		//添加图书信息模块
		else if(cmd.equals("添加")){
			Connection conn=null;
			Statement stmt=null;
	  	    ResultSet rst=null;
	  	    bcode=tf1.getText();
            bname=tf2.getText();
            btype=tf3.getText();
            bprice=tf4.getText();
            bpress=tf5.getText();
	  	    String sql="insert into bookinfo(Bcode,Bname,Btype,Bprice,Bprss,Storedate) values ('"
                       +bcode+"','"+bname+"','"+btype+"','"+bprice
	  	    		   +"','"+bpress+"','"+bdate+"');";
            String uniqueKey="select Bcode from bookinfo where Bcode='"+bcode+"';";
	  	  if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
	  	  String sqlSelect="select * from bookinfo order by Bid desc";
	  	  try {
	  		stmt=conn.createStatement();
//	  		rs=stmt.executeQuery(uniqueKey);
//	  		String result=new String();
//	  		result=null;
//	  		while(rs.next()){result=rst.getString(2);};
//	  		if(result.equals(bcode))
//	  			JOptionPane.showMessageDialog(this, "图书编号重复,请检查后在输入！");
//	  		else
	  			stmt.executeUpdate(sql);
	  			JOptionPane.showMessageDialog(this, "图书添加成功！");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "图书编号重复,请检查后在输入！");
			e1.printStackTrace();
		}
	  	try{
	  		
	  	    rst=stmt.executeQuery(sqlSelect);
            int i=0;
            while(rst.next()&&i<15)		    
		    {	
		      
			  tableDate[i][0]=rst.getString(2);
			  tableDate[i][1]=rst.getString(3);
			  tableDate[i][2]=rst.getString(4);
			  tableDate[i][3]=rst.getString(5);
			  tableDate[i][4]=rst.getString(6);
			  tableDate[i][5]=rst.getString(7);
			 
		      i++;
		    }
            for(i=0;i<15;i++)
            {
            	for(int j=0;j<6;j++)
            	{this.table.setValueAt(tableDate[i][j], i, j);}
            	
            }
        
		 }catch(Exception ex){ex.printStackTrace();}
	    
		}
		else if(cmd.equals("修改")){
			Connection conn=null;
			Statement stmt=null;
	  	    ResultSet rst=null;
	  	    String str1,str2,str3,str4,str5,str6;
	  	    str1=tf1.getText();
            str2=tf2.getText();
            str3=tf3.getText();
            str4=tf4.getText();
            str5=tf5.getText();
            str6=tf6.getText();
            
            String sql="update bookinfo set Bcode='"+str1+"',Bname='"+
                        str2+"',Btype='"+str3+"',Bprice='"+str4+"',Bprss='"+
            		    str5+"',Storedate='"+str6+"'  where Bcode='"+bcode+"' and Bname='"+
                        bname+"' and Btype='"+btype+"' and Bprice='"+bprice+"' and Bprss='"+
            		    bpress+"' and Storedate='"+bdate+"';";
            try{
            	if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
            	stmt=conn.createStatement();
            	stmt.executeUpdate(sql);
            	JOptionPane.showMessageDialog(this, "修改成功！");
            }
            catch (Exception e1)
            {e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "请检查后在输入！");
            }
            
            try{
            	String sqlSelect="select * from bookinfo order by Bid desc";
    	  	    rst=stmt.executeQuery(sqlSelect);
                int i=0;
                while(rst.next()&&i<15)		    
    		    {	
    		      
    			  tableDate[i][0]=rst.getString(2);
    			  tableDate[i][1]=rst.getString(3);
    			  tableDate[i][2]=rst.getString(4);
    			  tableDate[i][3]=rst.getString(5);
    			  tableDate[i][4]=rst.getString(6);
    			  tableDate[i][5]=rst.getString(7);
    			 
    		      i++;
    		    }
                for(i=0;i<15;i++)
                {
                	for(int j=0;j<6;j++)
                	{this.table.setValueAt(tableDate[i][j], i, j);}
                	
                }
            
    		 }catch(Exception ex){ex.printStackTrace();}
    	    
		}
		else if(cmd.equals("删除")){
			Connection conn=null;
			Statement stmt=null;
	  	    ResultSet rst=null;
	  	    String str=tf1.getText();
	  	    String sql="delete from bookinfo where Bcode='"+str+"';";
	  	    
		
		try{
        	if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
        	stmt=conn.createStatement();
        	
			stmt.executeUpdate(sql);
        	JOptionPane.showMessageDialog(this, "删除信息成功！");
        }
        catch (Exception e1)
        {e1.printStackTrace();
        JOptionPane.showMessageDialog(this, "请检查后在输入！");
        }
		
		try{
        	String sqlSelect="select * from bookinfo order by Bid desc";
	  	    rst=stmt.executeQuery(sqlSelect);
            int i=0;
            while(rst.next()&&i<15)		    
		    {	
		      
			  tableDate[i][0]=rst.getString(2);
			  tableDate[i][1]=rst.getString(3);
			  tableDate[i][2]=rst.getString(4);
			  tableDate[i][3]=rst.getString(5);
			  tableDate[i][4]=rst.getString(6);
			  tableDate[i][5]=rst.getString(7);
			 
		      i++;
		    }
            for(i=0;i<15;i++)
            {
            	for(int j=0;j<6;j++)
            	{this.table.setValueAt(tableDate[i][j], i, j);}
            	
            }
        
		 }catch(Exception ex){ex.printStackTrace();}
		}
	}
	
	public static void main(String [] args){
		new BookManage();
	}
}
