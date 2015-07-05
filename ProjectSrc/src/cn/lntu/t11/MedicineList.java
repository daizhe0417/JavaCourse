package cn.lntu.t11;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class MedicineList extends JFrame implements ActionListener, ItemListener{
	private JTextField  text_name;
	private JButton button_select,button_quit; // 添加按钮
	private JTextArea text_user; // 文本区
	public MedicineList(){
	    super("Medicine对象查询器");
	    this.setSize(400, 100);
		this.setLocation(300, 240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行
		this.setLayout(new GridLayout(1, 2)); // 网格布局，1行2列，左右分隔窗口
        JPanel panel = new JPanel(new GridLayout(3, 1)); // 面板网格布局，6行1列
		this.add(panel); // 占据窗口右半部分
		text_user = new JTextArea(); // 创建文本区
		this.add(text_user); // 占据窗口左半部分
		text_name = new JTextField("你要查询的姓名");
		panel.add(text_name);	
		button_select = new JButton("查询");
		button_select.addActionListener(this);
		panel.add(button_select);
		button_quit = new JButton("退出");
		button_quit.addActionListener(this);
		panel.add(button_quit);
	    this.setVisible(true);
	}
	public static void main(String arg[]) {
		new MedicineList();
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		if(ev.getActionCommand().equals("查询")){
			try{
				File f = new File("C:\\Medicine.txt");
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
		        {   
		        	Vector<String>  vec=new  Vector<String>();
		        	String  [] str=line.split("@");
		        	if(text_name.getText().equals((String)str[0]))
		        	{for(int j=0;j<str.length;j++)
		        	{vec.add(str[j]);}
		            text_user.append(vec + "\n");
		            }
		        line = reader.readLine();}
		        reader.close();
		        is.close();		
		}catch (Exception e) {
			e.printStackTrace();
			}
		}
	    
		if(ev.getActionCommand().equals("退出"))
		{   Medicine value[]={new Medicine()};
			new MedicineJFrame(new MedicineJPanel(),value);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
