package cn.lntu.t35;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.lntu.t35.User;

public class PersonalStuInfo extends JPanel implements ActionListener{
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel[] label = { new JLabel("姓名："),new JLabel("学号："),
			new JLabel("性别："), new JLabel("籍贯："),new JLabel("班级："),
			new JLabel("专业："),new JLabel("学院：")};
	
	private JTextField[] field = { new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField("")
			};
	private int i;
	private User user;
	public PersonalStuInfo(User user){
		this.user = user;
		initialFrame();
		addListener();
	}
	private void addListener() {
		 for (i = 0; i < field.length; i++) {
			 field[i].addActionListener(this);
			 }
		
	}
	private void initialFrame() {
		 this.setLayout(null);
		    for (i = 0; i < field.length; i++) {
			label[i].setBounds(100, 60 + 50 * i, 160, 30);
			field[i].setBounds(190, 60 + 50 * i, 160, 30);	
			field[i].setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
			field[0].setText(user.getStuname());
			field[1].setText(user.getStunum());
			field[2].setText(user.getStusex());
			field[3].setText(user.getStuhometown());
			field[4].setText(user.getStuclass());
			field[5].setText(user.getStumajor());
			field[6].setText(user.getStuinstitute());
			this.add(label[i]);
			this.add(field[i]);
			}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
