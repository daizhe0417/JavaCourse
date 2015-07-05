package Hospital;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class DoctorJFrame extends JFrame implements ActionListener, ListSelectionListener{
	protected JTable jtable;
	protected DoctorJPanel doctor;
	private   Doctor  doc;
	private DefaultTableModel table;
	protected JComboBox<String>comboxs[];
	public DoctorJFrame(DoctorJPanel doctor,Doctor value[]){
    super("Doctor对象信息管理");
			this.setSize(850, 500);
			this.setLocation(300,200);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行
			this.doctor=doctor;
			JPanel rightpanel=new JPanel(new BorderLayout());
			JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,this.doctor,rightpanel);
			split.setDividerLocation(200);
			this.getContentPane().add(split);
			String titles[]={"姓名","年龄","性别","编号","部门","科室"};
			this.table=new DefaultTableModel(titles,0);
			JTable jtable=new JTable(this.table);
			rightpanel.add(new JScrollPane(jtable));
			this.setVisible(true);
			
			JPanel buttonpanel=new JPanel();
			rightpanel.add(buttonpanel,"South");
			String str[][]={{"添加","删除","退出程序","查询","保存","更新"}};
			for(int i=0;i<str[0].length;i++)
			{
				JButton button=new JButton(str[0][i]);
				button.addActionListener(this);
				buttonpanel.add(button);
			}	
			this.initialFrame();
	}
 public void initialFrame()
    {   String buffer;
    	try{
    		File f = new File("C:\\Doctor.txt");
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
            
            	table.addRow(vec);
            line = reader.readLine();
            }
            reader.close();
            is.close();		
    }catch (Exception e) {
    	e.printStackTrace();
    	}
    }
	@Override
	public void valueChanged(ListSelectionEvent ev) 
	{
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getActionCommand().equals("添加"))
		{    int j=table.getRowCount();
	         doc=this.doctor.get();
	         for(int t=0;t<j;t++)
		     if(doc.getDedno().equals(table.getValueAt(t,3)))
		     {JOptionPane.showMessageDialog(this, "药品编号已经存在不能添加");return;}
			 doc=this.doctor.get();
		     Vector<String>  vec=new  Vector<String>();
		     vec.add(doc.getDename());
		     vec.add(doc.getDeage());
		     vec.add(doc.getDesex());
		     vec.add(doc.getDedno());
		     vec.add(doc.getDedepart());
		     vec.add(doc.getDeoffice());
		     this.table.addRow(vec);
		     
		}
		if(ev.getActionCommand().equals("删除"))
		{ doc=this.doctor.get();
          Vector<String>  vec=new  Vector<String>();
          vec.add(doc.getDenumber());
          int i=Integer.parseInt(doc.getDenumber());
          if(this.table.getColumnCount()==0)
		  JOptionPane.showMessageDialog(this, "列表为空，不能删除");
			else
			{
				if(i-1>=table.getRowCount())
				JOptionPane.showMessageDialog(this, "表中没有此行数据，不能删除");
				else
				table.removeRow(i-1);
			}
        }
		if(ev.getActionCommand().equals("保存"))
		{try{
			File f = new File("C:\\Doctor.txt");
			if (f.exists()) {
			} 
			else 
			{f.createNewFile();
			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			int j=table.getRowCount();
			for(int i=0;i<j;i++)
	    	{for(int k=0;k<6;k++)
	    	output.write(table.getValueAt(i,k)+"@");
		    output.newLine();}
			output.close();
         }catch (Exception e) {
		 e.printStackTrace();}
			
		}
		if(ev.getActionCommand().equals("退出程序"))
		{if (JOptionPane.showConfirmDialog(this, "终止当前程序运行？") == 0) {
			 new MainJFrame();
			 this.hide();}
		}
		if(ev.getActionCommand().equals("查询"))
		{MyTree t = new MyTree();
		t.pack();
		this.hide();}
	}
	public static void main(String arg[]) {
		Doctor value[]={new Doctor()};
		new DoctorJFrame(new DoctorJPanel(),value);
}
}

