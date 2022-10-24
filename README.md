# Spring Boot Training
This project serves as training material for Spring Boot v3.0
Prvious knowledge of Java and some toolkits (e.g.: git, maven/gradle) is assumed, but previous Spring and Spring Boot knowledge is not required.

The training is separated in basic and more advanced topics, to be used depending on the needs of the class.

That being said, this is by no means a comprehensive collection of everything Spring Boot can do.

## Pre-requisites
- use IntelliJ for and IDE if possible
- have Java 17, docker, gradle, npm, git installed

- discuss HTTP, AOP, Java Reflection  
-- https://code.tutsplus.com/tutorials/http-the-protocol-every-web-developer-must-know-part-1--net-31177  
-- http://www.andrewewhite.net/wordpress/2010/03/17/aspectj-annotation-tutorial/  
-- https://www.sitepoint.com/java-reflection-api-tutorial/  

## The training case-study project
As a case study for the project, we will buld a bookstore backend system.
The requirements are presented in individual steps, starting with 00. Project Specs

- [ ] what the final application will look like
- [ ] data structure
- [x] functional requirements

## Topics

### 01. Spring initializr
Create a project using https://start.spring.io

### 02. Hello World
The @Controller and @RestController annotation
Exposing our first API endpoint

### 03. Controllers
Layer-based vs module-based folder structure
Record classes
Author, Book DTOs
Author, Book endpoints
Package scanning: convention vs configuration
Spring components: @Controller, @Service, @Repository

### 04. Services
Author, Book CRUD operations
Faked static objects
Rewrite controllers to use services
Postman



1 entity with unattached list of sub-entities
1 entity with list of owned sub-entities
sub-entities always link up to parent
1 many-to-many relation

order
	- client
	- courier
	- venue
	- owned: order products
