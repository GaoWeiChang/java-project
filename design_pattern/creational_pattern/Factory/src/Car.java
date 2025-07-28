public class Car extends Vehicle {
    private int numberOfDoors;
    private double engineCapacity;

    public Car(String model, String fuelType, double price, int numberOfDoors, double engineCapacity){
        super(model, fuelType, price);
        this.numberOfDoors = numberOfDoors;
        this.engineCapacity = engineCapacity;
    }

    // getter & setter
    public int getNumberOfDoors() { return numberOfDoors; }
    public double getEngineCapacity() { return engineCapacity; }

    public void setNumberOfDoors(int numberOfDoors) { this.numberOfDoors = numberOfDoors; }
    public void setEngineCapacity(double engineCapacity) { this.engineCapacity = engineCapacity; }

    // interface method
    @Override
    public void startEngine(){
        System.out.println("Car engine started: Sedan roaring to life!");
    }

    @Override
    public void stopEngine(){
        System.out.println("Car engine stopped: Sedan engine turned off.");
    }

    @Override
    public String getVehicleInfo(){
        String carInfo = String.format("Vehicle Info: Car[Model: %s, Fuel: %s, Doors: %d, Price: $%.1f, Engine: %.1fL]",
                                        model, fuelType, numberOfDoors, price, engineCapacity);
        return carInfo;
    }

    @Override
    public double calculateRegistrationFee(){
        return (0.05 * price) + 200;
    }
}
