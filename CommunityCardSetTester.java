package proj4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CommunityCardSetTester {
    public static void main(String[] args) {
        Testing t = new Testing();
        Card card = new Card( 5, 0);
        testCommunityCardSet(t,13,14,11,6,5,0,1,0,2,0, 4,card, 5);
        t = new Testing();
        card = new Card( 2, 1);
        testCommunityCardSet(t,12,2,9,4,5,0,1,2,2,0, 1,card, 5);
        t = new Testing();
        card = new Card( 4, 2);
        testCommunityCardSet(t,12,2,9,4,5,0,1,2,2,0, 3,card, 5);
        t.finishTests();
    }
    public static void testCommunityCardSet(Testing t,int rank1, int rank2, int rank3, int rank4, int
            rank5, int suit1,int suit2,int suit3,int suit4,int suit5,
                                            int wantedCard, Card expectedCard,int size){
        ArrayList<Card> cc = new ArrayList<>();
        Card aCard1 = new Card(rank1, suit1);
        Card aCard2 = new Card(rank2, suit2);
        Card aCard3 = new Card(rank3, suit3);
        Card aCard4 = new Card(rank4, suit4);
        Card aCard5 = new Card(rank5, suit5);
        final ArrayList<Card> cardList = new ArrayList<>
                (Arrays.asList(aCard1,aCard2,aCard3,aCard4,aCard5));
        cc.addAll(cardList);
        CommunityCardSet ccs= new CommunityCardSet(cc);
        System.out.println("Expected: " + expectedCard +"\nActual: "+ ccs.getIthCard(wantedCard)
                +"\n");
        t.assertEquals("checking if the expected size is equal to the size of community card set ",size, ccs.getSize());

    }
}