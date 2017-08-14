package session;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();		

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();


//		News news =session.get(News.class, 16);
//		System.out.println(news);

//		News news2 =session.get(News.class, 16);
//		System.out.println(news2);
//		System.out.println(news.equals(news2));

		//delete testing
//		session.delete(news);
//		System.out.println(news);

		//evict testing
//		News news3 =session.get(News.class, 17);
//		news.setTitle("Java");
//		news3.setTitle("Java");
//		session.evict(news);

		News news = new News("Java","BH2",new Date(new java.util.Date().getTime()));
		InputStream stream = new FileInputStream("world_of_warcraft.png");
		Blob image = Hibernate.getLobCreator(session).createBlob(stream,stream.available());
		news.setImage(image);
		session.save(news);

		News news2=session.get(News.class,3);
		System.out.println(news2);
		Blob image2 = news2.getImage();
		InputStream stream2 = image2.getBinaryStream();
		System.out.println(stream2.available());


		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println(connection);
			}
		});




		transaction.commit();
		session.close();


		sessionFactory.close();
	}
}
