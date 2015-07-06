package bookmanage;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DateChooser extends JPanel implements ActionListener,ChangeListener
{
  int startYear=1980;        //默认最小显示年份
  int lastYear=2050;         //默认最大显示年份
  int width=200;             //界面宽度
  int height=200;            //界面高度
  Color backGroundColor=Color.gray;    //底色为灰色
  //月历表格配色----------------------//
  Color palletTableColor=Color.white;   //日历表底色
  Color todayBackColor=Color.orange;    //今天背景色
  Color weekFontColor=Color.blue;       //星期文字色
  Color dateFontColor=Color.black;      //日期文字色
  Color weekendFontColor=Color.red;     //周末文字色
  //控制条配色------------------------//
  Color controlLineColor=Color.pink;    //控制条底色
  Color controlTextColor=Color.white;   //控制条标签文字色
  Color rbFontColor=Color.white;        //RoundBox文字色
  Color rbBorderColor=Color.red;        //RoundBox边框色
  Color rbButtonColor=Color.pink;       //RoundBox按钮色
  Color rbBTFontColor=Color.red;        //RoundBox按钮文字色
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
   JLabel yearLabel=new JLabel("年");
   yearLabel.setForeground(controlTextColor);
   result.add(yearLabel);
   JSpinner monthSpin=new JSpinner(new SpinnerNumberModel(currentMonth,1,12,1));
   monthSpin.setPreferredSize(new Dimension(35,20));
   monthSpin.setName("Month");
   monthSpin.addChangeListener(this);
   result.add(monthSpin);
   JLabel monthLabel=new JLabel("月");
   monthLabel.setForeground(controlTextColor);
   result.add(monthLabel);
   JSpinner hourSpin =new JSpinner(new SpinnerNumberModel(currentHour,0,23,1));
   hourSpin.setPreferredSize(new Dimension(35,20));
   hourSpin.setName("Hour");
   hourSpin.addChangeListener(this);
   result.add(hourSpin);
   JLabel hourLabel=new JLabel("时");
   hourLabel.setForeground(controlTextColor);
   result.add(hourLabel);
   return result;
         
  }
  private JPanel createWeekAndDayPanal()
  {
   String colname[]={"日","一","二","三","四","五","六"};
   JPanel result=new JPanel();
   //设置固定字体,以免调用环境改变影响界面外观
   result.setFont(new Font("宋体",Font.PLAIN, 12));
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
	// TODO 自动生成的方法存根
	System.out.println("值的改变");
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO 自动生成的方法存根
	System.out.println("单击事件");
 }


 public static void main(String [] args){
	 JFrame frame=new JFrame("时间表");
	 frame.setSize(300,200);
	 frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	 Container c=frame.getContentPane();
	 c.add(new DateChooser());
	 frame.setVisible(true);
	 
	 
 }
 
 }
