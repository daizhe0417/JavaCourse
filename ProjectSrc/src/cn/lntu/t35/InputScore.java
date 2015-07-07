package cn.lntu.t35;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.lntu.t35.Score;
import cn.lntu.t35.ScoreService;

public class InputScore extends JPanel implements ActionListener{
	/**
	 * 成绩管理
	 */
	private static final long serialVersionUID = 1L;
	private JLabel[] label = { new JLabel("学生号："),new JLabel("学生姓名："),new JLabel("课程号："), new JLabel("课程名称："),
			new JLabel("成绩：")};
	
	private JTextField[] field = { new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			};
	private JButton input = new JButton("提交");
	private JButton update = new JButton("修改");
	private JButton delete = new JButton("删除");
	private int i;
	
	public InputScore(){
		initialFrame();
		addListener();
	}
	private void addListener() {
		for (i = 0; i < field.length; i++) {
			 field[i].addActionListener(this);
			 }
			 input.addActionListener(this);
			 update.addActionListener(this);
			 delete.addActionListener(this);
		
	}
	private void initialFrame() {
		 this.setLayout(null);
		    for (i = 0; i < field.length; i++) {
			label[i].setBounds(100, 60 + 50 * i, 160, 30);
			field[i].setBounds(190, 60 + 50 * i, 160, 30);	
			input.setBounds(120, 360, 90, 30);
			update.setBounds(210, 360, 90, 30);
			delete.setBounds(300, 360, 90, 30);
			this.remove(field[1]);
			this.remove(field[3]);
			this.remove(label[1]);
			this.remove(label[3]);

			this.add(label[i]);
			this.add(field[i]);
			this.add(input);
			this.add(update);
			this.add(delete);
		 }	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input){
			 if(field[0].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入学生学号！");
			 field[0].requestFocus();
		    }
			 
			 else if(field[2].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入课程号！");
			 field[2].requestFocus();
		    }
			
			 else if(field[4].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "请输入成绩！");
			 field[4].requestFocus();
		    }
			 else{
				 Score is=new Score();
				 is.setStunum(field[0].getText());
				
				 is.setCoursenum(field[2].getText());
				 
				 is.setScscore(field[4].getText());
				 ScoreService cs = new ScoreService();
				
		             if(cs.saveScore(is)){
		            	 field[0].setText("");
						 
						 field[2].setText("");
						 
						 field[4].setText("");
					 JOptionPane.showMessageDialog(getParent(), "操作成功！"); 
					 }
	             else{
	            	 field[0].setText("");
					
					 field[2].setText("");
					 
					 field[4].setText("");
					 JOptionPane.showMessageDialog(getParent(), "提交失败!");	
					 }
			 }
		}
		if(e.getSource()==update){
			int choose=JOptionPane.showConfirmDialog(getParent(), "你确认要更新!");
			if(choose==0){
				 Score ss=new Score();
				 ss.setStunum(field[0].getText());
				
				 ss.setCoursenum(field[2].getText());
				 
				 ss.setScscore(field[4].getText());
				 
				 ScoreService score = new ScoreService();
				
				 if(  score.updateScore(ss)){
					 field[0].setText("");
					
					 field[2].setText("");
					 
					 field[4].setText("");
					JOptionPane.showConfirmDialog(getParent(), "操作成功");
				 }
				 else{
					 JOptionPane.showConfirmDialog(getParent(), "操作失败");
				 }
			}
		}
		if(e.getSource()==delete){
			int choose=JOptionPane.showConfirmDialog(getParent(), "你确认要删除该项？", "警告", JOptionPane.WARNING_MESSAGE);
			if(choose==0){
				ScoreService service=new ScoreService();
			
				if(service.deleteScore(Integer.parseInt(field[0].getText()),Integer.parseInt(field[2].getText()))){
					
					 field[0].setText("");
					 
					 field[2].setText("");
					 
					 field[4].setText("");
					 JOptionPane.showMessageDialog(getParent(), "操作成功");
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "操作失败");
				}
		    }
		}
	}

}
