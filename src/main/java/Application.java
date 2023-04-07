public class Application {
    public static void main(String[] args) {
        EmployeeDaoImpl a = new EmployeeDaoImpl();
        Employee update = new Employee();
        Employee delete = new Employee();
        Employee create = new Employee();
        update.setId(1L);
        update.setFirst_name("2");
        update.setLast_name("2");
        update.setGender("муж");
        update.setAge(23);
        System.out.println(a.getAllEmployee());
        a.updateUserId(update);
        delete.setId(1L);
        a.deleteUserId(delete);
        System.out.println(a.getAllEmployee());
        create.setFirst_name("У");
        create.setLast_name("У");
        create.setGender("муж");
        create.setAge(23);
        a.createUser(create);
    }
}

