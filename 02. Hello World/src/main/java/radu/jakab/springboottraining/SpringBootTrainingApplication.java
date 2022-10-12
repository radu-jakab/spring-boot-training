package radu.jakab.springboottraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// configuration annotation that marks this as a runnable Spring Boot application
@SpringBootApplication
// tells Spring this class defines REST endpoints
@RestController
public class SpringBootTrainingApplication {

    // Spring runs as a standalone java application, started using a "main" method
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTrainingApplication.class, args);
    }

    // maps HTTP calls to "/hello" to the execution of this method
    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
