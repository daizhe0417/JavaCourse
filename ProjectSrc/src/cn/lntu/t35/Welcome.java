package cn.lntu.t35;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JPanel{
	    
	/**
	 * welcome ΩÁ√Ê
	 */
	private static final long serialVersionUID = 1L;
	private JLabel  jlabe=new JLabel(new ImageIcon(getClass().getResource("Admin.jpg")));
		Welcome(){
			
			this.setLayout(null);
			jlabe.setBounds(0, 0,800, 700);
			this.add(jlabe);
			
			
		}
	}

