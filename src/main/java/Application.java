import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.concurrent.Callable;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CityDAOImpl a = new CityDAOImpl(entityManager);
        EmployeeDaoImpl d = new EmployeeDaoImpl(entityManager);
        City b = new City("Dallas");
        b.setCity_id(4L);
        System.out.println(a.getAllCity());
        Employee c = new Employee("2","2","Жен",23,b);
        c.setId(17L);
        d.updateUserId(c);
        System.out.println(d.getAllEmployee());
        entityManagerFactory.close();
        entityManager.close();
    }
}

