import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Parking Lot");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.initSlot();

        while(true){
            System.out.println("Select the options below to do particular Tasks : ");
            System.out.println("1:To Park the Vehicle : ");
            System.out.println("2:To Unpark the Vehicle :");
            System.out.println("3:Exit :");
            System.out.print("Enter your choice : ");
            int caseNo = sc.nextInt();
            sc.nextLine();
            switch(caseNo){
                case 1: {
                    System.out.println("Enter the owner name : ");;
                    String ownerName = sc.nextLine();
                    System.out.println("Enter the vehicle number : ");
                    String vehicleNo = sc.next();
                    System.out.println("Select the type of vehicle to Park : ");
                    System.out.println("1:Car");
                    System.out.println("2:Bike");
                    System.out.println("3:Truck");
                    int vehicleChoice = sc.nextInt();
                    System.out.println();
                    switch (vehicleChoice){
                        case 1 : {
                            Car c1 = new Car(vehicleNo , ownerName );
                            Ticket ticket1 = parkingLot.park(c1);
                            System.out.println("Generated Ticket is : ");
                            System.out.println(ticket1);
                            System.out.println();
                            try {
                                Thread.sleep(3000);
                            } catch(Exception e) {

                            }
                            break;
                        }
                        case 2 : {
                            Bike b1 = new Bike(vehicleNo , ownerName);
                            Ticket ticket1 = parkingLot.park(b1);
                            System.out.println("Generated Ticket is : ");
                            System.out.println(ticket1);
                            System.out.println();
                            break;
                        }
                        case 3 : {
                            Truck t1 = new Truck(vehicleNo , ownerName);
                            Ticket ticket1 = parkingLot.park(t1);
                            System.out.println("Generated Ticket is : ");
                            System.out.println(ticket1);
                            System.out.println();
                            break;
                        }
                        default:{
                            System.out.println("Vehicle type not available .");
                            System.out.println();
                            break;
                        }
                    }

                    break;


                }
                case 2:{
                    System.out.println("Enter the owner name : ");;
                    String ownerName = sc.nextLine();
                    System.out.println("Enter the vehicle number : ");
                    String vehicleNo = sc.next();
                    System.out.println("Select the type of vehicle to UnPark : ");
                    System.out.println("1:Car");
                    System.out.println("2:Bike");
                    System.out.println("3:Truck");
                    int vehicleChoice = sc.nextInt();
                    System.out.println();

                    switch (vehicleChoice){
                        case 1 : {
//                            Car c1 = new Car(vehicleNo , ownerName );
                            Ticket t1 = parkingLot.getTicket(vehicleNo , ownerName , "Car" );
                            System.out.println("Unparking Vehicle Ticket : ");
                            System.out.println("Parking Cost : Rs : " + parkingLot.unPark(t1));
                            System.out.println();
                            break;
                        }
                        case 2 : {
//                            Bike b1 = new Bike(vehicleNo , ownerName );

                            Ticket t1 = parkingLot.getTicket(vehicleNo , ownerName , "Bike" );
                            System.out.println("Unparking Vehicle Ticket : ");
                            System.out.println("Parking Cost : Rs : " + parkingLot.unPark(t1));
                            System.out.println();
                            break;
                        }
                        case 3 : {
//                            Truck t1 = new Truck(vehicleNo , ownerName );
                            Ticket ticket1 = parkingLot.getTicket(vehicleNo , ownerName ,"Truck");
                            System.out.println("Unparking Vehicle Ticket : ");
                            System.out.println("Parking Cost : Rs : " + parkingLot.unPark(ticket1));
                            System.out.println();
                            break;
                        }
                        default:{
                            break;
                        }
                    }


                    break;
                }
                case 3:{
                    return;

                } default:{
                    System.out.println("Enter the suitable option . ");
                    break;
                }
            }
        }
//        Car c1 = new Car("BX123" , "Aj");
//        Ticket t1 = parkingLot.park(c1);
//        System.out.println(t1);
    }
}
