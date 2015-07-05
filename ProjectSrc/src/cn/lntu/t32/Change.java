package cn.lntu.t32;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.sunshine.sunsdk.swing.*;

public class Change 
extends JDialog 
implements ActionListener {
	
	private JLabel lbA;
	private JTextField tf1,tf2;
	private JCheckBox chk;
	private JButton bt1,bt2;
	private JPanel panelMain;
	
	public Change(JFrame frame) {
		super(frame,"���",true);
		
		buildPanel();
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (270,200));
		this.setMinimumSize (new Dimension (270,200));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
	}
	
	//�¼�����
	private void addListener() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	//
	private void buildPanel() {
		JPanel pcc,p1,p2,p3,p4,p5;
		JLabel lb1,lb2,lb3,lb4,lb5,lb6; 
		
		panelMain = new JPanel(new BorderLayout(0,5));
		pcc		  = new JPanel(new GridLayout(5,1));
		p1		  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
		p2 	      = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
		p3 		  = new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
		p4 		  = new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
		p5 		  = new JPanel(new FlowLayout(FlowLayout.CENTER,35,0));
		
		lb1 	  = new JLabel("         ԭ���䣺");
		lb2 	  = new JLabel("         ����Ϊ��");
		lb3 	  = new JLabel("     ���ۣ�");
		lb4 	  = new JLabel(" ע������ͬ�෿��ʱ������Ч��");
		lb5 	  = new JLabel();
		lb6 	  = new JLabel();
		lbA		  = new JLabel("BD001");
		
		chk       = new JCheckBox("    ����ԭ����ķ����");
		bt1 	  = new TJButton ("pic/save.gif", "ȷ��", "ȷ����Ϣ"); 
		bt2 	  = new TJButton ("pic/u01.gif", "ȡ��", "ȡ�����"); 
		
		tf1       = new TJTextField(5);
		tf2       = new TJMoneyField("0.00",5);
		
		p1.add(lb1);
		p1.add(lbA);
		p2.add(lb2);
		p2.add(tf1);
		p2.add(lb3);
		p2.add(tf2);
		p3.add(chk);
		p4.add(lb4);
		p5.add(bt1);
		p5.add(bt2);
		
		pcc.add(p1);
		pcc.add(p2);
		pcc.add(p3);
		pcc.add(p4);
		pcc.add(p5);
		
		
		panelMain.add("North",lb5);
		panelMain.add(pcc);
		panelMain.add("South",lb6);
	} 
	
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o==bt1) {
			this.setVisible(false);//ȷ��
		}
		else if(o==bt2) {
			this.setVisible(false);//ȡ��
		}
	}
}