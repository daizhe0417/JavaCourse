package cn.lntu.t31.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.lntu.t31.Bean.ProjectSubmit;
import cn.lntu.t31.Bean.User;
import cn.lntu.t31.Dao.ProjectService;


@SuppressWarnings("serial")
public class ProjectSubmitPanel extends JPanel implements ActionListener{
	private JLabel JLpName,JLdevelopTime,JLcontent,JLdevelopers,JLtype;
	private JTextField JFpName,JFdevelopTime_start,JFdevelopTime_end,JFtype;
	private JTextArea JAcontent,JFdevelopers;
	private JButton JBSubmit,JBReset;
	private User user;
	ProjectSubmitPanel(User user) {	
		this.user = user;
		this.initialFrame();
		this.addListener();
		this.initText();
	}

	private void initText() {
		JFpName.setText("");
		JFdevelopTime_start.setText("");
		JFdevelopTime_end.setText("");
		JFtype.setText("");
		JAcontent.setText("");
		JFdevelopers.setText("");
	}

	private void addListener() {
		JBSubmit.addActionListener(this);
		JBReset.addActionListener(this);
	}

	private void initialFrame() {
		this.setLayout(null);
		Chooser ser = Chooser.getInstance();
		Chooser ser1= Chooser.getInstance();
		
		
		JLpName = new JLabel("项目名称:");
		JFpName = new JTextField();
		JLtype = new JLabel("项目类型:");
		JFtype = new JTextField();
		JLdevelopers = new JLabel("参与人员:");
		JFdevelopers = new JTextArea();
		JLdevelopTime = new JLabel("�?发周�?:");
		JFdevelopTime_start = new JTextField();
		ser.register(JFdevelopTime_start);
		JLabel sign = new JLabel("~");
		JFdevelopTime_end = new JTextField();
		ser1.register(JFdevelopTime_end);
		JLcontent = new JLabel("项目内容:");
		JAcontent = new JTextArea();
		JBSubmit = new JButton("项目申报");
		JBReset = new JButton("重置");
		
		
		JLpName.setBounds(200,100,100,30);
		JFpName.setBounds(300,100,200,30);
		JLtype.setBounds(200,140,100,30);
		JFtype.setBounds(300,140,200,30);
		JLdevelopers.setBounds(200,180,100,30);
		
		JFdevelopers.setBounds(300,180,200,30);	
		JFdevelopers.setLineWrap(true);
		JScrollPane JDscroll = new JScrollPane(JFdevelopers); 
		JDscroll.setBounds(300,180,200,30);
		
		JDscroll.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 		
		JLdevelopTime.setBounds(200,220,100,30);
		JFdevelopTime_start.setBounds(300,220,150,30);
		sign.setBounds(450,220,10,30);
		JFdevelopTime_end.setBounds(460,220,150,30);
		JLcontent.setBounds(200,260,100,30);
		JAcontent.setBounds(300,260,350,200);
		JAcontent.setLineWrap(true);
		JScrollPane JAscroll = new JScrollPane(JAcontent); 
		JAscroll.setBounds(300,260,350,200);		
/*		JAscroll.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); */
		JAscroll.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		JBSubmit.setBounds(350,510,250,30);
		JBReset.setBounds(550,100,100,30);
		
		
		this.add(JLpName);
		this.add(JFpName);
		this.add(JLtype);
		this.add(JFtype);
		this.add(JLdevelopers);
		this.add(JLdevelopTime);
		this.add(JFdevelopTime_start);
		this.add(sign);
		this.add(JFdevelopTime_end);
		this.add(JLcontent);
		this.add(JAscroll);
		this.add(JDscroll);
		this.add(JBSubmit);
		this.add(JBReset);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JBSubmit){
			if(JFpName.getText().toString().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请填写项目名称，不能为空!");	
				return;
			}
			if(JFtype.getText().toString().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请填写项目类型，不能为空!");	
				return;
			}
			if(JFdevelopers.getText().toString().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请填写项目参与人员，不能为空!");	
				return;
			}
			if(JFdevelopTime_start.getText().toString().equals("")||JFdevelopTime_end.getText().toString().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请填写项目开发周期，不能为空!");	
				return;
			}
			if(JAcontent.getText().toString().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请填写项目概述，不能为空!");	
				return;
			}
			pSubmitTask();	
		}
		if(e.getSource()==JBReset){
			initText();
			return;
		}
		
	}

	private void pSubmitTask() {
		ProjectSubmit ps = new ProjectSubmit();
		ps.setpName(JFpName.getText().toString());
		ps.setType(JFtype.getText().toString());
		ps.setpSubmiter(user.getUserName());
		ps.setDevelopTime(JFdevelopTime_start.getText().toString() + "-" + JFdevelopTime_end.getText().toString());
		ps.setpContent(JAcontent.getText().toString());
		ps.setDevelopers(JFdevelopers.getText().toString());
		ProjectService pService = new ProjectService();
		try{
			int res = pService.projectSubmit(ps);
			if(res==1){
				JOptionPane.showMessageDialog(getParent(), "提交成功!");	
				initText();
				return;
			}else{
				JOptionPane.showMessageDialog(getParent(), "提交失败!");	
				initText();
				return;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(getParent(), "提交失败!");	
			initText();
			return;
		}
	}
	

}
