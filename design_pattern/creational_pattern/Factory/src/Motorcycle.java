public class Motorcycle extends Vehicle {
    private double engineCapacity;
    private boolean hasCarrier;

    public Motorcycle(String model, String fuelType, double price, double engineCapacity, boolean hasCarrier){
        super(model, fuelType, price);
        this.engineCapacity = engineCapacity;
        this.hasCarrier = hasCarrier;
    }

    // getter & setter
    public double getEngineCapacity() { return engineCapacity; }
    public boolean isHasCarrier() { return hasCarrier; }

    public void setEngineCapacity(double engineCapacity) { this.engineCapacity = engineCapacity; }
    public void setHasCarrier(boolean hasCarrier) { this.hasCarrier = hasCarrier; }

    // interface method
    @Override
    public void startEngine(){
        System.out.println("Motorcycle engine started: Sport bike ready to ride!");
    }

    @Override
    public void stopEngine(){
        System.out.println("Motorcycle engine stopped: Sport bike engine");
    }

    @Override
    public String getVehicleInfo(){
        String motorcycleInfo = String.format("Vehicle Info: Motorcycle[Model: %s, Fuel: %s, Engine: %.1fCC, Price: $%.1f, Carrier: %s]",
                model, fuelType, engineCapacity, price, (hasCarrier?"Yes":"No"));
        return motorcycleInfo;
    }

    @Override
    public double calculateRegistrationFee(){
        return (0.03 * price) + 100;
    }
}
