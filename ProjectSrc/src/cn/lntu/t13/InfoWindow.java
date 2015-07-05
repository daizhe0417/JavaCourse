package cn.lntu.t13;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class InfoWindow extends JFrame implements ActionListener {
	public static String worker[] = { "����", "��������", "�Ա�", "����", "ְ��", "ְ��",
			"ѧϰ����", "��������", "��ͥ���" };

	public InfoWindow(Worker w) {
		super("������ϸ��Ϣ");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		/*
		JTextField wor[];
		wor=new JTextField[10];
		for(int i=0;i<wor.length;i++){
			wor[i]=new JTextField(worker[i]);
			wor[i].setBounds(100, 20, 22, 22);
		}
		*/
		JButton button = new JButton("ss");
		button.setBounds(0, 0, 10, 50);
		panel.add(button);
		JButton button1 = new JButton("sa");
		button.setBounds(200, 200, 50, 10);
		panel.add(button1);
		
		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String arg[]) {
		Worker w;
		w = new Worker("SDS", "0625", "man", "office", "manager");
		new InfoWindow(w);
	}
}
