//�������ݿ����

import java.sql.*;
public class Connect
{
static Connection conn;
static Statement sql;
static ResultSet res;
static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
static String dbURL="jdbc:sqlserver://127.0.0.1:1433;integratedSecurity=true;"
dbURL=dbURL+"DatabaseName=(��������Ҫ���ӵ����ݿ�����)";
public static Connection getConnect()
{
try{
Class.forName(driverName);
conn=DriverManager.getConnection(dbURL);
System.out.println("SQLSERVER2008 Connection Success!");
}catch(Exception e)
{
e.printStackTrace();
}
return conn;
}
//ִ������ɾ�������
public static int ExeSqlOper(String strSql) //����������������ֱ�ӵ��þ�����
{
int intReturn=0;
try{
conn=getConnect();
sql=conn.createStatement();
intReturn=sql.executeUpdate(strSql);
conn.close();
}catch(Exception e)
{
System.out.println(e.toString());
}
return intReturn;
}
//ִ��Select���
public static ResultSet ExeSqlQuery(String strSql) //ͬ��ֱ�ӵ���ʹ��
{
try{
conn=getConnect();
sql=conn.createStatement();

res=sql.executeQuery(strSql);

}catch(Exception e)
{
System.out.println(e.toString());
}
return res;
}
//������
public static void main(String arges[])
{
getConnect();
}