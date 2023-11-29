
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Registration{
    private Schedule schedule;
    private List<Bus> retrievedSchedule;

    public Registration()
    {
        this.schedule = schedule;
        this.retrievedSchedule = schedule.getBusSchedule();
    }

    /*
    public void accessSchedule() 
    {
        List<Bus> retrievedSchedule = schedule.getBusSchedule();
    }
    */

    public void makeRegistration(int busID) {
        
        Iterator<Bus> iterator = retrievedSchedule.iterator();
        while (iterator.hasNext()) {
            Bus bus = iterator.next();
            if (bus.getBusID() == (busID)) {
                int seats = bus.getAvailableSeats();
                seats = seats - 1;
                bus.setAvailableSeats(seats);
                int reserved = bus.getReservedSeats();
                reserved = reserved + 1;
                bus.setReservedSeats(reserved);
                break;
            }

        }
        //requestNotifications();
        

    }

    public void cancelRegistration(int busID) 
    {
        Iterator<Bus> iterator = retrievedSchedule.iterator();
        while (iterator.hasNext()) {
            Bus bus = iterator.next();
            if (bus.getBusID() == (busID)) {
                int seats = bus.getAvailableSeats();
                seats = seats + 1;
                bus.setAvailableSeats(seats);
                int reserved = bus.getReservedSeats();
                reserved = reserved - 1;
                bus.setReservedSeats(reserved);
                break;
            }

        }
    }

    //feel like i can remove this entirely. 
    //This is likely to get addressed on the gui or in main. 
    //Should link directly to notif class
    /* 
    public void requestNotifications() {
        System.out.println("Do you wish to receive email or text notifications? Email: Text: No:");

    }
    */

    public void openRegistration() 
    {
        /*
        Registration opens automatically, as soon as the bus is created. maybe this will be gui?
         */
        
    }

    public void closeRegistration() {
        /*
           List<String> myList = new ArrayList<>();
         */
    }

}
