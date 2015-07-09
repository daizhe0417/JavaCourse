<%@
 page contentType="text/html; charset=gb2312" import="java.sql.*"
 errorPage=""
 %>
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html;charest=gb2312">
 <title></title>
 </head>
 <body>
 <% 
  String operator=request.getParameter("operator");
  if("login".equals(operator))
  {
  %>
  <jsp:forward page="load.jsp"></jsp:forward>
  <%
  }
   %>
  </body>
  </html>
  