# configurex-test

Try the app by visiting [configurex-test-msausner.c9users.io](https://configurex-test-msausner.c9users.io/).

## How to setup server on a local machine

First compile dependencies into a jar using Maven:

```
mvn package
```

Then start up the web server:

```
java -jar target/configurex-test-*.jar
```

You can access the app by going to `localhost:8080`.

## How It Works

The Spring framework is used as the base for the web-server. Bootstrap is used 
for styling the app components(input field, button, etc.) and jQuery is used to 
perform the POST request to the server.

`FibController.java` holds the class responsible for calculating and returning the next
fibonacci number based on the user input. `fibformhandler.js` sends a POST
request to the route mapped by the fib controller and inserts an alert with the correct 
output. Inserts an error message if input cannot be cast to an integer.
