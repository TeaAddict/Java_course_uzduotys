
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Archive> archives = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Indentifier? (empty will stop)");
            String identifier = scanner.nextLine();
            if (identifier.isEmpty()) break;

            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();
            if (name.isEmpty()) break;

            Archive newItem = new Archive(identifier, name);

            if (!archives.contains(newItem)) archives.add(newItem);
        }

        System.out.println("==Items==");
        for (Archive item : archives) {
            System.out.println(item);
        }
    }
}
