package cn.lntu.t11;

import java.awt.BorderLayout;
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
import java.util.ArrayList;
import java.util.Collection;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class CureJFrame extends JFrame implements ActionListener, ListSelectionListener{
	protected JTable jtable;
	protected CureJPanel cure;
	private  Cure cu;
	private DefaultTableModel tablemodel;
	protected JComboBox<String>comboxs[];
	private static List<Cure> list = new ArrayList();
	public CureJFrame(CureJPanel cure,Cure value[]){
    super("Cure对象信息管理");
			this.setSize(900, 500);
			this.setLocation(300,200);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行
			this.cure=cure;
			JPanel rightpanel=new JPanel(new BorderLayout());
			JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,this.cure,rightpanel);
			split.setDividerLocation(200);
			this.getContentPane().add(split);
			String titles[]={"医生姓名","病人姓名","治疗时间","医生编号","药品属性","药品科室","药品类别"};
			this.tablemodel=new DefaultTableModel(titles,0);
			JTable jtable=new JTable(this.tablemodel);
			rightpanel.add(new JScrollPane(jtable));
			this.setVisible(true);
			DefaultTableModel dtm = new DefaultTableModel();
			JTable jt = new JTable(dtm);
			JPanel buttonpanel=new JPanel();
			rightpanel.add(buttonpanel,"South");
			String str[][]={{"添加","删除","退出程序","保存"},{"查找关键字"},{"药品编号","治疗时间"}};
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
	            
	            tablemodel.addRow(vec);
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
		{int j=tablemodel.getRowCount();
		 cu=this.cure.get();
		 for(int t=0;t<j;t++)
			 if((cu.getCudno().equals(tablemodel.getValueAt(t,3)))&(cu.getCutime().equals(tablemodel.getValueAt(t,2))))
			 {JOptionPane.showMessageDialog(this, "治疗时间和医生编号已经存在不能添加");return;}
		 cu=this.cure.get();
	     Vector<String>  vec=new  Vector<String>();
	     vec.add(cu.getCudname());
	     vec.add(cu.getCupname());
	     vec.add(cu.getCutime());
	     vec.add(cu.getCudno());
	     vec.add(cu.getCucategory());
	     vec.add(cu.getCtype());
	     vec.add(cu.getCuattribute());
	     this.tablemodel.addRow(vec);
		}
		if(ev.getActionCommand().equals("删除"))
		{  
			cu=this.cure.get();
		    Vector<String>  vec=new  Vector<String>();
		    vec.add(cu.getCunumber());
		    int i=Integer.parseInt(cu.getCunumber());
			if(this.tablemodel.getRowCount()==0)
			JOptionPane.showMessageDialog(this, "列表为空，不能删除");
			else
			{   
				if(i-1>=tablemodel.getRowCount())
				JOptionPane.showMessageDialog(this, "表中没有此行数据，不能删除");
				else
				tablemodel.removeRow(i-1);
			}
		}
		if(ev.getActionCommand().equals("退出程序"))
		{
			if (JOptionPane.showConfirmDialog(this, "终止当前程序运行？") == 0) {
				 new MainJFrame();
				 this.hide();}
		}
		if(ev.getActionCommand().equals("保存"))
		{
			 try{
					File f = new File("C:\\Cure.txt");
					if (f.exists()) {
					} 
					else 
					{f.createNewFile();
					}
					BufferedReader input = new BufferedReader(new FileReader(f));
					BufferedWriter output = new BufferedWriter(new FileWriter(f));
					int j=tablemodel.getRowCount();
					for(int i=0;i<j;i++)
			    	{for(int k=0;k<7;k++)
			    	output.write(tablemodel.getValueAt(i,k)+"@");
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
				new CureSelect();
				this.hide();			   
			}	    			    	
			if(i==1)
			{new CureSelect();
			this.hide();}
		}
	}
	public static void main(String arg[]) {
		Cure value[]={new Cure()};
		new CureJFrame(new CureJPanel(),value);	
}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public List<Cure> getAllCure() {
		return this.list;
	}

	

}

