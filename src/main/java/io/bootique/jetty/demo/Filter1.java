package io.bootique.jetty.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Filter1 implements Filter {

    private static Logger LOGGER = LoggerFactory.getLogger(Filter1.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Filtering of requests to the servlet1");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
