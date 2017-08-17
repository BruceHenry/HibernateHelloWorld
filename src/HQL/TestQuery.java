package HQL;

import inherent.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestQuery {

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
        String hql = "FROM inherent.Person p where id=? and name=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, 3).setParameter(1, "BaoHan");

        List<Person> list = query.list();
        for (Person p : list)
            System.out.println(p);
    }

    @Test
    public void NamedParameter() {
        String hql = "FROM inherent.Person where id=:id and name=:name";
        Query query = session.createQuery(hql);

        query.setParameter("id", 3).setParameter("name", "BaoHan");

        List<Person> list = query.list();
        for (Person p : list)
            System.out.println(p);
    }

    @Test
    public void NamedQuery() {
        Query query = session.getNamedQuery("all");//<query name="all"><![CDATA[from inherent.Person]]></query>
        List<Person> list = query.list();
        System.out.println(list);
    }

    @Test
    public void fieldQuery(){
        String hql = "SELECT id,name FROM inherent.Person";
        Query query = session.createQuery(hql);

        List<Object[]> result = query.list();
        //List<Person> result = query.list();//need constructor with related fields
        for(Object[] o:result)
            System.out.println(Arrays.asList(o));

    }



    @Test
    public void page() {
        String hql = "FROM inherent.Person";
        Query query = session.createQuery(hql);

        int pageNum = 3;//which page
        int pageSize = 2;

        List<Person> list = query.setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageSize).list();
        System.out.println(list);
    }


}



