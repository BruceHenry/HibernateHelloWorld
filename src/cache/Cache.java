package cache;

import inherent.Person;
import many_to_many.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class Cache {
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
        Movie movie = session.get(Movie.class, 1);
        System.out.println(movie.getActors());

        transaction.commit();
        session.close();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        movie = session.get(Movie.class, 1);
        System.out.println(movie.getActors());
    }
    @Test
    public void queryIterator() {
        Movie movie = session.get(Movie.class, 1);
        System.out.println(movie.getActors());

        Query query = session.createQuery("FROM many_to_many.Movie where id=1");
        Iterator<Movie> iterate = query.iterate();
        while (iterate.hasNext())
            System.out.println(iterate.next());
    }
}
