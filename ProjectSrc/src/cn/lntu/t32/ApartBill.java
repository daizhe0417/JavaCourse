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

public class ApartBill 
extends JDialog 
implements ActionListener {
	private JTable tb1,tb2;
	private DefaultTableModel dtm1,dtm2;
	private JScrollPane sp1,sp2;
	private JButton bt1,bt2,bt3;
	private JTextField tf1,tfA,tfB;
	private JPanel panelMain;
	
	public ApartBill(JFrame frame) {
		super(frame,"����˵�",true);
		
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
		tf1.addActionListener(this);
	}
	
	private void buildPanel() {

		bt1 = new TJButton("pic/modi3.gif","ȷ��","ȷ�����");
		bt2 = new TJButton("pic/recall.gif","ȡ��","ȡ����");
		bt3 = new TJButton("pic/new.gif","��ӵ������","��ӵ������");
		
		tf1 = new TJTextField(5);
		tfA = new JTextField("�ɹ���ֵ��˵�");
		tfB = new JTextField("�����");
		tfA.setHorizontalAlignment (JTextField.CENTER);
		tfA.setBackground(new Color(199,183,143));
		tfA.setBorder(new LineBorder(new Color(87,87,47)));
		tfA.setEditable(false);
		tfB.setHorizontalAlignment (JTextField.CENTER);
		tfB.setBackground(new Color(199,183,143));
		tfB.setBorder(new LineBorder(new Color(87,87,47)));
		tfB.setEditable(false);
		
		dtm1 = new DefaultTableModel();
		tb1  = new JTable(dtm1);
		sp1  = new JScrollPane(tb1);
		sp1.setBorder(BorderFactory.createTitledBorder(""));
		String sqlCode = "select main_room �������,in_time ��סʱ�� from livein where account > 1 and statemark = 3 and delmark = 0";
		sunsql.initDTM(dtm1,sqlCode);
		
		dtm2 = new DefaultTableModel();
		tb2  = new JTable(dtm2);
		sp2  = new JScrollPane(tb2);
		sp2.setBorder(BorderFactory.createTitledBorder(""));
		/////////////////////////���
		
		JPanel pc,p1,p1c,p1s,p1cn,p2,p2s;
		JLabel lb1,temp;
		pc = new JPanel(new GridLayout(1,2,10,0));//�°����Ϊ��񲼾�
		lb1 = new JLabel("ָ������ţ�");
		temp = new JLabel("");
		p1 = new JPanel(new BorderLayout());//������߱��
		p1c = new JPanel(new BorderLayout());
		p1s  = new JPanel(new GridLayout(1,1));
		p1cn = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
		p2   = new JPanel(new BorderLayout());//�����ұ߱��
		p2s  = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
		
		p1cn.add(lb1);
		p1cn.add(tf1);
		p1cn.setBorder(BorderFactory.createTitledBorder(""));
		p1c.add("North",p1cn);
		p1c.add(sp1);
		p1s.add(bt3);
		p1s.setBorder(BorderFactory.createTitledBorder(""));
		p1.add("North",tfA);
		p1.add(p1c);
		p1.add("South",p1s);
		
		p2s.add(bt1);
		p2s.add(bt2);
		p2s.setBorder(BorderFactory.createTitledBorder(""));
		p2.add("North",tfB);
		p2.add(sp2);
		p2.add("South",p2s);
		
		pc.add(p1);
		pc.add(p2);
		
		panelMain.add("North",temp);
		panelMain.add(pc);
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
		else if(o==tf1) {
			
		}
	}
}