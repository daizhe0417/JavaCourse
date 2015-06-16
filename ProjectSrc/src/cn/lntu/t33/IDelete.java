package cn.lntu.t33;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class IDelete extends JPanel implements ActionListener   
{    
	  Hashtable ��������Ϣ��=null;                              
	  JTextField �����˱��,����������,�绰;                     
	  JRadioButton ��,Ů;   
	  JButton ɾ��;   
	  ButtonGroup group=null;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public IDelete(File file)   
	  {   
	   this.file=file;   
	   �����˱��=new JTextField(10);   
	   ɾ��=new JButton("ɾ��");   
	   �����˱��.addActionListener(this);   
	   ɾ��.addActionListener(this);   
	   ����������=new JTextField(10);   
	   ����������.setEditable(false);   
	   �绰=new JTextField(10);   
	   �绰.setEditable(false);     
	   ��=new JRadioButton("��",false);   
	   Ů=new JRadioButton("Ů",false);   
	   group=new ButtonGroup();   
	   group.add(��);   
	   group.add(Ů);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("����Ҫɾ���Ľ����˱��:",JLabel.CENTER));   
	   box1.add(�����˱��);   
	   box1.add(ɾ��);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("����������:",JLabel.CENTER));   
	   box2.add(����������);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("�Ա�:",JLabel.CENTER));   
	   box3.add(��);   
	   box3.add(Ů);   
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("�绰:",JLabel.CENTER));   
	   box4.add(�绰);   
	   Box boxH=Box.createVerticalBox();                 
	   boxH.add(box1);   
	   boxH.add(box2);   
	   boxH.add(box3);   
	   boxH.add(box4);    
	   boxH.add(Box.createVerticalGlue());             
	   JPanel pCenter=new JPanel();   
	   pCenter.add(boxH);   
	   setLayout(new BorderLayout());   
	   add(pCenter,BorderLayout.CENTER);   
	   validate();   
	  }   
	 public void actionPerformed(ActionEvent e)   
	  {   
	    if(e.getSource()==ɾ��||e.getSource()==�����˱��)   
	      {   
	        String number="";   
	        number=�����˱��.getText();   
	           
	         if(number.length()>0)   
	            {   
	              try {   
	                    inOne=new FileInputStream(file);   
	                    inTwo=new ObjectInputStream(inOne);   
	                    ��������Ϣ��=(Hashtable)inTwo.readObject();   
	                    inOne.close();   
	                    inTwo.close();   
	                  }   
	               catch(Exception ee)   
	                   {   
	                   }   
	              if(��������Ϣ��.containsKey(number))             
	                 {   
	            	  Introducer stu=(Introducer)��������Ϣ��.get(number);   
	                   ����������.setText(stu.getIdname());   
	                   �绰.setText(stu.getphone());      
	                   if(stu.getsex().equals("��"))   
	                      {   
	                        ��.setSelected(true);   
	                      }   
	                    else   
	                      {   
	                        Ů.setSelected(true);   
	                      }   
	                  String m="ȷ��Ҫɾ���ý����˼�ȫ����Ϣ��?";   
	                  int ok=JOptionPane.showConfirmDialog(this,m,"ȷ��",JOptionPane.YES_NO_OPTION,   
	                                                 JOptionPane.QUESTION_MESSAGE);   
	                  if(ok==JOptionPane.YES_OPTION)   
	                     {   
	                       ��������Ϣ��.remove(number);   
	                       try   
	                        {   
	                          outOne=new FileOutputStream(file);   
	                          outTwo=new ObjectOutputStream(outOne);   
	                          outTwo.writeObject(��������Ϣ��);   
	                          outTwo.close();   
	                          outOne.close();   
	                          �����˱��.setText(null);   
	    	                  ����������.setText(null);   
	    	           	      �绰.setText(null);   
	                        }   
	                       catch(Exception ee)   
	                        {    
	                         System.out.println(ee);   
	                        }   
	                     }   
	                   else if(ok==JOptionPane.NO_OPTION)   
	                     {   
	                	   �����˱��.setText(null);   
	    	               ����������.setText(null);   
	    	           	   �绰.setText(null);    
	                     }   
	                 }   
	              else   
	                 {    
	                  String warning="�ý����˱�Ų�����!";   
	                  JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	                 }   
	            }   
	        else   
	            {    
	              String warning="����Ҫ��������˱��!";   
	              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	            }   
	      }    
	  }   
	} 
