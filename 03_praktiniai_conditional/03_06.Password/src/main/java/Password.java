
import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        String givenWord = scan.nextLine();

        if (givenWord.equals("Caput Draconis")) System.out.println("Welcome!");
        else System.out.println("Off with you!");

    }
}
