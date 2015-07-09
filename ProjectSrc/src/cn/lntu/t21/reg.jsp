<%@ 
  page contentType="text/html; charset=gb2312" import="java.sql.*"
  %>
  <html>
  <head>
  <title></title>
  </head>
  <body>
  <textarea name="textfield" cols="60" rows="20">
  This is a VCDManage
  </textarea>
  <table>
  <tr>
  <td>
  <form action="reg1.jsp" method="post">
  <input type="button" name="I Agree" value="I Agree" onclick="submit()">
  </form>
  </td>
  <td>
  <form action="frame.jsp" method="post">
     <input type="button" name="I Don't AGREE" value="I Don't Agree" onclick="submit()">
</form>
</td>
</tr>
</table>
</body>
</html>
