package Config;

import Domain.Guest;
import Domain.Hotel;
import Domain.Reservation;
import Domain.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    static {
        try{
            Configuration con=new Configuration().
                    configure("hibernate.cfg.xml").
                    //opsiyonel zorunlu degil.
//configure yazmazsak default olarak zaten bizim yazdıgımız kısım alır.
// adını değiştirdiğimizde de belirtmemiz lazım.
                    addAnnotatedClass(Hotel.class).//entity clasları anateyşın yapıp ekliyorum.
                    addAnnotatedClass(Room.class).
                    addAnnotatedClass(Reservation.class).
                    addAnnotatedClass(Guest.class);
        }catch (Exception e){
            System.err.println("session factor acılamadı.");
        }
    }

    //getter methodu session factor için

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //sessionfactor kapatalıcak.
    public static void shutdown(){
        getSessionFactory().close();

    }
    //sessionı da kapatalım.fakat session olmadıgından parametreli constractır yapatık
    public static void closeSession(Session session){
        //session acık ve null olmadıgı duurmda kapat.
        if (session!= null && session.isOpen()) {//session acık demek=isOpen
            session.close();

        }

    }
}
