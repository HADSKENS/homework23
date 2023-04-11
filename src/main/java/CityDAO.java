import java.util.List;

public interface CityDAO {
    void addCity(City city);
    void removeCity(City city);
    void updateCity(City city);
    City getCityId(City city);
    List<City> getAllCity();
}
