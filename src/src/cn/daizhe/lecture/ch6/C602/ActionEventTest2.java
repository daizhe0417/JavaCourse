package cn.daizhe.lecture.ch6.C602;

//��ť���ı��򡢱�ǩ���÷����Լ��¼�����
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ActionEventTest2 extends Applet implements ActionListener {
	TextField text;
	Button bEnter, bClear;

	public void init() {
		text = new TextField("0", 10);
		add(text);
		bEnter = new Button("ȷ��");
		bClear = new Button("���");
		add(bEnter);
		add(bClear);
		bEnter.addActionListener(this);
		bClear.addActionListener(this);
		text.addActionListener(this);
	}

	public void paint(Graphics g) {
		g.drawString("���ı������������ַ�س��򵥻�ȷ����ť", 10, 100);
		g.drawString("�ı�����ʾ�����ƽ����", 10, 120);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bEnter || e.getSource() == text) {
			double n = 0;
			try {
				n = Double.valueOf(text.getText()).doubleValue();
				text.setText("" + Math.sqrt(n));
			} catch (NumberFormatException event) {
				text.setText("����������");
			}
		} else if (e.getSource() == bClear) {
			text.setText("0");
		}
	}
}