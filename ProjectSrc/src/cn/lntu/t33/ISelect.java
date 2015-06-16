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

public class ISelect extends JDialog implements ActionListener   
{    
	  Hashtable ��������Ϣ��=null;                              
	  JTextField �����˱��,����������,�绰;                    
	  JRadioButton ��,Ů;   
	  JButton ��ѯ;   
	  ButtonGroup group=null;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  File file=null;                                              
	  public ISelect(JFrame f,File file)   
	  {   
	   super(f,"��ѯ�Ի���",false);                              
	   this.file=file;   
	   �����˱��=new JTextField(10);   
	   ��ѯ=new JButton("��ѯ");   
	   �����˱��.addActionListener(this);   
	   ��ѯ.addActionListener(this);   
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
	   box1.add(new JLabel("����Ҫ��ѯ�Ľ����˱��:",JLabel.CENTER));   
	   box1.add(�����˱��);   
	   box1.add(��ѯ);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("����������:",JLabel.CENTER));   
	   box2.add(����������);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("�������Ա�:",JLabel.CENTER));   
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
	     ����������.setText(null);   
	     �绰.setText(null);      
	        
	    if(e.getSource()==��ѯ||e.getSource()==�����˱��)   
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

