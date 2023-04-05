import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    void getUserId(int id);

    void deleteUserId(int id);

    void createUser(Employee employee);

    void updateUserId(int id);
}
