package session;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();		

		Session session = sessionFactory.openSession();
		Transaction transction = session.beginTransaction();


		News news =session.get(News.class, 10);
		System.out.println(news);

		News news2 =session.get(News.class, 10);
		System.out.println(news2);
		System.out.println(news.equals(news2));


		transction.commit();


		session.close();
		sessionFactory.close();
	}
}
