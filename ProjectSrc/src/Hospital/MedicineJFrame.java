package Hospital;

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
import java.util.Vector;

import javax.swing.AbstractButton;
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

public class MedicineJFrame extends JFrame implements ActionListener, ListSelectionListener{
	protected JTable jtable;
	protected MedicineJPanel medicine;
	private DefaultTableModel tablem;
	private   Medicine medic;
	protected JComboBox<String>comboxs[];
	public MedicineJFrame(MedicineJPanel medicine,Medicine value[]){
    super("Medicine对象信息管理");
			this.setSize(850, 500);
			this.setLocation(300,200);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行
			this.medicine=medicine;
			JPanel rightpanel=new JPanel(new BorderLayout());
			JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,this.medicine,rightpanel);
			split.setDividerLocation(200);
			this.getContentPane().add(split);
			String titles[]={"药品名","药品编号","药品属性","药品科室","药品类别"};
			this.tablem=new DefaultTableModel(titles,0);
			JTable jtable=new JTable(this.tablem);
			rightpanel.add(new JScrollPane(jtable));
			this.setVisible(true);
			DefaultTableModel dtm = new DefaultTableModel();
			JTable jt = new JTable(dtm);
			JPanel buttonpanel=new JPanel();
			rightpanel.add(buttonpanel,"South");
			String str[][]={{"添加","删除","退出程序","查询"}};
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
            {   Vector<String>  vec=new  Vector<String>();
            	String  [] str=line.split("@");
            	for(int j=0;j<str.length;j++){     		
                 vec.add(str[j]);
            }
            	tablem.addRow(vec);
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
		{    int j=tablem.getRowCount();
		     medic=this.medicine.get();
		     for(int t=0;t<j;t++)
			 if(medic.getMedno().equals(tablem.getValueAt(t,1)))
			 {JOptionPane.showMessageDialog(this, "药品编号已经存在不能添加");return;}
			 medic=this.medicine.get();
		     Vector<String>  vec=new  Vector<String>();
		     vec.add(medic.getMename());
		     vec.add(medic.getMedno());
		     vec.add(medic.getMedsex());
		     vec.add(medic.getMedepart());
		     vec.add(medic.getMeoffice());
		     this.tablem.addRow(vec);     
		}
		
		if(ev.getActionCommand().equals("删除"))
		{   medic=this.medicine.get();
	        Vector<String>  vec=new  Vector<String>();
	        vec.add(medic.getMenumber());
	        int i=Integer.parseInt(medic.getMenumber());
		    if(this.tablem.getRowCount()==0)
		    JOptionPane.showMessageDialog(this, "列表为空，不能删除");
		else
		{   
			if(i-1>=tablem.getRowCount())
			JOptionPane.showMessageDialog(this, "表中没有此行数据，不能删除");
			else
			tablem.removeRow(i-1);
		}
		}
		if(ev.getActionCommand().equals("退出程序"))
		{if (JOptionPane.showConfirmDialog(this, "终止当前程序运行？") == 0) {
		 new MainJFrame();
		 this.hide();
		 }
		}
		
		if(ev.getActionCommand().equals("查询"))
		{   
			try{
				File f = new File("C:\\Medicine.txt");
				if (f.exists()) {
				} 
				else 
				{f.createNewFile();
				}
				BufferedReader input = new BufferedReader(new FileReader(f));
				BufferedWriter output = new BufferedWriter(new FileWriter(f));
				int j=tablem.getRowCount();
				for(int i=0;i<j;i++)
		    	{for(int k=0;k<5;k++)
		    	output.write(tablem.getValueAt(i,k)+"@");
			    output.newLine();}
				output.close();
	         }catch (Exception e) {
			 e.printStackTrace();}
			 new MedicineList();
			 this.hide();
		}
	}
	public static void main(String arg[]) {
		Medicine value[]={new Medicine()};
		new MedicineJFrame(new MedicineJPanel(),value);
}



	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
