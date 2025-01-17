import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void print() {
        cards.forEach(card ->
                {
                    if (card.getValue() > 10) {
                        System.out.println(card.getSuit() + " " + HighCard.values()[(card.getValue() - 11)]);
                    } else {
                        System.out.println(card.getSuit() + " " + card.getValue());
                    }
                }
        );
    }

    public void sort() {
        cards.sort(Card::compareTo);
        print();
    }

    public void sortBySuit() {
        cards.sort((o1, o2) -> o1.getSuit().ordinal() - o2.getSuit().ordinal());
    }

    @Override
    public int compareTo(Hand otherHand) {
        int currentHandSum = cards.stream().mapToInt(Card::getValue).sum();
        int otherHandSum = otherHand.getCards().stream().mapToInt(Card::getValue).sum();
        return currentHandSum - otherHandSum;
    }
}
