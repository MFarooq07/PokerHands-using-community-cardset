package proj4;
import java.util.ArrayList;
import java.util.List;
public class StudPokerHandTester {
    public static void main (String [] args)
    {
        Testing t = new Testing();
        testCompareToStudPoker(t);
        t.finishTests();
    }
    public static void testCompareToStudPoker(Testing t){
        Card[] cc1= {new Card("14", "Hearts"), new Card("14", "Spades") ,new Card("13", "Clubs"),new
                Card("9", "Hearts"),new Card("2", "Hearts")};
        Card[] h1= {new Card("14", "Hearts"), new Card("14", "Spades") };
        Card[] h2= {new Card("13", "Hearts"), new Card("13", "Spades") };
        Card[] h3= {new Card("13", "Hearts"), new Card("11", "Spades") };
        Card[] h4= {new Card("13", "Hearts"), new Card("12", "Spades") };
        Card[] cc2= {new Card("14", "Hearts"), new Card("14", "Spades") ,new Card("13", "Hearts"),new
                Card("9", "Hearts"),new Card("8", "Hearts")};
        Card[] h5= {new Card("13", "Clubs"), new Card("11", "Hearts") };
        Card[] h6= {new Card("14", "Clubs"), new Card("12", "Hearts") };
        Card[] h7= {new Card("6", "Hearts"), new Card("4", "Spades") };
        Card[] h8= {new Card("5", "Clubs"), new Card("3", "Spades") };
        Card[] cc3= {new Card("14", "Hearts"), new Card("12", "Spades") ,new Card("11", "Clubs"),new
                Card("9", "Hearts"),new Card("2", "Hearts")};
        Card[] h9= {new Card("6", "Hearts"), new Card("4", "Spades") };
        Card[] h10= {new Card("6", "Clubs"), new Card("3", "Spades") };
        Card[] h11= {new Card("14", "Clubs"), new Card("7", "Hearts") };
        Card[] h12= {new Card("11", "Clubs"), new Card("9", "Hearts") };
        Card[] h13= {new Card("8", "Hearts"), new Card("4", "Spades") };
        Card[] h14= {new Card("7", "Clubs"), new Card("3", "Spades") };
        Card[] h15= {new Card("13", "Spades"), new Card("3", "Spades") };
        Card[] h16= {new Card("13", "Clubs"), new Card("6", "Clubs") };
        Card[] cc4= {new Card("12", "Hearts"), new Card("11", "Spades") ,new Card("10", "Clubs"),new
                Card("9", "Hearts"),new Card("2", "Hearts")};
        Card[] h17= {new Card("13", "Clubs"), new Card("8", "Hearts") };
        Card[] h18= {new Card("14", "Clubs"), new Card("8", "Hearts") };
        Card[] h19= {new Card("13", "Clubs"), new Card("11", "Hearts") };
        Card[] h20= {new Card("14", "Clubs"), new Card("11", "Hearts") };
        Card[] h21= {new Card("7", "Hearts"), new Card("11", "Hearts") };
        Card[] h22= {new Card("12", "Hearts"), new Card("9", "Spades") };
        Card[] h23= {new Card("11", "Hearts"), new Card("10", "Spades") };
        Card[] cc5= {new Card("12", "Hearts"), new Card("12", "Spades") ,new Card("13", "Clubs"),new
                Card("13", "Hearts"),new Card("14", "Hearts")};
        Card[] h24= {new Card("11", "Hearts"), new Card("9", "Spades") };
        Card[] h25= {new Card("8", "Hearts"), new Card("5", "Spades") };
        ArrayList<Card> comCard = new ArrayList<>();
        ArrayList<Card> hands1 = new ArrayList<>();
        ArrayList<Card> hands2 = new ArrayList<>();
        comCard.addAll(List.of(cc1));
//
        hands1.addAll(List.of(h1));
        hands2.addAll(List.of(h2));
        CommunityCardSet comCardSet = new CommunityCardSet(comCard);
        StudPokerHand hand1 = new StudPokerHand(comCardSet, hands1);
        StudPokerHand hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("two pair hands; same on first pair but different on highcard of second pair",
                1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h3));
        hands2.addAll(List.of(h4));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("two pair hands; same on both pairs but different on highcard ",
                -1, hand1.compareTo(hand2));

///////////////////////////
        comCard = new ArrayList<>();
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        comCard.addAll(List.of(cc2));
        hands1.addAll(List.of(h5));
        hands2.addAll(List.of(h6));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("flush hands; same on first 2 high card hands but different on 3rd highcard",
                -1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h7));
        hands2.addAll(List.of(h8));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("two one-pair hands; same on pairs but different on the third highcard ",
                1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h16));
        hands2.addAll(List.of(h15));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("two pair a tie ",
                0, hand1.compareTo(hand2));
        //
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h19));
        hands2.addAll(List.of(h20));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("flushes a tie ",
                0, hand1.compareTo(hand2));
/////////////////////
        comCard = new ArrayList<>();
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        comCard.addAll(List.of(cc3));
        hands1.addAll(List.of(h9));
        hands2.addAll(List.of(h10));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("high card hands a tie",0, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h11));
        hands2.addAll(List.of(h12));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("one hand a pair of aces and the other have pair of Jacks and nine ",
                -1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h7));
        hands2.addAll(List.of(h10));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("tie of a pair hands ",
                0, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h13));
        hands2.addAll(List.of(h14));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("high cards different on the last card ",
                1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h14));
        hands2.addAll(List.of(h21));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("a flush vs a high card ",
                -1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h12));
        hands2.addAll(List.of(h21));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("a flush vs a two-pair ",
                -1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h11));
        hands2.addAll(List.of(h21));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("a flush vs a one-pair ",
                -1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h11));
        hands2.addAll(List.of(h14));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("a highcard vs a one-pair ",
                1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h11));
        hands2.addAll(List.of(h12));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("a two-pair vs a one-pair ",
                -1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h14));
        hands2.addAll(List.of(h12));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("a two-pair vs a high-card ",
                -1, hand1.compareTo(hand2));
///////////////////////////
        comCard = new ArrayList<>();
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        comCard.addAll(List.of(cc4));
        hands1.addAll(List.of(h17));
        hands2.addAll(List.of(h18));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("different first high cards",
                -1, hand1.compareTo(hand2));
//
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        hands1.addAll(List.of(h22));
        hands2.addAll(List.of(h23));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("two pair hands; one has higher first pair but lower rank second pair than other" , 1, hand1.compareTo(hand2));
///////////////////////////
        comCard = new ArrayList<>();
        hands1 = new ArrayList<>();
        hands2 = new ArrayList<>();
        comCard.addAll(List.of(cc5));
        hands1.addAll(List.of(h24));
        hands2.addAll(List.of(h25));
        comCardSet = new CommunityCardSet(comCard);
        hand1 = new StudPokerHand(comCardSet, hands1);
        hand2 = new StudPokerHand(comCardSet, hands2);
        t.assertEquals("best hand turns out to be a community card hand",
                0, hand1.compareTo(hand2));
    }
}

