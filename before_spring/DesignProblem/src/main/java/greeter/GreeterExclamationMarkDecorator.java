package greeter;

public class GreeterExclamationMarkDecorator implements Greeter{
    private Greeter original;

    public GreeterExclamationMarkDecorator(Greeter original) {
        this.original = original;
    }

    @Override
    public String greet(String firstName, String lastName) {
        return original.greet(firstName, lastName) + "!";
    }
}
