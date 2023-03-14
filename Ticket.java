import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

    Vehicle vehicle;
    Slot slot;
    LocalTime entryTime;

    public Ticket (Vehicle vehicle , Slot slot){
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalTime.now();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("SlotNo - ").append(this.slot.slotNo).append("\n");
        sb.append("Name - ").append(this.vehicle.getOwnerName()).append("\n");
        sb.append("Vehicle No - ").append(this.vehicle.getNumber()).append("\t").append("Entry Time : ").append(entryTime);
        return sb.toString();
    }
}
