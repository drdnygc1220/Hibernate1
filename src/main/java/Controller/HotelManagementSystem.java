package Controller;

import Config.HibernateUtils;
import Repository.HotelRepository;
import Service.HotelService;

import java.util.Scanner;

public class HotelManagementSystem {
    //kullanıcı ile iletişime gectiğimiz kısım.
    //menüleri sunacagız..

    //birden fazla scanner oluşturacagımız için field şeklinde yazdım
   private static Scanner scanner=new Scanner(System.in);

   public static void displayMenuHotelManagementSystem(){
       HotelRepository hotelRepository=new HotelRepository();//bir kere oluşturduk
       HotelService hotelService=new HotelService(hotelRepository);//içine enjekte ediyorum.
       boolean exit=false;
       while (!exit){
           System.out.println("============Hotel Management  System Menu ==========");
           System.out.println("1-Hotel Operations");
           System.out.println("2-Room Operations");
           System.out.println("3-Guest Operations");
           System.out.println("4-Rezervation Operations");
           System.out.println("0-Exit");
           System.out.println("Enter your choice:");
           int choice= scanner.nextInt();
           scanner.nextLine();

           switch (choice){
               case 1:
                   //save hotel:OTELİ KAYDEDECEĞİZ..
                   displayHotelOperationsMenu(hotelService);
                   break;
               case 2:
                   displayRoomOperationsMenu();
                   break;
               case 3:
                   displayGuestOperationsMenu();
                   break;
               case 4:
                   displayReserveationOperationsMenu();
                   break;
               case 0:
                   exit=true;
                   System.out.println("Good bye ...");
                   //CIKIŞ YAPARKEN KAPAT.Shutdown METHOD CAGIRILACAK..
                   HibernateUtils.shutdown();
                   break;
               default:
                   System.out.println("Invalid choice,Please try again");
                   break;
           }
       }
   }

   private static void displayHotelOperationsMenu(HotelService hotelService){//otelle ilgili menüler
       System.out.println("HotelOperationMenu");
       boolean exit=false;
      while(!exit){
          System.out.println("===Hotel Operations");
          System.out.println("1.Add a new hotel");
          System.out.println("2.Find Hotel By 10");
          System.out.println("3.Delete hotel By ID");
          System.out.println("4.Find All Hotels");
          System.out.println("5.Update Hotel By ID");
          System.out.println("0.Return to Main Menu");
          System.out.println("Enter your choice");

          int choice= scanner.nextInt();
          scanner.nextLine();
          switch (choice){
              case 1:
                  //save hotel
                  hotelService.saveHotel();
                  break;
              case 2:
                  break;
              case 3:
                  break;
              case 4:
                  break;
              case 0:
                  exit=true;
                  System.out.println("Good bye ...");
                  //CIKIŞ YAPARKEN KAPAT.Shutdown METHOD CAGIRILACAK..
                  HibernateUtils.shutdown();
                  break;
              default:
                  System.out.println("Invalid choice,Please try again");
                  break;
          }

      }

   }
   private  static void displayRoomOperationsMenu(){
       boolean exit=false;
       while(!exit){
           System.out.println("");
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
                   System.out.println("Good By...");
                   HibernateUtils.shutdown();
                   break;
               default:
                   System.out.println("Invalid choice,Please try again");
                   break;
          }
       }
   }
   private static void displayGuestOperationsMenu(){
       boolean exit=false;
       while (!exit){
           System.out.println("");
           System.out.println();
           int choice=scanner.nextInt();
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
                   System.out.println("Good by");
                   HibernateUtils.shutdown();
                   break;
                   default:
                       System.out.println("Invalid choice,Please try again");
                       break;
           }
       }

   }
   private static void displayReserveationOperationsMenu(){
       boolean exit=false;
       while (!exit){
           System.out.println("");
           System.out.println();
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
                   break;
               case 0:
                   exit=true;
                   System.out.println("Good By");
                   HibernateUtils.shutdown();
                   break;
               default:
                   System.out.println("Invalid choice,Please try again");
                   break;

           }
       }

   }

}
