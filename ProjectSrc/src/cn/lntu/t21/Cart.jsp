<%@page import="cn.lntu.t21.Cart"%>
<%@ page
  contentType="text/html; charset=GBK"
  import="wyf.DBBean"
  %>
  <jsp:useBean id="cart" scope="session"class="cn.lntu.t21.Cart"/>
  <html>
    <head>
    <title>Shopping</title>
    </head>
    <body>
    <% 
    if(cart.isEmpty())
    {
    %>
    <font color="red" size="20">Shopping Empty</font>
    <%
    }
    else
    {
    %>
    <h2>Shopping car</h2>
    <table border="1">
    <tr>
    <th width="27%"align="center">ID</td>
    <th width="27%"align="center">Name</td>
    <th width="27%"align="center">$$$</td>
    <th width="27%"align="center">Num</td>
    <th width="27%"align="center">More?</td>
    </tr>
    <% 
      String[][] ssa=cart.getCart();
      for(int i=0;i<ssa.length;i++)
      {
      %>
      <tr>
        <th height="30%" align="center"><%=ssa[i][0] %>
         <th height="30%" align="center"><%=ssa[i][1] %>
          <th height="30%" align="center"><%=ssa[i][2] %>
         <th>
         <form action="Buy.jsp" method="post">
         <input type="text"name="count" value="<%=ssa[i][3] %>">
         <input type="hidden"name="sid" value="<%=ssa[i][0] %>">
         <input type="hidden"name="action"value="gc">
         </form>
         </td>
         <th><a href="Buy.jsp?sid=<%=ssa[i][0]%>&action="del">Delete</a></td>
         </tr>
         <%
         }
         %>
         </table>
         <br>
         <br>
         Shopping Sum:<%= Math.round(cart.getTotal()*100)/100.0%>
         <%
         }
         %>
         </td>
         <br>
         <hr/>
         <a target="_BLANK" href="frame.jsp">Shopping More</a>
         </body>
         </html>
         
             
  