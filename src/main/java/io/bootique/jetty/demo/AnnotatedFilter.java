package io.bootique.jetty.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(
        filterName = "f1",
        urlPatterns = "/test/*"
)
public class AnnotatedFilter implements Filter {

    private static Logger LOGGER = LoggerFactory.getLogger(AnnotatedFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LOGGER.info("Filtering of requests to the servlet");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
