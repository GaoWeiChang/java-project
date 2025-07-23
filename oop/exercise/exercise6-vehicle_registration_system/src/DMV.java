import java.util.ArrayList;

public class DMV {
    private ArrayList<Vehicle> registeredVehicles;
    private double totalFeesCollected;

    public DMV() {
        registeredVehicles = new ArrayList<Vehicle>();
        totalFeesCollected = 0.0;
    }

    public boolean register(Vehicle vehicle) {
        vehicle.calculateRegistrationFee();
        vehicle.setRegistered(true);

        registeredVehicles.add(vehicle);

        totalFeesCollected += vehicle.getRegistrationFee();

        // Display registration info
        vehicle.displayInfo();
        System.out.println("Status: REGISTERED");
        System.out.println();

        return true;
    }

    public boolean register(String licensePlate, String owner) {
        Vehicle basicVehicle = new Vehicle(licensePlate, owner, 2023);
        return register(basicVehicle);
    }

    public Vehicle findVehicle(String licensePlate) {
        for (Vehicle vehicle: registeredVehicles) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    public void displaySummary() {
        System.out.println("=== REGISTRATION SUMMARY ===");
        System.out.println("Total Vehicles Registered: " + registeredVehicles.size());
        System.out.printf("Total Fees Collected: $%.2f%n", totalFeesCollected);
    }

    // Display all registered vehicles
    public void displayAllVehicles() {
        System.out.println("=== ALL REGISTERED VEHICLES ===");
        for (Vehicle v: registeredVehicles) {
            System.out.printf("%s - %s (%d) - Fee: $%.2f%n", v.getLicensePlate(), v.getOwner(), v.getYear(), v.getRegistrationFee());
        }
        System.out.println();
    }
}