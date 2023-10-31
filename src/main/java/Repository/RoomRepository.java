package Repository;

import Config.HibernateUtils;
import Domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository {
    private Session session;
    public void saveRoom(Room room){//odayı kaydet:transaction var
        try {
            session= HibernateUtils.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();
            session.persist(room);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }

    }

    public Room findRoomById(Long roomId){//oda ile id bul:transaction yok
        session=HibernateUtils.getSessionFactory().openSession();
       Room room=session.get(Room.class,roomId);
       return room;


    }
    public List<Room> findAllRoom(){//tüm odaları bul
        try{
            session=HibernateUtils.getSessionFactory().openSession();
            List<Room>rooms=session.createQuery("FROM Room",Room.class).getResultList();
            return rooms;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
