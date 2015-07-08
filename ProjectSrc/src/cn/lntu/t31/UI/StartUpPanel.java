package cn.lntu.t31.UI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartUpPanel extends JPanel{
	
	private JLabel  jlabel=new JLabel(new ImageIcon(getClass().getResource("startup.png")));
	StartUpPanel(){	
		this.setLayout(null);
		jlabel.setBounds(0, 0,800, 700);
		this.add(jlabel);	
	}

}
