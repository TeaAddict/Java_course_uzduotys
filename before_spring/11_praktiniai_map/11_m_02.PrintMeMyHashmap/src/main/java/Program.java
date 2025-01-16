
import java.util.HashMap;
import java.util.Map;

public class Program {

    private static HashMap<String,String> hm = new HashMap<>();

    public static void main(String[] args) {
        // Test your program here!
        hm.put("f.e", "for example");
        hm.put("etc.", "and so on");
        hm.put("i.e", "more precisely");


        printKeys(hm);
        System.out.println("---");
        printKeysWhere(hm, "i");
        System.out.println("---");
        printValuesOfKeysWhere(hm, ".e");
    }


    public static void printKeys(HashMap<String,String> hashmap){
        for (Map.Entry<String,String> keyVal : hashmap.entrySet()){
            System.out.println(keyVal.getKey());
        }
    }

    public static void printKeysWhere(HashMap<String,String> hashmap, String text){
        for (Map.Entry<String, String> keyVal : hashmap.entrySet()){
            if (keyVal.getValue().contains(text)){
                System.out.println(keyVal.getKey());
            }
        }
    }

    public static void printValuesOfKeysWhere(HashMap<String,String> hashmap, String text) {
        for (Map.Entry<String,String> keyVal : hashmap.entrySet()) {
            if (keyVal.getKey().contains(text)){
                System.out.println(keyVal.getValue());
            }
        }
    }

}
