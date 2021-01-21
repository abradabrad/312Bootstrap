package com.example.bootstrap.controller;


import com.example.bootstrap.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.bootstrap.model.User;
import com.example.bootstrap.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin")

public class AdminController {
    private UserService userService;


    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("usersList", userService.allUsers());
        return "admin/allUsers";
    }



    @PostMapping("/edit/{id}")
    public String editUser(@RequestParam("id") int id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "secondName") String secondMame,
                             @RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password,
                             @RequestParam("role") String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(userService.getRoleByName(roles));
        }
        System.out.println(roleSet);
        userService.edit(new User(id, name, secondMame, login, password, roleSet));
        System.out.println(role);
        return "redirect:/admin";
    }
   // public String editUser(@ModelAttribute("user") User user) {
        //System.out.println(user + " editing");
      //  userService.edit(user);
      //  System.out.println(user + " edit");
      //  return "redirect:/admin";
  //  }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "admin/addPage";
    }

    @PostMapping(value = "/add")
    public String addNewUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "secondName") String secondMame,
                             @RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password,
                             @RequestParam("role") String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(userService.getRoleByName(roles));
        }
        System.out.println(roleSet);
        userService.add(new User(name,secondMame,login,password,roleSet));
        System.out.println(role);
        return "redirect:/admin";
    }

  /*  @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }*/

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/admin";
    }


}
