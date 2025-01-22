package SecondStrategy;

public class LithuanianGreetingStrategy implements GreeterLanguageStrategy {

    @Override
    public String getGreetingString() {
        return "Sveiki!";
    }
}
