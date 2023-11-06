package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_hotel")
public class Hotel {

    @Id
    private Long id;//non-primitive almamım sebebi default olarak 0 alır
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;

    //odaları vardır liste seklinde gösterecegiz.
    @OneToMany(mappedBy = "hotel",fetch = FetchType.EAGER)//3.tablo oluşturma
    // room clasındaki hotel içinde set edildiğinde sende buraya gel mapped.
    private List<Room> rooms=new ArrayList<>();

    //parametresiz cons.;Normalde parametreli yaptıgımızda bunu opsiyonel yapmış oluyoruz
    // fakat hibeernate dataları alıp getirdiğine
    // buradaki objelerle karşılaştırma yapmak için bir alana ihtiyac duyar.

    // bu alan parametresiz cons olur.
    public Hotel() {
    }

    //parametreli con
    public Hotel(Long id, String name, String location ) {
        this.id = id;
        this.name = name;
        this.location = location;

    }
    //getter-setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    //toString

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
