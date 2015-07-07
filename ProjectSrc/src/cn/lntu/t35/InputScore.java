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
	 * �ɼ�����
	 */
	private static final long serialVersionUID = 1L;
	private JLabel[] label = { new JLabel("ѧ���ţ�"),new JLabel("ѧ��������"),new JLabel("�γ̺ţ�"), new JLabel("�γ����ƣ�"),
			new JLabel("�ɼ���")};
	
	private JTextField[] field = { new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			};
	private JButton input = new JButton("�ύ");
	private JButton update = new JButton("�޸�");
	private JButton delete = new JButton("ɾ��");
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
			 if(field[0].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������ѧ��ѧ�ţ�");
			 field[0].requestFocus();
		    }
			 
			 else if(field[2].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������γ̺ţ�");
			 field[2].requestFocus();
		    }
			
			 else if(field[4].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������ɼ���");
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
					 JOptionPane.showMessageDialog(getParent(), "�����ɹ���"); 
					 }
	             else{
	            	 field[0].setText("");
					
					 field[2].setText("");
					 
					 field[4].setText("");
					 JOptionPane.showMessageDialog(getParent(), "�ύʧ��!");	
					 }
			 }
		}
		if(e.getSource()==update){
			int choose=JOptionPane.showConfirmDialog(getParent(), "��ȷ��Ҫ����!");
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
					JOptionPane.showConfirmDialog(getParent(), "�����ɹ�");
				 }
				 else{
					 JOptionPane.showConfirmDialog(getParent(), "����ʧ��");
				 }
			}
		}
		if(e.getSource()==delete){
			int choose=JOptionPane.showConfirmDialog(getParent(), "��ȷ��Ҫɾ�����", "����", JOptionPane.WARNING_MESSAGE);
			if(choose==0){
				ScoreService service=new ScoreService();
			
				if(service.deleteScore(Integer.parseInt(field[0].getText()),Integer.parseInt(field[2].getText()))){
					
					 field[0].setText("");
					 
					 field[2].setText("");
					 
					 field[4].setText("");
					 JOptionPane.showMessageDialog(getParent(), "�����ɹ�");
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "����ʧ��");
				}
		    }
		}
	}

}
