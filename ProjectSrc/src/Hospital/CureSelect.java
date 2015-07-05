package Hospital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class CureSelect extends JFrame implements ActionListener, ListSelectionListener{
	protected DefaultTableModel cureselect;
	public JTextField texts[];
	private JButton button,button1;
	protected OfficeJFrame office;
	public CureSelect(){
	super("Cure对象查询管理");
	this.setSize(550, 300);
	this.setLocation(300,200);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	JPanel panel=new JPanel();
	this.getContentPane().add(panel,"North");
	String str[]={"要查询的医生编号","要查询的治疗时间"};
	String str_text[]={"",""};
	this.texts=new JTextField[str_text.length];
	for(int i=0;i<str_text.length;i++)
	{
		panel.add(new JLabel(str[i]));
		texts[i]=new JTextField(str_text[i],6);
		panel.add(texts[i]);
	}
	button=new JButton("查询");
	panel.add(button);
	button1=new JButton("退出");
	panel.add(button1);
	button.addActionListener(this);
	button1.addActionListener(this);
	String titles[]={"医生姓名","病人姓名","治疗时间","医生编号","药品属性","药品科室","药品类别"};
	this.cureselect=new DefaultTableModel(titles,0);
	JTable jtable=new JTable(this.cureselect);
	this.add(new JScrollPane(jtable));
	this.setVisible(true);
	this.initialFrame();
	}
	public void initialFrame()
	{   String buffer;
		try{
			File f = new File("C:\\Cure.txt");
			if (f.exists()) {
			} 
			else 
			{f.createNewFile();
			}
			InputStream is = new FileInputStream(f);
	        String line; // 用来保存每行读取的内容
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        line = reader.readLine(); // 读取第一行
	        while(line!=null)
	        {   Vector<String>  vec=new  Vector<String>();
	        	String  [] str=line.split("@");
	        	for(int j=0;j<str.length;j++){     		
	             vec.add(str[j]);
	        }
	        cureselect.addRow(vec);
	        line = reader.readLine();
	        }
	        reader.close();
	        is.close();		
	}catch (Exception e) {
		e.printStackTrace();
		}
	}
	public static void main(String arg[]) {
		new CureSelect();
	}
	@Override
	public void valueChanged(ListSelectionEvent ev) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		if(ev.getActionCommand().equals("查询"))
		{   
			int j=cureselect.getRowCount();
			for(int k=0;k<j;k++)
			{
				cureselect.removeRow(0);
			}
			try{
				File f = new File("C:\\Cure.txt");
				if (f.exists()) {
				} 
				else 
				{f.createNewFile();
				}
				InputStream is = new FileInputStream(f);
		        String line; // 用来保存每行读取的内容
		        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		        line = reader.readLine(); // 读取第一行
		        while(line!=null)
		        {   Vector<String>  vec=new  Vector<String>();
		        	String  [] str=line.split("@");
		        	if(texts[0].getText().equals(str[3]))
		        	{for(int t=0;t<str.length;t++){     		
		             vec.add(str[t]); } 
		        	cureselect.addRow(vec);}
		        	if(texts[1].getText().equals(str[2]))
		        	{for(int t=0;t<str.length;t++){     		
		             vec.add(str[t]); } 
		        	cureselect.addRow(vec);}
		        line = reader.readLine();
		        }
		        reader.close();
		        is.close();	
		        int i=cureselect.getRowCount();
		        if(i==0)
		        {JOptionPane.showMessageDialog(this, "没有你要查询的数据");}
		}catch (Exception e) {
			e.printStackTrace();
			}
		}
		if(ev.getActionCommand().equals("退出"))
		{Cure value[]={new Cure()};
		new CureJFrame(new CureJPanel(),value);
		this.hide();}
	}
}