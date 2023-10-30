package Service;

import Repository.GuestRepository;

import java.util.Scanner;

public class GuestService {
    private Scanner scanner=new Scanner(System.in);
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
}
