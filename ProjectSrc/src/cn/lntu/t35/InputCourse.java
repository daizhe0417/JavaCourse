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
	 * �γ���Ϣ����
	 */
	private static final long serialVersionUID = -95897441548430657L;
	private JLabel[] label = { new JLabel("�γ̺ţ�"),new JLabel("�γ����ƣ�"),new JLabel("ѧʱ��"), new JLabel("ѧ�֣�"),
			new JLabel("��ʦ��")};
	
	private JTextField[] field = { new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			};
	private JButton input = new JButton("�ύ");
	private JButton quarry = new JButton("��ѯ");
	private JButton update = new JButton("�޸�");
	private JButton delete = new JButton("ɾ��");
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
			 if(field[0].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������γ̺ţ�");
			 field[0].requestFocus();
		    }
			 else if(field[1].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������γ����ƣ�");
			 field[1].requestFocus();
		    }
			 else if(field[2].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������γ�ѧʱ��");
			 field[2].requestFocus();
		    }
			 else if(field[3].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������γ�ѧ�֣�");
			 field[3].requestFocus();
		    }
			 else if(field[4].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "�������ο���ʦ��");
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
					 JOptionPane.showMessageDialog(getParent(), "�����ɹ���"); 
					 }
	             else{
	            	 field[0].setText("");
					 field[1].setText("");
					 field[2].setText("");
					 field[3].setText("");
					 field[4].setText("");
					 JOptionPane.showMessageDialog(getParent(), "�ύʧ��!");	
					 }
			 }
		} 
		if(e.getSource()==quarry){
			if(field[0].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������γ̺Ž��в�ѯ��");
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
			if(field[0].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������Ҫɾ���Ŀγ̺ţ�");
			 field[0].requestFocus();
		    }
			else{int choose=JOptionPane.showConfirmDialog(getParent(), "��ȷ��Ҫɾ���ÿγ̣�", "����", JOptionPane.WARNING_MESSAGE);
			if(choose==0){
				UserService service=new UserService();
				
				 if(service.deleteCourse(Integer.parseInt(field[0].getText()))){
					JOptionPane.showMessageDialog(getParent(), "�����ɹ�");
					 field[0].setText("");
					 field[1].setText("");
					 field[2].setText("");
					 field[3].setText("");
					 field[4].setText("");
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "����ʧ��");
				}
		      }
			}
		}
		if(e.getSource()==update){
			int choose=JOptionPane.showConfirmDialog(getParent(), "��ȷ��Ҫ����!");
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
					JOptionPane.showConfirmDialog(getParent(), "�����ɹ�");
				 }
				 else{
					 JOptionPane.showConfirmDialog(getParent(), "����ʧ��");
				 }
			}
		}
	}

}
