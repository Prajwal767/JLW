import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Library {

    private ArrayList<Book> books;
    private HashMap<Integer, User> users;

    public Library() {
        books = new ArrayList<>();
        users = new HashMap<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Add User
    public void addUser(User user) {
        users.put(user.getUserId(), user);
        System.out.println("User added successfully.");
    }

    // Display Books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        books.forEach(System.out::println);
    }

    // Display Users 
    public void displayUsers() {

        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }

        users.values().forEach(System.out::println);
    }

    // Search Book using Stream API
    public void searchBook(String title) {

        Optional<Book> book = books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst();

        if (book.isPresent()) {
            System.out.println(book.get());
        } else {
            System.out.println("Book not found.");
        }
    }

    // Display Available Books using Stream API
    public void displayAvailableBooks() {

        books.stream()
                .filter(book -> !book.isIssued())
                .forEach(System.out::println);
    }

    // Issue Book
    public void issueBook(int bookId) throws LibraryException {

        Book book = books.stream()
                .filter(b -> b.getBookId() == bookId)
                .findFirst()
                .orElse(null);

        if (book == null) {
            throw new LibraryException("Book not found.");
        }

        if (book.isIssued()) {
            throw new LibraryException("Book already issued.");
        }

        book.setIssued(true);

        System.out.println("Book issued successfully.");
    }

    // Return Book
    public void returnBook(int bookId) throws LibraryException {

        Book book = books.stream()
                .filter(b -> b.getBookId() == bookId)
                .findFirst()
                .orElse(null);

        if (book == null) {
            throw new LibraryException("Book not found.");
        }

        if (!book.isIssued()) {
            throw new LibraryException("Book was not issued.");
        }

        book.setIssued(false);

        System.out.println("Book returned successfully.");
    }
}