package philate;

import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PostStamp;

import java.util.ArrayList;
import java.util.List;

public class MyPhilatelist implements Philatelist {
    ArrayList<PostStamp> postStamps = new ArrayList<>();

    @Override
    public void addToCollection(PostStamp postStamp) {

        if (postStamp == null || postStamp.getName() == null || postStamp.getName().isEmpty() ) {
            throw new IllegalArgumentException();
        }
        postStamps.add(postStamp);
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        return postStamps.size();
    }

    @Override
    public void printAllPostStampNames() {
        for (PostStamp postStamp : postStamps) {
            System.out.println(postStamp.getName());
        }
    }

    @Override
    public void printPostStampsWithPriceGreaterThan(double v) {
        for (PostStamp postStamp : postStamps) {
            if (postStamp.getMarketPrice() > v) {
                System.out.println(postStamp.getName());
            }
        }
    }

    @Override
    public boolean isPostStampInCollection(PostStamp postStamp) {

            return postStamps.contains(postStamp);

    }

    @Override
    public boolean isPostStampWithNameInCollection(String s) {
        for (PostStamp postStamp : postStamps) {
            if (postStamp.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculateTotalMarketPrice() {
        double totalMarketPrice = 0;
        for (PostStamp postStamp : postStamps) {
            totalMarketPrice += postStamp.getMarketPrice();
        }
        return totalMarketPrice;
    }

    @Override
    public double getAveragePostStampPrice() {
        double postStampPrice = 0;
        for (PostStamp postStamp : postStamps) {
            postStampPrice += postStamp.getMarketPrice();
        }
        return postStampPrice / postStamps.size();
    }

    @Override
    public PostStamp getTheMostExpensivePostStampByMarketValue() {
        double highestValue = 0;
        PostStamp mostExpensivePostStamp = new PostStamp("empty", 0, 0);

        for (PostStamp postStamp : postStamps) {
            double currentMarketPrice = postStamp.getMarketPrice();
            if (currentMarketPrice > highestValue) {
                highestValue = currentMarketPrice;
                mostExpensivePostStamp = postStamp;
            }
        }
        return mostExpensivePostStamp;
    }

    @Override
    public List<PostStamp> findPostStampsByNameContaining(String s) {
        List<PostStamp> postStampsList = new ArrayList<PostStamp>();
        for (PostStamp postStamp : postStamps) {
            if (postStamp.getName().contains(s)) {
                postStampsList.add(postStamp);
            }
        }
        return postStampsList;
    }

    @Override
    public List<PostStamp> getSortedPostStampsByName() {
        postStamps.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return postStamps;
    }
}
