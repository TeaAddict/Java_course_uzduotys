import SecondStrategy.EnglishGreetingStrategy;
import SecondStrategy.Greeter;
import SecondStrategy.LithuanianGreetingStrategy;

public class Main {
    public static void main(String[] args) {

//        Greeter first = new Greeter(new LithuanianGreetingStrategy());
        Greeter first = new Greeter(new EnglishGreetingStrategy());
        first.greet("Jonas", "Jonaitis");
    }
}
