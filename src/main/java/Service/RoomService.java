package Service;

import Repository.RoomRepository;

import java.util.Scanner;

public class RoomService {
   private Scanner scanner=new Scanner(System.in);

   private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
}
