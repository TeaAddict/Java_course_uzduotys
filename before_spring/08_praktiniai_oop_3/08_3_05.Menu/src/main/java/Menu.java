
import java.util.ArrayList;
import java.util.Objects;

public class Menu {

    private ArrayList<String> meals;

    public Menu() {
        this.meals = new ArrayList<>();
    }

    // implement the required methods here
    public void addMeal(String meal){
        if (!meals.contains(meal)) meals.add(meal);
    }

    public void printMeals(){
        for (String meal : meals){
            System.out.println(meal);
        }
    }

    public void clearMenu(){
        meals.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(meals, menu.meals);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(meals);
    }
}
