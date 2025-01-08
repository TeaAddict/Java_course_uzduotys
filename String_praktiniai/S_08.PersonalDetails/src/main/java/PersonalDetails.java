
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String longestName = "";
        int count = 0;
        int yearSum = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) break;

            String[] words = input.split(",");

            int newYear = Integer.parseInt(words[1]);
            String newName = words[0];

            if (newName.length() > longestName.length()) {
                longestName = newName;
            }
            yearSum += newYear;

            count++;
        }

        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + ((double) yearSum / count));
    }
}
