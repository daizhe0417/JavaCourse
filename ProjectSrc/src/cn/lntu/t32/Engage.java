package cn.lntu.t32;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.sunshine.sunsdk.sql.*;
import com.sunshine.sunsdk.swing.*;
import com.sunshine.mainframe.*;




public class Engage 
extends JDialog 
implements ActionListener,MouseListener {
	
	public static DefaultTableModel dtm = new DefaultTableModel();
	public static long pk;
	public static String r_type,r_no;
	
	private JTable tb = new JTable(dtm);
	private JScrollPane sp = new JScrollPane(tb);
	private JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7;
	private JTextField tf1,tf2;
	private JPopupMenu pm;
	private JMenuItem mi1,mi2;
	
	EngageInfo ei  = new EngageInfo(this);
	ModiEngage em  = new ModiEngage(this);
	Eindividual ev = new Eindividual(this);
	
	public Engage(JFrame frame) {
		super (frame, "�ͻ�Ԥ��", true);
		
		JPanel panelMain,panelCent,panelNort;
		panelMain = new JPanel(new BorderLayout());
		panelNort = buildNorth();
		panelCent = buildDTM();
		
		panelMain.add("North",panelNort);
		panelMain.add(panelCent);
		addListener();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (880,508));
		this.setMinimumSize (new Dimension (880,508));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		sunswing.setWindowCenter(this);	//������Ļ����
		
	}
	
	private void addListener() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt6.addActionListener(this);
		bt7.addActionListener(this);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
		bt3.addMouseListener(this);
		bt4.addMouseListener(this);
		bt5.addMouseListener(this);
		bt6.addMouseListener(this);
		bt7.addMouseListener(this);
	}
	
	//////////////////////
	private JPanel buildNorth() {
		JPanel panelNort1 = new JPanel();
		JLabel lb = new JLabel("     �����/����/�绰:");
		tf1 = new JTextField (10);
		bt1 = new TJButton ("pic/new.gif", "����", "����Ԥ����Ϣ");
		bt2 = new TJButton ("pic/modi0.gif", "�޸�", "�޸�Ԥ����Ϣ");
		bt3 = new TJButton ("pic/del.gif", "ɾ��", "ɾ��Ԥ����Ϣ");
		bt4 = new TJButton ("pic/find.gif", "��ѯ", "��ѯԤ����Ϣ");
		bt5 = new TJButton ("pic/recall.gif", "����", "����Ԥ����Ϣ");
		bt6 = new TJButton ("pic/b1.gif", "ˢ��", "ˢ��Ԥ����Ϣ");
		bt7 = new TJButton ("pic/modi3.gif", "���跿��", "ΪԤ�����俪��");
		
		pm = new JPopupMenu();
		mi1 = new JMenuItem("����Ԥ�Ƶִ�ı���");
		mi2 = new JMenuItem("����Ԥ�Ƶִ�ı���");
		pm.addSeparator();
		pm.add(mi1);
		pm.add(mi2);
		pm.addSeparator();
		
		panelNort1.add(bt1);
		panelNort1.add(bt2);
		panelNort1.add(bt3);
		panelNort1.add(lb);
		panelNort1.add(tf1);
		panelNort1.add(bt4);
		panelNort1.add(bt5);
		panelNort1.add(bt6);
		panelNort1.add(bt7);
		
		return panelNort1;
	}
	
	
	private JPanel buildDTM () {
		JPanel panelCent1 = new JPanel(new BorderLayout());
		initDTM();
		tf2 = new JTextField("����Ԥ����Ϣ");
		tf2.setHorizontalAlignment (JTextField.CENTER);
		tf2.setBackground(new Color(199,183,143));
		tf2.setBorder(new LineBorder(new Color(87,87,47)));
		tf2.setEditable(false);
		
		panelCent1.add("North",tf2);
		panelCent1.add(sp);
		panelCent1.setBorder(BorderFactory.createTitledBorder(""));
		
		return panelCent1;
	}
	
	private void initDTM() {
		String sqlCode;
		sqlCode = "select a.pk,a.c_name ��������,a.c_tel ��ϵ�绰,b.r_type Ԥ����������,a.r_no Ԥ��������,a.pa_time Ԥ��ʱ��,a.keep_time ����ʱ��,a.eng_time Ԥ��ʱ��,a.remark ��ע,b.id,"+
				  "b.price from engage as a,roomtype as b where a.r_type_id = b.id and a.delmark = 0 and engagemark = 2 and b.delmark = 0";
		sunsql.initDTM(dtm,sqlCode);
		tb.removeColumn(tb.getColumn("pk"));
		tb.removeColumn(tb.getColumn("id"));
		tb.removeColumn(tb.getColumn("price"));
	}
	
	private boolean initMrt() {
		int row = tb.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "���ڱ���Ԥ����Ϣ����ָ����¼��","��ʾ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		pk = Long.parseLong(dtm.getValueAt(row,0)+"");
		r_type = dtm.getValueAt(row,3)+"";
		r_no = dtm.getValueAt(row,4)+"";
		ModiEngage.tf1.setText(dtm.getValueAt(row,1) + "");		
		ModiEngage.tf2.setText(dtm.getValueAt(row,2) + "");	
		ModiEngage.tf3.setText(dtm.getValueAt(row,5) + "");		
		ModiEngage.tf4.setText(dtm.getValueAt(row,6) + "");
		ModiEngage.ta.setText(dtm.getValueAt(row,8) + "");
		ModiEngage.cb1.setSelectedItem(dtm.getValueAt(row,3)+"");		
		ModiEngage.cb2.addItem(dtm.getValueAt(row,4));	
		ModiEngage.cb2.setSelectedItem(dtm.getValueAt(row,4)+"");
		try {
			String sql = "select cluemark from engage where pk = '"+pk+"'";
			ResultSet rs = sunsql.executeQuery(sql);
			if(rs.next()) {
				int cluemark = Integer.parseInt(rs.getString(1));
				if(cluemark==0) 
					ModiEngage.chk.setSelected(false);
				else
					ModiEngage.chk.setSelected(true);
			}
	    }
	    catch (Exception ex) {
	    }
		
		return true;
	}
	
	private boolean delInfo (int dr[]) {
		int rowCount = dr.length*2;
		int r =0;							//DTM��ָ��
					
		if(rowCount > 0) {					//�ж�ѡ���¼��
			int isDel = JOptionPane.showConfirmDialog (null, "ȷ��Ҫɾ��Ԥ����¼��?", "��ʾ", JOptionPane.YES_NO_OPTION);
			if(isDel == JOptionPane.YES_OPTION) {
				String sqlCode[] = new String[rowCount];
				//���SQL���
				for (int i = 0; i < rowCount; i++) {
					String pk = dtm.getValueAt(dr[r], 0)+"";
					sqlCode[i] = "update engage set delmark = 1, engagemark = 0 where pk= "+pk;
					i++;
					String r_no = dtm.getValueAt(dr[r],4)+"";
					String r_type_id = dtm.getValueAt(dr[r],9)+"";
					sqlCode[i] = "update roominfo set state = '�ɹ�' where id = '"+r_no+"' and delmark = 0";
					RightTopPanel.setViewListButtonImage(r_type_id,r_no,"�ɹ�");
					r++;		//DTM��ָ���1
			    }//Endfor
			    //������ģʽִ��SQL�����, ȷ��������ȷ, ����ֵΪ�ɹ�ִ��SQL��������
			    isDel = sunsql.runTransaction(sqlCode);		
			    if(isDel != rowCount) {			//���ɹ�ִ�е����� = ���鳤�ȣ����ʾ���³ɹ�
			    	String mm = "��ִ�е� [ " + (isDel + 1) + " ] ����¼��ɾ�����ʱ���?����п��ܱ������ն��޸�\n���������粻ͨ�� ...";
			    	JOptionPane.showMessageDialog(null, mm, "����",JOptionPane.ERROR_MESSAGE);
			    	//����ʧ�ܣ�����false
			    	for(int i = 0; i<dr.length; i++) {
			    		RightTopPanel.setViewListButtonImage(dtm.getValueAt(dr[i],4)+"",dtm.getValueAt(dr[i],9)+"","Ԥ��");
			    	}
			    	
			    	return false;
			    }//Endif
			    return true;		//���³ɹ�������true
			}//Endif
		}
		else {						//���û��ѡ�м�¼������ʾһ��
			String msg1 = "����ѡ����¼�ٰ�ɾ���!";
			JOptionPane.showMessageDialog(null, msg1, "��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}
	
	private boolean initIDV(int row) {
		try {
			//�ӷ�����Ϣ�����õ�ǰ�����״̬�ͷ������ͱ��
			ResultSet rs = null;			
			
							
				//������ŵ���������
				ev.lbA.setText(dtm.getValueAt(row, 4) + "");
				//���������͵���������
				ev.lbB.setText(dtm.getValueAt(row, 3) + "");
				//�����䵥�۵���������
				ev.lbC.setText(dtm.getValueAt(row, 10) + "");
				//�����������
				ev.tf2.setText(dtm.getValueAt(row, 1) + "");
				
				//�������ͱ��
				String clRoom = dtm.getValueAt(row, 9) + "";
				//��ô����ͷ����Ƿ���Կ����ӵ㷿
				rs = sunsql.executeQuery("select cl_room from roomtype where " +
				"delmark=0 and id='" + clRoom + "'");
				
				rs.next();
				if(rs.getString(1).equals("N")) {	//���ܿ��裬�򿪵����ڵ��ӵ�ѡ�����
					ev.chk1.setSelected(false);		//ȡ��ѡ��״̬
					ev.chk1.setEnabled(false);		//���ò�����
				}else {
					ev.chk1.setEnabled(true);		//����
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
			    ev.cb2.removeAllItems();
				for (int i = 0; i < ct; i++) {
					ev.cb2.addItem(cType[i]);
			    }//Endfor
			    ev.cb2.setSelectedItem("��ͨ����");
				
				//��ʼ�����������---------��ʱ��
				sunsql.executeUpdate("delete from roomnum");		//�����ʱ��
				sunsql.executeUpdate("insert into roomnum(roomid) values('" + 
				dtm.getValueAt(row, 4) + "')");				//���뵱ǰ������Ϣ
				//��ʼ���������ڵĿ��������
				sunsql.initDTM(ev.dtm2,"select roomid ������ from roomnum");
				
				//��ʼ��׷�ӷ����---------��ǰ���͵ĳ�ǰ��������пɹ�����
				sunsql.executeUpdate("update roominfo set indimark=0");	//ˢ�����з���Ŀ���״̬
				sunsql.executeUpdate("update roominfo set indimark=1 where id='" + 
				dtm.getValueAt(row, 4) + "'");				//���õ�ǰ����Ϊ����״̬
				//��ʼ���������ڵĿɹ������
				sunsql.initDTM(ev.dtm1,"select a.id ������1 from roominfo " +
				"a,(select id from roomtype where r_type='" + ev.lbB.getText() + 
				"') b where a.delmark=0 and a.indimark=0 and a.state='�ɹ�' and a.r_type_id=b.id");
				
			
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println ("Engage.initIDV(): false");
	    }//End try
	    return true;
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o==bt1) {
			//����Ԥ����Ϣ
			sunsql.executeUpdate("delete from engage1");
			String sqlCode = "select a.r_type Ԥ�����,b.r_no ���� from roomtype as a,engage1 as b where a.id = b.r_type_id";
			sunsql.initDTM(ei.dtm1,sqlCode);
			ei.chk.setSelected(false);
			ei.show(true);
			initDTM();
		//	sunsql.initJComboBox(ei.cb1,"select r_type from roomtype where delmark = 0");
		}
		else if(o==bt2) {
			//�޸�Ԥ����Ϣ
			if(initMrt()) {					//����ݸ��
				em.show(true);				//�޸�Ԥ����Ϣ
				initDTM();			    	//ˢ�±����
			}//Endif
		}
		else if(o==bt3) {
			//ɾ��Ԥ����Ϣ
			int rRow[] = tb.getSelectedRows();				//ɾ��Ԥ����Ϣ
			if(delInfo (rRow)) {	//ִ��ɾ�����
				initDTM();			//ˢ�·�������
			}//Endif
			
		}
		else if(o==bt4) {
			//��ѯ
			String s = tf1.getText();
			String sqlCode = "select a.c_name ��������,a.c_tel ��ϵ�绰,b.r_type Ԥ����������,a.r_no Ԥ��������,a.pa_time Ԥ��ʱ��,a.keep_time ����ʱ��,a.eng_time Ԥ��ʱ��,a.remark ��ע "+
				      "from engage as a,roomtype as b where a.r_type_id = b.id and a.delmark = 0 and b.delmark = 0 and a.engagemark = 2 and (a.c_name like '%"+s+"%' or a.r_no like '%"+s+"%' or a.c_tel like '%"+s+"%')";
			sunsql.initDTM(dtm,sqlCode);
		}
		else if(o==bt6) {
			//ˢ��
			String sqlCode = "select a.c_name ��������,a.c_tel ��ϵ�绰,b.r_type Ԥ����������,a.r_no Ԥ��������,a.pa_time Ԥ��ʱ��,a.keep_time ����ʱ��,a.eng_time Ԥ��ʱ��,a.remark ��ע "+
					  "from engage as a,roomtype as b where a.r_type_id = b.id and a.delmark = 0 and b.delmark = 0 and engagemark = 2";
			sunsql.initDTM(dtm,sqlCode);
		}
		else if(o==bt7) {	//���跿��
			int row = tb.getSelectedRow();
			if(row < 0) {
				JOptionPane.showMessageDialog(null, "����Ԥ���б���ѡ��ָ����Ԥ�����䣬���跿��", 
				"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}//Endif
			if(initIDV(row)) {
				ev.show(true);
				initDTM();
			}//Endif
		}
		else if(o==mi1) {
			//���˽���Ԥ�ֱ���
			String date = getDate();
			String start = date + " 00:00:00";
			String end = date + " 23:59:59";
			String sqlCode = "select a.c_name ��������,a.c_tel ��ϵ�绰,b.r_type Ԥ����������,a.r_no Ԥ��������,a.pa_time Ԥ��ʱ��,a.keep_time ����ʱ��,a.eng_time Ԥ��ʱ��,a.remark ��ע "+
					 		 "from engage as a,roomtype as b where a.r_type_id = b.id and a.delmark = 0 and b.delmark = 0 and engagemark = 2 and a.pa_time between '"+start+"' and '"+end+"'";
			sunsql.initDTM(dtm,sqlCode);
		}
		else if(o==mi2) {
			//��������Ԥ�ֱ���
			String date = tomorrow();
			String start = date + " 00:00:00";
			String end = date + " 23:59:59";
			String sqlCode = "select a.c_name ��������,a.c_tel ��ϵ�绰,b.r_type Ԥ����������,a.r_no Ԥ��������,a.pa_time Ԥ��ʱ��,a.keep_time ����ʱ��,a.eng_time Ԥ��ʱ��,a.remark ��ע "+
					 		 "from engage as a,roomtype as b where a.r_type_id = b.id and a.delmark = 0 and b.delmark = 0 and engagemark = 2 and a.pa_time between '"+start+"' and '"+end+"'";
			sunsql.initDTM(dtm,sqlCode);
		}
	}
	
	//ȡ�õ�ǰ������
	private String getDate() {
		GregorianCalendar gc = new GregorianCalendar();
		String year = gc.get(GregorianCalendar.YEAR)+"";
		//Ϊ�·ݲ�'0'
		String month = gc.get (GregorianCalendar.MONTH) + 1 + "";
		if( month.length() == 1)
			month = "0" + month;
		//Ϊ�첹'0'
		String day = gc.get (GregorianCalendar.DAY_OF_MONTH) + "";
		if( day.length () == 1)
			day = "0" + day;
			
		String date = year+"-"+month+"-"+day;
		return date;
	}
	
	//ȡ����һ�������
	private String tomorrow() {
		GregorianCalendar gc = new GregorianCalendar();
		int ty = gc.get(GregorianCalendar.YEAR);
		int tM = gc.get(GregorianCalendar.MONTH);
		int td = gc.get(GregorianCalendar.DAY_OF_MONTH) + 1;
		gc.set(ty, tM, td, 0, 0, 0);
		ty = gc.get(GregorianCalendar.YEAR);
		tM = gc.get(GregorianCalendar.MONTH)+1;
		td = gc.get(GregorianCalendar.DAY_OF_MONTH);
		String tomorrow = "";
		if(tM < 10) 
			tomorrow = ty + "-0" + tM;
		else 
			tomorrow = ty + "-" + tM;
		if(td < 10)
			tomorrow = tomorrow + "-0" + td;
		else
			tomorrow = tomorrow + "-" + td;
		return tomorrow;
	}
	
	/**=======================================================================**
	 *			MouseListener ����
	 **=======================================================================**
	 */
	public void mouseClicked (MouseEvent me) {
		Object o = me.getSource();
		//�������˲˵�
		if(o==bt5) {
			int x = me.getX();
			int y = me.getY();
			pm.show(bt5,x,y);
		}
	}

	public void mousePressed (MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered (MouseEvent me) {		//����ƽ���ʾ
		Object o = me.getSource ();
		if(o == bt1) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"���ӷ���Ԥ����Ϣ      ���������������������������������� ��");
		}else if(o == bt2) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"�޸ķ���Ԥ����Ϣ      ���������������������������������� ��");
		}else if(o == bt3) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ɾ���Ԥ����Ϣ      ���������������������������������� ��");
		}else if(o == bt4) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"��ѯ����Ԥ����Ϣ      ���������������������������������� ��");
		}else if(o == bt5) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"���˷���Ԥ����Ϣ      ���������������������������������� ��");
		}else if(o == bt6) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ˢ�·���Ԥ����Ϣ      ���������������������������������� ��");
		}else if(o == bt7) {
			HotelFrame.lbA.setText (HotelFrame.clue + 
			"ΪԤ�����俪����      ���������������������������������� ��");
		}
	}

	public void mouseExited (MouseEvent me) {
		HotelFrame.lbA.setText (HotelFrame.clue + "��ѡ������ ...   ����������������������������������������");
	}
}