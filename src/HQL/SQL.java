package HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class SQL {
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
    public void test() {
        Query query = session.createNativeQuery("SELECT * FROM department");
        List<Object[]> list = query.list();
        for(Object o: list.get(0))//every column
            System.out.println(o);

        //insert, delete, update
        //query.executeUpdate();

    }
}
