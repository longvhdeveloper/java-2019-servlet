package my.vlong.java.training.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter4 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        long before = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long after = System.currentTimeMillis();
        out.print("<br/>Total response time " + (after - before) + " miliseconds");
        out.close();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
