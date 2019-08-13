package my.vlong.java.training.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {

    private static int count = 0;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        PrintWriter out = servletResponse.getWriter();
        filterChain.doFilter(servletRequest, servletResponse);

        out.print("<br/>Total visitors " + (++count));
        out.close();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
