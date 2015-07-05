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
import com.sunshine.mainframe.HotelFrame;



public class Customer 
extends JDialog 
implements ActionListener,MouseListener {
	
	public static long pk;
	private JLabel top;
	private JTabbedPane tp;
	private JPanel panelMain;
	
	//��Ա����Ϣά��
	private JButton bt11,bt12,bt13,bt14,bt15;
	private JTextField tf11,tf1;
	private JTable tb1;
	public static DefaultTableModel dtm1;
	private JScrollPane sp1;
	
	//������Ϣһ����
	private JButton bt21,bt22;
	private JTextField tf21,tf2;
	private JTable tb2;
	private DefaultTableModel dtm2;
	private JScrollPane sp2;
	
	AddHuiYuan ahy = new AddHuiYuan(this);
	ModiHuiYuan mhy = new ModiHuiYuan(this);
	
	public Customer(JFrame frame) {
		super(frame,"�ͻ�����",true);
		
		top = new JLabel();		//�ٿո�
		panelMain = new JPanel(new BorderLayout(0,5));
		tab();					//����ϵͳ������Ŀ��ǩ���
		addListener();			//�����¼�����
		panelMain.add("North",top);
		panelMain.add("Center",tp);
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (750,500));
		this.setMinimumSize (new Dimension (750,500));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
	}
	
	private void addListener() {
		bt11.addActionListener(this);		//�Ӷ�������
		bt12.addActionListener(this);
		bt13.addActionListener(this);
		bt14.addActionListener(this);
		bt15.addActionListener(this);
		bt21.addActionListener(this);
		bt22.addActionListener(this);
		bt11.addMouseListener(this);		//��������
		bt12.addMouseListener(this);
		bt13.addMouseListener(this);
		bt14.addMouseListener(this);
		bt15.addMouseListener(this);
		bt21.addMouseListener(this);
		bt22.addMouseListener(this);
	}
	
	//����ϵͳ������Ŀ��ǩ���
	private void tab() {
		JPanel jp1,jp2;
		///////////////////////////////////////////////-----------ģ��ӿ�
		jp1 = huiYuan();		    //��Ա����Ϣά��
		jp2 = laiBin();	            //������Ϣһ����
		//////////////////////////////////////////////////////////////////
		tp = new JTabbedPane();
		tp.addTab("��Ա����Ϣά��", new ImageIcon("pic/u02.gif"), jp1);
		tp.addTab("������Ϣһ����", new ImageIcon("pic/u03.gif"), jp2);
	}
	
	//��Ա����Ϣά��
	private JPanel huiYuan() {
		
		bt11 = new TJButton ("pic/new.gif", "����", "���ӻ�Ա��Ϣ");
		bt12 = new TJButton ("pic/modi0.gif", "�޸�", "�޸Ļ�Ա��Ϣ");
		bt13 = new TJButton ("pic/del.gif", "ɾ��", "ɾ���Ա��Ϣ");
		bt14 = new TJButton ("pic/find.gif", "��ѯ", "��ѯ��Ա��Ϣ");
		bt15 = new TJButton ("pic/b1.gif", "ˢ��", "ˢ�»�Ա��Ϣ");
		
		tf11 = new TJTextField (10);
		tf1 = new JTextField("��Ա��Ϣ");
		tf1.setHorizontalAlignment (JTextField.CENTER);
		tf1.setBackground(new Color(199,183,143));
		tf1.setBorder(new LineBorder(new Color(87,87,47)));
		tf1.setEditable(false);
		
		dtm1 = new DefaultTableModel();
		tb1  = new JTable(dtm1);
		sp1  = new JScrollPane(tb1);
		//////////////////////////////��д���
		initDTM1();
		tf11.setText("");
		
		JPanel ph,pn,pc;
		ph = new JPanel(new BorderLayout());
		pn = new JPanel();
		pc = new JPanel(new BorderLayout());
		JLabel lb,lb1;
		lb = new JLabel("     ��Ա���/����");
		lb1 = new JLabel("   ");

		pn.add(bt11);
		pn.add(bt12);
		pn.add(bt13);
		pn.add(lb);
		pn.add(tf11);
		pn.add(lb1);
		pn.add(bt14);
		pn.add(bt15);
		
		pc.add("North",tf1);
		pc.add(sp1);
		pc.setBorder(BorderFactory.createTitledBorder(""));
		
		ph.add("North",pn);
		ph.add(pc);
		
		return ph;
	}
	
	//DTM1��ʼ��
	public void initDTM1() {
		String sqlCode = "select pk,m_id ��Ա���,m_name ��Ա����,sex �Ա�,zj_no ���֤��,m_tel ��ϵ�绰,address ��ϸ��ַ from member where delmark = 0";
		sunsql.initDTM(dtm1,sqlCode);
		tb1.removeColumn(tb1.getColumn("pk"));
		tf11.setText("");
	}
	
	//������Ϣһ����
	private JPanel laiBin() {
		
		tf21 = new TJTextField (10);
		tf2  = new TJTextField ("������Ϣ");
		tf2.setHorizontalAlignment (JTextField.CENTER);
		tf2.setBackground(new Color(199,183,143));
		tf2.setBorder(new LineBorder(new Color(87,87,47)));
		tf2.setEditable(false);
		
		bt21 = new TJButton ("pic/find.gif", "��ѯ", "��ѯ������Ϣ");
		bt22 = new TJButton ("pic/b1.gif", "ˢ��", "ˢ��������Ϣ");
		
		dtm2 = new DefaultTableModel();
		tb2  = new JTable(dtm2);
		sp2  = new JScrollPane(tb2);
		////////////////////////��д���
		initDTM2();
		
		JLabel lb1,lb2,lb3,lb4;
		lb1 = new JLabel("��������/֤����ţ�");
		lb2 = new JLabel("      ");
		lb3 = new JLabel("   ");
		lb4 = new JLabel("   ");
		
		JPanel pl,pn,pc; 
		pl = new JPanel(new BorderLayout());
		pn = new JPanel();
		pc = new JPanel(new BorderLayout());
		
		pn.add(lb1);
		pn.add(tf21);
		pn.add(lb2);
		pn.add(bt21);
		pn.add(lb3);
		pn.add(bt22);
		pn.add(lb4);
		
		pc.add("North",tf2);
		pc.add(sp2);
		pc.setBorder(BorderFactory.createTitledBorder(""));
		
		pl.add("North",pn);
		pl.add(pc);
		
		return pl;
	}
	
	//DTM2��ʼ��
	private void initDTM2() {
		String sqlCode = "select c_name ��������,sex �Ա�,zj_type ֤������,zj_no ֤�����,address ��ϸ��ַ from livein where delmark = 0";
		sunsql.initDTM(dtm2,sqlCode);
		tf21.setText("");
	}
	
	private boolean initMmb() {
		int row = tb1.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "���ڱ���Ԥ����Ϣ����ָ����¼��","��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		pk = Long.parseLong(dtm1.getValueAt(row,0)+"");
		ModiHuiYuan.tf1.setText(dtm1.getValueAt(row,1) + "");		
		ModiHuiYuan.tf2.setText(dtm1.getValueAt(row,2) + "");	
		ModiHuiYuan.tf3.setText(dtm1.getValueAt(row,4) + "");		
		ModiHuiYuan.tf4.setText(dtm1.getValueAt(row,5) + "");
		ModiHuiYuan.tf5.setText(dtm1.getValueAt(row,6) + "");
		ModiHuiYuan.cb1.setSelectedItem(dtm1.getValueAt(row,3)+"");		
		return true;
	}
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o==bt11) {
			//���ӻ�Ա��Ϣ
			ahy.tf1.setText("");
			ahy.tf2.setText("");
			ahy.tf3.setText("");
			ahy.tf4.setText("");
			ahy.tf5.setText("");
			ahy.cb1.setSelectedItem("��");
			ahy.tf1.requestFocus();
			ahy.show(true);
			initDTM1();
		}
		else if(o==bt12) {
			//�޸Ļ�Ա��Ϣ
			if(initMmb()) {
				mhy.show(true);
				initDTM1();
			}
		}
		else if(o==bt13) {
			//ɾ���Ա��Ϣ
			int rRow[] = tb1.getSelectedRows();
			int rowCount = rRow.length;
			if(rowCount > 0) {
				int isDel = JOptionPane.showConfirmDialog (null, "ȷ��Ҫɾ���Ա��Ϣ��?", "��ʾ", JOptionPane.YES_NO_OPTION);
				if(isDel == JOptionPane.YES_OPTION) {
					String sqlCode[] = new String[rowCount];
					//���SQL���
					for (int i = 0; i < rowCount; i++) {
						String pk = dtm1.getValueAt(rRow[i], 0)+"";
						sqlCode[i] = "update member set delmark = 1 where pk= "+pk;
				    }//Endfor
				    //������ģʽִ��SQL�����, ȷ��������ȷ, ����ֵΪ�ɹ�ִ��SQL��������
				    isDel = sunsql.runTransaction(sqlCode);		
				    if(isDel != rowCount) {			//���ɹ�ִ�е����� = ���鳤�ȣ����ʾ���³ɹ�
				    	String mm = "��ִ�е� [ " + (isDel + 1) + " ] ����¼��ɾ�����ʱ���?����п��ܱ������ն��޸�\n���������粻ͨ�� ...";
				    	JOptionPane.showMessageDialog(null, mm, "����",JOptionPane.ERROR_MESSAGE);
				    }//Endif
				    else {
				    	initDTM1();
				    }
				}//Endif
				
			}
		}
		else if(o==bt14) {
			//��ѯ��Ա��Ϣ
			String bx = tf11.getText();
			String sqlCode = "select m_id ��Ա���,m_name ��Ա����,sex �Ա�,zj_no ���֤��,m_tel ��ϵ�绰,address ��ϸ��ַ "+
							 "from member where delmark = 0 and (m_id like '%"+bx+"%' or m_name like '%"+bx+"%')";
			sunsql.initDTM(dtm1,sqlCode);
		}
		else if(o==bt15) {
			//ˢ�»�Ա��Ϣ
			initDTM1();
			tf11.setText("");
		}
		else if(o==bt21) {
			//��ѯ������Ϣ
			String cz = tf21.getText();
			String sqlCode = "select c_name ��������,sex �Ա�,zj_type ֤������,zj_no ֤�����,address ��ϸ��ַ "+
							 "from livein where delmark = 0 and (c_name like '%"+cz+"%' or zj_no like '%"+cz+"%')";
			sunsql.initDTM(dtm2,sqlCode);
		}
		else if(o==bt22) {
			//ˢ��������Ϣ
			initDTM2();
		}
		
	}
	
	/**=======================================================================**
	 *			MouseListener ����
	 **=======================================================================**
	 */
	public void mouseClicked (MouseEvent me) {
	}

	public void mousePressed (MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered (MouseEvent me) {		//����ƽ���ʾ
		Object o = me.getSource ();
		if(o == bt11) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"���ӻ�Ա����Ϣ      ���������������������������������� ��");
		}else if(o == bt12) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�޸Ļ�Ա����Ϣ      ���������������������������������� ��");
		}else if(o == bt13) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ɾ���Ա����Ϣ      ���������������������������������� ��");
		}else if(o == bt14) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯ��Ա����Ϣ      ���������������������������������� ��");
		}else if(o == bt15) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ˢ�»�Ա����Ϣ      ���������������������������������� ��");
		}else if(o == bt21) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯ������Ϣ����      ���������������������������������� ��");
		}else if(o == bt22) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ˢ��������Ϣ����      ���������������������������������� ��");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}
}