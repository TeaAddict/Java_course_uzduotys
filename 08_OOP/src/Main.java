public class Main {
    public static void main(String[] args) {

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.0);

        Employee employee1 = new Employee(1, "Petras", "Petrauskas", 999);


        Account account1 = new Account("11", "Petras");
        Account account2 = new Account("11", "Petras", 500);


        System.out.println(account1);
        System.out.println(account2);

        account1.transferTo(account2, 10);
        account2.transferTo(account1, 10);

        System.out.println(account2.getBalance());
        System.out.println(account1.getBalance());
    }
}
