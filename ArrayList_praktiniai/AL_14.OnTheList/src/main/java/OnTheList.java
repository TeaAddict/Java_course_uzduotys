
import java.util.ArrayList;
import java.util.Scanner;

public class OnTheList {

    public static void main(String[] args) {
        // Try your method here
        Scanner scan = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<String>();
        while (true) {
            String input = scan.nextLine();

            if (input.isEmpty()) break;

            names.add(input);
        }

        System.out.println("Search for? ");
        String findName = scan.nextLine();

        if (names.contains(findName)) System.out.println(findName + " was found!");
        else System.out.println(findName + " was not found!");

    }
}
