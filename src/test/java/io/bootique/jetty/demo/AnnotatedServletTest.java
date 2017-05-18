package io.bootique.jetty.demo;

import io.bootique.jetty.test.junit.JettyTestFactory;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class AnnotatedServletTest extends Mockito {

    @Rule
    public JettyTestFactory jettyTestFactory = new JettyTestFactory();

    @Test
    public void doGet() throws Exception {
        jettyTestFactory.app().module(App.class).autoLoadModules().start();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter response_writer = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(response_writer));
        given(request.getParameter("user")).willReturn("testUser");

        AnnotatedServlet servlet = new AnnotatedServlet();
        servlet.doGet(request, response);

        verify(request, atLeast(1)).getParameter("user");
        assertNotNull("URL param \"user\" is null.", request.getParameter("user"));

        assertThat(response_writer.toString(),
                containsString("Hello"));
    }

}