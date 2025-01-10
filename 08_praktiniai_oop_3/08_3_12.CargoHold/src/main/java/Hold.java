import java.util.ArrayList;

public class Hold {

    private int maximumWeight;

    private ArrayList<Suitcase> suitcases = new ArrayList<>();

    public Hold(int maximumWeight){
        this.maximumWeight = maximumWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        int totalExistingWeight = 0;

        for (Suitcase existingSuitcase: suitcases) {
            totalExistingWeight += existingSuitcase.totalWeight();
        }

        if (totalExistingWeight + suitcase.totalWeight() <= maximumWeight) {
            suitcases.add(suitcase);
        }

    }

    public void printItems(){
        for (Suitcase suitcase: suitcases) {
            suitcase.printItems();
        }
    }

    public String toString(){
        if (suitcases.isEmpty()) return "no items (0 kg)";

        int totalWeight = 0;

        for (Suitcase suitcase: suitcases){
            totalWeight += suitcase.totalWeight();
        }

        return suitcases.size() + " suitcases (" + totalWeight + " kg)";
    }
}
