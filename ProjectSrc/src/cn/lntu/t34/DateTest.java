package bookmanage;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTest {

/**
* 日期转换成字符串
* @param date 
* @return str
*/
public static String DateToStr(Date date) {
  
   SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd");
   String str = simpleformat.format(date);
   return str;
} 

/**
* 字符串转换成日期
* @param str
* @return date
*/
public static Date StrToDate(String str) {
  
   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
   Date date = null;
   try {
    date = format.parse(str);
   } catch (ParseException e) {
    e.printStackTrace();
   }
   return date;
}

//public static void main(String[] args) {
//  
//   Date date = new Date();
//   System.out.println("日期转字符串：" + DateTest.DateToStr(date));
//   //System.out.println("字符串转日期：" + DateTest.StrToDate(DateTest.DateToStr(date)));
//  System.out.println("字符串转日期: " +DateTest.StrToDate("2015-02-01"));
//  System.out.println(DateTest.DateToStr(DateTest.StrToDate("2015-05-23")));
//}

}


