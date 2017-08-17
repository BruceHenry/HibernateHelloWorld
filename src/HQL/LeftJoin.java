package HQL;

import many_to_many.Actor;
import many_to_many.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LeftJoin {
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void tearDown() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    @Test
    public void leftJoinFetch() {
        String hql = "FROM many_to_many.Movie m left join fetch m.actors";
        Query query = session.createQuery(hql);
        List<Movie> list = query.list();
        System.out.println(list);
        System.out.println(list.get(0).getActors());//No need to SELECT again
    }

    @Test
    public void leftJoin() {
        String hql = "FROM many_to_many.Movie m left join  m.actors";
        Query query = session.createQuery(hql);
        List list = query.list();
        System.out.println(list.get(0));//A Object array, [0]=Movie, [1]=Actor

        hql = "SELECT m FROM many_to_many.Movie m left join  m.actors";
        query = session.createQuery(hql);
        list = query.list();
        System.out.println(list.get(0));//A Movie object

    }
}
