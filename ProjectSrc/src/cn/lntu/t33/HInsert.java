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

public class HInsert extends JPanel implements ActionListener   
{    
	  Hashtable 求职者信息表=null;                              
	  JTextField 求职者号,求职者姓名,攻读专业,是否聘用,月薪要求;                    
	  JRadioButton 男,女;   
	  Jobhunter  求职者=null;   
	  ButtonGroup group=null;   
	  JButton 录入,重置;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public HInsert(File file)   
	  {   
	     
	   this.file=file;   
	   求职者号=new JTextField(10);   
	   求职者姓名=new JTextField(10);   
	   攻读专业=new JTextField(10);   
	   是否聘用=new JTextField(10);   
	   月薪要求=new JTextField(10);   
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
	   box1.add(new JLabel("求职者编号:",JLabel.CENTER));   
	   box1.add(求职者号);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("求职者姓名:",JLabel.CENTER));   
	   box2.add(求职者姓名);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("性别:",JLabel.CENTER));   
	   box3.add(男);   
	   box3.add(女);   
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("攻读专业:",JLabel.CENTER));   
	   box4.add(攻读专业);   
	   Box box5=Box.createHorizontalBox();                 
	   box5.add(new JLabel("是否聘用:",JLabel.CENTER));   
	   box5.add(是否聘用);   
	   Box box6=Box.createHorizontalBox();                 
	   box6.add(new JLabel("月薪要求/月:",JLabel.CENTER));   
	   box6.add(月薪要求);   
	   Box boxH=Box.createVerticalBox();                 
	   boxH.add(box1);   
	   boxH.add(box2);   
	   boxH.add(box3);   
	   boxH.add(box4);   
	   boxH.add(box5);   
	   boxH.add(box6);   
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
	        number=求职者号.getText();   
	           
	         if(number.length()>0)   
	            {   
	              try {   
	                    inOne=new FileInputStream(file);   
	                    inTwo=new ObjectInputStream(inOne);   
	                    求职者信息表=(Hashtable)inTwo.readObject();   
	                    inOne.close();   
	                    inTwo.close();   
	                  }   
	               catch(Exception ee)   
	                   {   
	                   }   
	              if(求职者信息表.containsKey(number))             
	                 {   
	                   String warning="该求职者信息已存在,请到修改页面修改!";   
	                       
	                   JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	                 }   
	              else   
	                 {     
	                   String m="求职者信息将被录入!";   
	                   int ok=JOptionPane.showConfirmDialog(this,m,"确认",JOptionPane.YES_NO_OPTION,   
	                                                 JOptionPane.INFORMATION_MESSAGE);   
	                  if(ok==JOptionPane.YES_OPTION)   
	                    {   
	                     String name=求职者姓名.getText();   
	                     String gdzy=攻读专业.getText();   
	                     String sfpy=是否聘用.getText();   
	                     String yxyq=月薪要求.getText();   
	                     String sex=null;   
	                        if(男.isSelected())   
	                           {   
	                             sex=男.getText();   
	                           }   
	                        else   
	                           {   
	                             sex=女.getText();   
	                           }   
	                     求职者=new Jobhunter();   
	                     求职者.setjhnumber(number);
	                     求职者.setjhname(name);   
	                     求职者.setgdzy(gdzy);   
	                     求职者.setsfpy(sfpy);   
	                     求职者.setyxyq(yxyq);   
	                     求职者.setsex(sex);   
	                       try{   
	                           outOne=new FileOutputStream(file);   
	                           outTwo=new ObjectOutputStream(outOne);   
	                           求职者信息表.put(number,求职者);   
	                           outTwo.writeObject(求职者信息表);   
	                           outTwo.close();   
	                           outOne.close();   
	                           求职者号.setText(null);   
	                           求职者姓名.setText(null);                                   
	                           攻读专业.setText(null);   
	                           是否聘用.setText(null);   
	                           月薪要求.setText(null);   
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
	              String warning="必须要输入求职者号!";   
	              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);   
	            }   
	      }    
	    if(e.getSource()==重置)   
	      {    
	        求职者号.setText(null);   
	        求职者姓名.setText(null);   
	        攻读专业.setText(null);   
	        是否聘用.setText(null);   
	        月薪要求.setText(null);   
	           
	      }   
	  }   
	}   