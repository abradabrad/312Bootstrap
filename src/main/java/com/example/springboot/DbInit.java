package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.springboot.model.Role;
import com.example.springboot.model.User;
import com.example.springboot.service.RoleService;
import com.example.springboot.service.UserService;


@Component
public class DbInit {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DbInit(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        //добавляем в БД две роли
        Role roleUser = new Role(1L, "ROLE_USER");
        Role roleAdmin = new Role(2L, "ROLE_ADMIN");

        roleService.addRole(roleUser);
        roleService.addRole(roleAdmin);


        //и двоих пользователей
        User user = new User("", "", "user", "", null);
        userService.add(user);

        User admin = new User("","", "admin", "", null);
        admin.setAdmin("ROLE_ADMIN");

        userService.add(admin);
    }

}
