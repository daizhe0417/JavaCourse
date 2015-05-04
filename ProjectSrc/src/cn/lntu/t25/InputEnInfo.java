package cn.lntu.t25;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



class  InputEnInfo  extends  JPanel  implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Enterprise  enterprise;
	private EnterpriseService  service;
	private JLabel []label={new JLabel("编号"),new JLabel("公司名"),new JLabel("地址"),new JLabel("email"),new JLabel("联系电话")};
	private  JTextField  [] textfield={new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField()};
	private  JButton  submit=new  JButton("提交");
	InputEnInfo(){
		initial();
		addListener();
		
	}
	
	

	private void addListener() {
		
		submit.addActionListener(this);
		for(int i=0;i<label.length;i++){			
			textfield[i].addActionListener(this);
			
			}
	}


	private void initial() {
		this.setLayout(null);
		for(int i=0;i<label.length;i++){
		label[i].setBounds(80, 40+60*i, 80, 40);
		this.add(label[i]);
		textfield[i].setBounds(200, 40+60*i, 150, 40);
		this.add(textfield[i]);
		}
		submit.setBounds(150, 500, 80, 40);
		this.add(submit);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==textfield[0]){
		if(textfield[0].getText().equals("")){
		JOptionPane.showMessageDialog(getParent(), "内容不能为空");
		}
		else{
			textfield[1].requestFocus();
		}
	}
		
if(e.getSource()==textfield[1]){
	if(textfield[1].getText().equals("")){
		JOptionPane.showMessageDialog(getParent(), "内容不能为空");
		}
		else{
			textfield[2].requestFocus();
		}
	}
if(e.getSource()==textfield[2]){
	if(textfield[2].getText().equals("")){
		JOptionPane.showMessageDialog(getParent(), "内容不能为空");
		}
		
			else{textfield[3].requestFocus();
		}}

if(e.getSource()==textfield[3]){
	if(textfield[3].getText().equals("")){
		JOptionPane.showMessageDialog(getParent(), "内容不能为空");
		}
		/*else{
				Pattern pattern = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
				Matcher matcher = pattern.matcher(textfield[2].getText().toString());
				if(!matcher.matches()){
					JOptionPane.showMessageDialog(getParent(), "邮箱格式错误");
					textfield[3].requestFocus();
				}*/
			
				else{textfield[4].requestFocus();}
		}

if(e.getSource()==textfield[4]){
	if(textfield[4].getText().equals("")){
		JOptionPane.showMessageDialog(getParent(), "内容不能为空");
		}
		else{
			submit.requestFocus();
		}
}
	if(e.getSource()==submit){
		enterprise=new Enterprise();
		enterprise.setId(Integer.parseInt(textfield[0].getText()));
		enterprise.setName(textfield[1].getText());
		enterprise.setAddress(textfield[2].getText());
		enterprise.setEmail(textfield[3].getText());
		enterprise.setPhoneNumber(textfield[4].getText());
		service =new EnterpriseService();
		if(service.saveEnterprise(enterprise)){
			JOptionPane.showMessageDialog(getParent(),"操作成功");
			for(int i=0;i<textfield.length;i++){
				textfield[i].setText("");;
				}
			
		}
		else {
			JOptionPane.showMessageDialog(getParent(),"操作失败");
			
		}
		
	}
	}
}


class  EnterpriseInforQU  extends JPanel  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JLabel [] label={new JLabel("编号"),new JLabel("企业名"),new JLabel("地址"),new JLabel("email"),new JLabel("联系电话")};
	private  JTextField [] text={new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField()};
	private  JButton  query=new JButton("查询"),
			          update=new JButton("更新"),
			          delete=new JButton("删除");
	private  Enterprise  enterprise;
	private  EnterpriseService  service;
	
	EnterpriseInforQU(){
		initial();
		addListener();
	}
	

	private void addListener() {
		query.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
	}


	private void initial() {
		this.setLayout(null);
		for(int i=0;i<label.length;i++){
			label[i].setBounds(80, 40+60*i, 80, 40);
			this.add(label[i]);
			text[i].setBounds(200, 40+60*i, 150, 40);
			this.add(text[i]);
			text[i].setEditable(false);
			}
		text[0].setEditable(true);
		query.setBounds(400, 40, 80, 40);
		this.add(query);
		update.setBounds(200, 500, 80, 40);
		update.setVisible(false);
		delete.setBounds(400, 500, 80, 40);
		this.add(update);
		this.add(delete);
		delete.setVisible(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==query){
        	if(text[0].getText().equals("")){
        	JOptionPane.showMessageDialog(getParent(), "编号不能为空");}
        	else{
        		service=new  EnterpriseService();
             	enterprise=service.queryEnterprise(Integer.parseInt(text[0].getText()));
             	text[1].setText(enterprise.getName());
             	text[2].setText(enterprise.getAddress());
             	text[3].setText(enterprise.getEmail());
             	text[4].setText(enterprise.getPhoneNumber());
             	update.setVisible(true);
             	delete.setVisible(true);
             	text[2].setEditable(false);
    			text[3].setEditable(true);
    			text[4].setEditable(true);
        	}
        }

		if(e.getSource()==update){
			enterprise=new Enterprise();
			service=new EnterpriseService();
			enterprise.setId(Integer.parseInt(text[0].getText()));
			enterprise.setAddress(text[2].getText());
			enterprise.setEmail(text[3].getText());
			enterprise.setPhoneNumber(text[4].getText());
			if(service.updateEnterprise(enterprise)){
				JOptionPane.showMessageDialog(getParent(), "操作成功");
				
			}else{
				JOptionPane.showMessageDialog(getParent(), "操作失败");
				
			}
		
			
			
			
			
		}
		
		if(e.getSource()==delete){
			int choose=JOptionPane.showConfirmDialog(getParent(), "你确定要删除当前企业信息", "警告", JOptionPane.WARNING_MESSAGE);
			if(choose==0){
				service=new  EnterpriseService();
				if(service.deleteEnterprise(Integer.parseInt(text[0].getText()))){
					
					JOptionPane.showMessageDialog(getParent(), "操作成功");
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "操作失败");
				}
			}
		}
	}
}