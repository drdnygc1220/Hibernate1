package Service;

import Domain.Hotel;
import Domain.Reservation;
import Exceptions.HotelNotFoundExceptions;
import Repository.ReservationRepository;

import java.util.List;
import java.util.Scanner;

public class ReservationService {
    private Scanner scanner=new Scanner(System.in);
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
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

}
