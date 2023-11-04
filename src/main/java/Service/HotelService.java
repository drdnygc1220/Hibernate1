package Service;

import Domain.Hotel;
import Repository.HotelRepository;

import java.util.Scanner;

//hotel ile ilgili işlem yapacagız
public class HotelService {
   private Scanner scanner=new Scanner(System.in);
   private final HotelRepository hotelRepository;//burada yapmamızın sebebi hotel repository her
    // cagrıldıgında newlememek için tek bir kere yazıp daha sonra kullanacgız.
    //final da parametreli cons yapmak zorundayız

    public HotelService(HotelRepository hotelRepository) {//bir classın fieldını obje oluşturuken
        // nasıl cgaırıırm parametreli const
        //hotelservice objesi oluşturulurken bana hotel repository de ver diyorum.
        this.hotelRepository = hotelRepository;
        //savehotel+hotelservice+hotelrepository kısmında hotel servıce cagırıdgımda
        // hotelrepository de ver demek isityorum

    }

    public void saveHotel() {
        Hotel hotel = new Hotel();

        System.out.println("Hotel ID:");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Hotel name:");
        hotel.setName(scanner.nextLine());
        System.out.println("Hotel location");
        hotel.setLocation(scanner.nextLine());

        hotelRepository.saveHotel(hotel);

        //room kısmını burada oluşturmak yerine room clasında bu oda bu otele
        // ait şekllinde yapacagız..
        ///Db ye gönderme işlemi için repository gittik.
    }




}
