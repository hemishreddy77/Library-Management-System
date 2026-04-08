public class Book {
    private String title;
    private boolean isBorrowed;

    // Constructor
    public Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }

    // Mark as borrowed
    public void borrowBook() {
        isBorrowed = true;
    }

    // Mark as returned
    public void returnBook() {
        isBorrowed = false;
    }

    // Get title
    public String getTitle() {
        return title;
    }

    // Check borrowed status
    public boolean isBorrowed() {
        return isBorrowed;
    }
}