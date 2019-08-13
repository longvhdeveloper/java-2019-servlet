package my.vlong.java.training.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter2 implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();

        String construction = filterConfig.getInitParameter("construction");
        if (construction.equals("yes")) {
            writer.println("Page is under construction");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {

    }
}
