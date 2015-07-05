package Hospital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class OfficeSelect extends JFrame implements ActionListener, ListSelectionListener{
	protected DefaultTableModel officeselect;
	public JTextField texts[];
	private JButton button,button1;
	protected OfficeJFrame office;
	protected JTable jtable;
	private Color color;
	public OfficeSelect(){
	super("Office对象查询管理");
	this.setSize(500, 300);
	this.setLocation(300,200);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	JPanel panel=new JPanel();
	this.getContentPane().add(panel,"North");
	String str[]={"要查询的科室编号","要查询的楼层"};
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
	String titles[]={"科室名称","科室编号","科室电话","楼层"};
	this.officeselect=new DefaultTableModel(titles,0);
	JTable jtable=new JTable(this.officeselect);
	this.add(new JScrollPane(jtable));
	this.setVisible(true);
	this.initialFrame();
	}
	
	public static void main(String arg[]) {
		new OfficeSelect();
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
			int j=officeselect.getRowCount();
			for(int k=0;k<j;k++)
			{
				officeselect.removeRow(0);
			}
			try{
				File f = new File("C:\\Office.txt");
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
		        	if(texts[0].getText().equals(str[1]))
		        	{for(int t=0;t<str.length;t++){     		
		             vec.add(str[t]); } 
		             officeselect.addRow(vec);}
		        	if(texts[1].getText().equals(str[3]))
		        	{for(int t=0;t<str.length;t++){     		
		             vec.add(str[t]); } 
		             officeselect.addRow(vec);}
		        line = reader.readLine();
		        }
		        reader.close();
		        is.close();
		        int i=officeselect.getRowCount();
		        if(i==0)
		        {JOptionPane.showMessageDialog(this, "没有你要查询的数据");}
		}catch (Exception e) {
			e.printStackTrace();
			}
		}
		if(ev.getActionCommand().equals("退出"))
		{Office value[]={new Office()};
		new OfficeJFrame(new OfficeJPanel(),value);
		this.hide();
		
		}
	}

public void initialFrame()
{   String buffer;
	try{
		File f = new File("C:\\Office.txt");
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
        
        officeselect.addRow(vec);
        line = reader.readLine();
        }
        reader.close();
        is.close();		
}catch (Exception e) {
	e.printStackTrace();
	}
}}
/*{if(texts[1].getText().equals((String)officeselect.getValueAt(i,3)))
{   officeselect.setValueAt((String)officeselect.getValueAt(i,3)+"<---", i, 3);
}
//else if(officeselect.getValueAt(i+1,3)==null){JOptionPane.showMessageDialog(this, "没有你要查询的数据");}
}
for(int i=0;i<j;i++)
{if(texts[0].getText().equals((String)officeselect.getValueAt(i,2)))
{   officeselect.setValueAt((String)officeselect.getValueAt(i,2)+"<---", i, 2);
}
//else if(i==j){JOptionPane.showMessageDialog(this, "没有你要查询的数据");}
}*/ 