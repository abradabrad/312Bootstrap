package com.example.springboot.dao;

import com.example.springboot.model.Role;

public interface RoleDao {
    Role getRole(String role);
    void addRole(Role role);
}
