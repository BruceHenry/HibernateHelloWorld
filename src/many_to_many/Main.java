package many_to_many;

import one_to_one.Department;
import one_to_one.Department2;
import one_to_one.Manager;
import one_to_one.Manager2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Main {
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
    public void insert() {
        Movie movie = new Movie();
        movie.setName("007");
        Movie movie2 = new Movie();
        movie2.setName("Batman");

        Actor actor = new Actor();
        actor.setName("James");
        Actor actor2 = new Actor();
        actor2.setName("Morgen");

        movie.getActors().add(actor);
        movie.getActors().add(actor2);
        movie2.getActors().add(actor);
        movie2.getActors().add(actor2);

        session.save(actor);
        session.save(movie);
        session.save(actor2);
        session.save(movie2);
    }

    @Test
    public void get(){
        Movie movie = session.get(Movie.class,1);//Only SELECT FROM MOVIE
        System.out.println(movie.getName());
        System.out.println(movie.getActors());// SELECT FROM ACT inner join ACTOR
    }

    @Test
    public void insert2() {
        Movie2 movie = new Movie2();
        movie.setName("007");
        Movie2 movie2 = new Movie2();
        movie2.setName("Batman");

        Actor2 actor = new Actor2();
        actor.setName("James");
        Actor2 actor2 = new Actor2();
        actor2.setName("Morgen");

        movie.getActors().add(actor);
        movie.getActors().add(actor2);
        movie2.getActors().add(actor);
        movie2.getActors().add(actor2);

        actor.getMovies().add(movie);
        actor.getMovies().add(movie2);
        actor2.getMovies().add(movie);
        actor2.getMovies().add(movie2);


        session.save(actor);
        session.save(movie);
        session.save(actor2);
        session.save(movie2);
    }
}