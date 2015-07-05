package cn.lntu.t32;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import com.sunshine.sunsdk.swing.*;		//���빫�����
import com.sunshine.sunsdk.system.*;
import com.sunshine.sunsdk.sql.*;
import com.sunshine.mainframe.*;		//����ģ�����
import com.sunshine.individual.*;		//ɢ�Ϳ���
import com.sunshine.team.*;				//���忪��
import com.sunshine.checkout.*;			//���ͽ���
import com.sunshine.engage.*;			//Ԥ������
import com.sunshine.query.*;            //Ӫҵ��ѯ
import com.sunshine.customer.*;			//�ͻ�����
import com.sunshine.netsetup.*;			//��������
import com.sunshine.setup.*;			//ϵͳ����
import com.sunshine.about.*;			//��������
import com.sunshine.menu.*;				//�����˵��еĹ��ܿ�



public class HotelFrame 
extends JFrame 
implements ActionListener, MouseListener, Runnable {
	
	//�û���Ȩ��
	public static String userid, puil;
	public static JLabel lbA, lbB;
	public static String clue = "    �� ʾ :  ";
	public static String face = "    ��ǰ�������� :  ";
	
	//������˵���ص���
	private JMenuBar mb;
	private JMenu m1, m2, m3, m4;
	private JMenuItem mi11, mi12, mi13, mi14, mi15, mi16, mi17, mi18, mi19,
					  mi21, mi22, mi23, mi24, mi25,
			  		  mi31, mi32, mi33, mi34, mi35, mi36;
	//������
	private JToolBar tb;
	private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btA;
	//�ָ����
	private JSplitPane spaneMain, spaneLeft, spaneRight;
	//ģ��ӿ�
	private JPanel panelMain, bott, jp2, jp3, jp4;
	private LeftTopPanel jp1;						//������������
	//������ʾ
	private String toolTip[] = {
		"��ɢ������ס�Ǽ�   ��������������������������������������",
		"������ס�Ǽ�   ������������������������������������������",
		"���ڱ������֧����Ϣ   ����������������������������������",
		"�����˷�����   ������������������������������������������",
		"Ϊ����Ԥ������   ����������������������������������������",
		"��ѯӪҵ���   ������������������������������������������",
		"Ϊ�Ƶ�̶��ͻ����ò���   ��������������������������������",
		"����ϵͳ���������ӷ�ʽ   ��������������������������������",
		"����ϵͳ����   ������������������������������������������",
		"����Windows  ������������������������������������������"
	};
	
	//����ģ��
	/*#######################################################################*/
		Individual idv = new Individual(this);	//ɢ�Ϳ���
		Team		tm = new Team(this);		//���忪��
		CheckOut	co = new CheckOut(this);	//���ͽ���
		Engage		eg = new Engage(this);		//�ͷ�Ԥ��
		Query		qr = new Query(this);		//Ӫҵ��ѯ
		Customer	ct = new Customer(this);	//�ͻ�����
		NetSetup	ns = new NetSetup(this);	//��������
		Setup 		st = new Setup(this);		//ϵͳ����
		About		ab = new About(this);		//�������� 
		GoOn		go = new GoOn(this);		//������ס
		Change		cg = new Change(this);		//���
	//	Remind		rm = new Remind(this);		//��������
		UniteBill	ub = new UniteBill(this);   //�ϲ��ʵ�
		ApartBill	ap = new ApartBill(this);   //����ʵ�
		Record		rc = new Record(this);		//ϵͳ��־
	/*#######################################################################*/
	
	
	
	//���캯��
	public HotelFrame (String us, String pu) {
		super ("����Ƶ����ϵͳ - ����");
		
		userid = us;		//��ò���Ա���
		puil   = pu;		//��ò���ԱȨ��
		
		panelMain = new JPanel (new BorderLayout());		//�����
		
		//�����˵�
		buildMenuBar ();
		//����������
		buildToolBar ();
		//�����ָ����
		buildSpaneMain ();
		//�������ڵ׶���Ϣ��
		buildBott ();
		
		//��������������
		panelMain.add ("North", tb);			//���빤����
		panelMain.add ("South", bott);			//���봰�ڵ׶���Ϣ��
		panelMain.add ("Center", spaneMain);	//����ָ����
		
		//����˵���
		this.setJMenuBar (mb);
		
		//���¼�����
		addListener ();
		
		this.addWindowListener (new WindowAdapter () {
			public void windowClosing (WindowEvent we) {
				quit ();
			}//End windowClosing
		});
		
		this.setContentPane (panelMain);
		this.setBounds (2, 2, 1020, 740);
		this.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
		this.setMinimumSize (new Dimension (1020, 740));	//���ô�����С�ߴ�
		this.setVisible (true);
		(new Thread(this)).start();				//��������״̬����߳�
	}
	
	//�����˵�
	private void buildMenuBar () {
		//ʵ��˵���
		mb = new JMenuBar ();
		
		//ʵ��˵�
		m1 = new JMenu ("�����Ǽ� (B)");
		m2 = new JMenu ("������� (S)");
		m3 = new JMenu ("ϵͳά�� (W)");
		
		//ʵ��˵���
		mi11 = new JMenuItem ("ɢ�Ϳ�������(G)");
		mi12 = new JMenuItem ("���忪������(M)");
		mi13 = new JMenuItem ("������ס����(Z)");
		mi14 = new JMenuItem ("��䡡��(A)");
		mi15 = new JMenuItem ("�޸ĵǼǡ���(J)");
		mi16 = new JMenuItem ("����״̬����(Z)");
		mi17 = new JMenuItem ("Ԥ�����?��(T)");
		mi18 = new JMenuItem ("�������ѡ���(L)");
		mi19 = new JMenuItem ("�˳�ϵͳ����(X)");
		mi21 = new JMenuItem ("���ͽ��ʡ���(J)");
		mi22 = new JMenuItem ("�ϲ��ʵ�����(E)");
		mi23 = new JMenuItem ("�۷��ʵ�����(F)");
		mi24 = new JMenuItem ("���������ϸ��ѯ");
		mi25 = new JMenuItem ("�����˵���ϸ��ѯ");
		mi31 = new JMenuItem ("�������á���(N)");
		mi32 = new JMenuItem ("ϵͳ���á���(X)");
		mi33 = new JMenuItem ("ϵͳ��־����(Z)");
		mi34 = new JMenuItem ("��ݱ��ݡ���(R)");
		mi35 = new JMenuItem ("�������(H)");
		mi36 = new JMenuItem ("�������ǡ���(A)");
		///////////////////////////////////////////
		mi16.setEnabled(false);//δ������ϵĹ���
		mi18.setEnabled(false);
		mi34.setEnabled(false);
		////////////////////////////////////////////
		//��֯�˵�
		m1.add (mi11);			//�����Ǽ�
		m1.add (mi12);
		m1.add (mi13);
		m1.add (mi14);
		m1.add (mi15);
		m1.add (mi16);
		m1.addSeparator();
		m1.add (mi17);
		m1.add (mi18);
		m1.addSeparator();
		m1.add (mi19);

		m2.add (mi21);			//�������
		m2.add (mi22);
		m2.add (mi23);
		//m2.addSeparator();
		//m2.add (mi24);			//���������ϸ
		//m2.add (mi25);
		m3.add (mi31);			//ϵͳά��
		m3.add (mi32);
		m3.add (mi33);
		m3.addSeparator();
		m3.add (mi34);
		m3.addSeparator();
		m3.add (mi35);
		m3.add (mi36);
		
		mb.add (m1);			//����˵���
		mb.add (m2);
		mb.add (m3);
	}
	
	//����������
	private void buildToolBar () {
		tb = new JToolBar();
		//��������
		bt1 = new TJButton ("pic/ToolBar/m01.gif", "  ɢ�Ϳ���  ", "��ɢ������ס�Ǽ�", true);
		bt2 = new TJButton ("pic/ToolBar/m02.gif", "  ���忪��  ", "������ס�Ǽ�", true);
		bt3 = new TJButton ("pic/ToolBar/m03.gif", "  ��������  ", "�����Ϣ", true);
		bt4 = new TJButton ("pic/ToolBar/m04.gif", "  ���ͽ���  ", "�����˷�����", true);
		bt5 = new TJButton ("pic/ToolBar/m05.gif", "  �ͷ�Ԥ��  ", "Ϊ����Ԥ������", true);
		bt6 = new TJButton ("pic/ToolBar/m06.gif", "  Ӫҵ��ѯ  ", "��ѯӪҵ���", true);
		bt7 = new TJButton ("pic/ToolBar/m07.gif", "  �ͻ�����  ", "Ϊ�Ƶ�̶��ͻ�����", true);
		bt8 = new TJButton ("pic/ToolBar/m08.gif", "  ��������  ", "�������ӷ�ʽ", true);
		bt9 = new TJButton ("pic/ToolBar/m09.gif", "  ϵͳ����  ", "����ϵͳ����", true);
		btA = new TJButton ("pic/ToolBar/m10.gif", "  �˳�ϵͳ  ", "����Windows", true);
		
		//�Ѱ�����빤����
		tb.addSeparator ();
		tb.add (bt1);
		tb.add (bt2);
		tb.addSeparator ();
		tb.add (bt4);
		tb.add (bt5);
		tb.add (bt6);
		tb.addSeparator ();
		tb.add (bt7);
		tb.add (bt8);
		tb.add (bt9);
		tb.addSeparator ();
		tb.add (bt3);
		tb.addSeparator ();
		tb.add (btA);
		
		//���ù��������ɸ���
		tb.setFloatable(false);
	}
	
	//���������
	private void buildSpaneMain () {
		
		jp1 = new LeftTopPanel ();		//���ĸ����Ϊ���ܽӿ�//////////////
		jp2 = new LeftBottPanel();		//�������		����ͨ��
		jp3 = new RightTopPanel();		///////////////////////////////
		jp4 = new RightBottPanel();		//�������		�����Ϣ��
		
		//����ָ����
		spaneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp1, jp2);
		spaneRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp3, jp4);
		spaneMain  = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, spaneLeft, spaneRight);
		
		//���������С�ߴ�
		jp1.setMinimumSize(new Dimension (157, 450));
		jp2.setMinimumSize(new Dimension (157, 94));
		jp3.setMinimumSize(new Dimension (875, 300));
		jp4.setMinimumSize(new Dimension (875, 94));
		spaneRight.setMinimumSize(new Dimension (875, 565));
		
		//���÷ָ����Ƿ���������
		spaneMain.setOneTouchExpandable (true);
		spaneRight.setOneTouchExpandable(true);
		
		//���ø����ĳ���ߴ�
		spaneMain.setDividerLocation (160);
		spaneLeft.setDividerLocation (450);
		spaneRight.setDividerLocation(450);
		
		//���÷ָ������
		spaneMain.setDividerSize (10);
		spaneLeft.setDividerSize (23);
		spaneRight.setDividerSize(23);
	}
	
	//����bott��
	private void buildBott () {
		JLabel lb1, lb2;
		
		lb1 = new JLabel("    �� �� �� �� �� �� ϵ ͳ    ");
		lb2 = new JLabel("    ��ǰ����Ա :  " + userid + "                  ");
		lbA = new JLabel(clue + "��ѡ������ ...   ����������������������������������������");
		lbB	= new JLabel(face + "�� �� �� �� �� �� ϵ ͳ -    ��� ��         ");
		
		//�������
		lbA.setBorder(new LineBorder(new Color(87, 87, 47)));
		lbB.setBorder(new LineBorder(new Color(87, 87, 47)));
		lb1.setBorder(new LineBorder(new Color(87, 87, 47)));
		lb2.setBorder(new LineBorder(new Color(87, 87, 47)));
		
		bott = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		
		bott.add (lb1);
		bott.add (lbA);
		bott.add (lbB);
		bott.add (lb2);
	}
	
	//���¼�����
	private void addListener () {
		mi11.addActionListener (this);		//�����Ǽ�
		mi12.addActionListener (this);
		mi13.addActionListener (this);
		mi14.addActionListener (this);
		mi15.addActionListener (this);
		mi16.addActionListener (this);
		mi17.addActionListener (this);
		mi18.addActionListener (this);
		mi19.addActionListener (this);
		mi21.addActionListener (this);		//�������
		mi22.addActionListener (this);
		mi23.addActionListener (this);
		mi24.addActionListener (this);
		mi25.addActionListener (this);
		mi31.addActionListener (this);		//ϵͳά��
		mi32.addActionListener (this);
		mi33.addActionListener (this);
		mi34.addActionListener (this);
		mi35.addActionListener (this);
		mi36.addActionListener (this);
		bt1.addActionListener (this);		//����Ӷ�������
		bt2.addActionListener (this);
		bt3.addActionListener (this);
		bt4.addActionListener (this);
		bt5.addActionListener (this);
		bt6.addActionListener (this);
		bt7.addActionListener (this);
		bt8.addActionListener (this);
		bt9.addActionListener (this);
		btA.addActionListener (this);
		bt1.addMouseListener (this);		//�����������
		bt2.addMouseListener (this);
		bt3.addMouseListener (this);
		bt4.addMouseListener (this);
		bt5.addMouseListener (this);
		bt6.addMouseListener (this);
		bt7.addMouseListener (this);
		bt8.addMouseListener (this);
		bt9.addMouseListener (this);
		btA.addMouseListener (this);
	}
	
	/**=======================================================================**
	 *		[## private void quit () {} ]: 				ϵͳ�˳�
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��private
	 *			����   ���ر�ϵͳ���������ʹ��
	 **=======================================================================**
	 */
	private void quit () {
		int flag = 0;
		String msg = "�� �� �� Ҫ �� �� ϵ ͳ �� ��";
		flag = JOptionPane.showConfirmDialog (null, msg, "��ʾ", JOptionPane.YES_NO_OPTION);
		if(flag == JOptionPane.YES_OPTION) {
			Journal.writeJournalInfo(userid, "�˳���ϵͳ", Journal.TYPE_LG);//��¼������־
			this.setVisible (false);
			System.exit (0);
		}//End if(flag == JOptionPane.YES_OPTION)
		return;
	}
	
	//ˢ���󷿼���Ϣ�����
	private void initLeftData() {
		jp1.title1.setText("");		//ˢ������Ϣ
		for (int i = 0; i < 8; i++) {
			jp1.lt[i].setText("");
	    }//Endfor
		jp1.initRoomstate();					//ˢ�·�����״̬
	}
	
	//����ݸ�ɢ�Ϳ�������
	private boolean initIDV() {
		try {
			//�ӷ�����Ϣ�����õ�ǰ�����״̬�ͷ������ͱ��
			ResultSet rs = sunsql.executeQuery("select state,r_type_id from roominfo " +
			"where delmark=0 and id='" + LeftTopPanel.title1.getText() + "'");
			
			if(!rs.next()) {		//����޽����ʾ�û�ˢ�·������
				if(LeftTopPanel.title1.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"��ѡ���������Ϊ���Ϳ��跿��", 
					"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "[ " + LeftTopPanel.title1.getText() + 
					" ] ������Ϣ�Ѹ�ģ���ˢ�·�����Ϣ����Ϊ���Ϳ��跿��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
				return false;
			}else {
				if(!rs.getString(1).equals("�ɹ�")) {		//ֻ��״̬�ǿɹ����䣬����Ϊ���Ϳ���
					JOptionPane.showMessageDialog(null, "��ѡ��շ��䣬��Ϊ���Ϳ��跿��", 
					"��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}//Endif
				
				//������ŵ���������
				Individual.lbA.setText(LeftTopPanel.title1.getText());
				//���������͵���������
				Individual.lbB.setText(LeftTopPanel.title0.getText().substring(0, 
									   LeftTopPanel.title0.getText().length()-2));
				//�����䵥�۵���������
				Individual.lbC.setText(LeftTopPanel.lt[1].getText());
				
				//�������ͱ��
				String clRoom = rs.getString(2);
				//��ô����ͷ����Ƿ���Կ����ӵ㷿
				rs = sunsql.executeQuery("select cl_room from roomtype where " +
				"delmark=0 and id='" + clRoom + "'");
				rs.next();
				if(rs.getString(1).equals("N")) {	//���ܿ��裬�򿪵����ڵ��ӵ�ѡ�����
					Individual.chk1.setSelected(false);		//ȡ��ѡ��״̬
					Individual.chk1.setEnabled(false);		//���ò�����
				}else {
					Individual.chk1.setEnabled(true);		//����
				}//Endif
				
				//������������ݸ�����
				rs = sunsql.executeQuery("select distinct c_type from customertype where " +
				"delmark = 0 and pk!=0");
				int ct = sunsql.recCount(rs);
				String cType[] = new String[ct];
				for (int i = 0; i < ct; i++) {
					rs.next();
					cType[i] = rs.getString(1);
			    }//Endfor
			    Individual.cb2.removeAllItems();
				for (int i = 0; i < ct; i++) {
					Individual.cb2.addItem(cType[i]);
			    }//Endfor
			    Individual.cb2.setSelectedItem("��ͨ����");
				
				//��ʼ�����������---------��ʱ��
				sunsql.executeUpdate("delete from roomnum");		//�����ʱ��
				sunsql.executeUpdate("insert into roomnum(roomid) values('" + 
				LeftTopPanel.title1.getText() + "')");				//���뵱ǰ������Ϣ
				//��ʼ���������ڵĿ��������
				sunsql.initDTM(Individual.dtm2,"select roomid ������ from roomnum");
				
				//��ʼ��׷�ӷ����---------��ǰ���͵ĳ�ǰ��������пɹ�����
				sunsql.executeUpdate("update roominfo set indimark=0");	//ˢ�����з���Ŀ���״̬
				sunsql.executeUpdate("update roominfo set indimark=1 where id='" + 
				LeftTopPanel.title1.getText() + "'");				//���õ�ǰ����Ϊ����״̬
				//��ʼ���������ڵĿɹ������
				sunsql.initDTM(Individual.dtm1,"select a.id ������1 from roominfo " +
				"a,(select id from roomtype where r_type='" + Individual.lbB.getText() + 
				"') b where a.delmark=0 and a.indimark=0 and a.state='�ɹ�' and a.r_type_id=b.id");
				
			}//Endif
	    }
	    catch (Exception ex) {
	    	System.out.println ("HotelFrame.initIDV(): false");
	    }//End try
	    return true;
	}
	
	//����ݸ����忪������
	private boolean initTeam() {
		try {
			//��ʼ�����������---------��ʱ��
			sunsql.executeUpdate("delete from roomnums");		//�����ʱ��
			//��ʼ���������ڵĿ��������
			Team.initDTM2();
			
			//��ʼ��׷�ӷ����---------��ǰ���͵ĳ�ǰ��������пɹ�����
			sunsql.executeUpdate("update roominfo set indimark=0");	//ˢ�����з���Ŀ���״̬
			
			//������������ݸ����忪������
			ResultSet rs = sunsql.executeQuery("select r_type from roomtype where delmark=0");
			int ct = sunsql.recCount(rs);
			String type[] = new String[ct];
			
			//�����ͷ�����ݸ����忪������
			for (int i = 0; i < ct; i++) {
				rs.next();
				type[i] = rs.getString(1);
			}//Endfor
			Team.cb.removeAllItems();
			for (int i = 0; i < ct; i++) {
				Team.cb.addItem(type[i]);
			}//Endfor
			
			//������������ݸ����忪������
			rs = sunsql.executeQuery("select distinct c_type from customertype where " +
			"delmark = 0 and pk!=0");
			ct = sunsql.recCount(rs);
			for (int i = 0; i < ct; i++) {
				rs.next();
				type[i] = rs.getString(1);
			}//Endfor
			Team.cb2.removeAllItems();
			for (int i = 0; i < ct; i++) {
				Team.cb2.addItem(type[i]);
			}//Endfor
			Team.cb2.setSelectedItem("��ͨ����");
	    }
	    catch (Exception ex) {
	    	System.out.println ("HotelFrame.initTeam(): false");
	    }//Endtry
	    return true;
	}
	
	//����ݸ���㴰��
	private boolean initCKO() {
		try {
			ResultSet rs = sunsql.executeQuery("select state,r_type_id from roominfo " +
			"where delmark=0 and id='" + LeftTopPanel.title1.getText() + "'");
			
			if(!rs.next()) {		//����޽����ʾ�û�ˢ�·������
				if(LeftTopPanel.title1.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"��ѡ��������ס�ķ������Ϊ���ͽ������", 
					"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "[ " + LeftTopPanel.title1.getText() + 
					" ] ������Ϣ�Ѹ�ģ���ˢ�·�����Ϣ����Ϊ���Ϳ��跿��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}//Endif
				return false;
			}else {
				//ֻ��״̬��ռ�û��ӵ㷿�䣬����Ϊ���ͽ���
				if(!rs.getString(1).equals("ռ��") && !rs.getString(1).equals("�ӵ�")) {
					JOptionPane.showMessageDialog(null, "��ѡ�����������ѵķ�����н�����ò���", 
					"��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}//Endif
				
				//�����㵥�Ÿ���㴰��
				co.lbA.setText(suntools.getNumber(suntools.Number_JS));
				//�����㷿�����㴰��
				co.lbB.setText(jp1.title1.getText());
				//�����������Ƹ���㴰��
				co.lbC.setText(jp1.lt[0].getText());
				//��Ѻ�����㴰��
				co.lbF.setText(jp1.lt[6].getText());
				
				//��ս����м��
				sunsql.executeUpdate("delete from checkout_temp");
				
				//����������
				rs = sunsql.executeQuery("select main_room,in_no from livein where " +
				"delmark=0 and r_no='" + co.lbB.getText() + "' and statemark='�������'");
				
				if(!rs.next()) {
					JOptionPane.showMessageDialog(null, "����ʧ�ܣ������������", 
					"��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}//Endif
				
				String mainRoom = rs.getString(1);		//ȡ���������
				co.inNo = rs.getString(2);				//����ס����Ϊ���㴰��
				
				//���������״̬��������ͨס�޻����ӵ㷿
				rs = sunsql.executeQuery("select state from roominfo where delmark=0 and id='" + mainRoom + "'"); 
				rs.next();
				int mrState = 0;    //������״̬ 0:��ͨ��ס  1:�ӵ㷿
				if(rs.getString(1).equals("�ӵ�")) {
					mrState = 1;
				}//Endif
				
				DefaultTableModel ckoDTM = new DefaultTableModel();		//�������µ����з�����Ϣ
				sunsql.initDTM(ckoDTM, "select pk,r_no,r_type_id,c_type_id,in_time,foregift from " +
				"livein where delmark=0 and main_room='" + mainRoom + "'");
				
				double total = 0;		//����ܽ��
				double shsh  = 0;		//ʵ�ս��
				double youh  = 0;		//�Żݽ��
				for (int i = 0; i < ckoDTM.getRowCount(); i++) {
					//ȡ����ǰ����ı�׼����
					rs = sunsql.executeQuery("select price,cl_price from roomtype where delmark=0 and id='" + 
					ckoDTM.getValueAt(i, 2) + "'");
					rs.next();
					double rprice = 0;
					double days	  = 0;
					if(mrState == 0) {
						rprice = rs.getDouble(1);		//��ͨ��ס����
						//�����ס����
						days   = suntools.getConsumeFactor(ckoDTM.getValueAt(i, 4) + "", Journal.getNowDTime());
					}else {
						rprice = rs.getDouble(2);		//�ӵ㷿����
						days   = suntools.getClockFactor(ckoDTM.getValueAt(i, 4) + "", Journal.getNowDTime());
					}//Endif
					
					double rd 	  = rprice * days;		//��ǰ���������ܽ��
					total 		  = total + rd;			//�ۼ������
					rs = sunsql.executeQuery("select discount from customertype where delmark=0 and " +
					"id='" + ckoDTM.getValueAt(i, 3) + "' and dis_attr='" + ckoDTM.getValueAt(i, 2) + "'");
					rs.next();
					//ȡ���������ܵ��ۿ�
					int dst 	  = rs.getInt(1);
					double ddr    = rd * dst/10;			//��ǰ����Ĵ��ۺ�۸�
					shsh		  = shsh + ddr;				//Ӧ�ս���ۼ�
					youh		  = youh + rd - ddr;		//�Żݽ���ۼ�
					
					//������м��������
					sunsql.executeUpdate("insert into checkout_temp(pk,r_type_id,r_no,price," +
					"discount,dis_price,account,money,in_time) values(" + ckoDTM.getValueAt(i, 0) +
					",'" + ckoDTM.getValueAt(i, 2) + "','" + ckoDTM.getValueAt(i, 1) + "'," + 
					rprice + "," + dst + "," + rprice * dst / 10 + "," + days + "," + ddr + ",'" + 
					ckoDTM.getValueAt(i, 4) + "')");
			    }
				
				//����ѽ�����㴰��
				co.lbD.setText(total + "");
				//��Ӧ�ս�����㴰��
				co.lbE.setText(shsh + "");
				//��ʵ�ս��
				co.tf1.setText(shsh + "");
				//���Żݽ�����㴰��
				co.lbG.setText(youh + "");
				//�����������㴰��
				co.lbH.setText(Double.parseDouble(co.lbF.getText()) - shsh + "");
				
				//ˢ�½����м�����
				co.initDTM();
				
				co.tf2.requestFocus(true);		//�����֧������
				
			}//Endif
	    }
	    catch (Exception ex) {
	    	JOptionPane.showMessageDialog(null, "����ʧ�ܣ������������", 
			"��ʾ", JOptionPane.INFORMATION_MESSAGE);
	    	ex.printStackTrace();
	    	System.out.println ("HotelFrame.initCKO(): false");
	    	return false;
	    }//End try
		return true;
	}
	
	/**=======================================================================**
	 *			ActionListener ����
	 **=======================================================================**
	 */
	public void actionPerformed (ActionEvent ae) {
		Object o = ae.getSource ();
		if(o == bt1 || o ==mi11) {//============================================
			lbB.setText(face + "ɢ �� �� ��                   ��������������-");
			if(initIDV()) {								//����ݸ�ɢ�Ϳ�������
				idv.show();								//ɢ�Ϳ���
				initLeftData();							//ˢ���󷿼���Ϣ�����
			}//Endif
		}else if(o == bt2 || o == mi12) {//=====================================
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			if(initTeam()) {							//������������ݸ����忪������
				tm.show();								//���忪��
				initLeftData();							//ˢ���󷿼���Ϣ�����
			}//Endif
		}else if(o == bt3 || o == mi36) {//=====================================
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			ab.show();									//��������
		}else if(o == bt4 || o == mi21) {//=====================================
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			if(initCKO()) {								//����ݸ���㴰��
				co.show();								//���ͽ���
				initLeftData();							//ˢ���󷿼���Ϣ�����
			}//Endif
		}else if(o == bt5 || o == mi17) {//=====================================
			lbB.setText(face + "�� �� Ԥ ��                   ��������������-");
			eg.show();									//�ͷ�Ԥ��
			initLeftData();								//ˢ���󷿼���Ϣ�����
		}else if(o == bt6) {//==================================================
			lbB.setText(face + "Ӫ ҵ �� ѯ                   ��������������-");
			qr.show();									//Ӫҵ��ѯ
		}else if(o == bt7) {//==================================================
			if(puil.equals("��ͨ����Ա")) {				//�ͻ�����
				String msg = "�Բ������Ȩ�޲��ܽ��� [ �ͻ����� ] ҳ�棬���ù���ԱID��¼ ...";
				JOptionPane.showMessageDialog(null, msg, "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			ct.show();
		}else if(o == bt8 || o == mi31) {//=====================================
			if(puil.equals("��ͨ����Ա")) {				//��������
				String msg = "�Բ������Ȩ�޲��ܽ��� [ �������� ] ҳ�棬���ù���ԱID��¼ ...";
				JOptionPane.showMessageDialog(null, msg, "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			ns.show();
		}else if(o == bt9 || o == mi32) {//=====================================
			if(puil.equals("��ͨ����Ա")) {				//ϵͳ����
				String msg = "�Բ������Ȩ�޲��ܽ��� [ �������� ] ҳ�棬���ù���ԱID��¼ ...";
				JOptionPane.showMessageDialog(null, msg, "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			lbB.setText(face + "ϵ ͳ �� ��                   ��������������-");
			st.buildDTM12("");							//ˢ�·�����Ϣ��ķ���״̬
			st.show();
			initLeftData();								//ˢ���󷿼���Ϣ�����
		}else if(o == btA || o == mi19) {//=====================================
			quit ();									//�˳�ϵͳ
		}else if(o == mi13) {//=================================================
			lbB.setText(face + "�� �� �� ס                   ��������������-");
			go.show();									//������ס
		}else if(o == mi14) {//=================================================
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			cg.show();									//���
		}else if(o == mi15) {//=================================================
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			idv.show();						//�޸ĵǼ�-------��Ҫ�޸�
		}else if(o == mi16) {//=================================================
			//����״̬
		}else if(o == mi18) {//=================================================
			//��������
			
		}else if(o == mi22) {//=================================================
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			ub.show();									//�ϲ��ʵ�
		}else if(o == mi23) {//=================================================
			lbB.setText(face + "�� �� �� ��                   ��������������-");
			ap.show();									//�۷��ʵ�
		}else if(o == mi33) {//=================================================
			lbB.setText(face + "ϵ ͳ �� ־                   ��������������-");
			rc.initDTM();								//ˢ����־�б�
			rc.show();									//ϵͳ��־
		}else if(o == mi34) {//=================================================
			//��ݱ���
		}else if(o == mi35) {//=================================================
			//�������
		}
		lbB.setText(face + "�� �� �� �� �� �� ϵ ͳ -    ��� ��         ");
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
			lbA.setText (clue + toolTip[0]);
		}else if(o == bt2) {
			lbA.setText (clue + toolTip[1]);
		}else if(o == bt3) {
			lbA.setText (clue + toolTip[2]);
		}else if(o == bt4) {
			lbA.setText (clue + toolTip[3]);
		}else if(o == bt5) {
			lbA.setText (clue + toolTip[4]);
		}else if(o == bt6) {
			lbA.setText (clue + toolTip[5]);
		}else if(o == bt7) {
			lbA.setText (clue + toolTip[6]);
		}else if(o == bt8) {
			lbA.setText (clue + toolTip[7]);
		}else if(o == bt9) {
			lbA.setText (clue + toolTip[8]);
		}else if(o == btA) {
			lbA.setText (clue + toolTip[9]);
		}
	}

	public void mouseExited (MouseEvent me) {
		lbA.setText (clue + "��ѡ������ ...   ����������������������������������������");
	}
	
	
	/**=======================================================================**
	 *		[## public void run() {} ]: 
	 *			����   ����
	 *			����ֵ ����
	 *			���η� ��public
	 *			����   ��������鷿��״̬�߳�
	 **=======================================================================**
	 */
	public void run() {
		try {
			Statement ste1 = null;
			Connection conn1 = null;
			if(sunini.getIniKey ("Default_Link").equals ("1")) {		//JDBC���ӷ�ʽ
				String user1 = sunini.getIniKey ("UserID");
				String pwd1  = sunini.getIniKey ("Password");
				String ip1   = sunini.getIniKey ("IP");
				String acc1  = sunini.getIniKey ("Access");
				String dbf1  = sunini.getIniKey ("DBFname");
				String url1  = "jdbc:microsoft:sqlserver://" + ip1 + ":" + acc1 + ";" + "databasename=" + dbf1;
				//ע����
				Class.forName ("com.microsoft.jdbc.SQLServerDriver");
				//���һ������
				conn1 = DriverManager.getConnection (url1, user1, pwd1);
			}
			else {
				//ע����										//JDBCODBC���ӷ�ʽ
				DriverManager.registerDriver (new sun.jdbc.odbc.JdbcOdbcDriver());
				//���һ������
				conn1 = DriverManager.getConnection ("jdbc:odbc:" + sunini.getIniKey("LinkName"));
			}
			
			//�����߼�����
			ste1 = conn1.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			while( true ) {
				ste1.executeUpdate("update roominfo set statetime=statetime-1 where statetime>0");
				ste1.executeUpdate("update roominfo set state='�ɹ�' where statetime=0 and state='�෿'");
				Thread.sleep(30000);
			}//End while
	    }
	    catch (Exception ex) {
	    	JOptionPane.showMessageDialog (null, "��ݿ�����ʧ��...", "����", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	    	//ex.printStackTrace();
	    }//End try
	}
/*
	public static void main (String sd[]) {
		sunswing.setWindowStyle (sunini.getIniKey ("Sys_style").charAt (0));
		new HotelFrame ("gujun", "����Ա");
	}*/
}