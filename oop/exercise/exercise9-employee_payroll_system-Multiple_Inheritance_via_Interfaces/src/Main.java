public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee[] employees = {
                new SalariedEmployee("E001", "John Smith", "2020-01-15", 75000),
                new HourlyEmployee("E002", "Sarah Wilson", "2021-03-10", 25, 40)
        };

        // Create contractors
        Contractor[] contractors = {
                new Contractor("C001", "Mike Johnson", 50, 20)
        };

        // Process payroll
        PayrollProcessor processor = new PayrollProcessor();
        processor.processPayroll(employees, contractors);
    }
}
