package com.program.elearning.repository;

import java.util.ArrayList;
import java.util.List;

import com.program.elearning.entity.User;


public class UserRepositoryImpl implements UserRepository {

  private List<User> users;

  public UserRepositoryImpl() {
    users = new ArrayList<>();
  }

  @Override
  public List<User> findAll() {
    return this.users;
  }

  @Override
  public User findById(String id) {
    for (User user : users) {
      if (user.getId().equalsIgnoreCase(id)) {
        return user;
      }
    }
    return null;
  }

  @Override
  public boolean save(User user) {
    return this.users.add(user);
  }

  @Override
  public boolean delete(String id) {
    User user = this.findById(id);
    return this.users.remove(user);
  }

}
