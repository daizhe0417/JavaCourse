package cn.daizhe.lecture.ch6.C602;

/**
 * 锟铰硷拷锟斤拷锟斤拷
 * @author venice
 * @version 2012-05-03
 */
//事件处理
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//ActionEventTest类实现了ActionListener接口，则可以作为监视器
public class ActionEventTest1 extends Applet implements ActionListener {
	TextField text1, text2, text3;

	// applet的规定方法init初始化
	public void init() {
		text1 = new TextField(10);
		text2 = new TextField(10);
		text3 = new TextField(10);
		add(text1);
		add(text2);
		add(text3);
		text1.addActionListener(this);// 为事件源文本框text1注册监视器
		text2.addActionListener(this);// 为事件源文本框text2注册监视器
	}

	// 实现ActionListener接口的方法，即事件处理器
	public void actionPerformed(ActionEvent e)// e是事件对象
	{
		if (e.getSource() == text1)// getSource()方法取得事件源
		{
			String str = text1.getText();
			if (str.equals("boy")) {
				text3.setText("男孩");
			} else if (str.equals("girl")) {
				text3.setText("女孩");
			} else {
				text3.setText("没有该单词");
			}
		} else if (e.getSource() == text2) {
			String str = text2.getText();
			if (str.equals("男孩")) {
				text3.setText("boy");
			} else if (str.equals("女孩")) {
				text3.setText("girl");
			} else {
				text3.setText("没有该单词");
			}
		}
	}
}
