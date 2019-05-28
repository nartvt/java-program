package com.spring.program.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
  private Logger logger = LoggerFactory.getLogger(MainController.class);


  @Value("false")
  private boolean authorize;

  @RequestMapping(value = "/login")
  protected String login() {
    return redirectLogin();
  }

  @RequestMapping(value = "/logout")
  protected String logout() {
    return redirectLogout();
  }

  @RequestMapping(value = "/logoutSuccess", method = RequestMethod.POST)
  protected String logoutSuccess() {
    return redirectLogin();
  }

  private String redirectLogin() {

    String url;
    if (authorize) {
      url = "redirect:/authorize/login";
    } else {
      url = "redirect:/authorize/login";
    }
    logger.info("logoutSuccess url: {} ", url);
    return url;
  }

  private String redirectLogout() {
    String url;
    if (authorize) {
      url = "redirect:/authorize/logout";
    } else {
      url = "redirect:/authorize/logout";
    }
    logger.info("redirectLogout url: {} ", url);
    return url;
  }
}
