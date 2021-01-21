package com.example.bootstrap.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "secondname")
    private String secondName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)

    private Set<Role> roles;

    @Transient
    private String admin;

    public User() {
    }

    public User(String name, String secondName, String login, String password) {
        this.name = name;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }

    public User(String name, String secondName, String login, String password, Set<Role> roles) {
        this.name = name;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public User(int id, String name, String secondMame, String login, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getRolesStr() {
        String rolesStr = null;
        rolesStr = roles.toString().replace('[', ' ').replace(']', ' ').trim();
        return rolesStr;
    }

    //public void setRolesStr(String[] rolesStr) {
   //     Set<Role> roles = null;
   //    roles.add(roles.ge);

  //  }


   // public void setRoles(Set<Role> roles) {
   //     this.roles = roles;
   // }
     public void setRoles(Set<Role> roles) {
         this.roles = roles;
    }



    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public boolean getIsAdmin() {
       System.out.println("Is Admin? "+roles);
       try {
           return roles.toString().contains("ROLE_ADMIN");
       } catch (NullPointerException exception) {
           System.out.println("Error " + roles);
           return false;
       }
    }


    @Override
    public String toString() {
        return "User {" +
                "Id='" + id + '\'' +
                "name='" + name + '\'' +
                ", second name='" + secondName + '\'' +
                ", login=" + login +
                ", pass=" + password +
                ", isAdmin=" + getIsAdmin() +
                ", role=" + roles +
                '}';
    }
}
