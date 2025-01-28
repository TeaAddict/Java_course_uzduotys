import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext()) {
      System.out.println("Yes or no?");
      String s1 = scanner.nextLine();

      if (s1.equalsIgnoreCase("no")) {
        break;
      }
    }
  }
}
