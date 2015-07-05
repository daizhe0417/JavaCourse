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

public class AddHuiYuan 
extends JDialog 
implements ActionListener,MouseListener {
	
	public static JTextField tf1,tf2,tf3,tf4,tf5;
	public static JComboBox cb1;
	private JTextField tf;
	private JButton bt1,bt2;
	private JPanel panelMain;
	
	public AddHuiYuan (JDialog dialog) {
		super(dialog, "��ӻ�Ա",true);
		
		panelMain = new JPanel(new BorderLayout(0,0));
		buildPanel();
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (300,300));
		this.setMinimumSize (new Dimension (300,300));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
	}
	
	//���¼�����
	private void addListener(){
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		tf1.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
	}
	
	//�������
	private void buildPanel() {
		tf1 = new TJTextField(12);
		tf2 = new TJTextField(12);
		tf3 = new TJTextField(10);
		tf4 = new TJTextField(10);
		tf5 = new TJTextField(10);
		tf  = new JTextField("��Ա��Ϣ");
		tf.setHorizontalAlignment (JTextField.CENTER);
		tf.setBackground(new Color(199,183,143));
		tf.setBorder(new LineBorder(new Color(87,87,47)));
		tf.setEditable(false);
		
		cb1 = new JComboBox();
		cb1.addItem("��");
		cb1.addItem("Ů");
				
		bt1 = new TJButton ("pic/save.gif", "����", "�����Ա��Ϣ");
		bt2 = new TJButton ("pic/cancel.gif", "ȡ��", "ȡ�����");
		
		JLabel lb1,lb2,lb3,lb5,lb6,lb7,lb8;
		lb1 = new JLabel("��Ա��ţ�");
		lb2 = new JLabel("��Ա����");
		lb3 = new JLabel("��Ա�Ա�");
		lb5 = new JLabel("���֤�ţ�");
		lb6 = new JLabel("��ϵ�绰��");
		lb7 = new JLabel("��ϸ��ַ��");
		lb8 = new JLabel();
		
		JPanel ps,ps1,pc,pcc,pcc1,pcc2;
		ps = new JPanel();
		ps1 = new JPanel(new FlowLayout(FlowLayout.CENTER,35,0));
		pc  = new JPanel(new BorderLayout(0,5));
		pcc = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
		pcc1 = new JPanel(new GridLayout(6,1,0,14));
		pcc2 = new JPanel(new GridLayout(6,1,0,5));
		
		pcc1.add(lb1);
		pcc1.add(lb2);
		pcc1.add(lb3);
		pcc1.add(lb5);
		pcc1.add(lb6);
		pcc1.add(lb7);
		
		pcc2.add(tf1);
		pcc2.add(tf2);
		pcc2.add(cb1);
		pcc2.add(tf3);
		pcc2.add(tf4);
		pcc2.add(tf5);
		
		pcc.add(pcc1);
		pcc.add(pcc2);
		
		pc.add("North",tf);
		pc.add(pcc);
		pc.setBorder(BorderFactory.createTitledBorder(""));
		
		ps1.add(bt1);
		ps1.add(bt2);
		ps.add(ps1);
		
		panelMain.add("North",lb8);
		panelMain.add(pc);
		panelMain.add("South",ps);
	}
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o==bt1) {//=====================================����
			long pk = sunsql.getPrimaryKey();//�õ�����
			String m_id,m_name,sex,zj_no,m_tel,address;
			m_id = tf1.getText();
			m_name = tf2.getText();
			sex = cb1.getSelectedItem()+"";
			zj_no = tf3.getText();
			m_tel = tf4.getText();
			address = tf5.getText();
			if(m_id.equals("")||m_name.equals("")||zj_no.equals("")||m_tel.equals("")||address.equals("")) {
				//��������п�ֵ
				JOptionPane.showMessageDialog(null,"��Ա��Ϣ�п�ֵ�����������룡");
				return;
			}else {
				try {
					ResultSet rs = sunsql.executeQuery("select m_id from member where m_id = '"+m_id+"' and delmark = 0");
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"�û�Ա����Ѵ��ڣ����������룡");
						tf1.requestFocus();
						tf1.setText("");
					}else if(!suntools.isNum(tf4.getText())) {//�жϵ绰�Ƿ����������
						JOptionPane.showMessageDialog(null,"��ϵ�绰�������������,����������!");
						tf4.setText("");
					}else {//����ӵ���Ϣ�����Ա��
						String sqlCode = "insert into member (pk,m_id,m_name,sex,zj_no,m_tel,address)" + 
										 "values ("+pk+",'"+m_id+"','"+m_name+"','"+sex+"','"+zj_no+"','"+m_tel+"','"+address+"')";
						sunsql.executeUpdate(sqlCode);
						this.setVisible(false);
					}
			    }
			    catch (Exception ex) {
			    }		
			}
		}else if(o==bt2) {//===============================ȡ��
			this.setVisible(false);
		}else if(o==tf1) {
			tf2.requestFocus();
		}else if(o==tf3) {
			tf4.requestFocus();
		}else if(o==tf4) {
			//�жϱ���ȫ��Ϊ����
			if(!suntools.isNum(tf4.getText())) {//�жϵ绰�Ƿ����������
				JOptionPane.showMessageDialog(null,"��ϵ�绰�������������,����������!");
				tf4.setText("");
			}else {
				tf5.requestFocus();
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
			"�����Ա��Ϣ����      ���������������������������������� ��");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ȡ���Ա��Ϣ���      ���������������������������������� ��");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}
}		