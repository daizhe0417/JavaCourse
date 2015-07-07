package cn.lntu.t35;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.lntu.t35.User;

public class QuarryScore extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jlKey;
	private JTextField jfKeyword;

	private JButton jbqurry;
	private JTable JTproject;
	private DefaultTableModel tModel;
	
	QuarryScore(User user){	
		this.initialFrame();
		this.addListener();	
		jfKeyword.setText("");
	}

	private void addListener() {
		jfKeyword.addActionListener(this);
		jbqurry.addActionListener(this);
		

	}

	private void initialFrame() {
		this.setLayout(null);
		
		jlKey = new JLabel("关键字(学号或课程号):");
		jfKeyword = new JTextField("");
		jbqurry = new JButton("查询");
		
		
		jlKey.setBounds(70,60,150,30);
		jfKeyword.setBounds(220,60,150,30);
		
		jbqurry.setBounds(410,60,100,30);
		
		String name[] = {"学号","学生姓名","课程号","课程名称","成绩"};
		tModel = new DefaultTableModel(name,0);
		JTproject = new JTable(this.tModel);	
        JScrollPane jp = new JScrollPane(JTproject);
       
        jp.setBounds(50,120,600,400);
        jp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS) ;

        this.add(jp);     
        this.add(jlKey);
        this.add(jfKeyword);      
        this.add(jbqurry);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbqurry){
			if(jfKeyword.getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入关键字信息进行查询！");
			jfKeyword.requestFocus();
		       }
			else{
				int id=0;
				User qs=new User();
				Score sc=new Score();
				Course cs=new Course();
				id=Integer.parseInt(jfKeyword.getText());
				ScoreService ss=new ScoreService();
				sc=ss.queryScore(id);	
			    for(int i=0;i<5;i++){
				
				tModel.setValueAt(sc.getStunum(), i, 0);
				tModel.setValueAt(qs.getStuname(), i, 1);
				tModel.setValueAt(sc.getCoursenum(), i, 2);
				tModel.setValueAt(cs.getCoursenam(), i, 3);
				tModel.setValueAt(sc.getScscore(), i, 4);		
			   }	
				
			
			}
	   }
		
		
	}

	private AbstractButton DefaultTableModel(DefaultTableModel tModel2, int i) {
		// TODO Auto-generated method stub
		return null;
	} 

}
