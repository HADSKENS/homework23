import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "7852";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee1")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idemployee = resultSet.getInt("id");
                System.out.println("ID работника: " + idemployee);

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");

                System.out.println("Имя: " + firstName);
                System.out.println("Фамилия: " + lastName);
                System.out.println("Пол: " + gender);
                System.out.println("Возраст:" + age);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void getUserId(int idNew) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee1")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idemployee = resultSet.getInt("id");
                if (idNew == idemployee) {
                    System.out.println("ID работника: " + idemployee);

                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String gender = resultSet.getString("gender");

                    System.out.println("Имя: " + firstName);
                    System.out.println("Фамилия: " + lastName);
                    System.out.println("Пол: " + gender);
                    System.out.println();
                    break;
                }
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserId(int idNew) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee1")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idemployee = resultSet.getInt("id");
                if (idNew == idemployee) {
                    PreparedStatement statement1 = connection.prepareStatement("DELETE employee1 WHERE id=idNew");
                    break;
                }
            }


            while (resultSet.next()) {
                int idemployee = resultSet.getInt("id");
                System.out.println("ID работника: " + idemployee);

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");

                System.out.println("Имя: " + firstName);
                System.out.println("Фамилия: " + lastName);
                System.out.println("Пол: " + gender);
                System.out.println("Возраст:" + age);
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUser(Employee employee) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO employee1 (first_name,last_name,gender,age) VALUES ")) {
            connection.prepareStatement(employee.toString());
            System.out.println(employee.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee1")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idemployee = resultSet.getInt("id");
                System.out.println("ID работника: " + idemployee);

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");

                System.out.println("Имя: " + firstName);
                System.out.println("Фамилия: " + lastName);
                System.out.println("Пол: " + gender);
                System.out.println("Возраст:" + age);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserId(int idNew) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee1")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idemployee = resultSet.getInt("id");
                if (idNew == idemployee) {
                    PreparedStatement statement1 = connection.prepareStatement("UPDATE employee1 WHERE id=idNew");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    public EmployeeDaoImpl() {

    }
}
