import java.util.ArrayList;
import java.util.List;

public class Hideout <T> {
    List<T> items = new ArrayList<>();

    public void putIntoHideout(T toHide){
        if (!items.contains(toHide)){
            items.add(toHide);
        }
    }

    public T takeFromHideout(){
        if (!isInHideout()){
            return null;
        }
        T item =  items.get(items.size()-1);
        items.remove(items.size()-1);
        return item;
    }

    public boolean isInHideout(){
        return !items.isEmpty();
    }

}
