import generics.Box;
import generics.ElementUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        List<String> listOfStrings = List.of("one", "two");
        String lastString = ElementUtils.lastElement(listOfStrings);
        List<Integer> intList = List.of(1, 2, 3, 4);
        int lastInt = ElementUtils.lastElement(intList);

        System.out.println(lastString);
        System.out.println(lastInt);

        String[] wordList = {"vienas", "du", "trys"};
        String lastWord = ElementUtils.lastElementArr(wordList);
        System.out.println(lastWord);

        Box<String> twoNames = new Box<>("John", "Jane");
        twoNames.unlock();
        System.out.printf("twoNames=%s.%n", twoNames);
        String name1 = twoNames.getItem1();
        String name2 = twoNames.getItem2();

        Box<Integer> twoNums = new Box<>(11, 2);
        System.out.printf("twoNums=%s.%n", twoNums);
        Integer num1 = twoNums.getItem1();
        Integer num2 = twoNums.getItem2();

        System.out.println(twoNums.isLocked());

    }
}
