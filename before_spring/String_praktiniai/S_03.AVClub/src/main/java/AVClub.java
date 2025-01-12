
import java.util.Scanner;

public class AVClub {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) break;

            String[] words = input.split(" ");

            for (String word : words) {
                if (word.contains("av")) System.out.println(word);
            }
        }
    }
}
