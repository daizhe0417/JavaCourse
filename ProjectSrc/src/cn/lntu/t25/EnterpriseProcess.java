package cn.lntu.t25;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;





import java.util.Iterator;
import java.util.List;
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

public class EnterpriseProcess extends JPanel implements  ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
    private  Enterprise  enterprise;
    private  JLabel []label={new JLabel("你当前有"),new JLabel(),new JLabel("条待处理信息")};
    private  JButton  button=new  JButton("点击处理");
    private  String  [] title={"职位","学生ID","处理"};
    private  DefaultTableModel  dt=new DefaultTableModel(title,0);
    private  JTable  table=new JTable(dt);
    private  JScrollPane  scroll=new JScrollPane(table);
	private EnterpriseService enterservice;
	private  Form form;
	EnterpriseProcess(Integer id){
		this.id=id;
		initial();
		getenterprise();
		addListener();
		
	}
	
	
	private void addListener() {
	table.addMouseListener(new MouseAdapter(){
		

		public   void  mousePressed(MouseEvent e){
			if(table.getSelectedColumn()==2){
				int choose=	JOptionPane.showConfirmDialog(getParent(), "确认查看？");
				String jobname = null;
				Integer studentId = null;
				if(choose==0){
					jobname= (String) table.getValueAt(table.getSelectedRow(), 0);
					studentId= Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 1));
				}
				
			 new ShowStudentInformation(studentId,enterprise.getName(),jobname);
				
			}	
		}
		
	});
	button.addActionListener(this);
	}
	private void initial() {
		this.setLayout(null);
		label[0].setBounds(50, 50, 80, 40);
		label[0].setHorizontalTextPosition(JLabel.RIGHT);
		this.add(label[0]);
		label[1].setBounds(130, 50, 20, 40);
		this.add(label[1]);
		label[2].setBounds(150, 50, 150, 40);
		label[2].setHorizontalTextPosition(JLabel.LEFT);
		this.add(label[2]);
		button.setBounds(350, 50, 100, 40);
		this.add(button);
		scroll.setBounds(100, 200, 400, 400);
		this.add(scroll);
		scroll.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		scroll.setVisible(true);
	
		FormService formservice = new FormService();
		List<Form> list=formservice.queryForm(enterprise.getName());
	    Iterator<Form> it=list.iterator();
	    while(it.hasNext()){
	    Vector<String> vector =new Vector<String>();
	    form=(Form) it.next();
		vector.add((form.getJobname()));
		vector.add(String.valueOf(form.getStudnetId()));
		vector.add("点击查看学生信息");
		dt.addRow(vector);
		}
	}
	
	private void getenterprise() {
		enterprise=new Enterprise();
		enterservice=new  EnterpriseService();
		enterprise=enterservice.queryEnterprise(id);
		FormService formservice = new FormService();
	    label[1].setText(String.valueOf(formservice.countnNumber(enterprise.getName())));
	}
	
}




class  ShowStudentInformation extends JFrame  implements  ActionListener,Runnable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer stuid;
	private String  enterprisename,jobname;
	private  JLabel [] label={new JLabel("姓名"),new JLabel("学院"),new JLabel("专业"),new JLabel("性别"),new JLabel("出生年月"),new JLabel("个人说明")};
	private  JTextField  [] text={new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField()};
	private  JTextArea  area=new JTextArea();
	private  JScrollPane  scroll=new  JScrollPane(area);
	private  JButton  button1=new JButton("接收");
	private  JButton  button2=new JButton("删除");
	private Form form;
	private FormService formser;
	ShowStudentInformation(Integer id,String enterprisename,String jobname){
		this.stuid=id;
		this.enterprisename=enterprisename;
		this.jobname=jobname;
		run();
		
		addListener();
		
	}

	private void getInformation() {
		
		StudentService stuservice=new StudentService();
		Student student=stuservice.queryStudent(stuid);
		text[0].setText(student.getName());
		text[3].setText(student.getSex());
		text[4].setText(student.getIdNumber().substring(6, 14));
		CollegeService  collservice=new CollegeService();
	    College college=	collservice.queryCollege(student.getCollege());
	    text[1].setText(college.getName());
	    MajorService majorser=new MajorService();
	    Major  major=majorser.queryMajor(student.getMajor());
	    text[2].setText(major.getName());
	    formser=new FormService();
	    form=formser.queryForm(enterprisename, stuid, jobname);
	    area.setText(form.getResume().toString());
		
	}

	private void addListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		
	}

	private void initial() {
		this.setLayout(null);
		this.setTitle("处理求职申请");
		this.setVisible(true);
		this.setSize(700, 700);
		Dimension  screen=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width-this.getWidth())/2,(screen.height-this.getHeight())/2);
		for(int  i=0;i<label.length;i++){
			label[i].setBounds(50, 50+i*60, 80, 40);
			this.add(label[i]);
		}
		for(int i=0;i<text.length;i++){
			text[i].setBounds(150, 50+i*60, 150, 40);
			this.add(text[i]);
			text[i].setEditable(false);
		}
		scroll.setBounds(150,350, 400, 200);
		this.add(scroll);
		area.setEditable(false);
		button1.setBounds(150, 600, 80, 40);
		this.add(button1);
		button2.setBounds(400, 600, 80, 40);
		this.add(button2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1){
			form.setStatus("同意");
			if(formser.updateForm(form)){
				JOptionPane.showMessageDialog(getParent(), "操作成功！");
			}
			else{
				JOptionPane.showMessageDialog(getParent(), "操作失败！");
			}
		}
		if(e.getSource()==button2){
			int choose=JOptionPane.showConfirmDialog(getParent(), "你确定要删除？");
			if(choose==0){
				if(formser.deleteForm(form)){
					JOptionPane.showMessageDialog(getParent(), "操作成功！");	
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "操作失败！");
				}
		}	}
	}

	@Override
	public void run() {
		initial();
		getInformation();
	}
	
}
