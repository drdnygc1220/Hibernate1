package Service;

import Domain.Guest;
import Exceptions.HotelNotFoundExceptions;
import Repository.GuestRepository;

import java.util.List;
import java.util.Scanner;

public class GuestService {
   private Scanner scanner=new Scanner(System.in);
   private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

   public Guest findGuestById(Long id){
        Guest foundGuest=guestRepository.findById(id);
        try{
            if(foundGuest!=null){
                System.out.println("--------------");
                System.out.println(foundGuest);
                System.out.println("----------------");
                return foundGuest;
            }else{
                throw  new HotelNotFoundExceptions("hotel id bulunamadı");
            }

        }catch(HotelNotFoundExceptions e){
            System.out.println(e.getMessage());

        }
        return null;
   }
   public List<Guest>findAllGuest(){
        List<Guest>guestList=guestRepository.findAllGuest();
        if(!guestList.isEmpty()){
            System.out.println("------list of -----");
            for(Guest guest:guestList){
                System.out.println(guest);
                System.out.println("--------------------");
            }
        }else{
            System.out.println("Room list is empty");
        }
        return null;
   }

}
