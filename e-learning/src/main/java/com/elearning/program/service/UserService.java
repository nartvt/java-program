package com.elearning.program.service;

import java.util.List;

import com.elearning.program.entity.User;

public interface UserService {
  List<User> findAll();
  boolean save(User user);
  User findById(String id);
<<<<<<< HEAD
  
  boolean delete(String id);
  boolean update(User user);
=======

>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d
}
