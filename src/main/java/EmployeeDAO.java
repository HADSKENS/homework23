import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    Employee getUserId(Long id);

    void deleteUserId(Employee employee);

    void createUser(Employee employee);

    void updateUserId(Employee employee);
}
