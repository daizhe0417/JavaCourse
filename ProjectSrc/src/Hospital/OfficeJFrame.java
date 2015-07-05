package Hospital;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class OfficeJFrame extends JFrame implements ActionListener, ListSelectionListener{
	protected JTable jtable;
	protected OfficeJPanel office;
	private   Office  offi;
	protected DefaultTableModel tableoffice;
	protected JComboBox<String>comboxs[];
	private static List<Office> list = new ArrayList();
	public OfficeJFrame(OfficeJPanel office,Office value[]){
    super("Office对象信息管理");
			this.setSize(850, 400);
			this.setLocation(300,200);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行
			this.office=office;
			JPanel rightpanel=new JPanel(new BorderLayout());
			JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,this.office,rightpanel);
			split.setDividerLocation(200);
			this.getContentPane().add(split);
			String titles[]={"科室名称","科室编号","科室电话","楼层"};
			this.tableoffice=new DefaultTableModel(titles,0);
			JTable jtable=new JTable(this.tableoffice);
			rightpanel.add(new JScrollPane(jtable));
			DefaultTableModel dtm = new DefaultTableModel();
			JTable jt = new JTable(dtm);
			JPanel buttonpanel=new JPanel();
			rightpanel.add(buttonpanel,"South");
			String str[][]={{"添加","删除","保存","退出程序"},{"查找关键字"},{"楼层","科室编号"}};
			for(int i=0;i<str[0].length;i++)
			{   
				JButton button=new JButton(str[0][i]);
				button.addActionListener(this);
				buttonpanel.add(button);
			}
			this.comboxs=new JComboBox[str[1].length];
			for(int i=0;i<str[1].length;i++)
			{   
				buttonpanel.add(new JLabel(str[1][i]));
				buttonpanel.add(this.comboxs[i]=new JComboBox<String>(str[2]));
				this.comboxs[i].addActionListener(this);
			}
			this.setVisible(true);
			this.initialFrame();
		}
	    public List<Office> getAllOffice() {
		return this.list;
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
	            
	            tableoffice.addRow(vec);
	            line = reader.readLine();
	            }
	            reader.close();
	            is.close();	            
	    }catch (Exception e) {
	    	e.printStackTrace();
	    	}
	    }
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getActionCommand().equals("添加"))
		{int j=tableoffice.getRowCount();
		offi=this.office.get();
		System.out.print(offi.getOfdno());
		 for(int t=0;t<j;t++)
			 if(offi.getOfdno().equals(tableoffice.getValueAt(t,1)))
			 {JOptionPane.showMessageDialog(this, "科室编号已经存在不能添加");return;} 
	     offi=this.office.get();
	     Vector<String>  vec=new  Vector<String>();
	     vec.add(offi.getOfname());
	     vec.add(offi.getOfdno());
	     vec.add(offi.getOfphone());
	     vec.add(offi.getOfflooor());
	     this.tableoffice.addRow(vec);
	     	 
		}
		if(ev.getActionCommand().equals("删除"))
		{
			offi=this.office.get();
		    Vector<String>  vec=new  Vector<String>();
		    vec.add(offi.getOfnumber());
		    int i=Integer.parseInt(offi.getOfnumber());
			if(this.tableoffice.getRowCount()==0)
			JOptionPane.showMessageDialog(this, "列表为空，不能删除");
			else
			{   
				if(i-1>=tableoffice.getRowCount())
				JOptionPane.showMessageDialog(this, "表中没有此行数据，不能删除");
				else
				tableoffice.removeRow(i-1);
			}
		}
		if(ev.getActionCommand().equals("退出程序"))
		{if (JOptionPane.showConfirmDialog(this, "终止当前程序运行？") == 0) {
		 new MainJFrame();
		 this.hide();}
		}
		if(ev.getActionCommand().equals("保存"))
		{   
			try{
				File f = new File("C:\\Office.txt");
				if (f.exists()) {
				} 
				else 
				{f.createNewFile();
				}
				BufferedReader input = new BufferedReader(new FileReader(f));
				BufferedWriter output = new BufferedWriter(new FileWriter(f));
				int j=tableoffice.getRowCount();
			    for(int i=0;i<j;i++)
			    	{output.write(tableoffice.getValueAt(i,0)+"@");
			         output.write(tableoffice.getValueAt(i,1)+"@");
			         output.write(tableoffice.getValueAt(i,2)+"@");
			         output.write(tableoffice.getValueAt(i,3)+"@");
				    output.newLine();}
				 output.close();	
	         }catch (Exception e) {
			 e.printStackTrace();}	
		}
		if(ev.getSource()==this.comboxs[0])
		{  
			int i=this.comboxs[0].getSelectedIndex();
			if(i==0)
			{
				new OfficeSelect();
				this.hide();
			}  	
			if(i==1)
			{new OfficeSelect();
			this.hide();
			}
		}
	}
	private String getValueAt(int i, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String arg[]) {
		Office value[]={new Office()};
		new OfficeJFrame(new OfficeJPanel(),value);
}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

