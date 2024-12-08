/**
 * The Employee class extends the Person class and represents an employee at the amusement park.
 * It contains employee-specific information such as employee ID and role.
 *
 * Author: hpan12
 */
public class Employee extends Person {
    private String employeeId;
    private String role;

    // Default constructor
    public Employee() {
    }

    public Employee(String name, int age, String gender, String employeeId, String role) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.role = role;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
