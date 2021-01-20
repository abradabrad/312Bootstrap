package com.example.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.bootstrap.model.Role;
import com.example.bootstrap.model.User;
import com.example.bootstrap.service.RoleService;
import com.example.bootstrap.service.UserService;


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
        User user = new User("", "", "user", "123", null);
        userService.add(user);

        User admin = new User("","", "admin", "123", null);
        admin.setAdmin("ROLE_ADMIN");

        userService.add(admin);
    }

}
