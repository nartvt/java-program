package com.elearning.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elearning.program.entity.User;
import com.elearning.program.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public String index(ModelMap model) {
    List<User> users = userService.findAll();
    model.addAttribute("users", users);
    return "userList";
  }

  @GetMapping("/add")
  public String add(@ModelAttribute("user") User user, ModelMap model) {
    userService.save(user);
    model.addAttribute("user", user);
    return "userAdd";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") String id, ModelMap model) {
    User user = userService.findById(id);
    model.addAttribute("users", user);
    return "userEdit";
  }

}
