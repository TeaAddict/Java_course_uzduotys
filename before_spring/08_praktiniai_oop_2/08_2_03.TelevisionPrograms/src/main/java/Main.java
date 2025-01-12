import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement here your program that uses the TelevisionProgram class

        ArrayList<TelevisionProgram> programs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.println();

            if (name.isEmpty()) break;

            System.out.print("Duration: ");
            int duration = Integer.parseInt(scanner.nextLine());
            System.out.println();


            TelevisionProgram program = new TelevisionProgram(name, duration);
            programs.add(program);
        }

            System.out.print("\nProgram's maximum duration? ");
            int maxDuration = Integer.parseInt(scanner.nextLine());
            System.out.println();

        for (TelevisionProgram program : programs){
            if (program.getDuration() <= maxDuration){
                System.out.print(program.getName() + ", " +program.getDuration());
            }
        }
    }
}
