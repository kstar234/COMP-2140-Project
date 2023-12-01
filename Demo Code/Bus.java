import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Bus
 */
public class Bus {
    private String busId;
    private String route;
    private LocalTime depTime;
    private LocalTime arrTime;
    private int availableSeats;
    private ArrayList<String> passengerList;

    public Bus(String busId, String route, int capacity) {
        this.busId = busId;
        this.route = route;
        this.availableSeats = capacity;
        this.passengerList = new ArrayList<>();
    }

    public boolean reserveSeat(String passengerName) {
        if (availableSeats > 0) {
            passengerList.add(passengerName);
            availableSeats--;
            return true;
            // System.out.println("Seat reserved for " + passengerName + " on bus " +
            // busId);
        } else {
            return false;
            // System.out.println("Sorry, no more seats available on bus " + getBusId());
        }
    }

    public String getBusId() {
        return busId;
    }

    public String getRoute() {
        return route;
    }

    public LocalTime getDepTime() {
        return depTime;
    }

    public LocalTime getArrTime() {
        return arrTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public ArrayList<String> getPassengerList() {
        return passengerList;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setArrTime(LocalTime arrTime) {
        this.arrTime = arrTime;
    }

    public void setDepTime(LocalTime depTime) {
        this.depTime = depTime;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setPassengerList(ArrayList<String> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return getBusId() + ";" + getRoute() + ";" + getAvailableSeats() + ";" + getArrTime() + ";" + getDepTime() + ";"
                + getPassengerList();
    }
}