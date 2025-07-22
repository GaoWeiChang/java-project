public class Main {
    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();

        FullTimeEmployee fullTime = new FullTimeEmployee(101, "John Doe", 5000);
        PartTimeEmployee partTime = new PartTimeEmployee(102, "Jane Smith", 3000, 20);
        ContractEmployee contract = new ContractEmployee(103, "Bob Johnson", 50, 35);

        // Add employees to payroll system
        payroll.addEmployee(fullTime);
        payroll.addEmployee(partTime);
        payroll.addEmployee(contract);

        payroll.displayPayrollSummary();



        System.out.println("\n=== DEMONSTRATING POLYMORPHISM ===");
        // Demonstrate polymorphism - using Employee reference
        Employee[] allEmployees = {fullTime, partTime, contract};

        double totalSalary = 0;
        for (Employee emp : allEmployees) {
            System.out.printf("%s earns $%.2f%n",
                    emp.getName(), emp.calculateSalary());
            totalSalary += emp.calculateSalary();
        }
        System.out.printf("Total using polymorphism: $%.2f%n", totalSalary);


        System.out.println("\n=== DEMONSTRATING METHOD OVERLOADING ===");
        // Show basic info (no salary)
        System.out.println("Basic Info:");
        fullTime.displayInfo();

        System.out.println("\nDetailed Info:");
        fullTime.displayInfo(true);
    }
}
