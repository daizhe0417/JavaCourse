package bookmanage;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTest {

/**
* ����ת�����ַ���
* @param date 
* @return str
*/
public static String DateToStr(Date date) {
  
   SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd");
   String str = simpleformat.format(date);
   return str;
} 

/**
* �ַ���ת��������
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
//   System.out.println("����ת�ַ�����" + DateTest.DateToStr(date));
//   //System.out.println("�ַ���ת���ڣ�" + DateTest.StrToDate(DateTest.DateToStr(date)));
//  System.out.println("�ַ���ת����: " +DateTest.StrToDate("2015-02-01"));
//  System.out.println(DateTest.DateToStr(DateTest.StrToDate("2015-05-23")));
//}

}


