import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Slot> bikes , cars , trucks;
    List<Ticket> ticket ;

    ParkingLot(){
        this.bikes = new ArrayList<>();
        this.cars = new ArrayList<>();
        this.trucks = new ArrayList<>();
        this.ticket  = new ArrayList<>();
    }

    public void initSlot(){
        for(int i=0 ; i<10 ; i++){
            bikes.add(new Slot("B"+(i+1)));
        }
        for(int i=0 ; i<6 ; i++){
            cars.add(new Slot("C"+(i+1)));
        }
        for(int i=0 ; i<4 ; i++){
            trucks.add(new Slot("T"+(i+1)));
        }
    }

    public Ticket park(Vehicle vehicle){
        Slot freeSlot = null;
        if(vehicle instanceof Bike){
            freeSlot = findSlot("Bike");
        }else if(vehicle instanceof Car){
            freeSlot = findSlot("Car");
        }else{
            freeSlot = findSlot("Truck");
        }

        if(freeSlot==null){
            System.out.println("No Slot Available");
            return null;
        }
        freeSlot.vehicle = vehicle;

        Ticket t1 = new Ticket(vehicle , freeSlot);
        ticket.add(t1);

        return t1;
    }

    public Slot findSlot(String type){
        List<Slot> toFindIn = null;
        if(type.equals("Bike")) toFindIn = bikes;
        else if(type.equals("Car")) toFindIn = cars;
        else toFindIn = trucks;

        for(Slot slot : toFindIn) if(slot.vehicle == null) return slot;


        return null;
    }

    public Ticket getTicket(String number , String ownerName , String type ){
        Slot fillSlot = null;
        Vehicle v1 = null;
        if(type.equals("Bike")){
            fillSlot = findSlot2("Bike",number , ownerName);
//            v1 = findVehicle("Bike" , number , ownerName);
        }else if(type.equals("Car")){
            fillSlot = findSlot2("Car",number , ownerName);
//            v1 = findVehicle("Car" , number , ownerName);
        }else{
            fillSlot = findSlot2("Truck",number , ownerName);
//            v1 = findVehicle("Truck" , number , ownerName);
        }
        v1 = fillSlot.vehicle ;

        Ticket t1 = findTicket(fillSlot);


        return t1;


    }

    public Ticket findTicket(Slot slot){
        for(int i=0 ; i<ticket.size() ; i++){
            if(ticket.get(i).slot.equals(slot)){
                return ticket.get(i);
            }
        }
        return null;
    }

//    public Vehicle findVehicle(String type,String number , String ownerName){
//
//    }
    public Slot findSlot2(String type,String number , String ownerName){
        Vehicle vehicle ;
        List<Slot> toFindIn = null;
        if(type.equals("Bike")) {
            vehicle= new Bike(number , ownerName);
            toFindIn = bikes;
        }
        else if(type.equals("Car")) {
            vehicle= new Car(number , ownerName);
            toFindIn = cars;
        }
        else {
            vehicle= new Truck(number , ownerName);
            toFindIn = trucks;
        }

        for(Slot slot : toFindIn) if(slot.vehicle.getNumber().equals(vehicle.getNumber())) return slot;


        return null;
    }

    public double unPark(Ticket ticket){
        LocalTime exitTime = LocalTime.now();
//        double amount = (LocalTime.now().getHour()-ticket.entryTime.getHour()) * ticket.vehicle.parkingPrice;

        double amount = (exitTime.getSecond()-ticket.entryTime.getSecond()) * ticket.vehicle.parkingPrice;

//        Ticket printing
        System.out.println(ticket);
        System.out.println("Exit Time - " + exitTime);
        ticket.slot.unpark();
        return amount;
    }
}
