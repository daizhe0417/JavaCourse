package cn.lntu.t31.UI;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SystemSetPanel extends JPanel{
	private JCheckBox ck1;
	

	SystemSetPanel(){	
		this.initialFrame();
		this.addListener();	
	}

	private void initialFrame() {
		this.setLayout(null);
		ck1 = new JCheckBox("自动更新");
		ck1.setBounds(20,20,150,100);
		ck1.setSelected(false);
		this.add(ck1);
	
	}

	private void addListener() {
		// TODO Auto-generated method stub
		
	}
	
}
