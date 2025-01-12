import java.util.ArrayList;

public class Package {
    private ArrayList<Gift> gifts = new ArrayList<>();

    public void addGift(Gift gift){
        gifts.add(gift);
    }

    public int totalWeight(){
        int weightSum = 0;
        for (Gift gift : gifts) {
            weightSum += gift.getWeight();
        }

        return weightSum;
    }
}
