package Service;

import Domain.Address;
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

    public void saveGuest() {
        Guest guest=new Guest();
        System.out.println("Enter guest name: ");
        guest.setName(scanner.nextLine());

        Address address=new Address();
        System.out.println("Enter street:");
        address.setStreet(scanner.nextLine());
        System.out.println("Enter city:");
        address.setCity(scanner.nextLine());
        System.out.println("Enter country:");
        address.setCountry(scanner.nextLine());
        System.out.println("Enter zipcode:");
        address.setZipcode(scanner.nextInt());
        scanner.nextLine();

        guest.setAddress(address);

        guestRepository.save(guest);
        System.out.println("Guest is saved succesfully...guset id:"+guest.getId());


    }
}
