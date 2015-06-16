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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JobUpdate extends JPanel implements ActionListener   
{    
	  Hashtable 职业信息表=null;                              
	  JTextField 职业号,职业名称,职业类型号,职业类型名称,单位号,单位名称,专业要求,已聘人数,需求人数,工资;                    ;   
	  JButton 开始修改,录入修改,重置;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public JobUpdate(File file)   
	  {  
	   this.file=file;   
	   职业号=new JTextField(10);   
	   职业名称=new JTextField(10);   
	   职业类型号=new JTextField(10);   
	   职业类型名称=new JTextField(10);   
	   单位号=new JTextField(10); 
	   单位名称=new JTextField(10);   
	   专业要求=new JTextField(10);   
	   已聘人数=new JTextField(10);   
	   需求人数=new JTextField(10);   
	   工资=new JTextField(10);
	   
	   开始修改=new JButton("开始修改");   
	   录入修改=new JButton("录入修改");   
	   录入修改.setEnabled(false);   
	   重置=new JButton("重置");   
	   职业号.addActionListener(this);   
	   开始修改.addActionListener(this);   
	   录入修改.addActionListener(this);   
	   重置.addActionListener(this);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("输入要修改信息的职业号:",JLabel.CENTER));   
	   box1.add(职业号);   
	   box1.add(开始修改);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("(新)职业名称:",JLabel.CENTER));   
	   box2.add(职业名称);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("(新)职业类型号:",JLabel.CENTER));   
	   box3.add(职业类型号);    
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("(新)职业类型名称:",JLabel.CENTER));   
	   box4.add(职业类型名称);   
	   Box box5=Box.createHorizontalBox();                 
	   box5.add(new JLabel("(新)单位号:",JLabel.CENTER));   
	   box5.add(单位号);   
	   Box box6=Box.createHorizontalBox();                 
	   box6.add(new JLabel("(新)单位名称:",JLabel.CENTER));   
	   box6.add(单位名称);   
	   Box box7=Box.createHorizontalBox();                 
	   box7.add(new JLabel("(新)专业要求:",JLabel.CENTER));   
	   box7.add(专业要求);   
	   Box box8=Box.createHorizontalBox();                 
	   box8.add(new JLabel("(新)已聘人数:",JLabel.CENTER));   
	   box8.add(已聘人数);   
	   Box box9=Box.createHorizontalBox();                 
	   box9.add(new JLabel("(新)需求人数:",JLabel.CENTER));   
	   box9.add(需求人数);
	   Box box10=Box.createHorizontalBox();                 
	   box10.add(new JLabel("(新)工资/月:",JLabel.CENTER));   
	   box10.add(工资);
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
	   setLayout(new BorderLayout());   
	   add(pCenter,BorderLayout.CENTER);   
	   JPanel pSouth=new JPanel();   
	   pSouth.add(录入修改);   
	   pSouth.add(重置); 
	   职业号.setText(null);   
       职业名称.setText(null);                                   
       职业类型号.setText(null);   
       职业类型名称.setText(null);   
       单位号.setText(null);
       单位名称.setText(null);                                   
       专业要求.setText(null);   
       已聘人数.setText(null);   
       需求人数.setText(null); 
       工资.setText(null); 
	   add(pSouth,BorderLayout.SOUTH);   
	   validate();   
	  }   
	 public void actionPerformed(ActionEvent e)   
	 {    
	   if(e.getSource()==开始修改||e.getSource()==职业号)   
	      {   
	         String number="";   
	        number=职业号.getText();   
	           
	         if(number.length()>0)   
	            {   
	              try {   
	                    inOne=new FileInputStream(file);   
	                    inTwo=new ObjectInputStream(inOne);   
	                    职业信息表=(Hashtable)inTwo.readObject();   
	                    inOne.close();   
	                    inTwo.close();   
	                  }   
	               catch(Exception ee)   
	                   {   
	                   }   
	              if(职业信息表.containsKey(number))             
	                 {   
	                   录入修改.setEnabled(true);   
	                   JobInformation stu=(JobInformation)职业信息表.get(number);   
	                   职业名称.setText(stu.getzyname());   
	                   职业类型号.setText(stu.getzylxnumber());   
	                   职业类型名称.setText(stu.getzylxname());   
	                   单位号.setText(stu.getdwnumber());  
	                   单位名称.setText(stu.getdwname());   
	                   专业要求.setText(stu.getzyyq());   
	                   已聘人数.setText(stu.getyprs());   
	                   需求人数.setText(stu.getxqrs());
	                   工资.setText(stu.getgz()); 
	                      
	                 }    
	              else   
	                 {    
	                  录入修改.setEnabled(false);   
	                     
	                  String warning="该职业号不存在!";   
	                  JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	                  职业号.setText(null);   
                      职业名称.setText(null);                                   
                      职业类型号.setText(null);   
                      职业类型名称.setText(null);   
                      单位号.setText(null);
                      单位名称.setText(null);                                   
                      专业要求.setText(null);   
                      已聘人数.setText(null);   
                      需求人数.setText(null); 
                      工资.setText(null); 
	   
	                 }   
	            }   
	        else   
	            {    
	              录入修改.setEnabled(false);    
	                 
	              String warning="必须要输入职业号!";   
	              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	              职业号.setText(null);   
                职业名称.setText(null);                                   
                职业类型号.setText(null);   
                职业类型名称.setText(null);   
                单位号.setText(null);
                单位名称.setText(null);                                   
                专业要求.setText(null);   
                已聘人数.setText(null);   
                需求人数.setText(null); 
                工资.setText(null);   
	            }   
	      }    
	  else if(e.getSource()==录入修改)   
	      {     
	        String number="";   
	        number=职业号.getText();   
	        if(number.length()>0)   
	           {   
	            try {   
	                 inOne=new FileInputStream(file);   
	                 inTwo=new ObjectInputStream(inOne);   
	                 职业信息表=(Hashtable)inTwo.readObject();   
	                 inOne.close();   
	                 inTwo.close();    
	                }   
	            catch(Exception ee)   
	                {   
	                }   
	            if(职业信息表.containsKey(number))             
	                {   
	                  String question="该职业信息已存在,您想修改它的基本信息吗?";   
	                     
	                  JOptionPane.showMessageDialog(this,question,"警告",JOptionPane.QUESTION_MESSAGE);   
	                      
	                  String m="职业信息将被修改!";   
	                  int ok=JOptionPane.showConfirmDialog(this,m,"确认",JOptionPane.YES_NO_OPTION,   
	                                                 JOptionPane.INFORMATION_MESSAGE);   
	                  if(ok==JOptionPane.YES_OPTION)   
	                    {   
	                      String zyname=职业名称.getText();   
		                  String zylxnumber=职业类型号.getText();   
		                  String zylxname=职业类型名称.getText();   
		                  String dwnumber=单位号.getText(); 
		                  String dwname=单位名称.getText();   
		                  String zyyq=专业要求.getText();   
		                  String yprs=已聘人数.getText();
		                  String xqrs=需求人数.getText();   
		                  String gz=工资.getText(); 
	                           
	                     JobInformation  职业=new JobInformation();   
	                     职业.setzynumber(number);   
	                     职业.setzyame(zyname); 
	                     职业.setzylxnumber(zylxnumber);
	                     职业.setzylxname(zylxname);
	                     职业.setdwnumber(dwnumber);
	                     职业.setdwname(dwname);
	                     职业.setzyyq(zyyq);
	                     职业.setzyprs(yprs);
	                     职业.setxqrs(xqrs);
	                     职业.setgz(gz);   
	                     try   
	                      {   
	                       outOne=new FileOutputStream(file);   
	                       outTwo=new ObjectOutputStream(outOne);   
	                       职业信息表.put(number,职业);   
	                       outTwo.writeObject(职业信息表);   
	                       outTwo.close();   
	                       outOne.close();   
	                       职业号.setText(null);   
	                       职业名称.setText(null);                                   
	                       职业类型号.setText(null);   
	                       职业类型名称.setText(null);   
	                       单位号.setText(null);
	                       单位名称.setText(null);                                   
	                       专业要求.setText(null);   
	                       已聘人数.setText(null);   
	                       需求人数.setText(null); 
	                       工资.setText(null);   
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
	                   
	                 String warning="该职业号没有职业信息,不能修改!";   
	                 JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	                 录入修改.setEnabled(false);    
	               }   
	           }   
	        else   
	           {   
	              String warning="必须要输入职业号!";   
	              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	              录入修改.setEnabled(false);   
	           }   
	       }   
	   if(e.getSource()==重置)   
	      {    
		   职业号.setText(null);   
         职业名称.setText(null);                                   
         职业类型号.setText(null);   
         职业类型名称.setText(null);   
         单位号.setText(null);
         单位名称.setText(null);                                   
         专业要求.setText(null);   
         已聘人数.setText(null);   
         需求人数.setText(null); 
         工资.setText(null);   
	      }   
	  }   
	}  

