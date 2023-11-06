package Repository;

import Config.HibernateUtils;
import Domain.Guest;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class GuestRepository {
    private Session session;
    private void saveGuest(){

    }

    public Guest findById(Long guestId) {
        try{
            session= HibernateUtils.getSessionFactory().openSession();
            Guest guest=session.get(Guest.class,guestId);
            return guest;
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public List<Guest> findAllGuest() {
        try{
            session=HibernateUtils.getSessionFactory().openSession();
            List<Guest>guest=session.createQuery("FROM Guest", Guest.class).getResultList();
            return guest;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
