package cn.lntu.t25;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JPanel{
 /**
	 * 欢迎界面
	 */
	private static final long serialVersionUID = 4809293292305833007L;
private JLabel  jlabel=new JLabel(new ImageIcon(getClass().getResource("Hello.jpg")));
 	
	
	Welcome(){
		
		this.setLayout(null);
		jlabel.setBounds(0, 0,1000, 700);
		this.add(jlabel);
		
		
	}
}
