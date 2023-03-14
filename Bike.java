public class Bike extends Vehicle {
    int parkingPrice;
    Bike(String name , String numberPlate){
        super(name , numberPlate);
        super.parkingPrice = 10;
    }
}
