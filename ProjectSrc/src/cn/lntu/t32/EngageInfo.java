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

public class EngageInfo 
extends JDialog 
implements ActionListener,MouseListener {
	
	public static DefaultTableModel dtm1;	
	public static JComboBox cb1,cb2;
	public static JCheckBox chk;
	private JTable tb1;
	private JScrollPane sp1,sp2;
	private JTextField tf,tf1,tf2,tf3,tf4;
	private JTextArea ta;
	private JButton bt1,bt2,bt3;
	private JPanel panelMain,pc,ps,pcc,pcs,pccc,pccs,pccw,pccwc,pccwc1,pccwc2,pccws;
	
	public EngageInfo (JDialog dialog) {
		super(dialog, "�ͷ�Ԥ��",true);
		
		panelMain = new JPanel(new BorderLayout ());
		ps = new JPanel(new FlowLayout(FlowLayout.CENTER,200,10));//�Ű�ť
		pc = new JPanel(new BorderLayout());//��ȥ��ť����ַ���һ�������
		buildPane();
		panelMain.add(pc);
		panelMain.add("South",ps);
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (595,460));
		this.setMinimumSize (new Dimension (595,460));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
		
	}
	
	private void addListener() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		cb1.addActionListener(this);
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
		bt3.addMouseListener(this);
		
	}
	
	private void buildPane() {
		
		pcs = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));//����JCheckBox
		pcc = new JPanel(new BorderLayout());//���ñ�ע����,tf���µĿؼ�
		pccs = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));//���ñ�ע
		pccc = new JPanel(new GridLayout(1,1));//���������б�
		pccw = new JPanel(new BorderLayout());//�����б���ߵĿؼ�
		pccws = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));//����Ӱ�ť
		pccwc = new JPanel(new FlowLayout(FlowLayout.LEFT,5,10));//������д��Ŀ
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
		
		tf1 = new TJTextField(12);
		tf2 = new TJTextField(12);
		tf3 = new TJTextField(12);
		tf4 = new TJTextField(12);
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
		
		bt3 = new TJButton ("pic/add.gif", "", "��ӵ�Ԥ���б�");
		bt3.setBorderPainted(false);	//�����
		bt3.setFocusPainted(false);		//�޽����
		bt3.setContentAreaFilled(false);//����͸��ɫ
		
		lb7 = new JLabel("����ұ߰�ť���Ԥ��");
		pccws.add(lb7);
		pccws.add(bt3);
		
		pccw.add(pccwc);
		pccw.add("South",pccws);
		
		dtm1 = new DefaultTableModel();
		tb1	 = new JTable(dtm1);
		sp1  = new JScrollPane(tb1);
		String sqlCode1 = "select a.r_type Ԥ�����,b.r_no ���� from roomtype as a,engage1 as b where a.id = b.r_type_id";
		sunsql.initDTM(dtm1,sqlCode1);

		pccc.setBorder(BorderFactory.createTitledBorder("����Ԥ���ķ���"));
		pccc.add(sp1);
		
		lb8 = new JLabel("��ע��");
		ta  = new TJTextArea(3,45);
		sp2 = new JScrollPane(ta);
		
		pccs.add(lb8);
		pccs.add(sp2);
		
		pcc.add("West",pccw);
		pcc.add("South",pccs);
		pcc.add(pccc);
		
		chk = new JCheckBox("���ﱣ��ʱ���Ƿ��Զ�ȡ��Ԥ��");
		chk.setSelected(false);
		
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
		String c_name,c_tel,roomtype,r_no,pa_time,keep_time,remark;
		c_name = tf1.getText();					//��������
		c_tel = tf2.getText();					//��ϵ�绰
		roomtype = cb1.getSelectedItem()+"";	//��������
		r_no = cb2.getSelectedItem()+"";		//������
		pa_time = tf3.getText();				//Ԥ��ʱ��
		keep_time = tf4.getText();				//����ʱ��
		remark = ta.getText();					//��ע
		
		if(o==bt1) {//==============================================================����
			if(dtm1.getRowCount()==0) {  //���ұ߱����û�����
				JOptionPane.showMessageDialog(null,"�����Ԥ����Ϣ�󱣴棬��Ҫȡ������ȡ��ť��");
				return;
			}else {  //�ұ߱��������ݣ��������Ԥ����ͷ�����Ϣ����и����޸�
				int count = tb1.getRowCount();
				String sqlCode[] = new String[count + 1];
				for(int i = 0;i < count; i++) {
	   				sqlCode[i] = "update roominfo set state='Ԥ��' where id = '"+dtm1.getValueAt(i,2)+"' and delmark = 0";
					RightTopPanel.setViewListButtonImage(dtm1.getValueAt(i,0)+"",dtm1.getValueAt(i,2)+"","Ԥ��");
				}
				sqlCode[count] = "insert into engage (pk,c_name,c_tel,r_type_id,r_no,pa_time,keep_time,eng_time,cluemark,remark) "+
								 "(select pk,c_name,c_tel,r_type_id,r_no,pa_time,keep_time,eng_time,cluemark,remark from engage1)";
				count = sunsql.runTransaction(sqlCode);
				if(sqlCode.length != count) {
					JOptionPane.showMessageDialog(null, "�ύʧ�ܣ������������� ...", "����", JOptionPane.ERROR_MESSAGE);
					for (int i = 0; i < count; i++) {
						RightTopPanel.setViewListButtonImage(dtm1.getValueAt(i,0)+"",dtm1.getValueAt(i,2)+"","�ɹ�");
				    }//Endfor
					return;
				}
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				ta.setText("");
				cb1.setSelectedItem("��׼���˼�");
				cb2.setSelectedItem("");
			}
			
			this.setVisible(false);
			
			
		}
		else if(o==bt2) {
			//ȡ��
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			ta.setText("");
			cb1.setSelectedItem("��׼���˼�");
			cb2.setSelectedItem("");
			this.setVisible(false);
		}
		else if(o==bt3) {
			//���Ԥ��
			if(c_name.equals("")||c_tel.equals("")||r_no.equals("")||pa_time.equals("")||keep_time.equals("")) {
				JOptionPane.showMessageDialog(null,"Ԥ����Ϣ�п�ֵ����������д��");
				return;
			}else {//
				if(!suntools.isNum(tf2.getText())) {//�жϵ绰�Ƿ����������
					JOptionPane.showMessageDialog(null,"��ϵ�绰�������������,����������!");
					tf2.setText("");
					tf2.requestFocus();
				}else if(!suntools.isDate(pa_time)) {  //�ж�Ԥ�������Ƿ�Ϸ�
					JOptionPane.showMessageDialog(null,"Ԥ��ʱ����������,����ȷ����(yyyy-mm-dd)");
					tf3.setText("");
					tf3.requestFocus();
				}else if(!suntools.isDate(tf4.getText())) {  //�жϱ���ʱ���Ƿ�Ϸ�
					JOptionPane.showMessageDialog(null,"����ʱ����������,����ȷ����(yyyy-mm-dd)");
					tf4.setText("");
					tf4.requestFocus();
				}else {
					try {
						ResultSet rs = sunsql.executeQuery("select r_no from engage1 where r_no = '"+r_no+"'");
						if(rs.next()) {//�ж�ҪԤ���ķ����Ƿ��Ѿ���Ԥ��
							JOptionPane.showMessageDialog(null,"�÷����Ѿ���Ԥ��,������ѡ�񷿼�!");
						}else {//Ҫ��ӵķ���Ϊ�ɹ�״̬
							String eng_time = Journal.getNowDTime();
							String r_type_id = "";
							try {
								ResultSet rs1 = sunsql.executeQuery("select id from roomtype where r_type = '"+roomtype+"'");
								rs1.next();
								r_type_id = rs1.getString(1);//ȡ����ѡ����Ӧ�ķ������ͱ��
						    }
						    catch (Exception ex) {
						    	ex.printStackTrace();
						    }
						    //��Ԥ����Ϣ������ʱ��
						    long pk = sunsql.getPrimaryKey();
						    String sqlCode = "";
						    if(chk.isSelected()) {
						    	sqlCode = "insert into engage1 (pk,c_name,c_tel,r_type_id,r_no,pa_time,keep_time,eng_time,cluemark,remark) "+
						    				 "values ("+pk+",'"+c_name+"','"+c_tel+"','"+r_type_id+"','"+r_no+"','"+pa_time+"','"+keep_time+"','"+eng_time+"',1,'"+remark+"')";
						    }else {
						    	sqlCode = "insert into engage1 (pk,c_name,c_tel,r_type_id,r_no,pa_time,keep_time,eng_time,remark) "+
						    				 "values ("+pk+",'"+c_name+"','"+c_tel+"','"+r_type_id+"','"+r_no+"','"+pa_time+"','"+keep_time+"','"+eng_time+"','"+remark+"')";
						    }		    
						   	sunsql.executeUpdate(sqlCode);
						   	//�������Ԥ����Ϣ��ʾ����
						   	String sqlCode1 = "select b.r_type_id,a.r_type Ԥ�����,b.r_no ���� from roomtype as a,engage1 as b where a.id = b.r_type_id and a.delmark = 0";
							sunsql.initDTM(dtm1,sqlCode1);
							tb1.removeColumn(tb1.getColumn("r_type_id"));
							tf1.setText("");
							tf2.setText("");
							tf3.setText("");
							tf4.setText("");
							ta.setText("");
							cb1.setSelectedItem("��׼���˼�");
							String type = cb1.getSelectedItem()+"";
							String sql = "select a.id from roominfo as a,roomtype as b where a.delmark = 0 and b.delmark = 0 and a.r_type_id = b.id and b.r_type = '"+type+"' and a.state = '�ɹ�' and a.delmark = 0";
							sunsql.initJComboBox(cb2,sql);
						}
				    }
				    catch (Exception ex) {
				    	ex.printStackTrace();
				    }
				}
			}
			
		
		}
		else if(o==cb1) {
			String type = cb1.getSelectedItem()+"";
			String sql = "select a.id from roominfo as a,roomtype as b where a.delmark = 0 and b.delmark = 0 and a.r_type_id = b.id and b.r_type = '"+type+"' and a.state = '�ɹ�' and a.delmark = 0";
			sunsql.initJComboBox(cb2,sql);
		}
		else if(o==tf1) {
			tf2.requestFocus();
		}
		else if(o==tf2) {
			if(!suntools.isNum(c_tel)||c_tel.equals("")) {//�жϵ绰�Ƿ����������
				JOptionPane.showMessageDialog(null,"��ϵ�绰������������ɻ���Ϊ��,����������!");
				tf2.setText("");
				tf2.requestFocus();
			}
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
		Object o = me.getSource();
		if(o == bt3) 
			bt3.setIcon(new ImageIcon("pic/add2.gif"));
	}

	public void mouseReleased(MouseEvent me) {
		Object o = me.getSource();
		if(o == bt3) 
			bt3.setIcon(new ImageIcon("pic/add.gif"));
	}

	public void mouseEntered (MouseEvent me) {		//����ƽ���ʾ
		Object o = me.getSource ();
		if(o == bt1) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"���淿��Ԥ����Ϣ      ���������������������������������� ��");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ȡ��Ԥ����Ϣ���      ���������������������������������� ��");
		}else if(o == bt3) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ӷ��䵽Ԥ����      ���������������������������������� ��");
			bt3.setIcon(new ImageIcon("pic/add1.gif"));
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}

	
}