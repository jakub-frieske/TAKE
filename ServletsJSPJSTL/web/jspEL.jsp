<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import = "java.util.Date" session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head><title>JSP EL Test</title></head>
 <body>
 <form method="post">
 Podaj imię: <input type="text" name="username" />
 <input type="submit" value="Prześlij" />
 </form><br/>
 <h2>Język wyrażeń JSP EL</h2>

 Imię: ${param.username} <br/>
 Przeglądarka: ${header["user-agent"]} <br/>
 Ostatnia wizyta: ${sessionScope.lastVisit} <br/>

 <% session.setAttribute("lastVisit", new java.util.Date()); %>
 </body>
</html>