package Domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_guest")
public class Guest {
    //todo:generate
    @Id
    private Long id;
    private String name;
    @Embedded
   private Address address;

    private LocalDateTime createDate;//konuk giriş yaptıgında hangi zaman diliminde yapılmış:prePersist
    @PrePersist
    public void prePersist(){//tabloya kaydetmeden HEMEN önce ne yapmak istiyorsak anateyşını kullanacagız..
        this.createDate=LocalDateTime.now();

    }

    //her bir konuğun rezervasyonu olabilir.
    @OneToMany(mappedBy = "reservation",orphanRemoval = true)
    private List<Reservation>reservations=new ArrayList<>();

    public Guest(Long id, String name, Address address, LocalDateTime createDate, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.createDate = createDate;
        this.reservations = reservations;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", createDate=" + createDate +
                '}';
    }
}
