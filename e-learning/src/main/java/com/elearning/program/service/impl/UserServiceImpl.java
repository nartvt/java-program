package com.elearning.program.service.impl;

import java.util.List;
<<<<<<< HEAD
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d

import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;
import com.elearning.program.service.UserService;

<<<<<<< HEAD
@Service
=======
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public boolean save(User user) {
<<<<<<< HEAD
    user.setId(UUID.randomUUID().toString());
    return this.userRepository.save(user);
=======
   return this.userRepository.save(user);
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d
  }

  @Override
  public User findById(String id) {
    return this.userRepository.findById(id);
  }

<<<<<<< HEAD
  @Override
  public boolean delete(String id) {
   return userRepository.delete(id);
  }

  @Override
  public boolean update(User user) {
    return userRepository.update(user);
  }

=======
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d
}
