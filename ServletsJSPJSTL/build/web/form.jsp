<%@page contentType="text/html; charset=windows-1250"%>
<%@page pageEncoding="windows-1250"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <title>Form example</title>
 </head>
 <body>
 <form>
 Nazwisko: <input type="text" name="last_name"/>
 <input type="submit" value="wyœlij"/>
 </form><br/>
 <% request.setCharacterEncoding("windows-1250"); %>
 <% if (request.getParameter("last_name") != null) { %>
 Przes³ane nazwisko to <%= request.getParameter("last_name") %>
 <% } %>
 </body>
</html>
