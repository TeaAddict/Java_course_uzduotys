import greeter.GreeterExclamationMarkDecorator;
import greeter.Greeter;
import greeter.GreeterImpl;
import greeter.GreeterUpperCaseDecorator;

public class Main {
    public static void main(String[] args) {

        Greeter g1 = new GreeterExclamationMarkDecorator(new GreeterUpperCaseDecorator(new GreeterImpl()));

        System.out.println(g1.greet("Jonas", "Jonaitis"));
    }
}
