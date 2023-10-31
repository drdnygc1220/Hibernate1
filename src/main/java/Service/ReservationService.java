package Service;

import Repository.ReservationRepository;

import java.util.Scanner;

public class ReservationService {
    private Scanner scanner=new Scanner(System.in);
    private final ReservationRepository reservationRepository;
    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository=reservationRepository;

    }
}
