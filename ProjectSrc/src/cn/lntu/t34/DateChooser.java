package cn.lntu.t34;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DateChooser extends JPanel implements ActionListener,ChangeListener
{
  int startYear=1980;        //Ĭ����С��ʾ���
  int lastYear=2050;         //Ĭ�������ʾ���
  int width=200;             //������
  int height=200;            //����߶�
  Color backGroundColor=Color.gray;    //��ɫΪ��ɫ
  //��������ɫ----------------------//
  Color palletTableColor=Color.white;   //������ɫ
  Color todayBackColor=Color.orange;    //���챳��ɫ
  Color weekFontColor=Color.blue;       //��������ɫ
  Color dateFontColor=Color.black;      //��������ɫ
  Color weekendFontColor=Color.red;     //��ĩ����ɫ
  //��������ɫ------------------------//
  Color controlLineColor=Color.pink;    //��������ɫ
  Color controlTextColor=Color.white;   //��������ǩ����ɫ
  Color rbFontColor=Color.white;        //RoundBox����ɫ
  Color rbBorderColor=Color.red;        //RoundBox�߿�ɫ
  Color rbButtonColor=Color.pink;       //RoundBox��ťɫ
  Color rbBTFontColor=Color.red;        //RoundBox��ť����ɫ
  JButton[][] daysButton=new JButton[6][7];
  DateChooser()
  {
   setLayout(new BorderLayout());
   setBorder(new LineBorder(backGroundColor,2));
   setBackground(backGroundColor);
   JPanel topYearAndMonth=createYearAndMonthPanal();
   add(topYearAndMonth,BorderLayout.NORTH);
   JPanel centerWeekAndDay=createWeekAndDayPanal();
   add(centerWeekAndDay,BorderLayout.CENTER);
      
  }
  private JPanel createYearAndMonthPanal()
  {
   Calendar c=Calendar.getInstance();
   int currentYear=c.get(Calendar.YEAR);
   int currentMonth=c.get(Calendar.MONTH)+1;
   int currentHour=c.get(Calendar.HOUR_OF_DAY);
   JPanel result=new JPanel();
   result.setLayout(new FlowLayout());
   result.setBackground(controlLineColor);
   JSpinner yearSpin=new JSpinner(new SpinnerNumberModel(currentYear,startYear,lastYear,1));
   yearSpin.setPreferredSize(new Dimension(48,20));
   yearSpin.setName("Year");
   yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin,"####"));
   yearSpin.addChangeListener(this);
   result.add(yearSpin);
   JLabel yearLabel=new JLabel("��");
   yearLabel.setForeground(controlTextColor);
   result.add(yearLabel);
   JSpinner monthSpin=new JSpinner(new SpinnerNumberModel(currentMonth,1,12,1));
   monthSpin.setPreferredSize(new Dimension(35,20));
   monthSpin.setName("Month");
   monthSpin.addChangeListener(this);
   result.add(monthSpin);
   JLabel monthLabel=new JLabel("��");
   monthLabel.setForeground(controlTextColor);
   result.add(monthLabel);
   JSpinner hourSpin =new JSpinner(new SpinnerNumberModel(currentHour,0,23,1));
   hourSpin.setPreferredSize(new Dimension(35,20));
   hourSpin.setName("Hour");
   hourSpin.addChangeListener(this);
   result.add(hourSpin);
   JLabel hourLabel=new JLabel("ʱ");
   hourLabel.setForeground(controlTextColor);
   result.add(hourLabel);
   return result;
         
  }
  private JPanel createWeekAndDayPanal()
  {
   String colname[]={"��","һ","��","��","��","��","��"};
   JPanel result=new JPanel();
   //���ù̶�����,������û����ı�Ӱ��������
   result.setFont(new Font("����",Font.PLAIN, 12));
   result.setLayout(new GridLayout(7,7));
   result.setBackground(Color.white);
   JLabel cell;
   for(int i=0;i<7;i++)
   {
     cell=new JLabel(colname[i]);
     cell.setHorizontalAlignment(JLabel.RIGHT);
     if((i==0)||(i==6))cell.setForeground(weekendFontColor);
     else cell.setForeground(weekFontColor);
     result.add(cell);
    }
    int actionCommandId=0;
    for(int i=0;i<6;i++)
    {
     for(int j=0;j<7;j++)
     {
       JButton numberButton=new JButton();
       numberButton.setBorder(null);
       numberButton.setHorizontalAlignment(SwingConstants.RIGHT);
       numberButton.addActionListener(this);
       numberButton.setBackground(palletTableColor);
       numberButton.setForeground(dateFontColor);
       if((j==0)||(j==6))numberButton.setForeground(weekendFontColor);
       else numberButton.setForeground(dateFontColor);
       daysButton[i][j]=numberButton;
       result.add(numberButton);
       actionCommandId++;
      }
     }
   return result;
  }
@Override
public void stateChanged(ChangeEvent e) {
	// TODO �Զ���ɵķ������
	System.out.println("ֵ�ĸı�");
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO �Զ���ɵķ������
	System.out.println("�����¼�");
 }


 public static void main(String [] args){
	 
	 
 }
 
 }
