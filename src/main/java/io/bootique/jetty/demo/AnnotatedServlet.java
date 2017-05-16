package io.bootique.jetty.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test", initParams = {
        @WebInitParam(name = "user", value = "user")
})
public class AnnotatedServlet extends HttpServlet {

    private static Logger LOGGER = LoggerFactory.getLogger(AnnotatedServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info("Do GET request to the Jetty server");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");
        pw.println(String.format("Hello, %s!", req.getParameter("user")));
        pw.println("</body></html>");

        pw.close();
    }
}

