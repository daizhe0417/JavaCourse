package cn.lntu.t21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.enterprise.deploy.model.DDBean;
import javax.enterprise.inject.New;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Cart { 
	 HashMap hm=new HashMap();
	 double total=0;
	 public void add(String sid)
	 {
		 if(hm.containsKey(sid))
		 {
			 int xc=((Integer)hm.get(sid)).intValue()+1;
			 hm.put(sid, new Integer(xc));
			 
		 }
		 else 
			 {
				 hm.put(sid, new Integer(1));
			 }
			 total=total+DBBean.getPrice(sid);
	 }
			 
		
		 public double getTotal()
		 {
			 return total;
			 
		 }
		 public void setCount(int c,String sid)
		 {
			 int yc=((Integer)hm.get(sid)).intValue();
			 total=total+(c-yc)*DBBean.getPrice(sid);
			hm.put(sid, new Integer(c));
		 }
		 public void deleteFromCart(String sid)
		 {
			 int yc=((Integer)hm.get(sid)).intValue();
			 total=total-yc*DBBean.getPrice(sid);
			 hm.remove(sid);
	 }
		 public boolean isEmpty()
		 {
			 return hm.isEmpty();
		 }
		 public String[][] getCart()
		 {
			 Set ks=hm.keySet();
			 Iterator ii=ks.iterator();
			 int size=hm.size();
			 String rs[][]= new String[size][];
			 for (int i = 0; i <size; i++) {
				 String sid=(String)ii.next();
				 String[] sa=new String[4];
				 sa[0]=sid;
				 String[] sat=DBBean.getDetail(sid);
				 sa[1]=sat[0];
				 sa[2]=sat[1];
				 sa[3]=((Integer)hm.get(sid)).toString();
				 rs[i]=sa;
				 
				
			}
			 return rs;
		 }
	 
}
