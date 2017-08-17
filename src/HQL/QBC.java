package HQL;

import many_to_many.Movie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QBC {
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
    public void basic() {
        Criteria criteria = session.createCriteria(Movie.class);
        criteria.add(Restrictions.eq("id", 1));
        Movie movie = (Movie) criteria.uniqueResult();
        System.out.println(movie);
    }

    @Test
    public void condition() {
        //And
        Conjunction conjunction = Restrictions.conjunction();
        conjunction.add(Restrictions.gt("id", 0)).add(Restrictions.eq("name", "007"));

        //Or
        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.eq("id", 1)).add(Restrictions.eq("name", "007"));

        Criteria criteria = session.createCriteria(Movie.class);
        criteria.add(conjunction).add(disjunction);

        System.out.println(criteria.list());
    }

    @Test
    public void projection() {
        Criteria criteria = session.createCriteria(Movie.class);
        criteria.setProjection(Projections.max("id"));
        System.out.println(criteria.uniqueResult());
    }

    @Test
    public void sort() {
        Criteria criteria = session.createCriteria(Movie.class);
        criteria.addOrder(Order.desc("id"));
        System.out.println(criteria.list());
    }
}
