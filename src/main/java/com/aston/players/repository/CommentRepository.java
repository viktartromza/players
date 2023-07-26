package com.aston.players.repository;

import com.aston.players.config.HibernateSessionFactoryUtil;
import com.aston.players.model.domain.Comment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    public Comment findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Comment.class, id);
    }

    public void save(Comment comment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(comment);
        tx1.commit();
        session.close();
    }

    public List<Comment> findAll() {
        List<Comment> users = (List<Comment>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Comment").list();
        return users;
    }
}
