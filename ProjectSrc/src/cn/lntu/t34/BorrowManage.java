package bookmanage;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BorrowManage extends JFrame implements ActionListener{
	private static final String ActionEvent = null;
	Container content;
	JLabel unamel,bcodel,bdatel,rdatel;  //����֤����ͼ���ţ��������ڣ���������
	JTextField tf1,tf2,tf3,tf4;
	JTable table=null;
	JButton b1,b2;    //�������˳���ť
	String uname,bcode,bdate,rdate;
	
	Calendar calendar=Calendar.getInstance();
	Object [][]tableData=new Object[30][5];
	int row=-1;
	public BorrowManage(){
		content=getContentPane();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(450, 150, 600, 400);
        
        Chooser ser = Chooser.getInstance();
        Chooser ser1 = Chooser.getInstance();
        Date date=new Date();
        String dateFormatStr="yyyy��MM��dd��  E";
        String dateStr="yyyy-MM-dd";
        SimpleDateFormat simpleFormat=new SimpleDateFormat(dateFormatStr);
        SimpleDateFormat simpleformat=new SimpleDateFormat(dateStr);
        
        unamel=new JLabel("����֤��:");
        unamel.setBounds(30,10,60,30);
        add(unamel);
        tf1=new JTextField();
        tf1.setBounds(90,10,150,30);
        add(tf1);
        
        bcodel=new JLabel("ͼ����:");
        bcodel.setBounds(300,10,60,30);
        add(bcodel);
        tf2=new JTextField();
        tf2.setBounds(360,10,150,30);
        add(tf2);
        
        bdatel=new JLabel("��������:");
        tf3=new JTextField();
        bdatel.setBounds(30,50,60,30);
        tf3.setBounds(90,50,150,30);
        tf3.setText(simpleFormat.format(date));
        ser.register(tf3);
        add(bdatel);add(tf3);
        
        rdatel=new JLabel("��������:");
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 60);
        Date date60=cal.getTime();
        tf4=new JTextField(simpleformat.format(date60));
          
        rdatel.setBounds(300,50,60,30);
        tf4.setBounds(360,50,150,30);
        ser1.register(tf4);
        add(rdatel);add(tf4);
        
        
        for(int i=0;i<30;i++)
        	for(int j=0;j<5;j++)
        	{
        		tableData[i][j]="\0";
        	}
        String [] name={"����֤��","ͼ����","����","��������","��������"};
        table = new JTable(tableData,name);
        JScrollPane js=new JScrollPane(table);
        js.setBounds(30,90,530,200);
      //  table.setVisible(true);
        this.add(js);
        
        b1=new JButton("��  ��");
        b2=new JButton("��  ��");
        b1.setBounds(100,320,100,30);b2.setBounds(400,320,100,30);
        
        add(b1);add(b2);
        b2.addActionListener(this);
        content.setLayout(null);
        getContentPane().setBackground(Color.green);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd=e.getActionCommand();
		if(cmd.equals("��  ��")) dispose();
		if(cmd.equals("��  ��")){}
	}
	
	public static void main(String [] args){
		new  BorrowManage();
	}

}
