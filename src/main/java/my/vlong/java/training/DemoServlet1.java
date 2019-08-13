package my.vlong.java.training;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo01")
public class DemoServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("company", "Techbase VietNam");
        writer.println("Welcome first servlet");
        writer.println("<a href='/demo02'>visit</a>");
        writer.close();

    }
}
