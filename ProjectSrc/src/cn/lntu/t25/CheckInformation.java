package cn.lntu.t25;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;


import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class CheckInformation extends JPanel implements  ActionListener{
	/**
	 * 学生端  查看企业发布的职位需求信息
	 */
	private static final long serialVersionUID = 1L;
	private   String [] coll_name={"企业名","职位名","查看"};
	
	private  JLabel  label=new JLabel("查看当前已发布的信息");
	private  DefaultTableModel  dtm=new DefaultTableModel(coll_name,0);
	private  JTable  table=new JTable(dtm);
	private JScrollPane  scroll=new JScrollPane(table);
	private  JButton  show=new JButton("查看");
	private int id;
	private  String entername,jobname;
	CheckInformation(int id){
		this.id=id;
		initial();
		addListener();
	}
	
	
	private void initial() {
		
		this.setLayout(null);
		label.setBounds(30, 30, 150, 40);
		this.add(label);
		show.setBounds(200, 30, 80, 40);
		this.add(show);	
		scroll.setBounds(80, 150, 500, 300);
		this.add(scroll);
		scroll.setVisible(false);
		
	}

	private void addListener() {
	
		show.addActionListener(this);
		table.addMouseListener(new MouseAdapter(){//table面板点击可查看对应的职位信息
			public  void mousePressed(MouseEvent e){
			if(table.getSelectedColumn()==2){
			int choose=	JOptionPane.showConfirmDialog(getParent(), "确认查看？");
				if(choose==0){entername=(String) table.getValueAt(table.getSelectedRow(), 0);
				jobname=(String) table.getValueAt(table.getSelectedRow(), 1);
			    new ShowInfor(entername,jobname,id);
				}
			}	
			else{	
			}	
			}});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==show){
			scroll.setVisible(true);
			JobService  jobser=new JobService();
		   LinkedList<Job>  list =	(LinkedList<Job>) jobser.queryAllJob();
		   Iterator<Job> it=list.iterator();
		   while(it.hasNext()){
			   Vector<String> vector =new Vector<String>();
			    Job job = (Job) it.next();
				vector.add(job.getEntername());
				vector.add(job.getJobName());
				vector.add("点击查看");
				dtm.addRow(vector);  
		   }
		}
	}
}




