package com.cybersoft.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cybersoft.controller.ContactController;
import com.cybersoft.controller.HomeController;
import com.cybersoft.service.EmailService;
import com.cybersoft.service.FacebookService;

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
