package io.bootique.examples.jetty;

import io.bootique.BQModule;
import io.bootique.Bootique;
import io.bootique.di.Binder;
import io.bootique.jetty.JettyModule;
import io.bootique.jetty.MappedServlet;

public class App implements BQModule {

    public static void main(String[] args) {
        Bootique.app(args)
                .autoLoadModules()
                .exec()
                .exit();
    }

    @Override
    public void configure(Binder binder) {

        // Turns Jetty into a webserver that serves static files from the "/" URL mapped to the "root/" folder
        MappedServlet<?> statics = MappedServlet
                .ofStatic("/")
                .resourceBase("classpath:docroot/")
                .build();

        // register servlets and filters
        JettyModule.extend(binder)

                // register the "statics" servlets
                .addMappedServlet(statics)

                // register a servlet that generates its content dynamically. URL mapping is taken from its class annotations
                .addServlet(AnnotatedServlet.class)

                // register a filter. URL mapping is taken from its class annotations
                .addFilter(AnnotatedFilter.class);
    }
}
