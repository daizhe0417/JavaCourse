package cn.lntu.t33;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HSelect extends JDialog implements ActionListener   
{    
	  Hashtable ��ְ����Ϣ��=null;                              
	  JTextField ��ְ�ߺ�,��ְ������,����רҵ,�Ƿ�Ƹ��,��нҪ��;                    
	  JRadioButton ��,Ů;   
	  JButton ��ѯ;   
	  ButtonGroup group=null;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  File file=null;                                              
	  public HSelect(JFrame f,File file)   
	  {   
	   super(f,"��ѯ�Ի���",false);                              
	   this.file=file;   
	   ��ְ�ߺ�=new JTextField(10);   
	   ��ѯ=new JButton("��ѯ");   
	   ��ְ�ߺ�.addActionListener(this);   
	   ��ѯ.addActionListener(this);   
	   ��ְ������=new JTextField(10);   
	   ��ְ������.setEditable(false);   
	   ����רҵ=new JTextField(10);   
	   ����רҵ.setEditable(false);   
	   �Ƿ�Ƹ��=new JTextField(10);   
	   �Ƿ�Ƹ��.setEditable(false);   
	   ��нҪ��=new JTextField(10);   
	   ��нҪ��.setEditable(false);   
	   ��=new JRadioButton("��",false);   
	   Ů=new JRadioButton("Ů",false);   
	   group=new ButtonGroup();   
	   group.add(��);   
	   group.add(Ů);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("����Ҫ��ѯ����ְ�ߺ�:",JLabel.CENTER));   
	   box1.add(��ְ�ߺ�);   
	   box1.add(��ѯ);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("��ְ������:",JLabel.CENTER));   
	   box2.add(��ְ������);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("��ְ���Ա�:",JLabel.CENTER));   
	   box3.add(��);   
	   box3.add(Ů);   
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("����רҵ:",JLabel.CENTER));   
	   box4.add(����רҵ);   
	   Box box5=Box.createHorizontalBox();                 
	   box5.add(new JLabel("�Ƿ�Ƹ��:",JLabel.CENTER));   
	   box5.add(�Ƿ�Ƹ��);   
	   Box box6=Box.createHorizontalBox();                 
	   box6.add(new JLabel("��нҪ��/��:",JLabel.CENTER));   
	   box6.add(��нҪ��);   
	   Box boxH=Box.createVerticalBox();                 
	   boxH.add(box1);   
	   boxH.add(box2);   
	   boxH.add(box3);   
	   boxH.add(box4);   
	   boxH.add(box5);   
	   boxH.add(box6);   
	   boxH.add(Box.createVerticalGlue());             
	   JPanel pCenter=new JPanel();   
	   pCenter.add(boxH);   
	   Container con=getContentPane();   
	   con.add(pCenter,BorderLayout.CENTER);   
	   con.validate();   
	   setVisible(false);   
	   setBounds(100,200,360,270);   
	   addWindowListener(new WindowAdapter()   
	                    { public void windowClosing(WindowEvent e)   
	                       {   
	                         setVisible(false);   
	                       }   
	                    });   
	  }   
	 public void actionPerformed(ActionEvent e)   
	  {       
	     ��ְ������.setText(null);   
	     ����רҵ.setText(null);   
	     �Ƿ�Ƹ��.setText(null);   
	     ��нҪ��.setText(null);   
	        
	    if(e.getSource()==��ѯ||e.getSource()==��ְ�ߺ�)   
	      {   
	         String number="";   
	         number=��ְ�ߺ�.getText();   
	           
	         if(number.length()>0)   
	            {   
	              try {   
	                    inOne=new FileInputStream(file);   
	                    inTwo=new ObjectInputStream(inOne);   
	                    ��ְ����Ϣ��=(Hashtable)inTwo.readObject();   
	                    inOne.close();   
	                    inTwo.close();   
	                  }   
	               catch(Exception ee)   
	                   {   
	                   }   
	              if(��ְ����Ϣ��.containsKey(number))             
	                 {   
	                   Jobhunter stu=(Jobhunter)��ְ����Ϣ��.get(number);   
	                   ��ְ������.setText(stu.getjhname());   
	                   ����רҵ.setText(stu.getgdzy());   
	                   �Ƿ�Ƹ��.setText(stu.getsfpy());   
	                   ��нҪ��.setText(stu.getyxyq());    
	                   if(stu.getsex().equals("��"))   
	                      {   
	                        ��.setSelected(true);   
	                      }   
	                    else   
	                      {   
	                        Ů.setSelected(true);   
	                      }   
	      
	                 }   
	              else   
	                 {    
	                  String warning="����ְ�ߺŲ�����!";   
	                  JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	                 }   
	            }   
	        else   
	            {    
	              String warning="����Ҫ������ְ�ߺ�!";   
	              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	            }   
	      }    
	  }   
	}   
