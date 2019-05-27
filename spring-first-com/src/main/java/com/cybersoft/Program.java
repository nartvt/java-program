package com.cybersoft;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cybersoft.configuration.BeansConfig;
import com.cybersoft.controller.ContactController;
import com.cybersoft.controller.HomeController;
import com.cybersoft.service.EmailService;
import com.cybersoft.service.FacebookService;
import com.cybersoft.service.MessageService;

public class Program {
  
  public static void main(String [] args) {
    
//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//    
//    MessageService service = (MessageService) context.getBean("emailService");
//    
////    MessageService emailMessageService = new EmailService();
//    ContactController contactController = (ContactController) context.getBean("contactController");
//    contactController.setService(service);
//    HomeController homeController = (HomeController) context.getBean("homeController");
//    
//    contactController.sendMessage();
//    homeController.sendMessage();
    
    // config with java code
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
    
    HomeController homeController = context.getBean(HomeController.class);    
    homeController.sendMessage();
    
    
   
    
  }
}
