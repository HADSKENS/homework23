public class Application {
    public static void main(String[] args) {
        EmployeeDaoImpl a = new EmployeeDaoImpl();
        Employee b = new Employee(1L,"2","1","муж",12);
        a.getAllEmployee();
        a.getUserId(1L);
        a.deleteUserId(b);
        a.updateUserId(b);
        a.delEntityManager();
    }
}

