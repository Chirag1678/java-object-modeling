import java.util.ArrayList;

// Employee class (Part of department)
class Employee {
    // Attributes
    private final String name;

    // Constructor
    Employee(String name) {
        this.name = name;
    }

    // Method to get Employee's name
    public String getName() {
        return name;
    }
}

// Department Class -> Composition with company
class Department {
    // Attributes
    private final String name;
    private final ArrayList<Employee> employees;

    // Constructor
    Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Method to add employee to department
    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    // Method to get department name
    public String getName() {
        return name;
    }

    // Method to display employees in a department
    public void displayEmployees() {
        System.out.println("Department Name: " + name);
        for (Employee employee : employees) {
            System.out.println("Employee Name: " + employee.getName());
        }
        System.out.println();
    }
}

// Company class -> owns multiple Departments (Composition)
class Company {
    // Attributes
    private final String name;
    private final ArrayList<Department> departments;

    // Constructor
    Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    // Method to add Department in company
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Method to add employee to department
    public void addEmployee(String departmentName, String employeeName) {
        for(Department department : departments) {
            if(departmentName.equals(department.getName())) {
                department.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department does not exist");
    }

    // Method to display departments and employees in company
    public void displayDepartments() {
        System.out.println("Company Name: " + name);
        for (Department department : departments) {
            department.displayEmployees();
        }
    }
}


// Main class -> to show Composition
public class CompanySystem {
    public static void main(String[] args) {
        // Create an object of company class
        Company company1 = new Company("ABC Company");

        // Add departments to company
        company1.addDepartment("IT");
        company1.addDepartment("HR");
        company1.addDepartment("Marketing");

        // Add employees to different departments
        company1.addEmployee("IT", "John");
        company1.addEmployee("IT", "Mary");

        company1.addEmployee("HR", "Peter");

        company1.addEmployee("Marketing", "Lisa");
        company1.addEmployee("Marketing", "Tom");
        company1.addEmployee("Marketing", "Jane");

        // Display company structure
        company1.displayDepartments();
    }
}
// Sample Output ->
//Company Name: ABC Company
//Department Name: IT
//Employee Name: John
//Employee Name: Mary
//
//Department Name: HR
//Employee Name: Peter
//
//Department Name: Marketing
//Employee Name: Lisa
//Employee Name: Tom
//Employee Name: Jane