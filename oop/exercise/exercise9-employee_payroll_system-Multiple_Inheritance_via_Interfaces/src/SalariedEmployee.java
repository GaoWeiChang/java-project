public class SalariedEmployee extends Employee implements Benefitable {
    private double annualSalary;

    public SalariedEmployee(String employeeId, String name, String hireDate, double annualSalary){
        super(employeeId, name, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public String getEmployeeType() {
        return "SALARIED";
    }

    @Override
    public double calculatePay(){
        return annualSalary / 26;
    }

    @Override
    public String getPayPeriod(){
        return "bi-weekly";
    }

    @Override
    public double calculateTax(){
        return calculatePay() * getTaxRate();
    }

    @Override
    public double getTaxRate(){
        return 0.22;
    }

    @Override
    public double calculateBenefits() {
        return 150.0;
    }

    @Override
    public String getBenefitPackage() {
        return "Health, Dental, Vision, 401k";
    }
}
