package io.bootique.jetty.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "filter1", urlPatterns = "/s1/*")
public class AnnotatedFilter1 implements Filter {

    static final Logger LOGGER = LoggerFactory.getLogger(AnnotatedFilter1.class);

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("GET filter1");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
