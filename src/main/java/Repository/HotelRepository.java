package Repository;

import Config.HibernateUtils;
import Domain.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

//transaction burada yapacagız
public class HotelRepository {
    //SessionFactor lazım:database oturum acmak için
    //hibernateUtils de method yaptık.
    private Session session;
    public void saveHotel(Hotel hotel){
        //session factor cagırılsın
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            session.save(hotel);

            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();//BU hataya sebep olan kodları yazdırmak için
        }finally {
            HibernateUtils.closeSession(session);// try-catch hangisinin içinde olursa olsun sessionı kapat.
        }
    }

    public Hotel findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
             //getirme işlemlerinde transaction kullanmasak da olur
            //save ve update gibi işlemlerde transaction olmadan işlem yapamyız.
           return  session.get(Hotel.class,id);

        }catch (HibernateException e){
            e.printStackTrace();//BU hataya sebep olan kodları yazdırmak için
        }finally {
            HibernateUtils.closeSession(session);// try-catch hangisinin içinde olursa olsun sessionı kapat.
        }
        return null;
    }

    public List<Hotel> findALL() {
        try{
            session=HibernateUtils.getSessionFactory().openSession();
          List<Hotel>hotelList=session.createQuery("FROM Hotel ",Hotel.class).getResultList();
       return hotelList;
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return null;
    }
}
