import java.util.ArrayList;

// Faculty class -> Independent Entity, Aggregation with University
class Faculty {
    // Attributes
    private final String name;

    // Constructor
    Faculty(String name) {
        this.name = name;
    }

    // Method to get Faculty name
    public String getName() {
        return name;
    }
}

// UniversityDepartment class -> Composition with University
class UniversityDepartment {
    // Attributes
    private final String name;

    // Constructor
    UniversityDepartment(String name) {
        this.name = name;
    }

    // Method to get Department name
    public String getName() {
        return name;
    }
}

// University class -> Composition with Department, Aggregation with Faculty
class University {
    // Attributes
    private final String name;
    private final ArrayList<UniversityDepartment> departments;
    private final ArrayList<Faculty> faculties;

    // Constructor
    University(String name) {
        this.name = name;
        departments = new ArrayList<>();
        faculties = new ArrayList<>();
    }

    // Method to add department to university
    public void addDepartment(String departmentName) {
        departments.add(new UniversityDepartment(departmentName));
    }

    // Method to add faculty to university
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Method to display university details
    public void displayDetails() {
        System.out.println("University Name: " + name);
        System.out.println("Departments: ");
        for (UniversityDepartment department : departments) {
            System.out.println("Department Name: " + department.getName());
        }
        System.out.println();
        System.out.println("Faculties: ");
        for (Faculty faculty : faculties) {
            System.out.println("Faculty Name: " + faculty.getName());
        }
        System.out.println();
    }

    // Method to close University
    public void close() {
        System.out.println("University " + name + " is closed");
        System.out.println();
        departments.clear(); // Departments are cleared with university
    }
}

// Main class ->Demonstrating Aggregation and Composition
public class UniversitySystem {
    public static void main(String[] args) {
        // Create an object of university
        University university = new University("ABC University");

        // Add departments to university
        university.addDepartment("Arts");
        university.addDepartment("Science");

        // Create objects of faculty
        Faculty faculty1 = new Faculty("Dr. Jane");
        Faculty faculty2 = new Faculty("Prof. Marry");

        // Add faculty to university
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        // Display University details
        university.displayDetails();

        // Close university
        university.close();

        // Now display university details
        university.displayDetails(); // Departments removed, but Faculty is still there
    }
}
// Sample Output ->
// University Name: ABC University
// Departments:
// Department Name: Arts
// Department Name: Science

// Faculties:
// Faculty Name: Dr. Jane
// Faculty Name: Prof. Marry

// University ABC University is closed

// University Name: ABC University
// Departments:

// Faculties:
// Faculty Name: Dr. Jane
// Faculty Name: Prof. Marry