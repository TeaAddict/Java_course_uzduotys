import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getValue() - o2.getValue();
    }
}
