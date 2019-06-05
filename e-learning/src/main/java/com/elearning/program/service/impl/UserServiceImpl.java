package com.elearning.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;
import com.elearning.program.service.UserService;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public boolean save(User user) {
   return this.userRepository.save(user);
  }

  @Override
  public User findById(String id) {
    return this.userRepository.findById(id);
  }

}
