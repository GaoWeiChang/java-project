public class Car extends Vehicle {
    private double engineSize; // liters

    public Car(String licensePlate, String owner, int year, double engineSize) {
        super(licensePlate, owner, year);
        this.engineSize = engineSize;
    }

    @Override
    public double calculateRegistrationFee() {
        double baseFee = super.calculateRegistrationFee();
        double engineFee = engineSize * 20; // $20 per liter
        this.registrationFee = baseFee + engineFee;
        return this.registrationFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("Registering Car:");
        super.displayInfo();
        System.out.println("Engine: " + engineSize + "L");
        System.out.printf("Registration Fee: $%.2f%n", registrationFee);
    }
}