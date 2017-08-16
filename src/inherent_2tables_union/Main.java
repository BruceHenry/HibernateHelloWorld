package inherent_2tables_union;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void insert() {// Two tables
        Student s = new Student();
        s.setName("Han");
        s.setSchool("WPI");

        Person p = new Person();
        p.setName("BaoHan");

        session.save(p);
        session.save(s);
    }

    @Test
    public void query(){
        List<Person> persons = session.createQuery("FROM inherent_2tables_union.Person").list();
        System.out.println(persons.size());

        List<Student> students = session.createQuery("FROM inherent_2tables_union.Student ").list();//WHERE type=student
        System.out.println(students.size());

    }

}