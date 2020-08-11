package com.program.elearning.service;

import java.util.List;

import com.program.elearning.entity.User;

public interface UserService {
  List<User> findAll();
  boolean save(User user);
  User findById(String id);

}
