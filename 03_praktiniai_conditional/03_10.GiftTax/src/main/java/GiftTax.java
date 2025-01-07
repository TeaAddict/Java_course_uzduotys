
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Value of the gift?");
        int giftNum = Integer.parseInt(scan.nextLine());

        if (giftNum < 5000) {
            System.out.println("No tax!");
        } else if (giftNum <= 25000) {
            System.out.println("Tax: " + (100 + (giftNum - 5000) * 0.08));

        } else if (giftNum <= 55000) {
            System.out.println("Tax: " + (1700 + (giftNum - 25000) * 0.10));

        } else if (giftNum <= 200000) {
            System.out.println("Tax: " + (4700 + (giftNum - 55000) * 0.12));

        } else if (giftNum <= 1000000) {
            System.out.println("Tax: " + (22100 + (giftNum - 200000) * 0.15));

        } else {
            System.out.println("Tax: " + (142100 + (giftNum - 1000000) * 0.17));
        }

    }
}
