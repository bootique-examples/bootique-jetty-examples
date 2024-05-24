package io.bootique.examples.jetty;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/annotated/filtered/*")
public class AnnotatedFilter extends HttpFilter {

    @Override
    protected void doFilter(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        res.getWriter().write("[annotated_filter{");
        chain.doFilter(req, res);
        res.getWriter().write("}]");
    }
}
