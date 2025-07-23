public class Truck extends Vehicle {
    private int weight;
    public Truck(String licensePlate, String owner, int year, int weight){
        super(licensePlate, owner, year);
        this.weight = weight;
    }

    @Override
    public double calculateRegistrationFee() {
        double baseFee = super.calculateRegistrationFee();
        double weightFee = (weight/1000) * 20; // $20 per 1000 lbs
        this.registrationFee = baseFee + weightFee;
        return this.registrationFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("Registering Truck:");
        super.displayInfo();
        System.out.println("Weight Capacity: " + weight + " lbs");
        System.out.printf("Registration Fee: $%.2f%n", registrationFee);
    }
}
