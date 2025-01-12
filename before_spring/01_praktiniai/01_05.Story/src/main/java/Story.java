
import java.util.Scanner;

public class Story {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("I will tell you a story, but I need some information first.");
        System.out.println("What is the main character called?");

        String res1 = scanner.nextLine();

        System.out.println("What is their job?");

        String res2 = scanner.nextLine();


        System.out.println("Here is the story:\n" +
                "Once upon a time there was " + res1  + ", who was " + res2 + ".\n" +
                "On the way to work, " + res1 + " reflected on life.\n" +
                "Perhaps " + res1 + " will not be " + res2 +" forever.");

    }
}
