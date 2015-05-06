package cn.lntu.t25;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputStuInfo extends  JPanel implements ActionListener ,ItemListener,Runnable{
	
	/**
	 * 学校管理员录入企业信息
	 */
	private static final long serialVersionUID = 2596684801306957742L;
	private JLabel [] label={new JLabel("学号(*)"),new JLabel("姓名(*)"),new  JLabel("性别(*)"),new JLabel("身份证号(*)"),new JLabel("籍贯(*)"),new JLabel("学院(*)"),new JLabel("专业(*)"),new JLabel("联系方式")};
	private  JTextField []  textfield={new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField() };
	private JButton jbutton=new JButton("提交");
	private  JComboBox<String> combox=new JComboBox<String>(),
	         collegebox=new JComboBox<String>(),
	         majorbox=new JComboBox<String>();
	private  Map<String ,Integer> collegemap =new HashMap<String,Integer>();
	private  Map<String ,Integer> majormap =new HashMap<String,Integer>();
	private  Student  student;
	private  StudentService  stuservice;
	private MajorService majorservice;
	InputStuInfo(){
		
		run();
		setFocus();
		
	}

	
	public void initial(){
		this.setLayout(null);
		for(int i=0;i<label.length;i++){
			label[i].setBounds(50, 20+50*i, 80, 40);
			textfield[i].setBounds(200,20+50*i, 150, 40);
			this.add(label[i]);
			this.add(textfield[i]);
			textfield[i].addActionListener(this);
		}
		this.remove(textfield[2]);
		this.remove(textfield[5]);
		this.remove(textfield[6]);
		combox.addItem("男");
		combox.addItem("女");
		combox.setBounds(200, 120, 80, 40);
		this.add(combox);
		combox.addItemListener(this);
		collegebox.setBounds(200, 270, 200, 40);
		majorbox.setBounds(200, 320, 200, 40);
		this.add(collegebox);
		collegebox.addItemListener(this);
		
		this.add(majorbox);
		jbutton.setBounds(400, 400, 80, 40);
		this.add(jbutton);
		jbutton.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jbutton){
			if(textfield[0].getText().equals("")||textfield[1].getText().equals("")||textfield[3].getText().equals("")||textfield[4].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "必填项不能为空");
				textfield[0].requestFocus();
			}
			else{
				student=new Student();
				student.setId(Integer.valueOf(textfield[0].getText()));
				student.setName(String.valueOf(textfield[1].getText()));
				student.setSex( (String) combox.getSelectedItem());
				student.setIdNumber(String.valueOf(textfield[3].getText()));
				student.setAddress(String.valueOf(textfield[4].getText()));
				student.setCollege(collegemap.get(collegebox.getSelectedItem()));
				student.setMajor(majormap.get(majorbox.getSelectedItem()));
				student.setPassword(String.valueOf(textfield[3].getText()));
				student.setEmployment("待业");
				if(!textfield[5].getText().equals("")){
					student.setPhoneNumber((textfield[5].getText()));
				}
				else{student.setPhoneNumber("null");}
			} 
			
		stuservice=new StudentService();
		if(stuservice.saveStudent(student)){
			JOptionPane.showMessageDialog(getParent(), "操作成功");
			for(int i=0;i<textfield.length;i++){
				if(i!=2&&i!=5&&i!=6)
				textfield[i].setText("");
			}
			
		}
		else{
			
			JOptionPane.showMessageDialog(getParent(), "操作失败");
		}
		
		}
		if(e.getSource()==textfield[0]){
			if(textfield[0].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "学号不能为空");
				textfield[0].requestFocus();
			}
			if(textfield[0].getText().toString().length()!=10){
				JOptionPane.showMessageDialog(getParent(), "学号格式错误");
			}
			else{	textfield[1].requestFocus();
		}}
		
		if(e.getSource()==textfield[1]){
			if(textfield[1].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "名字不能为空");
				textfield[1].requestFocus();
			}
			else{combox.requestFocus();
		}}
		
		if(e.getSource()==textfield[3]){
			if(textfield[3].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "身份证号不能为空");
				textfield[3].requestFocus();
			}
			else if(textfield[3].getText().toString().length()!=18){
				JOptionPane.showMessageDialog(getParent(), "身份证号格式错误");
			}
			else {textfield[4].requestFocus();
		}}
		if(e.getSource()==textfield[4]){
			if(textfield[4].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "籍贯不能为空");
				textfield[4].requestFocus();
			}
			else{	textfield[5].requestFocus();
		}}
		if(e.getSource()==textfield[5]){
			collegebox.requestFocus();
		}
		
		if(e.getSource()==textfield[7]){
			jbutton.requestFocus();
		}
		
	}

	
	@Override
	public void itemStateChanged(ItemEvent e) {
	
		if(e.getSource()==collegebox){
			 majorservice=new  MajorService();
			 String  collegename=(String) collegebox.getSelectedItem();
			 majorbox.removeAllItems();
			 Integer collegeid=collegemap.get(collegename);
		     majormap=majorservice.queryAllMajor(collegeid);
		     Set<String> majorname=new HashSet<String>();
				for(String name:majormap.keySet()){
					majorname.add(name);
				}
				Iterator<String>  iterator=     majorname.iterator();
				while(iterator.hasNext()){
					majorbox.addItem((String) iterator.next());	
				}}}
	
	
	private  void initialComboBox(){
		CollegeService service = new CollegeService();
		collegemap=service.queryAllCollege();
		Set<String> collegename=new HashSet<String>();
		for(String name:collegemap.keySet()){
			collegename.add(name);
		}
		Iterator<String>  iterator=     collegename.iterator();
		while(iterator.hasNext()){
			collegebox.addItem((String) iterator.next());
			}}
	
	
	
	public  void  setFocus(){
		textfield[0].requestFocus();
	}


	@Override
	public void run() {
		
		initial();
		initialComboBox();
	}
	

}




