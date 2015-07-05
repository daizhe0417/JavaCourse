package cn.lntu.t13;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class RSMSWindow extends JFrame implements ActionListener,
		ListSelectionListener {
	public JList<Worker> jlist;
	public JList<String> lister;
	public DefaultListModel<Worker> listmodel;
	public DefaultListModel<String> listermodel;
	public WorkerPanel workerpanel;
	public JComboBox<String> combox[];

	public RSMSWindow(WorkerPanel wp, Worker value[], String temp[]) {
		super("���¹���ϵͳ");
		this.setSize(740, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.workerpanel = wp;
		JPanel rightpanel = new JPanel(new BorderLayout());
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				this.workerpanel, rightpanel);
		split.setDividerLocation(140);
		this.getContentPane().add(split);

		this.listmodel = new DefaultListModel<Worker>();
		if (value != null) {
			for (int j = 0; j < value.length; j++) {
				this.listmodel.addElement(value[j]);
			}
		}
		this.jlist = new JList<Worker>(this.listmodel);
		this.jlist.addListSelectionListener(this);
		// rightpanel.add(new JScrollPane(this.jlist));

		this.listermodel = new DefaultListModel<String>();
		if (temp != null) {
			for (int j = 0; j < temp.length; j++) {
				this.listermodel.addElement(temp[j]);
			}
		}
		this.lister = new JList<String>(this.listermodel);
		this.lister.addListSelectionListener(this);
		rightpanel.add(new JScrollPane(this.lister));

		JPanel buttonpanel = new JPanel();
		rightpanel.add(buttonpanel, "South");

		String str[][] = { { "���", "ɾ��", "�鿴/�����ϸ" }, { "�ؼ��ֲ�ѯ", "����ؼ���" },
				{ "����", "��������" } };
		for (int i = 0; i < str[0].length; i++) {
			JButton button = new JButton(str[0][i]);
			button.addActionListener(this);
			buttonpanel.add(button);
		}
		this.combox = new JComboBox[str[1].length];
		for (int i = 0; i < str[1].length; i++) {
			buttonpanel.add(new JLabel(str[1][i]));
			buttonpanel.add(this.combox[i] = new JComboBox<String>(str[2]));
			this.combox[i].addActionListener(this);
		}

		this.setVisible(true);
	}

	public void valueChanged(ListSelectionEvent ev) {
		int i = this.lister.getAnchorSelectionIndex();
		this.workerpanel.set(this.listmodel.getElementAt(i));
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getActionCommand().equals("���")) {
			Worker w[];
			String t[];
			w = new Worker[1];
			t = new String[1];
			w[0] = this.workerpanel.get();
			t = RSMSWindow.exchangeWorker(w);
			this.listmodel.addElement(this.workerpanel.get());
			this.listermodel.addElement(t[0]);
			try {
				DBinsert.dbinsert(w[0].name, w[0].birth, w[0].sex, w[0].depart,
						w[0].job);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (ev.getActionCommand().equals("ɾ��")) {

			if (this.listermodel.getSize() == 0) {
				JOptionPane.showMessageDialog(this, "�б��Ϊ�գ�����ɾ��");
			} else {
				int i = this.lister.getSelectedIndex();

				if (i == -1) {
					JOptionPane.showMessageDialog(this, "��ѡ���б�������");
				} else {
					Worker ww=new Worker(listmodel.get(i));
					System.out.println(ww.name);
					this.listmodel.removeElementAt(i);
					this.listermodel.removeElementAt(i);
					DBdelete.delete(ww.name);
				}
			}
		}

	}

	public static String[] exchangeWorker(Worker w[]) {
		String t[];
		t = new String[w.length];
		for (int i = 0; i < w.length; i++) {
			t[i] = new String(w[i].name + "--" + w[i].birth + "--" + w[i].sex
					+ "--" + w[i].depart + "--" + w[i].job);
		}
		return t;
	}
}
