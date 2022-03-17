<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <title>Buble Sort</title>
 </head>
 <body>
 <%! int temp, i; %>
 <%! boolean change; %>
 <%! int data[] = { 1, 6, 4, 5, 3 }; %>
 <%! int size; %>

 <% size = data.length;
 do {
 change = false;
 i = size - 1;
 do {
 i--;
 if (data[i+1] < data[i]) {
 temp = data[i];
data[i] = data[i+1];
data[i+1] = temp;
change = true;
 }
 } while (i != 0);
 } while (change); %>
 Posortowane liczby:
 <% for (int i = 0; i < size; i++) { %>
 <%= data [i] %>
 <% } %>
 </body>
</html>
