package cn.lntu.t32;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.sunshine.sunsdk.sql.*;			//������
import com.sunshine.sunsdk.swing.*;
import com.sunshine.sunsdk.system.*;
import com.sunshine.mainframe.*;			//����ܴ���


public class CheckOut 
extends JDialog 
implements ActionListener, MouseListener {
	
	public JLabel lbA, lbB, lbC, lbD, lbE, lbF, lbG, lbH;
	           //�˵���,����,����,���,Ӧ��,Ѻ��,�Ż�,����
	public DefaultTableModel dtm;
	public JTable tb;
	
	public JTextField tf1, tf2, tf3, tf;
	                 //ʵ��,֧��,��ע
	private JButton bt1, bt2;
				 //����,ȡ��
	private JScrollPane sp;
	private JPanel panelMain,p1,p2;
	
	public String inNo = "";		//��ס����
	
	
	//���캯��
	public CheckOut(JFrame frame) {
		super (frame, "�������", true);
		
		panelMain = new JPanel(new GridLayout(2, 1, 0, 0));		//�����Ϊ(2,1)��񲼾�
		p1        = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));//�ϰ벿��Ϊ(4,1)��񲼾�
		p2        = new JPanel(new BorderLayout(15, 0));		//�°벿��Ϊ�߽粼��
		
		buildP1();//�����ϰ����
		buildP2();//�����°����
		
		panelMain.add(p1);
		panelMain.add(p2);
		
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension(640, 450));
		this.setMinimumSize (new Dimension(640, 450));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
	}
	
	//���¼�����
	private void addListener() {
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
	}
	
	//�����ϰ����
	private void buildP1() {
		JPanel p11,p111,p112,p113,
			   p12,p121,p122,p123,p124,
			   p13,p131,p132,p133,
			   p14,p141,p142,p15;
		JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
		p11 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,3));	//���ý��˵���...һ��
		p111 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //���ý��˵���
		p112 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //���ý��˷���
		p113 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //���ñ�������
		p12  = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));//����Ӧ�ս��...һ��
		p121 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //����Ӧ�ս��
		p122 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //��������Ѻ��
		p123 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //�����Żݽ��
		p124 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //������ѽ��
		p13  = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));//����ʵ�ս��...һ��
		p131 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //����ʵ�ս��
		p132 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //���ñ���֧��
		p133 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //��������
		p14  = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));//���ý��˱�ע...һ��
		p141 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,3)); //���ý��˱�ע
		p142 = new JPanel(new FlowLayout(FlowLayout.LEFT,33,3)); //���ð�ť
		p15  = new JPanel(new GridLayout(3,1,0,5));
		lb1 = new JLabel("���˵��ţ�");
		lb2 = new JLabel("       ���˷��䣺");
		lb3 = new JLabel("       ��������");
		lb4 = new JLabel("��ѽ�");
		lb5 = new JLabel(" Ӧ�ս�");
		lb6 = new JLabel(" ����Ѻ��");
		lb7 = new JLabel(" �Żݽ�");
		lb8 = new JLabel("ʵ�ս�");
		lb9 = new JLabel("      ����֧����");
		lb10 = new JLabel("   ��     �㣺");
		lb11 = new JLabel("���˱�ע��");
		lb1.setFont(new Font("����",Font.BOLD,15));
		lb2.setFont(new Font("����",Font.BOLD,15));
		lb3.setFont(new Font("����",Font.BOLD,15));
		lb4.setFont(new Font("����",Font.BOLD,15));
		lb5.setFont(new Font("����",Font.BOLD,15));
		lb6.setFont(new Font("����",Font.BOLD,15));
		lb7.setFont(new Font("����",Font.BOLD,15));
		lb10.setFont(new Font("����",Font.BOLD,15));
		lb4.setForeground(Color.blue);
		lb5.setForeground(Color.blue);
		lb6.setForeground(Color.blue);
		lb7.setForeground(Color.blue);
		lb10.setForeground(Color.blue);
		////////////////////////////////////////////////////////////////////////
		lbA = new JLabel("ZD200604210001");
		lbB = new JLabel("BD001");
		lbC = new JLabel("�����");
		lbD = new JLabel("500.00");
		lbE = new JLabel("450.00");
		lbF = new JLabel("300.00");
		lbG = new JLabel("50.00");
		lbH = new JLabel("��0.00");
		////////////////////////////////////////////////////////////////////////
		lbA.setFont(new Font("����",Font.BOLD,15));
		lbB.setFont(new Font("����",Font.BOLD,15));
		lbC.setFont(new Font("����",Font.BOLD,15));
		lbD.setFont(new Font("����",Font.BOLD,15));
		lbE.setFont(new Font("����",Font.BOLD,15));
		lbF.setFont(new Font("����",Font.BOLD,15));
		lbG.setFont(new Font("����",Font.BOLD,15));
		lbH.setFont(new Font("����",Font.BOLD,15));
		lbA.setForeground(Color.blue);
		lbB.setForeground(Color.blue);
		lbC.setForeground(Color.blue);
		lbD.setForeground(Color.blue);
		lbE.setForeground(Color.red);
		lbF.setForeground(Color.red);
		lbG.setForeground(Color.red);
		lbH.setForeground(Color.red);
		tf1 = new TJMoneyField("0.00",10);
		tf2 = new TJMoneyField("0.00",10);
		tf3 = new TJTextField(20);
		
		bt1 = new TJButton("pic/u04.gif", " ��   �� ", "���㷿��");
		bt2 = new TJButton("pic/cancel.gif", " ȡ   �� ", "ȡ�����");
		
		//��һ��
		p111.add(lb1);
		p111.add(lbA);
		p112.add(lb2);
		p112.add(lbB);
		p113.add(lb3);
		p113.add(lbC);
		p11.add(p111);
		p11.add(p112);
		p11.add(p113);
		p11.setBorder(BorderFactory.createTitledBorder(""));
		
		//�ڶ���
		p121.add(lb4);
		p121.add(lbD);
		p122.add(lb5);
		p122.add(lbE);
		p123.add(lb6);
		p123.add(lbF);
		p124.add(lb7);
		p124.add(lbG);
		p12.add(p121);
		p12.add(p122);
		p12.add(p123);
		p12.add(p124);
		
		//������
		p131.add(lb8);
		p131.add(tf1);
		p132.add(lb9);
		p132.add(tf2);
		p133.add(lb10);
		p133.add(lbH);
		p13.add(p131);
		p13.add(p132);
		p13.add(p133);
		
		//������
		p141.add(lb11);
		p141.add(tf3);
		p142.add(bt1);
		p142.add(bt2);
		p14.add(p141);
		p14.add(p142);
		
		p15.add(p12);
		p15.add(p13);
		p15.add(p14);
		p15.setBorder(BorderFactory.createTitledBorder(""));
		p1.add(p11);
		p1.add(p15);
	}
	
	//�����°����
	private void buildP2() {
		JPanel p2c;
		p2c = new JPanel(new GridLayout(1,1));
		tf = new JTextField("�������ڷ�������嵥");
		tf.setEditable(false);
		tf.setBorder(new LineBorder(new Color(87,87,47)));
		tf.setBackground(new Color(199,183,143));
		tf.setHorizontalAlignment(JTextField.CENTER);
		dtm = new DefaultTableModel();
		tb	= new JTable(dtm);
		sp	= new JScrollPane(tb);
		///////////////////////����
		p2c.add(sp);
		p2.add("North",tf);
		p2.add(p2c);
		p2.setBorder(BorderFactory.createTitledBorder(""));
	}
	
	//��ʼ��DTM
	public void initDTM() {
		sunsql.initDTM(dtm, "select pk,r_type_id,r_no �����,price ����,discount �ۿ�," +
		"dis_price �ۿۼ�,account �������,money ��ѽ��,in_time ���ʱ�� from checkout_temp");
		tb.removeColumn(tb.getColumn("pk"));
		tb.removeColumn(tb.getColumn("r_type_id"));
	}
	
	/**=======================================================================**
	 *		[## private boolean isValidity() {} ]: 	�����û����������Ƿ�Ϸ�
	 *			����   ����
	 *			����ֵ ��boolean
	 *			���η� ��private
	 *			����   �������û����������Ƿ�Ϸ�
	 **=======================================================================**
	 */
	private boolean isValidity() {
		double t1 = Double.parseDouble(tf1.getText());//ʵ�ս��
		double t2 = Double.parseDouble(lbE.getText());//Ӧ�ս��
		double t3 = Double.parseDouble(lbH.getText());//����
		if(t1 < t2) {
			JOptionPane.showMessageDialog(null, "[ ʵ�ս�� ] ����С�� [ Ӧ�ս�� ]", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf1.requestFocus(true);
			return false;
		}else if(t3 < 0) {
			JOptionPane.showMessageDialog(null, "�����֧���㹻����ѷ���", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
			tf2.requestFocus(true);
			return false;
		}//Endif
		return true;
	}
	
	//����������
	private void saveCKO() {
		long ckPK = sunsql.getPrimaryKey();			//��ý����¼��PK
		String chNO = suntools.getNumber(suntools.Number_JS);	//��ý��㵥��
		String chkTime = Journal.getNowDTime();		//����ʱ��
		String reMark  = tf3.getText();				//��ע
		int count = tb.getRowCount();				//�õ��м�������¼
		String sqlCode[] = new String[count * 3];	//����SQL�������
		String riState = "�ɹ�";					//����״̬
		String stateTime = "0";						//�����״̬��ʱ
		int flag = Integer.parseInt(sunini.getIniKey("Ck_Habitus"));//�����ķ���״̬  0:�ɹ� 1:����	
		if(flag == 1) {
			riState = "�෿";
			stateTime = sunini.getIniKey("Ck_Minute");
		}//Endif
		int sc=0;
		for (int i = 0; i < count * 3; i++) {
			//����������
			sqlCode[i] = "insert into checkout(pk,chk_no,in_no,days,money,chk_time,remark) values(" +
			(ckPK + sc) + ",'" + chNO + "','" + inNo + "'," + dtm.getValueAt(sc, 6) + "," + 
			dtm.getValueAt(sc, 7) + ",'" + chkTime + "','" + reMark + "')";
			i++;
			//�����ס��Ϣ����ļ�¼״̬Ϊ�ѽ���
			sqlCode[i] = "update livein set statemark='�ѽ���' where pk='" + dtm.getValueAt(sc, 0) + "'";
			i++;
			//��ķ���״̬
			sqlCode[i] = "update roominfo set state='" + riState + "',statetime=" + stateTime + " where delmark=0 and id='" + 
			dtm.getValueAt(sc, 2) + "'";

			sc++;				//DTMָ��+1
	    }//Endfor
	    
	    flag = sunsql.runTransaction(sqlCode);		//ִ���������
	    
	    if(flag < sqlCode.length) {
		    JOptionPane.showMessageDialog(null, "���跿�����ʧ�ܣ���������" +
		    "���ӻ���ϵ����Ա", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return;					//�û���������
		}else if(flag == sqlCode.length) {
			//�������ɹ�������״̬ͼƬ
			for (int i = 0; i < tb.getRowCount(); i++) {
		    	//���״̬ͼƬ
				RightTopPanel.setViewListButtonImage(dtm.getValueAt(i, 1) + "", 
				dtm.getValueAt(i, 2) + "", riState);
			}//Endfor
			tf1.setText("0.00");		//��տؼ�
			tf2.setText("0.00");
			tf3.setText("");
			this.setVisible(false);		//�رմ���
		}//Endif
	}
	
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == bt1) {
			if(isValidity()) {
				saveCKO();				//����������
			}//Endif
		}else if(o == bt2) {			//ȡ�����
			tf1.setText("0.00");		//�����ı�������
			tf2.setText("0.00");
			tf3.setText("");
			this.setVisible(false);		//�رմ���
		}//Endif
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
			"���㵱ǰ����������Ŀ   ��������������������������������");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ȡ��������������������  ������������������������������ ");
		}//Endif
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}
	
}