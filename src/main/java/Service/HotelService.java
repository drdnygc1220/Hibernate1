package Service;

import Domain.Hotel;
import Exceptions.HotelNotFoundExceptions;
import Repository.HotelRepository;

import java.util.List;
import java.util.Scanner;

//hotel ile ilgili işlem yapacagız
public class HotelService {
   private  Scanner scanner=new Scanner(System.in);
   private  final HotelRepository hotelRepository;//burada yapmamızın sebebi hotel repository her
    // cagrıldıgında newlememek için tek bir kere yazıp daha sonra kullanacgız.
    //final da parametreli cons yapmak zorundayız

    public HotelService(HotelRepository hotelRepository) {//bir classın fieldını obje oluşturuken
        // nasıl cgaırıırm parametreli const
        //hotelservice objesi oluşturulurken bana hotel repository de ver diyorum.
        this.hotelRepository = hotelRepository;
        //savehotel+hotelservice+hotelrepository kısmında hotel servıce cagırıdgımda
        // hotelrepository de ver demek isityorum

    }

    public  void saveHotel() {
        Hotel hotel = new Hotel();

        System.out.println("Hotel ID:");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Hotel name:");
        hotel.setName(scanner.nextLine());
        System.out.println("Hotel location");
        hotel.setLocation(scanner.nextLine());

        try {

            hotelRepository.saveHotel(hotel);
            System.out.println("Hotel saved successfully.Hotel ID: " + hotel.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //room kısmını burada oluşturmak yerine room clasında bu oda bu otele
        // ait şekllinde yapacagız..
        ///Db ye gönderme işlemi için repository gittik.
    }


    public Hotel findHotelById(Long id) {
        Hotel foundHotel=hotelRepository.findById(id);
        try {
            if (foundHotel != null) {
                System.out.println("-----------------");
                System.out.println(foundHotel);
                System.out.println("-----------------");
                return foundHotel;
            } else {
                throw new HotelNotFoundExceptions("hotel ıd bulunumadı: " + id);
            }
        }catch (HotelNotFoundExceptions e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Hotel> findAllHotels() {

        List<Hotel> hotelList = hotelRepository.findALL();
        //Tabloda hiç birşey yokda boş bir rapor dönüyordu
        //hotel listem boş mu degil mi kontrol etmem lazım.
        if (!hotelList.isEmpty()) {
            System.out.println("----------------List of Hotels---------------------");
            for(Hotel hotel:hotelList){//hotelleri hotel listten gez..
                System.out.println(hotel);
                System.out.println("-----------------------------------------------");
            }

        } else {
            System.out.println("Hotel list is empty!");
        }
        return hotelList;


    }

    public void deleteHotelById(Long id) {
        //id si verilen oteli öncelikle bulalım
        //burada repositoryden gitmek yerine yukarıda findHotelById methodundan cekmek daha kolay oluyor.
        Hotel foundHotel=findHotelById(id);
        if(foundHotel!=null){
            System.out.println(foundHotel);
            System.out.println("Are you sure want to delete hotel by ıd: "+id);
            System.out.println("Please answer with Y or N");
            String confirmation=scanner.nextLine();
            if(confirmation.equalsIgnoreCase("Y")){
                hotelRepository.deleteById(foundHotel);
                System.out.println("Hotel is deleted successfully");
            }else{
                System.out.println("Delete operation is cancellec...");
            }
        }
    }

    public void updateHotelById(Long id) {
        //öncelikle oteli bulalım
        Hotel existingHotel=findHotelById(id);
        if(existingHotel!=null){
            System.out.println("Enter the hotel name to update:");
            String name=scanner.nextLine();
            System.out.println("Enter the hotel location to update:");
            String location=scanner.nextLine();
            existingHotel.setName(name);
            existingHotel.setLocation(location);
            hotelRepository.updateById(existingHotel);
            System.out.println("Hotel is update successfully");
        }
    }
}


