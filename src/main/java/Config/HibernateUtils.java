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
    //1-Configurasyon ayarlarımı yapmam lazım;
    //Uygulama calıştıgında configurasyon calışsın istersem statick blok kullanırım
    static{
        try {
            //addAnnotatedClass() deyip çağıracagız.
            Configuration config=new Configuration().configure("hibernate.cfg.xml").
                    addAnnotatedClass(Guest.class).
                    addAnnotatedClass(Hotel.class).
                    addAnnotatedClass(Reservation.class).
                    addAnnotatedClass(Room.class);
            sessionFactory=config.buildSessionFactory();

        }catch(Exception e){
            System.out.println("Initial Session Factory is failed!");
        }
    }
    //sessionnfactoru döndüren get methodu yazdık public seklinde
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }
    //sf kapatalım
    //kaynakları gereksiz yere döndürmemek için.sessionfaktor kaynagı database baglanan bir kaynak oldugundan
    //close methodu ile kapatmalıyız.
    public static void shutdown(){
        getSessionFactory().close();

    }
    //session kapatalım.
    public static void closeSession(Session session){
        if(session!=null && session.isOpen()){//null degil  ise yani böyle bir session
            // oluşturulmuşsa ve aynın zamanada bu session acıksa kapat.
            session.close();
        }
    }






}
