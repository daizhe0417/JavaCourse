package cn.lntu.t32;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;
import com.sunshine.sunsdk.swing.*;

public class UniteBill 
extends JDialog 
implements ActionListener {
	
	private JTable tb1,tb2;
	private DefaultTableModel dtm1,dtm2;
	private JScrollPane sp1,sp2;
	private JButton bt1,bt2,bt3,bt4;
	private JTextField tf1,tf2,tfA,tfB;
	private JPanel panelMain;
	
	public UniteBill(JFrame frame) {
		super(frame,"�ϲ��˵�",true);
		
		panelMain = new JPanel(new BorderLayout(0,5));//�����Ϊ�߽粼��
		buildPanel();
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (540,410));
		this.setMinimumSize (new Dimension (540, 410));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
	}
	
	private void addListener() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		tf1.addActionListener(this);
	}
	
	private void buildPanel() {
		
		
		bt1 = new TJButton("pic/modi3.gif","ȷ��","ȷ���ϲ�");
		bt2 = new TJButton("pic/recall.gif","ȡ��","ȡ��ϲ�");
		bt3 = new TJButton("pic/new.gif","��ӵ��ϲ���","��ӵ��ϲ���");
		bt4 = new TJButton("pic/del.gif","�Ӻϲ���ɾ��","�Ӻϲ���ɾ��");
		
		tf1 = new TJTextField(5);
		tf2 = new TJTextField(5);
		tfA = new JTextField("�ڵ����");
		tfB = new JTextField("�ϲ���");
		tfA.setHorizontalAlignment (JTextField.CENTER);
		tfA.setBackground(new Color(199,183,143));
		tfA.setBorder(new LineBorder(new Color(87,87,47)));
		tfA.setEditable(false);
		tfB.setHorizontalAlignment (JTextField.CENTER);
		tfB.setBackground(new Color(199,183,143));
		tfB.setBorder(new LineBorder(new Color(87,87,47)));
		tfB.setEditable(false);
		tf2.setEditable(false);
		
		dtm1 = new DefaultTableModel();
		tb1  = new JTable(dtm1);
		sp1  = new JScrollPane(tb1);
		sp1.setBorder(BorderFactory.createTitledBorder(""));
		String sqlCode = "select r_no �����,in_time ��סʱ�� from livein where statemark = '�������' and delmark = 0";
		sunsql.initDTM(dtm1,sqlCode);
		
		dtm2 = new DefaultTableModel();
		tb2  = new JTable(dtm2);
		sp2  = new JScrollPane(tb2);
		sp2.setBorder(BorderFactory.createTitledBorder(""));
		/////////////////////////���
		
		JPanel pc,ps,pc1,pc1c,pc1cn,pc2,pc2c,pc2cn;
		JLabel lb1,lb2,temp;
		lb1 = new JLabel("ָ������ţ�");
		lb2 = new JLabel("�ϲ��������䣺");
		temp = new JLabel("");
		pc  = new JPanel(new GridLayout(1,2,10,0));
		ps  = new JPanel(new FlowLayout(FlowLayout.CENTER,70,10));
		pc1 = new JPanel(new BorderLayout());//������߱��
		pc1c = new JPanel(new BorderLayout());
		pc1cn = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
		pc2   = new JPanel(new BorderLayout());//�����ұ߱��
		pc2c  = new JPanel(new BorderLayout());
		pc2cn = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
		
		pc1cn.add(lb1);
		pc1cn.add(tf1);
		pc1cn.setBorder(BorderFactory.createTitledBorder(""));
		pc1c.add("North",pc1cn);
		pc1c.add(sp1);
		pc1.add("North",tfA);
		pc1.add(pc1c);
		pc1.add("South",bt3);
		
		pc2cn.add(lb2);
		pc2cn.add(tf2);
		pc2cn.setBorder(BorderFactory.createTitledBorder(""));
		pc2c.add("North",pc2cn);
		pc2c.add(sp2);
		pc2.add("North",tfB);
		pc2.add(pc2c);
		pc2.add("South",bt4);
		
		pc.add(pc1);
		pc.add(pc2);
		ps.add(bt1);
		ps.add(bt2);
		panelMain.add("North",temp);
		panelMain.add(pc);
		panelMain.add("South",ps);
	}
		
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o==bt1) {
			this.setVisible(false);//ȷ��
		}
		else if(o==bt2) {
			this.setVisible(false);//ȡ��
		}
		else if(o==bt3) {
			//���
		}
		else if(o==bt4) {
			//�Ƴ�
		}
		else if(o==tf1) {
			
		}
	}
}
