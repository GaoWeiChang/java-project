public class Main {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Management System Test ===\n");

        // Create VehicleManager instance
        VehicleManager manager = new VehicleManager();

        // Test 1: Create different types of vehicles
        System.out.println("1. Creating Vehicles...");

        // Create a Car
        Car car = new Car("Toyota", "Camry", 2022, 15.5, 4);
        manager.addVehicle(car);
        System.out.println("✓ Created: " + car.getMake() + " " + car.getModel());

        // Create a Motorcycle
        Motorcycle motorcycle = new Motorcycle("Harley Davidson", "Street 750", 2021, 5.0);
        manager.addVehicle(motorcycle);
        System.out.println("✓ Created: " + motorcycle.getMake() + " " + motorcycle.getModel());

        // Create a Truck
        Truck truck = new Truck("Ford", "F-150", 2023, 26.0, 1000.0);
        manager.addVehicle(truck);
        System.out.println("✓ Created: " + truck.getMake() + " " + truck.getModel());

        System.out.println();



        // Test 2: Display all vehicles using polymorphism
        System.out.println("2. Displaying All Vehicles (Polymorphism Demo):");
        manager.displayVehicles();
        System.out.println();




        // Test 3: Test individual vehicle methods
        System.out.println("3. Individual Vehicle Testing:");

        // Test Car specific methods
        System.out.println("Car Details:");
        car.displayInfo();
        System.out.println("Vehicle Type: " + car.getVehicleType());
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " MPG");
        System.out.println("Number of Doors: " + car.getNumberOfDoors());
        System.out.println();

        // Test Motorcycle specific methods
        System.out.println("Motorcycle Details:");
        motorcycle.displayInfo();
        System.out.println("Vehicle Type: " + motorcycle.getVehicleType());
        System.out.println("Fuel Efficiency: " + motorcycle.calculateFuelEfficiency() + " MPG");
        System.out.println();

        // Test Truck specific methods
        System.out.println("Truck Details:");
        truck.displayInfo();
        System.out.println("Vehicle Type: " + truck.getVehicleType());
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " MPG");
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " lbs");
        System.out.println();



        // Test 4: Find most fuel efficient vehicle
        System.out.println("4. Finding Most Fuel Efficient Vehicle:");
        Vehicle mostEfficient = manager.findMostFuelEfficient();
        if (mostEfficient != null) {
            System.out.println("Most Fuel Efficient: " + mostEfficient.getMake() + " " +
                    mostEfficient.getModel() + " (" +
                    mostEfficient.calculateFuelEfficiency() + " MPG)");
        }
        System.out.println();

        // Test 5: Add more vehicles and test again
        System.out.println("5. Adding More Vehicles for Extended Testing:");

        Car sportsCar = new Car("BMW", "M3", 2023, 16.6, 2);
        Motorcycle cruiser = new Motorcycle("Honda", "Gold Wing", 2022, 5.5);
        Truck heavyTruck = new Truck("Chevrolet", "Silverado", 2023, 28.0, 1200.0);

        manager.addVehicle(sportsCar);
        manager.addVehicle(cruiser);
        manager.addVehicle(heavyTruck);

        System.out.println("✓ Added 3 more vehicles");
        System.out.println();

        // Display updated fleet
        System.out.println("6. Updated Vehicle Fleet:");
        manager.displayVehicles();
        System.out.println();

        // Find most efficient from larger fleet
        System.out.println("7. Most Efficient from Expanded Fleet:");
        Vehicle newMostEfficient = manager.findMostFuelEfficient();
        if (newMostEfficient != null) {
            System.out.println("Most Fuel Efficient: " + newMostEfficient.getMake() + " " +
                    newMostEfficient.getModel() + " " + newMostEfficient.getYear() +
                    " (" + newMostEfficient.calculateFuelEfficiency() + " MPG)");
        }
        System.out.println();


        // Test 6: Demonstrate polymorphism with array
        System.out.println("8. Polymorphism Demonstration with Array:");
        Vehicle[] vehicleArray = {car, motorcycle, truck, sportsCar};

        System.out.println("Processing vehicles polymorphically:");
        for (Vehicle v : vehicleArray) {
            System.out.printf("%-20s: %6.1f MPG (%s)%n",
                    v.getMake() + " " + v.getModel(),
                    v.calculateFuelEfficiency(),
                    v.getVehicleType());
        }
        System.out.println();

        // Test 7: Test toString methods
        System.out.println("9. Testing toString() Methods:");
        System.out.println("Car toString(): " + car.toString());
        System.out.println("Motorcycle toString(): " + motorcycle.toString());
        System.out.println("Truck toString(): " + truck.toString());
        System.out.println();

        System.out.println("=== All Tests Completed Successfully! ===");
    }
}
