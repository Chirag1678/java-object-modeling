import java.util.ArrayList;

//Bank class -> Association with customer
class Bank {
    // Attributes
    private final String name;
    private final ArrayList<Customer> customers;

    // Constructor
    Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Method to open a bank account
    public void openAccount(Customer customer, double amount) {
        customers.add(customer);
        customer.setBank(this);
        customer.deposit(amount);
        System.out.println("Account opened for " + customer.getName() + " in " + name +  " with initial balance of " + amount);
        System.out.println();
    }

    // Method to get bank name
    public String getName() {
        return name;
    }
}

// Customer class -> Associated with Bank
class Customer {
    // Attributes
    private final String name;
    private double balance;
    private Bank bank;

    // Constructor
    Customer(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    // Method to set bank
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " in " + name + "'s account");
        }
        else {
            System.out.println("Invalid amount");
        }
    }

    // Method to view balance
    public void viewBalance() {
        System.out.println(name + "'s balance at " + bank.getName() + " is: " + balance);
    }

    // Method to get user's name
    public String getName() {
        return name;
    }
}

// Main class to show association
public class BankSystem {
    public static void main(String[] args) {
        // Create an object of Bank class
        Bank bank1 = new Bank("HDFC Bank");

        // Create objects of customer class
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Mary");

        // Open accounts
        bank1.openAccount(customer1, 10000);
        bank1.openAccount(customer2, 20000);

        // View balance
        customer1.viewBalance();
        customer2.viewBalance();
    }
}
// Sample Output ->
// Deposited 10000.0 in John's account
// Account opened for John in HDFC Bank with initial balance of 10000.0
//
// Deposited 20000.0 in Mary's account
// Account opened for Mary in HDFC Bank with initial balance of 20000.0
//
// John's balance at HDFC Bank is: 10000.0
// Mary's balance at HDFC Bank is: 20000.0