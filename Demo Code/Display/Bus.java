public class Bus {
    private int busID;
    private int availableSeats;
    private int reservedSeats;
    private String driver;
    private String arrivalTime;
    private String arrivalDate;
    private String busRoute;


    // Constructor to initialize the class
    public Bus(int busID, int availableSeats, int reservedSeats, String driver, String arrivalTime, String arrivalDate, String busRoute) {
        this.busID = busID;
        this.availableSeats = availableSeats;
        this.reservedSeats = 0;
        this.driver = driver;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.busRoute = busRoute;
}

    public void setBusID(int busID) 
    {
        this.busID = busID;
    }

    public int getBusID() 
    {
        return busID;
    }

    public void setAvailableSeats(int availableSeats) 
    {
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() 
    {
        return availableSeats;
    }

    public void setReservedSeats(int reservedSeats) 
    {
        this.reservedSeats = reservedSeats;
    }

    public int getReservedSeats() 
    {
        return reservedSeats;
    }

    public void setDriver(String driver) 
    {
        this.driver = driver;
    }

    public String getDriver() 
    {
        return driver;
    }

    public void setArrivalTime(String arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTime() 
    {
        return arrivalTime;
    }

    public void setArrivalDate(String arrivalDate) 
    {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalDate() 
    {
        return arrivalDate;
    }

    public void setBusRoute(String busRoute) 
    {
        this.busRoute = busRoute;
    }

    public String getBusRoute() 
    {
        return busRoute;
    }



}