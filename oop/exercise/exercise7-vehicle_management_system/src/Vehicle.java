public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelCapacity;

    public Vehicle(String make, String model, int year, double fuelCapacity) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getFuelCapacity() { return fuelCapacity; }


    public abstract double calculateFuelEfficiency();
    public abstract String getVehicleType();

    public void displayInfo() {
        System.out.println(make + " " + model + " " + year);
    }
}
