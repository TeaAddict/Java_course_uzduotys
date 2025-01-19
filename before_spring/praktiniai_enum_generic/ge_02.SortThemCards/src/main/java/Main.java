

public class Main {

    public static void main(String[] args) {
        // test your code here

//        Card first = new Card(2, Suit.CLUB);
//        Card second = new Card(2, Suit.SPADE);
//        Card third2 = new Card(12, Suit.HEART);
//        Card third3 = new Card(14, Suit.DIAMOND);
//        Card third4 = new Card(2, Suit.CLUB);
//        Card third5 = new Card(2, Suit.SPADE);
//        Card third6 = new Card(12, Suit.HEART);
//        Card third7 = new Card(14, Suit.DIAMOND);

        Card first = new Card(3,Suit.CLUB);
        Card second = new Card(2,Suit.SPADE);

        System.out.println( first.compareTo(second));

//        System.out.println(first);
//        System.out.println(second);
//        System.out.println(third);
//
//        System.out.println(first.compareTo(second));

        Hand hand1 = new Hand();
        hand1.add(first);
        hand1.add(second);
//        hand1.add(third2);
//        hand1.add(third3);
//        hand1.add(third4);
//        hand1.add(third5);
//        hand1.add(third6);
//        hand1.add(third7);

        hand1.sort();
    }
}
