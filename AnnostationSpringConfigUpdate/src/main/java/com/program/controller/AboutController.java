package com.program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AboutController {

  @GetMapping("/about")
  public String about() {
    //System.out.println(name);
    return "about";
  }
}
