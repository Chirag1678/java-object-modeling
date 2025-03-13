import java.util.ArrayList;

// Product class -> Independent Entity
class Product {
    // Attributes
    private final String name;
    private final double price;

    // Constructor
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method to get name of product
    public String getName() {
        return name;
    }

    // Method to get price of product
    public double getPrice() {
        return price;
    }
}

// Order class -> Aggregation of Products
class Order {
    // Attributes
    private final int orderId;
    private final ArrayList<Product> products;
    private final CustomerDetails customer;

    // Constructor
    Order(int orderId, CustomerDetails customer) {
        this.orderId = orderId;
        this.customer = customer;
        products = new ArrayList<>();
    }

    // Method to add product to order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to display order details
    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Products: ");
        for (Product product : products) {
            System.out.println("Product Name: " + product.getName() + ", Price: " + product.getPrice());
        }
        System.out.println();
    }
}

// Customer class -> Association with Order
class CustomerDetails {
    // Attributes
    private final String name;
    private final ArrayList<Order> orders;

    // Constructor
    CustomerDetails(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    // Method to place order
    public void placeOrder(Order order) {
        orders.add(order);
    }

    // Method to get name of Customer
    public String getName() {
        return name;
    }
}

// Main class -> Demonstrating Communication in E-Commerce Platform
public class ECommerceSystem {
    public static void main(String[] args) {
        // Create objects of customer
        CustomerDetails customer1 = new CustomerDetails("John");
        CustomerDetails customer2 = new CustomerDetails("Mary");

        // Create objects of products
        Product product1 = new Product("Laptop", 10000);
        Product product2 = new Product("Smartphone", 5000);
        Product product3 = new Product("Tablet", 8000);

        // Create objects of Order and add products in it, and place order
        Order order1 = new Order(1, customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        customer1.placeOrder(order1);

        Order order2 = new Order(2, customer2);
        order2.addProduct(product3);
        customer2.placeOrder(order2);

        // Display order details
        order1.displayOrder();
        order2.displayOrder();
    }
}
// Sample Output ->
// Order ID: 1
// Customer Name: John
// Products: 
// Product Name: Laptop, Price: 10000.0
// Product Name: Smartphone, Price: 5000.0
//
// Order ID: 2
// Customer Name: Mary
// Products: 
// Product Name: Tablet, Price: 8000.0