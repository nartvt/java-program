package com.program.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.program.controller.ContactController;
import com.program.controller.HomeController;
import com.program.service.EmailService;
import com.program.service.FacebookService;

@Configuration
public class BeansConfig {

  @Bean
  public EmailService emailService() {
    return new EmailService();
  }
  @Bean
  public FacebookService facebookService() {
    return new FacebookService();
  }
  @Bean
  public HomeController homeController() {
    return new HomeController(emailService());
  }
  
  @Bean
  public ContactController contactController() {
    ContactController contactController = new ContactController();
    contactController.setService(emailService());
    return contactController;
    
  }
}
