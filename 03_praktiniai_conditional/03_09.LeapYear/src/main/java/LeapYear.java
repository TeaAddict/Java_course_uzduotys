
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give a year:");
        int givenYear = Integer.parseInt(scan.nextLine());


        if (givenYear % 100 == 0 && givenYear % 400 != 0) {
            System.out.println("The year is not a leap year.");
            return;
        } else if (givenYear % 4 == 0) {
            System.out.println("The year is a leap year.");
            return;
        } else System.out.println("The year is not a leap year.");
    }
}
