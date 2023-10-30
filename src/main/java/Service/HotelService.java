package Service;

import Domain.Hotel;
import Repository.HotelRepository;

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
}
