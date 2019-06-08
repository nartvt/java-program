package com.program.elearning.admin.conttroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.program.elearning.entity.User;
import com.program.elearning.service.UserService;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public String index(ModelMap model) {
    model.addAttribute("users", userService.findAll());
    return "userList";
  }

  @GetMapping("add")
  public String add(ModelMap model) {
    model.addAttribute("user", new User());
    return "userAdd";
  }

  @PostMapping("add")
  public String add(@ModelAttribute("user") User user, ModelMap model) {
    userService.save(user);
    return "redirect:/admin/user";
  }

  @GetMapping("edit/{id}")
  public String edit(@PathVariable String id) {

    return "userEdit";
  }
}
