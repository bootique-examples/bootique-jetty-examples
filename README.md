[![Build Status](https://travis-ci.org/bootique-examples/bootique-jetty-producer.svg)](https://travis-ci.org/bootique-examples/bootique-kafka-producer)

# bootique-jetty-demo

An example of Jetty integrated with [Bootique](http://bootique.io). Documentation and configuration reference are [available here](http://bootique.io/docs/0/bootique-jetty-docs/).

*For additional help/questions about this example send a message to
[Bootique forum](https://groups.google.com/forum/#!forum/bootique-user).*

## Prerequisites

* Java 1.8 or newer.
* Apache Maven.

## Build the Demo

TODO:

Here is how to build it:

	
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




--server --config=config.yml
    
