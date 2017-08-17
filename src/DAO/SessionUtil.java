package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static SessionUtil instance = new SessionUtil();
    private SessionFactory sessionFactory;

    private SessionUtil() {
        Configuration configuration = new Configuration().configure();
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionUtil getInstance() {
        return instance;
    }

    public SessionFactory getSessionFactory(){
        return instance.sessionFactory;
    }
    public Session getSession(){
        return instance.sessionFactory.getCurrentSession();
    }
}
