import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Display Users");
            System.out.println("5. Search Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    library.addBook(
                            new Book(bookId, title, author));

                    break;

                case 2:

                    System.out.print("User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("User Name: ");
                    String userName = sc.nextLine();

                    library.addUser(
                            new User(userId, userName));

                    break;

                case 3:

                    library.displayBooks();
                    break;

                case 4:

                    library.displayUsers();
                    break;

                case 5:

                    System.out.print("Enter title: ");
                    String searchTitle = sc.nextLine();

                    library.searchBook(searchTitle);
                    break;

                case 6:

                    try {

                        System.out.print("Enter Book ID: ");
                        int issueId = sc.nextInt();

                        library.issueBook(issueId);

                    } catch (LibraryException e) {

                        System.out.println(
                                "Error: " + e.getMessage());
                    }

                    break;

                case 7:

                    try {

                        System.out.print("Enter Book ID: ");
                        int returnId = sc.nextInt();

                        library.returnBook(returnId);

                    } catch (LibraryException e) {

                        System.out.println(
                                "Error: " + e.getMessage());
                    }

                    break;

                case 8:

                    System.out.println("Thank you!");
                    System.exit(0);

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}