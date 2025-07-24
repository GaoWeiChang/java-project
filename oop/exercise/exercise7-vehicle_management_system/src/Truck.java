public class Truck extends Vehicle {
    protected double cargoCapacity;
    public Truck(String make, String model, int year, double fuelCapacity, double cargoCapacity){
        super(make, model, year, fuelCapacity);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity(){
        return cargoCapacity;
    }

    @Override
    public double calculateFuelEfficiency(){
        return 15.0  + (fuelCapacity * 0.5);
    }

    @Override
    public String getVehicleType(){
        return "Truck";
    }

    @Override
    public String toString(){
        return String.format("Type: %s | %s %s %d | Cargo: %.1f lbs | Fuel Efficiency: %.1f MPG", getVehicleType(), make, model, year, cargoCapacity, calculateFuelEfficiency());
    }
}
