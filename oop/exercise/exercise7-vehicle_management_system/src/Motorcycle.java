public class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, double fuelCapacity){
        super(make, model, year, fuelCapacity);
    }

    @Override
    public double calculateFuelEfficiency(){
        return 40.0 + (fuelCapacity * 0.5);
    }

    @Override
    public String getVehicleType(){
        return "Motorcycle";
    }

    @Override
    public String toString(){
        return String.format("Type: %s | %s %s %d | Fuel Efficiency: %.1f MPG", getVehicleType(), make, model, year, calculateFuelEfficiency());
    }
}
