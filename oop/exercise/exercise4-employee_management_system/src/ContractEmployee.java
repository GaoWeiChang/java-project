public class ContractEmployee extends Employee{
    private int _hoursWorked;
    private double _hourlyRate;

    public ContractEmployee(int employeeId, String name, double hourlyRate, int hoursWorked){
        super(employeeId, name, 0);
        _hourlyRate = hourlyRate;
        _hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return _hourlyRate;
    }

    public int getHoursWorked() {
        return _hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return _hourlyRate * _hoursWorked;
    }

    @Override
    public String getEmployeeType() {
        return "Contract Employee";
    }

    @Override
    public void displayInfo(boolean detailed) {
        displayInfo();
        System.out.printf("Hours Worked: %d, Rate: $%.2f%n", _hoursWorked, _hourlyRate);
        if (detailed) {
            System.out.printf("Monthly Salary: $%.2f\n", calculateSalary());
        }
    }
}
