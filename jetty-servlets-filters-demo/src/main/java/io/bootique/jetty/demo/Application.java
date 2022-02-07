package io.bootique.jetty.demo;

import io.bootique.BaseModule;
import io.bootique.Bootique;
import io.bootique.di.Binder;
import io.bootique.di.Provides;
import io.bootique.di.TypeLiteral;
import io.bootique.jetty.JettyModule;
import io.bootique.jetty.MappedFilter;
import io.bootique.jetty.MappedServlet;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.Map;

public class Application extends BaseModule {

    public static void main(String[] args) {
        Bootique.app(args)
                .autoLoadModules()
                .module(Application.class)
                .exec()
                .exit();
    }

    @Override
    public void configure(Binder binder) {

        // DI key for a MappedServlet of a certain kind
        TypeLiteral<MappedServlet<Servlet2>> servlet2Key = new TypeLiteral<>() {
        };

        // DI key for a MappedFilter of a certain kind
        TypeLiteral<MappedFilter<Filter2>> filter2Key = new TypeLiteral<>() {
        };

        // register servlets and filters
        JettyModule.extend(binder)
                // annotated servlets can be added directly
                .addServlet(AnnotatedServlet1.class)

                // alternatively servlets can be mapped in Bootique via MappedServlet and referenced via a special DI key
                .addMappedServlet(servlet2Key)

                // annotated filters can be added directly
                .addFilter(AnnotatedFilter1.class)

                // alternatively filters can be mapped in Bootique via MappedServlet and referenced via a special DI key
                .addMappedFilter(filter2Key);
    }

    @Singleton
    @Provides
    MappedServlet<Servlet2> provideServlet2() {
        Map<String, String> params = Map.of(
                "p1", "v1",
                "p2", "v2");

        return new MappedServlet<>(new Servlet2(), Collections.singleton("/s2"), "servlet2", params);
    }

    @Singleton
    @Provides
    MappedFilter<Filter2> provideFilter2() {
        return new MappedFilter<>(new Filter2(), Collections.singleton("/s2/*"), "filter2", 1);
    }
}
