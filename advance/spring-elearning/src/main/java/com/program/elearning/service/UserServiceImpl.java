package com.program.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.program.elearning.entity.User;
import com.program.elearning.repository.UserRepository;

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
