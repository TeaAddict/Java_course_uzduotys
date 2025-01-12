import java.util.ArrayList;

public class Suitcase {

    private int maximumWeight = 0;

    private ArrayList<Item> items = new ArrayList<>();

    public Suitcase(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public void addItem(Item item){
        int totalWeight = 0;

        for (Item el: items) {
            totalWeight += el.getWeight();
        }

        if (totalWeight + item.getWeight() <= maximumWeight) {
            items.add(item);
        }

    }

    public void printItems(){
        for (Item item : items) {
            System.out.println(item.getName() + " (" + item.getWeight() + " kg\n)");
        }
    }

    public Item heaviestItem(){
        int heaviestID = 0;

        if (items.isEmpty()) return null;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() > items.get(heaviestID).getWeight()){
                heaviestID = i;
            }
        }

        return items.get(heaviestID);
    }

    // Not sure if I can add my own methods?
    public int totalWeight(){
        int totalWeight = 0;

        for (Item item: items) {
                totalWeight += item.getWeight();
        }

        return totalWeight;
    }

    public String toString(){
        int currentWeight = 0;
        for (Item item : items){
            currentWeight += item.getWeight();
        }

        if (items.isEmpty()) return "no items (0 kg)";

        if (items.size() == 1) {
            return items.size() + " item (" + currentWeight + " kg)";
        }

        return items.size() + " items (" + currentWeight + " kg)";
    }
}
