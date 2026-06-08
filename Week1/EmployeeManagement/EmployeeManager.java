import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class EmployeeManager {

private ArrayList<Employee> employees;

public EmployeeManager() {
    employees = new ArrayList<>();
}

public void addEmployee(Employee employee)
        throws EmployeeException {

    boolean exists = employees.stream()
            .anyMatch(e ->
                    e.getEmployeeId() ==
                            employee.getEmployeeId());

    if (exists) {
        throw new EmployeeException(
                "Employee ID already exists."
        );
    }

    employees.add(employee);

    System.out.println(
            "Employee added successfully."
    );
}

public void removeEmployee(int employeeId)
        throws EmployeeException {

    Employee employee = employees.stream()
            .filter(e ->
                    e.getEmployeeId() ==
                            employeeId)
            .findFirst()
            .orElse(null);

    if (employee == null) {
        throw new EmployeeException(
                "Employee not found."
        );
    }

    employees.remove(employee);

    System.out.println(
            "Employee removed successfully."
    );
}

public void searchEmployee(int employeeId) {

    Optional<Employee> employee =
            employees.stream()
                    .filter(e ->
                            e.getEmployeeId()
                                    == employeeId)
                    .findFirst();

    if (employee.isPresent()) {
        System.out.println(employee.get());
    } else {
        System.out.println(
                "Employee not found."
        );
    }
}

public void displayEmployees() {

    if (employees.isEmpty()) {

        System.out.println(
                "No employees available."
        );

        return;
    }

    employees.forEach(System.out::println);
}

public void displayEmployeesByDepartment(String department) {

    employees.stream()
            .filter(e ->
                    e.getDepartment()
                            .equalsIgnoreCase(department))
            .forEach(System.out::println);
}

public void sortEmployeesBySalary() {

    employees.stream()
            .sorted(
                    Comparator.comparingDouble(
                            Employee::getSalary
                    )
            )
            .forEach(System.out::println);
}


}
