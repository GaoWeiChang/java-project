public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, Object... params){
        if (type == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null");
        }

        try{
            switch (type){
                case CAR:
                    if (params.length != 5){
                        throw new IllegalArgumentException("Car requires 5 parameters: model, fuelType, doors, price, engineCapacity");
                    }
                    return new Car(
                                (String) params[0], // model
                                (String) params[1], // fuelType
                                (double) params[2], // price
                                (int) params[3], // numberOfDoors
                                (double) params[4] // engineCapacity
                    );

                case MOTORCYCLE:
                    if (params.length != 5) {
                        throw new IllegalArgumentException("Motorcycle requires 5 parameters: model, fuelType, engineCapacity, price, hasCarrier");
                    }
                    return new Motorcycle(
                            (String) params[0],  // model
                            (String) params[1],  // fuelType
                            (double) params[2],  // engineCapacity
                            (double) params[3],  // price
                            (boolean) params[4]  // hasCarrier
                    );

                case TRUCK:
                    if (params.length != 5) {
                        throw new IllegalArgumentException("Truck requires 5 parameters: model, fuelType, loadCapacity, price, numberOfAxles");
                    }
                    return new Truck(
                            (String) params[0],  // model
                            (String) params[1],  // fuelType
                            (double) params[2],  // loadCapacity
                            (double) params[3],  // price
                            (int) params[4]  // numberOfAxles
                    );

                default:
                    throw new IllegalArgumentException("Unknown vehicle type: " + type);
            }
        } catch (ClassCastException e){
            throw new IllegalArgumentException("Invalid parameter types for " + type + ": " + e.getMessage());
        }
    }

    public static Car createCar(String model, String fuelType, double price, int numberOfDoors, double engineCapacity) {
        return (Car) createVehicle(VehicleType.CAR, model, fuelType, price, numberOfDoors, engineCapacity);
    }

    public static Motorcycle createMotorcycle(String model, String fuelType, double price, double engineCapacity, boolean hasCarrier) {
        return (Motorcycle) createVehicle(VehicleType.MOTORCYCLE, model, fuelType, price, engineCapacity, hasCarrier);
    }

    public static Truck createTruck(String model, String fuelType, double price, double loadCapacity, int numberOfAxles) {
        return (Truck) createVehicle(VehicleType.TRUCK, model, fuelType, price, loadCapacity, numberOfAxles);
    }
}
