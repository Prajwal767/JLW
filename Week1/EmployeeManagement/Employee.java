public class Employee {

    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    public Employee(int employeeId, String name,
                    String department, double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Name: %s | Department: %s | Salary: %.2f",
                employeeId,
                name,
                department,
                salary
        );
    }
}