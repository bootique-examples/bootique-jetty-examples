[![Build Status](https://travis-ci.org/bootique-examples/bootique-jetty-demo.svg)](https://travis-ci.org/bootique-examples/bootique-jetty-demo)

# bootique-jetty-demo

A simple example that explains how to run servlet specification objects on Jetty server integrated with [Bootique](https://bootique.io). 

*Bootique Jetty Documentation and configuration reference are [available here](https://bootique.io/docs/0/bootique-jetty-docs/).*
*For additional help/questions about this example send a message to [Bootique forum](https://groups.google.com/forum/#!forum/bootique-user).*

## Prerequisites

* Java 1.8 or newer.
* Apache Maven.

## Build the Demo

Here is how to build it:

	git clone git@github.com:bootique-examples/bootique-jetty-demo.git
	cd bootique-jetty-demo
	mvn package

## Run the Demo

Now you can check the options available in your app:

    java -jar target/bootique-jetty-demo-1.0-SNAPSHOT.jar
    
    Option                                              Description
    ------                                              -----------    
    -c yaml_location, --config=yaml_location            Specifies YAML config location, which can be a file path or a URL.

    -h, --help                                          Prints this message.

    -H, --help-config                                   Prints information about application modules and their configuration
                                                            options.
                                                            
    -s, --server                                        Starts Jetty server.


Provide YAML config:

    jetty:
      context: '/myapp'
      connectors:       # Jetty connector. If none is provided, Bootique creates a single HTTP connector on port 8080
        - port: 9999
      servlets:         # override java settings of the servlet named "servlet2"
        servlet2:
          urlPatterns:
            - '/ss2'
          params:
            p3: v33
            p4: v44
      filters:          # override filter settings
        filter2:
          urlPatterns:
            - '/ss2/*'

Run the server:
    
    java -jar target/bootique-jetty-demo-1.0-SNAPSHOT.jar --server --config=config.yml

Then open:
1. [http://192.168.1.13:9999/myapp/s1?p1=1&p2=2](http://192.168.1.13:9999/myapp/s1?p1=1&p2=2) to do GET request on the server mapped on servlet1
2. [http://192.168.1.13:9999/myapp/s2](http://192.168.1.13:9999/myapp/s2) leads to HTTP ERROR: 404 since YAML overrides servlet2 java settings
3. [http://192.168.1.13:9999/myapp/ss2](http://192.168.1.13:9999/myapp/ss2) successful request




    
