import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<Book>();
        // implement here the program that allows the user to enter 
        // book information and to examine them
        while (true){
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.println();

            if (title.isEmpty()) break;

            System.out.print("Pages: ");
            int pages = Integer.parseInt(scanner.nextLine());
            System.out.println();

            System.out.print("Publication year: ");
            int publicationYear = Integer.parseInt(scanner.nextLine());
            System.out.println();

            Book book = new Book(title, pages, publicationYear);
            books.add(book);
        }

        System.out.print("\nWhat information will be printed? ");
        String printScope = scanner.nextLine();
        System.out.println();

        for (Book book : books){
            if (printScope.equals("everything")){
                System.out.print(book.getTitle() + ", " + book.getPages() + " pages, " + book.getPublicationYear());
            }

            if (printScope.equals("name")){
                System.out.print(book.getTitle());
            }
        }
    }
}
