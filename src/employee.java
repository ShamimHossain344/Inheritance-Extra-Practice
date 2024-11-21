// Base class
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [Name: " + name + ", Salary: $" + salary + "]";
    }
}

// Subclass: Manager
class Manager extends Employee {
    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Manager [Name: " + getName() + ", Department: " + department + ", Salary: $" + getSalary() + "]";
    }
}

// Subclass: Executive
class Executive extends Manager {

    public Executive(String name, double salary, String department) {
        super(name, salary, department);
    }

    @Override
    public String toString() {
        return "Executive [Name: " + getName() + ", Department: " + getDepartment() + ", Salary: $" + getSalary() + "]";
    }
}

// Test Program
public class Main {
    public static void main(String[] args) {
        // Create an Employee
        Employee employee = new Employee("John Doe", 50000.0);
        System.out.println(employee);

        // Create a Manager
        Manager manager = new Manager("Jane Smith", 80000.0, "IT");
        System.out.println(manager);

        // Create an Executive
        Executive executive = new Executive("Alice Johnson", 120000.0, "Finance");
        System.out.println(executive);
    }
}
