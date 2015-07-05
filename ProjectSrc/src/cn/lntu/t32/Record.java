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
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.HotelFrame;

public class Record 
extends JDialog 
implements ActionListener,MouseListener {
	
	private JButton bt1,bt2;
	private JTextField tf1,tf2,tf;
	private JTable tb;
	private DefaultTableModel dtm;
	private JScrollPane sp;
	private JPanel panelMain,pc,pn;
	
	public Record(JFrame frame) {
		super (frame, "ϵͳ��־", true);
		panelMain = new JPanel(new BorderLayout());
		buildPC();
		buildPN();
		
		panelMain.add("North",pn);
		panelMain.add(pc);
		
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (800,450));
		this.setMinimumSize (new Dimension (800,450));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
		addListener();
	}
	
	private void addListener() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		tf1.addActionListener(this);
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
	}
	
	//����������
	private void buildPC() {
		pc = new JPanel(new BorderLayout(0,0));
		dtm = new DefaultTableModel();
		tb  = new JTable(dtm);
		sp  = new JScrollPane(tb);
		
		tf = new JTextField("��־��Ϣ");
		tf.setHorizontalAlignment (JTextField.CENTER);
		tf.setBackground(new Color(199,183,143));
		tf.setBorder(new LineBorder(new Color(87,87,47)));
		tf.setEditable(false);
		
		pc.add("North",tf);
		pc.add(sp);
		pc.setBorder(BorderFactory.createTitledBorder(""));
	}
	
	public void initDTM() {
		String sqlCode;
		sqlCode = "select pk,time ����ʱ��,operator ����Ա,brief ����ժҪ,content ���� from record where delmark = 0 ";
		sunsql.initDTM(dtm,sqlCode);
		tb.removeColumn(tb.getColumn("pk"));
	}
	
	//������ʼ��ֹʱ�估��ť���
	private void buildPN() {
		pn = new JPanel();
		JLabel lb1,lb4,lb7,lb;
		lb1 = new JLabel("��ʼʱ�䣺");
		lb4 = new JLabel("��      ��ֹʱ�䣺");
		lb7 = new JLabel("                   ");
		lb  = new JLabel("       ");
		
		tf1 = new TJTextField (12);
		tf2 = new TJTextField (12);
		
		bt1 = new TJButton ("pic/find.gif", "��ѯ", "��ѯ��־��Ϣ");
		bt2 = new TJButton ("pic/del.gif", "ɾ��", "ɾ����־��Ϣ");
		
		pn.add(lb1);
		pn.add(tf1);
		pn.add(lb4);
		pn.add(tf2);
		pn.add(lb7);
		pn.add(bt1);
		pn.add(lb);
		pn.add(bt2);
	}
	

	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o==bt1) {//============================================��ѯ
			String start,end;
			start = tf1.getText();
			end = tf2.getText();
			if(!suntools.isDate(end)||!suntools.isDate(start)) {
				//�����ڲ��Ϸ�
				JOptionPane.showMessageDialog(null,"ʱ����������,����ȷ����(yyyy-mm-dd)");
				tf2.setText("");
				tf1.setText("");
				tf1.requestFocus();
			}else {//�����ںϷ�
				start = tf1.getText()+" 00:00:00";
				end = tf2.getText()+" 23:59:59";
				String sqlCode = "select pk,time ����ʱ��,operator ����Ա,brief ����ժҪ,content ���� from record where delmark = 0 and time between '"+start+"' and '"+end+"' ";
				sunsql.initDTM(dtm,sqlCode);
				tb.removeColumn(tb.getColumn("pk"));
			}
			tf1.setText("");
			tf2.setText("");
		}
		else if(o==bt2) {//========================================ɾ��
			int rRow[] = tb.getSelectedRows();
			int rowCount = rRow.length;
			if(rowCount > 0) {
				int isDel = JOptionPane.showConfirmDialog (null, "ȷ��Ҫɾ����־��¼��?", "��ʾ", JOptionPane.YES_NO_OPTION);
				if(isDel == JOptionPane.YES_OPTION) {
					String sqlCode[] = new String[rowCount];
					//���SQL���
					for (int i = 0; i < rowCount; i++) {
						String pk = dtm.getValueAt(rRow[i], 0)+"";
						sqlCode[i] = "update record set delmark = 1 where pk= "+pk;
				    }//Endfor
				    //������ģʽִ��SQL�����, ȷ��������ȷ, ����ֵΪ�ɹ�ִ��SQL��������
				    isDel = sunsql.runTransaction(sqlCode);		
				    if(isDel != rowCount) {			//���ɹ�ִ�е����� = ���鳤�ȣ����ʾ���³ɹ�
				    	String mm = "��ִ�е� [ " + (isDel + 1) + " ] ����¼��ɾ�����ʱ���?����п��ܱ������ն��޸�\n���������粻ͨ�� ...";
				    	JOptionPane.showMessageDialog(null, mm, "����",JOptionPane.ERROR_MESSAGE);
				    }//Endif
				    else {
				    	initDTM();
				    }
				}//Endif
				
			}
			tf1.setText("");
			tf2.setText("");
		}
		else if(o==tf1) {
			if(!suntools.isDate(tf1.getText())) {
				//�����ڲ��Ϸ�
				JOptionPane.showMessageDialog(null,"��ʼʱ����������,����ȷ����(yyyy-mm-dd)");
				tf1.setText("");
				tf1.requestFocus();
			}else {//�����ںϷ�
				tf2.requestFocus();
			}
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
		if(o == bt1) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯϵͳ��־��Ϣ      ���������������������������������� ��");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ɾ��ϵͳ��־��Ϣ      ���������������������������������� ��");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}
}