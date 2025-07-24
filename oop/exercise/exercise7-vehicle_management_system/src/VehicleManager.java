import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> vehicles;

    public VehicleManager(){
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void displayVehicles(){
        System.out.println("=== All Vehicle ===");
        for(Vehicle vehicle: vehicles){
            System.out.println(vehicle.toString());
        }
    }

    public Vehicle findMostFuelEfficient(){
        double mostEfficient = -1;
        Vehicle res = null;
        for (Vehicle vehicle: vehicles){
            double fuelEfficiency = vehicle.calculateFuelEfficiency();
            if (fuelEfficiency > mostEfficient){
                mostEfficient = fuelEfficiency;
                res = vehicle;
            }
        }
        return res;
    }
}
