public class Main {
    public static void main(String[] args) {
        System.out.println("=== DMV REGISTRATION SYSTEM ===");
        System.out.println();

        DMV dmv = new DMV();

        Car car = new Car("ABC123", "John Smith", 2020, 2.5);
        Motorcycle motorcycle = new Motorcycle("XYZ789", "Mike Johnson", 2019, 600);
        Truck truck = new Truck("TRK456", "Transport Co.", 2021, 5000);

        dmv.register(car);
        dmv.register(motorcycle);
        dmv.register(truck);

        System.out.println("Registering basic vehicle:");
        dmv.register("BASIC01", "Jane Doe");

        dmv.displayAllVehicles();
        dmv.displaySummary();


        // Demonstrate polymorphism
        System.out.println("\n=== POLYMORPHISM DEMO ===");
        Vehicle[] vehicles = {car, motorcycle, truck};

        for (Vehicle v : vehicles) {
            System.out.printf("Vehicle %s fee: $%.2f%n", v.getLicensePlate(), v.calculateRegistrationFee());
        }



        // Find a specific vehicle
        System.out.println("\n=== VEHICLE LOOKUP ===");
        Vehicle found = dmv.findVehicle("XYZ789");
        if (found != null) {
            System.out.println("Found vehicle: " + found.getLicensePlate() + " owned by " + found.getOwner());
        }
    }
}
