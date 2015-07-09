<%@page import="javax.enterprise.deploy.model.DDBean"%>
<%@ 
page contentType="text/html; charset=GBK"
 import="cn.lntu.t21.DBBean"
 %>
 <html>
 <head>   
 <title>
 </title>
 </head>
 <body>
 <table border="1">
 <tr>
 <th width="30%" align="center"></td>
 <th width="30%" align="center"></td>
 <th width="30%" align="center"></td>
 <th width="30%" align="center"></td>
 </tr>
 <%  
    String cp=request.getParameter("cp");
    int currpage=(cp==null||cp=="")?1:Integer.parseInt(cp);
    String[][] ss=DBBean.getGoodList(currpage); 
    for(int i=0;i<ss.length;i++) 
    {
  %>
  <tr>
  <td height="30%" align="center"><%=ss[i][0] %></td>
  <td height="30%" align="center"><%=ss[i][1] %></td>
  <td height="30%" align="center"><%=ss[i][2] %></td>
  <td height="30%" align="center"><a href="Buy.jsp?sid=<%= ss[i][0] %>&action=buy">Buy</a></td>
  </tr>
  <%
     }
  
   %>
   </table>
   <%
       int tp=DBBean.getTotalPage();
       if(currpage!=1)
       {
       %>
       <a href="rightFrame.jsp?cp=<%=currpage-1%>"><< Before Page</a>&nbsp;&nbsp; 
       <%
       }
       if(currpage!=tp)
       {
       %>
       <a href="rightFrame.jsp?cp=<%=currpage+1%>">Later Page>></a>
       <%
       }
       %>
       <form action="rightFrame.jsp" name="myform">
       <select name="cp" onchange="document.myform.submit()">
       <% 
          for(int i=1;i<=tp;i++)
          {
          %>
          <option value="<%=i%>"<%=(i==currpage)?"selected":""%>>Page<%=i%></option>
          <%
          }
           %>
          </select>
          </form>
          <hr/>
          <a target="_BLANK"href="Cart.jsp">1.THE SHOPPING CART</a>
          <a target="_BLANK"href="reg.jsp">2.USER RESISTER</a>
          </body>
          </html>
       