package cn.lntu.t34;
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
		super("ͼ����Ϣ����");
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new GridLayout(3,5));
		JLabel label1=new JLabel("ͼ����:",SwingConstants.CENTER);
		JTextField tf1=new JTextField();
		panel1.add(label1);panel1.add(tf1);
		
	    label1=new JLabel("ͼ�����:",SwingConstants.CENTER);
	    JTextField tf2=new JTextField();	    
		panel1.add(label1);panel1.add(tf2);
		label1=new JLabel("ͼ������:",SwingConstants.CENTER);
		JTextField tf3=new JTextField();
		panel1.add(label1);panel1.add(tf3);
		label1=new JLabel("ͼ��۸�:",SwingConstants.CENTER);
		JTextField tf4=new JTextField();
		panel1.add(label1);panel1.add(tf4);
		label1=new JLabel(" ��   ��  ��:",SwingConstants.CENTER);
		JTextField tf5=new JTextField();
		panel1.add(label1);panel1.add(tf5);
		label1=new JLabel("�������:",SwingConstants.CENTER);
	    
		Date date=new Date();
		String dateFormateStr="yyyy-MM-dd"+"  "+"E";
		String dateFormateStr1="yyyy-MM-dd";
		SimpleDateFormat simpleFormat1=new SimpleDateFormat(dateFormateStr1);
		SimpleDateFormat simpleFormat=new SimpleDateFormat(dateFormateStr);
//		JTextField tf6=new JTextField(simpleFormat.format(date));
		JTextField tf6=new JTextField(simpleFormat1.format(date));
		panel1.add(label1);panel1.add(tf6);
		tf6.addFocusListener(new FocusL());
		
		JButton b1=new JButton("���");
		JButton b2=new JButton("�޸�");
		JButton b3=new JButton("ɾ��");
		JButton b4=new JButton("�˳�");
		b1.addActionListener(this);b2.addActionListener(this);
		b3.addActionListener(this);b4.addActionListener(this);
		JPanel panel2=new JPanel();
		panel2.add(b1);panel2.add(b2);panel2.add(b3);panel2.add(b4);
		JPanel panel3=new JPanel();
		Object [][] tableDate=new Object[5][6];
		for(int i=0;i<5;i++)
		{
			tableDate[i][0]="08100"+i;
			for(int j=1;j<6;j++)
			{	tableDate[i][j]=0;}
		}
		String[] name={"ͼ����","ͼ�����","ͼ������","ͼ��۸�","��      ��     ��","���ʱ��"};
		JTable table=new JTable(tableDate,name);
		
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
		if(cmd.equals("�˳�"))dispose();
		else if(cmd.equals("���")){}
		else if(cmd.equals("�޸�")){}
		else if(cmd.equals("ɾ��")){}
	}
	
	public static void main(String [] args){
		new BookManage();
	}
}
