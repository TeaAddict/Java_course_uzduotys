
public class StarSign {

    public static void main(String[] args) {


        //The tests are not checking the main, so you can modify it freely.
        //NB: If the tests don't seem to pass, you should try the methods here
        //in the main to make sure they print the correct shapes!

        printStars(3);
        System.out.println("\n---");  // printing --- between the shapes
        printSquare(4);
        System.out.println("\n---");
        printRectangle(5, 6);
        System.out.println("\n---");
        printTriangle(3);
        System.out.println("\n---");
    }

    public static void printStars(int number) {
        // first part of the exercise
        for (int i = 0; i < number; i++) {
            System.out.printf("*");
        }
        System.out.println();
    }

    public static void printSquare(int size) {
        // second part of the exercise
        for (int row = 0; row < size; row++) {
            System.out.println();
            for (int col = 0; col < size; col++) {
                System.out.printf("*");
            }
        }
    }

    public static void printRectangle(int width, int height) {
        // third part of the exercise
        for (int row = 0; row < height; row++) {
            System.out.println();
            for (int col = 0; col < width; col++) {
                System.out.printf("*");
            }
        }
    }

    public static void printTriangle(int size) {
        // fourth part of the exercise
        for (int row = 0; row < size; row++) {
            System.out.println();
            for (int col = 0; col < row + 1; col++) {
                System.out.printf("*");
            }
        }
    }
}
