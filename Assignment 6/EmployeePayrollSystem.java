import java.util.ArrayList;

abstract class Employee {
    protected int empId;
    protected String name;
    protected String PANNo;
    protected String joiningDate;
    protected String designation; // Maps to role

    public Employee(int empId, String name, String PANNo, String joiningDate, String designation) {
        this.empId = empId;
        this.name = name;
        this.PANNo = PANNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
    }

    public abstract double calcCTC();

    public void printDetails() {
        System.out.println("EmpID       : " + empId);
        System.out.println("Name        : " + name);
        System.out.println("Designation : " + designation);
        System.out.println("PAN No      : " + PANNo);
        System.out.println("Joining Date: " + joiningDate);
        System.out.printf("Calculated CTC: INR %.2f%n", calcCTC());
    }
}

class FullTimeEmployee extends Employee {
    protected double baseSalary;
    protected double perfBonus;
    protected double hiringCommision;

    public FullTimeEmployee(int empId, String name, String PANNo, String joiningDate, String designation, 
                            double baseSalary, double perfBonus, double hiringCommision) {
        super(empId, name, PANNo, joiningDate, designation);
        this.baseSalary = baseSalary;
        this.perfBonus = perfBonus;
        this.hiringCommision = hiringCommision;
    }

    @Override
    public double calcCTC() {
        if (designation.equalsIgnoreCase("SWE")) {
            return baseSalary + perfBonus;
        } else if (designation.equalsIgnoreCase("HR")) {
            return baseSalary + hiringCommision;
        }
        // Base case for other full-time roles
        return baseSalary;
    }
}

class ContractEmployee extends Employee {
    private int noOfHrs;
    private double hourlyRate;

    public ContractEmployee(int empId, String name, String PANNo, String joiningDate, String designation, 
                            int noOfHrs, double hourlyRate) {
        super(empId, name, PANNo, joiningDate, designation);
        this.noOfHrs = noOfHrs;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcCTC() {
        return noOfHrs * hourlyRate;
    }
}

class Manager extends FullTimeEmployee {
    private double TA;
    private double eduAllowance;

    public Manager(int empId, String name, String PANNo, String joiningDate, String designation, 
                   double baseSalary, double perfBonus, double TA, double eduAllowance) {
        // Manager extends FullTimeEmployee, hiringCommision not primarily used here
        super(empId, name, PANNo, joiningDate, designation, baseSalary, perfBonus, 0.0);
        this.TA = TA;
        this.eduAllowance = eduAllowance;
    }

    @Override
    public double calcCTC() {
        // baseSalary + perfBonus + TA + eduAllowance
        return baseSalary + perfBonus + TA + eduAllowance;
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        System.out.println("=== Employee Payroll System ===");
        
        ArrayList<Employee> staff = new ArrayList<>();

        // SWE Example
        staff.add(new FullTimeEmployee(101, "Alice", "ABCDE1234F", "2022-01-10", "SWE", 
                                       80000, 15000, 0));
        
        // HR Example
        staff.add(new FullTimeEmployee(102, "Bob", "FGHIJ5678K", "2021-05-20", "HR", 
                                       60000, 0, 10000));
        
        // Contract Employee Example
        staff.add(new ContractEmployee(103, "Charlie", "KLMON9012P", "2023-03-15", "Contract SWE", 
                                       160, 500));
        
        // Manager Example
        staff.add(new Manager(104, "Diana", "QRSTU3456V", "2018-11-01", "Manager", 
                              100000, 25000, 10000, 5000));

        // Print details and CTC for all employees
        for (Employee e : staff) {
            e.printDetails();
            System.out.println("----------------------------------------");
        }
    }
}