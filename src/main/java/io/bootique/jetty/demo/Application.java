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
import java.util.HashMap;
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

        // Wrap not annotated servlet into a special metadata object MappedServlet
        Map<String, String> params = new HashMap<>();
        params.put("p1", "v1");
        params.put("p2", "v2");

        MappedServlet<Servlet1> mappedServlet = new MappedServlet<>(
                new Servlet1(),
                Collections.singleton("/s1"),
                "servlet1",
                params
        );

        // Wrap not annotated filter
        MappedFilter<Filter1> mappedFilter = new MappedFilter<>(
                new Filter1(),
                Collections.singleton("/s1/*"),
                0
        );

        // Create binding via TypeLiteral for not annotated servlet
        TypeLiteral<MappedServlet<Servlet2>> servletTypeLiteral = new TypeLiteral<MappedServlet<Servlet2>>() {};

        // Create binding via TypeLiteral for not annotated filter
        TypeLiteral<MappedFilter<Filter2>> filterTypeLiteral = new TypeLiteral<MappedFilter<Filter2>>() {};

        JettyModule.extend(binder)
                .addMappedServlet(mappedServlet)
                .addMappedServlet(servletTypeLiteral)
                .addMappedFilter(mappedFilter)
                .addMappedFilter(filterTypeLiteral);
    }

    @Singleton
    @Provides
    MappedServlet<Servlet2> provideServlet2() {
        Servlet2 servlet = new Servlet2();

        Map<String, String> params = new HashMap<>();
        params.put("p3", "v3");
        params.put("p4", "v4");

        return new MappedServlet<>(servlet, Collections.singleton("/s2"), "servlet2", params);
    }

    @Singleton
    @Provides
    MappedFilter<Filter2> provideFilter2() {
        Filter2 filter = new Filter2();
        return new MappedFilter<>(filter, Collections.singleton("/s2/*"), "filter2", 1);
    }
}
