package Repository;

import Config.HibernateUtils;
import Domain.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HotelRepository {
    //oturum açacagım bunun için tekrar tekrar kullancagımız için session field olarak aldık.

    private static Session session;



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

    public Hotel findById(Long id) {
        try {
            session= HibernateUtils.getSessionFactory().openSession();//opensession exceptıon fırlatır try-catch fırlatır
            //getirme işlemi oldugu için Transactıon kullanmıyoruz.
            return session.get(Hotel.class,id);//dogrudan döndür dedik return için

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            //her koşulda yapılması gereken işi yap demek finally blogunda her türlü kapat.
            HibernateUtils.closeSession(session);
        }
        return null;

    }
    public static List<Hotel> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Hotel> hotelList = session.createQuery("FROM Hotel", Hotel.class).getResultList();
            //HQL de SELECT yazmak zorunda degiliz ,class ismi yazılack
            return hotelList;
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}
