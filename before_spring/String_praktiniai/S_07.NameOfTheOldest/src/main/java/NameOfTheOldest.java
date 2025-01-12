
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int highestAge = 0;
        String nameOfOldest = "";

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) break;

            String[] words = input.split(",");

            int newAge = Integer.parseInt(words[1]);
            String newName = words[0];

            if (highestAge < newAge) {
                highestAge = newAge;
                nameOfOldest = newName;
            }
        }

        System.out.println("Name of the oldest: " + nameOfOldest);
    }
}
