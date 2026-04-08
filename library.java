import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library lib = new Library();
        lib.run();
    }

    public void run() {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            // Handle invalid input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Try again.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    displayAvailableBooks();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        books.add(new Book(title));
        System.out.println("Book added!");
    }

    private void borrowBook() {
        System.out.print("Enter title to borrow: ");
        String title = scanner.nextLine();

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (!b.isBorrowed()) {
                    b.borrowBook();
                    System.out.println("Book borrowed.");
                } else {
                    System.out.println("Book already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void returnBook() {
        System.out.print("Enter title to return: ");
        String title = scanner.nextLine();

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isBorrowed()) {
                    b.returnBook();
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");
        boolean found = false;

        for (Book b : books) {
            if (!b.isBorrowed()) {
                System.out.println("- " + b.getTitle());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books.");
        }
    }
}