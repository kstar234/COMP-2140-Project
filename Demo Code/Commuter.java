import java.util.ArrayList;

public class Commuter extends User {
    private ArrayList<String> busRevered;

    Commuter(String name, String email, String password) {
        super(name, email, password);
        this.busRevered = new ArrayList<>();
    }
     
    public void reserveSeat(String busId, String passengerName) {
        for (Bus bus : PelicanDrive.buses) {
            if (bus.getBusId().equals(busId) && bus.reserveSeat(passengerName)) {
                busRevered.add(busId);
                return;
            }
        }
        // System.out.println("Bus with ID " + busId + " not found");
    }

    public void setBusRevered(ArrayList<String> busRevered) {
        this.busRevered = busRevered;
    }

    public ArrayList<String> getBusRevered() {
        return busRevered;
    }
}
