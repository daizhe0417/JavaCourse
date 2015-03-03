package cn.daizhe.lecture.ch8.C801;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ActiveImagesJApplet extends JApplet implements ActionListener {
	private Image[] images; // 图像数组
	private int index; // 图像数组下标

	private Thread athread; // 线程
	private int sleeptime; // 线程sleep时间

	private String graphfile; // 图像文件�?
	private int graphcount; // 图像张数

	private JButton button_start, button_stop; // 启动和停止按�?

	private Timer timer;

	public void init() {
		this.index = 0;
		this.athread = null;
		this.sleeptime = Integer.parseInt(this.getParameter("sleeptime")); // 获得参数
		this.graphfile = this.getParameter("graphfile");
		this.graphcount = Integer.parseInt(this.getParameter("graphcount"));
		this.images = new Image[this.graphcount];

		String fname = this.graphfile;
		int j = fname.indexOf(".");
		for (int i = 0; i < this.graphcount; i++) // �?��图像装入数组
		{
			fname = fname.substring(0, j - 1) + i + fname.substring(j); // 拼接其他图像的文件名
			images[i] = this
					.getImage(this.getDocumentBase(), "IMAGES/" + fname);
		}

		JPanel panel = new JPanel();
		button_start = new JButton("Start");
		panel.add(button_start);
		button_start.addActionListener(this);

		button_stop = new JButton("Stop");
		panel.add(button_stop);
		button_stop.addActionListener(this);

		this.setLayout(new BorderLayout());
		this.add(panel, "South");

		timer = new Timer(sleeptime, this);
		timer.start();
	}

	public void paint(Graphics g) {
		g.drawImage(this.images[this.index], 0, 0, this);
	}

	public void start() {
		// if (athread == null)
		// {
		// athread = new Thread(this);
		// athread.start(); //线程启动
		// button_start.setEnabled(false);
		// button_stop.setEnabled(true);
		// }
		timer.start();
		button_stop.setEnabled(true);
	}

	public void stop() {
		// if (athread != null)
		// {
		// athread.interrupt(); //线程中断
		// athread = null;
		// button_start.setEnabled(true);
		// button_stop.setEnabled(false);
		// }
		timer.stop();
		button_start.setEnabled(true);
	}

	// public void run()
	// {
	// while (true)
	// {
	// index = (index+1) % images.length; //下一幅图像的下标
	// repaint();
	// try
	// {
	// athread.sleep(this.sleeptime);
	// }
	// catch (InterruptedException e)
	// { //中断时抛�?
	// break; //�?��循环
	// }
	// }
	// }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			index = (index + 1) % images.length; // 下一幅图像的下标
			repaint();
		}
		if (e.getSource() == button_start) // 单击Start按钮�?
			this.start(); // 调用执行当前Applet对象的start()方法

		if (e.getSource() == button_stop) // 单击Stop按钮�?
			this.stop(); // 调用执行当前Applet对象的stop()方法
	}
}