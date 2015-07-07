package cn.lntu.t35;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class InputCourse extends JPanel implements ActionListener{
	/**
	 * 课程信息处理
	 */
	private static final long serialVersionUID = -95897441548430657L;
	private JLabel[] label = { new JLabel("课程号："),new JLabel("课程名称："),new JLabel("学时："), new JLabel("学分："),
			new JLabel("老师：")};
	
	private JTextField[] field = { new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			};
	private JButton input = new JButton("提交");
	private JButton quarry = new JButton("查询");
	private JButton update = new JButton("修改");
	private JButton delete = new JButton("删除");
	private int i;
	
	public InputCourse(){
		initialFrame();
		addListener();
	}
	
	
	private void addListener() {
		 for (i = 0; i < field.length; i++) {
		 field[i].addActionListener(this);
		 }
		 input.addActionListener(this);
		 quarry.addActionListener(this);
		 update.addActionListener(this);
		 delete.addActionListener(this);
	}
	
	
	private void initialFrame() {
		    this.setLayout(null);
		    for (i = 0; i < field.length; i++) {
			label[i].setBounds(100, 60 + 50 * i, 160, 30);
			field[i].setBounds(190, 60 + 50 * i, 160, 30);	
			input.setBounds(50, 360, 90, 30);
			quarry.setBounds(140, 360, 90, 30);
			update.setBounds(230, 360, 90, 30);
			delete.setBounds(320, 360, 90, 30);
			this.add(label[i]);
			this.add(field[i]);
			this.add(input);
			this.add(quarry);
			this.add(update);
			this.add(delete);
		 }	
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input){
			 if(field[0].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入课程号！");
			 field[0].requestFocus();
		    }
			 else if(field[1].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入课程名称！");
			 field[1].requestFocus();
		    }
			 else if(field[2].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入课程学时！");
			 field[2].requestFocus();
		    }
			 else if(field[3].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入课程学分！");
			 field[3].requestFocus();
		    }
			 else if(field[4].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入任课老师！");
			 field[4].requestFocus();
		    }
			 else{ 
				 Course ic=new Course();
				 ic.setCoursenum(field[0].getText());
				 ic.setCoursenam(field[1].getText());
				 ic.setStutim(field[2].getText());
				 ic.setCredit(field[3].getText());
				 ic.setTeacher(field[4].getText());
				 UserService cs = new UserService();
				
		             if(cs.saveCourse(ic)){
		            	 field[0].setText("");
						 field[1].setText("");
						 field[2].setText("");
						 field[3].setText("");
						 field[4].setText("");
					 JOptionPane.showMessageDialog(getParent(), "操作成功！"); 
					 }
	             else{
	            	 field[0].setText("");
					 field[1].setText("");
					 field[2].setText("");
					 field[3].setText("");
					 field[4].setText("");
					 JOptionPane.showMessageDialog(getParent(), "提交失败!");	
					 }
			 }
		} 
		if(e.getSource()==quarry){
			if(field[0].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入课程号进行查询！");
			field[0].requestFocus();
			}	
			else {
				int id=0;
				Course qc=new Course();
				id=Integer.parseInt(field[0].getText());
				UserService service=new UserService();
				qc=service.queryCourse(id);
				field[0].setText(qc.getCoursenum());
				field[1].setText(qc.getCoursenam());
				field[2].setText(qc.getStutim());
				field[3].setText(qc.getCredit());
				field[4].setText(qc.getTeacher());
				update.setVisible(true);
				delete.setVisible(true);
			
			}
		}
		if(e.getSource()==delete){
			if(field[0].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入要删除的课程号！");
			 field[0].requestFocus();
		    }
			else{int choose=JOptionPane.showConfirmDialog(getParent(), "你确认要删除该课程？", "警告", JOptionPane.WARNING_MESSAGE);
			if(choose==0){
				UserService service=new UserService();
				
				 if(service.deleteCourse(Integer.parseInt(field[0].getText()))){
					JOptionPane.showMessageDialog(getParent(), "操作成功");
					 field[0].setText("");
					 field[1].setText("");
					 field[2].setText("");
					 field[3].setText("");
					 field[4].setText("");
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "操作失败");
				}
		      }
			}
		}
		if(e.getSource()==update){
			int choose=JOptionPane.showConfirmDialog(getParent(), "你确认要更新!");
			if(choose==0){
				 Course cs=new Course();
				 cs.setCoursenum(field[0].getText());
				 cs.setCoursenam(field[1].getText());
				 cs.setStutim(field[2].getText());
				 cs.setCredit(field[3].getText()); 
				 cs.setTeacher(field[4].getText());
				 
				 UserService service = new UserService();
				
				 if(  service.updateCourse(cs)){
					 field[0].setText("");
					 field[1].setText("");
					 field[2].setText("");
					 field[3].setText("");
					 field[4].setText("");
					JOptionPane.showConfirmDialog(getParent(), "操作成功");
				 }
				 else{
					 JOptionPane.showConfirmDialog(getParent(), "操作失败");
				 }
			}
		}
	}

}
