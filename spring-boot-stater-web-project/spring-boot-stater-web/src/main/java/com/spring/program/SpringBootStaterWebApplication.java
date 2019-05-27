package com.spring.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class SpringBootStarterWebApplication.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.spring.program")
public class SpringBootStaterWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootStaterWebApplication.class, args);
  }

}
