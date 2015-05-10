package bookmanage;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
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

}
