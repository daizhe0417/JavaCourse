package cn.lntu.t21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.enterprise.deploy.model.DDBean;
import javax.naming.spi.DirStateFactory.Result;

import org.apache.taglibs.standard.lang.jstl.test.StaticFunctionTests;
import org.omg.CORBA.PUBLIC_MEMBER;

public class DBBean {
	static Connection con;
	static PreparedStatement psGoodList;
	static PreparedStatement psGoodFromldToPrice;
	static PreparedStatement psGoodFromldToDetail;
	static PreparedStatement psCountRecords;
	static int span=5;
	static 
	{
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:shop","","");
			psGoodList=con.prepareStatement("select sid,sname,sprice from good",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			psGoodFromldToPrice=con.prepareStatement("select sprice from good where sid=?");
			psGoodFromldToDetail=con.prepareStatement("select sname,sprice from good where sid=?");
			psCountRecords=con.prepareStatement("select count(sid) from good");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String[][]getGoodList(int cp){
		String[][] result=null;
		Vector v = new Vector();
		try {
			
			ResultSet rs= psGoodList.executeQuery();
			if(cp!=1)
			{
				rs.absolute((cp-1)*span);
			}
			int count =1;
			while(rs.next()&&count<=span)
			{
				count++;
				String[] tempsa= new String[3];
				tempsa[0]=rs.getString(1);
				tempsa[1]=rs.getString(2);
				tempsa[2]=rs.getString(3);
				v.add(tempsa);
				
			}
			int size=v.size();
			result= new String[size][];
			for (int i = 0; i < size; i++) {
				
				result[i]=(String[])v.elementAt(i);
				
				
			}
		} catch (Exception e) {
			
       e.printStackTrace();
 }
		
		return result;
	}
	public static double getPrice(String sid)
	{
		double dd=0;
		try {
			
			psGoodFromldToPrice.setString(1, sid);
			ResultSet rs=psGoodFromldToPrice.executeQuery();
			rs.next();
			dd=Double.parseDouble(rs.getString(1));
			
			
		} catch (Exception e) {
			e.printStackTrace();

		
		}
		
		return dd;
		
	}
	
	public static String[] getDetail(String sid)
	{
		String[] ss=null;
		try {
			psGoodFromldToDetail.setString(1, sid);
			ResultSet rs=psGoodFromldToDetail.executeQuery();
			rs.next();
			ss=new String[2];
			ss[0]=rs.getString(1);
			ss[1]=rs.getString(2);
			
		} catch (Exception e) {
			e.printStackTrace();

		
		}
		return ss;
	}
	
	   public static int getTotalPage(){
	   int tp=0;
	   try {
		ResultSet rs=psCountRecords.executeQuery();
		rs.next();
		int count =rs.getInt(1);
		tp=count/span+((count%span==0)?0:1);
		
	} catch (Exception e) {
		
		
    e.printStackTrace();

	}
	   
	   return tp;
		
		
		
		
	}
	public static void  main(String args[]) {
		
		System.out.println(DBBean.getTotalPage());
		
	}
	
	
	
	
	
	
	
	
	

}
