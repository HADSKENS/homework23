public class Application {
    public static void main(String[] args) {
        EmployeeDaoImpl a = new EmployeeDaoImpl();
        a.deleteUserId(1);
        a.getAllEmployee();
        a.getUserId(1);
        a.updateUserId(1);
        a.createUser(new Employee("1", "1", "Муж", 23));
    }
}
