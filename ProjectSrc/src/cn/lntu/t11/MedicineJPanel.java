package cn.lntu.t11;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MedicineJPanel extends JPanel implements ActionListener{
	private JTextField texts[];
	 private JRadioButton radiobs[];
	 public JComboBox<String>combox_depart,combox_office;
	 private static String depart[] = {"内科","骨科","心脑血管科"};
	 private static String office[][]={{"解热镇痛药","抗肿瘤药","补益剂","解表剂","止咳剂"},{"类风湿剂","活气血剂"},{"中成药","循环系统药"}};
	 private JLabel lname,lsex,lnum,lage,lmonth,ldepart,loffice;
	 public MedicineJPanel(){
		 this.setBorder(new TitledBorder("Medicine"));
		 lname = new JLabel("姓名");
		 lnum=new JLabel("编号");
		 lsex = new JLabel("性别");
		 lage = new JLabel("年龄");
		 ldepart=new JLabel("部门");
		 loffice=new JLabel("科室");
		 this.setLayout(new GridLayout(10,1));
		 String str[][]={{"药品名","药品编号","要删除的位置(第几行)"},{"中药","西药"}};
		 this.texts=new JTextField[str[0].length];
		 for(int i=0;i<this.texts.length;i++)
		 {  
			 this.add(this.texts[i]=new JTextField(str[0][i]));
		 }
		 JPanel panel=new JPanel(new GridLayout(1,2));
		 this.add(panel);
		 ButtonGroup bgroup=new ButtonGroup();
		 this.radiobs=new JRadioButton[str[1].length];
		 for(int i=0;i<this.radiobs.length;i++)
		 {
			 panel.add(this.radiobs[i]=new JRadioButton(str[1][i]));
			 bgroup.add(this.radiobs[i]);
		 }
		 this.radiobs[0].setSelected(true); 
		 this.add(this.combox_depart=new JComboBox<String>(MedicineJPanel.depart));
		 this.add(this.combox_office=new JComboBox<String>(MedicineJPanel.office[0]));
		 this.combox_depart.addActionListener(this);
		 this.combox_office.addActionListener(this);
		 }
		 public Medicine get()
		 {   
			String sex=radiobs[0].isSelected()?radiobs[0].getText():radiobs[1].getText();
			return new Medicine(texts[0].getText(),texts[1].getText(),texts[2].getText(),sex,(String)combox_depart.getSelectedItem(),(String)combox_office.getSelectedItem());
		}
		@Override
		public void actionPerformed(ActionEvent ev) 
		{
			int i=this.combox_depart.getSelectedIndex();
			if(office!=null&&i!=-1)
			{this.combox_office.removeAllItems();
			for(int j=0;j<MedicineJPanel.office[i].length;j++)
				this.combox_office.addItem(MedicineJPanel.office[i][j]);
			}
			
		}

}
