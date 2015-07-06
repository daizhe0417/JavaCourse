package bookmanage;
import javax.swing.table.AbstractTableModel;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class DatabaseTableModel {
	//制作表格的通用模板
	
	 ResultSet rs;
	 public DatabaseTableModel(ResultSet rs){
	  this.rs=rs;
	 }

	 public String getColumnName(int c){
	  try{
	      return rs.getMetaData().getColumnName(c+1);
	     }
	  catch (SQLException ex){ex.printStackTrace();}
	  return null;
	 }

	 //implement three necessary methods.
	 public int getRowCount(){
	  try{
	      rs.last();
	      return rs.getRow();
	     }
	  catch (SQLException ex){ex.printStackTrace();}
	  return 0;
	 }

	 public int getColumnCount(){
	  try{
	      return rs.getMetaData().getColumnCount(); 
	     }
	  catch (SQLException ex){ex.printStackTrace();}
	  return 0;
	 }

	 public Object getValueAt(int rowIndex, int columnIndex){
	  try
	  {
	   rs.absolute(rowIndex + 1);
	   return rs.getString(columnIndex+1); 
	  }
	  catch(SQLException ex)
	  {
	   ex.printStackTrace();
	  }
	  return null;
	 }
	 public static void main(String [] args){
		 Statement stmt=null;
		 Connection conn=null;
		 ResultSet rst;
		 JTable table=null;
		 if(conn==null) conn=ConnectDataBase.getConn();     //进行数据库连接
		 JFrame frame=new JFrame("测试");
		 frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 Container contentPane=frame.getContentPane();
		 
		 table.setPreferredScrollableViewportSize(new Dimension(550,30));
		 JScrollPane scrollPane = new JScrollPane(table);
		 
		 try{
              String sql="select * from bookinfo order by Bid desc";
              stmt=conn.createStatement();
              rst=stmt.executeQuery(sql);
            
		 }catch(Exception ex){ex.printStackTrace();}
		// frame.getContentPane().add(panel,BorderLayout.NORTH);
		  frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		  frame.pack();
		  frame.setVisible(true);

		  frame.addWindowListener(new WindowAdapter(){
		   public void windowClosing(WindowEvent e){
		    System.exit(0);
		   }
		  });
		 
	 }

}
