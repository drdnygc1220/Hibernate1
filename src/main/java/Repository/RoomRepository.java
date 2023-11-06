package Repository;

import Config.HibernateUtils;
import Domain.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository {
    private Session session;

    public void saveRoom(Room room){
        try{
            session=HibernateUtils.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();
            session.save(room);

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }

    }

    public  Room findById(Long roomId) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Room room = session.get(Room.class, roomId);
            return room;
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public Room findRoomById(Long roomId){
        session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Room room=session.get(Room.class,roomId);
        return room;

    }
    public List<Room> findAllRooms(){
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
