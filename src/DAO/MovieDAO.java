package DAO;

import many_to_many.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDAO {
    public static void save (Movie movie){
        Session session = SessionUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(movie);

        transaction.commit();
//        session.close();//No need if using getCurrentSession()
        SessionUtil.getInstance().getSessionFactory().close();
    }
}
