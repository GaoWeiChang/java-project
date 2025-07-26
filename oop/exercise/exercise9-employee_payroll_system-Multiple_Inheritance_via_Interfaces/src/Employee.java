public abstract class Employee implements Payable, Taxable {
    protected String employeeId;
    protected String name;
    protected String hireDate;

    // constructor
    public Employee(String employeeId, String name, String hireDate){
        this.employeeId = employeeId;
        this.name = name;
        this.hireDate = hireDate;
    }

    // getter & setter
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getHireDate() { return hireDate; }

    // abstract method
    public abstract String getEmployeeType();
}
