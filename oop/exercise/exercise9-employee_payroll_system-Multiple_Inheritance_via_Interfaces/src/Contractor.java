public class Contractor implements Payable {
    protected String employeeId;
    protected String name;
    private double hourlyRate;
    private double hoursWorked;

    public Contractor(String employeeId, String name, double hourlyRate, double hoursWorked){
        this.employeeId = employeeId;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // getter & setter
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getPayPeriod() {
        return "project-based";
    }

    public String getEmployeeType(){
        return "CONTRACTOR";
    }
}