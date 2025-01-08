
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int highestAge = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) break;

            int newAge = Integer.parseInt(input.split(",")[1]);

            if (highestAge < newAge) highestAge = newAge;
        }

        System.out.println("Age of the oldest: " + highestAge);
    }
}
