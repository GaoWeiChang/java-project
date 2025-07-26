public class PayrollProcessor {
    public void processPayroll(Employee[] employees, Contractor[] contractors){
        System.out.println("=== Payroll Processing ===\n");
        double totalGross = 0, totalTax = 0, totalBenefits = 0, totalNet = 0;

        // Process Employees
        for (Employee emp : employees) {
            double gross = emp.calculatePay();
            double tax = emp.calculateTax();
            double benefits = (emp instanceof Benefitable) ? ((Benefitable) emp).calculateBenefits() : 0;
            double net = gross - tax - benefits;

            totalGross += gross;
            totalTax += tax;
            totalBenefits += benefits;
            totalNet += net;

            printPayStub(emp.getName(), emp.getEmployeeId(), emp.getEmployeeType(),
                    gross, tax, benefits, net, emp.getPayPeriod());
        }

        // Process Contractors
        for (Contractor contractor : contractors) {
            double gross = contractor.calculatePay();
            double net = gross; // No tax or benefits

            totalGross += gross;
            totalNet += net;

            printPayStub(contractor.getName(), contractor.getEmployeeId(),
                    contractor.getEmployeeType(), gross, 0, 0, net, contractor.getPayPeriod());
        }

        printSummary(totalGross, totalTax, totalBenefits, totalNet);
    }

    private void printPayStub(String name, String id, String type, double gross,
                              double tax, double benefits, double net, String period) {
        System.out.printf("Employee: %s (%s) - %s%n", name, id, type);
        System.out.printf("Gross Pay: $%.2f (%s)%n", gross, period);
        System.out.printf("Tax (%.0f%%): $%.2f%n",
                tax > 0 ? (tax/gross)*100 : 0, tax);
        System.out.printf("Benefits: $%.2f%n", benefits);
        System.out.printf("Net Pay: $%.2f%n%n", net);
    }

    private void printSummary(double totalGross, double totalTax, double totalBenefits, double totalNet) {
        System.out.println("=== Payroll Summary ===");
        System.out.printf("Total Gross Pay: $%.2f%n", totalGross);
        System.out.printf("Total Taxes: $%.2f%n", totalTax);
        System.out.printf("Total Benefits: $%.2f%n", totalBenefits);
        System.out.printf("Total Net Pay: $%.2f%n", totalNet);
        System.out.printf("Company Total Cost: $%.2f%n", totalGross + totalBenefits);
    }
}
