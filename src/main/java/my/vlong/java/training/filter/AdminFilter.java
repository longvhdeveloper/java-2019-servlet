package my.vlong.java.training.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        if (isLoginValid(username, password)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setContentType("text/html");
            writer.println("Username or password is not valid");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("admin-login.html");
            requestDispatcher.include(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    private boolean isLoginValid(String username, String password) {
        return username.equals("admin") && password.equals("123456");
    }
}
