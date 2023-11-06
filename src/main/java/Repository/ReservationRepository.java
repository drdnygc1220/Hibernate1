package Repository;

import Config.HibernateUtils;
import Domain.Guest;
import Domain.Hotel;
import Domain.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class ReservationRepository {
    private Session session;
    private void saveResevation(){

    }

    public Reservation findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            //getirme işlemlerinde transaction kullanmasak da olur
            //save ve update gibi işlemlerde transaction olmadan işlem yapamyız.
            return  session.get(Reservation.class,id);

        }catch (HibernateException e){
            e.printStackTrace();//BU hataya sebep olan kodları yazdırmak için
        }finally {
            HibernateUtils.closeSession(session);// try-catch hangisinin içinde olursa olsun sessionı kapat.
        }
        return null;
    }

    public List<Reservation> findALL() {
        try{
            session=HibernateUtils.getSessionFactory().openSession();
            List<Reservation>reservations=session.createQuery("FROM Hotel ", Reservation.class).getResultList();
            return reservations;
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}
