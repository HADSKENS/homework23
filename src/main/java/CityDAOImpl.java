import javax.persistence.*;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    private final String user = "postgres";
    private final String password = "7852";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";
    EntityManager entityManager;

    public CityDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addCity(City city) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeCity(City city) {
        entityManager.getTransaction().begin();
        City a = entityManager.find(City.class,city.getCity_id());
        entityManager.remove(a);
    }

    @Override
    public void updateCity(City city) {
        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public City getCityId(City city) {
        return entityManager.find(City.class,city.getCity_id());
    }

    @Override
    public List<City> getAllCity() {
        TypedQuery<City> a = entityManager.createQuery("from City", City.class);
        return a.getResultList();

    }
}
