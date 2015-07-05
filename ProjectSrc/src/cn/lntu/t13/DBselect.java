package cn.lntu.t13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBselect {
	public static WorkerBuffer getAll() {
	    Connection conn = DBconnect.getConn();
	    String sql = "select * from wworker";
	    PreparedStatement pstmt;
        WorkerBuffer wb=new WorkerBuffer();
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        
	        System.out.println("============================"+col);
	        while (rs.next()) {
	        	Worker w=new Worker();
	        	String t[]=new String[col];
	            for (int i = 1; i <= col; i++) {
	            	t[i-1]=new String(rs.getString(i));
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 5) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            w.name=t[0];
	            w.birth=t[1];
	            w.sex=t[2];
	            w.depart=t[3];
	            w.job=t[4];
	            wb.additem(w);
	            System.out.println("");
	        }
	        System.out.println("============================");
	        for(int i=0;i<wb.num;i++){
	        	System.out.println(wb.www[i].name+"	"+wb.www[i].birth+"\t");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return wb;
	}
}

class WorkerBuffer{
	public Worker www[];
	public int num;
	
	public WorkerBuffer(){
		www=new Worker[15];
		num=0;
	}
	
	public WorkerBuffer(WorkerBuffer wb){
		this.www=new Worker[wb.num];
		for(int i=0;i<wb.num;i++){
			this.www[i]=new Worker(wb.www[i]);
		}

		this.num=wb.num;
	}
	public void additem(Worker temp){
		this.www[this.num]=new Worker(temp);
		this.num++;
	}

}
