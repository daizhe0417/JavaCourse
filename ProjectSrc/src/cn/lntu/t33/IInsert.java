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

public class IInsert extends JPanel implements ActionListener   
{    
	  Hashtable ��������Ϣ��=null;                              
	  JTextField �����˱��,����������,�绰;                    
	  JRadioButton ��,Ů;   
	  Introducer  ������=null;   
	  ButtonGroup group=null;   
	  JButton ¼��,����;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public IInsert(File file)   
	  {   
	     
	   this.file=file;   
	   �����˱��=new JTextField(10);   
	   ����������=new JTextField(10);   
	   �绰=new JTextField(10);      
	   group=new ButtonGroup();   
	   ��=new JRadioButton("��",true);   
	   Ů=new JRadioButton("Ů",false);   
	   group.add(��);   
	   group.add(Ů);   
	   ¼��=new JButton("¼��");   
	   ����=new JButton("����");   
	   ¼��.addActionListener(this);   
	   ����.addActionListener(this);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("�����˱��:",JLabel.CENTER));   
	   box1.add(�����˱��);   
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
	   JPanel pSouth=new JPanel();   
	   pSouth.add(¼��);   
	   pSouth.add(����);   
	   add(pSouth,BorderLayout.SOUTH);   
	   validate();   
	  }   
	 public void actionPerformed(ActionEvent e)   
	  {   
	    if(e.getSource()==¼��)   
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
	                   String warning="�ý�������Ϣ�Ѵ���,�뵽�޸�ҳ���޸�!";   
	                       
	                   JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	                 }   
	              else   
	                 {     
	                   String m="��������Ϣ����¼��!";   
	                   int ok=JOptionPane.showConfirmDialog(this,m,"ȷ��",JOptionPane.YES_NO_OPTION,   
	                                                 JOptionPane.INFORMATION_MESSAGE);   
	                  if(ok==JOptionPane.YES_OPTION)   
	                    {   
	                     String name=����������.getText();   
	                     String phone=�绰.getText();     
	                     String sex=null;   
	                        if(��.isSelected())   
	                           {   
	                             sex=��.getText();   
	                           }   
	                        else   
	                           {   
	                             sex=Ů.getText();   
	                           }   
	                     ������= new Introducer();   
	                     ������.setIdnumber(number);
	                     ������.setIdname(name);   
	                     ������.setphone(phone);      
	                     ������.setsex(sex);   
	                       try{   
	                           outOne=new FileOutputStream(file);   
	                           outTwo=new ObjectOutputStream(outOne);   
	                           ��������Ϣ��.put(number,������);   
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
	                }    
	            }   
	        else   
	            {    
	              String warning="����Ҫ��������˱��!";   
	              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	            }   
	      }    
	    if(e.getSource()==����)   
	      {    
	        �����˱��.setText(null);   
	        ����������.setText(null);   
	        �绰.setText(null);   
	           
	           
	      }   
	  }   
	}   
