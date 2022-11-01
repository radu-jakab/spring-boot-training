# Spring Boot Training
This project serves as training material for Spring Boot v3.0
Prvious knowledge of Java and some toolkits (e.g.: git, maven/gradle) is assumed, but previous Spring and Spring Boot knowledge is not required.

The training is separated in basic and more advanced topics, to be used depending on the needs of the class.

That being said, this is by no means a comprehensive collection of everything Spring Boot can do.

## Pre-requisites
- use IntelliJ for and IDE if possible
- have Java 17, docker, maven, npm, git installed

- discuss HTTP, AOP, Java Reflection  
-- https://code.tutsplus.com/tutorials/http-the-protocol-every-web-developer-must-know-part-1--net-31177  
-- http://www.andrewewhite.net/wordpress/2010/03/17/aspectj-annotation-tutorial/  
-- https://www.sitepoint.com/java-reflection-api-tutorial/  

## The training case-study project
As a case study for the project, we will buld a bookstore backend system.
The requirements are presented in individual steps, starting with 00. Project Specs

- [ ] what the final application will look like
- [x] data structure
- [x] functional requirements

## Topics

### 01. Spring initializr
Create a project using https://start.spring.io
Select Maven packaging, Java language, Spring Boot 3.0.0, Java 17 and SPring Web dependency
Observe the console output

### 02. Hello World
The @Controller and @RestController annotation
Exposing our first API endpoint

### 03. Controllers
Layered architectures - rules and benefits
Layer-based vs module-based folder structure
Record classes
Setup lombok
Venue DTO, endpoints
Courier DTO, endpoints
Package scanning: convention vs configuration
Spring components: @Controller, @Service, @Repository

### 04. OpenAPI and Swagger-UI
Why OpenAPI; see also https://swagger.io/docs/specification/about/
Add `springdoc-openapi-starter-webmvc-ui` dependency
Check out http://localhost:8080/swagger-ui/index.html#/
Controlling the OpenAPI spec: `@Tag`, `@Operation`, `@ApiResponse`, `@Schema`

### 05. Services
Venue, Courier operations
Faked static objects
Rewrite controllers to use services
Postman

### 06. Entities and Repos
Add Spring Data JPA, H2 in-memory database
```        
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>8.0.0.Final</version>
        </dependency>
```
Change app configuration file to .yml
Configure H2 database
```
spring:
  jpa:
    show-sql: true
  h2:
    console:
      enabled: true
      path: '/h2-console'
  datasource:
    url: jdbc:h2:mem:spring-app;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driverClassName: org.h2.Driver
    username: sa
    password: 
    database-platform: org.hibernate.dialect.H2Dialect
```
Check startup logs warnings
```
HHH90000021: Encountered deprecated setting [javax.persistence.sharedCache.mode], use [jakarta.persistence.sharedCache.mode] instead
spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
```
Create Courier and Venue entities (if using String IDs, use @UuidGenerator)
Create Courier and Venue repos
Difficulty of mapping DTO to DO and back

### 07. Converters
Add mapstruct and annotation-processing support
```
			<plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven-compiler.version}</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.mapstruct</groupId>
                            <artifactId>mapstruct-processor</artifactId>
                            <version>${mapstruct.version}</version>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>${lombok.version}</version>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok-mapstruct-binding</artifactId>
                            <version>0.2.0</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
```
Create mappers for Venue and Courier
Rewrite Venue and Courier Services to use mappers and link to database repos

validation
- getOneMustExist
