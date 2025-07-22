import java.util.ArrayList;

public class PayrollSystem {
    private final ArrayList<Employee> employees;

    public PayrollSystem() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayAllEmployees() {
        System.out.println("\n=== PAYROLL SYSTEM ===");
        for (Employee employee : employees) {
            employee.displayInfo(true);
            System.out.println();
        }
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }
        return total;
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee: employees){
            if(employee.getEmployeeId() == id){
                return employee;
            }
        }
        return null;
    }

    public void displayPayrollSummary() {
        displayAllEmployees();
        System.out.printf("Total Payroll: $%.2f%n", calculateTotalPayroll());
    }
}