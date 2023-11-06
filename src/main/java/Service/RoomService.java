package Service;
//service clasları controller ile reposştory clasları arasında bir memur gibi.
import Domain.Hotel;
import Domain.Room;
import Exceptions.HotelNotFoundExceptions;
import Exceptions.RoomNotFoundExceptions;
import Repository.RoomRepository;

import java.util.List;
import java.util.Scanner;

public class RoomService {
   private static Scanner scanner=new Scanner(System.in);

   private  final RoomRepository roomRepository;//room service classının içine room repository clasını enjekte ettik.
    private final HotelService hotelService;

    public RoomService(RoomRepository roomRepository,HotelService hotelService) {
        this.roomRepository = roomRepository;
        this.hotelService=hotelService;
    }

    public  void saveRoom() {
        Room room=new Room();
        System.out.println("Enter Room ID: ");
        room.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Enter Room number");
        room.setNumber(scanner.nextLine());
        System.out.println("Enter Room capacity");
        room.setCapacity(scanner.nextInt());
        System.out.println("Enter hotel id");
        Long hotelId=scanner.nextLong();//hotel tipinde oldugu için değişkene atamak zorundayız.
        //id si verilen hoteli bulalım.
        try {
            Hotel foundHotel = hotelService.findHotelById(hotelId); //bu id ait bulamazsam exception fırlatır.
            if(foundHotel!=null){
                room.setHotel(foundHotel);//odanın ait oldugu hotel set edildi.
                //otelin listesine odayı eklememize gerek yok.mappedby ekler.
                //foundHotel.getRooms().add(room);
                roomRepository.saveRoom(room);//oda tabloya eklendi
                System.out.println("Room saved succesfully.Room id: "+room.getId());
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public  Room findRoomById(Long id) {
        Room foundRoom=roomRepository.findById(id);
        try{
            if(foundRoom!=null){
                System.out.println("-------------");
                System.out.println(foundRoom);
                System.out.println("----------");
                return foundRoom;
            }else {
                throw new HotelNotFoundExceptions("horel id bulunamadı");
            }

        }catch (HotelNotFoundExceptions e){
            System.out.println(e.getMessage());
        }
     return null;
    }

    public List<Room> findAllRooms(){
        List<Room>roomList=roomRepository.findAllRooms();
                if(!roomList.isEmpty()){
                    System.out.println("--------list of Rooms-------");
                    for(Room room:roomList){
                        System.out.println(room);
                        System.out.println("----------------------");
                    }
                }else{
                    System.out.println("Room list is empty!");
                }
                return roomList;
    }
}
