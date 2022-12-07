package proj4;
import java.util.ArrayList;
import java.util.List;
public class PokerHandTester {
    public static void main (String [] args)
    {
        Testing t = new Testing();
        testCompareTo(t,"2","3","4","12","12","Hearts","Spades","Clubs","Hearts","Hearts","2","3","5","11","1 1","Hearts","Spades","Clubs","Hearts","Hearts",1,"two 1-pair hands - different on pair (Queens vs. Jacks)");
        testCompareTo(t,"2","3","4","5","14","Hearts","Spades","Clubs","Hearts","Hearts","2","4","6","10","11 ","Hearts","Spades","Clubs","Spades","Spades",1," 1 pair (10s) vs. high card (Ace) ");
        testCompareTo(t,"2","3","4","7","7","Hearts","Spades","Clubs","Hearts","Hearts","2","4","4","7","7"," Hearts","Spades","Clubs","Spades","Spades",-1," 1 pair (7s) vs 2 pairs (7s and 4s)");
        testCompareTo(t,"2","3","4","7","7","Hearts","Spades","Clubs","Hearts","Hearts","2","4","6","10","11","Spades","Spades","Spades","Spades","Spades",-1,"1 pair (7s) vs. flush (Jack high) ");
        testCompareTo(t,"2","10","10","12","12","Hearts","Spades","Clubs","Hearts","Hearts","2","4","6","10", "14","Spades","Spades","Spades","Spades","Spades",-1,"2 pairs (Queens and 10s) vs. high card (Ace) ");
        testCompareTo(t,"2","10","10","7","7","Hearts","Spades","Clubs","Hearts","Spades","2","4","6","10","1 1","Spades","Spades","Spades","Spades","Spades",-1,"2 pairs (10s and 7s) vs. flush (Jack high) ");
        testCompareTo(t,"2","9","10","7","14","Hearts","Spades","Clubs","Hearts","Hearts","2","4","6","10","1 3","Spades","Spades","Spades","Spades","Spades",-1," flush (Ace high) vs. high card (Ace) ");
        testCompareTo(t,"2","3","7","7","7","Hearts","Clubs","Clubs","Hearts","Hearts","2","4","6","10","13", "Spades","Spades","Spades","Spades","Spades",-1,"3-of-a-kind (7s - counts as 1 pair) vs. flush (King high) ");

        testCompareTo(t,"2","3","14","14","14","Hearts","Clubs","Clubs","Spades","Hearts","2","6","6","10","10","Hearts","Spades","Clubs","Spades","Spades",-1," 3-of-a-kind (Aces - counts as 1 pair) vs. 2 pairs(10s and 6s) ");

        testCompareTo(t,"2","3","9","9","9","Hearts","Clubs","Clubs","Spades","Hearts","2","4","6","10","9"," Spades","Spades","Hearts","Spades","Spades",1," 3-of-a-kind (9s - counts as 1 pair) vs. high card (10)");
        testCompareTo(t,"14","14","13","13","13","Hearts","Clubs","Clubs","Spades","Hearts","2","4","6","10", "12","Spades","Spades","Spades","Spades","Spades",-1," full house (Kings over Aces - counts as 2 pairs) vs. flush (Queen high)");
        testCompareTo(t,"14","14","13","13","13","Hearts","Clubs","Clubs","Hearts","Hearts","2","3","4","5"," 14","Hearts","Spades","Clubs","Hearts","Hearts",1," full house (Kings over Aces - counts as 2 pairs) vs. 1 pair (7s)");
        testCompareTo(t,"14","14","13","13","13","Hearts","Clubs","Clubs","Hearts","Hearts","2","4","6","8"," 9","Spades","Spades","Hearts","Spades","Spades",1,"full house (Kings over Aces - counts as 2 pairs)vs. 1 pair (7s)");t.finishTests();
    }
    public static void testCompareTo(Testing t,String rank11, String rank12, String rank13, String
            rank14, String rank15, String suit11,String suit12,String suit13,String suit14,String suit15,String
                                             rank21, String rank22, String rank23, String rank24, String rank25, String suit21,String
                                             suit22,String suit23,String suit24,String suit25, int winner, String message)
    {
        Card[] hand1= {new Card(rank11, suit11), new Card(rank12, suit12) ,new Card(rank13,
                suit13),new Card(rank14, suit14),new Card(rank15, suit15)};
        Card[] hand2= {new Card(rank21, suit21), new Card(rank22, suit22) ,new Card(rank23,
                suit23),new Card(rank24, suit24),new Card(rank25, suit25)};
        ArrayList<Card> hands1 = new ArrayList<>();
        ArrayList<Card> hands2 = new ArrayList<>();
        hands1.addAll(List.of(hand1));
        hands2.addAll(List.of(hand2));
        PokerHand handsOfPlayer1 = new PokerHand(hands1);
        PokerHand handsOfPlayer2 = new PokerHand(hands2);
        t.assertEquals(message,winner, handsOfPlayer1.compareTo(handsOfPlayer2));
    }
}