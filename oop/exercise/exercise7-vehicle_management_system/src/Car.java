public class Car extends Vehicle{
    protected int numberOfDoors;

    public Car(String make, String model, int year, double fuelCapacity, int numberOfDoors){
        super(make, model, year, fuelCapacity);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors(){
        return numberOfDoors;
    }

    @Override
    public double calculateFuelEfficiency(){
        return 30.0 + (fuelCapacity * 0.5);
    }

    @Override
    public String getVehicleType(){
        return "Car";
    }

    @Override
    public String toString(){
        return String.format("Type: %s | %s %s %d | Doors: %d | Fuel Efficiency: %.1f MPG", getVehicleType(), make, model, year, numberOfDoors, calculateFuelEfficiency());
    }
}
