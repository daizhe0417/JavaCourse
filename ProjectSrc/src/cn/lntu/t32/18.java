//链接数据库代码

import java.sql.*;
public class Connect
{
static Connection conn;
static Statement sql;
static ResultSet res;
static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
static String dbURL="jdbc:sqlserver://127.0.0.1:1433;integratedSecurity=true;"
dbURL=dbURL+"DatabaseName=(这里是你要连接的数据库名称)";
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
//执行增、删、改语句
public static int ExeSqlOper(String strSql) //方法在其它函数中直接调用就行了
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
//执行Select语句
public static ResultSet ExeSqlQuery(String strSql) //同样直接调用使用
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
//主函数
public static void main(String arges[])
{
getConnect();
}