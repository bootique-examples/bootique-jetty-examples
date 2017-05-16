package io.bootique.jetty.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(
        filterName = "f1",
        urlPatterns = "/test/*",
        initParams = {
                @WebInitParam(name = "user", value = "user")
        }
)
public class AnnotatedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (((HttpServletRequest) request).getSession() == null) {
            throw new ServletException("Session is null");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
