package com.aston.players.repository;

import com.aston.players.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User");
        List<User> users = (ArrayList<User>) query.getResultList();
        session.close();
        return users;
    }

    public User getUserByID(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User u where u.id=:userId");
        query.setParameter("userId", id);
        User user = (User) query.getSingleResult();
        session.close();
        return user;
    }
}

