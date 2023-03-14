public class Car extends Vehicle {
    int parkingPrice;
    Car(String name , String numberPlate){
        super(name , numberPlate);
        super.parkingPrice = 20;
    }
}
