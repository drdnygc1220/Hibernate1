package Service;

import Domain.Hotel;
import Exceptions.HotelNotFoundException;
import Repository.HotelRepository;

import java.util.List;
import java.util.Scanner;

public class HotelService {
    private Scanner scanner=new Scanner(System.in);//her yerde kullanmak için field içinde acıyoruz.
    //her seferinde tekrar tekrar obje oluşturmam gerekmiyor.sürekli new lemek yorar.

   // private HotelRepository hotelRepository=new HotelRepository();
   private final HotelRepository hotelRepository;//bir kere kullanacagız ve değişmeyecek:final
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void saveHotel(){

        Hotel hotel=new Hotel();
        System.out.println("Otel ıd sini giriniz");
        hotel.setId(scanner.nextLong());//dogrudan set ettik daha kullanmayacagız diye.
        scanner.nextLine();//sayısaldan sonra nextline cagırılırsa hata veriyor araya nextline koyalım.
        System.out.println("Hotel adı giriniz");
        hotel.setName(scanner.nextLine());
        System.out.println("Hotel locationı giriniz.");
        hotel.setLocation(scanner.nextLine());

        //database baglanacagız.baglanma işini repository classında yapıyoruz....
        //otelimiz hazır kaydetme işlemi yapacagız..
        hotelRepository.save(hotel);
        System.out.println("otelimiz başarıyla kaydedildi , kaydedilen objenin ıd: "+hotel.getId());




    }

    public Hotel findHotelById(Long id) {
        Hotel founHotel=hotelRepository.findById(id);
        try {
            if (founHotel != null) {
                System.out.println("-------------------");
                System.out.println(founHotel);//toString oldugu için direk objeyi yazdırır
                System.out.println("-------------------");
                return founHotel;
            } else {
                throw new HotelNotFoundException("Hotel not found by id: " + id);//throw ile exception bizi yaptık anlamlı olması için
            }
        }catch (HotelNotFoundException e){
            System.out.println("e.getMessage()= "+e.getMessage());
        }
        return null;
    }

    public List<Hotel> findAllHotels() {//birden fazla hotel oldugu için list yaptık

            //tüm otelleri repositoryden findAll methodundan içinde hotel olan bir liste döndürmeli
            List<Hotel> hotelList=HotelRepository.findAll();
            if(!hotelList.isEmpty()){//isEmpty=liste boşsa
                System.out.println("----------List of Hotels----------------");
               for(Hotel hotel:hotelList){
                   System.out.println(hotel);
                   System.out.println("--------------------------------------");
               }

            }else{
                System.out.println("Hotel list is empty!");
            }
            return hotelList;

    }
}
