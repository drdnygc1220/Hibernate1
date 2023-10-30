package Repository;

import Config.HibernateUtils;
import Domain.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HotelRepository {
    //oturum açacagım bunun için tekrar tekrar kullancagımız için session field olarak aldık.

    private Session session;
    public void save(Hotel hotel){
        try {
            session= HibernateUtils.getSessionFactory().openSession();//opensession exceptıon fırlatır try-catch fırlatır
            //kalıcı hale getirmek için transaction ,degişiklik yapmak bunun için şart
            Transaction transaction=session.beginTransaction();
            session.save(hotel);//insert ınto

            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            //her koşulda yapılması gereken işi yap demek finally blogunda her türlü kapat.
            HibernateUtils.closeSession(session);
        }


    }
}
