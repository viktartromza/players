package com.aston.players.repository;

import com.aston.players.config.HibernateSessionFactoryUtil;
import com.aston.players.model.domain.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryHibernate {
    public List<User> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users= (List<User>) session.createQuery("FROM User").list();
        session.close();
        return users;
    }
}
