package com.example.bootstrap.dao;

import com.example.bootstrap.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
    User getByName(String name);
    User getByLogin(String login);
}
