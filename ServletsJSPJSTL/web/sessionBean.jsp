<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head><title>JSP Beans</title></head>
 <body>
 <jsp:useBean id="myBean" class="ai.beans.SessionTrackerBean" scope="session"/>

 <h2>JSP Session Bean</h2>

 Dane odczytane z komponentu Java Bean:
 <ul>
 <li>adres IP: <jsp:getProperty name="myBean" property="ip"/>
 <li>ostatni dostęp: <jsp:getProperty name="myBean" property="lastAccess"/>
 </ul>

 <jsp:setProperty name="myBean" property="ip"
 value="<%= request.getRemoteAddr()%>"/>
 <jsp:setProperty name="myBean" property="lastAccess"
 value="<%= new Date() %>"/>
 </body>
</html>