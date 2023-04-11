import javax.persistence.*;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "7852";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";
    private final EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployee() {
        TypedQuery<Employee> a = entityManager.createQuery("from Employee", Employee.class);
        return a.getResultList();

    }

    @Override
    public Employee getUserId(Long idUser) {
        return entityManager.find(Employee.class, idUser);
    }

    @Override
    public void deleteUserId(Employee employee) {
        Employee a = entityManager.find(Employee.class, employee.getId());
        entityManager.remove(a);
    }

    @Override
    public void createUser(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUserId(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
    }

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }
}
