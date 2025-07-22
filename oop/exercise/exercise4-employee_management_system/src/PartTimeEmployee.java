public class PartTimeEmployee extends Employee{
    private int _hoursWorked;

    PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked){
        super(employeeId, name, baseSalary);
        _hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return _hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return _baseSalary * _hoursWorked / 40;
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time Employee";
    }

    @Override
    public void displayInfo(boolean detailed) {
        displayInfo();
        System.out.println("Hours Worked: " + _hoursWorked);
        if (detailed) {
            System.out.printf("Monthly Salary: $%.2f\n", calculateSalary());
        }
    }
}
