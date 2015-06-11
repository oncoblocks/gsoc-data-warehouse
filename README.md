# Magpie test branch
The branch contains preliminary code for the Magpie project.

## Updates

## About
This project is built with [Spring Boot][spring boot], [Spring Data][spring data mongo], and[MongoDB][mongo].


[spring boot]: http://projects.spring.io/spring-boot/
[spring data mongo]: http://projects.spring.io/spring-data-mongodb/
[mongo]: https://www.mongodb.org/

## Prerequisite
Running this application requires Maven and MongoDB. 

## Running the application

First start up the MongoDB daemon:

    mongod

Build the application as follows.

    mvn clean package
    
Then import test data into MongoDB by executing the following in the project home directory:
    
    sh scripts/import_data.sh
    
Running the JAR package will automatically start tomcat at `http://localhost:8080`.

    java -jar target/magpie1.0.jar
    
