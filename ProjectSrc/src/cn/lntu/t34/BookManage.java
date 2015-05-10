package bookmanage;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class BookManage extends JFrame/*JInternalFrame*/ implements ActionListener{
	/*Container panel1,panel2,panel3;
	JTextField bcode,bname,btype,bpress,bprice;
	JLabel bcodel,bnamel,btypel,bpressl,bpricel,storageTime;
	DateChooserJButton storageDate;*/
	public BookManage(){
		super("图书信息中心");
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new GridLayout(3,5));
		JLabel label1=new JLabel("图书编号:",SwingConstants.CENTER);
		JTextField tf1=new JTextField();
		panel1.add(label1);panel1.add(tf1);
		
	    label1=new JLabel("图书名称:",SwingConstants.CENTER);
	    JTextField tf2=new JTextField();	    
		panel1.add(label1);panel1.add(tf2);
		label1=new JLabel("图书类型:",SwingConstants.CENTER);
		JTextField tf3=new JTextField();
		panel1.add(label1);panel1.add(tf3);
		label1=new JLabel("图书价格:",SwingConstants.CENTER);
		JTextField tf4=new JTextField();
		panel1.add(label1);panel1.add(tf4);
		label1=new JLabel(" 出   版  社:",SwingConstants.CENTER);
		JTextField tf5=new JTextField();
		panel1.add(label1);panel1.add(tf5);
		label1=new JLabel("入库日期:",SwingConstants.CENTER);
	    
		Date date=new Date();
		String dateFormateStr="yyyy-MM-dd"+"  "+"E";
		String dateFormateStr1="yyyy-MM-dd";
		SimpleDateFormat simpleFormat1=new SimpleDateFormat(dateFormateStr1);
		SimpleDateFormat simpleFormat=new SimpleDateFormat(dateFormateStr);
//		JTextField tf6=new JTextField(simpleFormat.format(date));
		JTextField tf6=new JTextField(simpleFormat1.format(date));
		panel1.add(label1);panel1.add(tf6);
		tf6.addFocusListener(new FocusL());
		
		JButton b1=new JButton("添加");
		JButton b2=new JButton("修改");
		JButton b3=new JButton("删除");
		JButton b4=new JButton("退出");
		b1.addActionListener(this);b2.addActionListener(this);
		b3.addActionListener(this);b4.addActionListener(this);
		JPanel panel2=new JPanel();
		panel2.add(b1);panel2.add(b2);panel2.add(b3);panel2.add(b4);
		JPanel panel3=new JPanel();
		Object [][] tableDate=new Object[20][6];
		
		for(int i=0;i<10;i++)
		{
			tableDate[i][0]="08100"+i;
			for(int j=1;j<6;j++)
			{	tableDate[i][j]=0;}
		}
		String[] name={"图书编号","图书名称","图书类型","图书价格","出      版     社","入库时间"};
		JTable table=new JTable(tableDate,name);
		panel3.add(new JScrollPane(table));
		
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
		else if(cmd.equals("添加")){}
		else if(cmd.equals("修改")){}
		else if(cmd.equals("删除")){}
	}
	
	public static void main(String [] args){
		new BookManage();
	}
}
