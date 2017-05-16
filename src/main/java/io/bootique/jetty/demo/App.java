package io.bootique.jetty.demo;

import com.google.inject.Binder;
import com.google.inject.Module;
import io.bootique.Bootique;
import io.bootique.jersey.JerseyModule;
import io.bootique.jetty.JettyModule;

public class App implements Module {

    public static final void main(String[] args) {
        Bootique.app(args).module(App.class).autoLoadModules().run();
    }

    @Override
    public void configure(Binder binder) {
        JettyModule.extend(binder).addServlet(AnnotatedServlet.class).addFilter(AnnotatedFilter.class);
        JerseyModule.extend(binder).addResource(HelloResource.class);
    }
}
