
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfAList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // implement here a program, that first reads user input
        // adding them on a list until user gives -1.
        // Then it computes the average of the numbers on the list
        // and prints it.

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (true) {
            Integer input = Integer.parseInt(scanner.nextLine());

            if (input.equals(-1)) break;

            numbers.add(input);
        }

        int sum = 0;
        for (int num : numbers) sum += num;

        System.out.println("Average: " + (double) sum / numbers.size());

    }
}
