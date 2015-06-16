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
	   JobInsert   ְҵ��Ϣ¼��=null;             
	   JobUpdate   ְҵ��Ϣ�޸�=null;             
	   JobSelect   ְҵ��Ϣ��ѯ=null;    
	   JobDelete   ְҵ��Ϣɾ��=null;
	   HInsert   ��ְ����Ϣ¼��=null;             
	   HUpdate   ��ְ����Ϣ�޸�=null;             
	   HSelect   ��ְ����Ϣ��ѯ=null;    
	   HDelete   ��ְ����Ϣɾ��=null;
	   IInsert   ��������Ϣ¼��=null;             
	   IUpdate   ��������Ϣ�޸�=null;             
	   ISelect   ��������Ϣ��ѯ=null;    
	   IDelete   ��������Ϣɾ��=null;
	   JMenuBar bar; 
	   JMenu fileMenu;
	   JMenu fileMenu1;
	   JMenu fileMenu2;
	   JMenuItem ¼��,�޸�,��ѯ,ɾ��; 
	   JMenuItem ¼��1,�޸�1,��ѯ1,ɾ��1; 
	   JMenuItem ¼��2,�޸�2,��ѯ2,ɾ��2;
	   Container con=null;  
	   Hashtable ְҵ��Ϣ=null; 
	   Hashtable ��ְ����Ϣ=null;
	   Hashtable ��������Ϣ=null;
	   File file=null; 
	   File file1=null;
	   File file2=null;
	   CardLayout card=null; 
	   JLabel label=null;
	   JPanel pCenter;  
	   public Manager()   
	   {   
	     ¼��=new JMenuItem("¼��ְҵ��Ϣ");   
	     �޸�=new JMenuItem("�޸�ְҵ��Ϣ");   
	     ��ѯ=new JMenuItem("��ѯְҵ��Ϣ");   
	     ɾ��=new JMenuItem("ɾ��ְҵ��Ϣ"); 
	     ¼��1=new JMenuItem("¼����ְ����Ϣ");   
	     �޸�1=new JMenuItem("�޸���ְ����Ϣ");   
	     ��ѯ1=new JMenuItem("��ѯ��ְ����Ϣ");   
	     ɾ��1=new JMenuItem("ɾ����ְ����Ϣ");
	     ¼��2=new JMenuItem("¼���������Ϣ");   
	     �޸�2=new JMenuItem("�޸Ľ�������Ϣ");   
	     ��ѯ2=new JMenuItem("��ѯ��������Ϣ");   
	     ɾ��2=new JMenuItem("ɾ����������Ϣ");
	     bar=new JMenuBar();  
	     fileMenu=new JMenu("ְҵ��Ϣ"); 
	     fileMenu1 = new JMenu("��ְ����Ϣ");
	     fileMenu2 = new JMenu("��������Ϣ");
	     fileMenu.add(¼��);   
	     fileMenu.add(�޸�);   
	     fileMenu.add(��ѯ);   
	     fileMenu.add(ɾ��);  
	     fileMenu1.add(¼��1);   
	     fileMenu1.add(�޸�1);   
	     fileMenu1.add(��ѯ1);   
	     fileMenu1.add(ɾ��1);
	     fileMenu2.add(¼��2);   
	     fileMenu2.add(�޸�2);   
	     fileMenu2.add(��ѯ2);   
	     fileMenu2.add(ɾ��2);
	     bar.add(fileMenu); 
	     setJMenuBar(bar);
	     bar.add(fileMenu1); 
	     setJMenuBar(bar);
	     bar.add(fileMenu2); 
	     setJMenuBar(bar);
	     label=new JLabel("Welcome to use the job management system",JLabel.CENTER);   
	     label.setFont(new Font("TimesRoman",Font.BOLD,24));   
	     label.setForeground(Color.red); 
	     ְҵ��Ϣ=new Hashtable();
	     ��ְ����Ϣ=new Hashtable(); 
	     ��������Ϣ=new Hashtable();
	     ¼��.addActionListener(this);   
	     �޸�.addActionListener(this);   
	     ��ѯ.addActionListener(this);   
	     ɾ��.addActionListener(this); 
	     ¼��1.addActionListener(this);   
	     �޸�1.addActionListener(this);   
	     ��ѯ1.addActionListener(this);   
	     ɾ��1.addActionListener(this);
	     ¼��2.addActionListener(this);   
	     �޸�2.addActionListener(this);   
	     ��ѯ2.addActionListener(this);   
	     ɾ��2.addActionListener(this);
	     card=new CardLayout();   
	     con=getContentPane();
	     //con1=getContentPane(); 
	     pCenter=new JPanel(); 
	     pCenter.setLayout(card);  
	     file=new File("ְҵ��Ϣ.txt");   
	     file1=new File("��ְ����Ϣ.txt");
	     file2=new File("��������Ϣ.txt");
	     if(!file.exists())   
	      {   
	       try{   
	           FileOutputStream out=new FileOutputStream(file);   
	           ObjectOutputStream objectOut=new ObjectOutputStream(out);   
	           objectOut.writeObject(ְҵ��Ϣ);   
	           objectOut.close();   
	           out.close();   
	          }   
	       catch(IOException e)   
	          {   
	          }   
	      }    
	     ְҵ��Ϣ¼��=new JobInsert(file);   
	     ְҵ��Ϣ�޸�=new JobUpdate(file);   
	     ְҵ��Ϣ��ѯ=new JobSelect(this,file);  
	     ְҵ��Ϣɾ��=new JobDelete(file);   
	     pCenter.add("��ӭ�����",label);   
	     pCenter.add("¼�����",ְҵ��Ϣ¼��);   
	     pCenter.add("�޸Ľ���",ְҵ��Ϣ�޸�);       
	     pCenter.add("ɾ������",ְҵ��Ϣɾ��);   
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
	           objectOut.writeObject(��ְ����Ϣ);   
	           objectOut.close();   
	           out.close();   
	          }   
	       catch(IOException e)   
	          {   
	          }   
	      }    
	     ��ְ����Ϣ¼��=new HInsert(file1);   
	     ��ְ����Ϣ�޸�=new HUpdate(file1);   
	     ��ְ����Ϣ��ѯ=new HSelect(this,file1);  
	     ��ְ����Ϣɾ��=new HDelete(file1);   
	     //pCenter.add("��ӭ�����",label);   
	     pCenter.add("¼�����1",��ְ����Ϣ¼��);   
	   	 pCenter.add("�޸Ľ���1",��ְ����Ϣ�޸�);       
	     pCenter.add("ɾ������1",��ְ����Ϣɾ��);
	     if(!file2.exists())          //*************
	      {   
	       try{   
	           FileOutputStream out=new FileOutputStream(file2 );   
	           ObjectOutputStream objectOut=new ObjectOutputStream(out);   
	           objectOut.writeObject(��������Ϣ);   
	           objectOut.close();   
	           out.close();   
	          }   
	       catch(IOException e)   
	          {   
	          }   
	      }    
	     ��������Ϣ¼��=new IInsert(file2);   
	     ��������Ϣ�޸�=new IUpdate(file2);   
	     ��������Ϣ��ѯ=new ISelect(this,file2);  
	     ��������Ϣɾ��=new IDelete(file2);   
	     //pCenter.add("��ӭ�����",label);   
	     pCenter.add("¼�����2",��������Ϣ¼��);   
	   	 pCenter.add("�޸Ľ���2",��������Ϣ�޸�);       
	     pCenter.add("ɾ������2",��������Ϣɾ��);
	
	   }   
	    
	  public void actionPerformed(ActionEvent e)   
	   {   
	     if(e.getSource()==¼��)   
	       {  
	         card.show(pCenter,"¼�����");   
	       }   
	     else if(e.getSource()==�޸�)   
	       {   
	         card.show(pCenter,"�޸Ľ���");   
	       }   
	     else if(e.getSource()==��ѯ)   
	      {   
	         ְҵ��Ϣ��ѯ.setVisible(true);   
	      }   
	     else if(e.getSource()==ɾ��)   
	      {   
	         card.show(pCenter,"ɾ������");   
	      }  
	     else if(e.getSource()==¼��1)   
	       {   
	         card.show(pCenter,"¼�����1");
	         System.out.println("dddd");
	       }   
	     else if(e.getSource()==�޸�1)   
	       {   
	         card.show(pCenter,"�޸Ľ���1");   
	       }   
	     else if(e.getSource()==��ѯ1)   
	      {   
	         ��ְ����Ϣ��ѯ.setVisible(true);   
	      }   
	     else if(e.getSource()==ɾ��1)   
	      {   
	         card.show(pCenter,"ɾ������1");   
	      }   
	     else if(e.getSource()==¼��2)   
	       {   
	         card.show(pCenter,"¼�����2");
	       }   
	     else if(e.getSource()==�޸�2)   
	       {   
	         card.show(pCenter,"�޸Ľ���2");   
	       }   
	     else if(e.getSource()==��ѯ2)   
	      {   
	         ��������Ϣ��ѯ.setVisible(true);   
	      }   
	     else if(e.getSource()==ɾ��2)   
	      {   
	         card.show(pCenter,"ɾ������2");   
	      }   
	   }
	    
	  public static void main(String args[])   
	   {   
	     new Manager();   
	   }   
	}   
