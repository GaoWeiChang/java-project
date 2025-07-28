public class Main {
    public static void main(String[] args) {
        System.out.println("=== VEHICLE MANUFACTURING SYSTEM ===\n");

        try {
            // Test Case 1: Creating a Car
            System.out.println("Creating Car...");
            Vehicle car = VehicleFactory.createCar("Sedan", "Petrol",25000.0, 4 , 2.0);
            testVehicle(car);

            System.out.println("\nCreating Motorcycle...");
            Vehicle motorcycle = VehicleFactory.createMotorcycle("Sport", "Petrol", 12000.0,600.0, false);
            testVehicle(motorcycle);

            System.out.println("\nCreating Truck...");
            Vehicle truck = VehicleFactory.createTruck("Heavy", "Diesel", 80000.0, 10.0, 3);
            testVehicle(truck);

            // Demonstrate factory pattern with generic method
            System.out.println("\n=== USING GENERIC FACTORY METHOD ===\n");

            Vehicle car2 = VehicleFactory.createVehicle(VehicleType.CAR, "SUV", "Electric", 45000.0, 5, 0.0);
            System.out.println("Created: " + car2.getVehicleInfo());

            // Test error handling
            System.out.println("\n=== ERROR HANDLING TEST ===");
            testErrorHandling();

        } catch (Exception e) {
            System.err.println("Error in main: " + e.getMessage());
        }
    }

    private static void testVehicle(Vehicle vehicle) {
        vehicle.startEngine();
        System.out.println("Vehicle Info: " + vehicle.getVehicleInfo());
        System.out.println("Registration Fee: $" + String.format("%.1f", vehicle.calculateRegistrationFee()));
        vehicle.stopEngine();
    }

    private static void testErrorHandling() {
        try {
            // Test null type
            VehicleFactory.createVehicle(null, "Test");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Null type handled: " + e.getMessage());
        }

        try {
            // Test wrong number of parameters
            VehicleFactory.createVehicle(VehicleType.CAR, "Model");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Wrong parameters handled: " + e.getMessage());
        }

        try {
            // Test wrong parameter types
            VehicleFactory.createVehicle(VehicleType.CAR, "Model", "Fuel", "NotAnInteger", 25000.0, 2.0);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Wrong parameter types handled: " + e.getMessage());
        }
    }
}
