package com.example.bootstrap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.bootstrap.model.User;
import com.example.bootstrap.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getIndex(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Spring CRUD Security app");
        messages.add("Login for continue ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model, Authentication authentication) {
        System.out.println(authentication);
        if (authentication.isAuthenticated()){
            String login = authentication.getName();
            System.out.println(login);
            User user = (User) userService.loadUserByUsername(login);
            model.addAttribute("user", user);
        }
    return "user/userPage";
    }







}

