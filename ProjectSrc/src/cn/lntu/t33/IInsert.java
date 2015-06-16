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
	  Hashtable 介绍人信息表=null;                              
	  JTextField 介绍人编号,介绍人姓名,电话;                    
	  JRadioButton 男,女;   
	  Introducer  介绍人=null;   
	  ButtonGroup group=null;   
	  JButton 录入,重置;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public IInsert(File file)   
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
	   录入=new JButton("录入");   
	   重置=new JButton("重置");   
	   录入.addActionListener(this);   
	   重置.addActionListener(this);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("介绍人编号:",JLabel.CENTER));   
	   box1.add(介绍人编号);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("介绍人姓名:",JLabel.CENTER));   
	   box2.add(介绍人姓名);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("性别:",JLabel.CENTER));   
	   box3.add(男);   
	   box3.add(女);   
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("电话:",JLabel.CENTER));   
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
	   pSouth.add(录入);   
	   pSouth.add(重置);   
	   add(pSouth,BorderLayout.SOUTH);   
	   validate();   
	  }   
	 public void actionPerformed(ActionEvent e)   
	  {   
	    if(e.getSource()==录入)   
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
	                   String warning="该介绍人信息已存在,请到修改页面修改!";   
	                       
	                   JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	                 }   
	              else   
	                 {     
	                   String m="介绍人信息将被录入!";   
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
	                     介绍人= new Introducer();   
	                     介绍人.setIdnumber(number);
	                     介绍人.setIdname(name);   
	                     介绍人.setphone(phone);      
	                     介绍人.setsex(sex);   
	                       try{   
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
	                      
	                   }   
	                }    
	            }   
	        else   
	            {    
	              String warning="必须要输入介绍人编号!";   
	              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
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
