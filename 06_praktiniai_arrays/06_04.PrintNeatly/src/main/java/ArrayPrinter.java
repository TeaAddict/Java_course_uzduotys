import java.util.Arrays;

public class ArrayPrinter {

    public static void main(String[] args) {
        // You can test your method here
        int[] array = {5, 1, 3, 4, 2};
        printNeatly(array);
    }

    public static void printNeatly(int[] array) {
        // Write some code in here
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i + 1 == array.length) break;
            System.out.print(",");
        }
    }
}
