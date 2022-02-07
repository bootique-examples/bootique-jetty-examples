# jetty-servlets-filters-demo

A simple example that explains how to run servlet specification objects on the Jetty server and Bootique.

## Prerequisites

* Java 11 or newer
* Apache Maven

## Build the Demo

```bash
git clone git@github.com:bootique-examples/bootique-jetty-demo.git
cd bootique-jetty-demo/jetty-servlets-filters-demo
mvn clean package
```

## Run the Demo

Check the options available in your app:

```bash
java -jar target/jetty-servlets-filters-demo-X.XX.jar
    
    Option                                              Description
    ------                                              -----------    
    -c yaml_location, --config=yaml_location            Specifies YAML config location, which can be a file path or a URL.

    -h, --help                                          Prints this message.

    -H, --help-config                                   Prints information about application modules and their configuration
                                                            options.
                                                            
    -s, --server                                        Starts Jetty server.
```

Run the server with the provided `config.yml` file:

```bash    
java -jar target/jetty-servlets-filters-demo-X.XX.jar --server --config=config.yml
```

Trying opening the following URLs: 

* [http://127.0.0.1:9999/myapp/ss2](http://127.0.0.1:9999/myapp/ss2) should succeed
* [http://127.0.0.1:9999/myapp/s1?p1=1&p2=2](http://127.0.0.1:9999/myapp/s1?p1=1&p2=2) should succeed
* [http://127.0.0.1:9999/myapp/s2](http://127.0.0.1:9999/myapp/s2) should fail with HTTP 404, "servlet2" path specified in the code is overridden with `config.yml`




    
