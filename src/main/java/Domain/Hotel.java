package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//domain=entity=pojo
//entity classları bir package de topladık
@Entity//bir tablo oluşturacak
@Table(name="t_hotel")//opsiyonel=zorunluluk yok
public class Hotel {

    //tablolar arasındada ilişki olması lazım:id sütunumu kullanarak yap bunu demek için @ıd kullanırız
    @Id
    private Long id;//null deger girmesini istiyorsak non-primitive kullanmam lazım.
    //non-primitive yazdım:çünkü ıd degerini girmezsem 0 girer ama benim için bir degerdir girmesin diyoruz.

    //name sütunundaki degerlerin null olmasını istemiyorum
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;

   // TODO:@OneToMany:Room tablosunda koymak daha dogru olur
    //odalarını collectıon tutmam lazım genelde list tipinde tutmam lazım
    private List<Room> romms=new ArrayList<>();//onetoone yapacagım

    //param cons:bunu yaptıgımızda biz parametresiz constructora ihtiyacımız yok demekti fakat Hibernate parametresiz cons ihtiyac duyar.
    public Hotel(Long id, String name, String location, List<Room> romms) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.romms = romms;
    }

    //parametresiz con
    public Hotel() {//fetch için hibernate default cons kullanır.
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

    public List<Room> getRomms() {
        return romms;
    }

    public void setRomms(List<Room> romms) {
        this.romms = romms;
    }

    //otel objemizi dogrudan getirebilmek için toString

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", romms=" + romms +
                '}';
    }
}
