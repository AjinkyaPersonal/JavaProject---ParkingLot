abstract class Vehicle {
    private String ownerName;
    private String number;
    int parkingPrice;

    Vehicle(String number , String ownerName){
        this.ownerName = ownerName;
        this.number = number;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public void setOwnerName(){
        this.ownerName = ownerName;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(){
        this.number=number;
    }


}
