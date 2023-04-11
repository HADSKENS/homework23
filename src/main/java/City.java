import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity

@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id",updatable = false,nullable = false)
    private Long city_id;
    @Column(name = "city_name",nullable = false)
    private String city_name;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    List<Employee> employees;

    public City(String city_name) {
        this.city_name = city_name;
    }

    public City() {
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
