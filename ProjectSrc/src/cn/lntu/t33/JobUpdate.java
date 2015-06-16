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
	  Hashtable ְҵ��Ϣ��=null;                              
	  JTextField ְҵ��,ְҵ����,ְҵ���ͺ�,ְҵ��������,��λ��,��λ����,רҵҪ��,��Ƹ����,��������,����;                    ;   
	  JButton ��ʼ�޸�,¼���޸�,����;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public JobUpdate(File file)   
	  {  
	   this.file=file;   
	   ְҵ��=new JTextField(10);   
	   ְҵ����=new JTextField(10);   
	   ְҵ���ͺ�=new JTextField(10);   
	   ְҵ��������=new JTextField(10);   
	   ��λ��=new JTextField(10); 
	   ��λ����=new JTextField(10);   
	   רҵҪ��=new JTextField(10);   
	   ��Ƹ����=new JTextField(10);   
	   ��������=new JTextField(10);   
	   ����=new JTextField(10);
	   
	   ��ʼ�޸�=new JButton("��ʼ�޸�");   
	   ¼���޸�=new JButton("¼���޸�");   
	   ¼���޸�.setEnabled(false);   
	   ����=new JButton("����");   
	   ְҵ��.addActionListener(this);   
	   ��ʼ�޸�.addActionListener(this);   
	   ¼���޸�.addActionListener(this);   
	   ����.addActionListener(this);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("����Ҫ�޸���Ϣ��ְҵ��:",JLabel.CENTER));   
	   box1.add(ְҵ��);   
	   box1.add(��ʼ�޸�);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("(��)ְҵ����:",JLabel.CENTER));   
	   box2.add(ְҵ����);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("(��)ְҵ���ͺ�:",JLabel.CENTER));   
	   box3.add(ְҵ���ͺ�);    
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("(��)ְҵ��������:",JLabel.CENTER));   
	   box4.add(ְҵ��������);   
	   Box box5=Box.createHorizontalBox();                 
	   box5.add(new JLabel("(��)��λ��:",JLabel.CENTER));   
	   box5.add(��λ��);   
	   Box box6=Box.createHorizontalBox();                 
	   box6.add(new JLabel("(��)��λ����:",JLabel.CENTER));   
	   box6.add(��λ����);   
	   Box box7=Box.createHorizontalBox();                 
	   box7.add(new JLabel("(��)רҵҪ��:",JLabel.CENTER));   
	   box7.add(רҵҪ��);   
	   Box box8=Box.createHorizontalBox();                 
	   box8.add(new JLabel("(��)��Ƹ����:",JLabel.CENTER));   
	   box8.add(��Ƹ����);   
	   Box box9=Box.createHorizontalBox();                 
	   box9.add(new JLabel("(��)��������:",JLabel.CENTER));   
	   box9.add(��������);
	   Box box10=Box.createHorizontalBox();                 
	   box10.add(new JLabel("(��)����/��:",JLabel.CENTER));   
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
	   setLayout(new BorderLayout());   
	   add(pCenter,BorderLayout.CENTER);   
	   JPanel pSouth=new JPanel();   
	   pSouth.add(¼���޸�);   
	   pSouth.add(����); 
	   ְҵ��.setText(null);   
       ְҵ����.setText(null);                                   
       ְҵ���ͺ�.setText(null);   
       ְҵ��������.setText(null);   
       ��λ��.setText(null);
       ��λ����.setText(null);                                   
       רҵҪ��.setText(null);   
       ��Ƹ����.setText(null);   
       ��������.setText(null); 
       ����.setText(null); 
	   add(pSouth,BorderLayout.SOUTH);   
	   validate();   
	  }   
	 public void actionPerformed(ActionEvent e)   
	 {    
	   if(e.getSource()==��ʼ�޸�||e.getSource()==ְҵ��)   
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
	                   ¼���޸�.setEnabled(true);   
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
	                  ¼���޸�.setEnabled(false);   
	                     
	                  String warning="��ְҵ�Ų�����!";   
	                  JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	                  ְҵ��.setText(null);   
                      ְҵ����.setText(null);                                   
                      ְҵ���ͺ�.setText(null);   
                      ְҵ��������.setText(null);   
                      ��λ��.setText(null);
                      ��λ����.setText(null);                                   
                      רҵҪ��.setText(null);   
                      ��Ƹ����.setText(null);   
                      ��������.setText(null); 
                      ����.setText(null); 
	   
	                 }   
	            }   
	        else   
	            {    
	              ¼���޸�.setEnabled(false);    
	                 
	              String warning="����Ҫ����ְҵ��!";   
	              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	              ְҵ��.setText(null);   
                ְҵ����.setText(null);                                   
                ְҵ���ͺ�.setText(null);   
                ְҵ��������.setText(null);   
                ��λ��.setText(null);
                ��λ����.setText(null);                                   
                רҵҪ��.setText(null);   
                ��Ƹ����.setText(null);   
                ��������.setText(null); 
                ����.setText(null);   
	            }   
	      }    
	  else if(e.getSource()==¼���޸�)   
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
	                  String question="��ְҵ��Ϣ�Ѵ���,�����޸����Ļ�����Ϣ��?";   
	                     
	                  JOptionPane.showMessageDialog(this,question,"����",JOptionPane.QUESTION_MESSAGE);   
	                      
	                  String m="ְҵ��Ϣ�����޸�!";   
	                  int ok=JOptionPane.showConfirmDialog(this,m,"ȷ��",JOptionPane.YES_NO_OPTION,   
	                                                 JOptionPane.INFORMATION_MESSAGE);   
	                  if(ok==JOptionPane.YES_OPTION)   
	                    {   
	                      String zyname=ְҵ����.getText();   
		                  String zylxnumber=ְҵ���ͺ�.getText();   
		                  String zylxname=ְҵ��������.getText();   
		                  String dwnumber=��λ��.getText(); 
		                  String dwname=��λ����.getText();   
		                  String zyyq=רҵҪ��.getText();   
		                  String yprs=��Ƹ����.getText();
		                  String xqrs=��������.getText();   
		                  String gz=����.getText(); 
	                           
	                     JobInformation  ְҵ=new JobInformation();   
	                     ְҵ.setzynumber(number);   
	                     ְҵ.setzyame(zyname); 
	                     ְҵ.setzylxnumber(zylxnumber);
	                     ְҵ.setzylxname(zylxname);
	                     ְҵ.setdwnumber(dwnumber);
	                     ְҵ.setdwname(dwname);
	                     ְҵ.setzyyq(zyyq);
	                     ְҵ.setzyprs(yprs);
	                     ְҵ.setxqrs(xqrs);
	                     ְҵ.setgz(gz);   
	                     try   
	                      {   
	                       outOne=new FileOutputStream(file);   
	                       outTwo=new ObjectOutputStream(outOne);   
	                       ְҵ��Ϣ��.put(number,ְҵ);   
	                       outTwo.writeObject(ְҵ��Ϣ��);   
	                       outTwo.close();   
	                       outOne.close();   
	                       ְҵ��.setText(null);   
	                       ְҵ����.setText(null);                                   
	                       ְҵ���ͺ�.setText(null);   
	                       ְҵ��������.setText(null);   
	                       ��λ��.setText(null);
	                       ��λ����.setText(null);                                   
	                       רҵҪ��.setText(null);   
	                       ��Ƹ����.setText(null);   
	                       ��������.setText(null); 
	                       ����.setText(null);   
	                      }   
	                     catch(Exception ee)   
	                      {    
	                       System.out.println(ee);   
	                      }   
	                     ¼���޸�.setEnabled(false);    
	                   }   
	                 else if(ok==JOptionPane.NO_OPTION)   
	                   {   
	                     ¼���޸�.setEnabled(true);   
	                   }   
	               }   
	             else   
	               {   
	                   
	                 String warning="��ְҵ��û��ְҵ��Ϣ,�����޸�!";   
	                 JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	                 ¼���޸�.setEnabled(false);    
	               }   
	           }   
	        else   
	           {   
	              String warning="����Ҫ����ְҵ��!";   
	              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	              ¼���޸�.setEnabled(false);   
	           }   
	       }   
	   if(e.getSource()==����)   
	      {    
		   ְҵ��.setText(null);   
         ְҵ����.setText(null);                                   
         ְҵ���ͺ�.setText(null);   
         ְҵ��������.setText(null);   
         ��λ��.setText(null);
         ��λ����.setText(null);                                   
         רҵҪ��.setText(null);   
         ��Ƹ����.setText(null);   
         ��������.setText(null); 
         ����.setText(null);   
	      }   
	  }   
	}  

