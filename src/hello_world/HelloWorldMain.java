package hello_world;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HelloWorldMain {
	public static void main(String[] args) {
		// 1. SessionFactory Object
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();		

		// 2. Session Object
		Session session = sessionFactory.openSession();
		// 3.Turn on transaction
		Transaction transaction = session.beginTransaction();
		// 4. Save
		News news = new News("Java","BH2",new Date(new java.util.Date().getTime()));
		news.setId(888);
		session.save(news);
		//5.Hand over transaction
		transaction.commit();
		//6. Close session
		session.close();
		//7. Close sessionFactory
		sessionFactory.close();
	}
}
