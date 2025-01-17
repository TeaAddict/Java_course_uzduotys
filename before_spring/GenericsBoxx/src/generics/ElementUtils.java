package generics;

import java.lang.reflect.Array;
import java.util.List;

public class ElementUtils {

    public static <T> T lastElement(List<T> elements) {
        return elements.getLast();
    }

    public static <T> T lastElementArr(T[] elements) {
        return elements[elements.length - 1];
    }
}
