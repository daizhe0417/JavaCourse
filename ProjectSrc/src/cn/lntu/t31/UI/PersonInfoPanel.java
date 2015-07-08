package cn.lntu.t31.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.lntu.t31.Bean.User;
import cn.lntu.t31.Dao.UserService;

@SuppressWarnings("serial")
public class PersonInfoPanel extends JPanel implements ActionListener{
	
	private JLabel  personPho;
	private JLabel  JLAccount,JLPassword,JLRealName,JLTel,JLSex,JLPower,JLUnit;
	private JTextField JFUserName,JFPassword,JFTel,JFRealName,JFPower,JFUnit;
	private JRadioButton JrbMan,JrbWoman;
	private JButton JBSubmit;
	private ButtonGroup group;
	private User user;
	private String path;
	
	PersonInfoPanel(User user) {
		this.user = user;
		path = user.getPhotoPath();
		if(path.equals("")||path==null){
			path = "G:\\项目\\javaCourse\\JavaSystem\\photo\\person.jpg";
		}
		this.initialFrame();
		this.initText();
		this.addListener();
	}

	private void initText() {
		JFUserName.setText(user.getUserName());
		JFRealName.setText(user.getRealName());
		JFUnit.setText(user.getUnit());
		JFTel.setText(user.getTel());
		if(user.getSex().equals("�?")){
			JrbMan.setSelected(true);
			JrbWoman.setSelected(false);
		}else{
			JrbMan.setSelected(false);
			JrbWoman.setSelected(true);
		}
		switch(user.getPower()){
			case "1": JFPower.setText("普�?�用�?");break;
			case "2": JFPower.setText("项目审核�?");break;
			case "3": JFPower.setText("系统管理�?");break;
		}
		
	}

	private void addListener() {
		JBSubmit.addActionListener(this);
		
	}

	private void initialFrame() {
		this.setLayout(null);
		personPho=new JLabel(new ImageIcon(path));	
		JLAccount=new JLabel("�?		�?:");
		JFUserName=new JTextField();
		JLPassword=new JLabel("�?	�?:");
		JFPassword=new JTextField("******");
		JLRealName = new JLabel("真实姓名:");
		JFRealName = new JTextField();
		JLPower = new JLabel("�?		�?:");
		JFPower= new JTextField();
		JLSex = new JLabel("�?	�?:");
		group = new ButtonGroup();
		JrbMan = new JRadioButton("�?");
		JrbWoman = new JRadioButton("�?");
	    group.add(JrbMan);
	    group.add(JrbWoman);
		JLTel = new JLabel("联系方式:");
		JFTel=new JTextField();
		JLUnit = new JLabel("工作单位:");
		JFUnit=new JTextField();
		JBSubmit=new JButton("确认修改");
		

		personPho.setBounds(150, 150,200, 250);
		JLAccount.setBounds(400,150,150,30);
		JFUserName.setBounds(480, 150, 150, 30);
		JLPassword.setBounds(400, 190, 150, 30);
		JFPassword.setBounds(480, 190, 150, 30);
		JLRealName.setBounds(400, 230, 150, 30);
		JFRealName.setBounds(480, 230, 150, 30);
		JLPower.setBounds(400, 270, 150, 30);
		JFPower.setBounds(480, 270, 150, 30);
		JLSex.setBounds(400,310,150,30);
		JrbMan.setBounds(480,310,50,30);
		JrbWoman.setBounds(550,310,50,30);
		JLTel.setBounds(400,350,150,30);
		JFTel.setBounds(480,350,150,30);
		JLUnit.setBounds(400,390,150,30);
		JFUnit.setBounds(480,390,150,30);
		JBSubmit.setBounds(430,450,180,30);
		
		JFUserName.setEditable(false);
		JFPassword.setEditable(false);
		JFPower.setEditable(false);
		JFUnit.setEditable(false);
		
		this.add(JLAccount);
		this.add(JFUserName);
		this.add(JLPassword);
		this.add(JFPassword);
		this.add(JLRealName);
		this.add(JFRealName);
		this.add(JLPower);
		this.add(JFPower);
		this.add(JLSex);
		this.add(JLTel);
		this.add(JrbMan);
		this.add(JrbWoman);
		this.add(JFTel);
		this.add(personPho);
		this.add(JLUnit);
		this.add(JFUnit);
		this.add(JBSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JBSubmit){
			String sex;
			if(JrbMan.isSelected()==true){
				sex="�?";
			}else{
				sex="�?";
			}
			int choose=JOptionPane.showConfirmDialog(getParent(), "您确认要修改吗？");
			if(choose==0){
				UserService us = new UserService();
				String [] request = {
						JFUserName.getText().toString(),
						JFRealName.getText().toString(),
						JFTel.getText().toString(),	
						sex
				};
				int res = us.updateInfo(request);
				if(res==1){
					JOptionPane.showMessageDialog(getParent(), "修改成功!");
					return;
				}else{
					JOptionPane.showMessageDialog(getParent(), "修改失败!");
					return;
				}
			}else{
				initText();
			}
		}
		
	}

}
