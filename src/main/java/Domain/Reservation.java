package Domain;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "t_reservation")
public class Reservation {

    @Id
    @GeneratedValue(generator = "seq",strategy =GenerationType.SEQUENCE)//DAHA HIZLI PARAMETRE VERMEM GEREK=genereate=seq
    //seq içinde parametre vermem gerek
    @SequenceGenerator(name = "seq",sequenceName = "reservation_id_seq",initialValue = 1000,allocationSize = 5)
    //name;hangi generate kullandıgını söylemek için.
    //sequenceName;seq adı
    //initivalue;başlangıç degerini belirler.
    //allocationSize;içinde hazır bulunan 5er beşer seti hazır beklet demek.
    private Long id;
    @Column(nullable = false)
    private LocalDate checkIn;
    @Column(nullable = false)
    private LocalDate checkOut;
    @ManyToOne(fetch = FetchType.LAZY)//MANY olan tarafta FK tablosunu saglıyor:guest_id
    @JoinColumn(nullable = false)//ilişkilerde joıcolumn kullanılır
    private Guest guest;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Room room;
//prmtreli con yok,kullanılabilr :reservation set ederken guest ve room obje olarak almmaız gerekecek bu sebebple dogrudan set edelim.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {//ilşkili oldugu objeler için tostring almıyoruz.
        return "Reservation{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
