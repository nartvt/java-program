package com.elearning.program.repository.impl;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.UUID;

import org.springframework.stereotype.Repository;
=======
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d

import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;

<<<<<<< HEAD
@Repository
=======
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d
public class UserRepositoryImpl implements UserRepository {

  private List<User> users;

  public UserRepositoryImpl() {
    users = new ArrayList<>();
<<<<<<< HEAD
    User user = new User();
    user.setId("T001");
    user.setEmail("tranvantai0011@gmail.com");
    user.setFullname("Tran Van Tai");
    user.setPassword("tranvantai");
    user.setPersonType("CEO");
    user.setAvatar("avatar");
    user.setPhone("01223246232");
    user.setAddress("1 Thanh Loc, Quan 12");
    user.setWebsite("voz.com.vn");
    user.setFacebook("facebook.com");
    user.setRoleId("R01");
    users.add(user);
=======
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d
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
<<<<<<< HEAD
  public boolean save(User user) {    
=======
  public boolean save(User user) {
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d
    return this.users.add(user);
  }

  @Override
  public boolean delete(String id) {
    User user = this.findById(id);
<<<<<<< HEAD
    return users.remove(user);
  }

  @Override
  public boolean update(User user) {
    for(User u:users) {
      if(u.getId().equalsIgnoreCase(user.getId())) {
        u.setEmail(user.getEmail());
        u.setFullname(user.getFullname());
        u.setPassword(user.getPassword());
        u.setPassword(user.getPassword());
        u.setPersonType(user.getPersonType());
        u.setAvatar(user.getAvatar());
        u.setPhone(user.getPhone());
        u.setAddress(user.getAddress());
        u.setWebsite(user.getWebsite());
        u.setFacebook(user.getFacebook());
        u.setRoleId(user.getRoleId());
        return true;
        
      }
    }
    return false;
=======
    return this.users.remove(user);
>>>>>>> 8630ea7178b6a2bc94086834c16c1277a1cd101d
  }

}
