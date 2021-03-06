package com.example.bootstrap.service;

import com.example.bootstrap.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.bootstrap.dao.UserDao;
import com.example.bootstrap.model.Role;
import com.example.bootstrap.model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        User userFromDB = userDao.getByLogin(user.getLogin());
        if (userFromDB != null) {
            System.out.println("user in base, go out");
            return;
        }
        System.out.println("create user");
        System.out.println(user);
        System.out.println(user+ " after get");
        userDao.add(user);
        System.out.println(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {

        userDao.edit(user);
    }

    //private User get(User user) {
     //   Set<Role> roleSet = new HashSet<>();
     //   roleSet.add(new Role(1L, "ROLE_USER"));
     //  if (user.getAdmin() != null && user.getAdmin().equals("ADMIN")) {
     //       roleSet.add(new Role(2L, "ROLE_ADMIN"));
     //   }
      //  user.setRoles(roleSet);
      //  System.out.println(user + " in get");
      //  return user;
   // }

    @Override
    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }

    // «Пользователь» – это просто Object. В большинстве случаев он может быть
    //  приведен к классу UserDetails.
    // Для создания UserDetails используется интерфейс UserDetailsService,
    // с единственным методом:


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: " + username);
        }
        return user;
    }

    @Override
    public Role getRoleByName(String role) {
        return roleDao.getRole(role);
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getRole()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
