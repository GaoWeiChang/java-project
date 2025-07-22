class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return _baseSalary;
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time Employee";
    }
}
