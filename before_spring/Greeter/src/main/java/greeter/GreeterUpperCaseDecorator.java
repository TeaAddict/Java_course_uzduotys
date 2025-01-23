package greeter;

public class GreeterUpperCaseDecorator implements Greeter {
    private Greeter original;

    public GreeterUpperCaseDecorator(Greeter original){
        this.original = original;
    }

    public String greet(String firstName, String lastName){
        return original.greet(firstName, lastName).toUpperCase();
    }
}
