import java.util.ArrayList;

// Doctor class -> Association with Patient
class Doctor {
    // Attrbiutes
    private final String name;
    private ArrayList<Patient> patients;

    // Constructor
    Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    // Method to add a patient for consultation
    public void consult(Patient patient) {
        if(!patients.contains(patient)) {
            patients.add(patient);
            patient.doctorConsulted(this);
        }
        System.out.println(name + " is consulting patient " + patient.getName());
        System.out.println();
    }

    // Method to get doctor name
    public String getName() {
        return name;
    }
}

// Patient class -> Associated with Doctor
class Patient {
    // Attributes
    private final String name;
    private ArrayList<Doctor> doctors;

    // Constructor
    Patient(String name) {
        this.name = name;
        doctors = new ArrayList<>();
    }

    // method to add Consulted doctor in patient history
    public void doctorConsulted(Doctor doctor) {
        if(!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    // Method to get Patient name
    public String getName() {
        return name;
    }
}

// Hospital class -> Manages doctor and patient
class Hospital {
    // Attributes
    private final String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    // Constructor
    Hospital(String name) {
        this.name = name;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    // Method to add doctor to hospital
    public void addDoctor(Doctor doctor) {
        if(!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    // Method to add patient to hospital
    public void addPatient(Patient patient) {
        if(!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    // Method to display hospital details
    public void displayDetails() {
        System.out.println("Hospital Name: " + name);
        System.out.println("Doctors: ");
        for (Doctor doctor : doctors) {
            System.out.println("Doctor Name: " + doctor.getName());
        }
        System.out.println();
        System.out.println("Patients: ");
        for (Patient patient : patients) {
            System.out.println("Patient Name: " + patient.getName());
        }
    }
}

// Main class -> Demonstrating Association and Communication
public class HospitalSystem {
    public static void main(String[] args) {
        // Create an Object of hospital
        Hospital hospital = new Hospital("ABC Hospital");

        // Create objects of doctor
        Doctor doctor1 = new Doctor("Dr. John");
        Doctor doctor2 = new Doctor("Dr. Mary");

        // Create objects of patient
        Patient patient1 = new Patient("Ryan");
        Patient patient2 = new Patient("Smith");

        // Add doctors and patients to hospital
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Consult patients with doctors
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient2);

        // Display details
        hospital.displayDetails();
    }
}
// Sample Output ->
// Dr. John is consulting patient Ryan
//
// Dr. John is consulting patient Smith
//
// Dr. Mary is consulting patient Smith
//
// Hospital Name: ABC Hospital
// Doctors: 
// Doctor Name: Dr. John
// Doctor Name: Dr. Mary
//
// Patients: 
// Patient Name: Ryan
// Patient Name: Smith