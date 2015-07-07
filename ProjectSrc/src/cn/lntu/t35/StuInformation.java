package cn.lntu.t35;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.lntu.t35.User;
import cn.lntu.t35.UserService;

public class StuInformation extends JPanel implements ActionListener {
	/**
	 * ѧ����Ϣ�Ĵ���
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel[] label = { new JLabel("Ȩ�ޣ�"),
			new JLabel("���룺"),new JLabel("������"), new JLabel("ѧ�ţ�"),
			new JLabel("�Ա�"), new JLabel("���᣺"), new JLabel("�༶��"),
			new JLabel("רҵ��"), new JLabel("ѧԺ��") };
	
	private JTextField[] field = { new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			new JTextField(""),new JTextField("")};
	
	private String[] sex = { "          ��", "          Ů" };
	private String[] power = {"00","11","����"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox sexchoose = new JComboBox(sex);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox powerchoose = new JComboBox(power);
	private JPasswordField passWd = new JPasswordField();
	private JButton input = new JButton("�ύ");

	private int i;

	public StuInformation() {
		initialFrame();
		addListener();
	}

	private void addListener() {
		field[i].addActionListener(this);
		passWd.addActionListener(this);
		sexchoose.addActionListener(this);
		powerchoose.addActionListener(this);
		input.addActionListener(this);
	}

	private void initialFrame() {
		this.setLayout(null);
		for (i = 0; i < label.length; i++) {
			if(i<7){
			label[i].setBounds(100, 60 + 50 * i, 160, 30);
			field[i].setBounds(150, 60 + 50 * i, 160, 30);}
			else {
				label[i].setBounds(430, 200+(i-6)*50, 160, 30);
				field[i].setBounds(480, 200+(i-6)*50, 160, 30);
			}
			this.add(label[i]);
			this.add(field[i]);
			// label[i].setHorizontalAlignment(JLabel.RIGHT);
			//field[i].setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
		}
		this.remove(field[0]);
		this.remove(field[1]);
		this.remove(field[4]);
		
		passWd.setBounds(150,110,160,30);
		sexchoose.setBounds(170, 260, 90, 30);
		powerchoose.setBounds(170,60,90,30);
		input.setBounds(480, 360, 90, 30);
	
		this.add(passWd);
		this.add(sexchoose);
		this.add(powerchoose);
		this.add(input);

	}

	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==input){
		 if(passWd.getText().equals("")){JOptionPane.showMessageDialog(getParent(), "�������ʼ���룡");
		     passWd.requestFocus();
		    }
		 else if(field[2].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "��������Ϊ�գ�");
		    field[2].requestFocus();
		    }
		 else if(field[3].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "ѧ�Ų���Ϊ�գ�");
		    field[3].requestFocus();
		    }
		 else if(field[5].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "���᲻��Ϊ�գ�");
		    field[5].requestFocus();
		    }
		 else if(field[6].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "���������ڰ༶��");
		    field[6].requestFocus();
		    }
		 else if(field[7].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "����������רҵ��");
		    field[7].requestFocus();
		    }
		 else if(field[8].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "����������ѧԺ��");
		    field[8].requestFocus();
		    }
		 else{
			 User ls=new User();
			 ls.setPower((String)powerchoose.getSelectedItem());
			 ls.setPassword(passWd.getText());
			 ls.setStuname(field[2].getText());
			 ls.setStunum(field[3].getText());
			 ls.setStusex((String)sexchoose.getSelectedItem());
			 ls.setStuhometown(field[5].getText());
			 ls.setStuclass(field[6].getText());
			 ls.setStumajor(field[7].getText());
			 ls.setStuinstitute(field[8].getText());
			 UserService us = new UserService();
			
			 
			 if(us.saveStudent(ls)){
				 
				 JOptionPane.showMessageDialog(getParent(), "�����ɹ���"); 
				 passWd.setText("");
				 field[2].setText("");
				 field[3].setText("");
				 field[5].setText("");
				 field[6].setText("");
				 field[7].setText("");
				 field[8].setText("");
			 }else{
				 JOptionPane.showMessageDialog(getParent(), "�޸�ʧ��!");	
				 passWd.setText("");
				 field[2].setText("");
				 field[3].setText("");
				 field[5].setText("");
				 field[6].setText("");
				 field[7].setText("");
				 field[8].setText("");
			 }
			 }
		 }
		
	}
}

class InformationOperate extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel[] label = { new JLabel("Ȩ�ޣ�"),
			new JLabel("���룺"),new JLabel("������"), new JLabel("ѧ�ţ�"),
			new JLabel("�Ա�"), new JLabel("���᣺"), new JLabel("�༶��"),
			new JLabel("רҵ��"), new JLabel("ѧԺ��") };
	
	private JTextField[] field = { new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField(""), new JTextField(""),
			new JTextField(""),new JTextField("")};	
	private JButton quarry = new JButton("��ѯ");
			JButton update = new JButton("�޸�");
			JButton delete = new JButton("ɾ��");

	private int i;
	public InformationOperate() {
		initialFrame();
		addListener();
	}

	private void addListener() {
		field[i].addActionListener(this);
		quarry.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
	}

	private void initialFrame() {
		this.setLayout(null);
		for (i = 0; i < label.length; i++) {
			if(i<5){
			label[i].setBounds(100, 60 + 50 * i, 160, 30);
			field[i].setBounds(150, 60 + 50 * i, 160, 30);}
			else {
				label[i].setBounds(430, 50+(i-5)*50, 160, 30);
				field[i].setBounds(480, 50+(i-5)*50, 160, 30);
			}
			this.add(label[i]);
			this.add(field[i]);
			//label[i].setHorizontalAlignment(JLabel.RIGHT);
			field[i].setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
		}
	
		quarry.setBounds(410, 260, 90, 30);
		update.setBounds(500, 260, 90, 30);
		delete.setBounds(590, 260, 90, 30);
		
		
		this.add(quarry);	
		this.add(update);	
		this.add(delete);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==quarry){
			if(field[3].getText().equals("")){JOptionPane.showMessageDialog(getParent(), "������ѧ�Ž��в�ѯ��");
			field[3].requestFocus();
			}	
			else{
				int id=0;
				User qs=new User();
				id=Integer.parseInt(field[3].getText());
				UserService service=new UserService();
				qs=service.queryStudent(id);
				field[0].setText(qs.getPower());
				field[1].setText(qs.getPassword());
				field[2].setText(qs.getStuname());
				field[3].setText(qs.getStunum());
				field[4].setText(qs.getStusex());
				field[5].setText(qs.getStuhometown());
				field[6].setText(qs.getStuclass());
				field[7].setText(qs.getStumajor());
				field[8].setText(qs.getStuinstitute());
				update.setVisible(true);
				delete.setVisible(true);
			
			}
		}	
		if(e.getSource()==delete){
			int choose=JOptionPane.showConfirmDialog(getParent(), "��ȷ��Ҫɾ�����ѧ����", "����", JOptionPane.WARNING_MESSAGE);
			if(choose==0){
				UserService service=new UserService();
				if(service.deleteStudent(Integer.parseInt(field[3].getText()))){
					JOptionPane.showMessageDialog(getParent(), "�����ɹ�");
					 field[0].setText("");
					 field[1].setText("");
					 field[2].setText("");
					 field[3].setText("");
					 field[4].setText("");
					 field[5].setText("");
					 field[6].setText("");
					 field[7].setText("");
					 field[8].setText("");
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "����ʧ��");
				}
		}
		}
		if(e.getSource()==update){
			int choose=JOptionPane.showConfirmDialog(getParent(), "��ȷ��Ҫ����!");
			if(choose==0){
				 User cs=new User();
				 cs.setPower(field[0].getText());
				 cs.setPassword(field[1].getText());
				 cs.setStuname(field[2].getText());
				 cs.setStunum(field[3].getText()); 
				 cs.setStusex(field[4].getText());
				 cs.setStuhometown(field[5].getText());
				 cs.setStuclass(field[6].getText());
				 cs.setStumajor(field[7].getText());
				 cs.setStuinstitute(field[8].getText());
				 
				 UserService service = new UserService();
				
				 if(  service.updateStudent(cs)){
					 
					JOptionPane.showConfirmDialog(getParent(), "�����ɹ�");
					 field[0].setText("");
					 field[1].setText("");
					 field[2].setText("");
					 field[3].setText("");
					 field[4].setText("");
					 field[5].setText("");
					 field[6].setText("");
					 field[7].setText("");
					 field[8].setText("");
				 }
				 else{
					 JOptionPane.showConfirmDialog(getParent(), "����ʧ��");
				 }
			}
		}
	}
	
}

