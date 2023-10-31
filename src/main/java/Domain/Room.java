package Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_room")
public class Room {
    @Id
    private Long id;//non-primitive girmemizin sebebi biz bir deger girmediysek sıfır yerine null atasın demek için
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private int capaticy;

    //TODO:MANY-TO-MANY:FK burada olsun
    private Hotel hotel;

    //TODO:one to many:bir odanın birden fazla rezervasyonu olabilir.
    private List<Reservation>reservations=new ArrayList<>();
    //default con
    public Room() {
    }

    //param cons:parm cons yaptıgımızda parametresiz cons default edilmiş oluyordu ama bize lazım oldugundan yapıyoruz.
    public Room(Long id, String number, int capaticy, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capaticy = capaticy;
        this.hotel = hotel;
    }

    //private yaptıhımız için getter-setter yapacagız


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return number;
    }

    public void setRoom(String room) {
        this.number = room;
    }

    public int getCapaticy() {
        return capaticy;
    }

    public void setCapaticy(int capaticy) {
        this.capaticy = capaticy;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    //toString

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room='" + room + '\'' +
                ", capaticy=" + capaticy +
                //", hotel=" + hotel +...burada bir oraya bir buraya gitmemek için stackhower sonsuz döngüye gider.
               // ", reservations=" + reservations +
                '}';
    }
}
