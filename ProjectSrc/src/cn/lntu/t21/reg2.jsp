<%@ 
   page contentType="text/html; charset=gb2312" import="java.sql.*"language="java"%>
   <html>
   <head>
   <meta http-equiv="Content-Type" content="text/html;charest=gb2312">
   <title></title>
   </head>
   <body>
   <% 
     String name=(String)request.getParameter("name");
     String password=(String)request.getParameter("password");
     String telephe=(String)request.getParameter("telephe");
     String mail=(String)request.getParameter("mail");
     String relname=(String)request.getParameter("relname");
     String adder=(String)request.getParameter("adder");
     Connection dbcon=null;
     try
     {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     dbcon=DriverManager.getConnection("jdbc:odbc:shop","","");
     PreparedStatement stat=dbcon.prepareStatement("insert into useInfo values(?,?,?,?,?,?)");
     stat.setString(1,name);
     stat.setString(2,password);
     stat.setString(3,relname);
     stat.setString(4,telephe);
     stat.setString(5,adder);
     stat.setString(6,mail);
     int count=stat.executeUpdate();
     if(count>0)
     {
     %>
     <jsp:forward page="reg3.jsp"/>
     <%
     }else
     {
     %>
     <jsp:forward page="frame.jsp"/>
     <%
     }
     dbcon.close();
     }
     catch(Exception e)
     {
     e.printStackTrace();
     %>
     <jsp:forward page="error.jsp"/>
     <%
     }
     finally
     {
     }
     %>
     </body>
     </html>
     
     
     