package com.example.bootstrap.dao;

import org.hibernate.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Repository;
import com.example.bootstrap.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


   @PersistenceContext
    private EntityManager entityManager;

    //@Autowired
    //public void setSessionFactory(SessionFactory sessionFactory) {
   //     this.sessionFactory = sessionFactory;
  //  }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {

        return entityManager.createQuery("select u from User as u").getResultList();
    }

     @Override
    public void add(User user) {
         //System.out.println(entityManager.isOpen());
        entityManager.persist(user);
    }

    @Override
    public User getById(int id) {
        User user = entityManager.find(User.class, id);
        //System.out.println(user);
        return user;
    }

    @Override
    public User getByName(String name) {
        Query query = (Query) entityManager.createQuery(
                "select u from User u where u.name = :name");
        query.setParameter("name", name);

        try {
            return (User) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public User getByLogin(String login) {
        Query query = (Query) entityManager.createQuery(
                "select u from User u where u.login = :login");
        query.setParameter("login", login);

        try {
            return (User) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.contains(user)
                ? user
                : entityManager.merge(user));
    }

    @Override
    public void edit(User user) {
        System.out.println(user);
       entityManager.merge(user);
        System.out.println(user);
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream()
                .map((role) -> role.getRole())
                .toArray(String[]::new);
        Collection<GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
