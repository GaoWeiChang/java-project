public class Vehicle {
    protected String licensePlate;
    protected String owner;
    protected int year;
    protected double registrationFee;
    protected boolean isRegistered;

    public Vehicle(String licensePlate, String owner, int year) {
        this.licensePlate = licensePlate;
        this.owner = owner;
        this.year = year;
        this.registrationFee = 0.0;
        this.isRegistered = false;
    }

    public void setRegistered(boolean registered) {
        this.isRegistered = registered;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwner() {
        return owner;
    }

    public int getYear() {
        return year;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public double calculateRegistrationFee(){
        return 100.0;
    }

    public void displayInfo() {
        System.out.println("License: " + licensePlate);
        System.out.println("Owner: " + owner);
        System.out.println("Year: " + year);
    }
}
