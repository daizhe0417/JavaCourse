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
	  Hashtable 介绍人信息表=null;                              
	  JTextField 介绍人编号,介绍人姓名,电话;                     
	  JRadioButton 男,女;   
	  JButton 删除;   
	  ButtonGroup group=null;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public IDelete(File file)   
	  {   
	   this.file=file;   
	   介绍人编号=new JTextField(10);   
	   删除=new JButton("删除");   
	   介绍人编号.addActionListener(this);   
	   删除.addActionListener(this);   
	   介绍人姓名=new JTextField(10);   
	   介绍人姓名.setEditable(false);   
	   电话=new JTextField(10);   
	   电话.setEditable(false);     
	   男=new JRadioButton("男",false);   
	   女=new JRadioButton("女",false);   
	   group=new ButtonGroup();   
	   group.add(男);   
	   group.add(女);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("输入要删除的介绍人编号:",JLabel.CENTER));   
	   box1.add(介绍人编号);   
	   box1.add(删除);   
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
	   validate();   
	  }   
	 public void actionPerformed(ActionEvent e)   
	  {   
	    if(e.getSource()==删除||e.getSource()==介绍人编号)   
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
	                  String m="确定要删除该介绍人及全部信息吗?";   
	                  int ok=JOptionPane.showConfirmDialog(this,m,"确认",JOptionPane.YES_NO_OPTION,   
	                                                 JOptionPane.QUESTION_MESSAGE);   
	                  if(ok==JOptionPane.YES_OPTION)   
	                     {   
	                       介绍人信息表.remove(number);   
	                       try   
	                        {   
	                          outOne=new FileOutputStream(file);   
	                          outTwo=new ObjectOutputStream(outOne);   
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
	                   else if(ok==JOptionPane.NO_OPTION)   
	                     {   
	                	   介绍人编号.setText(null);   
	    	               介绍人姓名.setText(null);   
	    	           	   电话.setText(null);    
	                     }   
	                 }   
	              else   
	                 {    
	                  String warning="该介绍人编号不存在!";   
	                  JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	                 }   
	            }   
	        else   
	            {    
	              String warning="必须要输入介绍人编号!";   
	              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	            }   
	      }    
	  }   
	} 
