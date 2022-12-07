package proj4;
import java.util.ArrayList;
import java.util.List;
public class CardTest {

    public static void main(String[] args) {
        Testing t = new Testing();
        testmakeACardAndGetSuitGetRankInt(t, 1, 0, "1 of Spades", "Spades");
        testmakeACardAndGetSuitGetRankInt(t,1, 0, "1 of Spades", "Spades");
        testmakeACardAndGetSuitGetRankInt(t, 12, 3, "Queen of Diamonds", "Diamonds");
        testmakeACardAndGetSuitGetRankInt(t, 14, 2, "Ace of Clubs", "Clubs");
        testmakeACardAndGetSuitGetRankInt(t, 14,1 , "Ace of Hearts", "Hearts");
        testmakeACardAndGetSuitGetRankStr(t,"Ace", "Hearts", "Ace of Hearts", 14);
        testmakeACardAndGetSuitGetRankStr(t,"ten", "Clubs", "10 of Clubs", 10);
        testmakeACardAndGetSuitGetRankStr(t,"5", "Spades", "5 of Spades", 5);
        testmakeACardAndGetSuitGetRankStr(t,"Two", "Diamonds", "2 of Diamonds", 2);
        t.finishTests();
    }
    /**
     * this method makes the card using int constructor and then test different public methods in it
     * @param t testing
     * @param rank rank of the card
     * @param suit suit of the card
     * @param expectedOutput display expectations
     * @param suitStr expected suit
     */
    public static void testmakeACardAndGetSuitGetRankInt(Testing t,int rank, int suit, String
            expectedOutput,String suitStr) {
        Card aCard = new Card(rank, suit);
        t.assertEquals("checking if expected rank is equal to the actual rank",rank,
                aCard.getRank());
        t.assertEquals("checking if expected suit is equal to the actual suit",suitStr,
                aCard.getSuit());
        t.assertEquals("checking if the output displayed by the toString method is the same",expectedOutput, aCard.toString());
    }
    /**
     * this method makes the card using int constructor and then test different public methods in it
     * @param t testing
     * @param rank rank of the card
     * @param suit suit of the card
     * @param expectedOutput display expectations
     * @param rankInt expected rank
     */
    public static void testmakeACardAndGetSuitGetRankStr(Testing t,String rank, String suit, String
            expectedOutput,int rankInt) {
        Card aCard = new Card(rank, suit);
        t.assertEquals("checking if the expected rank is printed or not",rankInt, aCard.getRank() );
        t.assertEquals("checking if we get the expected suit when calling the getSuit method",suit,
                aCard.getSuit());
        t.assertEquals("testing if the display is according to what we desired it to be",expectedOutput, aCard.toString());
    }
}