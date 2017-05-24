package io.bootique.jetty.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet1 extends HttpServlet {

    public static final Logger LOGGER = LoggerFactory.getLogger(Servlet1.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Do GET request to the Jetty server");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");
        pw.println(String.format("Servlet 1! p1: %s; p2: %s",
                req.getParameter("p1") == null ? this.getInitParameter("p1") : req.getParameter("p1"),
                req.getParameter("p2") == null ? this.getInitParameter("p2") : req.getParameter("p2")));
        pw.println("</body></html>");

        pw.close();
    }
}
