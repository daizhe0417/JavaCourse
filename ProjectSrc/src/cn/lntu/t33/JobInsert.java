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


public class JobInsert extends JPanel implements ActionListener   
{    
	  Hashtable 职业信息表=null;                              
	  JTextField 职业号,职业名称,职业类型号,职业类型名称,单位号,单位名称,专业要求,已聘人数,需求人数,工资;                      
	  JobInformation 职业=null;      
	  JButton 录入,重置;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public JobInsert(File file)   
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
	   录入=new JButton("录入");   
	   重置=new JButton("重置");   
	   录入.addActionListener(this);   
	   重置.addActionListener(this);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("职业号:",JLabel.CENTER));   
	   box1.add(职业号);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("职业名称:",JLabel.CENTER));   
	   box2.add(职业名称);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("职业类型号:",JLabel.CENTER));  
	   box3.add(职业类型号);  
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("职业类型名称:",JLabel.CENTER));   
	   box4.add(职业类型名称);   
	   Box box5=Box.createHorizontalBox();                 
	   box5.add(new JLabel("单位号:",JLabel.CENTER));   
	   box5.add(单位号);   
	   Box box6=Box.createHorizontalBox();                 
	   box6.add(new JLabel("单位名称:",JLabel.CENTER));   
	   box6.add(单位名称);  
	   Box box7=Box.createHorizontalBox();                 
	   box7.add(new JLabel("专业要求:",JLabel.CENTER));   
	   box7.add(专业要求);   
	   Box box8=Box.createHorizontalBox();                 
	   box8.add(new JLabel("已聘人数:",JLabel.CENTER));   
	   box8.add(已聘人数);   
	   Box box9=Box.createHorizontalBox();                 
	   box9.add(new JLabel("需求人数:",JLabel.CENTER));   
	   box9.add(需求人数); 
	   Box box10=Box.createHorizontalBox();                 
	   box10.add(new JLabel("工资/月:",JLabel.CENTER));   
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
	                   String warning="该职业基本信息已存在,请到修改页面修改!";   
	                       
	                   JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	                 }   
	              else   
	                 {     
	                   String m="基本信息将被录入!";   
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
	                     
	                     职业=new JobInformation();   
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
	                        
	                       try{   
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
	                      
	                   }   
	                }    
	            }   
	        else   
	            {    
	              String warning="必须要输入职业号!";   
	              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
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

