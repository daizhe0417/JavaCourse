package cn.lntu.t25;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class CollegeManager extends JPanel implements  ActionListener,Runnable,ItemListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private  JLabel label=new JLabel("学院名");
    private  JLabel label1=new JLabel("增加学院信息");
    private  JLabel collnumber=new JLabel("学院编号");
    private  JTextField  colltext=new JTextField();
    private  JLabel  label2=new JLabel("增加专业");
    private  JTextField  text=new  JTextField();
    private  JButton  submit=new  JButton("增加");
    private  JButton  submit1=new  JButton("增加");
    private  JButton  addcoll=new  JButton("增加学院");
    private  JButton  addmajor=new  JButton("增加专业");
    private  JLabel  label3=new JLabel("选择学院");
    private  JLabel  label4=new JLabel("输入专业名");
    private  JLabel  label5=new JLabel("已有学院");
    private  JLabel  label6=new  JLabel("已有专业");
    private  JLabel label7=new JLabel("请输入专业编号");
    private  JTextField   text2=new  JTextField();
    private  JTextField  text1=new JTextField();
    private  JComboBox<String>  collegebox=new  JComboBox<String>();
    private  JComboBox<String>  collegebox1=new JComboBox<String>();
    private  JComboBox<String>  majorbox=new  JComboBox<String>();
	private Map<String, Integer> collegemap;
	private College college;
	private Map<String, Integer> majormap;
   
	CollegeManager(){
		run();
		addListener();
		
	}
	
	
	private void addListener() {
		
		submit.addActionListener(this);
		submit1.addActionListener(this);
		addcoll.addActionListener(this);
		addmajor.addActionListener(this);
		text.addActionListener(this);
		text1.addActionListener(this);
		text2.addActionListener(this);
		collegebox.addItemListener(this);
	}


	private void initial() {
	this.setLayout(null);
	addcoll.setBounds(300, 200, 120, 40);
	this.add(addcoll);
	addmajor.setBounds(300,400,120,40);
	this.add(addmajor);
	label2.setBounds(50, 280, 80, 40);
	this.add(label2);
	label2.setVisible(false);
	label2.setForeground(Color.RED);
	label3.setBounds(200, 280, 80, 40);
	this.add(label3);
	label3.setVisible(false);
	collegebox.setBounds(300, 280, 150, 40);
	this.add(collegebox);
	collegebox.setVisible(false);
	label6.setBounds(500, 280, 80, 40);
	majorbox.setBounds(600, 280, 150, 40);
	this.add(majorbox);
	this.add(label6);
	majorbox.setVisible(false);
	label6.setVisible(false);
	label4.setBounds(200, 360, 80, 40);
	this.add(label4);
	label4.setVisible(false);
	text1.setBounds(300, 360, 150, 40);
	text1.setVisible(false);
	this.add(text1);
	label7.setBounds(200, 450, 120, 40);
	this.add(label7);
	label7.setVisible(false);
	text2.setBounds(300,450,150,40);
	this.add(text2);
	text2.setVisible(false);
	submit1.setBounds(300, 550, 80, 40);
	this.add(submit1);
	submit1.setVisible(false);
	label1.setBounds(50, 0, 80, 40);
	this.add(label1);
	label5.setBounds(200, 10, 80, 40);
	label1.setVisible(false);
	this.add(label5);
	label5.setVisible(false);
	collegebox1.setBounds(300, 10, 150, 40);
	collegebox1.setVisible(false);
	this.add(collegebox1);
	label1.setForeground(Color.RED);
	label.setBounds(200,100 , 80, 40);
	label.setVisible(false);
	this.add(label);
	collnumber.setBounds(200,150,100,40);
	this.add(collnumber);
	collnumber.setVisible(false );
	colltext.setBounds(300,150,150,40);
	this.add(colltext);
	colltext.setVisible(false);
	label.setHorizontalTextPosition(JLabel.RIGHT);
	text.setBounds(300, 100, 150, 40);
	text.setVisible(false);
	this.add(text);	
	submit.setBounds(300, 220, 80, 40);
	submit.setVisible(false);
	this.add(submit);
	
	}


	@Override
	public void actionPerformed(ActionEvent e ) {
		
		if(e.getSource()==addcoll){
			addcoll.setVisible(false);
			 collegePaneVisible();
			
		}
		if(e.getSource()==addmajor){
			addmajor.setVisible(false);
			 majorPaneVisible();
			
		}
	
		if(e.getSource()==submit){
			if(text.getText().equals("")||colltext.getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入学院名");
				text.requestFocus();
			}
			else{
				college=new College();
				college.setName(text.getText());
				college.setId(Integer.parseInt(colltext.getText()));
				CollegeService service = new CollegeService();
				if(service.saveCollege(college)){
					JOptionPane.showMessageDialog(getParent(), "插入成功");
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "插入失败");
					
				}
			}
		}
		if(e.getSource()==submit1){
			if(text1.getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入专业名");
				text1.requestFocus();
			}
			if(text2.getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入专业编号");
				text2.requestFocus();
				
			}
			if(!(text1.getText().equals("")&&text2.getText().equals(""))){
				Major major = new  Major();
				MajorService  service=new MajorService();
				major.setCollege(collegemap.get(collegebox.getSelectedItem()));
				major.setName(text1.getText());
				major.setId(Integer.parseInt(text2.getText()));
				if(service.saveMajor(major)){
					JOptionPane.showMessageDialog(getParent(), "更新成功");
					
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "更新失败");
			}
		}
	}
		if(e.getSource()==text1){
			if(text1.getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入信息");
				text1.requestFocus();
			}
			else{	text2.requestFocus();
		}
			}
		if(e.getSource()==text){
			if(text.getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入信息");
				text.requestFocus();
			}
			else{	colltext.requestFocus();
		}
		}
		if(e.getSource()==colltext){
			if(colltext.getText().equals("")){
				JOptionPane.showMessageDialog(getParent(), "请输入信息");
				colltext.requestFocus();
			}
		}
		
}


	private void majorPaneVisible() {
	
	boolean flag=true;
		label2.setVisible(flag);
		label2.setForeground(Color.RED);
		label3.setVisible(flag);
		collegebox.setVisible(flag);
		label6.setVisible(flag);
		majorbox.setVisible(flag);
		text1.setVisible(flag);
		label7.setVisible(flag);
		text2.setVisible(flag);
		submit1.setVisible(flag);
		label4.setVisible(flag);
		
	}


	private void collegePaneVisible() {
		boolean aFlag=true;
		label1.setVisible(aFlag);
		label5.setVisible(aFlag);
		collegebox1.setVisible(aFlag);
		label1.setForeground(Color.RED);
		label.setVisible(aFlag);
		label.setHorizontalTextPosition(JLabel.RIGHT);
		text.setVisible(aFlag);
		submit.setVisible(aFlag);
		collnumber.setVisible(aFlag);
		colltext.setVisible(aFlag);
		
	}

	private  void initialComboBox(){
		CollegeService service = new CollegeService();
		collegemap=service.queryAllCollege();
		Set<String> collegename=new HashSet<String>();
		for(String name:collegemap.keySet()){
			collegename.add(name);
		}
		Iterator<String>  iterator=     collegename.iterator();
	
			while(iterator.hasNext()){
				String item=(String) iterator.next();
				collegebox1.addItem(item);
				collegebox.addItem(item);	
		}}
	
	
	
	@Override
	public void run() {
		initial();
		initialComboBox();
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==collegebox){	
			 MajorService majorservice = new  MajorService();
			 String  collegename=(String) collegebox.getSelectedItem();
			 majorbox.removeAllItems();
			 Integer collegeid=collegemap.get(collegename);
		     majormap=majorservice.queryAllMajor(collegeid);
		     Set<String> majorname=new HashSet<String>();
				for(String name:majormap.keySet()){
					majorname.add(name);
				}
				Iterator<String>  iterator=  majorname.iterator();
				while(iterator.hasNext()){
					majorbox.addItem((String) iterator.next());	
				}}
	}

}
