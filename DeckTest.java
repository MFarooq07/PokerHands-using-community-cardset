package proj4;
public class DeckTest {
    public static void main (String [] args)
    {
        Testing t = new Testing();
        Card cardExp = new Card(2, 3);
        testDeck(t,0,5,47, cardExp, false);
        cardExp = new Card(10, 3);
        testDeck(t,8,8,44, cardExp,false);
        cardExp = new Card(14, 2);
        testDeck(t,51,49,3, cardExp, true);
        t.finishTests();
    }
    public static void testDeck(Testing t,int indexWanted, int dealtCards, int size, Card
            expOutput,boolean isEmpty){
        Deck aDeck = new Deck();
        aDeck.nextToDeal = dealtCards;
        t.assertEquals("Checking if the size is equal to the size expected after removing a number of cards",size, aDeck.getSize());
                t.assertEquals("Checking if the expectation of deck being empty is right or not",isEmpty,
                        aDeck.isEmpty());
        System.out.println("Expected Card: " + expOutput + "\nActual: "+
                aDeck.getCard(indexWanted)+"\n");
    }
}