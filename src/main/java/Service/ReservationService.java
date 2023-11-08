package Service;

import Domain.Guest;
import Domain.Hotel;
import Domain.Reservation;
import Domain.Room;
import Exceptions.HotelNotFoundExceptions;
import Exceptions.RoomNotFoundExceptions;
import Repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationService {
    private Scanner scanner=new Scanner(System.in);
    private final ReservationRepository reservationRepository;
    private final GuestService guestService;
    private final RoomService roomService;

    public ReservationService(ReservationRepository reservationRepository,GuestService guestService,RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.guestService=guestService;
        this.roomService=roomService;
    }
    public Reservation findReservationById(Long id) {
       Reservation foundReservation=reservationRepository.findById(id);
        try {
            if (foundReservation!= null) {
                System.out.println("-----------------");
                System.out.println(foundReservation);
                System.out.println("-----------------");
                return foundReservation;
            } else {
                throw new HotelNotFoundExceptions("hotel ıd bulunumadı: " + id);
            }
        }catch (HotelNotFoundExceptions e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Reservation> findAllResevation() {

        List<Reservation> reservationList = reservationRepository.findALL();
        //Tabloda hiç birşey yokda boş bir rapor dönüyordu
        //hotel listem boş mu degil mi kontrol etmem lazım.
        if (!reservationList.isEmpty()) {
            System.out.println("----------------List of Hotels---------------------");
            for(Reservation reservation:reservationList){//hotelleri hotel listten gez..
                System.out.println(reservation);
                System.out.println("-----------------------------------------------");
            }

        } else {
            System.out.println("Hotel list is empty!");
        }
        return reservationList;


    }

    public void saveReservation() {
        System.out.println("Enter guest id");
        Long guestId= scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter room id");
        Long roomId= scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter check-in date(yyyy-MM-dd) : ");
        LocalDate chechIn= LocalDate.parse(scanner.nextLine());//tarih tipini local date cevirir

        System.out.println("Enter check-out date(yyyy-MM-dd): ");
        LocalDate chechOut= LocalDate.parse(scanner.nextLine());//tarih tipini local date cevirir

        try {
            Reservation reservation = new Reservation();
            Guest guest = guestService.findGuestById(guestId);
            Room room=roomService.findRoomById(roomId);
            if(guest!=null && room!=null){
                reservation.setCheckIn(chechIn);
                reservation.setCheckOut(chechOut);
                reservation.setGuest(guest);
                reservation.setRoom(room);

                reservationRepository.save(reservation);
                System.out.println("reservation is create successfully.......");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

    }
}
