package greeter;

public class GreeterImpl implements Greeter {
    public String greet(String firstName, String lastName){
        return firstName + " " + lastName;
    }
}
