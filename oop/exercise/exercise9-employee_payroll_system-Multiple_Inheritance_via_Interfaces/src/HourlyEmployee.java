public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String employeeId, String name, String hireDate, double hourlyRate, double hoursWorked){
        super(employeeId, name, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getEmployeeType() {
        return "HOURLY";
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getPayPeriod() {
        return "weekly";
    }

    @Override
    public double calculateTax() {
        return calculatePay() * getTaxRate();
    }

    @Override
    public double getTaxRate() {
        return 0.18;
    }
}
