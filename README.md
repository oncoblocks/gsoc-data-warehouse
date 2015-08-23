# Magpie test branch
This a prototype of a data warehouse for storing processed genomic data such as mutation and copy number variation (CNV) data and their annotation information. Currently the prototype models CNV data by gene.

## Benchmarking
Preliminary benchmarking on query performance has been performed. See `/docs/benchmark` for details.

## About
This project is built with [Spring Boot][spring boot], [Spring Data][spring data mongo], and[MongoDB][mongo].

## Prerequisite
Running this application requires Maven and MongoDB. 

## Running the application

First start up the MongoDB daemon:

    mongod

Build the application as follows.

    mvn clean package
    
Then import all test data into MongoDB by executing scripts, execute the following script

    sh scripts/import_data.sh
    
while in the root directory of the project (where pom.xml resides).
    
Running the JAR package will automatically start tomcat at `http://localhost:8080`.

    java -jar target/magpie1.0.jar
    
Currently the prototype implements loading and querying of copy number variation data by gene and associated annotation data such as gene, cell line, and study. JSON specifications of these data types can be found in the `/docs/data-model` directory.

## Loading data
To load sample data to the databases, run scripts in the `/scripts/` folder. The `import_data.sh` script imports all data while others import individual data types.

## Queries
REST style queries are implemented for CNV data. Suppose the application is configured in Spring Boot to run on `localhost` and port 8080, then

    http://localhost:8080/copynumbergenecentric/all
    
returns a JSON of all CNV data. 

Criteria on fields can be specified as follows

    http://localhost:8080/copynumbergenecentric?geneId=1&sampleId=HCT15_LARGE_INTESTINE
    
To only return certain fields, the following query can be issued

     http://localhost:8080/copynumbergenecentric?geneId=1&fields=geneID,copyNumberValue
    
Sorting is supported by using the following format

    http://localhost:8080/copynumbergenecentric?geneId=1&value=lt:0&sort=sampleId:asc
    
Currently Paging is supported only for retrieving all records as follows

    http://localhost:8080/copynumbergenecentric/viewpage?page=1&size=10&sort=sampleId:asc

    
[spring boot]: http://projects.spring.io/spring-boot/
[spring data mongo]: http://projects.spring.io/spring-data-mongodb/
[mongo]: https://www.mongodb.org/