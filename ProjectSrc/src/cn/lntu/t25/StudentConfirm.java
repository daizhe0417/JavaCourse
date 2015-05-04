package cn.lntu.t25;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentConfirm extends JPanel{
     /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 private Integer  id;
     private  JLabel  label=new JLabel("提交的求职申请");
     String  [] title={"企业名","职位名","处理",""};
	 private  DefaultTableModel  dtm=new DefaultTableModel(title,0);
	 private  JTable table=new JTable(dtm);
	 private  JScrollPane  scroll=new JScrollPane(table);
	 private  FormService  formser;
	
	StudentConfirm (Integer id){
		
		this.id=id;
		initial();
		addListener();
	}
	
	
	
	
	
	private void addListener() {
		table.addMouseListener(new MouseAdapter(){
			public  void mouseClicked(MouseEvent e){
				if(table.getSelectedColumn()==3){
				//	System.out.print("hello");
					if(table.getValueAt(table.getSelectedRow(), 2).equals("同意")){
						int choose=JOptionPane.showConfirmDialog(getParent(), "你确认接收此职务？");
						if(choose==0){
							StudentService stuser=new StudentService();
							Student student=stuser.queryStudent(id);
							student.setEmployment("就业");
							stuser.updateStudent(student);
							CollegeService collser=new CollegeService();
						    College college=collser.queryCollege(student.getCollege());
						    college.setEmployment(college.getEmployment()+1);
						    collser.updateCollege(college);
						    MajorService maser=new MajorService();
						    Major  major=maser.queryMajor(student.getMajor());
						    major.setEmployment(major.getEmployment()+1);
						    maser.updateMajor(major);
						    Form form = new Form();
						    FormService formser=new FormService();
						    form.setEntername((String)table.getValueAt(table.getSelectedRow(), 0));
						    form.setJobname((String)table.getValueAt(table.getSelectedRow(), 1));
						    form.setStudnetId(id);
						    formser.deleteForm(form);
						}
						
					}
				}
			}
		});
	}





	private void initial() {
		this.setLayout(null);
		label.setBounds(30,30, 150, 40);
		this.add(label);
		scroll.setBounds(100, 100, 400, 300);
		this.add(scroll);
		formser=new FormService();
		List<Form> list=new LinkedList<Form>();
		list=formser.queryForm(id);
		Iterator<Form> it=list.iterator();
		while(it.hasNext()){
			
			 Vector<String> vector =new Vector<String>();
			    Form  form= (Form) it.next();
				vector.add(form.getEntername());
				vector.add(form.getJobname());
				vector.add(form.getStatus());
				vector.add("处理");
				dtm.addRow(vector);  
		}
	}
}
