import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pipe <T> {
    Queue<T> items = new LinkedList<>();

    public void putIntoPipe(T value){
        items.add(value);
    }

    public T takeFromPipe(){
        if (items.isEmpty()){
            return null;
        }
        return items.poll();
    }

    public boolean isInPipe(){
        return !items.isEmpty();
    }

}
