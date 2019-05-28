package com.program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.program.entity.Student;

@Controller
@RequestMapping("admin")
public class HomeController {

  // @RequestMapping(value = "/",method = RequestMethod.GET)
  @GetMapping("home")
  public String index(@RequestParam(value = "name", required = false, defaultValue = "TranVanTai") String name) {
    System.out.println(name);
    return "redirect:/about";
  }

  // @RequestMapping(value = "/",method = RequestMethod.GET)
  @GetMapping("/user")
  @ResponseBody
  public Student index2() {
  Student student = new Student(10,"Tai");
    return student;
  }

}
