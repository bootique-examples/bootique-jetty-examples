package io.bootique.jetty.demo;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import io.bootique.Bootique;
import io.bootique.jetty.JettyModule;
import io.bootique.jetty.MappedFilter;
import io.bootique.jetty.MappedServlet;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Application implements Module {

    public static final void main(String[] args) {
        Bootique.app(args).module(Application.class).autoLoadModules().run();
    }

    @Override
    public void configure(Binder binder) {

        //wrap not annotated servlet into a special metadata object MappedServlet
        MappedServlet<Servlet1> mappedServlet = new MappedServlet<>(
                new Servlet1(),
                Collections.singleton("/s1"),
                "servlet1", new HashMap<String, String>() {
            {
                put("p1", "v1");
                put("p2", "v2");
            }
        });
        //wrap not annotated filter
        MappedFilter<Filter1> mappedFilter = new MappedFilter<>(new Filter1(), new HashSet<String>() {{
            add("/s1/*");
        }}, 0);

        //create binding via TypeLiteral for not annotated servlet
        TypeLiteral<MappedServlet<Servlet2>> servletTypeLiteral = new TypeLiteral<MappedServlet<Servlet2>>() {
        };
        //filter
        TypeLiteral<MappedFilter<Filter2>> filterTypeLiteral = new TypeLiteral<MappedFilter<Filter2>>() {
        };

        JettyModule.extend(binder).addMappedServlet(mappedServlet).addMappedServlet(servletTypeLiteral).addMappedFilter(mappedFilter).addMappedFilter(filterTypeLiteral);
    }

    @Singleton
    @Provides
    MappedServlet<Servlet2> provideServlet2() {
        Servlet2 servlet = new Servlet2();

        Map<String, String> params = new HashMap<String, String>() {{
            put("p3", "v3");
            put("p4", "v4");
        }};

        return new MappedServlet<>(servlet, Collections.singleton("/s2"), "servlet2", params);
    }

    @Singleton
    @Provides
    MappedFilter<Filter2> provideFilter2() {
        Filter2 filter = new Filter2();

        return new MappedFilter<Filter2>(filter, new HashSet<String>() {{
            add("/s2/*");
        }}, "filter2", 1);
    }
}
