package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "t_room")
public class Room {//FK sütunu MANY olan kısımda olur genelde..
    @Id//Pk sütunu için @Id istiyor
    private Long id;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private int capacity;

    //her bir oda sadece bir otele ait olmalı.
    @ManyToOne//ROOM tablosunda FK sütunu oluşacak.FK:hotel_id yapar ben bu ismi degiştirmek istersem
    @JoinColumn(name = "hotel_id",nullable = false)//opsiyonel zorunlu değil.
    private Hotel hotel;

    //reservation olması lazım.
    //todo:one-to-many
   // private List<Reservation> reservations=new ArrayList<>();//rezervasyonu set etmedik constr kısmına

    //default cons


    public Room() {
    }

    //prmt con
    public Room(Long id, String number, int capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }
    //getter-setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

   /* public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    */

    //toString

    @Override
    public String toString() {//hotel almadık cünkü ilişkileri oldugu için sürekli bir oraya bir buraya gidecek
        // ikiside obje ikisininde classı var.
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                //", reservations=" + reservations +
                '}';
    }
}
