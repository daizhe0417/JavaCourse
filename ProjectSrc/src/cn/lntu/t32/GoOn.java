package cn.lntu.t32;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.sunshine.sunsdk.swing.*;

public class GoOn 
extends JDialog 
implements ActionListener {
	
	private JLabel lb1,lb2;
	private JTextField tf1,tf2;
	private JButton bt1,bt2;
	private JPanel panelMain,ps,pc;
	
	public GoOn(JFrame frame) {
		super(frame, "������ס", true);
		
		JLabel lb = new JLabel();
		panelMain = new JPanel(new BorderLayout(0,7));	//�����Ϊ�߽粼��
		ps		  = new JPanel(new FlowLayout(FlowLayout.CENTER,20,7));
		pc		  = new JPanel(new FlowLayout(FlowLayout.CENTER,10,7));
		
		buildPC();
		buildPS();
		
		panelMain.add("North",lb);
		panelMain.add(pc);
		panelMain.add("South",ps);
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (270,195));
		this.setMinimumSize (new Dimension (270,195));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
	}
	
	//�¼�����
	private void addListener() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	//�����м����
	private void buildPC() {
		JPanel pc1,pc2;
		JLabel lbA,lbB,lbC,lbD;
		lbA = new JLabel("��  ��  �ţ�");
		lbB = new JLabel("��������");
		lbC = new JLabel("��ס����");
		lbD = new JLabel("���Ѻ��");
		pc1 = new JPanel(new GridLayout(4,1,0,7));
		pc2 = new JPanel(new GridLayout(4,1,0,5));
		
		lb1 = new JLabel("BD001");/////////////////////////
		lb2 = new JLabel("����");//////////////////////////
		
		tf1 = new TJTextField(7);
		tf2 = new TJMoneyField("500.00",7);
		
		pc1.add(lbA);
		pc1.add(lbB);
		pc1.add(lbC);
		pc1.add(lbD);
		
		pc2.add(lb1);
		pc2.add(lb2);
		pc2.add(tf1);
		pc2.add(tf2);
		
		pc.add(pc1);
		pc.add(pc2);
	}
	
	//����South���
	private void buildPS() {
		bt1 = new TJButton ("pic/save.gif", "ȷ��", "ȷ����Ϣ"); 
		bt2 = new TJButton ("pic/cancel.gif", "ȡ��", "ȡ�����"); 
		
		ps.add(bt1);
		ps.add(bt2);
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