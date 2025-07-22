abstract class Employee {

    protected int _employeeId;
    protected String _name;
    protected double _baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        _employeeId = employeeId;
        _name = name;
        _baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return _employeeId;
    }

    public String getName() {
        return _name;
    }

    public double getBaseSalary() {
        return _baseSalary;
    }

    public abstract double calculateSalary();

    public abstract String getEmployeeType();

    public void displayInfo() {
        System.out.println("Employee: " + _name + " (ID: " + _employeeId + ")");
        System.out.println("Type: " + getEmployeeType());
    }

    public void displayInfo(boolean detailed) {
        displayInfo();
        if (detailed) {
            System.out.printf("Monthly Salary: $%.2f\n", calculateSalary());
        }
    }
}
