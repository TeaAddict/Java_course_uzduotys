
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give points [0-100]:");
        int givenGrade = Integer.parseInt(scan.nextLine());

         if (givenGrade < 0) System.out.println("Grade: " + "impossible!");
         else if (givenGrade < 50) System.out.println("Grade: " + "failed");
         else if (givenGrade < 60) System.out.println("Grade: " + "1");
         else if (givenGrade < 70) System.out.println("Grade: " + "2");
         else if (givenGrade < 80) System.out.println("Grade: " + "3");
         else if (givenGrade < 90) System.out.println("Grade: " + "4");
         else if (givenGrade < 101) System.out.println("Grade: " + "5");
         else System.out.println("Grade: " + "incredible!");
    }
}
