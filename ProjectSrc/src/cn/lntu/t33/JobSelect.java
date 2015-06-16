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

public class JobSelect extends JDialog implements ActionListener   
{    
	  Hashtable ְҵ��Ϣ��=null;                              
	  JTextField ְҵ��,ְҵ����,ְҵ���ͺ�,ְҵ��������,��λ��,��λ����,רҵҪ��,��Ƹ����,��������,����;                        
	  JButton ��ѯ;      
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  File file=null;                                              
	  public JobSelect(JFrame f,File file)   
	  {   
	   super(f,"��ѯ�Ի���",false);                              
	   this.file=file;   
	   ְҵ��=new JTextField(10);   
	   ��ѯ=new JButton("��ѯ");   
	   ְҵ��.addActionListener(this);   
	   ��ѯ.addActionListener(this);   
	   ְҵ����=new JTextField(10);   
	   ְҵ����.setEditable(false);   
	   ְҵ���ͺ�=new JTextField(10);   
	   ְҵ���ͺ�.setEditable(false);   
	   ְҵ��������=new JTextField(10);   
	   ְҵ��������.setEditable(false);   
	   ��λ��=new JTextField(10);   
	   ��λ��.setEditable(false);
	   ��λ����=new JTextField(10);   
	   ��λ����.setEditable(false);
	   רҵҪ��=new JTextField(10);   
	   רҵҪ��.setEditable(false);   
	   ��Ƹ����=new JTextField(10);   
	   ��Ƹ����.setEditable(false);   
	   ��������=new JTextField(10);   
	   ��������.setEditable(false);
	   ����=new JTextField(10);   
	   ����.setEditable(false);
	     
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("����Ҫ��ѯ��ְҵ��:",JLabel.CENTER));   
	   box1.add(ְҵ��);   
	   box1.add(��ѯ);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("ְҵ����:",JLabel.CENTER));   
	   box2.add(ְҵ����);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("ְҵ���ͺ�:",JLabel.CENTER));   
	   box3.add(ְҵ���ͺ�);      
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("ְҵ��������:",JLabel.CENTER));   
	   box4.add(ְҵ��������);   
	   Box box5=Box.createHorizontalBox();                 
	   box5.add(new JLabel("��λ��:",JLabel.CENTER));   
	   box5.add(��λ��);   
	   Box box6=Box.createHorizontalBox();                 
	   box6.add(new JLabel("��λ����:",JLabel.CENTER));   
	   box6.add(��λ����);
	   Box box7=Box.createHorizontalBox();
	   box7.add(new JLabel("רҵҪ��:",JLabel.CENTER));   
	   box7.add(רҵҪ��);      
	   Box box8=Box.createHorizontalBox();                 
	   box8.add(new JLabel("��Ƹ����:",JLabel.CENTER));   
	   box8.add(��Ƹ����);   
	   Box box9=Box.createHorizontalBox();                 
	   box9.add(new JLabel("��������:",JLabel.CENTER));   
	   box9.add(��������);   
	   Box box10=Box.createHorizontalBox();                 
	   box10.add(new JLabel("����/��:",JLabel.CENTER));   
	   box10.add(����); 
	   Box boxH=Box.createVerticalBox();                 
	   boxH.add(box1);   
	   boxH.add(box2);   
	   boxH.add(box3);   
	   boxH.add(box4); 
	   boxH.add(box5);   
	   boxH.add(box6); 
	   boxH.add(box7);   
	   boxH.add(box8); 
	   boxH.add(box9);   
	   boxH.add(box10); 
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
		 ְҵ����.setText(null);                                   
         ְҵ���ͺ�.setText(null);   
         ְҵ��������.setText(null);   
         ��λ��.setText(null);
         ��λ����.setText(null);                                   
         רҵҪ��.setText(null);   
         ��Ƹ����.setText(null);   
         ��������.setText(null); 
         ����.setText(null);   
	        
	    if(e.getSource()==��ѯ||e.getSource()==ְҵ��)   
	      {   
	         String number="";   
	         number=ְҵ��.getText();   
	           
	         if(number.length()>0)   
	            {   
	              try {   
	                    inOne=new FileInputStream(file);   
	                    inTwo=new ObjectInputStream(inOne);   
	                    ְҵ��Ϣ��=(Hashtable)inTwo.readObject();   
	                    inOne.close();   
	                    inTwo.close();   
	                  }   
	               catch(Exception ee)   
	                   {   
	                   }   
	              if(ְҵ��Ϣ��.containsKey(number))             
	                 {   
	                   JobInformation stu=(JobInformation)ְҵ��Ϣ��.get(number);   
	                   ְҵ����.setText(stu.getzyname());
	                   ְҵ���ͺ�.setText(stu.getzylxnumber());   
	                   ְҵ��������.setText(stu.getzylxname());   
	                   ��λ��.setText(stu.getdwnumber());  
	                   ��λ����.setText(stu.getdwname());   
	                   רҵҪ��.setText(stu.getzyyq());   
	                   ��Ƹ����.setText(stu.getyprs());   
	                   ��������.setText(stu.getxqrs());
	                   ����.setText(stu.getgz());    
	                    
	      
	                 }   
	              else   
	                 {    
	                  String warning="��ְҵ�Ų�����!";   
	                  JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	                 }   
	            }   
	        else   
	            {    
	              String warning="����Ҫ����ְҵ��!";   
	              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	            }   
	      }    
	  }   
	}   

