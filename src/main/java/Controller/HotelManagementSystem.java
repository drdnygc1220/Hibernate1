package Controller;

import Config.HibernateUtils;
import Domain.Reservation;
import Repository.GuestRepository;
import Repository.HotelRepository;
import Repository.ReservationRepository;
import Repository.RoomRepository;
import Service.GuestService;
import Service.HotelService;
import Service.ReservationService;
import Service.RoomService;

import java.util.Scanner;

//bu package kullanıcyla iletişime gectiğimiz alan
//runner classı sadece methodla cagırıp başlattıgımz kısım olack
public class HotelManagementSystem {
    private static Scanner scanner=new Scanner(System.in);

    //proje aslında bu method içinde başlıyor ve bitiyor.....
    public static void displayMenuHotelManagementSystem() {
        HotelRepository hotelRepository=new HotelRepository();
        HotelService hotelService=new HotelService(hotelRepository);

        RoomRepository roomRepository=new RoomRepository();
        RoomService roomService=new RoomService(roomRepository,hotelService);

        GuestRepository guestRepository=new GuestRepository();
        GuestService guestService=new GuestService(guestRepository);

        ReservationRepository reservationRepository=new ReservationRepository();
        ReservationService reservationService=new ReservationService(reservationRepository,guestService,roomService);


        boolean exit=false;
        while (!exit){
                System.out.println("====== Hotel Management System Menu ======");
                System.out.println("1. Hotel Operations");
                System.out.println("2. Room Operations");
                System.out.println("3. Guest Operations");
                System.out.println("4. Reservation Operations");
                System.out.println("0. Exit");
                System.out.println("Enter you cohoice");
                int cohoice=scanner.nextInt();
                switch (cohoice){
                    case 1:
                        displayHotelOperationsMenu(hotelService);
                        break;
                    case 2:
                       displayRoomOperationsMenu(roomService);
                        break;
                    case 3:
                        displayGuestOperationsMenu(guestService);
                        break;
                    case 4:
                        displayReservationOperationsMenu(reservationService);
                        break;
                    case 0:
                        exit=true;
                        System.out.println("tekrar bekleriz..");
                        //proggramı kapatalım.//shutdown methodu
                        HibernateUtils.shutdown();
                        break;
                    default:
                        System.out.println("lütfen secim kısmına dikkat edelim");
                        break;
                }
        }
    }

   private static void displayHotelOperationsMenu(HotelService hotelService){
        System.out.println("Hotel işlemleri Menüsü");
        boolean exit=false;
        while (!exit){
            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find Hotel By ID");
            System.out.println("3. Delete Hotel By ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1://save hotel
                    hotelService.saveHotel();
                break;
                case 2://find hotel
                    System.out.println("Hotel ID :");
                    Long id= scanner.nextLong();
                    scanner.nextLine();
                    hotelService.findHotelById(id);
                    break;
                case 3://delete hotel
                    System.out.println("Enter Hotel ID to Delete :");
                    Long hotelid= scanner.nextLong();
                    scanner.nextLine();
                    hotelService.deleteHotelById(hotelid);
                    break;
                case 4://tüm otelleri göster
                    hotelService.findAllHotels();
                    break;
                case 5://update//otel ıd almamız lazım.
                    System.out.println("Enter Hotel ID to Update:");
                    Long updateid= scanner.nextLong();
                    scanner.nextLine();
                    hotelService.updateHotelById(updateid);
                    break;
                case 0:
                    exit=true;
                    break;
                default:
                    System.out.println("lütfen gecerli bir işlem giriniz.");
                    break;

            }

        }

    }

    private static void displayRoomOperationsMenu(RoomService roomService){
        System.out.println("Room işlemleri menüsü");
        boolean exit=false;
        while (!exit){
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1://save room
                    roomService.saveRoom();
                    break;
                case 2://find room
                    System.out.println("Room ID:");
                    Long id=scanner.nextLong();
                    scanner.nextLine();
                    roomService.findRoomById(id);

                    break;
                case 3:
                    System.out.println("Enter the room ID to delete: ");
                    Long roomIdToDelete=scanner.nextLong();
                    scanner.nextLine();
                    roomService.deleteRoomById(roomIdToDelete);

                    break;
                case 4:
                    roomService.findAllRooms();
                    break;
                case 0:
                    exit=true;
                    break;
                default:
                    System.out.println("Yanlış yada eksik girdiniz");
                    break;

            }
        }

    }

  private static void displayGuestOperationsMenu(GuestService guestService){//parametre kısmına tekrar bak neden almamış
        System.out.println("Guest işlemleri menüsü");
        boolean exit=false;
        while (!exit){
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1://save guest
                    guestService.saveGuest();
                    break;
                case 2://ödev
                    System.out.println("Guest ID:");
                    Long id=scanner.nextLong();
                    scanner.nextLine();
                    guestService.findGuestById(id);
                    break;
                case 3:
                    System.out.println("Enter the Guest ID: ");
                    long guestId=scanner.nextLong();
                    scanner.nextLine();
                    guestService.findGuestById(guestId);
                    break;
                case 4:
                    guestService.findAllGuest();
                    break;
                case 0:
                    exit=true;
                    break;
                default:
                    System.out.println("yanlış yada eksik giriş yaptınız");
                    break;

            }
        }

    }

   private static void displayReservationOperationsMenu(ReservationService reservationService){
        System.out.println("Reservation işlemleri menüsü");
        boolean exit=false;
        while (!exit){
            System.out.println("==== Reservation Operations ====");
            System.out.println("1. Add a new reservation");
            System.out.println("2. Find Reservation By ID");
            System.out.println("3. Find All Reservations");
            System.out.println("4. Delete Reservation By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1://save reservation
                    reservationService.saveReservation();
                    break;
                case 2:
                    System.out.println("Reservation ID:");
                    Long id=scanner.nextLong();
                    scanner.nextLine();
                    reservationService.findReservationById(id);
                    break;
                case 3:
                    reservationService.findAllResevation();
                    break;
                case 4://ödev
                    break;
                case 5:
                    exit=true;
                    break;
                default:
                    System.out.println("yanlış yada eksik bilgi girdiniz");
                    break;
            }
        }

    }
}
