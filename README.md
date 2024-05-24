[![verify](https://github.com/bootique-examples/bootique-jetty-examples/actions/workflows/verify.yml/badge.svg)](https://github.com/bootique-examples/bootique-jetty-examples/actions/workflows/verify.yml)

# Bootique 3.x Jetty Examples

This is an example Bootique Jetty app.

Different Git branches contain example code for different versions of Bootique:

* [3.x](https://github.com/bootique-examples/bootique-jetty-examples/tree/3.x)
* [2.x](https://github.com/bootique-examples/bootique-jetty-examples/tree/2.x)
* [1.x](https://github.com/bootique-examples/bootique-jetty-examples/tree/1.x)

## Prerequisites

To build and run the project, ensure you have the following installed on your machine:

* Java 11 or newer
* Maven

and then follow these steps:

## Checkout
```
git clone git@github.com:bootique-examples/bootique-jetty-examples.git
cd bootique-jetty-examples
```

## Build, test and package

Run the following command to build the code, run the tests and package the app:
```
mvn clean package
```
Notice, how the tests started Jetty on the spot on a random port and executed real requests.

## Run

The following command prints a help message with supported options:
```bash  
java -jar target/bootique-jetty-examples-3.0.jar
```

```  
NAME
      bootique-jetty-examples-3.0.jar

OPTIONS
      -c yaml_location, --config=yaml_location
           Specifies YAML config location, which can be a file path or a URL.

      -h, --help
           Prints this message.

      -H [prefix], --help-config[=prefix]
           Prints information about application modules and their configuration
           options. Optionally, you can provide a 'prefix' argument to print only
           the specified config.

      -s, --server
           Starts Jetty server.
```

Start the server with the `-s` (`--server`) command:
```bash
java -jar target/bootique-jetty-examples-3.0.jar -s
```

Go to http://localhost:8080/ and you should see an HTML page served from Jetty, with links to the URLs served via 
"dynamic" servlets and filters.