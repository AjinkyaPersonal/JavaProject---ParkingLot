public class Truck extends Vehicle{
    int parkingPrice;
    Truck(String name , String numberPlate){
        super(name , numberPlate);
        super.parkingPrice = 40;
    }
}