class ShowInfor extends  JFrame implements  ActionListener,Runnable{
	
	
	/**
	 * 学生端点击查看后弹出该职位和该公司的具体信息
	 */
	private static final long serialVersionUID = 1L;
	private  String  entername,jobname;
	private  int stu_id,count=1;
	private  JLabel [] label={new JLabel("企业名"),new JLabel("企业地址"),new JLabel("企业邮箱"),new JLabel("企业电话"),new JLabel("职位名称"),new JLabel("需求量"),
			               new JLabel("剩余名额"),new JLabel("年龄要求"),new JLabel("性别要求"),new JLabel("岗位描述"),new JLabel("技能要求"),new JLabel("其它说明")};
	private  JTextField [] field={new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField()};
	private  JTextArea  descriptionarea=new JTextArea(),
			             resumearea=new JTextArea() ;
	private  JScrollPane  scroll=new JScrollPane(descriptionarea),
			              scroll1=new JScrollPane(resumearea);
	private  JButton submit =new JButton("提交申请"),
			         dispose=new JButton("关闭"),
	                  resume=new JButton("填写简历");
	ShowInfor(String entername,String jobname,int id){
		this.entername=entername;
		this.jobname=jobname;
		this.stu_id=id;
		run();
	}
	private void initial() {//界面
		 Container   content=this.getContentPane();
		  content.setLayout(null);
		  this.setVisible(true);
		  this.setSize(600, 700);
		  this.setTitle("查看企业信息及职位信息");
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		  this.setLocation((screensize.width-this.getWidth())/2, (screensize.height-this.getHeight())/2);
		 
		  label[0].setBounds(30, 20, 80, 40);
		  field[0].setBounds(120, 20, 150, 40);
		  
		  label[1].setBounds(300, 20, 80, 40);
		  field[1].setBounds(390, 20, 150, 40);
		  
		 label[2].setBounds(30, 70, 80, 40);
		 field[2].setBounds(120, 70, 150, 40);
		 
		 label[3].setBounds(300, 70, 80, 40);
		 field[3].setBounds(390, 70, 150, 40);
		 
		 label[4].setBounds(30, 120, 80, 40);
		 field[4].setBounds(120, 120, 150, 40);
		 
		 label[5].setBounds(300, 120, 80, 40);
		 field[5].setBounds(390, 120, 150, 40);

		 label[6].setBounds(30, 170, 80, 40);
		 field[6].setBounds(120, 170, 150, 40);
		 
		 label[7].setBounds(300, 170, 80, 40);
		 field[7].setBounds(390, 170, 150, 40);
		 
		 label[8].setBounds(30, 220, 80, 40);
		 field[8].setBounds(120, 220, 150, 40);
		 
		 label[9].setBounds(300, 220, 80, 40);
		 field[9].setBounds(390, 220, 150, 40);
		 
		 label[10].setBounds(30, 270, 80, 40);
		 field[10].setBounds(120, 270, 150, 40);
		 
		 label[11].setBounds(30, 310, 150, 40);
		
		 scroll.setBounds(80, 360, 400, 200);
		 content.add(scroll);
		 descriptionarea.setEditable(false);
		 scroll1.setBounds(80, 360, 400, 200);
		 content.add(scroll1);
		 scroll1.setVisible(false);
		 for(int i=0;i<label.length;i++){
	        content.add(label[i]);
		}
		for(int i=0 ;i<field.length;i++){
			content.add(field[i]);
			field[i].setEditable(false);
			
		}
		resume.setBounds(100, 600, 100, 40);
		content.add(resume);
		resume.addActionListener(this);
		submit.setBounds(250, 600, 100, 40);
		content.add(submit);
		submit.addActionListener(this);
		dispose.setBounds(400, 600, 80, 40);
		content.add(dispose);
		dispose.addActionListener(this);
		}

	private void initialTextField() {
		
		    EnterpriseService enterser=new EnterpriseService();
		    Enterprise enterprise=enterser.queryEnterprise(entername);
			field[0].setText(entername);
			field[1].setText(enterprise.getAddress());
			field[2].setText(enterprise.getEmail());
			field[3].setText(enterprise.getPhoneNumber());	
			JobService  jobser=new JobService();
			Job  job=jobser.queryJob(entername, jobname);
			field[4].setText(jobname);
			field[5].setText(String.valueOf(job.getNeedNumber()));
			field[6].setText(String.valueOf(job.getReminder()));
			field[7].setText(String.valueOf(job.getYear1()+"  to  "+String.valueOf(job.getYear2())));	
			field[8].setText(job.getGender());
			field[9].setText(job.getGangweimiaoshu());
			field[10].setText(job.getSkill());
			descriptionarea.setText(job.getDescription().toString());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			
			if(count==1){//学生点击提交申请后，将学生信息及对应的公司和职位名等存入数据库
				Form  form=new Form();
				FormService  formser=new FormService();
				form.setEntername(entername);
				form.setJobname(jobname);
				form.setStatus("待处理");
				form.setStudnetId(stu_id);
				form.setResume(resumearea.getText().toString());
				if(formser.saveForm(form)){
					JOptionPane.showMessageDialog(getParent(), "操作成功");
					count--;	
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "操作失败");
				}	
		}
			else{JOptionPane.showMessageDialog(getParent(), "请不要重复提交");}	
		}
		if(e.getSource()==dispose)
			{this.dispose();}
		if(e.getSource()==resume){
			
			scroll.setVisible(false);
			scroll1.setVisible(true);
			label[11].setText("请在此填写你的简历");;
			
		}
	}
	@Override
	public void run() {
		 initial();
		 initialTextField();
		
	}
     
}