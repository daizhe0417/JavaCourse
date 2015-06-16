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
	  Hashtable 介绍人信息表=null;                              
	  JTextField 介绍人编号,介绍人姓名,电话;                    
	  JRadioButton 男,女;   
	  JButton 查询;   
	  ButtonGroup group=null;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  File file=null;                                              
	  public ISelect(JFrame f,File file)   
	  {   
	   super(f,"查询对话框",false);                              
	   this.file=file;   
	   介绍人编号=new JTextField(10);   
	   查询=new JButton("查询");   
	   介绍人编号.addActionListener(this);   
	   查询.addActionListener(this);   
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
	   box1.add(new JLabel("输入要查询的介绍人编号:",JLabel.CENTER));   
	   box1.add(介绍人编号);   
	   box1.add(查询);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("介绍人姓名:",JLabel.CENTER));   
	   box2.add(介绍人姓名);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("介绍人性别:",JLabel.CENTER));   
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
	     介绍人姓名.setText(null);   
	     电话.setText(null);      
	        
	    if(e.getSource()==查询||e.getSource()==介绍人编号)   
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

