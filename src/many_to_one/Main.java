package many_to_one;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
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
    public void manyToOne(){
        Customer customer = new Customer("AA");
        MyOrder order1 = new MyOrder("001");
        MyOrder order2 = new MyOrder("002");

        order1.setCustomer(customer);
        order2.setCustomer(customer);

        session.save(customer);
        session.save(order1);
        session.save(order2);
    }

    @Test
    public void get(){
        MyOrder order = session.get(MyOrder.class, 1);
        System.out.println(order.getName());
        System.out.println(order);
    }

    @Test
    public void update(){
        MyOrder order = session.get(MyOrder.class, 1);
        order.getCustomer().setName("ABC");
    }

    @Test
    public void delete(){
        //Error!!! Cascade!
        MyOrder order = session.get(MyOrder.class,2);
        session.delete(order.getCustomer());
    }

}