class StudentInformationQU extends  JPanel  implements ActionListener,Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   private JLabel [] label={new JLabel("请输入学号"),new JLabel("姓名"),new JLabel("身份证号"),new JLabel("性别"),new JLabel("籍贯"),new JLabel("院系"),new JLabel("专业"),new JLabel("联系方式"),new JLabel("就业情况")};
   private  JTextField []  textfield={new  JTextField(),new  JTextField(),new  JTextField(),new  JTextField(),new  JTextField(),new  JTextField(),new  JTextField(),new  JTextField(),new  JTextField()};
   private  JButton query=new  JButton("查询"),
   		         update=new JButton("更新"),
   		         delete=new JButton("删除");
   private  Student  student;
   private StudentService  service;
   
   
   
	StudentInformationQU(){
		run();
		addListener();
	}
	
	

	private void initial() {
	this.setLayout(null);
	for(int i=0;i<label.length;i++){
		label[i].setBounds(10, 10+60*i, 80, 40);
		this.add(label[i]);
		label[i].setHorizontalTextPosition(JTextField.RIGHT);
	}
	for(int j=0;j<textfield.length;j++){
       textfield[j].setBounds(150, 10+60*j, 200, 40);
		this.add(textfield[j]);
     
       if(j!=0){
       	textfield[j].setEditable(false);
       }
	}
	textfield[0].requestFocus();
	  query.setBounds(400, 10, 80, 40);
	  this.add(query);
	  update.setBounds(200, 600, 80, 40);
	  this.add(update);
	  update.setVisible(false);
	  delete.setBounds(400, 600, 80, 40);
	  this.add(delete);
	  delete.setVisible(false);
	}
	

	
	
	private void addListener() {
		query.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
	}



	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==query){
			if(textfield[0].getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入学号");
				textfield[0].requestFocus();
			}
			else{
			int id=Integer.parseInt(textfield[0].getText());
			service=new StudentService();
			student=service.queryStudent(id);
			textfield[1].setText(student.getName());
			textfield[2].setText(student.getIdNumber());
			textfield[3].setText(student.getSex());
			textfield[4].setText(student.getAddress());
			CollegeService collegeservice = new CollegeService();
			College college = collegeservice.queryCollege(student.getCollege());
			textfield[5].setText(college.getName());
			MajorService majorservice=new MajorService();
			Major major=majorservice.queryMajor(student.getMajor());
			textfield[6].setText(major.getName());
			textfield[7].setText(student.getPhoneNumber());
			textfield[8].setText(student.isEmployment());
			textfield[1].setEditable(true);
			textfield[4].setEditable(true);
			textfield[7].setEditable(true);
			update.setVisible(true);
			delete.setVisible(true);
		}}
		if(e.getSource()==update){
			int choose=JOptionPane.showConfirmDialog(getParent(), "你确认要更新!");
			if(choose==0){
				service=new StudentService();
				 student=new Student();
				 student.setId(Integer.parseInt(textfield[0].getText()));
				 student.setName(textfield[1].getText());
				 student.setAddress(textfield[4].getText());
				 student.setPhoneNumber(textfield[7].getText());
				 if( service.updateStudent(student)){
					JOptionPane.showConfirmDialog(getParent(), "操作成功");
				 }
				 else{
					 JOptionPane.showConfirmDialog(getParent(), "操作失败");
				 }
			}
		}
		if(e.getSource()==delete){
			int choose=JOptionPane.showConfirmDialog(getParent(), "你确认要删除这个学生？", "警告", JOptionPane.WARNING_MESSAGE);
			if(choose==0){
				service=new StudentService();
				if(service.deleteStudent(Integer.parseInt(textfield[0].getText()))){
					JOptionPane.showMessageDialog(getParent(), "操作成功");
					
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "操作失败");
				}
		}
	}
}



	@Override
	public void run() {
		initial();
		
	}
	}
