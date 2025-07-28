public abstract class Vehicle implements VehicleOperations {
    protected String model;
    protected String fuelType;
    protected double price;

    public Vehicle(String model, String fuelType, double price){
        this.model = model;
        this.fuelType = fuelType;
        this.price = price;
    }

    // getter & setter
    public String getModel() { return model; }
    public String getFuelType() { return fuelType; }
    public double getPrice() { return price; }

    public void setModel(String model) { this.model = model; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    public void setPrice(double price) { this.price = price; }

}
