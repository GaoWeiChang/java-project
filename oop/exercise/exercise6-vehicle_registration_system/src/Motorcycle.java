public class Motorcycle extends Vehicle {
    private int engineCC;
    public Motorcycle(String licensePlate, String owner, int year, int engineCC) {
        super(licensePlate, owner, year);
        this.engineCC = engineCC;
    }

    @Override
    public double calculateRegistrationFee() {
        double baseFee = super.calculateRegistrationFee();
        double discount = 25.0;
        this.registrationFee = baseFee - discount;
        return this.registrationFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("Registering Motorcycle:");
        super.displayInfo();
        System.out.println("Engine: " + engineCC + "cc");
        System.out.printf("Registration Fee: $%.2f%n", registrationFee);
    }
}
