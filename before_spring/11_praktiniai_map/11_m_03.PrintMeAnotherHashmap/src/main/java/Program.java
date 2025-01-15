
import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        // Test your program here!

    }

    public static void printValues(HashMap<String, Book> hashmap) {
        for (Book book : hashmap.values()) {
            System.out.println(book);
        }
    }

    public static void printValueIfNameContains(HashMap<String,Book> hashmap, String text){
        for (Map.Entry<String,Book> keyVal : hashmap.entrySet()){
            if (keyVal.getValue().getName().contains(text)){
                System.out.println(keyVal.getValue());
            }
        }
    }

}
