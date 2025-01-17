import java.util.Comparator;

public class SortBySuit implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getSuit().ordinal() - o2.getSuit().ordinal();
    }
}
