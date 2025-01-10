
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }


    public String toString(){

        if (elements.size() > 1)
        {
            StringBuilder result = new StringBuilder();
            for (String el : elements){
                result.append(el).append("\n");
            }
            return "The collection " + name + " has " + elements.size() + " elements:\n" + result;
        }
        if (elements.size() == 1)
        {
            return "The collection " + name + " has " + elements.size() + " element:\n" + elements.get(0);
        } else {
            return "The collection " + name + " is empty.";
        }
    }
}
