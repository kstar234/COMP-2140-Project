
public class Manager extends User{

    Manager(String name, String email, String password) {
        super(name, email, password);
    }

    public void addBus(String busId, String route, int capacity) {
        Bus newBus = new Bus(busId, route, capacity);
        PelicanDrive.buses.add(newBus);
        // System.out.println("New bus added - Bus ID: " + busId + ", Route: " + route + ", Capacity: " + capacity);
    }

    public void setRoute(String busId, String newRoute) {
        for (Bus bus : PelicanDrive.buses) {
            if (bus.getBusId().equals(busId)) {
                bus.setRoute(newRoute);
                System.out.println("Route updated for bus " + busId + " - New Route: " + newRoute);
                return;
            }
        }
        System.out.println("Bus with ID " + busId + " not found");
    }
}
