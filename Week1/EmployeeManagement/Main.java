import java.util.Scanner;

public class Main {

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    EmployeeManager manager =
            new EmployeeManager();

    while (true) {

        System.out.println(
                "\n===== Employee Management System =====");

        System.out.println(
                "1. Add Employee");
        System.out.println(
                "2. Remove Employee");
        System.out.println(
                "3. Search Employee");
        System.out.println(
                "4. Display Employees");
        System.out.println(
                "5. Display Employees By Department");
        System.out.println(
                "6. Sort Employees By Salary");
        System.out.println(
                "7. Exit");

        System.out.print(
                "Enter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:

                System.out.print(
                        "Employee ID: ");
                int id = scanner.nextInt();

                scanner.nextLine();

                System.out.print(
                        "Name: ");
                String name =
                        scanner.nextLine();

                System.out.print(
                        "Department: ");
                String department =
                        scanner.nextLine();

                System.out.print(
                        "Salary: ");
                double salary =
                        scanner.nextDouble();

                try {

                    manager.addEmployee(
                            new Employee(
                                    id,
                                    name,
                                    department,
                                    salary
                            )
                    );

                } catch (
                        EmployeeException e) {

                    System.out.println(
                            e.getMessage()
                    );
                }

                break;

            case 2:

                System.out.print(
                        "Employee ID: ");

                int removeId =
                        scanner.nextInt();

                try {

                    manager.removeEmployee(
                            removeId
                    );

                } catch (
                        EmployeeException e) {

                    System.out.println(
                            e.getMessage()
                    );
                }

                break;

            case 3:

                System.out.print(
                        "Employee ID: ");

                int searchId =
                        scanner.nextInt();

                manager.searchEmployee(
                        searchId
                );

                break;

            case 4:

                manager.displayEmployees();
                break;

            case 5:

                scanner.nextLine();

                System.out.print(
                        "Enter Department: ");

                String departmentName =
                        scanner.nextLine();

                manager.displayEmployeesByDepartment(
                        departmentName
                );

                break;

            case 6:

                manager.sortEmployeesBySalary();
                break;

            case 7:

                System.out.println(
                        "Thank you!"
                );

                System.exit(0);

            default:

                System.out.println(
                        "Invalid choice.");
        }
    }
}

}
