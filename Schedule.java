import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


class Schedule {
    // ArrayList attribute
    private List<Bus> busSchedule;

    // Constructor
    public Schedule() 
    {
        // Initialize the ArrayList in the constructor
        this.busSchedule = new ArrayList<>();
    }

    // Method to add a Bus object to the ArrayList
    public void addBus(Bus bus) {
        busSchedule.add(bus);
    }

    // Method to get the entire ArrayList
    public List<Bus> getBusSchedule() {
        return busSchedule;
    }

    // Method to delete a Bus object from the ArrayList
    public void deleteBus(int busID) {
        Iterator<Bus> iterator = busSchedule.iterator();
        while (iterator.hasNext()) {
            Bus bus = iterator.next();
            if (bus.getBusID() == busID) {
                iterator.remove();
                System.out.println(busID + " has been deleted.");
                return;
            }
        }
        System.out.println("Bus with ID " + busID + " not found.");
    }

    // Method to edit a Bus object in the ArrayList
    public void editBus(int busID, int availableSeats, int reservedSeats, String driver, String arrivalTime, String arrivalDate, String busRoute) {
        for (Bus Bus : busSchedule) {
            if (Bus.getBusID() == busID) {
                Bus.setAvailableSeats(availableSeats);
                Bus.setReservedSeats(reservedSeats);
                Bus.setDriver(driver);
                Bus.setArrivalTime(arrivalTime);
                Bus.setArrivalDate(arrivalDate);
                Bus.setBusRoute(busRoute);
                System.out.println(busID + " has been edited to " + availableSeats + ".");
                return;
            }
        }
        System.out.println("Bus with ID " + busID + " not found.");
    }

    /* 
    public static void main(String[] args) {
        // Create an instance of Schedule
        Schedule busSchedule = new Schedule();

        // Create some Bus objects
        Bus Bus1 = new Bus(1,30,0,"John","8:00 a.m.","Monday","Half Way Tree to Uwi Mona");
        Bus Bus2 = new Bus(2,20,0,"Peter","2:00 p.m.","Tuesday","Uwi Mona to Half Way Tree");

        // Add Bus objects to the ArrayList
        busSchedule.addBus(Bus1);
        busSchedule.addBus(Bus2);

        // Access the ArrayList
        List<Bus> retrievedList = busSchedule.getBusSchedule();

        
        // Print the elements in the ArrayList
        System.out.println("Before deletion:");
        for (Bus Bus : retrievedList) {
            System.out.println("Name: " + Bus.getName() + ", Age: " + Bus.getAge());
        }
        

        // Delete a Bus
        busSchedule.deleteBus();

        // Print the elements in the ArrayList after deletion
        System.out.println("\nAfter deletion:");
        for (Bus Bus : busSchedule.getPeopleList()) {
            System.out.println("Name: " + Bus.getName() + ", Age: " + Bus.getAge());
        }

        // Edit a Bus
        busSchedule.editBus("Jane", "Janet", 35);

        // Print the elements in the ArrayList after editing
        System.out.println("\nAfter editing:");
        for (Bus Bus : busSchedule.getPeopleList()) {
            System.out.println("Name: " + Bus.getName() + ", Age: " + Bus.getAge());

            
        }
        */

}
