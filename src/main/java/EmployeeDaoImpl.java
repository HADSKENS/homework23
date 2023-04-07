import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "7852";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> results = new ArrayList<>();
        entityManager.getTransaction().begin();
        TypedQuery<Employee> a = entityManager.createQuery("SELECT s FROM Employee s" ,Employee.class);
        results=a.getResultList();
        for (Employee employee:results){
            System.out.println("Student ID: " + employee.getId());
            System.out.println("Student Name: " + employee.getFirst_name() +" "+ employee.getLast_name());
            System.out.println("Gender:"+employee.getGender());
            System.out.println("Student Age: " + employee.getAge());
            System.out.println("------------");
        }
        entityManager.getTransaction().commit();
        return null;
    }

    @Override
    public void getUserId(Long idUser) {
        List<Employee> results = new ArrayList<>();
        entityManager.getTransaction().begin();
        TypedQuery<Employee> a = entityManager.createQuery("SELECT s FROM Employee s WHERE s.id=:id1",Employee.class);
        a.setParameter("id1",idUser);
        results=a.getResultList();
        for (Employee employee:results){
            System.out.println("Student ID: " + employee.getId());
            System.out.println("Student Name: " + employee.getFirst_name() +" "+ employee.getLast_name());
            System.out.println("Gender:"+employee.getGender());
            System.out.println("Student Age: " + employee.getAge());
            System.out.println("------------");
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUserId(Employee employee) {
        entityManager.getTransaction().begin();
        Query a = entityManager.createQuery("DELETE Employee WHERE id =:idUser");
        a.setParameter("idUser",employee.getId());
        entityManager.getTransaction().commit();
    }

    @Override
    public void createUser(Employee employee) {
        entityManager.getTransaction().begin();
        Query a = entityManager.createQuery("INSERT INTO Employee(first_name,last_name,gender,age) VALUES (:first,:last,:gender,age)");
        a.setParameter("first",employee.getFirst_name());
        a.setParameter("last",employee.getLast_name());
        a.setParameter("gender",employee.getGender());
        a.setParameter("age",employee.getAge());
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUserId(Employee employee) {
        entityManager.getTransaction().begin();
        Query a = entityManager.createQuery("UPDATE employee SET s.first_name=:name");
        a.setParameter("name",employee.getFirst_name());
        entityManager.getTransaction().commit();
    }

    public void delEntityManager() {
        entityManager.close();
        entityManager.close();
    }
}
