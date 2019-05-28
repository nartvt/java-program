package com.program;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.program.configuration.BeansConfig;
import com.program.controller.ContactController;
import com.program.controller.HomeController;
import com.program.service.EmailService;
import com.program.service.FacebookService;
import com.program.service.MessageService;

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
