package io.bootique.examples.jetty;

import io.bootique.BQRuntime;
import io.bootique.Bootique;
import io.bootique.jetty.junit5.JettyTester;
import io.bootique.junit5.BQApp;
import io.bootique.junit5.BQTest;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

@BQTest
public class AppTest {

    static final JettyTester tester = JettyTester.create();

    @BQApp
    static final BQRuntime app = Bootique.app("--server")
            .autoLoadModules()
            .module(tester.moduleReplacingConnectors())
            .createRuntime();

    @Test
    void staticServlet() {
        Response html = tester.getTarget().request().get();
        JettyTester.assertOk(html)
                .assertContentType(MediaType.TEXT_HTML)
                .assertContent(c -> c.contains("<h1>Bootique Jetty Example</h1>"));

        Response css = tester.getTarget().path("css/my.css").request().get();
        JettyTester.assertOk(css)
                .assertContentType("text/css")
                .assertContent(c -> c.contains("h1 {"));
    }

    @Test
    void annotatedServlet() {
        Response response = tester.getTarget().path("annotated").request().get();
        JettyTester.assertOk(response)
                .assertContentType(MediaType.TEXT_PLAIN)
                .assertContent("[annotated_servlet]");
    }

    @Test
    void annotatedFilter() {
        Response response = tester.getTarget().path("annotated/filtered").request().get();
        JettyTester.assertOk(response)
                .assertContentType(MediaType.TEXT_PLAIN)
                .assertContent("[annotated_filter{[annotated_servlet]}]");
    }
}
