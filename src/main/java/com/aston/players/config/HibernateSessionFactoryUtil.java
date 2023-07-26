package com.aston.players.config;

import com.aston.players.model.domain.Comment;
import com.aston.players.model.domain.Game;
import com.aston.players.model.domain.User;
import com.aston.players.model.domain.Wallet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Comment.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Game.class);
                configuration.addAnnotatedClass(Wallet.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
