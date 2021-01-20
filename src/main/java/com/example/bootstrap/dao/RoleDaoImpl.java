package com.example.bootstrap.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.example.bootstrap.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRole(String role) {
        Query q = (Query) entityManager.createQuery(
                "select u from Role u where u.role = :role");
        q.setParameter("role", role);

        try {
            return (Role) q.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

}
