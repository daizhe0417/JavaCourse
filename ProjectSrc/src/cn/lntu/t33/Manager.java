package cn.lntu.t33;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import cn.lntu.t33.JobDelete;
import cn.lntu.t33.JobSelect;
import cn.lntu.t33.JobUpdate;
import cn.lntu.t33.Manager;
import cn.lntu.t33.JobInsert;

public class Manager extends JFrame implements ActionListener   
{   
	   JobInsert   职业信息录入=null;             
	   JobUpdate   职业信息修改=null;             
	   JobSelect   职业信息查询=null;    
	   JobDelete   职业信息删除=null;
	   HInsert   求职者信息录入=null;             
	   HUpdate   求职者信息修改=null;             
	   HSelect   求职者信息查询=null;    
	   HDelete   求职者信息删除=null;
	   IInsert   介绍人信息录入=null;             
	   IUpdate   介绍人信息修改=null;             
	   ISelect   介绍人信息查询=null;    
	   IDelete   介绍人信息删除=null;
	   JMenuBar bar; 
	   JMenu fileMenu;
	   JMenu fileMenu1;
	   JMenu fileMenu2;
	   JMenuItem 录入,修改,查询,删除; 
	   JMenuItem 录入1,修改1,查询1,删除1; 
	   JMenuItem 录入2,修改2,查询2,删除2;
	   Container con=null;  
	   Hashtable 职业信息=null; 
	   Hashtable 求职者信息=null;
	   Hashtable 介绍人信息=null;
	   File file=null; 
	   File file1=null;
	   File file2=null;
	   CardLayout card=null; 
	   JLabel label=null;
	   JPanel pCenter;  
	   public Manager()   
	   {   
	     录入=new JMenuItem("录入职业信息");   
	     修改=new JMenuItem("修改职业信息");   
	     查询=new JMenuItem("查询职业信息");   
	     删除=new JMenuItem("删除职业信息"); 
	     录入1=new JMenuItem("录入求职者信息");   
	     修改1=new JMenuItem("修改求职者信息");   
	     查询1=new JMenuItem("查询求职者信息");   
	     删除1=new JMenuItem("删除求职者信息");
	     录入2=new JMenuItem("录入介绍人信息");   
	     修改2=new JMenuItem("修改介绍人信息");   
	     查询2=new JMenuItem("查询介绍人信息");   
	     删除2=new JMenuItem("删除介绍人信息");
	     bar=new JMenuBar();  
	     fileMenu=new JMenu("职业信息"); 
	     fileMenu1 = new JMenu("求职者信息");
	     fileMenu2 = new JMenu("介绍人信息");
	     fileMenu.add(录入);   
	     fileMenu.add(修改);   
	     fileMenu.add(查询);   
	     fileMenu.add(删除);  
	     fileMenu1.add(录入1);   
	     fileMenu1.add(修改1);   
	     fileMenu1.add(查询1);   
	     fileMenu1.add(删除1);
	     fileMenu2.add(录入2);   
	     fileMenu2.add(修改2);   
	     fileMenu2.add(查询2);   
	     fileMenu2.add(删除2);
	     bar.add(fileMenu); 
	     setJMenuBar(bar);
	     bar.add(fileMenu1); 
	     setJMenuBar(bar);
	     bar.add(fileMenu2); 
	     setJMenuBar(bar);
	     label=new JLabel("Welcome to use the job management system",JLabel.CENTER);   
	     label.setFont(new Font("TimesRoman",Font.BOLD,24));   
	     label.setForeground(Color.red); 
	     职业信息=new Hashtable();
	     求职者信息=new Hashtable(); 
	     介绍人信息=new Hashtable();
	     录入.addActionListener(this);   
	     修改.addActionListener(this);   
	     查询.addActionListener(this);   
	     删除.addActionListener(this); 
	     录入1.addActionListener(this);   
	     修改1.addActionListener(this);   
	     查询1.addActionListener(this);   
	     删除1.addActionListener(this);
	     录入2.addActionListener(this);   
	     修改2.addActionListener(this);   
	     查询2.addActionListener(this);   
	     删除2.addActionListener(this);
	     card=new CardLayout();   
	     con=getContentPane();
	     //con1=getContentPane(); 
	     pCenter=new JPanel(); 
	     pCenter.setLayout(card);  
	     file=new File("职业信息.txt");   
	     file1=new File("求职者信息.txt");
	     file2=new File("介绍人信息.txt");
	     if(!file.exists())   
	      {   
	       try{   
	           FileOutputStream out=new FileOutputStream(file);   
	           ObjectOutputStream objectOut=new ObjectOutputStream(out);   
	           objectOut.writeObject(职业信息);   
	           objectOut.close();   
	           out.close();   
	          }   
	       catch(IOException e)   
	          {   
	          }   
	      }    
	     职业信息录入=new JobInsert(file);   
	     职业信息修改=new JobUpdate(file);   
	     职业信息查询=new JobSelect(this,file);  
	     职业信息删除=new JobDelete(file);   
	     pCenter.add("欢迎语界面",label);   
	     pCenter.add("录入界面",职业信息录入);   
	     pCenter.add("修改界面",职业信息修改);       
	     pCenter.add("删除界面",职业信息删除);   
	     con.add(pCenter,BorderLayout.CENTER);   
	     con.validate();   
	     addWindowListener(new WindowAdapter()   
	                    { public void windowClosing(WindowEvent e)   
	                       {   
	                          System.exit(0);   
	                       }   
	                    });   
	    setVisible(true);   
	    setBounds(100,300,420,380);   
	    validate();   
	    if(!file1.exists())          //*************
	      {   
	       try{   
	           FileOutputStream out=new FileOutputStream(file1 );   
	           ObjectOutputStream objectOut=new ObjectOutputStream(out);   
	           objectOut.writeObject(求职者信息);   
	           objectOut.close();   
	           out.close();   
	          }   
	       catch(IOException e)   
	          {   
	          }   
	      }    
	     求职者信息录入=new HInsert(file1);   
	     求职者信息修改=new HUpdate(file1);   
	     求职者信息查询=new HSelect(this,file1);  
	     求职者信息删除=new HDelete(file1);   
	     //pCenter.add("欢迎语界面",label);   
	     pCenter.add("录入界面1",求职者信息录入);   
	   	 pCenter.add("修改界面1",求职者信息修改);       
	     pCenter.add("删除界面1",求职者信息删除);
	     if(!file2.exists())          //*************
	      {   
	       try{   
	           FileOutputStream out=new FileOutputStream(file2 );   
	           ObjectOutputStream objectOut=new ObjectOutputStream(out);   
	           objectOut.writeObject(介绍人信息);   
	           objectOut.close();   
	           out.close();   
	          }   
	       catch(IOException e)   
	          {   
	          }   
	      }    
	     介绍人信息录入=new IInsert(file2);   
	     介绍人信息修改=new IUpdate(file2);   
	     介绍人信息查询=new ISelect(this,file2);  
	     介绍人信息删除=new IDelete(file2);   
	     //pCenter.add("欢迎语界面",label);   
	     pCenter.add("录入界面2",介绍人信息录入);   
	   	 pCenter.add("修改界面2",介绍人信息修改);       
	     pCenter.add("删除界面2",介绍人信息删除);
	
	   }   
	    
