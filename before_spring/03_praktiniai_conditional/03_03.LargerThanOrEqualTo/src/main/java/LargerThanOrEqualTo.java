
import java.util.Scanner;

public class LargerThanOrEqualTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give the first number:");
        int firstNum = Integer.parseInt(scan.nextLine());

        System.out.println("Give the second number:");
        int secondNum = Integer.parseInt(scan.nextLine());

        if (firstNum == secondNum) {
            System.out.println("The numbers are equal!");
        } else System.out.println("Greater number is: " + Math.max(firstNum, secondNum));

    }
}
