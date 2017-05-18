package io.bootique.jetty.demo;

import io.bootique.jetty.test.junit.JettyTestFactory;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class HelloResourceTest {

    @Rule
    public JettyTestFactory jettyTestFactory = new JettyTestFactory();

    @Test
    public void hello() throws Exception {
        jettyTestFactory.app().module(App.class).autoLoadModules().start();

        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/").request().get();

        assertEquals("Hello!", response.readEntity(String.class));
    }

}