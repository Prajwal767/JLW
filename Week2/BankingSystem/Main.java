import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        BankingService service =
                new BankingService();

        while (true) {

            System.out.println(
                    "\n===== JDBC Banking System =====");

            System.out.println(
                    "1. Add Customer");

            System.out.println(
                    "2. View Customers");

            System.out.println(
                    "3. Update Balance");

            System.out.println(
                    "4. Delete Customer");

            System.out.println(
                    "5. Transfer Money");

            System.out.println(
                    "6. Exit");

            System.out.print(
                    "Enter Choice: ");

            int choice =
                    sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print(
                            "Customer Name: ");

                    String name =
                            sc.nextLine();

                    System.out.print(
                            "Balance: ");

                    double balance =
                            sc.nextDouble();

                    service.addCustomer(
                            new Customer(
                                    0,
                                    name,
                                    balance));

                    break;

                case 2:

                    service.displayCustomers();

                    break;

                case 3:

                    System.out.print(
                            "Account ID: ");

                    int id =
                            sc.nextInt();

                    System.out.print(
                            "New Balance: ");

                    double newBalance =
                            sc.nextDouble();

                    service.updateBalance(
                            id,
                            newBalance);

                    break;

                case 4:

                    System.out.print(
                            "Account ID: ");

                    int deleteId =
                            sc.nextInt();

                    service.deleteCustomer(
                            deleteId);

                    break;

                case 5:

                    try {

                        System.out.print(
                                "From Account ID: ");

                        int fromId =
                                sc.nextInt();

                        System.out.print(
                                "To Account ID: ");

                        int toId =
                                sc.nextInt();

                        System.out.print(
                                "Amount: ");

                        double amount =
                                sc.nextDouble();

                        service.transferMoney(
                                fromId,
                                toId,
                                amount);

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                case 6:

                    System.out.println(
                            "Thank You");

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }
}