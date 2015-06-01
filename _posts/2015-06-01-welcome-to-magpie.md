---
layout: post
author: "Will Oemler"
title: "Welcome to Project Magpie"
date: 2015-06-01 18:00:00
permalink: "/welcome-to-magpie"
tags: news
---
Welcome to Magpie, the [Oncoblocks][ob-home] data warehouse project for Google Summer of Code 2015. Our goal is to design a framework for an open source, scalable, and modular data warehouse with REST API for processed genomic data. With these tools, we hope to help solve the problems of data fragmentation, redundancy, and ease-of-access that people who work with genomic data know all too well. Combined with the other projects in the [Oncoblocks platform][ob-gh], we hope to provide a valuable free resource to cancer researchers worldwide.

This project will consist of several components:

#### Data Model
A JSON-formatted data model representing all of the data types captured in the warehouse. This will cover common discrete and continuous data formats, such as gene expression and copy number data derived from various experimental platforms, as well as data annotations, such as samples, studies, and genomic features.

#### API Specification
[Swagger-formatted][swagger] API documentation, detailing all of the resources and operations a basic Magpie implementation would be required to adhere to.  This would include URI formatting, query syntax, and JSON representations of returned and accepted data objects.

#### Demo implementation
A demo application developed in Java with the [Spring Framework][spring] and [MongoDB][mongo], to serve as an example implementation of the data warehouse.

With these resources, organizations can build their own Oncoblocks-compliant data warehouse (using their technology of choice) that integrates with the other [Oncoblocks tools][ob-gh], or use the demo implementation to get up-and-running fast.

Over the course of this summer, our selected student developer, Tewei Luo will be developing the code base and hatching Magpie into something we hope will help make a difference in cancer research. Keep an eye out here for his and other collaborators thoughts on the project.  You can find the latest source code for the project [here][mp-gh].

[ob-home]: http://oncoblocks.org
[ob-gh]: https://github.com/oncoblocks
[mp-gh]: https://github.com/oncoblocks/magpie
[swagger]: http://swagger.io/
[spring]: http://spring.io/
[mongo]: https://www.mongodb.org/
