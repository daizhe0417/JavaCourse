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

public class OfficeJPanel extends JPanel implements ActionListener{
	private JTextField texts[];
	private JTextField  text_number;
	 private JRadioButton radiobs[];
	 public JComboBox<String>combox_depart;
	 private static String str[][]={{"科室名称","科室编号","科室电话"},{"一楼","二楼","三楼","四楼","五楼"}};
	 public OfficeJPanel(){
		 this.setBorder(new TitledBorder("Office"));
		 this.setLayout(new GridLayout(10,1));
		 this.texts=new JTextField[str[0].length];
		 for(int i=0;i<this.texts.length;i++)
		 {   
			 this.add(this.texts[i]=new JTextField(str[0][i]));
		 }
		 JPanel panel=new JPanel(new GridLayout(1,3));
		 this.add(panel);
		 this.add(this.combox_depart=new JComboBox<String>(OfficeJPanel.str[1]));
		 this.combox_depart.addActionListener(this);
		 text_number = new JTextField("要删除的位置(第几行)");
		 panel.add(text_number);
		 }
	     
		 public Office get()
		 {  
			return new Office(texts[0].getText(),texts[1].getText(),texts[2].getText(),(String)combox_depart.getSelectedItem(),text_number.getText());
		}
		@Override
		public void actionPerformed(ActionEvent ev) 
		{
		}
}
