package bookmanage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Returndelete {
	
	Connection  conn=null;
	Statement stmt;
	ResultSet rs=null;
	public Returndelete(String str)
	{
		if(conn==null) conn=ConnectDataBase.getConn();     //�������ݿ�����
		
		try {
	  		stmt=conn.createStatement();
	  		stmt.executeUpdate(str);
		}
		catch(SQLException e){e.printStackTrace();
		JOptionPane.showMessageDialog(null, this, "ɾ��ʧ�ܣ�", 0);}
	}

}
