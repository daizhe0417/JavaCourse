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
import com.sunshine.mainframe.*;

public class ModiEngage 
extends JDialog 
implements ActionListener,MouseListener {
	
	public static DefaultTableModel dtm1;	
	public static JComboBox cb1,cb2;
	public static JTextField tf,tf1,tf2,tf3,tf4;
	public static JTextArea ta;
	public static JCheckBox chk;
	private JTable tb1;
	private JScrollPane sp1,sp2;
	private JButton bt1,bt2;
	private JPanel panelMain,pc,ps,pcc,pcs,pccs,pccw,pccwc,pccwc1,pccwc2;
	
	public ModiEngage (JDialog dialog) {
		super(dialog, "�ͷ�Ԥ���޸�",true);
		
		panelMain = new JPanel(new BorderLayout ());
		ps = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));//�Ű�ť
		pc = new JPanel(new BorderLayout());//��ȥ��ť����ַ���һ�������
		buildPane();
		panelMain.add(pc);
		panelMain.add("South",ps);
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (280,415));
		this.setMinimumSize (new Dimension (280,415));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
		
	}
	
	private void addListener() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		cb1.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
	}
	
	private void buildPane() {
		
		pcs = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));//����JCheckBox
		pcc = new JPanel(new BorderLayout());//���ñ�ע����,tf���µĿؼ�
		pccs = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));//���ñ�ע
		pccw = new JPanel(new BorderLayout());//�����б���ߵĿؼ�
		pccwc = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));//������д��Ŀ
		pccwc1 = new JPanel(new GridLayout(6,1,0,14));//���ñ�ǩ
		pccwc2 = new JPanel(new GridLayout(6,1,0,5));//�����ı���������б��

		JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
		lb1 = new JLabel("��������");
		lb2 = new JLabel("��ϵ�绰��");
		lb3 = new JLabel("Ԥ�����");
		lb4 = new JLabel("�����ţ�");
		lb5 = new JLabel("Ԥ��ʱ�䣺");
		lb6 = new JLabel("����ʱ�䣺");

		pccwc1.add(lb1);
		pccwc1.add(lb2);
		pccwc1.add(lb3);
		pccwc1.add(lb4);
		pccwc1.add(lb5);
		pccwc1.add(lb6);
		
		tf1 = new JTextField(12);
		tf2 = new JTextField(12);
		tf3 = new TJTextField(12);
		tf4 = new TJTextField(12);
		tf1.setEditable(false);
		tf2.setEditable(false);
		cb1 = new JComboBox();//////////////������ˢ��
		sunsql.initJComboBox(cb1,"select r_type from roomtype where delmark = 0");
		cb2 = new JComboBox();
		String s = cb1.getSelectedItem()+"";
		sunsql.initJComboBox(cb2,"select a.id from roominfo as a,roomtype as b where b.r_type = '"+s+"' and a.r_type_id = b.id and a.state = '�ɹ�' and a.delmark = 0 and b.delmark = 0");
		
		pccwc2.add(tf1);
		pccwc2.add(tf2);
		pccwc2.add(cb1);
		pccwc2.add(cb2);
		pccwc2.add(tf3);
		pccwc2.add(tf4);
		
		pccwc.add(pccwc1);
		pccwc.add(pccwc2);
				
		pccw.add(pccwc);
		
		dtm1 = new DefaultTableModel();
		tb1	 = new JTable(dtm1);
		sp1  = new JScrollPane(tb1);
		String sqlCode1 = "select a.r_type Ԥ�����,b.r_no ���� from roomtype as a,engage1 as b where a.id = b.r_type_id";
		sunsql.initDTM(dtm1,sqlCode1);
		
		lb8 = new JLabel("������ע��");
		ta  = new TJTextArea(3,12);
		sp2 = new JScrollPane(ta);
		
		pccs.add(lb8);
		pccs.add(sp2);
		
		pcc.add("South",pccs);
		pcc.add(pccw);
		
		chk = new JCheckBox("�����ﱣ��ʱ���Ƿ��Զ�ȡ��Ԥ��");
		
		pcs.add(chk);

		bt1 = new TJButton ("pic/save.gif", "��  ��", "����Ԥ����Ϣ"); 
		bt2 = new TJButton ("pic/cancel.gif", "ȡ  ��", "ȡ�����"); 
		
		ps.add(bt1);
		ps.add(bt2);
		
		tf = new JTextField("��Ԥ����Ϣ");
		tf.setHorizontalAlignment (JTextField.CENTER);
		tf.setBackground(new Color(199,183,143));
		tf.setBorder(new LineBorder(new Color(87,87,47)));
		tf.setEditable(false);
		
		pc.add("North",tf);
		pc.add(pcc);
		pc.add("South",pcs);
		pc.setBorder(BorderFactory.createTitledBorder(""));
	}
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		String r_type,r_no,pa_time,keep_time,remark;
		r_type = cb1.getSelectedItem()+"";
		r_no = cb2.getSelectedItem()+"";
		pa_time = tf3.getText();
		keep_time = tf4.getText();
		remark = ta.getText();
		
		if(o==bt1) {
			//===============================================����,���������
			if(r_no.equals("")||pa_time.equals("")||keep_time.equals("")) {
				JOptionPane.showMessageDialog(null,"Ԥ����Ϣ�п�ֵ����������д��");
				return;
			}else {//
				if(!suntools.isDate(pa_time)) {  //�ж�Ԥ�������Ƿ�Ϸ�
					JOptionPane.showMessageDialog(null,"Ԥ��ʱ����������,����ȷ����(yyyy-mm-dd)");
					tf3.setText("");
					tf3.requestFocus();
				}else if(!suntools.isDate(tf4.getText())) {  //�жϱ���ʱ���Ƿ�Ϸ�
					JOptionPane.showMessageDialog(null,"����ʱ����������,����ȷ����(yyyy-mm-dd)");
					tf4.setText("");
					tf4.requestFocus();
				}else {
					String sqlCode[] = new String[3];
					
				    //���·�����Ϣ
				    String r_type_id0 = "";
				    String r_type0 = Engage.r_type;
				   	String r_no0 = Engage.r_no;
					try {
						ResultSet rs = sunsql.executeQuery("select id from roomtype where r_type = '"+r_type0+"'");
						rs.next();
						r_type_id0 = rs.getString(1);//ȡ����ѡ����Ӧ�ķ������ͱ��
				    }
				    catch (Exception ex) {
				    	ex.printStackTrace();
				    }
				   	sqlCode[0] = "update roominfo set state = '�ɹ�' where id = '"+r_no0+"' and delmark = 0";
					RightTopPanel.setViewListButtonImage(r_type_id0,r_no0,"�ɹ�");
					//����Ԥ����Ϣ
					String eng_time = Journal.getNowDTime();			
					String r_type_id = "";
					try {
						ResultSet rs = sunsql.executeQuery("select id from roomtype where r_type = '"+r_type+"'");
						rs.next();
						r_type_id = rs.getString(1);//ȡ����ѡ����Ӧ�ķ������ͱ��
				    }
				    catch (Exception ex) {
				    	ex.printStackTrace();
				    }
				    long pk = Engage.pk;
				    if(chk.isSelected()) {
				    	sqlCode[1] = "update engage set r_type_id = '"+r_type_id+"',r_no = '"+r_no+"',pa_time = '"+pa_time+"',keep_time = '"+keep_time+"',eng_time = '"+eng_time+"',cluemark = 1,remark = '"+remark+"' where pk = "+pk;
				    }else {
				    	sqlCode[1] = "update engage set r_type_id = '"+r_type_id+"',r_no = '"+r_no+"',pa_time = '"+pa_time+"',keep_time = '"+keep_time+"',eng_time = '"+eng_time+"',cluemark = 0,remark = '"+remark+"' where pk = "+pk;
				    }
				    sqlCode[2] = "update roominfo set state = 'Ԥ��' where id = '"+r_no+"' and delmark = 0";
				    RightTopPanel.setViewListButtonImage(r_type_id,r_no,"Ԥ��");
				    
				    int count = sunsql.runTransaction(sqlCode);
					if(count!=3) {
						JOptionPane.showMessageDialog(null, "�ύʧ�ܣ������������� ...", "����", JOptionPane.ERROR_MESSAGE);
						return;
					}
				    		
					this.setVisible(false);
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					ta.setText("");
				}
			}	
			
		}
		else if(o==bt2) {
			//ȡ��
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			ta.setText("");
			this.setVisible(false);
		}
		else if(o==cb1) {
			String type = cb1.getSelectedItem()+"";
			String sql = "select a.id from roominfo as a,roomtype as b where a.delmark = 0 and b.delmark = 0 and a.r_type_id = b.id and b.r_type = '"+type+"' and a.state = '�ɹ�'";
			sunsql.initJComboBox(cb2,sql);
		}
		else if(o==tf3) {
			//�ж�ʱ���Ƿ�Ϸ�
			if(!suntools.isDate(pa_time)) {
				//�����ڲ��Ϸ�
				JOptionPane.showMessageDialog(null,"������������,����ȷ����(yyyy-mm-dd)");
				tf3.setText("");
				tf3.requestFocus();
			}else {//�����ںϷ�
				tf4.requestFocus();
			}
		}
		else if(o==tf4) {
			//�ж�ʱ���Ƿ�Ϸ�
			if(!suntools.isDate(tf4.getText())) {
				//�����ڲ��Ϸ�
				JOptionPane.showMessageDialog(null,"������������,����ȷ����(yyyy-mm-dd)");
				tf4.setText("");
				tf4.requestFocus();
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
			"���淿��Ԥ����Ϣ      ���������������������������������� ��");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ȡ��Ԥ����Ϣ���      ���������������������������������� ��");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}

}