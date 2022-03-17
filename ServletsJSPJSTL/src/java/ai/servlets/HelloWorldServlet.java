/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ai.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Darkness
 */
@WebServlet(name = "HelloWorldServlet", urlPatterns = {"/HelloWorldServlet"})
public class HelloWorldServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("windows-1250");
    request.setCharacterEncoding("windows-1250");

    PrintWriter out = response.getWriter();
    
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));

    out.println("<html>");
    out.println("<head><title>Hello World Servlet</title></head>");
    out.println("<body>");
    out.println("<h1>Hello World!</h1>");
    
    out.println("<p>Witaj, " + name + ", masz " + age + " lat</p>");
     
    out.println("</body>");
    out.println("</html>");
    out.close();
    }

}
