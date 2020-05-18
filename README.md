# Call Center simulator

This project built on Quarkus leveraging Artemis ActiveMQ message broker. 
It has a simple structure to demonstrate Producer-Consumer communication through the message queue.

The application has CallGenerator which puts messages into a queue with the interval. 
Each call should be resolved with CallCenterService. 
To resolve a call it needs to solve the simple equation: x+2y=[caller request]. 
All messages processed asynchronously with the ThreadPool which is configured to 10 by default.

## Pre-requirements 

To run this project, you have to run Artemis ActiveMQ first.
There are two scripts which could help you with the setup located in `/ArtemisInit` folder:

```
/docker_init.sh
```
```
/kube_init.sh
```

## Configuration

Please configure application with `application.properties` file. 

```
amqp-host=localhost
amqp-port=30672
```

## Running

You can run project from console with: `./gradlew quarkusDev`.
The application prints the Thread name and Solution time in stdout.
