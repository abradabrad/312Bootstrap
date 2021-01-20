package com.example.bootstrap.dao;

import com.example.bootstrap.model.Role;

public interface RoleDao {
    Role getRole(String role);
    void addRole(Role role);
}
