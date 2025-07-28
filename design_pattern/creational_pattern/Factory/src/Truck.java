public class Truck extends Vehicle {
    private double loadCapacity;
    private int numberOfAxles;

    public Truck(String model, String fuelType, double price, double loadCapacity, int numberOfAxles){
        super(model, fuelType, price);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
    }

    // getter & setter
    public double getLoadCapacity() { return loadCapacity; }
    public int getNumberOfAxles() { return numberOfAxles; }

    public void setLoadCapacity(double loadCapacity) { this.loadCapacity = loadCapacity; }
    public void setNumberOfAxles(int numberOfAxles) { this.numberOfAxles = numberOfAxles; }

    // interface method
    @Override
    public void startEngine(){
        System.out.println("Truck engine started: Heavy duty truck engine running!");
    }

    @Override
    public void stopEngine(){
        System.out.println("Truck engine stopped: Heavy duty truck engine shut down.");
    }

    @Override
    public String getVehicleInfo(){
        String truckInfo = String.format("Vehicle Info: Truck[Model: %s, Fuel: %s, Load: %.1f tons, Price: $%.1f, Axles: %d]",
                model, fuelType, loadCapacity, price, numberOfAxles);
        return truckInfo;
    }

    @Override
    public double calculateRegistrationFee(){
        return (0.08 * price) + 500;
    }
}
