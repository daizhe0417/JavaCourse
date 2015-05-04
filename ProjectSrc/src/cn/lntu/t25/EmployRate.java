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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmployRate extends JPanel  implements ActionListener,ItemListener{
	
	
	/**
	 * 
	 */
   private static final long serialVersionUID = -2976954389070263008L;
   private  String [] item={"学院","专业"};
   private  JComboBox<String>  combox1=new  JComboBox<String>( item),
		    collegebox=new  JComboBox<String>(),
				   majorbox=new  JComboBox<String>();
   private  JLabel  label1=new JLabel("选择学院:"),
		     label2 =new JLabel("选择专业:"),
		     label=new JLabel("选择查询方式:");
   private  JButton submit=new JButton("查询"),
		    cancel=new JButton("清空");
   private  JLabel  label3=new JLabel("就业率");
   private  JTextField  jtext=new  JTextField();
   private  int choose;
  
   private  Map<String ,Integer> collegemap =new HashMap<String,Integer>();
   private  Map<String ,Integer> majormap =new HashMap<String,Integer>();
   private CollegeService  collser;

	EmployRate(){
		
		initial();
		initialComboBox();
		addListener();
	}
	
	

	


	private void addListener() {
		combox1.addItemListener(this);
		collegebox.addItemListener(this);
		majorbox.addItemListener(this);
		submit.addActionListener(this);
		cancel.addActionListener(this);
	}






	private void initial() {
		
		this.setLayout(null);
		label.setBounds(80, 50, 100, 40);
		this.add(label);
		combox1.setBounds(200, 50, 80, 40);
		this.add(combox1);
		
		label1.setBounds(50, 200, 80, 40);
		this.add(label1);
		collegebox.setBounds(50, 250, 150, 40);
		this.add(collegebox);
		
		label2.setBounds(300, 200, 80, 40);
		this.add(label2);
		label3.setBounds(500, 200, 80, 40);
		this.add(label3);
		
		majorbox.setBounds(300, 250, 150, 40);
		this.add(majorbox);
		jtext.setBounds(500, 250, 80, 40);
		this.add(jtext);
		jtext.setEditable(false);
		majorbox.setEnabled(false);
	    submit.setBounds(150, 350, 80, 40);
	    this.add(submit);
	    cancel.setBounds(330, 350, 80, 40);
	    this.add(cancel);
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit){
			if(combox1.getSelectedIndex()==0){
			 collser=new CollegeService();
			 College college=  collser.queryCollege(collegemap.get(collegebox.getSelectedItem()));
		    int total=college.getTotal();
			int employment=college.getEmployment();
			double re=(double)employment/total;
			jtext.setText(Double.toString(re));
			 }
			}
			else{
				MajorService majorser = new MajorService();
				Major major=majorser.queryMajor(majormap.get(majorbox.getSelectedItem()));
						int total=major.getTotal();
						int employment=major.getEmployment();
						double re=(double)employment/total;
						jtext.setText(Double.toString(re));			
		}
		if(e.getSource()==cancel){
			jtext.setText("");	
		}
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==combox1){
		choose=combox1.getSelectedIndex();
		if(choose==0){
			majorbox.setEnabled(false);
		}
		if(choose==1){
			majorbox.setEnabled(true);
			}}
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
				Iterator<String>  it=  majorname.iterator();
				while(it.hasNext()){
					majorbox.addItem((String) it.next());	
				}
		}
		if(e.getSource()==majorbox){
		}
		}
	

	
	
private  void initialComboBox(){
		//取得学院名字和ID
		
	
		CollegeService service = new CollegeService();
		collegemap=service.queryAllCollege();
		Set<String> collegenameset=new HashSet<String>();
		for(String name:collegemap.keySet()){
			collegenameset.add(name);
		}
		Iterator<String>  iterator=     collegenameset.iterator();
		while(iterator.hasNext()){
			collegebox.addItem((String) iterator.next());
			}
		
		collegebox.setSelectedIndex(0);
		//取得专业名字和ID
		
		 MajorService majorservice = new  MajorService();
		 String  collegename=(String) collegebox.getSelectedItem();
		 majorbox.removeAllItems();
		 Integer collegeid=collegemap.get(collegename);
	     majormap=majorservice.queryAllMajor(collegeid);
	     Set<String> majorname=new HashSet<String>();
			for(String name:majormap.keySet()){
				majorname.add(name);
			}
			Iterator<String>  it=  majorname.iterator();
			while(it.hasNext()){
				majorbox.addItem((String) it.next());	
			}}
		
	}
  



