package com.example.bootstrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.bootstrap.dao.RoleDao;
import com.example.bootstrap.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void addRole(Role role) {

        Role roleFromDB = roleDao.getRole(role.getRole());
        if (roleFromDB != null) {
            return ;
        }

        roleDao.addRole(role);
    }

}
