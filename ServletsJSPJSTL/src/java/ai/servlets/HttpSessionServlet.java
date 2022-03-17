package ai.servlets;
import java.io.*;
import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
@WebServlet(name="HttpSessionServlet", urlPatterns={"/HttpSessionServlet"})
public class HttpSessionServlet extends HttpServlet {

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {

 HttpSession session = request.getSession();

 ArrayList notes = (ArrayList)session.getAttribute("notes");
 if (notes == null) {
 notes = new ArrayList ();
 session.setAttribute("notes",notes);
 }

 String note = request.getParameter("note");
 if (note != null)
 notes.add(note);

 PrintWriter out = response.getWriter();

 out.println("<html>"); out.println("<body>");
 out.println("<h1>My notes</h1>");
 out.println("<ul>");

 for (int i = 0; i < notes.size(); i++)
 out.println("<li>" + notes.get(i));

 out.println("</ul>");

 out.println("<form action='HttpSessionServlet'>");
 out.println("<input type='text' name='note'/><br/>");
 out.println("<input type='submit' value='Add note'/>");
 out.println("</form>");
 out.println("</body>");
 out.println("</html>");
 }
}