	  public void actionPerformed(ActionEvent e)   
	   {   
	     if(e.getSource()==录入)   
	       {  
	         card.show(pCenter,"录入界面");   
	       }   
	     else if(e.getSource()==修改)   
	       {   
	         card.show(pCenter,"修改界面");   
	       }   
	     else if(e.getSource()==查询)   
	      {   
	         职业信息查询.setVisible(true);   
	      }   
	     else if(e.getSource()==删除)   
	      {   
	         card.show(pCenter,"删除界面");   
	      }  
	     else if(e.getSource()==录入1)   
	       {   
	         card.show(pCenter,"录入界面1");
	         System.out.println("dddd");
	       }   
	     else if(e.getSource()==修改1)   
	       {   
	         card.show(pCenter,"修改界面1");   
	       }   
	     else if(e.getSource()==查询1)   
	      {   
	         求职者信息查询.setVisible(true);   
	      }   
	     else if(e.getSource()==删除1)   
	      {   
	         card.show(pCenter,"删除界面1");   
	      }   
	     else if(e.getSource()==录入2)   
	       {   
	         card.show(pCenter,"录入界面2");
	       }   
	     else if(e.getSource()==修改2)   
	       {   
	         card.show(pCenter,"修改界面2");   
	       }   
	     else if(e.getSource()==查询2)   
	      {   
	         介绍人信息查询.setVisible(true);   
	      }   
	     else if(e.getSource()==删除2)   
	      {   
	         card.show(pCenter,"删除界面2");   
	      }   
	   }
	    
	  public static void main(String args[])   
	   {   
	     new Manager();   
	   }   
	}   
