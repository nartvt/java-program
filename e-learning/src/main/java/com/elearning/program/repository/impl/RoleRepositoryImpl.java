package com.elearning.program.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.elearning.program.entity.Role;
import com.elearning.program.repository.RoleRepository;

public class RoleRepositoryImpl implements RoleRepository {

  private List<Role> roles;

  public RoleRepositoryImpl() {
    roles = new ArrayList<Role>();
  }

  @Override
  public List<Role> findAll() {
    return this.roles;
  }

  @Override
  public Role findById(String id) {
    for (Role role : roles) {
      if (role.getId().equalsIgnoreCase(id)) {
        return role;
      }
    }
    return null;
  }

  @Override
  public boolean save(Role role) {
   return this.roles.add(role);
  }

  @Override
  public boolean delete(String id) {
  Role role = this.findById(id);
    return this.roles.remove(role);
  }

}
