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

public class IUpdate extends JPanel implements ActionListener   
{    
	  Hashtable 介绍人信息表=null;                              
	  JTextField 介绍人编号,介绍人姓名,电话;                    
	  JRadioButton 男,女;   
	  ButtonGroup group=null;   
	  JButton 开始修改,录入修改,重置;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public IUpdate(File file)   
	  {   
	   this.file=file;   
	   介绍人编号=new JTextField(10);   
	   介绍人姓名=new JTextField(10);                                   
	   电话=new JTextField(10);     
	   group=new ButtonGroup();   
	   男=new JRadioButton("男",true);   
	   女=new JRadioButton("女",false);   
	   group.add(男);   
	   group.add(女);   
	   开始修改=new JButton("开始修改");   
	   录入修改=new JButton("录入修改");   
	   录入修改.setEnabled(false);   
	   重置=new JButton("重置");   
	   介绍人编号.addActionListener(this);   
	   开始修改.addActionListener(this);   
	   录入修改.addActionListener(this);   
	   重置.addActionListener(this);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("输入要修改信息的介绍人编号:",JLabel.CENTER));   
	   box1.add(介绍人编号);   
	   box1.add(开始修改);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("(新)介绍人姓名:",JLabel.CENTER));   
	   box2.add(介绍人姓名);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("(新)性别:",JLabel.CENTER));   
	   box3.add(男);   
	   box3.add(女);   
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("(新)电话:",JLabel.CENTER));   
	   box4.add(电话);      
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
	   pSouth.add(录入修改);   
	   pSouth.add(重置);   
	   add(pSouth,BorderLayout.SOUTH);   
	   validate();   
	  }   
	 public void actionPerformed(ActionEvent e)   
	 {    
	   if(e.getSource()==开始修改||e.getSource()==介绍人编号)   
	      {   
	         String number="";   
	        number=介绍人编号.getText();   
	           
	         if(number.length()>0)   
	            {   
	              try {   
	                    inOne=new FileInputStream(file);   
	                    inTwo=new ObjectInputStream(inOne);   
	                    介绍人信息表=(Hashtable)inTwo.readObject();   
	                    inOne.close();   
	                    inTwo.close();   
	                  }   
	               catch(Exception ee)   
	                   {   
	                   }   
	              if(介绍人信息表.containsKey(number))             
	                 {   
	                   录入修改.setEnabled(true);   
	                   Introducer stu=(Introducer)介绍人信息表.get(number);   
	                   介绍人姓名.setText(stu.getIdname());   
	                   电话.setText(stu.getphone());     
	                   if(stu.getsex().equals("男"))   
	                      {   
	                        男.setSelected(true);   
	                      }   
	                    else   
	                      {   
	                        女.setSelected(true);   
	                      }   
	                 }    
	              else   
	                 {    
	                  录入修改.setEnabled(false);   
	                     
	                  String warning="该介绍人编号不存在!";   
	                  JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	                  介绍人编号.setText(null);   
	                  介绍人姓名.setText(null);   
	           	      电话.setText(null);     
	   
	                 }   
	            }   
	        else   
	            {    
	              录入修改.setEnabled(false);    
	                 
	              String warning="必须要输入介绍人编号!";   
	              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	              介绍人编号.setText(null);   
                  介绍人姓名.setText(null);   
           	      电话.setText(null);  
	            }   
	      }    
	  else if(e.getSource()==录入修改)   
	      {    
	        String number="";   
	        number=介绍人编号.getText();   
	        if(number.length()>0)   
	           {   
	            try {   
	                 inOne=new FileInputStream(file);   
	                 inTwo=new ObjectInputStream(inOne);   
	                 介绍人信息表=(Hashtable)inTwo.readObject();   
	                 inOne.close();   
	                 inTwo.close();    
	                }   
	            catch(Exception ee)   
	                {   
	                }   
	            if(介绍人信息表.containsKey(number))             
	                {   
	                  String question="该介绍人信息已存在,您想修改他(她)的基本信息吗?";   
	                     
	                  JOptionPane.showMessageDialog(this,question,"警告",JOptionPane.QUESTION_MESSAGE);   
	                      
	                  String m="介绍人信息将被修改!";   
	                  int ok=JOptionPane.showConfirmDialog(this,m,"确认",JOptionPane.YES_NO_OPTION,   
	                                                 JOptionPane.INFORMATION_MESSAGE);   
	                  if(ok==JOptionPane.YES_OPTION)   
	                    {   
	                	  String name=介绍人姓名.getText();   
		                  String phone=电话.getText();     
	                      String sex=null;   
	                        if(男.isSelected())   
	                           {   
	                             sex=男.getText();   
	                           }   
	                        else   
	                           {   
	                             sex=女.getText();   
	                           }   
	                     Introducer  介绍人=new Introducer();   
	                     介绍人.setIdnumber(number);
	                     介绍人.setIdname(name);   
	                     介绍人.setphone(phone);     
	                     介绍人.setsex(sex);  
	                     try   
	                      {   
	                       outOne=new FileOutputStream(file);   
	                       outTwo=new ObjectOutputStream(outOne);   
	                       介绍人信息表.put(number,介绍人);   
	                       outTwo.writeObject(介绍人信息表);   
	                       outTwo.close();   
	                       outOne.close();   
	                       介绍人编号.setText(null);   
                           介绍人姓名.setText(null);                                   
                           电话.setText(null);      
	                      }   
	                     catch(Exception ee)   
	                      {    
	                       System.out.println(ee);   
	                      }   
	                     录入修改.setEnabled(false);    
	                   }   
	                 else if(ok==JOptionPane.NO_OPTION)   
	                   {   
	                     录入修改.setEnabled(true);   
	                   }   
	               }   
	             else   
	               {   
	                   
	                 String warning="该介绍人编号没有介绍人信息,不能修改!";   
	                 JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	                 录入修改.setEnabled(false);    
	               }   
	           }   
	        else   
	           {   
	              String warning="必须要输入介绍人编号!";   
	              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	              录入修改.setEnabled(false);   
	           }   
	       }   
	   if(e.getSource()==重置)   
	      {    
		   介绍人编号.setText(null);   
           介绍人姓名.setText(null);                                   
           电话.setText(null);    
	      }   
	  }   
	}   

