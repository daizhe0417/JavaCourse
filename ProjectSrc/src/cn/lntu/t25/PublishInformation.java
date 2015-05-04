package cn.lntu.t25;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PublishInformation extends JPanel implements ActionListener,ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JLabel [] label={new  JLabel("职称"),new  JLabel("岗位职责描述"),new  JLabel("技能要求"),new  JLabel("招聘数量"),new  JLabel("性别"),new  JLabel("年龄"),new  JLabel("说明")};
	private  JTextField [] jtext={new  JTextField(),new  JTextField(),new  JTextField(),new  JTextField()}  ;
	private  JButton  button=new  JButton("提交");
	private  JTextArea  textarea=new  JTextArea();
	private  JScrollPane  scrollpane =new  JScrollPane(textarea);
	private  String []  gender={"无限制","男","女"};
	private  Integer [] year1={20,30,40,50};
	private  Integer  []year2={30,40,50,60};
	private  JComboBox<String>  combox1=new  JComboBox<String>(gender);
    private  JComboBox<Integer> combox2=new  JComboBox<Integer>(year1),
			            combox3=new JComboBox<Integer>(year2);
    private  Integer id;
    private  Job  job;
    private  JobService  jobservice;
    private  Enterprise  enterprise;
    private  EnterpriseService enterservice;
	PublishInformation(Integer id){
		this.id=id;
		initial();
		addListener();
		getenterprise();
	}

	

	private void getenterprise() {
		enterprise=new Enterprise();
		enterservice=new  EnterpriseService();
		enterprise=enterservice.queryEnterprise(id);
	}



	private void initial() {
		
		this.setLayout(null);
		for(int i=0;i<label.length;i++){
			
			label[i].setBounds(50, 50+60*i, 80, 40);
			this.add(label[i]);	
		}
		jtext[0].setBounds(200, 50, 150, 40);
		this.add(jtext[0]);
		jtext[1].setBounds(200, 110, 150, 40);
		this.add(jtext[1]);
		jtext[2].setBounds(200, 170, 150, 40);
		this.add(jtext[2]);
		jtext[3].setBounds(200, 230, 150, 40);
		this.add(jtext[3]);
		combox1.setBounds(200, 290, 80, 40);
		this.add(combox1);
		combox2.setBounds(200, 350, 80, 40);
		this.add(combox2);
		combox3.setBounds(300, 350, 80,40 );
		this.add(combox3);
		scrollpane.setBounds(200, 410, 300, 150);
		this.add(scrollpane);
		button.setBounds(300, 600, 80, 40);
		this.add(button);
	}

	private void addListener() {
		
for(int i=0;i<jtext.length;i++){
			
			jtext[i].addActionListener(this);
		}
		combox1.addItemListener(this);
		combox2.addItemListener(this);
		combox3.addItemListener(this);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jtext[0]){
			if(jtext[0].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "必填项不能为空");
				jtext[0].requestFocus();
			}
			else{jtext[1].requestFocus();
		}
			}
		if(e.getSource()==jtext[1]){
			if(jtext[1].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "必填项不能为空");
				jtext[1].requestFocus();
			}
			else{jtext[2].requestFocus();
		}
		}
		if(e.getSource()==jtext[2]){
			if(jtext[2].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "必填项不能为空");
				jtext[2].requestFocus();
			}
			else{jtext[3].requestFocus();
		}
		}
		if(e.getSource()==jtext[3]){
			if(jtext[3].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "必填项不能为空");
				jtext[3].requestFocus();
			}
			else{textarea.requestFocus();;
		}
			
		}
	    if(e.getSource()==button){
	    	
	    	//提交处理	
	    	if(jtext[0].getText().equals("")||jtext[1].getText().equals("")||jtext[2].getText().equals("")||jtext[3].getText().equals("")){
	    		JOptionPane.showMessageDialog(getParent(), "必填项不能为空");
	    		jtext[0].requestFocus();
	    	}
	    	
	    	else{
	    		job=new Job();
	    		job.setEnterId(id);
	    		job.setJobName(jtext[0].getText().toString());
	    		job.setGangweimiaoshu(jtext[1].getText().toString());
	    		job.setSkill(jtext[2].getText().toString());
	    		job.setNeedNumber(Integer.valueOf(jtext[3].getText()));
	    		job.setReminder(Integer.valueOf(jtext[3].getText()));
	    		job.setGender(String.valueOf(combox1.getSelectedItem()));
	    		job.setYear1((Integer)combox2.getSelectedItem());
	    		job.setYear2((Integer)combox3.getSelectedItem());
	    		job.setDescription(textarea.getText().toString());
	    		job.setEntername(enterprise.getName());
	    	    jobservice=new JobService();
	    	   if( jobservice.saveJob(job)){
	    		JOptionPane.showMessageDialog(getParent(), "发布信息成功");}
	    	   else{JOptionPane.showMessageDialog(getParent(), "发布信息失败");}
	    	}
	    	
	    	
	    }
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==combox1){
   //gender
			
	   }
		if(e.getSource()==combox2){
//year1
			
		}
		if(e.getSource()==combox3){
//year2
			
		}

}

}
