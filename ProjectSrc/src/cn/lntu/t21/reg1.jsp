<%@ page contentType="text/html;charest=gb2312"import="java.sql.*"
%>
<html>
<head>
<title>
</title>
</head>
<body>
<h2>Resister</h2>
<br>
<form name="info"action="reg2.jsp"method="post">
UserName:<input type="text"name="name"value=""><br>
Password:<input type="password"name="password"value=""><br>
Affirm:<input type="Password" name="password1"value=""><br>
Real Name:<input type="text" name="relname"value=""><br>
Tel: <input type="text" name="telephe" value=""><br>
E-mail:<input type="text" name="mail"value=""><br>
Address:<input type="text"name="adder"value=""><br>
<input type="button"name=next value="Next"onclick="Checkform()">
</form>
<script language=javascript>
function Checkform()
{
   flag=1;
   if(document.info.password.value!=document.info.password1.value)
   {
      alert("Not the same,");
      document.info.password.value="";
      document.info.password1.value="";
      flag=0;
      }
    if(document.info.name.value=="")
    {  
      alert("Please enter user name");
      document.info.name.focus();
      flag=0;
      return false;
      }
      if(document.info.password.value=="")
      {
      alert("please enter password");
      document.info.password.focus();
      flag=0;
      return false;
      }
      if(document.info.password1.value=="")
      {
      alert("Please insure your password");
      document.info.password1.focus();
      flag=0;
      return false;
      }
      if(document.info.telephe.value=="")
      {
         alert("Please enter phone number");
         document.info.telephe.focus();
         return false;
         flag=0;
         }
       if(document.info.mail.value=="")
       {
       alert("Please E-mail");
       document.info.mail.focus();
       flag=0;
       return false;
       }
       if(flag==1)
       {
         document.info.submit();
         }
         }
         </script>
         </body>
         </html>
         