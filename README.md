[![Build Status](https://travis-ci.org/bootique-examples/bootique-jetty-producer.svg)](https://travis-ci.org/bootique-examples/bootique-kafka-producer)

# bootique-jetty-demo

A simple example that explains how to run servlet specification objects on Jetty server integrated with [Bootique](https://bootique.io). 

*Bootique Jetty Documentation and configuration reference are 
[available here](https://bootique.io/docs/0/bootique-jetty-docs/).*

*For additional help/questions about this example send a message to
[Bootique forum](https://groups.google.com/forum/#!forum/bootique-user).*

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


Configure Jetty connector via YAML and run the server with the configuration:
    
    java -jar target/bootique-jetty-demo-1.0-SNAPSHOT.jar --server --config=config.yml

If no connectors are provided, Bootique will create a single HTTP connector on port 8080.

Then open [http://localhost:9999/test?user=user](http://locahost:9999/test?user=user) to do GET request on the server.

In the example one can also find some jUnit tests for the servlet and the resource on Jetty server.
 

    
