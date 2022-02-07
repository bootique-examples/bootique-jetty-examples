package io.bootique.jetty.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");
        pw.println(String.format("Servlet 2! p3: %s; p4: %s",
                req.getParameter("p3") == null ? this.getInitParameter("p3") : req.getParameter("p3"),
                req.getParameter("p4") == null ? this.getInitParameter("p4") : req.getParameter("p4")));
        pw.println("</body></html>");

        pw.close();
    }

}
