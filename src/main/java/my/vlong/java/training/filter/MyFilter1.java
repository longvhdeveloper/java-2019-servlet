package my.vlong.java.training.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.print("filter is invoked before");
        filterChain.doFilter(servletRequest, servletResponse);//sends request to next resource
        writer.print("filter is invoked after");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
