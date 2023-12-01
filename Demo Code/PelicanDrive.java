import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class PelicanDrive {
    static ArrayList<Bus> buses;
    static ArrayList<User> userRecord;
    static Manager manager;

    public PelicanDrive() {
        PelicanDrive.buses = new ArrayList<>();
        PelicanDrive.userRecord = new ArrayList<>();
        PelicanDriveWindow frame = new PelicanDriveWindow();
    }

    public static void main(String[] args) {
        PelicanDrive pelicanDrive = new PelicanDrive();
        pelicanDrive.updateSystem("BusDB.txt", "CommuterDB.txt");
    }
    
    private void reset(){

    }

    public void updateSystem(String busFilename, String userFilename){
        updateSystemB(busFilename);
        updateSystemU(userFilename);
    }

    public void updateSystemB(String busFilename){
        readBusData(busFilename);
    }

    public void updateSystemU(String userFilename){
        readUserData(userFilename);
    }

    private void readUserData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(";"); // Assuming data is comma-separated

                // Assuming Bus class has a constructor that accepts data fields
               Commuter commuter = new Commuter(userData[0], userData[1], userData[2]);
               commuter.setBusRevered(stringToArray(userData[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readBusData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] busData = line.split(";"); // Assuming data is comma-separated

                // Assuming Bus class has a constructor that accepts data fields
                Bus bus = new Bus(busData[0], busData[1], Integer.parseInt(busData[2]));
                bus.setArrTime(timeToLocalTime(busData[3]));
                bus.setDepTime(timeToLocalTime(busData[4]));
                bus.setPassengerList(stringToArray(busData[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> stringToArray(String slist){
        String slistWithoutBrackets = slist.replaceAll("\\[|\\]|\\s", "");
        String[] stringArray = slistWithoutBrackets.split(", ");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArray));
        return(arrayList);
    }

    public LocalTime timeToLocalTime(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return LocalTime.parse(time, formatter);
    }
}
