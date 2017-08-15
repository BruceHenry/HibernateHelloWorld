package one_to_one;

import one_to_many.Customer;
import one_to_many.MyOrder;
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
        Department dept = new Department();
        dept.setName("DEPT-AA");

        Manager manager = new Manager();
        manager.setName("M-AA");

        dept.setManager(manager);
        manager.setDept(dept);

        session.save(manager);
        session.save(dept);
    }

    @Test
    public void get() {
        Department dept = session.get(Department.class, 1);
        System.out.println(dept.getName());//Only SELECT FROM DEPARTMENT
        System.out.println(dept.getManager());//SELECT FROM MANAGER

        Manager manager = session.get(Manager.class, 1);//SELECT with left outer join
        System.out.println(manager.getName());
    }

    @Test
    public void insert2() {
        Department2 dept = new Department2();
        dept.setName("DEPT-BB");

        Manager2 manager = new Manager2();
        manager.setName("M-BB");

        dept.setManager(manager);
        manager.setDept(dept);

        session.save(dept);
        session.save(manager);
    }

    @Test
    public void get2() {
        Department2 dept = session.get(Department2.class, 1);
        System.out.println(dept.getName());//Only SELECT FROM DEPARTMENT
        System.out.println(dept.getManager());//SELECT FROM MANAGER

        Manager2 manager = session.get(Manager2.class, 2);//SELECT with left outer join
        System.out.println(manager.getName());


    }
}