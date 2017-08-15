package one_to_many;

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
    public void OneToMany() {
        Customer customer = new Customer("AA");
        MyOrder order1 = new MyOrder("001");
        MyOrder order2 = new MyOrder("002");

        order1.setCustomer(customer);
        order2.setCustomer(customer);

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        session.save(customer);
        session.save(order1);
        session.save(order2);
    }

    @Test
    public void get() {
        MyOrder order = session.get(MyOrder.class, 1);
        System.out.println(order.getCustomer().getOrders());
    }

    @Test
    public void multipleGet() {
        Customer customer = session.get(Customer.class, 1);
        System.out.println(customer);//One SELECT for Customer
        System.out.println(customer.getOrders().getClass());//SELECT for order
    }
}