import java.util.ArrayList;

// Book class -> independent entity
class Book {
    // Attributes
    private final String title;
    private final String author;

    // Constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
        System.out.println();
    }
}

// Library class (aggregating multiple books)
class Library {
    // Attributes
    private final String name;
    private final ArrayList<Book> books;

    // Constructor
    Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    // Method to add book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display books
    public void displayBooks() {
        System.out.println("Library Name: " + name);
        for (Book book : books) {
            book.displayBookDetails();
        }
    }
}

// Main class to demonstrate aggregation
public class LibrarySystem {
    public static void main(String[] args) {
        // Creating objects of book class (exist independently)
        Book book1 = new Book("Java", "James Gosling");
        Book book2 = new Book("C++", "Bjarne Stroustrup");
        Book book3 = new Book("Python", "Douglas Adams");

        // Creating libraries
        Library library1 = new Library("City Library");
        Library library2 = new Library("Town Library");

        // Adding books to libraries
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2); // Single book object can exist in multiple libraries
        library2.addBook(book3);

        // Display books in libraries
        library1.displayBooks();
        library2.displayBooks();
    }
}
// Sample Output ->
//Library Name: City Library
//Book Title: Java
//Book Author: James Gosling
//
//Book Title: C++
//Book Author: Bjarne Stroustrup
//
//Library Name: Town Library
//Book Title: C++
//Book Author: Bjarne Stroustrup
//
//Book Title: Python
//Book Author: Douglas Adams