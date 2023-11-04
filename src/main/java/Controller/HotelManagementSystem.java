package Controller;

import Config.HibernateUtils;
import Repository.GuestRepository;
import Repository.HotelRepository;
import Repository.RoomRepository;
import Service.HotelService;
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
       // RoomRepository roomRepository=new RoomRepository();
       // RoomService roomService=new RoomService(roomRepository,hotelService);

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
                       // displayRoomOperationsMenu(roomService);
                        break;
                    case 3:
                        displayGuestOperationsMenu();
                        break;
                    case 4:
                        displayReservationOperationsMenu();
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

    public static void displayHotelOperationsMenu(HotelService hotelService){
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
                    break;
                case 4://tüm otelleri göster
                    hotelService.findAllHotels();
                    break;
                case 5:
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

    public static void displayRoomOperationsMenu(RoomService roomService){
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
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    exit=true;
                    break;
                default:
                    System.out.println("yanlış yada eksik girdiniz");
                    break;

            }
        }

    }

    public static void displayGuestOperationsMenu(){//parametre kısmına tekrar bak neden almamış
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
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

    public static void displayReservationOperationsMenu(){
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
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
