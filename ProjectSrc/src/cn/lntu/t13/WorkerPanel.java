package cn.lntu.t13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class WorkerPanel extends JPanel implements ActionListener {
	public JTextField texts[];
	public JRadioButton radiob[];
	public JComboBox<String> combox_depart, combox_job;
	public static String depart[] = { "office", "finance", "human", "science",
			"sell" };
	public static String job[][] = { { "manager", "secretary" },
			{ "minister", "secretary", "staff" } };

	public WorkerPanel() {
		this.setBorder(new TitledBorder("Worker"));
		this.setLayout(new GridLayout(7, 1));
		String str[][] = { { "name", "birth" }, { "name", "birth" },
				{ "man", "won" } };

		this.texts = new JTextField[str[0].length];// ---------1~4
		for (int i = 0; i < this.texts.length; i++) {
			this.add(new JLabel(str[0][i]));// ��ӱ�ǩ
			this.add(this.texts[i] = new JTextField(str[1][i]));
		}

		JPanel sexpanel = new JPanel(new GridLayout(1, 2));// -----5
		this.add(sexpanel);
		ButtonGroup buttons = new ButtonGroup();
		this.radiob = new JRadioButton[str[2].length];
		for (int i = 0; i < this.radiob.length; i++) {
			sexpanel.add(this.radiob[i] = new JRadioButton(str[2][i]));
			buttons.add(radiob[i]);
		}
		this.radiob[0].setSelected(true);

		this.add(this.combox_depart = new JComboBox<String>(WorkerPanel.depart));// --6
		this.add(this.combox_job = new JComboBox<String>(WorkerPanel.job[0]));// --7
		this.combox_depart.addActionListener(this);
	}

	public void set(Worker w) {
		if (w == null)
			return;
		this.texts[0].setText(w.name);
		this.texts[1].setText(w.birth);
		if (w.sex.equals("��")) {
			radiob[0].setSelected(true);
		} else {
			radiob[1].setSelected(true);
		}
		this.combox_depart.setSelectedItem(w.depart);
		this.combox_job.setSelectedItem(w.job);
	}

	public Worker get() {
		String s = radiob[0].isSelected() ? radiob[0].getText() : radiob[1]
				.getText();
		return new Worker(texts[0].getText(), texts[1].getText(), s,
				(String) combox_depart.getSelectedItem(),
				(String) combox_job.getSelectedItem());
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		int i = this.combox_depart.getSelectedIndex();
		if (job != null && i != -1) {
			this.combox_job.removeAllItems();
			if (i == 0) {
				for (int j = 0; j < WorkerPanel.job[0].length; j++) {

					this.combox_job.addItem(WorkerPanel.job[0][j]);
				}
			} else {
				for (int j = 0; j < WorkerPanel.job[1].length; j++) {
					this.combox_job.addItem(WorkerPanel.job[1][j]);
				}
			}
		}
	}

}
